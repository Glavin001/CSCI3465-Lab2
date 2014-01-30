import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create and set up the window.
        JFrame frame = new JFrame("Lab 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        //contentPane.setLayout(new FlowLayout());
        
        // 
        Box b = new Box();
        b.setDefaultColor(Color.YELLOW);
        b.setHoverColor(Color.RED);
        b.setSize(100,100);
        b.setBounds(10,10,100,100);
        contentPane.add(b);

        Box b2 = new Box();
        b2.setDefaultColor(Color.CYAN);
        b2.setHoverColor(Color.PINK);
        b2.setSize(100,100);
        b2.setBounds(20,20,100,100);
        contentPane.add(b2);
        
        // Display the window.
        //frame.pack();
        frame.setSize(250, 200);
        frame.setResizable(true);
        frame.setVisible(true);
        
	}

}
