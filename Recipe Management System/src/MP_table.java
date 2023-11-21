import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MP_table extends JTable {

	public MP_table(DefaultTableModel model) {
		super(model);
		setForeground(new Color(100, 100, 100));
		setFont(new Font("Open Sans SemiBold", Font.TRUETYPE_FONT, 14));
		setFocusable(false);
		setShowGrid(false);
		setEnabled(false);
	}
}
