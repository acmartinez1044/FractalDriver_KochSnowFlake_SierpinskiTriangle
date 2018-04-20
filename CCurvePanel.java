import java.awt.*;

import javax.swing.*;

import java.math.*;
/**
 * Program that draws the CCurve program
 * @author Antonio Martinez
 * @Version 1.0
 */
public class CCurvePanel  extends JPanel {
	
	 
	 int MAX = 5;
	 final int cX1 = 165;
	 final int cX2 = 490;
	 final int cY1 = 150;
	 final int cY2 = cY1;
	 int current;
	 final int curveMax = 8;
	 private Color color;
	
	 public CCurvePanel(int currentOrder)
	 {
		 current = currentOrder;
		 setBackground (color);
		 setPreferredSize(new Dimension(getWidth(), getHeight()));
		 
	 }
	 /**
	  * Draws a CCurve using recursion
	  * @param draw level
	  * @param x1 start point
	  * @param y1 start point
	  * @param x2 end point
	  * @param y2 end point
	  * @param page draws line
	  */
	 public CCurvePanel(int draw, int x1, int y1, int x2, int y2, Graphics page){
	  
	  drawFractal(draw, x1, y1, x2, y2, page);
	 }
	 
	 /**
	  * Implements the method to define how to draw the CCurve
	  * @param draw level
	  * @param startX starting x coord
	  * @param startY starting y coord
	  * @param endX ending x coord
	  * @param endY ending y coord
	  * @param page draws here
	  */
	 public void drawFractal(int draw, int startX, int startY, int endX, int endY, Graphics page){
	  
	  int midX, midY;
	  
	  if(draw == 0)
	   
	   page.drawLine(startX, startY, endX, endY);
	  else{
	   
	   midX = (startX + endX) / 2 + (startY - endY) / 2;
	   midY = (endX - startX) / 2 + (startY + endY) / 2;
	   drawFractal(draw - 1, startX, startY, midX, midY, page);
	   drawFractal(draw - 1, midX, midY, endX, endY, page);
	  }
	 }
	
	public void paintComponent(Graphics page){
        
        super.paintComponent(page);
        
        page.setColor(Color.WHITE);
        
        drawFractal(current, cX1, cY1, cX2, cY2, page);
        MAX = curveMax;
    }
	public void setBackground(Color g){
		  
		  color = g;
	  }
    public void setOrder(int order)
    {
		 current = order;
	}
	public int getOrder() {
		
		return current;
	}
	 
}