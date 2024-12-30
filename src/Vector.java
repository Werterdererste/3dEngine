
public abstract class Vector <V extends Vector> {

	// für equals gleichheits diverens
	public final static double EQUAL_DELTA = 0.001;

	public abstract void set(V v);

	public abstract boolean equals(V v);

	// standart rechen operationen
	public abstract void add(V v);
	public abstract void subtract(V v);
	public abstract void multiplie(double a);
	public abstract void divide(double a);

	public abstract double length();

	public abstract String toString();
}
