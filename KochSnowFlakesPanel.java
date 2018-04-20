import java.awt.*;

import javax.swing.*;
/**
 * Draws the KochSnowFlakesPanel
 * @author Antonio Martinez
 * @Version 1.0
 */
public class KochSnowFlakesPanel extends JPanel{
 
 double sq = Math.sqrt(3.0) / 6;
 private final int PANEL_WIDTH = 400;
 private final int PANEL_HEIGHT = 400;
 private final int TOPX = 200, TOPY = 20;
 private final int LEFTX = 60, LEFTY = 300;
 private final int RIGHTX = 340, RIGHTY = 300;
 private int current;
 private Color color;
 
 public KochSnowFlakesPanel(int currentOrder)
 {
	 current = currentOrder;
	 setBackground (color);
	 setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	 
 }
 
 public void drawFractal(int draw, int startX, int startY, int endX, int endY, Graphics page){
  
  int x1 = startX;
  int x5 = endX;
  int y1 = startY;
  int y5 = endY;
  int dX, dY;
  int x2, x3, x4, y2, y3, y4;
  
  if(draw == 0)
   
   page.drawLine(x1, y1, x5, y5);
  
  else{
   
   dX = x5 - x1;
   dY = y5 - y1;
   x2 = x1 + dX / 3;
   y2 = y1 + dY / 3;
   x3 = (int)((x1 + x5) / 2 + sq * (y1 - y5));
   y3 = (int)((y1 + y5) / 2 + sq * (x5 - x1));
   x4 = x1 + dX * 2 / 3;
   y4 = y1 + dY * 2 / 3;
   
            drawFractal(draw -1, x1, y1, x2, y2, page);
            drawFractal(draw - 1, x2, y2, x3, y3, page);
            drawFractal(draw - 1, x3, y3, x4, y4, page);
            drawFractal(draw - 1, x4, y4, x5, y5, page);   
  }
 }
 public void paintComponent (Graphics page)
 {
	  super.paintComponent(page);
	  page.setColor(Color.WHITE);
	  drawFractal(current,TOPX,TOPY,LEFTX,LEFTY,page);
	  drawFractal(current,LEFTX,LEFTY,RIGHTX,RIGHTY,page);
	  drawFractal(current,RIGHTX,RIGHTY,TOPX,TOPY,page);
	  
 }
 public void setBackground(Color g){
	 
	  color = g;
 }
 public void setOrder(int order){
	 current = order;
 }
 public int getOrder(){
	 return current;
 }
}