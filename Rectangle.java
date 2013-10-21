import java.awt.*;

/**
 * Rectangle.java
 * Class for a rectangle.
 *
 * @author Sujay Busam 10/21/13
 * @see Shape
 */
public class Rectangle extends Shape {
	// Instance data known only to member functions
	private int myX, myY, myWidth, myHeight;
	
  
	/**
	 * Constructor for a Rectangle
	 * 
	 * @param color the color you wish the shape to initially have
	 */
	public Rectangle(Color color, int x, int y, int width, int height){
		super(color);
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
	}

	/**
	 * Draws the rectangle onto the page
	 * 
	 * @param page the Graphics page onto which it is drawn
	 */
	public void drawShape(Graphics page) {
		page.fillRect(myX, myY, myWidth, myHeight);		
	}

	/**
	 * Does the Rectangle contain the Point p?
	 * 
	 * @param p the given Point
	 */
	public boolean containsPoint(Point p) {
		return (myX <= p.x && p.x <= myX + myWidth && 
				myY <= p.y && p.y <= myY + myHeight);
	}

	/**
	 * Move the Rectangle a given number of pixels in the x and y directions
	 * 
	 * @param deltaX pixels to move in the x direction
	 * @param deltaY pixels to move in the y direction
	 */
	public void move(int deltaX, int deltaY) {
		myX += deltaX;
		myY += deltaY;
	}

	/**
	 * Get the center point of the rectangle
	 * 
	 * @return center the center Point
	 */
	public Point getCenter() {
		Point center = new Point();
		center.setLocation(myX + myWidth / 2, myY + myHeight / 2);
		
		return center;
	}
	
	// Setter methods to change the top left x, y & width and height of the rectangle
	public void setWidth(int width) {
		myWidth = width;
	}
	public void setHeight(int height) {
		myHeight = height;
	}
	public void setX(int x) {
		myX = x;
	}
	public void setY(int y) {
		myY = y;
	}
}
