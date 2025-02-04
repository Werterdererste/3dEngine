# Klassen diagram

main
--
--
+ Static main(String: args[])

abstract Vector <V extends Vector>
--
+ final static double EQUAL\_DELTA = 0.001  
--
+ abstract Vector()
+ abstract set(V) // werte ändern
+ abstract equals(V): bool  // ist vector gleich 
+ abstract add(V)
+ abstract subtract(V)
+ abstract multiplie(double)
+ abstract divide(double)
+ abstract scale(V) // komponentenweise multiplikation
+ abstract length(): double // lenge eines Vectors
+ abstract toString(): String

Vector3 extends Vector <Vector3>
--
- double: x
- double: y
- double: z
--
+ Vector3(double x, double y, double z)
+ Vector3() //x=0, y=0, z=0
+ X: get set // x y z der werte
+ Y: get set
+ Z: get set
+ set(double x, double y, double z) // werte ändern
+ set(double Vector3d) // werte ändern
+ equals(Vector3): bool  // ist vector gleich 
+ Static equals(Vector3, Vector3): bool  // ist vector gleich 
+ add(Vector3)
+ Static add(Vector3, Vector3): Vector3
+ subtract(Vector3)
+ Static subtract(Vector3, Vector3): Vector3
+ multiplie(double)
+ Static multiplie(Vector3, double): Vector3
+ divide(double)
+ Static divide(Vector3, double): Vector3
+ scale(Vector3 v)
+ Static scale(Vector3 v, Vector3 w): Vector 3
+ Static zero(): Vector // (0 0 0)
+ Static one(): Vector3 // (1 1 1)
+ length(): double // length eines Vectors
+ toString(): String

Vector2 extends Vector <Vector2>
--
- double: x
- double: y
--
+ Vector2(double x, double y)
+ Vector2() //x=0, y=0
+ X: get set // x y  der werte
+ Y: get set
+ set(double x, double y) // werte ändern
+ set(double Vector2) // werte ändern
+ equals(Vector2): bool  // ist vector gleich 
+ Static equals(Vector2, Vector2): bool  // ist vector gleich 
+ add(Vector2)
+ Static add(Vector2, Vector2): Vector2
+ subtract(Vector2)
+ Static subtract(Vector2, Vector2): Vector2
+ multiplie(double)
+ Static multiplie(Vector2, double): Vector2
+ divide(double)
+ Static divide(Vector2, double): Vector2 
+ scale(Vector2 v)
+ staic scale (Vector2 v, Vector2 w): Vector2
+ Static zero(): Vector2 // (0 0)
+ Static one(): Vector2 // (1 1)
+ length(): double // lenge eines Vectors
+ toString(): String

interface Updateble
--
--
+ onUpdate(float deltaTime) //zum ausführn jedes tick. delatTime zur berechnung
// +onStart()

Object3d implements Updateble
--
- static count: int
- name: String
- position: Vector3
- rotation: Vector3
- scale: Vector3
- visible: bool
- vertices: List<Vector3D>
- polygons: List<int[3]>
--
+ Object3d() //name ObjNum, pos 0, r 0, s 0
+ Object3d(name) // pos 0, rot 0, scale 0
+ Object3d(Vector3 p) //name ObjNum, r 0, s 0
+ Object3d(name String, Vector3 p) // pos, rotate 0, scale 0
+ Object3d(Vector p, Vector3 r, Vector3 s) //name ObjNum
+ Object3d(name String, Vector3 p, Vector3 r, Vector3 s)
+ getName(): String
+ getPosition(): Vector3
+ getRotation(): Vector3
+ getScale(): vector3
+ isVisible: bool
+ setVisible(bool)
+ toggelVisible()
+ getVertices(): List<Verctor3>
+ getVertex(int i): Vector3
+ getPolygons(): List<int[3]>
+ getPolygon(int i): int[3]
+ addVertices(List<Vector3D> vl)
+ addVertex(Vector3 v)
+ addPolygons(List<int [3]>)
+ addPolygon(int[3])
+ move(Vector3) // position add value
+ rotate(Vector3) // rotation add value
+ resize(Vector3) // scale add value 
+ onUpdate(float delaTime)
// abstract onStart()
+ toString(): String
+ Static getCount(): int

Camera
--
- position: Vector3
- direction: Vector3
--
+ Camera()
+ Camera(Vector3 p)
+ Camera(Vector3 p, Vector3 d)
+ getPosition(): Vector3
+ getDirection(): Vector3
+ move(Vector3) // ändert position
+ rotate(Vector3) // rotiert
+ lockAt(Vector3) // schaut in richtung
+ project(Vector3 v): Vector2 // wandelt 3d in 2d um
+ project(Vector3[] v): Vector2[] // wandelt 3d in 2d um
// onUpdate()
// onStart()
+ toString(): String

Scene
--
- objects: List<Object3d>
- camera: Camera
--
+ Scene(camara)
+ getObjects()
+ getObjectsLength()
+ getCamera()
+ add(Object3d)
+ add(List<Object3d>)
+ remove(name)
+ getObject(String name): Object3d
+ getObject(int id): Object3d
+ toString(): String

Render
--
- scene: Scene
--
+ Render()
+ Render(Scene scene)
+ setScene(Scene scene)
+ getScene(): Scene
+ paintComponent(Graphics g) //paint vectors
+ rotate(Vector3 v, Vector3 rotate): Vector3
+ paintPolygon(Graphics2d g2d, Vector3[] polygon
+ nextTick() //berechnet nächsten tick

Cube extende Object3d
--
- static count: int
--
+ Cube() //name cubNum
+ Cube(name)
+ Cube(Vector3 position) 
+ Cube(name String, Vector3 position) 
+ Cube(Vector positon, Vector3 rotation, Vector3 scale) 
+ Cube(name String, Vector3 position, Vector3 rotation, Vector3 scale)
+ static getCount(): int
+ onUpdate(float deltaTime)
+ creatObject()

ObjectOBJ extende Object3d
--
- static count: int
- string: fileName
--
+ ObjectOBJ(String: fileName) //name cubNum
+ ObjectOBJ(String: fileName, name)
+ ObjectOBJ(String: fileName, Vector3 position) 
+ ObjectOBJ(String: fileName, name String, Vector3 position) 
+ ObjectOBJ(String: fileName, Vector positon, Vector3 rotation, Vector3 scale) 
+ ObjectOBJ(String: fileName, name String, Vector3 position, Vector3 rotation, Vector3 scale)
+ static getCount(): int
+ onUpdate(float deltaTime)
+ parseOBJfile(String filePath)
+ parseVertex(String line)
+ parsePolygon(String line)



