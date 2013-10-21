import java.awt.*;
/**
 * ColorCmd.java
 * Command class to select the color of the shape being drawn
 * 
 * @author Sujay Busam 10/21/13
 * @see Command
 */
public class ColorCmd extends Command {
	private Color currentColor;
	
	/**
	 * Constructor that sets the current color of the drawing to
	 * the requested color
	 * 
	 * @param color the color requested to be drawn with
	 * @param dwg the drawing
	 */
	public ColorCmd(Color color, Drawing dwg) {
		dwg.setColor(color);
		currentColor = color;
	}
	
	/**
	 * On click, change clicked shape's color to selected color
	 * 
	 * @param p the click Point
	 * @param dwg the drawing
	 */
	public void executeClick(Point p, Drawing dwg) {
		Shape clickedShape = dwg.getFrontmostContainer(p);
		if (clickedShape != null) {
			clickedShape.setColor(currentColor);
		}
	}
}
