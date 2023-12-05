package finalProject;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {
//CONSTRUCTOR
	public Type_A_GameObject(int x, int y) {
		super(x, y);
		name = "Object A";
		
		setDirection(Direction.DOWN);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
	}
	
//INHERITED FROM GameObject
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();
	
		//default yellow game object movement
		if (highlighted == false) {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
				}
			} else if (getDirection() == Direction.DOWN){
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
				}
			} else {
				setDirection(Direction.NONE);
			}
		//movement if highlighted
		} else {
			switch(getDirection()) {
				case Direction.UP:
					setY(getY() - getVelocity());
					if (getY() < 0)
						setY(0);
					break;
				case Direction.DOWN:
					setY(getY() + getVelocity());
					if (getY() + iconHeight > canvasHeight)
						setY((int) (canvasHeight - iconHeight));
					break;
				case Direction.LEFT:
					break;
				case Direction.RIGHT:
					break;
				default:
					break;
			}
		}
	}
	
	//specify yellow object orientation (used for animation)
	public void setImage() {
	    switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.DOWN:
	        currentImage = 0;
	        break;
	      case Direction.UP:
	        currentImage = 1;
	        break;
	      case Direction.LEFT:
	        break;
	      case Direction.RIGHT:
	        break;
	    }
	}
	
//INHERITED FROM KeyListener
	public void keyTyped(KeyEvent e) { }
	
	public void keyPressed(KeyEvent e) {
		if (highlighted == true) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
		    	setDirection(Direction.UP);
		    }
		    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		        setDirection(Direction.DOWN);
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
				//resume movement when no longer highlighted
				if (currentImage == 0) {
					setDirection(Direction.DOWN);
				} else {
					setDirection(Direction.UP);
				}
			}
	    }
	}
}
