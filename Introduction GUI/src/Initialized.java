
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Initialized extends JFrame {

	private ArrayList<String> loginUsername = new ArrayList<String>();
	private ArrayList<String> loginPassword = new ArrayList<String>();
	// Icons
	ImageIcon loginIcon = new ImageIcon("ImageLog.png"), createIcon = new ImageIcon("create.png"),
			uncheckIcon = new ImageIcon("uncheck.png"), checkIcon = new ImageIcon("check1.png"),
			greenIcon = new ImageIcon("greenIcon.png"), redIcon = new ImageIcon("redIcon.png"),
			confirmIcon = new ImageIcon("confirmIcon.png"), hideIcon = new ImageIcon("hide.png"),
			showIcon = new ImageIcon("show.png"), usernameIcon = new ImageIcon("usernameIcon.png"),
			passwordIcon = new ImageIcon("passwordIcon.png");
	// Labels
	JLabel iconLabelLogin, iconLabelCreate, iconLabelUncheck, iconLabelCheck, green = new JLabel(greenIcon),
			red = new JLabel(redIcon), confirmIconLabel = new JLabel(confirmIcon);
	// Fonts
	Font labelFont = new Font("Open Sans Bold", Font.TRUETYPE_FONT, 35),
			normalFont = new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15),
			font = new Font("Open Sans SemiBold", Font.TRUETYPE_FONT, 20);
	// Colors, Booleans, PasswordField, Buttons
	Color passwordColor = Color.GRAY, confirmColor = Color.GRAY;
	boolean clicked = false, clicked2 = false, clicked3 = false;
	JPasswordField PasswordField, ConfirmPasswordField;
	JButton loginButton, createButton, clickButton;
	// Others
	JPanel confirm = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initialized frame = new Initialized();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Initialized() {
		Login();
	}

	@SuppressWarnings("removal")
	public void Login() {

		setTitle("Login Account Panel"); // Login Account Panel
		setSize(800, 820);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(getSize());
		add(layeredPane);

		JLabel loginAccountLabel = new JLabel("Login Account");
		loginAccountLabel.setFont(labelFont);
		loginAccountLabel.setBounds(156, 195, 468, 54);
		loginAccountLabel.setHorizontalAlignment(JTextField.CENTER);
		getContentPane().add(loginAccountLabel);

		JLabel dontHave = new JLabel("Don't have an account? ");
		dontHave.setFont(normalFont);
		dontHave.setForeground(Color.GRAY);
		dontHave.setBounds(267, 530, 468, 54);
		getContentPane().add(dontHave);

		// Create ImageIcon object
		iconLabelLogin = new JLabel();
		iconLabelLogin.setIcon(loginIcon);
		loginButton = new JButton(loginIcon);
		loginButton.setBounds(200, 455, 380, 70);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setOpaque(false);
		getContentPane().add(loginButton);

		JLabel usernameLabel = new JLabel("  Username");
		usernameLabel.setFont(normalFont);

		JPanel usernameLabelPanel = new JPanel();
		usernameLabelPanel.setBackground(Color.WHITE);
		usernameLabelPanel.setLayout(new BoxLayout(usernameLabelPanel, BoxLayout.PAGE_AXIS));
		usernameLabelPanel.add(usernameLabel);
		usernameLabelPanel.setBounds(231, 283, 95, 23);

		JLabel passwordLabel = new JLabel("  Password");
		passwordLabel.setFont(normalFont);

		JPanel passwordLabelPanel = new JPanel();
		passwordLabelPanel.setBackground(Color.WHITE);
		passwordLabelPanel.setLayout(new BoxLayout(passwordLabelPanel, BoxLayout.PAGE_AXIS));
		passwordLabelPanel.add(passwordLabel);
		passwordLabelPanel.setBounds(231, 370, 90, 23);

		JLabel signUp = new JLabel("Sign Up"); // Initialized - Label to Create Account
		signUp.setFont(normalFont);
		signUp.setBounds(452, 537, 70, 40);
		getContentPane().add(signUp);

		JPanel username = new JPanel(); // User name Icon
		JLabel userLabel = new JLabel(usernameIcon);
		username.add(userLabel);
		username.setOpaque(false);
		username.setLayout(new BoxLayout(username, BoxLayout.PAGE_AXIS));
		username.setBounds(522, 300, 44, 45);

		JPanel password = new JPanel(); // Password Icon
		JLabel passwordIconLabel = new JLabel(passwordIcon);
		password.add(passwordIconLabel);
		password.setOpaque(false);
		password.setLayout(new BoxLayout(password, BoxLayout.PAGE_AXIS));
		password.setBounds(522, 387, 44, 51);

// Rounded Text Field - for Login Account ----------------------------------------------------------

		@SuppressWarnings("serial")
		JTextField roundedTextField1 = new JTextField(20) { // Login text field "Username"
			@Override
			protected void paintComponent(Graphics g) {
				paintRoundedComponent(g, this); // draw the rounded border
				super.paintComponent(g); // call the superclass implementation to render text field's contents
			}
		};

		roundedTextField1.setOpaque(false);
		roundedTextField1.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		((AbstractDocument) roundedTextField1.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		roundedTextField1.setFont(font);

		// Set maximum size (So the TextField dosen't enlarge.)
		roundedTextField1.setMaximumSize(new Dimension(500, 60));

		JPanel roundedTextFieldPanel = new JPanel();

		roundedTextFieldPanel.setBackground(Color.WHITE);
		roundedTextFieldPanel.setLayout(new BoxLayout(roundedTextFieldPanel, BoxLayout.PAGE_AXIS));
		roundedTextFieldPanel.add(roundedTextField1);
		roundedTextFieldPanel.add(Box.createVerticalGlue());
		roundedTextFieldPanel.setBounds(207, 295, 365, 60);
		layeredPane.add(username, new Integer(0));
		layeredPane.add(roundedTextFieldPanel, new Integer(0));
		layeredPane.add(usernameLabelPanel, new Integer(1));

		@SuppressWarnings("serial")
		JPasswordField roundedPasswordField = new JPasswordField(20) { // Login Password field "Password"
			@Override
			protected void paintComponent(Graphics g) {
				paintRoundedComponent(g, this);
				super.paintComponent(g);
			}
		};
		roundedPasswordField.setOpaque(false);
		roundedPasswordField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));

		((AbstractDocument) roundedPasswordField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		roundedPasswordField.setFont(font);
		roundedPasswordField.setMaximumSize(new Dimension(500, 60));

		JPanel roundedPasswordFieldPanel = new JPanel();
		roundedPasswordFieldPanel.setBackground(Color.WHITE);
		roundedPasswordFieldPanel.setLayout(new BoxLayout(roundedPasswordFieldPanel, BoxLayout.PAGE_AXIS));
		roundedPasswordFieldPanel.add(roundedPasswordField);
		roundedPasswordFieldPanel.add(Box.createVerticalGlue());

		roundedPasswordFieldPanel.setBounds(207, 382, 365, 60);
		layeredPane.add(password, new Integer(2));
		layeredPane.add(roundedPasswordFieldPanel, new Integer(2));
		layeredPane.add(passwordLabelPanel, new Integer(3));

		JButton hide = new JButton(hideIcon);
		hide.setBorderPainted(false);
		hide.setContentAreaFilled(false);
		hide.setOpaque(false);

		hide.setVisible(false);
		password.add(hide);

		roundedPasswordField.addFocusListener(new FocusListener() { // Add a FocusListener to the JTextField
			@Override
			public void focusGained(FocusEvent e) {
				passwordIconLabel.setVisible(false);
				hide.setVisible(true);
				password.setBounds(522, 382, 44, 51);
			}

			@Override
			public void focusLost(FocusEvent e) {
				hide.setVisible(false);
				passwordIconLabel.setVisible(true);
				password.setBounds(522, 387, 44, 51);

			}
		});
		hide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (clicked2) {
					hide.setIcon(hideIcon);
					clicked2 = false;
					roundedPasswordField.setEchoChar('•');
				} else {
					hide.setIcon(showIcon);
					clicked2 = true;
					roundedPasswordField.setEchoChar((char) 0);
				}
			}
		});
		loginButton.addActionListener(e -> {
			// Set the font for the option pane
			UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));

			String usernameLogin = roundedTextField1.getText();
			String passwordLogin = new String(roundedPasswordField.getPassword());

			if (loginUsername.contains(usernameLogin) && loginPassword.contains(passwordLogin)) {
				roundedTextField1.setText("");
				roundedPasswordField.setText("");
				dispose();
				createMain();
			} else if (loginUsername.contains(usernameLogin) && !(loginPassword.contains(passwordLogin))) {
				JOptionPane.showMessageDialog(null, "Incorect Password", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Account doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		});
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				roundedTextField1.setText("");
				roundedPasswordField.setText("");
				createAccount();
				dispose();
			}
		});
		// Background Image for Login
		ImageIcon background = new ImageIcon("f1.png");
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, 780, 780);
		getContentPane().add(backgroundLabel);
	}

//--------------------------------------------------------------------------------------------------------	

	@SuppressWarnings({ "removal", "serial" })
	public void createAccount() {

		JFrame createAccount = new JFrame("Create Account Panel"); // Create Account Panel
		createAccount.getContentPane().setLayout(null);
		createAccount.setSize(800, 820);
		createAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createAccount.setLocationRelativeTo(null);
		createAccount.setVisible(true);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(getSize());
		createAccount.add(layeredPane);

		JLabel loginlLabel = new JLabel("Login"); // Initialized - to Login Account
		loginlLabel.setFont(normalFont);
		loginlLabel.setBounds(472, 649, 70, 40);
		createAccount.getContentPane().add(loginlLabel);

		loginlLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked = false;
				clickButton.setIcon(uncheckIcon);
				passwordColor = Color.GRAY;
				confirmColor = Color.GRAY;
				green.setVisible(false);
				red.setVisible(false);
				confirmIconLabel.setVisible(true);

				Login();
				createAccount.dispose();
			}
		});

		JLabel loginAccountLabel = new JLabel("Create Account");
		loginAccountLabel.setFont(labelFont);
		loginAccountLabel.setBounds(156, 94, 468, 54);
		loginAccountLabel.setHorizontalAlignment(JTextField.CENTER);
		createAccount.getContentPane().add(loginAccountLabel);

		JLabel alreadyHave = new JLabel("Already have an account? ");
		alreadyHave.setFont(normalFont);
		alreadyHave.setForeground(Color.GRAY);
		alreadyHave.setBounds(269, 642, 468, 54);
		createAccount.getContentPane().add(alreadyHave);

//      Create ImageIcon object
		iconLabelCreate = new JLabel();
		iconLabelCreate.setIcon(createIcon);

		createButton = new JButton(createIcon);
		createButton.setBounds(202, 564, 380, 70);
		createButton.setBorderPainted(false);
		createButton.setContentAreaFilled(false);
		createButton.setOpaque(false);
		createAccount.getContentPane().add(createButton);

//		Labels        
		JLabel fullnameLabel = new JLabel("  Full Name ");
		fullnameLabel.setFont(normalFont);

		JPanel fullnameLabelPanel = new JPanel();
		fullnameLabelPanel.setBackground(Color.WHITE);
		fullnameLabelPanel.setLayout(new BoxLayout(fullnameLabelPanel, BoxLayout.PAGE_AXIS));
		fullnameLabelPanel.add(fullnameLabel);
		fullnameLabelPanel.setBounds(231, 174, 95, 23);

		JLabel usernameLabel = new JLabel("  Username ");
		usernameLabel.setFont(normalFont);

		JPanel usernameLabelPanel = new JPanel();
		usernameLabelPanel.setBackground(Color.WHITE);
		usernameLabelPanel.setLayout(new BoxLayout(usernameLabelPanel, BoxLayout.PAGE_AXIS));
		usernameLabelPanel.add(usernameLabel);
		usernameLabelPanel.setBounds(231, 259, 95, 23);

		JLabel passwordLabel = new JLabel("  Password ");
		passwordLabel.setFont(normalFont);

		JPanel passwordLabelPanel = new JPanel();
		passwordLabelPanel.setBackground(Color.WHITE);
		passwordLabelPanel.setLayout(new BoxLayout(passwordLabelPanel, BoxLayout.PAGE_AXIS));
		passwordLabelPanel.add(passwordLabel);
		passwordLabelPanel.setBounds(231, 344, 90, 23);

		JLabel confirmPasswordLabel = new JLabel("  Confirm Password ");
		confirmPasswordLabel.setFont(normalFont);

		JPanel confirmPasswordLabelPanel = new JPanel();
		confirmPasswordLabelPanel.setBackground(Color.WHITE);
		confirmPasswordLabelPanel.setLayout(new BoxLayout(confirmPasswordLabelPanel, BoxLayout.PAGE_AXIS));
		confirmPasswordLabelPanel.add(confirmPasswordLabel);
		confirmPasswordLabelPanel.setBounds(231, 429, 157, 23);

//      CheckBox      
		iconLabelCheck = new JLabel();
		iconLabelCheck.setIcon(checkIcon);

		iconLabelUncheck = new JLabel();
		iconLabelUncheck.setIcon(uncheckIcon);

		clickButton = new JButton(uncheckIcon);
		clickButton.setBounds(210, 515, 35, 34);
		clickButton.setBorderPainted(false);
		clickButton.setContentAreaFilled(false);
		clickButton.setOpaque(false);

		clickButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (clicked) {
					clickButton.setIcon(uncheckIcon);
					clicked = false;
					System.out.println("Do not Agree");
				} else {
					clickButton.setIcon(checkIcon);
					clicked = true;
					System.out.println("Agree");
				}
			}
		});

		createAccount.getContentPane().add(clickButton);

// 		Terms and Conditions

		Font SpecialFont = new Font("Open Sans Bold", Font.TRUETYPE_FONT, 16);

		JLabel terms = new JLabel("Agree with ");
		terms.setForeground(Color.GRAY);
		terms.setFont(SpecialFont);
		terms.setBounds(245, 503, 468, 54);
		createAccount.getContentPane().add(terms);

		JLabel conditions = new JLabel("Terms & Conditions");
		conditions.setFont(SpecialFont);
		conditions.setBounds(335, 503, 468, 54);
		createAccount.getContentPane().add(conditions);

		UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));

		conditions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message = "By creating a user account, you agree to the following terms and conditions:\n\n"
						+ "1. You must provide accurate and complete information during the registration process,\nincluding your full name, username, and any other information that may be required.\n\n"
						+ "2. You must choose a strong and secure password and keep it confidential. You are\nsolely responsible for maintaining the confidentiality of your password and\naccount information.\n\n"
						+ "3. You are solely responsible for all activities that occur under your account.\nYou agree to notify us immediately of any unauthorized use of your account\nor any other breach of security.\n\n"
						+ "4. You may not use the user account to engage in any illegal or unauthorized activity,\nincluding but not limited to violating any applicable laws or regulations, infringing\non any intellectual property rights, or accessing any restricted areas\nor confidential information.\n\n"
						+ "5. You may not share your user account or password with anyone else,\nor allow anyone else to access your account.\n\n"
						+ "6. We reserve the right to suspend or terminate your user account at any time,\nfor any reason, without notice or liability to you.\n\n"
						+ "7. You agree to indemnify and hold us harmless from any claims, damages,\nor losses arising from your use of the user account or any breach of\nthese terms and conditions.\n\n"
						+ "Do you agree to these terms and conditions?";

				int choice = JOptionPane.showOptionDialog(null, message, "Terms and Conditions",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
				if (choice == JOptionPane.YES_OPTION) {
					// User agreed to the terms and conditions
					clickButton.setIcon(checkIcon);
					clicked = true;
					System.out.println("Agree");
				} else {
					// User did not agree to the terms and conditions
					clickButton.setIcon(uncheckIcon);
					clicked = false;
					System.out.println("Do not Agree");
				}
			}
		});

// Creation Of Icons ----------------------------------------------------------
		JPanel fullname = new JPanel(); // Full name Icon

		ImageIcon fullnameIcon = new ImageIcon("fullnameIcon.png");
		JLabel fullLabel = new JLabel(fullnameIcon);
		fullname.add(fullLabel);
		fullname.setOpaque(false);
		fullname.setLayout(new BoxLayout(fullname, BoxLayout.PAGE_AXIS));
		fullname.setBounds(522, 190, 44, 45);

		JPanel username = new JPanel(); // User name Icon

		ImageIcon usernameIcon = new ImageIcon("usernameIcon.png");
		JLabel userLabel = new JLabel(usernameIcon);
		username.add(userLabel);
		username.setOpaque(false);
		username.setLayout(new BoxLayout(username, BoxLayout.PAGE_AXIS));
		username.setBounds(522, 275, 44, 45);

		JPanel password = new JPanel(); // Password Icon

		ImageIcon passwordIcon = new ImageIcon("passwordIcon.png");
		JLabel passwordIconLabel = new JLabel(passwordIcon);
		password.add(passwordIconLabel);
		password.setOpaque(false);
		password.setLayout(new BoxLayout(password, BoxLayout.PAGE_AXIS));
		password.setBounds(522, 360, 44, 45);

		// Confirm Password Icon
		confirm.add(confirmIconLabel);
		confirm.setOpaque(false);
		confirm.setLayout(new BoxLayout(confirm, BoxLayout.PAGE_AXIS));
		confirm.setBounds(522, 445, 44, 45);

		confirmIconLabel.setVisible(true);

		// Green Check
		confirm.add(green);
		green.setVisible(false);

		// Red Check
		confirm.add(red);
		red.setVisible(false);

// Rounded Text Field - for Login Account ----------------------------------------------------------

		JTextField fullnameTextField = new JTextField(20) { // CreateAcc text field "Fullname"
			@Override
			protected void paintComponent(Graphics g) {
				paintRoundedComponent(g, this);
				super.paintComponent(g);
			}
		};

		fullnameTextField.setOpaque(false);
		fullnameTextField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		fullnameTextField.setFont(font);
		fullnameTextField.setMaximumSize(new Dimension(500, 60));

		JPanel fullnameTextFieldPanel = new JPanel();
		fullnameTextFieldPanel.setBackground(Color.WHITE);
		fullnameTextFieldPanel.setLayout(new BoxLayout(fullnameTextFieldPanel, BoxLayout.PAGE_AXIS));
		fullnameTextFieldPanel.add(fullnameTextField);
		fullnameTextFieldPanel.add(Box.createVerticalGlue());
		fullnameTextFieldPanel.setBounds(207, 185, 365, 60);

		((AbstractDocument) fullnameTextField.getDocument()).setDocumentFilter(createNumberSpecialFilter());

		layeredPane.add(fullnameTextFieldPanel, new Integer(0)); // Layer them (so dosen't overlap)
		layeredPane.add(fullnameLabelPanel, new Integer(1));
		layeredPane.add(fullname, new Integer(1));

		JTextField usernameTextField = new JTextField(20) { // CreateAcc text field "Username"
			@Override
			protected void paintComponent(Graphics g) {
				paintRoundedComponent(g, this);
				super.paintComponent(g);
			}
		};
		usernameTextField.setOpaque(false);
		usernameTextField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		usernameTextField.setFont(font);
		usernameTextField.setMaximumSize(new Dimension(500, 60)); // Set maximum size.

		JPanel usernameTextFieldPanel = new JPanel();

		usernameTextFieldPanel.setBackground(Color.WHITE);
		usernameTextFieldPanel.setLayout(new BoxLayout(usernameTextFieldPanel, BoxLayout.PAGE_AXIS));
		usernameTextFieldPanel.add(usernameTextField);
		usernameTextFieldPanel.add(Box.createVerticalGlue());
		usernameTextFieldPanel.setBounds(207, 270, 365, 60);

		((AbstractDocument) usernameTextField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		// Layer them (so dosen't overlap)
		layeredPane.add(usernameTextFieldPanel, new Integer(2));
		layeredPane.add(username, new Integer(3));
		layeredPane.add(usernameLabelPanel, new Integer(3));

		PasswordField = new JPasswordField(20) { // CreateAcc password field "Password"
			@Override
			protected void paintComponent(Graphics g) {
				int w = getWidth();
				int h = getHeight();
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(getBackground());
				g.fillRoundRect(0, 0, w - 1, h - 1, h, h);
				g2.setColor(passwordColor);
				g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
				super.paintComponent(g);
			}
		};
		PasswordField.setOpaque(false);
		PasswordField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));

		((AbstractDocument) PasswordField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		PasswordField.setFont(font);
		PasswordField.setMaximumSize(new Dimension(500, 60));

		JPanel PasswordFieldPanel = new JPanel();
		PasswordFieldPanel.setBackground(Color.WHITE);
		PasswordFieldPanel.setLayout(new BoxLayout(PasswordFieldPanel, BoxLayout.PAGE_AXIS));
		PasswordFieldPanel.add(PasswordField);
		PasswordFieldPanel.add(Box.createVerticalGlue());
		PasswordFieldPanel.setBounds(207, 355, 365, 60);

		// Layer them (so dosen't overlap)
		layeredPane.add(password, new Integer(4));
		layeredPane.add(PasswordFieldPanel, new Integer(4));
		layeredPane.add(passwordLabelPanel, new Integer(5));

		ImageIcon hideIcon = new ImageIcon("hide.png");
		ImageIcon showIcon = new ImageIcon("show.png");

		JButton hide = new JButton(hideIcon);
		hide.setBorderPainted(false);
		hide.setContentAreaFilled(false);
		hide.setOpaque(false);

		hide.setVisible(false);
		password.add(hide);

		// Add a FocusListener to the JTextField
		PasswordField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

				passwordIconLabel.setVisible(false);
				hide.setVisible(true);
				password.setBounds(522, 355, 44, 51);

			}

			@Override
			public void focusLost(FocusEvent e) {
				hide.setVisible(false);
				passwordIconLabel.setVisible(true);
				password.setBounds(522, 360, 44, 45);

			}
		});

		hide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (clicked3) {
					hide.setIcon(hideIcon);
					clicked3 = false;
					PasswordField.setEchoChar('•');
				} else {
					hide.setIcon(showIcon);
					clicked3 = true;
					PasswordField.setEchoChar((char) 0);
				}
			}
		});

		ConfirmPasswordField = new JPasswordField(20) { // CreateAcc password field "Confirm Password"
			@Override
			protected void paintComponent(Graphics g) {
				int w = getWidth();
				int h = getHeight();
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(getBackground());
				g.fillRoundRect(0, 0, w - 1, h - 1, h, h);
				g2.setColor(confirmColor);
				g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
				super.paintComponent(g);
			}
		};
		ConfirmPasswordField.setOpaque(false);
		ConfirmPasswordField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));

		((AbstractDocument) ConfirmPasswordField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		ConfirmPasswordField.setFont(font);
		ConfirmPasswordField.setMaximumSize(new Dimension(500, 60));
		ConfirmPasswordField.setEnabled(false); // disable confirm password field

		JPanel ConfirmPasswordFieldPanel = new JPanel();
		ConfirmPasswordFieldPanel.setBackground(Color.WHITE);
		ConfirmPasswordFieldPanel.setLayout(new BoxLayout(ConfirmPasswordFieldPanel, BoxLayout.PAGE_AXIS));
		ConfirmPasswordFieldPanel.add(ConfirmPasswordField);
		ConfirmPasswordFieldPanel.add(Box.createVerticalGlue());

		ConfirmPasswordFieldPanel.setBounds(207, 440, 365, 60);

		layeredPane.add(confirm, new Integer(6));
		layeredPane.add(ConfirmPasswordFieldPanel, new Integer(6));
		layeredPane.add(confirmPasswordLabelPanel, new Integer(7));

		createButton.addActionListener(e -> { // Clicking the Create Account
			// Get the values from the text fields and password fields
			String fullnameB = fullnameTextField.getText();
			String usernameB = usernameTextField.getText();
			char[] passwordChars = PasswordField.getPassword();
			char[] passwordChars2 = ConfirmPasswordField.getPassword();
			String passwordB = new String(passwordChars);
			String password2 = new String(passwordChars2);

			// Set the boolean variables for validations
			boolean isFullnameValid = fullnameB.length() >= 3;
			boolean isUsernameValid = usernameB.length() >= 3;
			boolean isPasswordValid = passwordB.length() >= 8 && passwordB.matches(".*\\d.*")
					&& passwordB.matches(".*[a-z].*") && passwordB.matches(".*[A-Z].*")
					&& passwordB.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
			boolean isPasswordMatched = passwordB.equals(password2);

			// Check if all validation is successful
			boolean isAllValid = isFullnameValid && isUsernameValid && isPasswordValid && isPasswordMatched && clicked;
			if (isAllValid) {
				Object[] options = { "Login Now" };
				JOptionPane.showOptionDialog(null, "  Account created successfully!", "Success",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				createAccount.dispose();
				loginUsername.add(usernameTextField.getText());
				loginPassword.add(new String(PasswordField.getPassword()));
				clicked = false;
				clickButton.setIcon(uncheckIcon);
				passwordColor = Color.GRAY;
				confirmColor = Color.GRAY;
				green.setVisible(false);
				red.setVisible(false);
				confirmIconLabel.setVisible(true);
				Login();
			} else {
				String errorMessage = "Please complete the following:\n";
				if (!isFullnameValid) {
					errorMessage += "- The Full Name should contain at least 3 letters.\n";
				}
				if (!isUsernameValid) {
					errorMessage += "- The Username should contain at least 3 letters.\n";
				}
				if (!isPasswordValid) {
					errorMessage += "- The Password should contain at least 8 characters,\n   1 Uppercase and Lowercase letter, 1 Digit, and\n   1 Special character.\n";
				}
				if (!isPasswordMatched) {
					errorMessage += "- The Passwords do not match.\n";
				}
				if (!clicked) {
					errorMessage += "- Accept Terms & Conditions\n";
				}
				JOptionPane.showMessageDialog(null, errorMessage);
			}
		});

//-------------------------------------------------------------------------------------------------------------------        

		PasswordField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkPasswordStrength();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkPasswordStrength();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkPasswordStrength();
			}
		});

		ConfirmPasswordField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkPasswordMatch();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkPasswordMatch();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkPasswordMatch();
			}
		});

		// Background Image for Create Account
		ImageIcon background2 = new ImageIcon("f2.png");
		JLabel backgroundLabel2 = new JLabel(background2);
		backgroundLabel2.setBounds(0, 0, 780, 780);
		createAccount.getContentPane().add(backgroundLabel2);
	}

//-------------------------------------------------------------------------------------------------------------
	private void checkPasswordStrength() {
		char[] passwordChars = PasswordField.getPassword();
		String password = new String(passwordChars);

		int score = 0;
		if (password.length() >= 8) {
			score++;
		}
		if (password.matches("(?=.*[a-z]).*")) {
			score++;
		}
		if (password.matches("(?=.*[A-Z]).*")) {
			score++;
		}
		if (password.matches("(?=.*\\d).*")) {
			score++;
		}
		if (password.matches("(?=.*[-+_!@#$%^&*.,?]).*")) {
			score++;
		}

		if (score == 0) {
			passwordColor = Color.GRAY;
			ConfirmPasswordField.setEnabled(false); // disable confirm password field
			ConfirmPasswordField.setText("");

			confirmColor = Color.GRAY;

			red.setVisible(false);
			green.setVisible(false);
			confirmIconLabel.setVisible(true);

		} else if (score <= 2) {
			passwordColor = Color.RED;
			ConfirmPasswordField.setEnabled(false); // disable
		} else if (score <= 4) {
			passwordColor = Color.ORANGE;
			ConfirmPasswordField.setEnabled(false); // disable
		} else {
			passwordColor = Color.GREEN;
			ConfirmPasswordField.setEnabled(true); // enable confirm password field
		}
	}

	private void checkPasswordMatch() {
		char[] passwordChars = PasswordField.getPassword();
		String password = new String(passwordChars);

		char[] confirmPasswordChars = ConfirmPasswordField.getPassword();
		String confirmPassword = new String(confirmPasswordChars);

		if (password.equals(confirmPassword)) {
			confirmColor = Color.GREEN;
			confirmIconLabel.setVisible(false);
			red.setVisible(false);
			green.setVisible(true);
		} else {
			confirmColor = Color.RED;
			confirmIconLabel.setVisible(false);
			green.setVisible(false);
			red.setVisible(true);
		}
	}

	public static void paintRoundedComponent(Graphics g, JComponent c) { // For Customized Rounded Text field
		int w = c.getWidth();
		int h = c.getHeight();
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(c.getBackground());
		g.fillRoundRect(0, 0, w - 1, h - 1, h, h);
		g2.setColor(Color.GRAY);
		g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
		g2.dispose();
	}

	// Super Advance Code "Removes Spaces"
	public static DocumentFilter createSpaceRemoverFilter() {
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

	public static DocumentFilter createNumberSpecialFilter() {
		return new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				if (string.matches("[^a-zA-Z\\s]")) {
					return; // do not allow insertion of non-alphabetic or non-space characters
				}
				fb.insertString(offset, string.replaceAll("[^a-zA-Z\\s]+", ""), attr);
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
					throws BadLocationException {
				if (string.matches("[^a-zA-Z\\s]")) {
					return; // do not allow replacement of non-alphabetic or non-space characters
				}
				fb.replace(offset, length, string.replaceAll("[^a-zA-Z\\s]+", ""), attrs);
			}
		};
	}

//-------------------------------------------------------------------------------------------------------------------
	public void createMain() {

		JFrame main = new JFrame("Create Account Panel"); // Create Account Panel
		main.getContentPane().setLayout(null);
		main.setSize(800, 820);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setVisible(true);

		JButton LogoutButton = new JButton();
		LogoutButton.setBounds(635, 710, 110, 40);
		LogoutButton.setBorderPainted(false);
		LogoutButton.setContentAreaFilled(false);
		LogoutButton.setOpaque(false);
		main.getContentPane().add(LogoutButton);

		JButton nextFirstPage = new JButton();
		nextFirstPage.setBounds(345, 550, 90, 35);
		nextFirstPage.setBorderPainted(false);
		nextFirstPage.setContentAreaFilled(false);
		nextFirstPage.setOpaque(false);
		main.getContentPane().add(nextFirstPage);

		JButton nextSecondPage = new JButton();
		nextSecondPage.setBounds(404, 620, 90, 35);
		nextSecondPage.setBorderPainted(false);
		nextSecondPage.setContentAreaFilled(false);
		nextSecondPage.setOpaque(false);

		nextSecondPage.setVisible(false);
		main.getContentPane().add(nextSecondPage);

		JButton backSecondPage = new JButton();
		backSecondPage.setBounds(295, 620, 90, 35);
		backSecondPage.setBorderPainted(false);
		backSecondPage.setContentAreaFilled(false);
		backSecondPage.setOpaque(false);

		backSecondPage.setVisible(false);
		main.getContentPane().add(backSecondPage);

		JButton backThirdPage = new JButton();
		backThirdPage.setBounds(346, 620, 90, 35);
		backThirdPage.setBorderPainted(false);
		backThirdPage.setContentAreaFilled(false);
		backThirdPage.setOpaque(false);

		backThirdPage.setVisible(false);
		main.getContentPane().add(backThirdPage);

		ImageIcon background = new ImageIcon("main1.png");
		ImageIcon background2 = new ImageIcon("main2.png");
		ImageIcon background3 = new ImageIcon("main3.png");

		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, 780, 780);
		main.getContentPane().add(backgroundLabel);

		LogoutButton.addActionListener(e -> {
			main.dispose();
			Login();
		});

		nextFirstPage.addActionListener(e -> {
			backgroundLabel.setIcon(background2);
			nextFirstPage.setVisible(false);

			backSecondPage.setVisible(true);
			nextSecondPage.setVisible(true);
		});

		backSecondPage.addActionListener(e -> {
			backgroundLabel.setIcon(background);
			backSecondPage.setVisible(false);
			nextSecondPage.setVisible(false);
			nextFirstPage.setVisible(true);
		});

		nextSecondPage.addActionListener(e -> {
			backgroundLabel.setIcon(background3);
			nextSecondPage.setVisible(false);
			backSecondPage.setVisible(false);
			backThirdPage.setVisible(true);
		});

		backThirdPage.addActionListener(e -> {
			backgroundLabel.setIcon(background2);
			backThirdPage.setVisible(false);
			backSecondPage.setVisible(true);
			nextSecondPage.setVisible(true);
		});
	}
}
