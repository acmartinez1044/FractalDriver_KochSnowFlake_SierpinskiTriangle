import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * Program that draws Koch Flake
 * @author Antonio Martinez
 * @Version 1.0
 */
public class KochSnowFlakes extends JPanel implements ActionListener
{
	
	  KochSnowFlakesPanel KochSnowFlakesPanel = new KochSnowFlakesPanel(0);
	  JPanel controlPanel = new JPanel();
	  JButton levelButton = new JButton();
	  JButton increase, decrease;
	  JLabel titleLabel, orderLabel;
	  JTextField levelTextField = new JTextField();
	  private final int MIN=0,MAX=10;
	  

	  /**Constructor**/
	  public KochSnowFlakes() {
		  
		    setSize(new Dimension(500,560));
		    setLayout(new BorderLayout());
		  
		    add(KochSnowFlakesPanel, BorderLayout.CENTER);
		    
		    titleLabel = new JLabel("Koch SnowFlake");
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
	    int order = KochSnowFlakesPanel.getOrder();
	    
	    if(e.getSource()== increase)
	    	order++;
	    else
	    	order--;
	    
	    if(order>=MIN && order <= MAX)
	    {
	    	orderLabel.setText("Order: " + order);
	    	KochSnowFlakesPanel.setOrder(order);
	    	repaint();
	    }
	  }
	}


