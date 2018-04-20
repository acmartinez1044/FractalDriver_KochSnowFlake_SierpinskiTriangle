import java.awt.*;

import javax.swing.JPanel;
/**
 * Program that draws Sierpinski Triangle
 * @author Antonio Martinez
 * @Version 1.0
 */
public class SierpinskiTrianglePanel extends JPanel {
  
	private int level;
	private Color color = Color.DARK_GRAY;

  public SierpinskiTrianglePanel(int initialLevel) {
    level = initialLevel;
    try {
      initialize();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void changeLevel(int newLevel) {
     level = newLevel;
     repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    setBackground(color);
    // The center triangle is red
    g.setColor(Color.WHITE);
    makeTriangle(g, 250, 0, 0, 500, 500, 500, level);
  }
  public int getOrder(){
	  return level;
  }
  public void setBackground(Color g){
	  
	  color = g;
  }
  public void makeTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int level) {
      // Compute the points
      int[] xPoints = new int[3];
      int[] yPoints = new int[3];
      int xMid12;
      int xMid23;
      int xMid31;
      int yMid12;
      int yMid23;
      int yMid31;
      // Compute midpoints of triangle sides
      xMid12 = (x1 + x2) / 2;
      xMid23 = (x2 + x3) / 2;
      xMid31 = (x3 + x1) / 2;
      yMid12 = (y1 + y2) / 2;
      yMid23 = (y2 + y3) / 2;
      yMid31 = (y3 + y1) / 2;
      xPoints[0] = xMid12;
      xPoints[1] = xMid23;
      xPoints[2] = xMid31;
      yPoints[0] = yMid12;
      yPoints[1] = yMid23;
      yPoints[2] = yMid31;
      // Fill the triangle
      g.fillPolygon(xPoints, yPoints, 3);
      // Recursively draw three smaller triangles if level > 0
      if (level > 0) {
        g.setColor(Color.red);
        makeTriangle(g, x1, y1, xMid12, yMid12, xMid31, yMid31, level - 1);
        g.setColor(Color.green);
        makeTriangle(g, xMid12, yMid12, x2, y2, xMid23, yMid23, level - 1);
        g.setColor(Color.blue);
        makeTriangle(g, xMid31, yMid31, xMid23, yMid23, x3, y3, level - 1);
      }
  }
  private void initialize() throws Exception {
    // Set minimum and preferred sizes
    setMinimumSize(new Dimension(500, 500));
    setPreferredSize(new Dimension(500, 500));
  }

}

