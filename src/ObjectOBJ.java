import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ObjectOBJ extends Object3d {

	public ObjectOBJ(String filePath) {
		super();
		parseOBJfile(filePath);
	}

	public ObjectOBJ(String filePath, String name) {
		super(name);
		parseOBJfile(filePath);
	}

	public ObjectOBJ(String filePath, Vector3 position) {
		super(position);
		parseOBJfile(filePath);
	}

	public ObjectOBJ(String filePath, String name, Vector3 position) {
		super(name, position);
		parseOBJfile(filePath);
	}

	public ObjectOBJ(String filePath, Vector3 position, Vector3 rotation, Vector3 scale) {
		super(position, rotation, scale);
		parseOBJfile(filePath);
	}

	public ObjectOBJ(String filePath, String name, Vector3 position, Vector3 rotation, Vector3 scale) {
		super(name, position, rotation, scale);
		parseOBJfile(filePath);
	}

	public void onUpdate(float timeDelta) {
		//TODO: just a test
		System.out.println("move");
		super.move(Vector3.multiplie(new Vector3(1,0,0), 1*timeDelta));
		super.resize(Vector3.multiplie(new Vector3(1,1,1), 1*timeDelta));
	}

	// read obj file and parse
	public void parseOBJfile(String filePath) {
		try {
			File obj = new File(filePath);
			Scanner sc = new Scanner(obj);
	
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.startsWith("v ")) {
					// Vertex 
					parseVertex(line.substring(2));			
				} else if (line.startsWith("f ")) {
					// Polygon
					parsePolygon(line.substring(2));
				}
			}

			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found: " + e);
			System.exit(2);
		}

	}
	
	//parse Vertex line from OBJ file
	public void parseVertex(String line) {
		String[] parts = line.split("\\s+");	
		double x = Double.parseDouble(parts[0]);
		double y = Double.parseDouble(parts[1]);
		double z = Double.parseDouble(parts[2]);
		Vector3 v = new Vector3(x,y,z);
		super.addVertex(v);
	}
	
	//parse Polygon line form OBJ file
	public void parsePolygon(String line) {
		String[] parts = line.split("\\s+");
		int[] polygon = new int[parts.length];

		for (int i = 0; i < parts.length; i++) {
			String[] vertexnum = parts[i].split("/");

			int vertex = Integer.parseInt(vertexnum[0])-1;
			polygon[i] = vertex;
		}
		super.addPolygon(polygon);
	}

	public static void main(String[] args) {
		System.out.println("Cube");
	}

}
