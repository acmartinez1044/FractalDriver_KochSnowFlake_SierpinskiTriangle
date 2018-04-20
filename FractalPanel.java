import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * Program that compiles all the fractals together
 * @author Antonio Martinez
 * @Version 1.0
 */
public class FractalPanel extends JPanel {

	private JRadioButton Red, Blue, Black;
	private Color color;
	SierpinskiTriangle sp = new SierpinskiTriangle();
	KochSnowFlakes kf = new KochSnowFlakes();
	CCurve cc = new CCurve();
	
	public FractalPanel(){

    cc.setBackground(Color.GREEN);
    sp.setBackground(Color.GREEN);
    kf.setBackground(Color.GREEN);
		
	setLayout(new BorderLayout());
	
	JPanel panel = new JPanel();
	Red = new JRadioButton("Red");
	Blue = new JRadioButton("Blue");
	Black = new JRadioButton("Black");
	
	ButtonGroup group = new ButtonGroup();
	group.add(Red);
	group.add(Blue);
	group.add(Black);
	
	Red.addActionListener(new ColorListener());
	Blue.addActionListener(new ColorListener());
	Black.addActionListener(new ColorListener());
	
	panel.add(Red);
	panel.add(Blue);
	panel.add(Black);
	add(panel, BorderLayout.NORTH);
	
	
	JTabbedPane tp = new JTabbedPane();
	tp.addTab("Sierpinski Triangle", sp);
	tp.addTab("Koch SnowFlake", kf);
	tp.addTab(" \"C\" Curve", cc);
	add(tp, BorderLayout.CENTER);
	
	}
	public class ColorListener implements ActionListener{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();
		
			if(source == Red)
			{
				cc.setBackground(Color.RED);
				sp.setBackground(Color.RED);
				kf.setBackground(Color.RED);
			}
			else
			{	
				if(source == Blue){
					cc.setBackground(Color.BLUE);
					sp.setBackground(Color.BLUE);
					kf.setBackground(Color.BLUE);
				}
				else{
					cc.setBackground(Color.BLACK);
					sp.setBackground(Color.BLACK);
					kf.setBackground(Color.BLACK);
				}
			}
	    }
	}
}
