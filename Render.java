import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Render extends JPanel{

	private Scene scene;
	
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public Render() {}
	public Render(Scene scene) {
		this.scene = scene;
	}

	//zeichnet einen frame
	public void paintComponent(Graphics g) {
		System.out.println("## Next Frame");
		Graphics2D g2d = (Graphics2D) g;
	
		// geht objekte der scene durch
		for (int i = 0; i < scene.getObjectsLength(); i++) {
			Object3d obj = scene.getObject(i);
			
			List<Vector3> vertices = obj.getVertices();
			List<int[]> polygons = obj.getPolygons();

			// geht polygons des objects durch
			for (int j = 0; j < polygons.size(); j++) {
				
				//holt die verticis eines polygons
				Vector3[] polygon = new Vector3[polygons.get(j).length];
				for (int p = 0; p < polygon.length; p++) {
					int numPolygon = polygons.get(j)[p];
					polygon[p] = vertices.get(numPolygon);
					// add obj positon
					polygon[p].add(obj.getPosition());
				}
				// zeichnet polygon
				paintPolygon(g2d, polygon);
			}
		}
	}

	// zeichnet polygon
	public void paintPolygon(Graphics2D g2d, Vector3[] polygon3d) {
		//bildschirm mittelpunkt kordinaten
		int centerX = getWidth() / 2;
        	int centerY = getHeight() / 2;

		System.out.println(polygon3d);
		//wandelt 3d zu 3d um
		Vector2[] polygon2d = scene.getCamera().project(polygon3d);	

		//wandelt vectorliste in positions listen um
		int length = polygon2d.length;
		int[] xPoints = new int[length];
		int[] yPoints = new int[length];

		//x punkte 
		for (int i = 0; i < length; i++) {
			xPoints[i] = centerX + (int) polygon2d[i].getX();
			yPoints[i] = centerY + (int) polygon2d[i].getY();
			System.out.println("x "+xPoints[i]+ " y "+ yPoints[i]);
		}

		g2d.drawPolygon(xPoints, yPoints, length);
	}

	//berechnet und zeichnet nächsten tick
	public void nextTick() {
		
		System.out.println("nextTick");	
		// TODO: berechne nächsten standort	
		repaint();
	}
}
