 
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel {

  public void paint(Graphics g) {
    g.setColor (Color.gray);
    g.draw3DRect (25, 10, 50, 75, true);
    g.draw3DRect (25, 110, 50, 75, false);
    g.fill3DRect (100, 10, 50, 75, true);
    g.fill3DRect (100, 110, 50, 75, false);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}