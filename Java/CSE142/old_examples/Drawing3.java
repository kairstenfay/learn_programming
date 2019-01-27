// Further improves the van drawing program by adding a parameter for 
//   the van's size to the drawVan method.
//
// You must download DrawingPanel.java from the course website and save it
//   in the same folder as this file to run this program.
import java.awt.*;

public class Drawing3 {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(600, 400);
      panel.setBackground(Color.LIGHT_GRAY);
      Graphics g = panel.getGraphics();
      
      drawVan(g, 10, 30, 100);
      drawVan(g, 100, 200, 200);
      drawVan(g, 400, 75, 20);
   }
   
   // Draws a van of the given size with a black body, cyan windshield, and 
   //   red wheels with its upper-left corner at position (x, y).   
   public static void drawVan(Graphics pen, int x, int y, int size) {
      pen.setColor(Color.BLACK);
      pen.fillRect(x, y, size, size / 2);
       
      pen.setColor(Color.RED);
      pen.fillOval(x + (size / 10), y + (size / 10 * 4), size / 5, size / 5);
      pen.fillOval(x + (size / 10 * 7), y + (size / 10 * 4), size / 5, size / 5);
        
      pen.setColor(Color.CYAN);
      pen.fillRect(x + (size / 10 * 7), y + (size / 10), size / 10 * 3, size / 5);
   }
}