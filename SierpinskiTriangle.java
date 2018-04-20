import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Program that draws Sierpinski Triangle
 * @author Antonio Martinez
 * @Version 1.0
 */
public class SierpinskiTriangle extends JPanel implements ActionListener
{
	
  SierpinskiTrianglePanel sierpinskiTrianglePanel = new SierpinskiTrianglePanel(0);
  JPanel controlPanel = new JPanel();
  JButton levelButton = new JButton();
  JButton increase, decrease;
  JLabel titleLabel, orderLabel;
  JTextField levelTextField = new JTextField();
  private final int MIN=0,MAX=10;


  /**Constructor**/
  public SierpinskiTriangle() {
	  
	    setSize(new Dimension(500,560));
	    setLayout(new BorderLayout());
	    
	    
	    add(sierpinskiTrianglePanel, BorderLayout.CENTER);
	    
	    titleLabel = new JLabel("The Sierpinski Triangle");
	    titleLabel.setForeground(Color.BLACK);
	    
	    increase = new JButton (new ImageIcon ("up.gif"));
	    increase.setPressedIcon (new ImageIcon ("up.gif"));
	    increase.setMargin(new Insets(0,0,0,0));
	    increase.addActionListener(this);
	    decrease = new JButton (new ImageIcon ("down.gif"));
	    decrease.setPressedIcon (new ImageIcon ("down.gif"));
	    decrease.setMargin(new Insets(0,0,0,0));
	    decrease.addActionListener(this);
	    
	    orderLabel = new JLabel ("Order: 0");
	    orderLabel.setForeground(Color.BLACK);
	    
	    controlPanel.setLayout(new FlowLayout());
	    controlPanel.add(titleLabel);
	    controlPanel.add(increase);
	    controlPanel.add(decrease);
	    controlPanel.add(orderLabel);
	    add(controlPanel, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
   // Change recursion level when the button is clicked
    int order = sierpinskiTrianglePanel.getOrder();
    
    if(e.getSource()== increase)
    	order++;
    else
    	order--;
    
    if(order>=MIN && order <= MAX)
    {
    	orderLabel.setText("Order: " + order);
    	sierpinskiTrianglePanel.changeLevel(order);

    }
  }
}