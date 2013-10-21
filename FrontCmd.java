import java.awt.Point;

/**
 * FrontCmd.java
 * Command class to move a selected shape to the front
 * 
 * @author Sujay Busam 10/21/13
 * @see Command
 */
public class FrontCmd extends Command {
  
  /**
   * When the mouse is clicked, move the frontmost Shape
   * at that Point to the front of the drawing.
   * 
   * @param p the coordinates of the click
   * @param dwg the drawing being clicked
   */
  public void executeClick(Point p, Drawing dwg) { 
  	Shape clickedShape = dwg.getFrontmostContainer(p);
  	
  	if (clickedShape != null) {
  		dwg.removeShape(clickedShape);
  		dwg.addToFront(clickedShape);
  	}
  }
}
