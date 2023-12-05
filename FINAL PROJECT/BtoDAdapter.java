package finalProject;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BtoDAdapter extends Type_D_GameObject {
	
	public BtoDAdapter(Type_B_GameObject objectB) {
		super(objectB.getX(), objectB.getY());
		
		setDirection(Direction.UP);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B_Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();
		
		//default red game object movement
		if (highlighted == false) {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.RIGHT);
				}
			} else if (getDirection() == Direction.RIGHT){
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.DOWN);
				}
			} else if (getDirection() == Direction.DOWN){
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.LEFT);
				}
			} else if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
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
					setX(getX() - getVelocity());
					if (getX() < 0)
						setX(0);
					break;
				case Direction.RIGHT:
					setX(getX() + getVelocity());
					if (getX() + iconWidth > canvasWidth)
						setX((int) (canvasWidth - iconWidth));
					break;
				default:
					break;
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
					setDirection(Direction.UP);
				} else if (currentImage == 1) {
					setDirection(Direction.DOWN);
				} else if (currentImage == 2) {
					setDirection(Direction.LEFT);
				} else {
					setDirection(Direction.RIGHT);
				}
			}
	    }
	}

}
