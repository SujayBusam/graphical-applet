import java.awt.Point;

/**
 * BackCmd.java
 * Command class to move a selected shape to the back
 * 
 * @author Sujay Busam
 * @see Command
 */
public class BackCmd extends Command {

	/**
	 * When the mouse is clicked, move the frontmost Shape
	 * at that Point to the back of the drawing.
	 * 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) { 
		Shape clickedShape = dwg.getFrontmostContainer(p);

		if (clickedShape != null) {
			dwg.removeShape(clickedShape);
			dwg.addToBack(clickedShape);
		}
	}
}
