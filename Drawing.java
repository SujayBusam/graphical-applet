import java.awt.*;
import java.util.ArrayList;

/**
 * Drawing.java
 * Drawing class that adds, modifies, and draws the shapes onto the page
 *
 * @author Sujay Busam 10/21/13
 * CS10 PS-3
 */

public class Drawing {

	// Instance variables
	private ArrayList<Shape> shapeList;
	private Color currentColor; 


	/**
	 * Create an empty drawing with an initial default color
	 * 
	 * @param color the current color
	 */
	public Drawing(Color color) {
		currentColor = color;

		// Create an empty drawing
		shapeList = new ArrayList<Shape>();
	}

	/**
	 * Given a reference to a Graphics object, draw each Shape
	 * 
	 * @param page
	 */
	public void draw(Graphics page) {
		// Draw all shapes in arraylist from back to front
			for (int i = shapeList.size() - 1; i >= 0; i--) {
				shapeList.get(i).draw(page);
			}
	}


	/**
	 * Returns frontmost Shape in the drawing that contains given Point
	 * Returns null if no Shape contains the Point
	 */
	public Shape getFrontmostContainer(Point point) {
		for (Shape shape: shapeList) {
			if (shape.containsPoint(point)) {
				return shape;
			}
		}
		return null;
	}
	
	/**
	 * Sets the current color to a given Color
	 * 
	 * @param color the requested Color
	 */
	public void setColor(Color color) {
		currentColor = color;
	}

	/**
	 * Add a given shape to the front of the arraylist
	 * 
	 * @param shape the Shape to be added
	 */
	public void addToFront(Shape shape) {
		shapeList.add(0, shape);
	}
	
	/**
	 * Add a given shape to the back of the arraylist
	 * 
	 * @param shape the Shape to be added
	 */
	public void addToBack(Shape shape) {
		shapeList.add(shape);
	}
	
	/**
	 * Remove a given shape from the arraylist (and drawing)
	 * 
	 * @param shape the Shape to be removed
	 */
	public void removeShape(Shape shape) {
		shapeList.remove(shape);
	}

	/**
	 * Add a rectangle without width or height to the front of the arraylist
	 * 
	 * @param p the top left corner of the rectangle
	 */
	public void addRect(Point p) {
		Shape currentRect = new Rectangle(currentColor, p.x, p.y, 0, 0);
		shapeList.add(0, currentRect);
	}

	/**
	 * Draw out the rectangle added so that it spans from its top left corner
	 * to the current mouse position
	 * 
	 * @param topLeft the top left corner of the rectangle
	 * @param mousePoint the current mouse position
	 */
	public void dragOutRect(Point topLeft, Point mousePosition) {
		Shape currentRect = shapeList.get(0);
		((Rectangle) currentRect).setX(Math.min(mousePosition.x, topLeft.x));
		((Rectangle) currentRect).setY(Math.min(mousePosition.y, topLeft.y));
		((Rectangle) currentRect).setWidth(Math.abs(mousePosition.x - topLeft.x));
		((Rectangle) currentRect).setHeight(Math.abs(mousePosition.y - topLeft.y));
	}
	
	/**
	 * Add an ellipse without width or height to the front of the arraylist
	 * 
	 * @param p the top left corner of the box surrounding the ellipse
	 */
	public void addEllipse(Point p) {
		Shape currentEllipse = new Ellipse(currentColor, p.x, p.y, 0, 0);
		shapeList.add(0, currentEllipse);
	}

	/**
	 * Draw out the Ellipse added so that it spans from its top left corner
	 * to the current mouse position
	 * 
	 * @param topLeft the top left corner of the box surrounding the ellipse
	 * @param mousePoint the current mouse position
	 */
	public void dragOutEllipse(Point topLeft, Point mousePosition) {
		Shape currentEllipse = shapeList.get(0);
		((Ellipse) currentEllipse).setX(Math.min(mousePosition.x, topLeft.x));
		((Ellipse) currentEllipse).setY(Math.min(mousePosition.y, topLeft.y));
		((Ellipse) currentEllipse).setWidth(Math.abs(mousePosition.x - topLeft.x));
		((Ellipse) currentEllipse).setHeight(Math.abs(mousePosition.y - topLeft.y));
	}
	
	/**
	 * Add a segment without length to the front of the arraylist
	 * 
	 * @param p the
	 */
	public void addSegment(Point p) {
		Shape currentSegment = new Segment(currentColor, p.x, p.y, p.x, p.y);
		shapeList.add(0, currentSegment);
	}
	
	/**
	 * Draw out the segment added so that it spans from its original
	 * click point to the current mouse position
	 * 
	 * @param mousePoint the current mouse position
	 */
	public void dragOutSegment(Point mousePoint) {
		Shape currentSegment = shapeList.get(0);
		((Segment) currentSegment).setX2(mousePoint.x);
		((Segment) currentSegment).setY2(mousePoint.y);
	}
}
