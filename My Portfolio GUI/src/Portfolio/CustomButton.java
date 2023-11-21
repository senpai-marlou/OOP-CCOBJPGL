package Portfolio;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// Parent/Super Class
public class CustomButton extends JButton {

	static ImageIcon gamingImage = new ImageIcon("gaming.png");
	static ImageIcon codingImage = new ImageIcon("coding.png");
	static ImageIcon moviesImage = new ImageIcon("movies.png");

	// Common properties or methods for the buttons
	public CustomButton() {
		// Common initialization code
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	void onClick() {
		System.out.println("Override this method");
	}
}
