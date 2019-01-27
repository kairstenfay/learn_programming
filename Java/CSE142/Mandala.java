// Draws a mandala 

import java.awt.*;

public class Mandala {   
   public static final int SIZE = 70;
   public static final int X_OFFSET = 30;
   public static final int Y_OFFSET = 80;
   public static final int FIRST_COL = 50;
   public static final Color LIGHT_BLUE = new Color(230, 255, 255);

   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(600, 600);
      panel.setBackground(LIGHT_BLUE);
      Graphics g = panel.getGraphics();
      drawLeaf(g, 4, 10, 10, 10);
      
   }
      
   public static void drawLeaf(Graphics g, int n_lines, int x, int y, int size) { 
      for (int i = 0; i < n_lines; i ++) { 
         g.setColor(Color.BLACK);
         g.drawRect(x, y, size, size);
         size += 10;
      }
   }
}
    
    