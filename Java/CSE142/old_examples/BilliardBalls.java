// This programs displays several rows of "billiard balls" of
//   varying sizes and lengths.
//
// Note the use of parameters to generalize the process of drawing a
//   single ball and a row of balls.

import java.awt.*;

public class BilliardBalls {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(800, 600);
      panel.setBackground(Color.LIGHT_GRAY);
      Graphics pen = panel.getGraphics();
      
      drawRow(pen, 50, 10, 5, 20);
      drawRow(pen, 200, 100, 8, 10);
      drawRow(pen, 350, 25, 10, 35);
   }
   
   // Draws a single billiard ball.
   //
   // pen - the Graphics object to use for drawing
   // x - the x-coordinate at which to draw the ball
   // y - the y-coordinate at which to draw the ball
   // size - the size (diameter) of the ball to draw
   public static void drawBall(Graphics pen, int x, int y, int size) {
         pen.setColor(Color.PINK);
         pen.fillOval(x, y, size, size);
         pen.setColor(Color.BLACK);
         pen.drawOval(x, y, size, size);
   }
   
   // Draws a row of billiard balls.
   //
   // pen - the Graphics object to use for drawing
   // x - the x-coordinate at which to draw the first ball in the row
   // y - the y-coordinate at which to draw all balls in the row
   // count - the number of balls to draw in the row
   // size - the size (diameter) of each ball to draw   
   public static void drawRow(Graphics pen, int x, int y, int count, int size) {
      for (int i = 0; i < count; i++) {
         drawBall(pen, x + (i * size), y, size);
      }
      pen.setColor(Color.BLUE);
      pen.drawLine(x, y + (size / 2), x + (count * size), y + (size / 2));
   }
}