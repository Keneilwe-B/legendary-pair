package main;
import javax.swing.JFrame;

import event.Listener;

public class GameWindow extends JFrame{
	
	JFrame jf = new JFrame();
	
	public GameWindow(GamePanel gp){
		
		
		jf.setSize(400,400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.add(gp);
		jf.requestFocus();
		jf.setVisible(true);
	}
	
	
}
