
public class Vector3 extends Vector <Vector3> {

	// position
	private double x;
	private double y;
	private double z;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	//konstruktoren
	public Vector3() {
		this(0, 0, 0);
	}

	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// position ändern
	public void set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void set(Vector3 v) {
		x = v.getX();
		y = v.getY();
		z = v.getZ();
	}

	// auf gleichheit überprüfen mit delta
	public boolean equals(Vector3 v) {
		return equals(this, v);
	}
	
	public static boolean equals(Vector3 v, Vector3 w) {
		return Math.abs(v.getX() - w.getX()) < Vector.EQUAL_DELTA && Math.abs(v.getY() - w.getY()) < Vector.EQUAL_DELTA && Math.abs(v.getZ() - w.getZ()) < Vector.EQUAL_DELTA;
	}
	
	//// Rechenoperationen
	//+
	public void add(Vector3 v) {
		x += v.getX();
		y += v.getY();
		z += v.getZ();
	}

	public static Vector3 add(Vector3 v, Vector3 w) {
		return new Vector3(v.getX() + w.getX(), v.getY() + w.getY(), v.getZ() + w.getZ());
	}

	//-
	public void subtract(Vector3 v) {
		x -= v.getX();
		y -= v.getY();
		z = v.getZ();
	}

	public static Vector3 subtract(Vector3 v, Vector3 w) {
		return new Vector3(v.getX() - w.getX(), v.getY() - w.getY(), v.getZ() - w.getZ());
	}

	//*
	public void multiplie(double a) {
		x *= a; 
		y *= a; 
		z *= a;
	}

	public static Vector3 multiplie(Vector3 v, double a) {
		return new Vector3(v.getX() * a, v.getY() * a, v.getZ() * a); 
	}

	// /
	public void divide(double a) {
		x /= a; 
		y /= a; 
		z /= a;
	}

	public static Vector3 divide(Vector3 v, double a) {
		return new Vector3(v.getX() / a, v.getY() / a, v.getZ() / a); 
	}

	// default vectoren
	public static Vector3 zero() {
		return new Vector3(0, 0, 0);
	}

	public static Vector3 one() {
		return new Vector3(1,1, 1);
	}

	// länge
	public double length() {
		return Math.sqrt(Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 2));
	}

	public String toString() {
		return "Vector 3d: \n\tx: " + x + "\n\ty: " + y + "\n\tz: " + z;
	}

	// test
	public static void main(String[] args) {
		Vector3 v = new Vector3(3, 1, 4);
		System.out.println(v);
		System.out.println(v.length());
		v.add(new Vector3(3, 1, 5));
		System.out.println(v);
		v.multiplie(3);
		System.out.println(v);	
		System.out.println(Vector3.subtract(new Vector3(3, 1, 7), new Vector3(8, 1, 3)));

	}

}
