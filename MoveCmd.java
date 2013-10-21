import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * @author Sujay Busam 10/21/13
 * @see Command
 */

public class MoveCmd extends Command {
	private Shape selectedShape; // the Shape to be moved
	
	// coordinates of click point before shape is moved
	private int originalX;
	private int originalY;

	/**
	 * When the mouse is pressed, get the frontmost shape containing that point.
	 * Store the original center Point of the shape.
	 * 
	 * @param p the coordinates of the mouse press
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		selectedShape = dwg.getFrontmostContainer(p);
		originalX = p.x;
		originalY = p.y;
	}

	/**
	 * When the mouse is dragged, update the shape's center Point
	 * so that it moves with the mouse
	 * 
	 * @param p the coordinates of the mouse drag
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		int currentX = p.x;
		int currentY = p.y;
		
		if (selectedShape != null) {
			selectedShape.move(currentX - originalX, currentY - originalY);
			// Update original coordinates
			originalX = currentX;
			originalY = currentY;
		}
	}
}