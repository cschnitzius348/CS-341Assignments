package finalProject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	//default serial number
	private static final long serialVersionUID = 1L;
	
	//game loop uses frame + timer
	private JFrame frame;
	private Timer gameLoopTimer;
	
	//game objects
	private List<GameObject> gameObjectList;
	private int highlightedIndex;
	
	//CONSTRUCTOR
	public Canvas() {
		//TASK 1: list of objects to appear on the canvas
		gameObjectList = new LinkedList<GameObject>();
		highlightedIndex = 0;
		
		//TASK 2: create window for the application
		frame = new JFrame("Final Project Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		//TASK 3: construct timer for game loop
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();
		
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		
		//TASK 4: make window visible
		frame.setVisible(true);
	}
	
	//add gameobjects to list (later added to canvas)
	public synchronized void addGameObject(GameObject sprite) {
		if (gameObjectList.isEmpty()) {
			sprite.highlighted = true;
		} else {
			sprite.highlighted = false;
		}
		
		gameObjectList.add(sprite);
	}
	
	//draw gameobject graphic onto canvas
	public synchronized void paint(Graphics g) {
		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}
	}
	
	//INHERITED ABTRACT METHODS from ActionListener
	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();
		}
		repaint();
	}
	
	//INHERITED ABSTRACT METHODS from KeyListener
	public void keyTyped(KeyEvent e) { }
	public void keyPressed(KeyEvent e) { }
	
	public void keyReleased(KeyEvent e) {
		GameObject s = gameObjectList.get(highlightedIndex);
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			//remove control from formerly highlighted object
			s.setDirection(Direction.NONE);
			s.highlighted = false;
			
			//change to next object
			highlightedIndex += 1;
			if (highlightedIndex == gameObjectList.size()) {
				highlightedIndex = 0;
			}
			
			//add control to new highlighted object
			s = gameObjectList.get(highlightedIndex);
			s.highlighted = true;
		}
		s.setVelocity(s.getVelocity()+1);
	}
}
