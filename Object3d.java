import java.util.*;

public class Object3d {
	//parameter
	private static int count = 0;
	
	private String name;
	private Vector3 position;
	private Vector3 rotation;
	private Vector3 scale;
	private boolean visible = true;

	private List<Vector3> vertices = new ArrayList<>();
	private List<int[]> polygons = new ArrayList<>();

	// konstructor
	public Object3d() {
		this(Vector3.zero(), Vector3.zero(), Vector3.zero());
	}

	public Object3d(String name) {
		this(name, Vector3.zero(), Vector3.zero(), Vector3.zero());
	}
	public Object3d(Vector3 p) {
		this(p, Vector3.zero(), Vector3.zero());
	}

	public Object3d(String name, Vector3 p) {
		this(name, p, Vector3.zero(), Vector3.zero());
	}

	public Object3d(Vector3 p, Vector3 r, Vector3 s) {
		this("Obj-"+count, p, r, s);
	}

	public Object3d(String name, Vector3 p, Vector3 r, Vector3 s) {
		count++;
		this.name = name;
		this.position = p;
		this.rotation = r;
		this.scale = s;
	}

	// get set
	public static int getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public Vector3 getPosition() {
		return position;
	}

	public Vector3 getRotation() {
		return rotation;
	}

	public Vector3 getScale() {
		return scale;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void toggleVisible() {
		visible = !visible;
	}

	public List<Vector3> getVertices() {
		return vertices;
	}

	public Vector3 getVertex(int i) {
		return vertices.get(i);
	}

	public List<int[]> getPolygons() {
		return polygons;
	}

	public int[] getPolygon(int i) {
		return polygons.get(i);
	}

	public void addVertices(List<Vector3> v) {
		vertices.addAll(v);
	}

	public void addVertex(Vector3 v) {
		vertices.add(v);
	}

	public void addPolygons(List<int[]> polygons) {
		this.polygons.addAll(polygons);
	}

	public void addPolygon(int[] polygon) {
		this.polygons.add(polygon);
	}

	//transformation
	public void move(Vector3 v) {
		this.position.add(v);
	}

	public void rotate(Vector3 v) {
		this.rotation.add(v);
	}

	public void resize(Vector3 v) {
		this.scale.add(v);
	}

	// toString
	public String toString() {
		return "Object3d " + name + " is visible " + visible + "\nPosition: " + position + "\nRotation: " + rotation + "\nScale: "+ scale + "\n";
	}

	public static void main(String[] args) {
		Object3d o = new Object3d("tante", new Vector3(5,4,3));
		System.out.println(new Object3d()); 
		System.out.println(new Object3d(new Vector3(2,1,9))); 
		o.toggleVisible();
		System.out.println(o);
	}
}
