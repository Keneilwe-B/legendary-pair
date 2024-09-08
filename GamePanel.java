package main;
import java.awt.Color;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import event.Listener;


public class GamePanel extends JPanel implements ActionListener{
	
	private Color colour ;
	private String letter;
	private Random rand = new Random();
	private Listener ls; 
	private ArrayList<String> balloon_str= new ArrayList<>();
	private ArrayList<Color> balloon_col= new ArrayList<>();
	private ArrayList<Integer> balloon_x= new ArrayList<>();
	private ArrayList<Integer> balloon_y= new ArrayList<>();
	private int y = 0;
	private int missed, hit= 0,speed = 1;
	private Timer time;
	private Timer BalloonTime;
	private boolean gameover = false;
	public GamePanel() {
	
		setFocusable(true);
		addKeyListener(new Listener(this));
		Random_Alphabets();
		Balloons();
		time = new Timer(50,this);
		time.start();
		BalloonTime = new Timer(rand.nextInt(500,1600), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Balloons();
            }
        });
        BalloonTime.start();
	}
	
	public Color Random_Colour() {
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue =rand.nextInt(256);
		return new Color(red,green,blue);
	}
	
	public String Random_Alphabets() {
		String[] alphabets = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		this.letter = alphabets[rand.nextInt(alphabets.length)];
		return letter;
	}
	
	public void Balloons() {
		int cnt = 0;
		for(int i = 0;i<rand.nextInt(1,3*speed);i++) {
			String alph = Random_Alphabets();
			this.balloon_str.add(alph);
			this.balloon_col.add(Random_Colour());
			this.balloon_x.add(rand.nextInt(331));
			this.balloon_y.add(0);
		}

	}public void GameOver() {
		if(!gameover) {
			repaint();
		}else {
			return;
		}
	}
	
	public void Hit(String keycode) {

		if(balloon_str.contains(keycode)) {
			hit++;
			
			int index = this.balloon_str.indexOf(keycode);
			this.balloon_str.remove(index);
			this.balloon_col.remove(index);
			this.balloon_x.remove(index);
			this.balloon_y.remove(index);
				
		}
		System.out.println(keycode);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Loop(g);
	}
	public void Loop(Graphics g) {
		for(int count= 0;count<balloon_str.size();count++) {
			
			letter = balloon_str.get(count);
			int x = balloon_x.get(count);
			int y = balloon_y.get(count);
			colour = balloon_col.get(count);  
			g.setColor(colour);
			g.fillOval(x, y, 50, 50);
			int letterX = x+ (50 - g.getFontMetrics().stringWidth(letter))/2;
			int letterY = 10+(50 - g.getFontMetrics().getHeight())/2;
			g.setColor(colour.white);
			g.drawString(letter, letterX,letterY+y);
			
			

		}
		System.out.println(this.balloon_str);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		for(int i = 0; i<balloon_y.size(); i++) {
			int updateY = balloon_y.get(i)+speed;
			System.out.println(hit);
			if(hit == 10*speed) {
				speed++;
				hit = 0;
			}
			if(missed ==10 ) {
				time.stop();
				BalloonTime.stop();
				gameover = true;
				return;
			}
			if(updateY > getHeight()) {
				missed++;
				
				this.balloon_str.remove(i);
				this.balloon_col.remove(i);
				this.balloon_x.remove(i);
				this.balloon_y.remove(i);
				i--;
			}else {
				balloon_y.set(i, updateY);
			}
		}
		GameOver();
		
	}

}
