
public class Cube extends Object3d {

	public Cube() {
		super();
		creatObject();
	}

	public Cube(String name) {
		super(name);

		creatObject();
}

	public Cube(Vector3 position) {
		super(position);
		creatObject();
	}

	public Cube(String name, Vector3 position) {
		super(name, position);
		creatObject();
	}

	public Cube(Vector3 position, Vector3 rotation, Vector3 scale) {
		super(position, rotation, scale);
		creatObject();
}

	public Cube(String name, Vector3 position, Vector3 rotation, Vector3 scale) {
		super(name, position, rotation, scale);
		creatObject();

	}

	public void onUpdate(float timeDelta) {
	}

	public void creatObject() {

		super.addVertex(new Vector3(-1 , -1, -1));
		super.addVertex(new Vector3(-1, 1, -1));
		super.addVertex(new Vector3(1,1,-1));
		super.addVertex(new Vector3(1,-1,-1));
		super.addVertex(new Vector3(-1,-1,1));
		super.addVertex(new Vector3(-1,1,1));
		super.addVertex(new Vector3(1,1,1));
		super.addVertex(new Vector3(1,-1,1));


		// 4v polygon
		super.addPolygon(new int[]{0, 1, 2, 3});
		super.addPolygon(new int[]{4, 5, 6, 7});

		super.addPolygon(new int[]{0, 1, 5, 4});
		super.addPolygon(new int[]{3, 2, 6, 7});

		super.addPolygon(new int[]{0, 3, 7, 4});
		super.addPolygon(new int[]{1, 2, 6, 5});
// 3v polygon
		/*
		super.addPolygon(new int[]{0,1,2});
		super.addPolygon(new int[]{0,2,3});

		super.addPolygon(new int[]{4,5,6});
		super.addPolygon(new int[]{4,6,7});

		super.addPolygon(new int[]{0,1,5});
		super.addPolygon(new int[]{0,4,5});

		super.addPolygon(new int[]{3,2,6});
		super.addPolygon(new int[]{3,6,7});

		super.addPolygon(new int[]{1,3,7});
		super.addPolygon(new int[]{0,4,7});
		
		super.addPolygon(new int[]{1,2,6});
		super.addPolygon(new int[]{1,5,6});
*/
	
	}

	public static void main(String[] args) {
		System.out.println("Cube");
	}

}
