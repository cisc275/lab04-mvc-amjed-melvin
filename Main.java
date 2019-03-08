import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
	    final int frameWidth = 500;
	    final int frameHeight = 300;
		JFrame frame = new JFrame();
		View view = new View();
        frame.getContentPane().add(new View());
        frame.setBackground(Color.gray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        for(int i = 0; i < 1000; i++){
            frame.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
