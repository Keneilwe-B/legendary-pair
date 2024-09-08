
package main;

public class Main {
	
	 
	public static void main(String[] args) {
		GamePanel gp = new GamePanel();
		GameWindow gw = new GameWindow(gp);
		gp.requestFocusInWindow();
	}

}
 