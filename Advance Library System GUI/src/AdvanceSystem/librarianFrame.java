package AdvanceSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class librarianFrame extends JFrame {

	static int bookOne = 5;
	static int bookTwo = 5;
	static int bookThree = 5;

	static Font buttonFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 15);
	static Icon focusIcon = new ImageIcon("focus.png");

	static boolean firstBook = false;
	static boolean secondBook = false;
	static boolean thirdBook = false;

	static JLabel copiesLabel = new JLabel();

	static JLabel book1 = new JLabel("Baka Sakali"), book2 = new JLabel("Against the heart"),
			book3 = new JLabel("Chasing the Sun");

	public librarianFrame() {
		librarianScreen();
	}

	public static void librarianScreen() {

		JFrame frame = new JFrame("Librarian Panel");
		frame.setSize(616, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

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

		Font labelFont = new Font("Poppins Medium", Font.TRUETYPE_FONT, 14);
		loginFrame get = new loginFrame();
		String text = get.getText();

		JLabel userLabel = new JLabel("Hi " + text + ",");
		userLabel.setFont(labelFont);
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(59, 25, 468, 54);
		frame.getContentPane().add(userLabel);
//---------------------------------------------------------------------------------------------------------------------			
		Font bookFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 14);

		book1.setFont(bookFont);
		book1.setForeground(Color.WHITE);
		book1.setHorizontalAlignment(JTextField.CENTER);
		book1.setBounds(48, 393, 150, 30);
		frame.getContentPane().add(book1);

		book2.setFont(bookFont);
		book2.setForeground(Color.WHITE);
		book2.setHorizontalAlignment(JTextField.CENTER);
		book2.setBounds(226, 393, 150, 30);
		frame.getContentPane().add(book2);

		book3.setFont(bookFont);
		book3.setForeground(Color.WHITE);
		book3.setHorizontalAlignment(JTextField.CENTER);
		book3.setBounds(401, 393, 150, 30);
		frame.getContentPane().add(book3);
//---------------------------------------------------------------------------------------------------------------------	

		JButton book1Button = new JButton();
		book1Button.setBounds(57, 187, 135, 209);
		book1Button.setBorderPainted(false);
		book1Button.setFocusPainted(false);
		book1Button.setContentAreaFilled(false);
		book1Button.setOpaque(false);
		frame.add(book1Button);

		JButton book2Button = new JButton();
		book2Button.setBounds(234, 187, 135, 209);
		book2Button.setBorderPainted(false);
		book2Button.setFocusPainted(false);
		book2Button.setContentAreaFilled(false);
		book2Button.setOpaque(false);
		frame.add(book2Button);

		JButton book3Button = new JButton();
		book3Button.setBounds(409, 187, 135, 209);
		book3Button.setBorderPainted(false);
		book3Button.setFocusPainted(false);
		book3Button.setContentAreaFilled(false);
		book3Button.setOpaque(false);
		frame.add(book3Button);

		book1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				book1Button.setIcon(focusIcon);
				if (bookOne < 1) {
					book1.setText("No Copies Available");
					book1.setForeground(new Color(133, 135, 146));
				}
//				book1.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				book1Button.setIcon(null);
				book1.setText("Baka Sakali");
				book1.setForeground(Color.WHITE);
			}
		});

		book2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				book2Button.setIcon(focusIcon);
				if (bookTwo < 1) {
					book2.setText("No Copies Available");
					book2.setForeground(new Color(133, 135, 146));
				}
//				book2.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				book2Button.setIcon(null);
				book2.setText("Against the heart");
				book2.setForeground(Color.WHITE);
			}
		});

		book3Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				book3Button.setIcon(focusIcon);
				if (bookThree < 1) {
					book3.setText("No Copies Available");
					book3.setForeground(new Color(133, 135, 146));
				}
//				book3.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				book3Button.setIcon(null);
				book3.setText("Chasing the Sun");
				book3.setForeground(Color.WHITE);
			}
		});
//---------------------------------------------------------------------------------------------------------------------

		book1Button.addActionListener(e -> {
			firstBook = true;
			secondBook = false;
			thirdBook = false;
			bookPanel();
			frame.setVisible(false);
		});

		book2Button.addActionListener(e -> {
			secondBook = true;
			firstBook = false;
			thirdBook = false;
			bookPanel();
			frame.setVisible(false);
		});

		book3Button.addActionListener(e -> {
			thirdBook = true;
			secondBook = false;
			firstBook = false;
			bookPanel();
			frame.setVisible(false);
		});

//---------------------------------------------------------------------------------------------------------------------			
		UIManager.put("OptionPane.messageFont", new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 17));
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

//---------------------------------------------------------------------------------------------------------------------	

//---------------------------------------------------------------------------------------------------------------------		

		// Set the background image
		ImageIcon background = new ImageIcon("P1.png");
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, 600, 500);
		frame.getContentPane().add(backgroundLabel);

	}

	public static void bookPanel() {

		JFrame bookFrame = new JFrame("Book Panel");
		bookFrame.setSize(616, 539);
		bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookFrame.setVisible(true);
		bookFrame.setLocationRelativeTo(null);
		bookFrame.getContentPane().setLayout(null);

		JButton backButton = new JButton();
		backButton.setBounds(22, 19, 30, 30);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setOpaque(false);
		bookFrame.add(backButton);

		JButton rentButton = new JButton();
		rentButton.setBounds(238, 204, 317, 45);
		rentButton.setBorderPainted(false);
		rentButton.setFocusPainted(false);
		rentButton.setContentAreaFilled(false);
		rentButton.setOpaque(false);
		bookFrame.add(rentButton);

		backButton.addActionListener(e -> {
			bookFrame.dispose();
			librarianScreen();
		});

//----------------------------------------------------------------------------------------------------------------------------------			
		Font copiesFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 16);

		copiesLabel.setFont(copiesFont);
		copiesLabel.setForeground(new Color(133, 135, 146));
		copiesLabel.setBounds(238, 121, 468, 54);
		bookFrame.getContentPane().add(copiesLabel);

		if (firstBook) {
			copiesLabel.setText("Available Copies: " + bookOne);
			ImageIcon background = new ImageIcon("book1.png");
			JLabel backgroundLabel = new JLabel(background);
			backgroundLabel.setBounds(0, 0, 600, 500);
			bookFrame.getContentPane().add(backgroundLabel);
		} else if (secondBook) {
			copiesLabel.setText("Available Copies: " + bookTwo);
			ImageIcon background = new ImageIcon("book2.png");
			JLabel backgroundLabel = new JLabel(background);
			backgroundLabel.setBounds(0, 0, 600, 500);
			bookFrame.getContentPane().add(backgroundLabel);
		} else if (thirdBook) {
			copiesLabel.setText("Available Copies: " + bookThree);
			ImageIcon background = new ImageIcon("book3.png");
			JLabel backgroundLabel = new JLabel(background);
			backgroundLabel.setBounds(0, 0, 600, 500);
			bookFrame.getContentPane().add(backgroundLabel);
		}

//----------------------------------------------------------------------------------------------------------------------------------		

		JButton ok = new JButton("Ok");
		ok.setFont(buttonFont);
		ok.setBackground(Color.WHITE);
		ok.setFocusPainted(false);
		ok.setBorderPainted(true);

		Object[] options2 = { ok };

		JButton rent = new JButton("Rent");
		rent.setFont(buttonFont);
		rent.setBackground(Color.WHITE);
		rent.setFocusPainted(false);
		rent.setBorderPainted(true);

		JButton noC = new JButton("No");
		noC.setFont(buttonFont);
		noC.setBackground(Color.WHITE);
		noC.setFocusPainted(false);
		noC.setBorderPainted(true);

		Object[] options = { rent, noC };
		String B1 = "Baka Sakali";
		String B2 = "Against the heart";
		String B3 = "Chasing the Sun";

		rentButton.addActionListener(e -> {
			if (firstBook && bookOne >= 1) {
				JOptionPane pane = new JOptionPane("Are you sure you want to rent " + B1 + "?",
						JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options);
				JDialog dialog = pane.createDialog("Rent confirmation");
				ActionListener rentListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						success();
						bookOne -= 1;
						bookFrame.dispose();
						librarianScreen();
					}
				};
				rent.addActionListener(rentListener);
				ActionListener noListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						rent.removeActionListener(rentListener);
					}
				};
				noC.addActionListener(noListener);
				dialog.setVisible(true);
				dialog.dispose();
			} else if (secondBook && bookTwo >= 1) {
				JOptionPane pane = new JOptionPane("Are you sure you want to rent " + B2 + "?",
						JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options);
				JDialog dialog = pane.createDialog("Rent confirmation");
				ActionListener rentListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						success();
						bookTwo -= 1;
						bookFrame.dispose();
						librarianScreen();
					}
				};
				rent.addActionListener(rentListener);
				ActionListener noListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						rent.removeActionListener(rentListener);
					}
				};
				noC.addActionListener(noListener);
				dialog.setVisible(true);
				dialog.dispose();
			} else if (thirdBook && bookThree >= 1) {
				JOptionPane pane = new JOptionPane("Are you sure you want to rent " + B3 + "?",
						JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options);
				JDialog dialog = pane.createDialog("Rent confirmation");
				ActionListener rentListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						success();
						bookThree -= 1;
						bookFrame.dispose();
						librarianScreen();
					}
				};
				rent.addActionListener(rentListener);
				ActionListener noListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						rent.removeActionListener(rentListener);
					}
				};
				noC.addActionListener(noListener);
				dialog.setVisible(true);
				dialog.dispose();
			} else {
				JOptionPane pane = new JOptionPane("        No Copies Available", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, options2);

				JDialog dialog = pane.createDialog("Sorry");
				dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

				ok.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				dialog.setVisible(true);

			}
		});
	}

	public static void success() {
		JButton exit = new JButton("Exit");
		exit.setFont(buttonFont);
		exit.setBackground(Color.WHITE);
		exit.setFocusPainted(false);
		exit.setBorderPainted(true);

		Object[] options2 = { exit };

		JOptionPane pane = new JOptionPane("   Book rented successfully!", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options2);

		JDialog dialog = pane.createDialog("Success");
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		dialog.setVisible(true);
	}
}
