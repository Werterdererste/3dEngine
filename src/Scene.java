import java.util.*;

public class Scene {
	
	private List<Object3d> objects = new ArrayList<>();
	private Camera camera;

	public int getObjectsLength() {
		return objects.size();
	}

	public List<Object3d> getObjects() {
		return objects;
	}

	public Object3d getObject(int id) {
		//TODO: check id exist	
		return objects.get(id);
	}
	public  Object3d getObject(String name) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).getName().equals(name))
				return objects.get(i);
		}
		return null;
	}

	public Camera getCamera() {
		return camera;
	}

	public Scene() {
		this(new Camera());
	}

	public Scene(Camera c) {
		this.camera = c;
	}	

	public void add(Object3d obj) {
		objects.add(obj);
	}

	public void add(List<Object3d> objects) {
		this.objects.addAll(objects);
	}

	// remove object by name
	public void remove(String name) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).getName().equals(name)) {
				objects.remove(i);
				break;
			}
		}
	}
 	
	public String toString() {
		String str = "Scene__________\nCamera: "+ camera + "\n";
		for (int i = 0; i < objects.size(); i++) {
			str+= i + ". " + objects.get(i) + "\n";
		}
		return str+"____________\n";
	}

	public static void main(String[] args) {
		Scene s = new Scene(new Camera(new Vector3(2,1,4)));

		System.out.println(s);
		s.add(new Object3d());
		s.add(new Object3d("otto", new Vector3(3, 1, 7)));
		System.out.println(s);
		System.out.println();
		System.out.println();
		System.out.println(s.getObject(1));
		System.out.println(s.getObjectsLength());
	}

}
