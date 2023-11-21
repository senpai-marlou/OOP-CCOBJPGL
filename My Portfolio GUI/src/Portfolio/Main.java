package Portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Main extends JFrame {

	public static JLayeredPane layeredPane = new JLayeredPane();

	static JFrame frame = new JFrame();
	static JPanel contentPanel = new JPanel();

	// Background
	static ImageIcon BG = new ImageIcon("BG.png");
	static JLabel background = new JLabel(BG);

	// Heading
	static ImageIcon headingBG = new ImageIcon("heading.png");
	static JLabel heading = new JLabel(headingBG);

	// Going Up button
	static ImageIcon upButtonBG = new ImageIcon("upButton.png");
	static JButton upButton = new JButton(upButtonBG);

	// Content Panel Buttons
	static inheritance socials = new inheritance();
	static inheritance aboutMe = new inheritance();

	static inheritance downloadCV = new inheritance();

	// Hobbies
	static inheritance gaming = new inheritance();
	static inheritance coding = new inheritance();
	static inheritance movies = new inheritance();

	// Social
	static inheritance facebook = new inheritance();
	static inheritance instagram = new inheritance();
	static inheritance discord = new inheritance();
	static inheritance linkedin = new inheritance();
	static inheritance github = new inheritance();

	// Heading Buttons
	static inheritance toHome = new inheritance();
	static inheritance toAbout = new inheritance();
	static inheritance toSkills = new inheritance();
	static inheritance toHobbies = new inheritance();
	static inheritance toEducation = new inheritance();
	static inheritance toContact = new inheritance();

	// Scroll Pane
	static JScrollPane scrollPane = new JScrollPane();

	// For animation
	static private final int animationDuration = 3; // Ads Animation duration in milliseconds
	static private final int animationSteps = 125; // Ads Number of animation steps

	static Timer slideToTop;
	static Timer slideToAbout;
	static Timer slideToSkills;
	static Timer slideToHobbies;
	static Timer slideToEducation;
	static Timer slideToContact;

	public Boolean initialized;
	public String printError = "";

	public static void main(String[] args) {
		createUI();
	}

	static void runUI() {

		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slideToTop.start();
			}
		});

		// Buttons
		toHome.addActionListener(e -> {
			upButton.doClick();
		});

		toAbout.addActionListener(e -> {
			slideToAbout.start();
		});

		toSkills.addActionListener(e -> {
			slideToSkills.start();
		});

		toHobbies.addActionListener(e -> {
			slideToHobbies.start();
		});

		toEducation.addActionListener(e -> {
			slideToEducation.start();
		});

		toContact.addActionListener(e -> {
			slideToContact.start();
		});

		aboutMe.addActionListener(e -> {
			slideToAbout.start();
		});

		socials.addActionListener(e -> {
			slideToContact.start();
		});

		// Clickable Buttons (Contents)
		downloadCV.addActionListener(new ActionListener() { // ActionListener to the downloadCV button
			@Override
			public void actionPerformed(ActionEvent e) {
				downloadCV.onClick();
			}
		});

		gaming.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gaming.onGaming();
			}
		});

		coding.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coding.onCoding();
			}
		});

		movies.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movies.onMovies();
			}
		});

		facebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				facebook.onFacebook();
			}
		});

		instagram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				instagram.onInstagram();
			}
		});

		discord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				discord.onDiscord();
			}
		});

		linkedin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				linkedin.onLinkedin();
			}
		});

		github.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				github.onGithub();
			}
		});

// Timer Animation -----------------------------------------------------------------------------------------------

		slideToTop = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;
			private int startY = scrollPane.getViewport().getViewPosition().y;

			private int distance = startY - 2;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = scrollPane.getViewport().getViewPosition().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((distance - initialY) * easedStep));

				scrollPane.getViewport().setViewPosition(new Point(0, y));

				if (y == 0) { // Stop the timer
					slideToTop.stop();
					step = 0;
				}
			}
		});

		slideToAbout = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;
			private int startY = scrollPane.getViewport().getViewPosition().y;

			private int distance = startY + 518;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = scrollPane.getViewport().getViewPosition().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((distance - initialY) * easedStep));

				scrollPane.getViewport().setViewPosition(new Point(0, y));

				if (y == 518) { // Stop the timer
					slideToAbout.stop();
					step = 0;
				}
			}
		});

		slideToSkills = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;
			private int startY = scrollPane.getViewport().getViewPosition().y;

			private int distance = startY + 976;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = scrollPane.getViewport().getViewPosition().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((distance - initialY) * easedStep));

				scrollPane.getViewport().setViewPosition(new Point(0, y));

				if (y == 976) { // Stop the timer
					slideToSkills.stop();
					step = 0;
				}
			}
		});

		slideToHobbies = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;
			private int startY = scrollPane.getViewport().getViewPosition().y;

			private int distance = startY + 1452;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = scrollPane.getViewport().getViewPosition().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((distance - initialY) * easedStep));

				scrollPane.getViewport().setViewPosition(new Point(0, y));

				if (y == 1452) { // Stop the timer
					slideToHobbies.stop();
					step = 0;
				}
			}
		});

		slideToEducation = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;
			private int startY = scrollPane.getViewport().getViewPosition().y;

			private int distance = startY + 1955;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = scrollPane.getViewport().getViewPosition().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((distance - initialY) * easedStep));

				scrollPane.getViewport().setViewPosition(new Point(0, y));

				if (y == 1955) { // Stop the timer
					slideToEducation.stop();
					step = 0;
				}
			}
		});

		slideToContact = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;
			private int startY = scrollPane.getViewport().getViewPosition().y;

			private int distance = startY + 2515;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = scrollPane.getViewport().getViewPosition().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((distance - initialY) * easedStep));

				scrollPane.getViewport().setViewPosition(new Point(0, y));

				if (y == 2515) { // Stop the timer
					slideToContact.stop();
					step = 0;
				}
			}
		});

	}

	@SuppressWarnings("removal")
	public static void createUI() {

		frame.setUndecorated(true); // Remove the window decorations
		frame.setSize(1115, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE); // Set the background color to white
		frame.setLocationRelativeTo(null); // Center the frame on the screen
		frame.getContentPane().setLayout(null); // Use null layout for custom component positioning
		frame.setVisible(true);

		layeredPane.setSize(frame.getSize());
		frame.add(layeredPane);

		heading.setBounds(0, 0, 1102, 73);
		heading.setOpaque(false);

		// Heading buttons
		upButton.setBounds(1044, 505, 38, 44);
		upButton.setContentAreaFilled(false);
		upButton.setBorderPainted(false);
		upButton.setOpaque(false);

		/*
		 * The commented codes below are the codes that have been reduced due to the
		 * inherited properties from the parent class.
		 */

		toHome.setBounds(552, 21, 40, 20);
//		toHome.setContentAreaFilled(false);
//		toHome.setBorderPainted(false);
//		toHome.setOpaque(false);

		toAbout.setBounds(618, 21, 42, 20);
//		toAbout.setContentAreaFilled(false);
//		toAbout.setBorderPainted(false);
//		toAbout.setOpaque(false);

		toSkills.setBounds(686, 21, 38, 20);
//		toSkills.setContentAreaFilled(false);
//		toSkills.setBorderPainted(false);
//		toSkills.setOpaque(false);

		toHobbies.setBounds(748, 21, 52, 20);
//		toHobbies.setContentAreaFilled(false);
//		toHobbies.setBorderPainted(false);
//		toHobbies.setOpaque(false);

		toEducation.setBounds(828, 21, 63, 20);
//		toEducation.setContentAreaFilled(false);
//		toEducation.setBorderPainted(false);
//		toEducation.setOpaque(false);

		toContact.setBounds(917, 21, 53, 20);
//		toContact.setContentAreaFilled(false);
//		toContact.setBorderPainted(false);
//		toContact.setOpaque(false);

		// content Panel buttons
		aboutMe.setBounds(259, 403, 148, 48);
//		aboutMe.setContentAreaFilled(false);
//		aboutMe.setBorderPainted(true);
//		aboutMe.setOpaque(false);

		downloadCV.setBounds(581, 959, 180, 55);
//		downloadCV.setContentAreaFilled(false);
//		downloadCV.setBorderPainted(true);
//		downloadCV.setOpaque(false);

		socials.setBounds(124, 236, 25, 105);
//		socials.setContentAreaFilled(false);
//		socials.setBorderPainted(true);
//		socials.setOpaque(false);

		gaming.setBounds(211, 1896, 100, 20);
//		gaming.setContentAreaFilled(false);
//		gaming.setBorderPainted(true);
//		gaming.setOpaque(false);

		coding.setBounds(472, 1896, 100, 20);
//		coding.setContentAreaFilled(false);
//		coding.setBorderPainted(true);
//		coding.setOpaque(false);

		movies.setBounds(732, 1896, 100, 20);
//		movies.setContentAreaFilled(false);
//		movies.setBorderPainted(true);
//		movies.setOpaque(false);

		// Social
		facebook.setBounds(412, 2995, 39, 37);
//		facebook.setContentAreaFilled(false);
//		facebook.setBorderPainted(true);
//		facebook.setOpaque(false);

		instagram.setBounds(474, 2995, 38, 37);
//		instagram.setContentAreaFilled(false);
//		instagram.setBorderPainted(true);
//		instagram.setOpaque(false);

		discord.setBounds(535, 2995, 38, 36);
//		discord.setContentAreaFilled(false);
//		discord.setBorderPainted(true);
//		discord.setOpaque(false);

		linkedin.setBounds(597, 2995, 37, 36);
//		linkedin.setContentAreaFilled(false);
//		linkedin.setBorderPainted(true);
//		linkedin.setOpaque(false);

		github.setBounds(657, 2995, 37, 36);
//		github.setContentAreaFilled(false);
//		github.setBorderPainted(true);
//		github.setOpaque(false);

		// Add Cursor
		upButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		toHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		toAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		toSkills.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		toHobbies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		toEducation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		toContact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		aboutMe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		downloadCV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		socials.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		gaming.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		coding.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		movies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		facebook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		instagram.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		discord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		linkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		github.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Add & Customized Scroll Pane
		scrollPane.setBounds(1, -2, 1115, 571);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.getVerticalScrollBar().setUnitIncrement(8);

		// For Up button show | hide
		scrollPane.getVerticalScrollBar().addAdjustmentListener(e -> {
			int scrollPosition = scrollPane.getVerticalScrollBar().getValue();
			boolean showUpButton = scrollPosition >= 518;
			if (showUpButton) {
				upButton.setVisible(true);
			} else {
				upButton.setVisible(false);
			}
		});

		// JPanel for the content
		contentPanel.setLayout(null); // Use null layout for absolute positioning
		contentPanel.setPreferredSize(new Dimension(1115, 3168));

		// Add the background label to the content panel
		background.setBounds(-4, -4, BG.getIconWidth(), BG.getIconHeight());

		// Layers for contentPanel
		contentPanel.add(aboutMe);
		contentPanel.add(downloadCV);
		contentPanel.add(socials);
		contentPanel.add(gaming);
		contentPanel.add(coding);
		contentPanel.add(movies);
		contentPanel.add(facebook);
		contentPanel.add(instagram);
		contentPanel.add(discord);
		contentPanel.add(linkedin);
		contentPanel.add(github);

		contentPanel.add(background);

		// Main Layers (To ensure my design have no overlapping elements.)
		layeredPane.add(scrollPane, new Integer(0));
		layeredPane.add(heading, new Integer(1));
		layeredPane.add(upButton, new Integer(1));
		layeredPane.add(toHome, new Integer(2));
		layeredPane.add(toAbout, new Integer(2));
		layeredPane.add(toSkills, new Integer(2));
		layeredPane.add(toHobbies, new Integer(2));
		layeredPane.add(toEducation, new Integer(2));
		layeredPane.add(toContact, new Integer(2));

		scrollPane.setViewportView(contentPanel); // Set the content panel as the view for the scroll pane

		// To main UI
		runUI();
	}

	public void initializeGUI() {
		try {
			main(null);
			runUI();
			initialized = true;
		} catch (Error e) {
			initialized = false;
			String errorMessage = e.getMessage().replaceAll("Type mismatch:.*", "").trim();
			StackTraceElement errorStack = e.getStackTrace()[0];
			printError = String.format("Error in %s.%s - Syntax error at line %d: %s", errorStack.getClassName(),
					errorStack.getMethodName(), errorStack.getLineNumber(), errorMessage);
		}
	}

	public static void close() {
		layeredPane.removeAll();
		contentPanel.removeAll();
		frame.dispose();
	}
}

// By: Marlou - Open source (Custom Scroll Bar)
class CustomScrollBarUI extends BasicScrollBarUI { // Custom UI for the scroll bar
	private final int radius = 9;

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new Color(119, 119, 119));
		g2.fillRoundRect(thumbBounds.x + 2, thumbBounds.y + 2, thumbBounds.width - 4, thumbBounds.height - 4, radius,
				radius);
		g2.setColor(new Color(150, 150, 150));
		g2.dispose();
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(new Color(200, 200, 200));
		g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	}

	private JButton createZeroButton() {
		JButton button = new JButton();
		Dimension zeroDim = new Dimension(0, 0);
		button.setPreferredSize(zeroDim);
		button.setMinimumSize(zeroDim);
		button.setMaximumSize(zeroDim);
		return button;
	}
}
