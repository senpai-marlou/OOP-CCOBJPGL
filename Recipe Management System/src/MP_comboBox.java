import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class MP_comboBox extends JComboBox<String> {

	// ComboBoxs
	static JComboBox<String> sundayBreakfast = new MP_comboBox();
	static JComboBox<String> sundayLunch = new MP_comboBox();
	static JComboBox<String> sundaySnacks = new MP_comboBox();
	static JComboBox<String> sundayDinner = new MP_comboBox();

	static JComboBox<String> mondayBreakfast = new JComboBox<>();
	static JComboBox<String> mondayLunch = new JComboBox<>();
	static JComboBox<String> mondaySnacks = new JComboBox<>();
	static JComboBox<String> mondayDinner = new JComboBox<>();

	static JComboBox<String> tuesdayBreakfast = new JComboBox<>();
	static JComboBox<String> tuesdayLunch = new JComboBox<>();
	static JComboBox<String> tuesdaySnacks = new JComboBox<>();
	static JComboBox<String> tuesdayDinner = new JComboBox<>();

	static JComboBox<String> wednesdayBreakfast = new JComboBox<>();
	static JComboBox<String> wednesdayLunch = new JComboBox<>();
	static JComboBox<String> wednesdaySnacks = new JComboBox<>();
	static JComboBox<String> wednesdayDinner = new JComboBox<>();

	static JComboBox<String> thursdayBreakfast = new JComboBox<>();
	static JComboBox<String> thursdayLunch = new JComboBox<>();
	static JComboBox<String> thursdaySnacks = new JComboBox<>();
	static JComboBox<String> thursdayDinner = new JComboBox<>();

	static JComboBox<String> fridayBreakfast = new JComboBox<>();
	static JComboBox<String> fridayLunch = new JComboBox<>();
	static JComboBox<String> fridaySnacks = new JComboBox<>();
	static JComboBox<String> fridayDinner = new JComboBox<>();

	static JComboBox<String> saturdayBreakfast = new JComboBox<>();
	static JComboBox<String> saturdayLunch = new JComboBox<>();
	static JComboBox<String> saturdaySnacks = new JComboBox<>();
	static JComboBox<String> saturdayDinner = new JComboBox<>();

	static ImageIcon dropDown = new ImageIcon("greenArrow.png");

	public MP_comboBox() {
		setUI(new BasicComboBoxUI() {
			@Override
			protected JButton createArrowButton() {
				// Edit a arrow down Button icon
				JButton button = new JButton(dropDown);
				button.setOpaque(false);
				button.setContentAreaFilled(false);
				button.setBorderPainted(false);
				return button;
			}
		});
		setFocusable(false);
		setBackground(Color.WHITE);
		setForeground(new Color(17, 130, 59));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setFont(new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 18));
	}
}
