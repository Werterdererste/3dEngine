import java.awt.*;
import javax.swing.*;
import java.lang.Thread;

public class Main {


	public static void main(String[] args) {
	
		Cube cube = new Cube(new Vector3(0,0,0), Vector3.one(), new Vector3(1,1,1));
		ObjectOBJ obj = new ObjectOBJ("obj/car.obj", new Vector3(0,0,0), Vector3.zero(), new Vector3(3,3,3));

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

		long lastTime = System.nanoTime();
		float deltaTime = 0;

		while (true) {

			try {
				//berrechnung deltaTime
				long currentTime = System.nanoTime();
				deltaTime = (currentTime - lastTime) / 1_000_000_000.0f;
				lastTime = currentTime;
				System.out.println("FPS: "+ 1/deltaTime);
				r.nextTick(deltaTime);

				//pause für 30 fps 
				Thread.sleep(30);

				//langsammer zum testen 1 fps
				//Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
