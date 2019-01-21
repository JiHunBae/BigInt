package Controller;

public class Controller {
	private static Controller controller = null;
	private Controller() {
		
	}
	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
}
