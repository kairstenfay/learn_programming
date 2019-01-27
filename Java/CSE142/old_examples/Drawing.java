// This program draws a rudimentary van using DrawingPanel.
// Note the import statement and the use of the Color and Graphics classes.
//
// You must download DrawingPanel.java from the course website and save it
//   in the same folder as this file to run this program.
import java.awt.*;

public class Drawing {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(600, 400);
      panel.setBackground(Color.LIGHT_GRAY);
      Graphics g = panel.getGraphics();
      
      g.setColor(Color.BLACK);
      g.fillRect(10, 30, 100, 50);
       
      g.setColor(Color.RED);
      g.fillOval(20, 70, 20, 20);
      g.fillOval(80, 70, 20, 20);
        
      g.setColor(Color.CYAN);
      g.fillRect(80, 40, 30, 20);
   }
}