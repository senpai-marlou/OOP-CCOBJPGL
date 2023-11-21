package AdvanceSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

@SuppressWarnings({ "removal", "serial" })
public class loginFrame extends JFrame {
	public loginFrame() {
	}

	private static Font labelFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 30),
			normalFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 18),
			buttonFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 15);

	private static ImageIcon adminLine = new ImageIcon("adminLine.png"),
			librarianLine = new ImageIcon("librarianLine.png"), usernameIcon = new ImageIcon("userIcon.png"),
			passwordIcon = new ImageIcon("passIcon.png"), hideIcon = new ImageIcon("hide.png"),
			showIcon = new ImageIcon("show.png");

	private static JButton line1 = new JButton(), line2 = new JButton();
	private static boolean clicked = false, adminLog = false, librarianLog = false;

	private static String message;
	private static JTextField textField;
	private static JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginScreen();
//					adminFrame.adminScreen();
//					librarianFrame.librarianScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void loginScreen() {

		loginFrame frame = new loginFrame(); // Login Frame Initialized
		frame.setTitle("Login Account Panel");
		frame.setSize(616, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane(); // Prevent Overlaps designs
		layeredPane.setSize(frame.getSize());
		frame.getContentPane().add(layeredPane);

		JLabel loginAccountLabel = new JLabel("Login Account");
		loginAccountLabel.setFont(labelFont);
		loginAccountLabel.setForeground(Color.WHITE);
		loginAccountLabel.setBounds(65, 88, 468, 54);
		loginAccountLabel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(loginAccountLabel);

		Font newFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 12);

		JLabel usernameLabel = new JLabel("   Username ");
		usernameLabel.setFont(newFont);
		usernameLabel.setForeground(Color.WHITE);

		JPanel usernameLabelPanel = new JPanel();
		usernameLabelPanel.setBackground(new Color(36, 39, 49));
		usernameLabelPanel.setLayout(new BoxLayout(usernameLabelPanel, BoxLayout.PAGE_AXIS));
		usernameLabelPanel.add(usernameLabel);
		usernameLabelPanel.setBounds(170, 177, 83, 19);

		JLabel passwordLabel = new JLabel("   Password");
		passwordLabel.setFont(newFont);
		passwordLabel.setForeground(Color.WHITE);

		JPanel passwordLabelPanel = new JPanel();
		passwordLabelPanel.setBackground(new Color(36, 39, 49));
		passwordLabelPanel.setLayout(new BoxLayout(passwordLabelPanel, BoxLayout.PAGE_AXIS));
		passwordLabelPanel.add(passwordLabel);
		passwordLabelPanel.setBounds(170, 243, 79, 18);

		layeredPane.add(usernameLabelPanel, new Integer(1));
		layeredPane.add(passwordLabelPanel, new Integer(1));

		JButton loginButton = new JButton(); // Login Button
		loginButton.setBounds(147, 317, 300, 50);
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setOpaque(false);
		frame.getContentPane().add(loginButton);

		line1.setBounds(239, 135, 50, 20); // For Admin
		line1.setFocusPainted(false);
		line1.setBorderPainted(false);
		line1.setContentAreaFilled(false);
		line1.setOpaque(false);

		line2.setBounds(267, 135, 120, 20); // For Librarian
		line2.setFocusPainted(false);
		line2.setBorderPainted(false);
		line2.setContentAreaFilled(false);
		line2.setOpaque(false);

		line1.setVisible(true);
		line2.setVisible(true);
		frame.getContentPane().add(line1);
		frame.getContentPane().add(line2);

		line1.addMouseListener(new MouseAdapter() { // Setting the login mode to Admin
			@Override
			public void mousePressed(MouseEvent e) {
				line2.setIcon(null);
				line1.setIcon(adminLine);
				adminLog = true;
				librarianLog = false;
			}
		});

		line2.addMouseListener(new MouseAdapter() { // Setting the login mode to Librarian
			@Override
			public void mousePressed(MouseEvent e) {
				line1.setIcon(null);
				line2.setIcon(librarianLine);
				librarianLog = true;
				adminLog = false;
			}
		});

		JLabel userLabel = new JLabel(usernameIcon);
		userLabel.setBounds(366, 159, 100, 100);
		frame.getContentPane().add(userLabel);

		JLabel passLabel = new JLabel(passwordIcon);
		passLabel.setBounds(366, 225, 100, 100);
		frame.getContentPane().add(passLabel);

		JButton hide = new JButton(hideIcon);
		hide.setBorderPainted(false);
		hide.setContentAreaFilled(false);
		hide.setOpaque(false);
		hide.setBounds(396, 255, 40, 40);
		frame.getContentPane().add(hide);

//------------------------------------------------------------------------------------------------------------
// Text Field and Password Field
		textField = new JTextField(20) {
			@Override
			protected void paintComponent(Graphics g) {
				paintRoundedComponent(g, this); // draw the rounded border
				super.paintComponent(g); // call the superclass implementation to render text field's contents
			}
		};

		((AbstractDocument) textField.getDocument()).setDocumentFilter(createFilter()); // Advance code: Removes spaces,
																						// and special character except
																						// underline
		// Create a JPanel to hold the rounded text field
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setOpaque(false);
		textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.PAGE_AXIS));
		textFieldPanel.add(textField);
		textFieldPanel.add(Box.createVerticalGlue());
		textFieldPanel.setBounds(146, 187, 310, 50);

		frame.getContentPane().add(textFieldPanel);

		passwordField = new JPasswordField(20) {
			@Override
			protected void paintComponent(Graphics g) {
				paintRoundedComponent(g, this);
				super.paintComponent(g);
			}
		};

		JPanel passwordFieldPanel = new JPanel();
		passwordFieldPanel.setOpaque(false);
		passwordFieldPanel.setLayout(new BoxLayout(passwordFieldPanel, BoxLayout.PAGE_AXIS));
		passwordFieldPanel.add(passwordField);
		passwordFieldPanel.add(Box.createVerticalGlue());
		passwordFieldPanel.setBounds(146, 252, 310, 50);

		frame.getContentPane().add(passwordFieldPanel);

		customizeField(textField, passwordField); // Calling the customized effects

		layeredPane.add(textFieldPanel, new Integer(0));
		layeredPane.add(passwordFieldPanel, new Integer(0));
		layeredPane.add(userLabel, new Integer(1));
		layeredPane.add(passLabel, new Integer(1));
		layeredPane.add(hide, new Integer(1));

		passwordField.addFocusListener(new FocusListener() { // Add a FocusListener
			@Override
			public void focusGained(FocusEvent e) {
				layeredPane.remove(passLabel);
				layeredPane.revalidate();
				layeredPane.repaint();
				hide.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				passLabel.setIcon(passwordIcon);
				hide.setVisible(false);
				layeredPane.add(passLabel, new Integer(1));
				layeredPane.revalidate();
				layeredPane.repaint();
			}
		});

		((AbstractDocument) passwordField.getDocument()).setDocumentFilter(createFilter());

		hide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (clicked) {
					hide.setIcon(hideIcon);
					clicked = false;
					passwordField.setEchoChar('•');
				} else {
					hide.setIcon(showIcon);
					clicked = true;
					passwordField.setEchoChar((char) 0);
				}
			}
		});

		loginButton.addActionListener(e -> { // Login Validation
			// Setting the general font of OptionPane
			UIManager.put("OptionPane.messageFont", new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 17));

			String usernameLogin = textField.getText();
			String passwordLogin = new String(passwordField.getPassword());

			boolean adminU1 = usernameLogin.equals("Admin_01");
			boolean adminU2 = usernameLogin.equals("Admin_02");
			boolean adminU3 = usernameLogin.equals("Admin_03");

			boolean adminP1 = passwordLogin.equals("AdminOne");
			boolean adminP2 = passwordLogin.equals("AdminTwo");
			boolean adminP3 = passwordLogin.equals("AdminThree");

			if (adminLog) {
				if (adminU1 && adminP1 || adminU2 && adminP2 || adminU3 && adminP3) {
					frame.dispose();
					adminFrame.adminScreen();
				} else if (adminU1 && !(adminP1) || adminU2 && !(adminP2) || adminU3 && !(adminP3)) {
					message = "Incorrect Password";
					okB();
					passwordField.setText("");
				} else if (!(adminU1) && adminP1 || !(adminU2) && adminP2 || !(adminU3) && adminP3) {
					message = "Incorrect Username";
					okB();
					textField.setText("");
				} else {
					message = "Incorrect Username and Password";
					textField.setText("");
					passwordField.setText("");
					okB();
				}
			}

			boolean libU1 = usernameLogin.equals("Librarian_01");
			boolean libU2 = usernameLogin.equals("Librarian_02");
			boolean libU3 = usernameLogin.equals("Librarian_03");

			boolean libP1 = passwordLogin.equals("LibOne");
			boolean libP2 = passwordLogin.equals("LibTwo");
			boolean libP3 = passwordLogin.equals("LibThree");

			if (librarianLog) {
				if (libU1 && libP1 || libU2 && libP2 || libU3 && libP3) {
					frame.dispose();
					librarianFrame.librarianScreen();
				} else if (libU1 && !(libP1) || libU2 && !(libP2) || libU3 && !(libP3)) {
					message = "Incorrect Password";
					okB();
					passwordField.setText("");
				} else if (!(libU1) && libP1 || !(libU2) && libP2 || !(libU3) && libP3) {
					message = "Incorrect Username";
					okB();
					textField.setText("");
				} else {
					message = "Incorrect Username and Password";
					textField.setText("");
					passwordField.setText("");
					okB();
				}
			}

			if (!(adminLog) && !(librarianLog)) {
				message = "Please Select: Admin or Librarian";
				okB2();
			}
		});

//------------------------------------------------------------------------------------------------------------		
		// Set the background image
		ImageIcon background = new ImageIcon("login.png");
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, 600, 500);
		frame.getContentPane().add(backgroundLabel);
	}

	public static void okB() {
		JButton okButton = new JButton("OK");
		okButton.setFont(buttonFont);
		okButton.setBackground(Color.WHITE);
		okButton.setFocusPainted(false);
		okButton.setBorderPainted(true);

		Object[] options = { okButton };

		JOptionPane pane = new JOptionPane(message, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options);
		JDialog dialog = pane.createDialog("Error");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		dialog.setVisible(true);
	}

	public static void okB2() {
		JButton adminButton = new JButton("Admin");
		adminButton.setFont(buttonFont);
		adminButton.setBackground(Color.WHITE);
		adminButton.setFocusPainted(false);
		adminButton.setBorderPainted(true);

		JButton librarianButton = new JButton("Librarian");
		librarianButton.setFont(buttonFont);
		librarianButton.setBackground(Color.WHITE);
		librarianButton.setFocusPainted(false);
		librarianButton.setBorderPainted(true);

		Object[] options = { adminButton, librarianButton };

		JOptionPane pane = new JOptionPane(message, JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options);
		JDialog dialog = pane.createDialog("Error");

		adminButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				line2.setIcon(null);
				line1.setIcon(adminLine);
				adminLog = true;
				dialog.dispose();
			}
		});

		librarianButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				line1.setIcon(null);
				line2.setIcon(librarianLine);
				librarianLog = true;
				dialog.dispose();
			}
		});
		dialog.setVisible(true);
	}

	public static void paintRoundedComponent(Graphics g, JComponent c) { // For Customized Rounded Text field
		int w = c.getWidth();
		int h = c.getHeight();
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(c.getBackground());
		g.fillRoundRect(0, 0, w - 1, h - 1, h, h);
		g2.setColor(Color.WHITE);
		g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
		g2.dispose();
	}

	public static void customizeField(JTextField textField, JPasswordField passwordField) {
		// Set the field to be transparent
		textField.setOpaque(false);
		passwordField.setOpaque(false);
		// Set the border
		textField.setBorder(BorderFactory.createEmptyBorder(9, 16, 9, 32));
		passwordField.setBorder(BorderFactory.createEmptyBorder(9, 16, 9, 32));
		// Set the font and maximum size
		textField.setFont(normalFont);
		passwordField.setFont(normalFont);
		textField.setForeground(Color.WHITE);
		passwordField.setForeground(Color.WHITE);
		textField.setMaximumSize(new Dimension(292, 25));
		passwordField.setMaximumSize(new Dimension(292, 25));
		// Set the background color to transparent
		textField.setBackground(new Color(0, 0, 0, 0));
		passwordField.setBackground(new Color(0, 0, 0, 0));
		// Set the Guide line white also
		textField.setCaretColor(Color.WHITE);
		passwordField.setCaretColor(Color.WHITE);
	}

	public static DocumentFilter createFilter() {
		// Super Advanced Code "Removes Spaces and Special Characters Except Underscore"
		return new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				fb.insertString(offset, string.replaceAll("[^\\w_]+", ""), attr);
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
					throws BadLocationException {
				fb.replace(offset, length, string.replaceAll("[^\\w_]+", ""), attrs);
			}
		};
	}

	public String getText() {
		return new String(textField.getText());
	}
}