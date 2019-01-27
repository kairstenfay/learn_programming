// Improves the van drawing program by creating a parameterized method
//   to draw a van at any location. 
//
// You must download DrawingPanel.java from the course website and save it
//   in the same folder as this file to run this program.
import java.awt.*;

public class Drawing2 {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(600, 400);
      panel.setBackground(Color.LIGHT_GRAY);
      Graphics g = panel.getGraphics();
      
      drawVan(g, 10, 30);
      drawVan(g, 100, 200);
   }
   
   // Draws a van with a black body, cyan windshield, and red wheels
   //   with its upper-left corner at position (x, y).
   public static void drawVan(Graphics pen, int x, int y) {
      pen.setColor(Color.BLACK);
      pen.fillRect(x, y, 100, 50);
       
      pen.setColor(Color.RED);
      pen.fillOval(x + 10, y + 40, 20, 20);
      pen.fillOval(x + 70, y + 40, 20, 20);
        
      pen.setColor(Color.CYAN);
      pen.fillRect(x + 70, y + 10, 30, 20);
   }
}