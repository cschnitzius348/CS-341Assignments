package finalProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.Icon;
import java.awt.BasicStroke;

public abstract class GameObject {
	//DATA MEMBERS
	//each game object has location (x, y), velocity, + direction
	private int x;
	private int y;
	private int velocity;
	private int direction;
	
	protected String name;
	protected boolean highlighted;
	
	//each game object can have collection of images
	protected List<Icon> imageList;
	protected int currentImage;
	
	//CONSTRUCTOR
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 0;
		currentImage = 0;
	}
	
	//FUNCTIONALITY
	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
		if (highlighted) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(4));
			g2.drawRect(x, y, imageList.get(currentImage).getIconWidth(), imageList.get(currentImage).getIconHeight());
		}
	}

	//SETTERS + GETTERS
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }

	public int getVelocity() { return velocity; }
	public void setVelocity(int velocity) { this.velocity = velocity; }
	
	public int getDirection() { return direction; }
	public void setDirection(int direction) { this.direction = direction; }
	
	public void setHighlighted(boolean h) { highlighted = h; }

	public Icon getCurrentImage() {
		return imageList.get(currentImage);
	}
	
	//ABSTRACT METHODS
	public abstract void move(Canvas canvas);
	public abstract void setImage();
	
}
