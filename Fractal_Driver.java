import java.awt.*;
import javax.swing.*;

import javax.swing.*;
/**
 * Main Driver
 * @author Antonio Martinez
 * @Version 1.0
 */
public class Fractal_Driver {
	public static void main(String[]args){
		JFrame frame = new JFrame();
		FractalPanel driver = new FractalPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600,700));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().add(driver);
		frame.pack();
		
		}

}
