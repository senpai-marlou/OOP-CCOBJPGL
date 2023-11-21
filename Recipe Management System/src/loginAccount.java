
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class loginAccount {

	private JPanel loginAccount;
	private JLayeredPane layeredPane = new JLayeredPane();

	public static JTextField usernameField;
	private JPasswordField passwordField;

	private int loginTimes = 0;

	static boolean clicked = false;

	@SuppressWarnings("removal")
	public loginAccount() {
		// Initialize the JPanel instance
		loginAccount = new JPanel();

		loginAccount.setLayout(null);
		loginAccount.setBounds(1351, 184, 445, 474);
		loginAccount.setOpaque(false);
		loginAccount.setVisible(true);

		// Layered Pane
		layeredPane.setSize(loginAccount.getSize());
		loginAccount.add(layeredPane);

		// Background
		JLabel loginAccBG = new JLabel(new ImageIcon("loginBack.png"));
		loginAccBG.setBounds(0, 0, 445, 474);

		// Front Background
		JLabel loginAccFront = new JLabel(new ImageIcon("loginFront.png"));
		loginAccFront.setBounds(0, 0, 445, 474);

		// Buttons
		JButton loginAccButton = new JButton();
		loginAccButton.setBorderPainted(false);
		loginAccButton.setContentAreaFilled(false);
		loginAccButton.setOpaque(false);
		loginAccButton.setBounds(51, 302, 341, 51);

		JButton toSignAcc = new JButton();
		toSignAcc.setBorderPainted(false);
		toSignAcc.setContentAreaFilled(false);
		toSignAcc.setOpaque(false);
		toSignAcc.setBounds(285, 384, 62, 18);

		toSignAcc.addActionListener(e -> {
			mainScreen.createAccountB.doClick();
			Timer timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					// Resets All Values
					usernameField.setText("");
					passwordField.setText("");
				}
			});
			timer.setRepeats(false);
			timer.start();
		});

// Text Field -----------------------------------------------------------------------------------------------

		usernameField = new JTextField(20) { // Text Field "Full Name"

			@Override
			protected void paintComponent(Graphics g) {
				createAccount.paintRoundedComponent(g, this);
				super.paintComponent(g);
			}
		};

		usernameField.setOpaque(false);
		usernameField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		usernameField.setFont(createAccount.font);
		usernameField.setMaximumSize(new Dimension(500, 60));
		usernameField.setBounds(50, 148, 342, 53);

		((AbstractDocument) usernameField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

// Password Field --------------------------------------------------------------------------------------------

		passwordField = new JPasswordField(20) { // CreateAcc password field "Password"
			@Override
			protected void paintComponent(Graphics g) {
				createAccount.paintRoundedComponent(g, this);
				super.paintComponent(g);
			}
		};
		passwordField.setOpaque(false);
		passwordField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		passwordField.setFont(createAccount.font);
		passwordField.setMaximumSize(new Dimension(500, 60));
		passwordField.setBounds(50, 224, 342, 53);

		((AbstractDocument) passwordField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		// Hide | Show Icon
		ImageIcon hideIcon = new ImageIcon("hide.png");
		ImageIcon showIcon = new ImageIcon("show.png");
		ImageIcon passwordIconn = new ImageIcon("password.png");

		JLabel passwordIconLabel = new JLabel(passwordIconn);
		passwordIconLabel.setOpaque(false);
		passwordIconLabel.setBounds(343, 229, 43, 43);

		JButton hideIconB = new JButton(hideIcon);
		hideIconB.setBorderPainted(false);
		hideIconB.setContentAreaFilled(false);
		hideIconB.setOpaque(false);
		hideIconB.setBounds(343, 229, 43, 43);
		hideIconB.setVisible(false);

		// Hide | Show Icon feature
		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordIconLabel.setVisible(false);
				hideIconB.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				hideIconB.setVisible(false);
				// Delay so it dosen't overlaps
				Timer timer = new Timer(10, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						passwordIconLabel.setVisible(true);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});
		hideIconB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (clicked) {
					hideIconB.setIcon(hideIcon);
					clicked = false;
					passwordField.setEchoChar('•');
				} else {
					hideIconB.setIcon(showIcon);
					clicked = true;
					passwordField.setEchoChar((char) 0);
				}
			}
		});

// Login button validation ----------------------------------------------------------------------------------

		loginAccButton.addActionListener(e -> {

			JButton okButton = new JButton("OK");
			okButton.setFont(createAccount.buttonFont);
			okButton.setBackground(Color.WHITE);
			okButton.setFocusPainted(false);
			okButton.setBorderPainted(true);

			JButton signUpButton = new JButton("Sign Up");
			signUpButton.setFont(createAccount.buttonFont);
			signUpButton.setBackground(Color.WHITE);
			signUpButton.setFocusPainted(false);
			signUpButton.setBorderPainted(true);

			Object[] options = { okButton };
			Object[] options2 = { okButton, signUpButton };

			// Set the font for the option pane
			UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));

			String usernameLogin = usernameField.getText();
			String passwordLogin = new String(passwordField.getPassword());

			if (usernameLogin.equals("") && passwordLogin.equals("")) {
				JOptionPane pane = new JOptionPane("Enter your Username & Password", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, options);

				JDialog dialog = pane.createDialog("Input Error");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				dialog.setVisible(true);
			} else if (usernameLogin.equals("")) {
				JOptionPane pane = new JOptionPane("Please enter your Username", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, options);

				JDialog dialog = pane.createDialog("Input Error");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				dialog.setVisible(true);
			} else if (createAccount.loginUsername.contains(usernameLogin)
					&& createAccount.loginPassword.contains(passwordLogin)) {
//				usernameField.setText("");
				passwordField.setText("");

				// Login Interface done !!!
				// Codes to Dash board here........................
//				dashboardScreen.createDashboard();
				if (loginTimes < 1) {
					dashboardScreen.createDashboard();
					loginTimes++;
					dashboardScreen.name.setText(usernameLogin);
					usernameField.setText("");
				} else {
					dashboardScreen.dashboardFrame.setVisible(true);
					dashboardScreen.name.setText(usernameLogin);
					usernameField.setText("");
				}
				mainScreen.mainFrame.setVisible(false);
				System.out.println("To Dashboard!");

			} else if (createAccount.loginUsername.contains(usernameLogin)
					&& !(createAccount.loginPassword.contains(passwordLogin))) {
				JOptionPane pane = new JOptionPane("Incorrect Password", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, options);

				JDialog dialog = pane.createDialog("Error");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						passwordField.setText("");
						dialog.dispose();
					}
				});
				dialog.setVisible(true);
			} else {
				JOptionPane pane = new JOptionPane("Account doesn't exist", JOptionPane.OK_OPTION,
						JOptionPane.ERROR_MESSAGE, null, options2);

				JDialog dialog = pane.createDialog("Error");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						usernameField.setText("");
						passwordField.setText("");
						dialog.dispose();
					}
				});

				signUpButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						toSignAcc.doClick();
					}
				});
				dialog.setVisible(true);
			}

		});

// ----------------------------------------------------------------------------------------------------------
		// Add cursor
		loginAccButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toSignAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Layers
		layeredPane.add(loginAccBG, new Integer(0));

		// Text Field && Password Field (Username and Password)
		layeredPane.add(usernameField, new Integer(1));
		layeredPane.add(passwordField, new Integer(1));

		// Buttons || Labels
		layeredPane.add(loginAccButton, new Integer(2));
		layeredPane.add(toSignAcc, new Integer(2));
		layeredPane.add(hideIconB, new Integer(2));
		layeredPane.add(passwordIconLabel, new Integer(2));

		//
		layeredPane.add(loginAccFront, new Integer(2));
	}

// Document Filters -------------------------------------------------------------------------------------------	

	private static DocumentFilter createSpaceRemoverFilter() { // Super Advance Code "Removes Spaces"
		return new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				fb.insertString(offset, string.replaceAll("\\s+", ""), attr);
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
					throws BadLocationException {
				fb.replace(offset, length, string.replaceAll("\\s+", ""), attrs);
			}
		};
	}

	public JPanel getloginAccount() {
		return loginAccount;
	}

}
