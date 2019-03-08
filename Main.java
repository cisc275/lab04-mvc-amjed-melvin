import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel{
	public static void main(String[] args) {
	    final int frameWidth = 500;
	    final int frameHeight = 300;
		JFrame frame = new JFrame();
        frame.getContentPane().add(new View(frame));
        frame.setBackground(Color.gray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        Controller ctrl = new Controller();
        ctrl.start();
    }
}
