import java.awt.Point;

/**
 * AddRectCmd.java
 * Command class to specify that a rectangle should be drawn.
 * 
 * @author Sujay Busam
 * @see Command
 */
public class AddRectCmd extends Command {
  
	// Top left corner of rectangle being drawn
	Point topLeft;

  /**
   * When the mouse is pressed, create a new rectangle
   * Shape and add it to the arraylist of Drawing
   * 
   * @param p the coordinates of the click
   * @param dwg the drawing being clicked
   */
  public void executePress(Point p, Drawing dwg) {
  	topLeft = p;
  	dwg.addRect(topLeft);
  }
  
  /**
   * When the mouse is dragged, update the rectangle's parameters
   * so that its width and height get dragged out
   * 
   * @param p the current mouse point
   * @param dwg the drawing being clicked
   */
  public void executeDrag(Point p, Drawing dwg) {
  	dwg.dragOutRect(topLeft, p);
  }
}
