import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen wrote original file containing only
 * the pointInEllipse method
 * @see Shape
 * 
 * @author Sujay Busam added rest of code for CS10 PS-3
 * 10/21/13
 */
public class Ellipse extends Shape {
	// Instance data known only to member functions
	private int myX, myY, myWidth, myHeight;


	/**
	 * Constructor for a Ellipse
	 * 
	 * @param color the color you wish the shape to initially have
	 */
	public Ellipse(Color color, int x, int y, int width, int height){
		super(color);
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
	}

	/**
	 * Draws the ellipse onto the page
	 * 
	 * @param page the Graphics page onto which it is drawn
	 */
	public void drawShape(Graphics page) {
		page.fillOval(myX, myY, myWidth, myHeight);		
	}

	/**
	 * Does the Ellipse contain the Point p?
	 * 
	 * @param p the given Point
	 */
	public boolean containsPoint(Point p) {
		return pointInEllipse(p, myX, myY, myWidth, myHeight);
	}

	/**
	 * Move the Ellipse a given number of pixels in the x and y directions
	 * 
	 * @param deltaX pixels to move in the x direction
	 * @param deltaY pixels to move in the y direction
	 */
	public void move(int deltaX, int deltaY) {
		myX += deltaX;
		myY += deltaY;
	}

	/**
	 * Get the center point of the Ellipse
	 * 
	 * @return center the center Point
	 */
	public Point getCenter() {
		Point center = new Point();
		center.setLocation(myX + myWidth / 2, myY + myHeight / 2);

		return center;
	}

	// Setter methods to change the top left x, y & width and height of the ellipse
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

	// Helper method that returns whether Point p is in an Ellipse with the given
	// top left corner and size.
	private static boolean pointInEllipse(Point p, int left, int top, int width,
			int height) {
		double a = width / 2.0; // half of the width
		double b = height / 2.0; // half of the height
		double centerx = left + a; // x-coord of the center
		double centery = top + b; // y-coord of the center
		double x = p.x - centerx; // horizontal distance between p and center
		double y = p.y - centery; // vertical distance between p and center

		// Now we just apply the standard geometry formula.
		// (See CRC, 29th edition, p. 178.)
		return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
	}
}
