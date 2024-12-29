import java.awt.*;
import javax.swing.*;

public class Main {


	public static void main(String[] args) {
		
		Object3d obj = new Object3d(new Vector3(3,2,1));
		
		obj.addVertex(new Vector3(1,1,1));
		obj.addVertex(new Vector3(1,2,1));
		obj.addVertex(new Vector3(2,2,1));
		obj.addVertex(new Vector3(2,1,1));
		obj.addVertex(new Vector3(1,1,2));
		obj.addVertex(new Vector3(1,2,2));
		obj.addVertex(new Vector3(2,2,2));
		obj.addVertex(new Vector3(2,1,2));


		// 4v polygon
		obj.addPolygon(new int[]{0, 1, 2, 3});
		obj.addPolygon(new int[]{4, 5, 6, 7});

		obj.addPolygon(new int[]{0, 1, 5, 4});
		obj.addPolygon(new int[]{3, 2, 6, 7});

		obj.addPolygon(new int[]{0, 3, 7, 4});
		obj.addPolygon(new int[]{1, 2, 6, 5});
// 3v polygon
		/*obj.addPolygon(new int[]{0,1,2});
		obj.addPolygon(new int[]{0,2,3});

		obj.addPolygon(new int[]{4,5,6});
		obj.addPolygon(new int[]{4,6,7});


		obj.addPolygon(new int[]{0,1,5});
		obj.addPolygon(new int[]{0,4,5});
		
		obj.addPolygon(new int[]{3,2,6});
		obj.addPolygon(new int[]{3,6,7});

		obj.addPolygon(new int[]{0,3,7});
		obj.addPolygon(new int[]{0,4,7});

		obj.addPolygon(new int[]{1,2,6});
		obj.addPolygon(new int[]{1,5,6});
*/

		Camera c = new Camera();

		Scene scene = new Scene(c);
		scene.add(obj);

		JFrame jframe = new JFrame("3D engin");
		Render r = new Render(scene);
	
		jframe.add(r);
		jframe.setSize(300, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setVisible(true);

	}

}
