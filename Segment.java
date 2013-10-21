import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Sujay Busam 10/21/13 
 * @author Thomas H. Cormen originally wrote file containing only the 
 * almostContainsPoint and distanceToPoint methods
 * @see Shape
 */
public class Segment extends Shape {

	// Instance data known only to member functions
	private static final int TOLERANCE = 3; // pixel tolerance of clicking on a line
	private int myX1, myY1, myX2, myY2; // x,y coords of both ends of line

	public Segment(Color color, int x1, int y1, int x2, int y2){
		super(color);
		myX1 = x1;
		myY1 = y1;
		myX2 = x2;
		myY2 = y2;
	}

	/**
	 * Draws the line onto the page
	 * 
	 * @param page the Graphics page onto which it is drawn
	 */	
	public void drawShape(Graphics page) {
		page.drawLine(myX1, myY1, myX2, myY2);
	}


	/**
	 * Does the Segment contain the Point p?
	 * 
	 * @param p the given Point
	 */
	public boolean containsPoint(Point p) {
		return isClicked(p, myX1, myY1, myX2, myY2);
	}

	/**
	 * Move the Ellipse a given number of pixels in the x and y directions
	 * 
	 * @param deltaX pixels to move in the x direction
	 * @param deltaY pixels to move in the y direction
	 */
	public void move(int deltaX, int deltaY) {
		myX1 += deltaX;
		myX2 += deltaX;
		myY1 += deltaY;
		myY2 += deltaY;
	}

	/**
	 * Get the center point of the Ellipse
	 * 
	 * @return
	 */
	public Point getCenter() {
		Point center = new Point();
		center.setLocation((myX1 + myX2) / 2, (myY1 + myY2) / 2);

		return center;
	}

	// Point is close enough to line segment if point is within tolerance of line segment's
	// bounding box and if distance between point and infinite line containing segment is
	// within the tolerance.
	private boolean isClicked(Point point, int lineX1, int lineY1, int lineX2, int lineY2) {
		return ((almostContainsPoint(point, Math.min(lineX1, lineX2), Math.min(lineY1, lineY2), 
				Math.max(lineX1, lineX2), Math.max(lineY1, lineY2), TOLERANCE) &&
				distanceToPoint(point, lineX1, lineY1, lineX2, lineY2) <= TOLERANCE));
	}

	// Helper method that returns true if Point p is within a tolerance of a
	// given bounding box. Here, the bounding box is given by the coordinates of
	// its left, top, right, and bottom.
	private static boolean almostContainsPoint(Point p, int left, int top,
			int right, int bottom, double tolerance) {
		return p.x >= left - tolerance && p.y >= top - tolerance
		&& p.x <= right + tolerance && p.y <= bottom + tolerance;
	}

	// Helper method that returns the distance from Point p to the line
	// containing a line segment whose endpoints are given.
	private static double distanceToPoint(Point p, int x1, int y1, int x2,
			int y2) {
		if (x1 == x2) // vertical segment?
			return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
		else if (y1 == y2) // horizontal segment?
			return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
		else {
			// Here, we know that the segment is neither vertical nor
			// horizontal.
			// Compute m, the slope of the line containing the segment.
			double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

			// Compute mperp, the slope of the line perpendicular to the
			// segment.
			double mperp = -1.0 / m;

			// Compute the (x, y) intersection of the line containing the
			// segment and the line that is perpendicular to the segment and that
			// contains Point p.
			double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
			/ (mperp - m);
			double y = m * (x - x1) + y1;

			// Return the distance between Point p and (x, y).
			return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
		}
	}

	// Setter methods to change the segment's endpoint coordinates
	public void setX2(int x2) {
		myX2 = x2;
	}
	public void setY2(int y2) {
		myY2 = y2;
	}
}
