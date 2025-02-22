
public class Camera implements Updateble {

	
	private Vector3 position;
	private Vector3 direction;

	
	public Vector3 getPosition() {
		return position;
	}

	public Vector3 getDirection() {
		return direction;
	}
	
	//konstruktor
	public Camera() {
		this(Vector3.zero(), Vector3.zero());
	}

	public Camera(Vector3 p) {
		this(p, Vector3.zero());
	}

	public Camera(Vector3 p, Vector3 d) {
		this.position = p;
		this.direction = d;
	}

	public void move(Vector3 v) {
		position.add(v);
	}

	public void rotate(Vector3 v) {
		direction.add(v);
	}

	public void lockAt(Vector3 v) {
		direction.set(v);
	}

	// projeziert einen 3d vector zu einem 2d vector
	public Vector2 project(Vector3 v) {
		//TODO: überarbeiten
		Vector2 vx = new Vector2(6,0);
		Vector2 vy = new Vector2(0,5);
		Vector2 vz = new Vector2(-2,-4);

		vx.multiplie(v.getX()*10);
		vy.multiplie(v.getY()*10);
		vz.multiplie(v.getZ()*10);

		Vector2 out = new Vector2();
		out.add(vx);
		out.add(vy);
		out.add(vz);
		return out;
	}

	// projeziert eine array an 3d vektoren zu 2d vectoren
	public Vector2[] project(Vector3[] vectors) {
		Vector2[] out = new Vector2[vectors.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = project(vectors[i]);
	}
		return out; 
	}	

	public void onUpdate(float deltaTime) {
	}
	public String toString() {
		return "Camera: \nPosition: "+ position + "\nDirection: " + direction + " ";
	}

	public static void main(String[] args) {
		Camera c = new Camera();
		System.out.println(c);
		c.move(new Vector3(3, 2, 1));
		System.out.println(c);
		c.rotate(Vector3.one());
		System.out.println(c);
		c.lockAt(new Vector3(2, 1, 0));
		System.out.println(c);
	}

}
