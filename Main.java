import java.awt.*;
import javax.swing.*;

public class Main {


	public static void main(String[] args) {
	
		Cube cube = new Cube();
		Camera c = new Camera();

		Scene scene = new Scene(c);
		scene.add(cube);
		
		//create window
		JFrame jframe = new JFrame("3D engin");
		Render r = new Render(scene);
	
		jframe.add(r);
		jframe.setSize(300, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setVisible(true);

	}

}
