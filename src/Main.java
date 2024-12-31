import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Main {


	public static void main(String[] args) {
	
		Cube cube = new Cube(new Vector3(0,0,0), Vector3.one(), new Vector3(1,1,1));
		ObjectOBJ obj = new ObjectOBJ("obj/car.obj", new Vector3(0,0,0), Vector3.one(), new Vector3(2,2,2));
		System.out.println(cube);

		Camera c = new Camera();

		Scene scene = new Scene(c);
		scene.add(obj);
		
		//create window
		JFrame jframe = new JFrame("3D engin");
		Render r = new Render(scene);
	
		jframe.add(r);
		jframe.setSize(300, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setVisible(true);

		while (true) {
			try {
			TimeUnit.SECONDS.sleep(2);
			r.nextTick();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
