
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class mainScreen extends JFrame {

	public static final long serialVersionUID = 1L;

	static JLayeredPane layeredPane = new JLayeredPane();

	public static JFrame mainFrame = new JFrame();
	public static JPanel mainJPanel = new JPanel();

	// For animation of Ads -------------------------------------------------------
	static JPanel ads = new JPanel();
	static Timer adsTimerRL;
	static Timer adsTimerLR;
	static private final int animationDuration = 3; // Ads Animation duration in milliseconds
	static private final int animationSteps = 100; // Ads Number of animation steps 145
	// ----------------------------------------------------------------------------

	// For all animation
	static int x = 0;
	static boolean open = true;

	// For Create Account Panel ---------------------------------------------------

	static Timer createAccTimerIN;
	static Timer createAccTimerOUT;

	// For Login Account Panel ---------------------------------------------------

	static Timer loginAccTimerOPEN1;
	static Timer loginAccTimerOPEN2;

	static Timer loginAccTimerIN;
	static Timer loginAccTimerOUT;

	// For Login and Create account button ----------------------------------------

	public static JButton createAccountB = new JButton();
	public static JButton loginAccountB = new JButton();

	static JLabel createAccLabel = new JLabel("SIGN UP");
	static JLabel loginAccLabel = new JLabel("LOGIN");

	static boolean createAccOpen = false;
	static boolean loginAccOpen = false;

	static boolean createAccSelected = true;
	static boolean loginAccSelected = false;

	public static Timer caTimer; // Create Account "Main Button" Timer Animation
	public static Timer laTimer; // Login Account "Main Button" Timer Animation

	static ImageIcon buttonSlider = new ImageIcon("buttonSlider.png");
	static JLabel buttonSliderLabel = new JLabel(buttonSlider);

	static Timer timerToBlack;
	static Timer timerToWhite;
	static Timer timerToBlack1;
	static Timer timerToWhite1;

	static int startRed = 255;
	static int startGreen = 255;
	static int startBlue = 255;
	static int endRed = 38;
	static int endGreen = 38;
	static int endBlue = 38;
	static float colorValueToBlack = 0f;
	static float colorValueToWhite = 0f;

	static ImageIcon historyBG = new ImageIcon("ourHistory.png");
	static ImageIcon contactBG = new ImageIcon("contactUs.png");

	static JLabel ourHistory = new JLabel(historyBG);
	static JLabel contactUss = new JLabel(contactBG);

	static JButton back = new JButton();

	// ----------------------------------------------------------------------------

	public static void main(String[] args) {
		createUI();
	}

	@SuppressWarnings("removal")
	public static void loginFrame() {

		ImageIcon background = new ImageIcon("finalBG.png"); // mainFrame1 background
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, 1366, 769);

		ImageIcon titleBG = new ImageIcon("recipeTitle.png"); // Recipe Management Title
		JLabel titleBGLabel = new JLabel(titleBG);
		titleBGLabel.setBounds(26, 97, 650, 647);

		ImageIcon rightArrow = new ImageIcon("aRight.png"), leftArrow = new ImageIcon("aLeft.png");
		JLabel leftArrowLabel = new JLabel(leftArrow);
		leftArrowLabel.setBounds(681, 410, 18, 18);
		leftArrowLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		leftArrowLabel.setVisible(true);

		ourHistory.setBounds(0, 0, 1366, 769);
		contactUss.setBounds(0, 0, 1366, 769);

		ourHistory.setVisible(false);
		contactUss.setVisible(false);

		back.setBounds(27, 20, 92, 40);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setOpaque(false);
		back.setVisible(false);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

// Ads panel ----------------------------------------------------------------------------
		ImageIcon adsBG = new ImageIcon("ads.png"); // Recipe Management Title
		JLabel adsBGLabel = new JLabel(adsBG);
		adsBGLabel.setBounds(0, 0, 650, 647);

		JButton viewSchool = new JButton(), contactUs = new JButton(), aboutUs = new JButton();

		viewSchool.setBorderPainted(false);
		viewSchool.setContentAreaFilled(false);
		viewSchool.setOpaque(false);

		contactUs.setBorderPainted(false);
		contactUs.setContentAreaFilled(false);
		contactUs.setOpaque(false);

		aboutUs.setBorderPainted(false);
		aboutUs.setContentAreaFilled(false);
		aboutUs.setOpaque(false);

		// Button locations
		viewSchool.setBounds(600, 10, 40, 40);
		contactUs.setBounds(590, 354, 40, 40);
		aboutUs.setBounds(265, 344, 40, 40);

		// Add cursor
		viewSchool.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contactUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aboutUs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ads.setBounds(691, 97, 650, 647);
		ads.setLayout(null);
		ads.setOpaque(false);
		ads.setVisible(true);

		// Adding the elements in the ads panel
		ads.add(aboutUs);
		ads.add(contactUs);
		ads.add(viewSchool);
		ads.add(adsBGLabel);

		// Action Listener
		viewSchool.addActionListener(e -> {
			try {
				Desktop.getDesktop().browse(new URI("https://national-u.edu.ph/nu-manila/"));
			} catch (IOException | URISyntaxException ex) {
				ex.printStackTrace();
			}
		});

		contactUs.addActionListener(e -> {
			contactUss.setVisible(true);
			back.setVisible(true);
		});

		aboutUs.addActionListener(e -> {
			ourHistory.setVisible(true);
			back.setVisible(true);
		});

		back.addActionListener(e -> {
			contactUss.setVisible(false);
			ourHistory.setVisible(false);
			back.setVisible(false);
		});

// Create Account Panel ----------------------------------------------------------------------------------

		// Create an instance of createAccount Panel
		createAccount createAccountPanel = new createAccount();
		JPanel createAccount = createAccountPanel.getcreateAccount();

// Login Account Panel -----------------------------------------------------------------------------------

		// Create an instance of loginAccount Panel
		loginAccount loginAccountPanel = new loginAccount();
		JPanel loginAccount = loginAccountPanel.getloginAccount();

// All Timer Animation

// Login Account -----------------------------------------------------------------------------------------
		loginAccTimerOPEN1 = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialX = loginAccount.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((792 - initialX) * easedStep));

				loginAccount.setBounds(x, 184, 445, 474);

				if (x == 792) { // Stop the timer when the panel has finished expanding
					loginAccTimerOPEN1.stop();
					step = 0;
				}
			}
		});

		loginAccTimerOPEN2 = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialX = loginAccount.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((1351 - initialX) * easedStep));

				loginAccount.setBounds(x, 184, 445, 474);

				if (x == 1351) { // Stop the timer when the panel has finished expanding
					loginAccTimerOPEN2.stop();
					step = 0;
				}
			}
		});

		loginAccTimerIN = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				loginAccount.setBounds(233, 184, 445, 474);
				if (step == 0) {
					initialX = loginAccount.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((792 - initialX) * easedStep));

				loginAccount.setBounds(x, 184, 445, 474);

				if (x == 792) { // Stop the timer when the panel has finished expanding
					loginAccTimerIN.stop();
					step = 0;
				}
			}
		});

		loginAccTimerOUT = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				loginAccount.setBounds(792, 184, 445, 474);
				if (step == 0) {
					initialX = loginAccount.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((233 - initialX) * easedStep));

				loginAccount.setBounds(x, 184, 445, 474);

				if (x == 233) { // Stop the timer when the panel has finished expanding
					loginAccTimerOUT.stop();
					step = 0;
				}
			}
		});
// Create Account ------------------------------------------------------------------------------------
		createAccTimerIN = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialX = createAccount.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((792 - initialX) * easedStep));

				createAccount.setBounds(x, 84, 445, 673);

				if (x == 792) { // Stop the timer when the panel has finished expanding
					createAccTimerIN.stop();
					step = 0;
				}
			}
		});

		createAccTimerOUT = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialX = createAccount.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((1351 - initialX) * easedStep));

				createAccount.setBounds(x, 84, 445, 673);

				if (x == 1351) { // Stop the timer when the panel has finished expanding
					createAccTimerOUT.stop();
					step = 0;
				}
			}
		});

// Ads Panel Animation -------------------------------------------------------------------------------
		adsTimerRL = new Timer(animationDuration, new ActionListener() {
			// Timer for sliding the panel from right to left
			private int step = 0;
			private int initialWidth;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (step == 0) {
					initialWidth = ads.getWidth();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);

				int width = Math.round(initialWidth - (initialWidth * easedStep));
				ads.setBounds(691, 97, width, 647);

				if (width <= 0) { // Stop the timer when the panel has finished sliding
					adsTimerRL.stop();
					ads.setBounds(691, 97, 0, 647);
					step = 0;
					ads.repaint();
				}
			}
		});

		adsTimerLR = new Timer(animationDuration, new ActionListener() {
			// Timer for expanding the panel from left to right
			private int step = 0;
			private int initialWidth;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (step == 0) {
					initialWidth = ads.getWidth();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int width = Math.round(initialWidth + ((650 - initialWidth) * easedStep));

				ads.setBounds(691, 97, width, 647);

				if (width >= 650) { // Stop the timer when the panel has finished expanding
					adsTimerLR.stop();
					ads.setBounds(691, 97, 650, 647);
					step = 0;
					ads.repaint();
				}
			}
		});

// Font Animation ------------------------------------------------------------------------------------
		timerToBlack = new Timer(3, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorValueToBlack += 0.01f;
				if (colorValueToBlack > 1f) {
					colorValueToBlack = 1f;
					timerToBlack.stop();
				}

				int red = (int) (startRed + (endRed - startRed) * colorValueToBlack);
				int green = (int) (startGreen + (endGreen - startGreen) * colorValueToBlack);
				int blue = (int) (startBlue + (endBlue - startBlue) * colorValueToBlack);

				Color interpolatedColor = new Color(red, green, blue);
				createAccLabel.setForeground(interpolatedColor);
			}
		});

		timerToWhite = new Timer(3, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorValueToWhite += 0.01f;
				if (colorValueToWhite > 1f) {
					colorValueToWhite = 1f;
					timerToWhite.stop();
				}

				int red = (int) (endRed + (startRed - endRed) * colorValueToWhite);
				int green = (int) (endGreen + (startGreen - endGreen) * colorValueToWhite);
				int blue = (int) (endBlue + (startBlue - endBlue) * colorValueToWhite);

				Color interpolatedColor = new Color(red, green, blue);
				createAccLabel.setForeground(interpolatedColor);
			}
		});

		timerToBlack1 = new Timer(3, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorValueToBlack += 0.01f;
				if (colorValueToBlack > 1f) {
					colorValueToBlack = 1f;
					timerToBlack1.stop();
				}

				int red = (int) (startRed + (endRed - startRed) * colorValueToBlack);
				int green = (int) (startGreen + (endGreen - startGreen) * colorValueToBlack);
				int blue = (int) (startBlue + (endBlue - startBlue) * colorValueToBlack);

				Color interpolatedColor = new Color(red, green, blue);
				loginAccLabel.setForeground(interpolatedColor);
			}
		});

		timerToWhite1 = new Timer(3, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorValueToWhite += 0.01f;
				if (colorValueToWhite > 1f) {
					colorValueToWhite = 1f;
					timerToWhite1.stop();
				}

				int red = (int) (endRed + (startRed - endRed) * colorValueToWhite);
				int green = (int) (endGreen + (startGreen - endGreen) * colorValueToWhite);
				int blue = (int) (endBlue + (startBlue - endBlue) * colorValueToWhite);

				Color interpolatedColor = new Color(red, green, blue);
				loginAccLabel.setForeground(interpolatedColor);
			}
		});

// Button Slider --------------------------------------------------------------------------------------
		buttonSliderLabel.setBounds(1228, 33, 111, 43);

		caTimer = new Timer(5, new ActionListener() {
			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialX = buttonSliderLabel.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((1228 - initialX) * easedStep));

				buttonSliderLabel.setBounds(x, 33, 111, 43);

				if (x == 1228) { // Stop the timer when the panel has finished expanding
					caTimer.stop();
					step = 0;
					buttonSliderLabel.repaint();
				}
			}
		});

		laTimer = new Timer(5, new ActionListener() {
			private int step = 0;
			private int initialX;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialX = buttonSliderLabel.getX();
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int x = Math.round(initialX + ((1117 - initialX) * easedStep));

				buttonSliderLabel.setBounds(x, 33, 111, 43);

				if (x == 1117) { // Stop the timer when the panel has finished expanding
					laTimer.stop();
					step = 0;
				}
			}
		});

// Animation Button -------------------------------------------------------------------------------------

		createAccountB.addActionListener(e -> {
			leftArrowLabel.setIcon(rightArrow);

			createAccOpen = true;
			createAccSelected = true;

			// Button Animation
			caTimer.start();

			// Full Animation
			if (!open) {

				if (loginAccSelected && loginAccOpen) {
					createAccSelected = true;

					loginAccTimerOUT.start();
					timerToWhite.start();
					timerToBlack1.start();
					createAccTimerIN.start();

					loginAccSelected = false;
				} else if (createAccSelected && loginAccSelected) {
					createAccSelected = true;
					timerToWhite.start();
					timerToBlack1.start();
					createAccTimerIN.start();
					loginAccSelected = false;
				} else if (createAccSelected && !loginAccSelected) {
					createAccSelected = true;
					timerToWhite.start();
				}
			}

			if (open) {
				if (createAccSelected) {

					createAccSelected = true;
					createAccOpen = true;

					adsTimerRL.start();
					createAccTimerIN.start();
					timerToWhite.start();
					timerToBlack1.start();
					open = false;
				}
			}
			loginAccOpen = false;
			createAccOpen = true;
			resetValues();
		});

		loginAccountB.addActionListener(e -> {
			leftArrowLabel.setIcon(rightArrow);

			loginAccOpen = true;
			loginAccSelected = true;

			// Button Animation
			laTimer.start();

			// Full Animation
			if (!open) {

				if (createAccSelected && createAccOpen) {
					loginAccOpen = true;

					timerToWhite1.start();
					timerToBlack.start();
					loginAccTimerIN.start();
					createAccTimerOUT.start();

					createAccSelected = false;
				} else if (loginAccSelected && createAccSelected) {
					loginAccOpen = true;

					timerToWhite1.start();
					timerToBlack.start();
					loginAccTimerIN.start();

					createAccSelected = false;
				} else if (loginAccSelected && !createAccSelected) {
					loginAccOpen = true;

					timerToWhite1.start();
				}
			}

			if (open) {
				if (loginAccSelected) {

					loginAccSelected = true;
					loginAccOpen = true;

					adsTimerRL.start();
					loginAccTimerOPEN1.start();

					timerToWhite1.start();
					timerToBlack.start();
					open = false;
				}
			}

			loginAccOpen = true;
			createAccOpen = false;
			resetValues();
		});

		// Ads animation button
		leftArrowLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (open) {
					open = false;
					if (loginAccSelected) {
						adsTimerRL.start();
						loginAccTimerOPEN1.start();
						timerToWhite1.start();

						loginAccOpen = true;

						leftArrowLabel.setIcon(rightArrow);
					} else if (createAccSelected) {
						adsTimerRL.start();
						createAccTimerIN.start();
						timerToWhite.start();

						createAccOpen = true;

						leftArrowLabel.setIcon(rightArrow);
					}
				} else {
					if (loginAccSelected) {
						loginAccTimerOPEN2.start();
						adsTimerLR.start();
						leftArrowLabel.setIcon(leftArrow);
						open = true;
					} else if (createAccSelected) {
						adsTimerLR.start();
						createAccTimerOUT.start();
						leftArrowLabel.setIcon(leftArrow);
						open = true;
					}
				}
				ads.repaint();
			}
		});

//-------------------------------------------------------------------------------------------------------	

		// Images | Icons
		layeredPane.add(backgroundLabel, new Integer(0));
		layeredPane.add(leftArrowLabel, new Integer(1));
		layeredPane.add(titleBGLabel, new Integer(1));

		// Buttons | Labels
		layeredPane.add(createAccountB, new Integer(1));
		layeredPane.add(loginAccountB, new Integer(1));
		layeredPane.add(buttonSliderLabel, new Integer(1));
		layeredPane.add(createAccLabel, new Integer(2));
		layeredPane.add(loginAccLabel, new Integer(2));

		// Panels
		layeredPane.add(createAccount, new Integer(1));
		layeredPane.add(loginAccount, new Integer(1));
		layeredPane.add(ads, new Integer(1));

		// History | Contact
		layeredPane.add(ourHistory, new Integer(3));
		layeredPane.add(contactUss, new Integer(3));
		layeredPane.add(back, new Integer(4));
	}

	static void createUI() {

		mainFrame.setSize(1366, 768); // Best Size for GUI system
		mainFrame.setUndecorated(true);

		mainJPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int cornerRadius = 35; // The roundness of the Frame
				int width = getWidth();
				int height = getHeight();

				g2.setColor(new Color(0, 0, 0, 0));
				g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
			}
		};

		mainFrame.setContentPane(mainJPanel);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setBackground(new Color(0, 0, 0, 0));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

		// Create Account main button
		createAccountB.setBounds(1228, 30, 112, 48);
		createAccountB.setBorderPainted(false);
		createAccountB.setContentAreaFilled(false);
		createAccountB.setOpaque(false);
		createAccountB.setVisible(true);

		// Login Account main button
		loginAccountB.setBounds(1113, 30, 115, 48);
		loginAccountB.setBorderPainted(false);
		loginAccountB.setContentAreaFilled(false);
		loginAccountB.setOpaque(false);
		loginAccountB.setVisible(true);

		// Sign Up
		createAccLabel.setBounds(1256, 41, 60, 25);
		createAccLabel.setFont(new Font("Poppins Bold", Font.TRUETYPE_FONT, 13));
		createAccLabel.setForeground(new Color(255, 255, 255));

		// Login
		loginAccLabel.setBounds(1152, 41, 60, 25);
		loginAccLabel.setFont(new Font("Poppins Bold", Font.TRUETYPE_FONT, 13));
		loginAccLabel.setForeground(new Color(38, 38, 38));

		// Layered Panel
		layeredPane.setSize(mainJPanel.getSize());
		mainJPanel.add(layeredPane);

		SwingUtilities.invokeLater(mainScreen::loginFrame);
	}

	public static void resetValues() {
		startRed = 255;
		startGreen = 255;
		startBlue = 255;
		endRed = 38;
		endGreen = 38;
		endBlue = 38;
		colorValueToBlack = 0f;
		colorValueToWhite = 0f;
	}
}
