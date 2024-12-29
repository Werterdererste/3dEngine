
public class Vector2 extends Vector <Vector2> {

	// position
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	//konstruktoren
	public Vector2() {
		this(0, 0);
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// position ändern
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2 v) {
		x = v.getX();
		y = v.getY();
	}

	// auf gleichheit überprüfen mit delta
	public boolean equals(Vector2 v) {
		return equals(this, v);
	}
	
	public static boolean equals(Vector2 v, Vector2 w) {
		return Math.abs(v.getX() - w.getX()) < Vector.EQUAL_DELTA && Math.abs(v.getY() - w.getY()) < Vector.EQUAL_DELTA;	
	}
	
	//// Rechenoperationen
	//+
	public void add(Vector2 v) {
		x += v.getX();
		y += v.getY();
	}

	public static Vector2 add(Vector2 v, Vector2 w) {
		return new Vector2(v.getX() + w.getX(), v.getY() + w.getY());
	}

	//-
	public void subtract(Vector2 v) {
		x -= v.getX();
		y -= v.getY();
	}

	public static Vector2 subtract(Vector2 v, Vector2 w) {
		return new Vector2(v.getX() - w.getX(), v.getY() - w.getY());
	}

	//*
	public void multiplie(double a) {
		x *= a; 
		y *= a; 
	}

	public static Vector2 multiplie(Vector2 v, double a) {
		return new Vector2(v.getX() * a, v.getY() * a); 
	}

	// /
	public void divide(double a) {
		x /= a; 
		y /= a; 
	}

	public static Vector2 divide(Vector2 v, double a) {
		return new Vector2(v.getX() / a, v.getY() / a); 
	}

	// default vectoren
	public static Vector2 zero() {
		return new Vector2(0, 0);
	}

	public static Vector2 one() {
		return new Vector2(1,1);
	}

	// länge
	public double length() {
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
	}

	public String toString() {
		return "Vector 2d: \n\tx: "+ x+"\n\ty: "+y;
	}

	// test
	public static void main(String[] args) {
		Vector2 v = new Vector2(3, 1);
		System.out.println(v);
		System.out.println(v.length());
		v.add(new Vector2(2,1));
		System.out.println(v);
		v.multiplie(3);
		System.out.println(v);	
		System.out.println(Vector2.subtract(new Vector2(2, 1), new Vector2(2, 3)));

	}

}
