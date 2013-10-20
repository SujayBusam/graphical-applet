import java.awt.Point;

/**
 * AddSegmentCmd.java
 * Command class to specify that a segment should be drawn.
 * 
 * @author Sujay Busam
 * @see Command
 */
public class AddSegmentCmd extends Command {

  /**
   * When the mouse is pressed, create a new segment
   * Shape and add it to the arraylist of Drawing
   * 
   * @param p the coordinates of the click
   * @param dwg the drawing being clicked
   */
  public void executePress(Point p, Drawing dwg) {
  	dwg.addSegment(p);
  }
  
  /**
   * When the mouse is dragged, update the segment's parameters
   * so that its gets dragged out
   * 
   * @param p the current mouse point
   * @param dwg the drawing being clicked
   */
  public void executeDrag(Point p, Drawing dwg) {
  	dwg.dragOutSegment(p);
  }
}
