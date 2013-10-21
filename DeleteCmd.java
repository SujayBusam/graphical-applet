import java.awt.*;

/**
 * DeleteCmd.java
 * Command class to perform a shape delete.
 * 
 * @author Sujay Busam 10/21/13
 * @see Command
 */
public class DeleteCmd extends Command {
  
  /**
   * When the mouse is clicked, get frontmost Shape
   * at the given Point and delete it.
   * 
   * @param p the coordinates of the click
   * @param dwg the drawing being clicked
   */
  public void executeClick(Point p, Drawing dwg) { 
  	Shape clickedShape = dwg.getFrontmostContainer(p);
  	
  	if (clickedShape != null) {
			dwg.removeShape(clickedShape);
  	}
  }
}
