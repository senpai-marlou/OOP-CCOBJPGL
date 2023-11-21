import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class R_textFields extends JTextField {

	static Font generalF = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 16);

	public R_textFields() {
		setFont(generalF);
		setForeground(new Color(100, 100, 100));
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
//		setBorder(null);
		setOpaque(false);
		putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

}
