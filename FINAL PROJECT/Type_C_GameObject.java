package finalProject;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {
//CONSTRUCTOR
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		name = "Object C";
		
		setDirection(Direction.LEFT);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}
	
//INHERITED FROM GameObject
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();
		
		//default purple game object movement
		if (highlighted == false) {
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
				}
			} else if (getDirection() == Direction.RIGHT){
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.LEFT);
				}
			} else {
				setDirection(Direction.NONE);
			}
		//movement if highlighted
		} else {
			switch(getDirection()) {
				case Direction.UP:
					break;
				case Direction.DOWN:
					break;
				case Direction.LEFT:
					setX(getX() - getVelocity());
					if (getX() < 0)
						setX(0);
					break;
				case Direction.RIGHT:
					setX(getX() + getVelocity());
					if (getX() + iconWidth > canvasWidth)
						setX((int) ( canvasWidth - iconWidth));
					break;
				default:
					break;
			}
		}
	}
	
	//specify purple object orientation (used for animation)
	public void setImage() {
		switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.UP:
	        break;
	      case Direction.DOWN:
	        break;
	      case Direction.LEFT:
	        currentImage = 0;
	        break;
	      case Direction.RIGHT:
	        currentImage = 1;
	        break;
	    }
	}
	
//INHERITED FROM KeyListener
	public void keyTyped(KeyEvent e) { }
	
	public void keyPressed(KeyEvent e) {
		if (highlighted == true) {
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		        setDirection(Direction.RIGHT);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        setDirection(Direction.LEFT);
		    }
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB && highlighted == true) {
			//releasing arrow keys while in control
			setDirection(Direction.NONE);
	    }
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			if (highlighted == true) {
				//stop movement when object becomes highlighted
				setDirection(Direction.NONE);
			}
			if (highlighted == false && getDirection() == Direction.NONE) {
				if (currentImage == 0) {
					setDirection(Direction.LEFT);
				} else {
					setDirection(Direction.RIGHT);
				}
			}
	    }
	}
}
