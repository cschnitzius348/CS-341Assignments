package finalProject;

public class MyMain {

	public static void main(String[] args) {
		//TASK 1: create canvas for animation
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2: add game object of type D
		Type_D_GameObject objectD = new Type_D_GameObject(400, 500);
		objectD.setVelocity(10);
		canvas.addGameObject(objectD);
		canvas.addKeyListener(objectD);
		
	//FINAL PROJECT TASKS
		//TASK 1: create GameObject A and GameObject C
		Type_A_GameObject objectA = new Type_A_GameObject(550, 50);
		objectA.setVelocity(10);
		canvas.addGameObject(objectA);
		canvas.addKeyListener(objectA);
		
		Type_C_GameObject objectC = new Type_C_GameObject(200, 400);
		objectC.setVelocity(10);
		canvas.addGameObject(objectC);
		canvas.addKeyListener(objectC);
		
		
		//TASK 2: create GameObject B
		Type_B_GameObject objectB = new Type_B_GameObject(100, 200);
		BtoDAdapter adapter = new BtoDAdapter(objectB);
		adapter.setVelocity(10);
		canvas.addGameObject(adapter);
		canvas.addKeyListener(adapter);

	}

}
