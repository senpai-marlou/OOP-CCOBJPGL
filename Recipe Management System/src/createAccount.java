
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class createAccount {

	public static ArrayList<String> loginUsername = new ArrayList<String>();
	public static ArrayList<String> loginPassword = new ArrayList<String>();
	public static ArrayList<String> personalInfo = new ArrayList<String>();

	private JPanel createAccount;
	private JLayeredPane layeredPane = new JLayeredPane();

	// Terms and Condition button
	static JButton yesButton = new JButton("Yes");
	static JButton noButton = new JButton("No");
	static JButton dataPrivacyAct = new JButton("Data Privacy Act");

	// Check Box Button
	static JButton checkBox = new JButton();
	static ImageIcon boxIcon = new ImageIcon("box.png");
	static boolean clicked = false;
	static boolean clicked2 = false;

	// Text Fields | Password Fields
	static JTextField fullnameTextField;
	static JTextField usernameTextField;
	static JTextField contactTextField;

	static JPasswordField passwordField;
	static JPasswordField confirmPasswordField;

	// Text Fields | Password Fields Colors
	static Color passwordColor = Color.GRAY, confirmColor = Color.GRAY, usernameColor = Color.GRAY,
			contactColor = Color.GRAY;

	// String Validation
	static JLabel fullNameValidation = new JLabel();
	static JLabel userNameValidation = new JLabel();
	static JLabel userNameValidation2 = new JLabel();
	static JLabel contactValidation = new JLabel();
	static JLabel passwordValidation = new JLabel();
	static JLabel confirmValidation = new JLabel();

	// Check | Label Icons
	static ImageIcon greenIcon = new ImageIcon("greenIcon.png");
	static ImageIcon redIcon = new ImageIcon("redIcon.png");
	static ImageIcon confirmIcon = new ImageIcon("confirmIcon.png");

	static JLabel green = new JLabel(greenIcon), red = new JLabel(redIcon), confirmIconLabel = new JLabel(confirmIcon);

	// Fonts
	public static Font buttonFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 13);
	public static Font font = new Font("Poppins Medium", Font.TRUETYPE_FONT, 20);
	static Font numberFont = new Font("Open Sans SemiBold", Font.TRUETYPE_FONT, 20);
	static Font validationFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 10);

	// Okay Button
	static JButton okButton = new JButton("OK");

	@SuppressWarnings({ "removal", "serial" })
	public createAccount() {
		// Initialize the JPanel instance
		createAccount = new JPanel();
		createAccount.setLayout(null);
		createAccount.setBounds(1351, 84, 445, 673);
		createAccount.setOpaque(false);
		createAccount.setVisible(true);

		// Layered Pane
		layeredPane.setSize(createAccount.getSize());
		createAccount.add(layeredPane);

		// Background
		JLabel createAccBG = new JLabel(new ImageIcon("createAccount.png"));
		createAccBG.setBounds(0, 0, 445, 673);

		// Front Background
		JLabel createAccFront = new JLabel(new ImageIcon("cFront.png"));
		createAccFront.setBounds(0, 0, 445, 673);

		// Check Box Icon
		ImageIcon checkBoxIcon = new ImageIcon("checkBox.png");
		checkBox = new JButton(boxIcon);
		checkBox.setBounds(57, 496, 22, 22);
		checkBox.setBorderPainted(false);
		checkBox.setContentAreaFilled(false);
		checkBox.setOpaque(false);

		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (clicked) {
					checkBox.setIcon(boxIcon);
					clicked = false;
				} else {
					checkBox.setIcon(checkBoxIcon);
					clicked = true;
				}
			}
		});

		// Setting the general JOption Font
		UIManager.put("OptionPane.messageFont", new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 13));

		// Buttons YES | NO
		yesButton.setFont(buttonFont);
		yesButton.setBackground(Color.WHITE);
		yesButton.setFocusPainted(false);
		yesButton.setBorderPainted(true);

		noButton.setFont(buttonFont);
		noButton.setBackground(Color.WHITE);
		noButton.setFocusPainted(false);
		noButton.setBorderPainted(true);

		dataPrivacyAct.setFont(buttonFont);
		dataPrivacyAct.setBackground(Color.WHITE);
		dataPrivacyAct.setFocusPainted(false);
		dataPrivacyAct.setBorderPainted(true);

// Syntax ---------------------------------------------------------------------------------------------------	
		JButton createAccButton = new JButton();
		createAccButton.setBorderPainted(false);
		createAccButton.setContentAreaFilled(false);
		createAccButton.setOpaque(false);
		createAccButton.setBounds(51, 538, 341, 51);

		JButton toLoginAcc = new JButton();
		toLoginAcc.setBorderPainted(false);
		toLoginAcc.setContentAreaFilled(false);
		toLoginAcc.setOpaque(false);
		toLoginAcc.setBounds(289, 617, 47, 18);

		JButton terms = new JButton();
		terms.setBorderPainted(false);
		terms.setContentAreaFilled(false);
		terms.setOpaque(false);
		terms.setBounds(169, 497, 157, 18);

		// Add cursor
		createAccButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toLoginAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		terms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		toLoginAcc.addActionListener(e -> {
			mainScreen.loginAccountB.doClick();
			// Set Delay Timer because I want too
			Timer timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					// Resets All Values
					resetValues();
				}
			});
			timer.setRepeats(false);
			timer.start();
		});

		terms.addMouseListener(new MouseAdapter() {
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

				Object[] options = { yesButton, dataPrivacyAct, noButton };
				JOptionPane pane = new JOptionPane(message, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
						options);
				JDialog dialog = pane.createDialog("Terms and Conditions");

				yesButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// User agreed to the terms and conditions
						checkBox.setIcon(checkBoxIcon);
						clicked = true;
						dialog.dispose();
					}
				});

				noButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// User did not agree to the terms and conditions
						checkBox.setIcon(boxIcon);
						clicked = false;
						dialog.dispose();
					}
				});

				// ActionListener for dataPrivacyAct button
				ActionListener termsNconditionListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// User can see the Data Privacy Act of 2012
						try {
							Desktop.getDesktop().browse(new URI(
									"https://privacy.gov.ph/data-privacy-act/#:~:text=Short%20Title.%20%E2%80%93%20This%20Act%20shall%20be%20known,flow%20of%20information%20to%20promote%20innovation%20and%20growth."));
						} catch (IOException | URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
				};

				dataPrivacyAct.addActionListener(termsNconditionListener);
				dialog.setVisible(true);
				dataPrivacyAct.removeActionListener(termsNconditionListener);
			}
		});

// Text Fields ----------------------------------------------------------------------------------------------

		fullnameTextField = new JTextField(20) { // Text Field "Full Name"

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
		fullnameTextField.setBounds(50, 106, 342, 53);

		((AbstractDocument) fullnameTextField.getDocument()).setDocumentFilter(createNumberSpecialFilter());

		usernameTextField = new JTextField(20) { // CreateAcc text field "User name"
			@Override
			protected void paintComponent(Graphics g) {
				int w = getWidth();
				int h = getHeight();
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(getBackground());
				g.fillRoundRect(0, 0, w - 1, h - 1, h, h);
				g2.setColor(usernameColor);
				g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
				super.paintComponent(g);
			}
		};
		usernameTextField.setOpaque(false);
		usernameTextField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		usernameTextField.setFont(font);
		usernameTextField.setMaximumSize(new Dimension(500, 60));
		usernameTextField.setBounds(50, 184, 342, 53);

		((AbstractDocument) usernameTextField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		contactTextField = new JTextField(20) {
			@Override
			protected void paintComponent(Graphics g) {
				int w = getWidth();
				int h = getHeight();
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(getBackground());
				g.fillRoundRect(0, 0, w - 1, h - 1, h, h);
				g2.setColor(contactColor);
				g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
				super.paintComponent(g);
			}
		};

		contactTextField.setOpaque(false);
		contactTextField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		contactTextField.setFont(numberFont);
		contactTextField.setMaximumSize(new Dimension(500, 60));
		contactTextField.setBounds(50, 264, 342, 53);

		((AbstractDocument) contactTextField.getDocument()).setDocumentFilter(createNumberFilter());

// Password Fields ------------------------------------------------------------------------------------------	

		passwordField = new JPasswordField(20) { // CreateAcc password field "Password"
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
		passwordField.setOpaque(false);
		passwordField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		passwordField.setFont(font);
		passwordField.setMaximumSize(new Dimension(500, 60));
		passwordField.setBounds(50, 344, 342, 53);

		((AbstractDocument) passwordField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		// Hide | Show Icon
		ImageIcon hideIcon = new ImageIcon("hide.png");
		ImageIcon showIcon = new ImageIcon("show.png");
		ImageIcon passwordIconn = new ImageIcon("password.png");

		JLabel passwordIconLabel = new JLabel(passwordIconn);
		passwordIconLabel.setOpaque(false);
		passwordIconLabel.setBounds(343, 349, 43, 43);

		JButton hideIconB = new JButton(hideIcon);
		hideIconB.setBorderPainted(false);
		hideIconB.setContentAreaFilled(false);
		hideIconB.setOpaque(false);
		hideIconB.setBounds(343, 349, 43, 43);
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
				if (clicked2) {
					hideIconB.setIcon(hideIcon);
					clicked2 = false;
					passwordField.setEchoChar('•');
				} else {
					hideIconB.setIcon(showIcon);
					clicked2 = true;
					passwordField.setEchoChar((char) 0);
				}
			}
		});

		confirmPasswordField = new JPasswordField(20) { // CreateAcc password field "Confirm Password"
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
		confirmPasswordField.setOpaque(false);
		confirmPasswordField.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 32));
		confirmPasswordField.setFont(font);
		confirmPasswordField.setMaximumSize(new Dimension(500, 60));
		confirmPasswordField.setBounds(50, 422, 342, 53);
		confirmPasswordField.setEnabled(false); // disable for now confirm password field

		((AbstractDocument) confirmPasswordField.getDocument()).setDocumentFilter(createSpaceRemoverFilter());

		confirmIconLabel.setBounds(343, 427, 43, 43);
		confirmIconLabel.setOpaque(false);

		// Green Check
		green.setBounds(343, 427, 43, 43);
		green.setOpaque(false);
		green.setVisible(false);

		// Red Check
		red.setBounds(343, 427, 43, 43);
		red.setOpaque(false);
		red.setVisible(false);

// Create Account Validation -------------------------------------------------------------------------------

		createAccButton.addActionListener(e -> {

			JButton loginNowButton = new JButton("Login Now");
			loginNowButton.setFont(buttonFont);
			loginNowButton.setBackground(Color.WHITE);
			loginNowButton.setFocusPainted(false);
			loginNowButton.setBorderPainted(true);

			okButton.setFont(buttonFont);
			okButton.setBackground(Color.WHITE);
			okButton.setFocusPainted(false);
			okButton.setBorderPainted(true);

			// Get the values from the text fields and password fields
			String fullnameB = fullnameTextField.getText();
			String usernameB = usernameTextField.getText();
			String contact = contactTextField.getText();
			char[] passwordChars = passwordField.getPassword();
			char[] passwordChars2 = confirmPasswordField.getPassword();
			String passwordB = new String(passwordChars);
			String password2 = new String(passwordChars2);

			// Set the boolean variables for validations
			boolean isFullnameValid = fullnameB.length() >= 3;
			boolean isUsernameValid = usernameB.length() >= 3;
			boolean isContactValid = contact.length() == 11;
			boolean isContactValid2 = contact.startsWith("09");
			boolean isPasswordValid = passwordB.length() >= 8 && passwordB.matches(".*\\d.*")
					&& passwordB.matches(".*[a-z].*") && passwordB.matches(".*[A-Z].*")
					&& passwordB.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
			boolean isPasswordMatched = passwordB.equals(password2);

			// Check if all validation is successful
			boolean isAllValid = isFullnameValid && isUsernameValid && isContactValid && isContactValid2
					&& isPasswordValid && isPasswordMatched && clicked;

			if (isAllValid) {
				Object[] options = { loginNowButton };

				JOptionPane pane = new JOptionPane("       Account created successfully!", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, options);

				JDialog dialog = pane.createDialog("Success");
				dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				loginNowButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						mainScreen.loginAccountB.doClick();
						// Adding the User Account to database
						loginUsername.add(usernameTextField.getText());
						loginPassword.add(new String(passwordField.getPassword()));
						personalInfo.add(fullnameTextField.getText());
						personalInfo.add(contactTextField.getText());
						// Set Delay Timer because I want too
						Timer timer = new Timer(1000, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								// Resets All Values
								resetValues();
							}
						});
						timer.setRepeats(false);
						timer.start();
					}
				});
				dialog.setVisible(true);

			} else {
				String errorMessage = "Please complete the following:\n";
				if (!isFullnameValid) {
					errorMessage += "- The Full Name should contain at least 3 letters.\n";
				}
				if (!isUsernameValid) {
					errorMessage += "- The Username should contain at least 3 letters.\n";
				}

				if (!isContactValid) {
					errorMessage += "- Contact Number should have exactly 11 characters.\n";
				}

				if (!isContactValid2) {
					errorMessage += "- Contact Number should start with \"09\".\n";
				}

				if (!isPasswordValid) {
					errorMessage += "- The Password should contain at least 8 characters,\n   1 Uppercase and Lowercase letter, 1 Digit, and\n   1 Special character.\n";
				}
				if (!isPasswordMatched) {
					errorMessage += "- The Passwords do not match.\n";
				}
				if (!clicked) {
					errorMessage += "- Agree with Terms & Conditions\n";
				}
				Object[] options = { okButton };
				JOptionPane pane = new JOptionPane(errorMessage, JOptionPane.WARNING_MESSAGE, JOptionPane.OK_OPTION,
						null, options);
				JDialog dialog = pane.createDialog("Account Creation Failed");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				dialog.setVisible(true);
			}
		});

// Validations ---------------------------------------------------------------------------------------------

		// Full name validation
		String nValidation = "Should contain at least 3 letters.";
		fullNameValidation.setText(nValidation);
		fullNameValidation.setFont(validationFont);
		fullNameValidation.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameValidation.setForeground(Color.RED);
		fullNameValidation.setVisible(false);
		fullNameValidation.setBounds(100, 146, 240, 20);

		// User name validation
		String uValidation = "Should contain at least 3 letters.";
		userNameValidation.setText(uValidation);
		userNameValidation.setFont(validationFont);
		userNameValidation.setHorizontalAlignment(SwingConstants.CENTER);
		userNameValidation.setForeground(Color.RED);
		userNameValidation.setVisible(false);
		userNameValidation.setBounds(100, 236, 240, 20);

		// Contact Validation
		String cValidation = "Should start with 09, and 11 number long.";
		contactValidation.setText(cValidation);
		contactValidation.setFont(validationFont);
		contactValidation.setHorizontalAlignment(SwingConstants.CENTER);
		contactValidation.setForeground(Color.RED);
		contactValidation.setVisible(false);
		contactValidation.setOpaque(false);
		contactValidation.setBounds(100, 316, 240, 20);

		// Password
		String pValidation = "8+ char, 1 uppercase, 1 lowercase, 1 digit, 1 special char.";
		passwordValidation.setText(pValidation);
		passwordValidation.setFont(validationFont);
		passwordValidation.setHorizontalAlignment(SwingConstants.CENTER);
		passwordValidation.setForeground(Color.RED);
		passwordValidation.setVisible(false);
		passwordValidation.setBounds(23, 396, 380, 20);

		// Confirm Password
		String conValidation = "Password do not match.";
		confirmValidation.setText(conValidation);
		confirmValidation.setFont(validationFont);
		confirmValidation.setHorizontalAlignment(SwingConstants.CENTER);
		confirmValidation.setForeground(Color.RED);
		confirmValidation.setVisible(false);
		confirmValidation.setBounds(100, 474, 240, 20);

		usernameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Do nothing
			}

			@Override
			public void focusLost(FocusEvent e) {

				JButton okButton = new JButton("OK");
				okButton.setFont(buttonFont);
				okButton.setBackground(Color.WHITE);
				okButton.setFocusPainted(false);
				okButton.setBorderPainted(true);
				Object[] options = { okButton };

				String usernameCreate = usernameTextField.getText();

				if (loginUsername.contains(usernameCreate)) {
					JOptionPane pane = new JOptionPane("Username Already Used", JOptionPane.OK_OPTION,
							JOptionPane.ERROR_MESSAGE, null, options);
					JDialog dialog = pane.createDialog("Username error");
					okButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							usernameTextField.setText("");
							dialog.dispose();
						}
					});
					dialog.setVisible(true);
				}
			}
		});

		contactTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkContact();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkContact();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkContact();
			}
		});

		usernameTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkUsername();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkUsername();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkUsername();
			}
		});

		passwordField.getDocument().addDocumentListener(new DocumentListener() {

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

		confirmPasswordField.getDocument().addDocumentListener(new DocumentListener() {
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

// Layers ---------------------------------------------------------------------------------------------------
		layeredPane.add(createAccBG, new Integer(0));

		// Text Field | Password Field
		layeredPane.add(fullnameTextField, new Integer(1));
		layeredPane.add(usernameTextField, new Integer(1));
		layeredPane.add(contactTextField, new Integer(1));
		layeredPane.add(passwordField, new Integer(1));
		layeredPane.add(confirmPasswordField, new Integer(1));

		// Buttons || Check Box || Labels
		layeredPane.add(createAccButton, new Integer(2));
		layeredPane.add(toLoginAcc, new Integer(2));
		layeredPane.add(terms, new Integer(2));
		layeredPane.add(checkBox, new Integer(2));
		layeredPane.add(hideIconB, new Integer(2));
		layeredPane.add(passwordIconLabel, new Integer(2));
		layeredPane.add(confirmIconLabel, new Integer(2));
		layeredPane.add(green, new Integer(2));
		layeredPane.add(red, new Integer(2));

		// Validation
		layeredPane.add(fullNameValidation, new Integer(3));
		layeredPane.add(userNameValidation, new Integer(3));
		layeredPane.add(contactValidation, new Integer(3));
		layeredPane.add(passwordValidation, new Integer(3));
		layeredPane.add(confirmValidation, new Integer(3));

		// Front BG
		layeredPane.add(createAccFront, new Integer(2));

	}

	public static void paintRoundedComponent(Graphics g, JComponent c) { // "Advance" For Customized Rounded Text field
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

// Additional Validation --------------------------------------------------------------------------------------

	private static void checkUsername() {
		String usernameCreate = usernameTextField.getText();

		if (usernameCreate.equals("")) {
			usernameColor = Color.GRAY;
			userNameValidation.setVisible(false);
		} else if (loginUsername.contains(usernameCreate)) {
			usernameColor = Color.RED;
			userNameValidation.setText("Username Already Exist");
			userNameValidation.setVisible(true);
		} else if (usernameCreate.length() < 3) {
			usernameColor = Color.RED;
			userNameValidation.setText("Should contain at least 3 letters.");
			userNameValidation.setVisible(true);
		} else {
			usernameColor = Color.GREEN;
			userNameValidation.setVisible(false);
		}
	}

	private static void checkContact() {
		String contact = contactTextField.getText();

		if (contact.equals("")) {
			contactColor = Color.GRAY;
			contactValidation.setVisible(false);
		} else if (contact.length() < 11) {
			contactColor = Color.RED;
			contactValidation.setVisible(true);
		} else if (!(contact.startsWith("09"))) {
			contactColor = Color.RED;
			contactValidation.setVisible(true);
		} else {
			contactColor = Color.GREEN;
			contactValidation.setVisible(false);
		}
	}

	private static void checkPasswordStrength() {
		char[] passwordChars = passwordField.getPassword();
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
			confirmPasswordField.setEnabled(false); // disable confirm password field
			confirmPasswordField.setText("");

			confirmColor = Color.GRAY;
			passwordValidation.setVisible(false);

			red.setVisible(false);
			green.setVisible(false);
			confirmIconLabel.setVisible(true);

		} else if (score <= 4) {
			passwordColor = Color.RED;
			confirmPasswordField.setEnabled(false); // disable
			passwordValidation.setVisible(true);
		} else {
			passwordColor = Color.GREEN;
			confirmPasswordField.setEnabled(true); // enable confirm password field
			passwordValidation.setVisible(false);
		}
	}

	private static void checkPasswordMatch() {
		char[] passwordChars = passwordField.getPassword();
		String password = new String(passwordChars);

		char[] confirmPasswordChars = confirmPasswordField.getPassword();
		String confirmPassword = new String(confirmPasswordChars);

		if (confirmPassword.equals("")) {
			confirmColor = Color.GRAY;
			confirmIconLabel.setVisible(true);
			red.setVisible(false);
			green.setVisible(false);
			confirmValidation.setVisible(false);
		} else if (password.equals(confirmPassword)) {
			confirmColor = Color.GREEN;
			confirmIconLabel.setVisible(false);
			red.setVisible(false);
			green.setVisible(true);
			confirmValidation.setVisible(false);
		} else {
			confirmColor = Color.RED;
			confirmIconLabel.setVisible(false);
			green.setVisible(false);
			red.setVisible(true);
			confirmValidation.setVisible(true);
		}
	}

	private static void resetValues() {
		clicked = false;
		checkBox.setIcon(boxIcon);
		passwordColor = Color.GRAY;
		confirmColor = Color.GRAY;
		green.setVisible(false);
		red.setVisible(false);
		fullnameTextField.setText("");
		usernameTextField.setText("");
		contactTextField.setText("");
		passwordField.setText("");
		confirmPasswordField.setText("");
		confirmIconLabel.setVisible(true);
	}

// Document Filters -------------------------------------------------------------------------------------------

	public static DocumentFilter createSpaceRemoverFilter() { // Super Advance Code "Removes Spaces"
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

	public static DocumentFilter createNumberSpecialFilter() { // Super Advance Code "Removes Numbers and Special Char"
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

	public static DocumentFilter createNumberFilter() { // Only allow numbers to be type in, also allows only 11 digits
		return new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
				if (newStr.matches("\\d{0,11}")) {
					fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
					throws BadLocationException {
				String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()).substring(0, offset) + string
						+ fb.getDocument().getText(offset + length, fb.getDocument().getLength() - offset - length);
				if (newStr.matches("\\d{0,11}")) {
					fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attrs);
				}
			}
		};
	}

	public JPanel getcreateAccount() {
		return createAccount;
	}
}
