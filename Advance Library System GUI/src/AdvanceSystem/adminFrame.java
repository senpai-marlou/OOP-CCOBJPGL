package AdvanceSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class adminFrame extends JFrame {

	static Font buttonFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 15);

	public adminFrame() {
		adminScreen();
	}

	public static void adminScreen() {

		JFrame frame = new JFrame("Admin Panel");
		frame.setSize(616, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		Font labelFont = new Font("Poppins Medium", Font.TRUETYPE_FONT, 15);

		loginFrame get = new loginFrame();
		String text = get.getText();

		JLabel loginAccountLabel = new JLabel("Hi " + text + ",");
		loginAccountLabel.setFont(labelFont);
		loginAccountLabel.setForeground(Color.WHITE);
		loginAccountLabel.setBounds(34, 216, 468, 54);
		frame.getContentPane().add(loginAccountLabel);

		JButton logoutButton = new JButton();
		logoutButton.setBounds(549, 19, 30, 30);
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setOpaque(false);
		frame.add(logoutButton);

		JButton logoutC = new JButton("Logout");
		logoutC.setFont(buttonFont);
		logoutC.setBackground(Color.WHITE);
		logoutC.setFocusPainted(false);
		logoutC.setBorderPainted(true);

		JButton noC = new JButton("No");
		noC.setFont(buttonFont);
		noC.setBackground(Color.WHITE);
		noC.setFocusPainted(false);
		noC.setBorderPainted(true);

		UIManager.put("OptionPane.message", new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 17));
		logoutButton.addActionListener(e -> {
			Object[] options = { logoutC, noC };
			JOptionPane pane = new JOptionPane("Are you sure you want to Logout?", JOptionPane.QUESTION_MESSAGE,
					JOptionPane.YES_NO_OPTION, null, options);
			JDialog dialog = pane.createDialog("Logout confirmation");

			ActionListener logoutListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					dialog.dispose();
					loginFrame.loginScreen();
				}
			};
			logoutC.addActionListener(logoutListener);

			ActionListener noListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
					logoutC.removeActionListener(logoutListener);
				}
			};
			noC.addActionListener(noListener);

			dialog.setVisible(true);
			dialog.dispose();
		});

		// Set the background image
		ImageIcon background = new ImageIcon("adminBG.png");
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, 600, 500);
		frame.getContentPane().add(backgroundLabel);

	}
}
