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

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
	
		// geht objekte der scene durch
		for (int i = 0; i < scene.getObjectsLength(); i++) {
			Object3d obj = scene.getObject(i);
			
			List<Vector3> vertices = new ArrayList<Vector3>(obj.getVertices());

			// Berechnungen
			for (int v = 0; v < vertices.size(); v++) {
				
				// skalierung
				vertices.set(v, Vector3.scale(vertices.get(v), obj.getScale()));
				// rotation 
				// position
				vertices.get(v).add(obj.getPosition());
			}

			List<int[]> polygons = obj.getPolygons();

			// geht polygons des objects durch
			for (int j = 0; j < polygons.size(); j++) {
				
				//holt die verticis eines polygons
				Vector3[] polygon = new Vector3[polygons.get(j).length];
				for (int p = 0; p < polygon.length; p++) {
					int numPolygon = polygons.get(j)[p];
					polygon[p] = vertices.get(numPolygon);
					
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

		//wandelt 3d zu 3d um
		Vector2[] polygon2d = scene.getCamera().project(polygon3d);	

		//wandelt vectorliste in positions listen um
		int length = polygon2d.length;
		int[] xPoints = new int[length];
		int[] yPoints = new int[length];

		// punkte 
		for (int i = 0; i < length; i++) {
			xPoints[i] = centerX + (int) polygon2d[i].getX();
			yPoints[i] = centerY - (int) polygon2d[i].getY();
		}

		g2d.drawPolygon(xPoints, yPoints, length);
	}

	//berechnet und zeichnet nächsten tick
	public void nextTick(float timeDelta) {
	
		// Aufrufen der onUpdate methoden.
		for (int i = 0; i < scene.getObjectsLength(); i++) {
			scene.getObject(i).onUpdate(timeDelta);
		}

		//leinwand löschen
		removeAll();
		//leinwand neuzeichenen
		repaint();
	}
}
