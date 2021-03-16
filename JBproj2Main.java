package JBproj2;

import javax.swing.JFrame;

public class JBproj2Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JBproj2Panel panel = new JBproj2Panel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
