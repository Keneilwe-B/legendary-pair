package event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

public class Listener implements KeyListener {
	
	GamePanel gp ;
	public Listener(GamePanel gp) {
		this.gp = gp;
		//this.gp.repaint();
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gp.Hit(Character.toString(e.getKeyChar()).toUpperCase());
		//System.out.println(e.getKeyChar());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
