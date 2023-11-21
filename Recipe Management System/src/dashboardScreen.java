import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

@SuppressWarnings({ "removal", "serial" })
public class dashboardScreen extends JFrame {

	public static int index;

	public static JLayeredPane layeredPaneDashboard = new JLayeredPane();

	public static JFrame dashboardFrame = new JFrame();
	public static JPanel dashboardJPanel = new JPanel();

	// Scroll Panes
	static JScrollPane scrollPaneAll = new JScrollPane();
	static JScrollPane scrollPaneFilipino = new JScrollPane();
	static JScrollPane scrollPaneItalian = new JScrollPane();
	static JScrollPane scrollPaneChinese = new JScrollPane();
	static JScrollPane scrollPaneJapanese = new JScrollPane();

	// For animation
	static private final int animationDuration = 3; // Ads Animation duration in milliseconds
	static private final int animationSteps = 60;

	// Logics
	static int recipeRun = 0;
	static int mealRun = 0;
	static boolean dashboardIsOpen = true;

	// User
	public static JLabel name = new JLabel();

	// Side Panel Animation
	static JLabel greenBarBG = new JLabel(new ImageIcon("greenBar.png"));
	static Timer slideToHome;
	static Timer slideToRecipe;
	static Timer slideToMeal;

	// Side Panel Buttons
	static JButton homeButton = new JButton();
	static JButton recipeButton = new JButton();
	static JButton mealButton = new JButton();
	static JButton logout = new JButton();

	// Add recipes button
	static JButton addRecipeButton = new JButton();
	public static JButton backToRecipe = new JButton();
	static JButton saveAddRecipe = new JButton();

	// View | Edit | Delete
	static JButton view = new JButton();
	static JButton editButton = new JButton();
	static JButton saveRecipe = new JButton();
	static JButton deleteButton = new JButton();

	// Choices Button
	static JButton all = new JButton();
	static JButton filipino = new JButton();
	static JButton italian = new JButton();
	static JButton chinese = new JButton();
	static JButton japanese = new JButton();

	static ImageIcon allIcon = new ImageIcon("All.png");
	static ImageIcon filipinoIcon = new ImageIcon("Filipino.png");
	static ImageIcon italianIcon = new ImageIcon("Italian.png");
	static ImageIcon chineseIcon = new ImageIcon("Chinese.png");
	static ImageIcon japaneseIcon = new ImageIcon("Japanese.png");

	// For meantime code | design only
	static JPanel contentAll = new JPanel();
	static JPanel contentFilipino = new JPanel();
	static JPanel contentItalian = new JPanel();
	static JPanel contentChinese = new JPanel();
	static JPanel contentJapanese = new JPanel();

	// BG
	static JLabel dashboardBG = new JLabel(new ImageIcon("dashboard.png"));
	static JLabel recipeBG = new JLabel(new ImageIcon("recipe.png"));
	static JLabel mealPlanBG = new JLabel(new ImageIcon("mealPlan.png"));

	static JLabel addRecipeBG = new JLabel(new ImageIcon("addRecipe.png"));
	static JLabel viewRecipeBG = new JLabel(new ImageIcon("viewRecipe.png"));
	static JLabel editRecipeBG = new JLabel(new ImageIcon("editRecipe.png"));

	// Set the font and background color for tooltips
	static FontUIResource tooltipFont = new FontUIResource("Poppins", Font.TRUETYPE_FONT, 12);
	static Color tooltipBackground = Color.WHITE;

	static void runDashboard() {

		if (recipeRun == 0) {
			// Don't print the data
		} else {
			printAllData();
		}

		// Side Panel Buttons
		homeButton.addActionListener(e -> {
			slideToHome.start();

			resetChoiceIcons();
			resetScrollPane();
			resetBg();
			resetVisible();
			onButtons();

			mealPlanFeature.mainScroll.setVisible(false);

			dashboardIsOpen = true;
			// Print All the Data contents
			if (recipeRun == 0) {
				// Don't print the data
			} else {
				printAllData();
			}

			all.setIcon(allIcon);
			scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
			scrollPaneAll.setVisible(true);

			dashboardBG.setVisible(true);
		});

		recipeButton.addActionListener(e -> {
			slideToRecipe.start();

			resetChoiceIcons();
			resetScrollPane();
			resetBg();
			resetVisible();
			onButtons();

			mealPlanFeature.mainScroll.setVisible(false);

			dashboardIsOpen = false;
			// Print All the Data contents
			if (recipeRun == 0) {
				// Don't print the data
			} else {
				printAllData();
			}

			all.setIcon(allIcon);
			scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
			scrollPaneAll.setVisible(true);
			addRecipeButton.setVisible(true);

			recipeBG.setVisible(true);
		});

		mealButton.addActionListener(e -> {
			slideToMeal.start();

			resetChoiceIcons();
			resetScrollPane();
			resetBg();
			resetVisible();
			resetButtons();

			if (mealRun == 0) {
				mealPlanFeature.mealPlan();
				mealPlanFeature.mainScroll.setVisible(true);
				mealRun += 1;
			} else if (mealRun == 1) {
				mealPlanFeature.printTable();
				mealPlanFeature.mainScroll.setVisible(true);
				mealRun += 1;
			} else if (1 < mealRun) {
				mealPlanFeature.printTable();
				mealPlanFeature.mainScroll.setVisible(true);
			}

			mealPlanBG.setVisible(true);
			mealPlanFeature.mainPlanPanel.setVisible(true);
		});

		// Add Recipe button
		addRecipeButton.addActionListener(e -> {

			mainButtonsDisable();
			resetContent();

			if (recipeRun == 0) {
				addRecipeFeature.addRecipe();
				recipeRun++;
			} else {
				addRecipeFeature.addRecipePanel.setVisible(true);
			}
			addRecipeBG.setVisible(true);
			backToRecipe.setVisible(true);
			saveAddRecipe.setVisible(true);
		});

		backToRecipe.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			resetBg();
			resetVisible();
			onButtons();
			mainButtons();

//			layeredPaneDashboard.remove(addRecipeFeature.addRecipePanel);

			addRecipeFeature.clearData();
			addRecipeFeature.addRecipePanel.setVisible(false);

			// viewRecipe.clearData();
			layeredPaneDashboard.remove(viewEditRecipe.viewRecipePanel);
			viewEditRecipe.viewRecipePanel.setVisible(false);

			// Removing the View Recipe Panel
			viewEditRecipe.resetValues();
			layeredPaneDashboard.remove(viewEditRecipe.viewRecipePanel2);
			viewEditRecipe.viewRecipePanel2.removeAll();

			// Updates the Data
			printAllData();

			backToRecipe.setVisible(false);
			all.setIcon(allIcon);
			scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
			scrollPaneAll.setVisible(true);
			addRecipeButton.setVisible(true);

			recipeBG.setVisible(true);
		});

		saveAddRecipe.addActionListener(e -> {
			System.out.println("SAVE RECIPE");
			addRecipeFeature.saveData();
			// Print the data in a Graphical Form
			printAllData();
		});

		view.addActionListener(e -> {
			mainButtonsDisable();
			// View Recipe
			editButton.setVisible(true);
			saveRecipe.setVisible(true);
			deleteButton.setVisible(true);
			saveRecipe.setEnabled(false);
		});

		editButton.addActionListener(e -> {
			System.out.println("Edit");
			resetBg();
			saveRecipe.setEnabled(true);
			editRecipeBG.setVisible(true);
			viewEditRecipe.editRecipe();
		});

		saveRecipe.addActionListener(e -> {
			System.out.println("Save Recipe");
			viewEditRecipe.saveData();
		});

		deleteButton.addActionListener(e -> {
			System.out.println("Delete " + index);

			JButton deleteButton = new JButton("Delete");
			deleteButton.setFont(createAccount.buttonFont);
			deleteButton.setBackground(Color.WHITE);
			deleteButton.setFocusPainted(false);
			deleteButton.setBorderPainted(true);

			JButton noButton = new JButton("No");
			noButton.setFont(createAccount.buttonFont);
			noButton.setBackground(Color.WHITE);
			noButton.setFocusPainted(false);
			noButton.setBorderPainted(true);

			Object[] options = { deleteButton, noButton };

			// Set the font for the option pane
			UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));

			JOptionPane pane = new JOptionPane("Are you sure you want to delete this recipe?",
					JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_OPTION, null, options);

			JDialog dialog = pane.createDialog("Confirmation");
			deleteButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Delete");

					addRecipeFeature.deleteRowData();
					printAllData();
					backToRecipe.doClick();
					dialog.dispose();
				}
			});

			noButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("No");
					dialog.dispose();
				}
			});
			dialog.setVisible(true);
		});

		// For logout
		logout();

		// Choices Button listner
		all.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			all.setIcon(allIcon);
			scrollPaneAll.setVisible(true);
		});

		filipino.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			filipino.setIcon(filipinoIcon);
			scrollPaneFilipino.setVisible(true);
		});

		italian.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			italian.setIcon(italianIcon);
			scrollPaneItalian.setVisible(true);
		});

		chinese.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			chinese.setIcon(chineseIcon);
			scrollPaneChinese.setVisible(true);
		});

		japanese.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			japanese.setIcon(japaneseIcon);
			scrollPaneJapanese.setVisible(true);
		});

		// Animation Green Bar
		slideToHome = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = greenBarBG.getLocation().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((78 - initialY) * easedStep));

				greenBarBG.setLocation(0, y);

				if (y == 78) { // Stop the timer
					slideToHome.stop();
					step = 0;
				}
			}
		});

		slideToRecipe = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = greenBarBG.getLocation().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((119 - initialY) * easedStep));

				greenBarBG.setLocation(0, y);

				if (y == 119) { // Stop the timer
					slideToRecipe.stop();
					step = 0;
				}
			}
		});

		slideToMeal = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = greenBarBG.getLocation().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((158 - initialY) * easedStep));

				greenBarBG.setLocation(0, y);

				if (y == 158) { // Stop the timer
					slideToMeal.stop();
					step = 0;
				}
			}
		});

	}

	static void mainButtons() {
		homeButton.setEnabled(true);
		recipeButton.setEnabled(true);
		mealButton.setEnabled(true);
	}

	static void mainButtonsDisable() {
		homeButton.setEnabled(false);
		recipeButton.setEnabled(false);
		mealButton.setEnabled(false);
	}

	static void resetChoiceIcons() {
		all.setIcon(null);
		filipino.setIcon(null);
		italian.setIcon(null);
		chinese.setIcon(null);
		japanese.setIcon(null);
	}

	static void resetScrollPane() {
		scrollPaneAll.setVisible(false);
		scrollPaneFilipino.setVisible(false);
		scrollPaneItalian.setVisible(false);
		scrollPaneChinese.setVisible(false);
		scrollPaneJapanese.setVisible(false);
	}

	static void resetBg() {
		dashboardBG.setVisible(false);
		recipeBG.setVisible(false);
		mealPlanBG.setVisible(false);
		viewRecipeBG.setVisible(false);
		editRecipeBG.setVisible(false);
	}

	static void resetVisible() {
		addRecipeButton.setVisible(false);
		backToRecipe.setVisible(false);
		saveAddRecipe.setVisible(false);

		editButton.setVisible(false);
		saveRecipe.setVisible(false);
		deleteButton.setVisible(false);
	}

	static void onButtons() {
		all.setVisible(true);
		filipino.setVisible(true);
		italian.setVisible(true);
		chinese.setVisible(true);
		japanese.setVisible(true);
	}

	static void resetButtons() {
		all.setVisible(false);
		filipino.setVisible(false);
		italian.setVisible(false);
		chinese.setVisible(false);
		japanese.setVisible(false);
	}

	static void resetContent() {
		resetChoiceIcons();
		resetScrollPane();
		resetBg();
		resetVisible();
		resetButtons();
	}

	// Printing data methods
	@SuppressWarnings("unused")
	static void printAllData() {

		// Resets the Data
		contentAll.removeAll();
		contentFilipino.removeAll();
		contentItalian.removeAll();
		contentChinese.removeAll();
		contentJapanese.removeAll();

		// Define the file path in the Downloads folder
		String filePath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator
				+ "PrintedData.csv";

		// Read the CSV file and create buttons for each recipe
		try {
			// Fonts
			Font recipeFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 25);
			Font mealTypeFont = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 13);
			Font cuisinelFont = new Font("Arial", Font.BOLD, 9);
			Font time = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 10);

			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;

			// For All contents
			int countAll = 0;
			int readCountAll = 0;
			int xAll = 0;
			int yAll = 0;

			// For Filipino contents
			int countFilipino = 0;
			int readCountFilipino = 0;
			int xFilipino = 0;
			int yFilipino = 0;

			// For Italian contents
			int countItalian = 0;
			int readCountItalian = 0;
			int xItalian = 0;
			int yItalian = 0;

			// For Chinese contents
			int countChinese = 0;
			int readCountChinese = 0;
			int xChinese = 0;
			int yChinese = 0;

			// For Japanese contents
			int countJapanese = 0;
			int readCountJapanese = 0;
			int xJapanese = 0;
			int yJapanese = 0;

			while ((line = bufferedReader.readLine()) != null) {
				final int rowIndex = countAll; // Index of the row in the CSV file
				String[] recipeData = line.split(",", -1);

				String imageData = recipeData[0].replace("\"", "");
				String recipeNameData = recipeData[1].replace("\"", "");
				String mealTypeData = recipeData[2].replace("\"", "");
				String cuisineData = recipeData[3].replace("\"", "");
				String timeData = recipeData[4].replace("\"", "");
				String favData = recipeData[5].replace("\"", "");

				JButton button = new JButton();
				button.setBounds(xAll, yAll, 276, 281);
				button.setOpaque(false);
				button.setBorderPainted(false);
				button.setContentAreaFilled(false);
				button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				contentAll.add(button);

				if (favData.equals("Yes")) {
					JLabel favorite = new JLabel(new ImageIcon("star.png"));
					favorite.setBounds(xAll + 238, yAll + 186, 22, 21);
					contentAll.add(favorite);
				} else {
					JLabel favorite = new JLabel();
					favorite.setBounds(xAll + 238, yAll + 186, 22, 21);
					contentAll.add(favorite);
				}

				JLabel timeLabel = new JLabel(timeData);
				timeLabel.setFont(time);
				timeLabel.setForeground(new Color(100, 100, 100));
				timeLabel.setBounds(xAll + 38, yAll + 245, 100, 12);
				timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
				timeLabel.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				contentAll.add(timeLabel);

				JLabel recipeLabel = new JLabel(recipeNameData);
				recipeLabel.setFont(recipeFont);
				recipeLabel.setForeground(new Color(38, 38, 38));
				recipeLabel.setBounds(xAll + 18, yAll + 209, 235, 33);
				recipeLabel.setHorizontalAlignment(SwingConstants.LEFT);
				recipeLabel.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				contentAll.add(recipeLabel);

				JLabel mealTypeLabel = new JLabel(mealTypeData);
				mealTypeLabel.setFont(mealTypeFont);
				mealTypeLabel.setForeground(new Color(100, 100, 100));
				mealTypeLabel.setBounds(xAll + 18, yAll + 195, 70, 15);
				mealTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
				mealTypeLabel.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				contentAll.add(mealTypeLabel);

				JLabel cuisineLabel = new JLabel(cuisineData);
				cuisineLabel.setFont(cuisinelFont);
				cuisineLabel.setForeground(Color.WHITE);
				cuisineLabel.setBounds(xAll + 13, yAll + 13, 58, 18);
				cuisineLabel.setHorizontalAlignment(SwingConstants.CENTER);
				cuisineLabel.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				contentAll.add(cuisineLabel);

				JLabel greenLabel = new JLabel(new ImageIcon("greenLabel.png"));
				greenLabel.setBounds(xAll + 13, yAll + 13, 58, 18);
				contentAll.add(greenLabel);

				JLabel curveImage = new JLabel(new ImageIcon("curveImage.png"));
				curveImage.setBounds(xAll, yAll, 276, 281);
				contentAll.add(curveImage);

				JLabel image = new JLabel(new ImageIcon(imageData));
				image.setBounds(xAll + 7, yAll + 7, 262, 171);
				contentAll.add(image);

				JLabel printedBG = new JLabel(new ImageIcon("printedBG.png"));
				printedBG.setBounds(xAll, yAll, 276, 281);
				contentAll.add(printedBG);

				// Add ActionListener to the button
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Clicked button at row index: " + rowIndex);
						index = rowIndex;

						resetContent();
						view.doClick();
						addRecipeBG.setVisible(false);
						viewRecipeBG.setVisible(true);
						backToRecipe.setVisible(true);

						viewEditRecipe.viewRecipe();
					}
				});

				// Print by Cuisine
				if (cuisineData.equals("Filipino")) {
					JButton buttonFilipino = new JButton();
					buttonFilipino.setBounds(xFilipino, yFilipino, 276, 281);
					buttonFilipino.setOpaque(false);
					buttonFilipino.setBorderPainted(false);
					buttonFilipino.setContentAreaFilled(false);
					buttonFilipino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					contentFilipino.add(buttonFilipino);

					if (favData.equals("Yes")) {
						JLabel favorite = new JLabel(new ImageIcon("star.png"));
						favorite.setBounds(xFilipino + 238, yFilipino + 186, 22, 21);
						contentFilipino.add(favorite);
					} else {
						JLabel favorite = new JLabel();
						favorite.setBounds(xFilipino + 238, yFilipino + 186, 22, 21);
						contentFilipino.add(favorite);
					}

					JLabel timeLabelFilipino = new JLabel(timeData);
					timeLabelFilipino.setFont(time);
					timeLabelFilipino.setForeground(new Color(100, 100, 100));
					timeLabelFilipino.setBounds(xFilipino + 38, yFilipino + 245, 100, 12);
					timeLabelFilipino.setHorizontalAlignment(SwingConstants.LEFT);
					timeLabelFilipino.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentFilipino.add(timeLabelFilipino);

					JLabel recipeLabelFilipino = new JLabel(recipeNameData);
					recipeLabelFilipino.setFont(recipeFont);
					recipeLabelFilipino.setForeground(new Color(38, 38, 38));
					recipeLabelFilipino.setBounds(xFilipino + 18, yFilipino + 209, 235, 33);
					recipeLabelFilipino.setHorizontalAlignment(SwingConstants.LEFT);
					recipeLabelFilipino.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentFilipino.add(recipeLabelFilipino);

					JLabel mealTypeLabelFilipino = new JLabel(mealTypeData);
					mealTypeLabelFilipino.setFont(mealTypeFont);
					mealTypeLabelFilipino.setForeground(new Color(100, 100, 100));
					mealTypeLabelFilipino.setBounds(xFilipino + 18, yFilipino + 195, 70, 15);
					mealTypeLabelFilipino.setHorizontalAlignment(SwingConstants.LEFT);
					mealTypeLabelFilipino.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentFilipino.add(mealTypeLabelFilipino);

					JLabel cuisineLabelFilipino = new JLabel(cuisineData);
					cuisineLabelFilipino.setFont(cuisinelFont);
					cuisineLabelFilipino.setForeground(Color.WHITE);
					cuisineLabelFilipino.setBounds(xFilipino + 13, yFilipino + 13, 58, 18);
					cuisineLabelFilipino.setHorizontalAlignment(SwingConstants.CENTER);
					cuisineLabelFilipino.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentFilipino.add(cuisineLabelFilipino);

					JLabel greenLabelFilipino = new JLabel(new ImageIcon("greenLabel.png"));
					greenLabelFilipino.setBounds(xFilipino + 13, yFilipino + 13, 58, 18);
					contentFilipino.add(greenLabelFilipino);

					JLabel curveImageFilipino = new JLabel(new ImageIcon("curveImage.png"));
					curveImageFilipino.setBounds(xFilipino, yFilipino, 276, 281);
					contentFilipino.add(curveImageFilipino);

					JLabel imageFilipino = new JLabel(new ImageIcon(imageData));
					imageFilipino.setBounds(xFilipino + 7, yFilipino + 7, 262, 171);
					contentFilipino.add(imageFilipino);

					JLabel printedBGFilipino = new JLabel(new ImageIcon("printedBG.png"));
					printedBGFilipino.setBounds(xFilipino, yFilipino, 276, 281);
					contentFilipino.add(printedBGFilipino);

					// Add ActionListener to the button
					buttonFilipino.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("Clicked button at row index: " + rowIndex);
							index = rowIndex;

							resetContent();
							view.doClick();
							addRecipeBG.setVisible(false);
							viewRecipeBG.setVisible(true);
							backToRecipe.setVisible(true);

							viewEditRecipe.viewRecipe();
						}
					});

					// Logic for Dashboard
					if (dashboardIsOpen) {
						buttonFilipino.setEnabled(false);
					} else {
						buttonFilipino.setEnabled(true);
					}

					countFilipino++;
					readCountFilipino++;
					if (readCountFilipino == 4) {
						readCountFilipino = 0;
						xFilipino = 0;
						yFilipino += 281;
					} else {
						xFilipino += 276;
					}
				}

				if (cuisineData.equals("Italian")) {
					JButton buttonItalian = new JButton();
					buttonItalian.setBounds(xItalian, yItalian, 276, 281);
					buttonItalian.setOpaque(false);
					buttonItalian.setBorderPainted(false);
					buttonItalian.setContentAreaFilled(false);
					buttonItalian.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					contentItalian.add(buttonItalian);

					if (favData.equals("Yes")) {
						JLabel favorite = new JLabel(new ImageIcon("star.png"));
						favorite.setBounds(xItalian + 238, yItalian + 186, 22, 21);
						contentItalian.add(favorite);
					} else {
						JLabel favorite = new JLabel();
						favorite.setBounds(xItalian + 238, yItalian + 186, 22, 21);
						contentItalian.add(favorite);
					}

					JLabel timeLabelItalian = new JLabel(timeData);
					timeLabelItalian.setFont(time);
					timeLabelItalian.setForeground(new Color(100, 100, 100));
					timeLabelItalian.setBounds(xItalian + 38, yItalian + 245, 100, 12);
					timeLabelItalian.setHorizontalAlignment(SwingConstants.LEFT);
					timeLabelItalian.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentItalian.add(timeLabelItalian);

					JLabel recipeLabelItalian = new JLabel(recipeNameData);
					recipeLabelItalian.setFont(recipeFont);
					recipeLabelItalian.setForeground(new Color(38, 38, 38));
					recipeLabelItalian.setBounds(xItalian + 18, yItalian + 209, 235, 33);
					recipeLabelItalian.setHorizontalAlignment(SwingConstants.LEFT);
					recipeLabelItalian.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentItalian.add(recipeLabelItalian);

					JLabel mealTypeLabelItalian = new JLabel(mealTypeData);
					mealTypeLabelItalian.setFont(mealTypeFont);
					mealTypeLabelItalian.setForeground(new Color(100, 100, 100));
					mealTypeLabelItalian.setBounds(xItalian + 18, yItalian + 195, 70, 15);
					mealTypeLabelItalian.setHorizontalAlignment(SwingConstants.LEFT);
					mealTypeLabelItalian.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentItalian.add(mealTypeLabelItalian);

					JLabel cuisineLabelItalian = new JLabel(cuisineData);
					cuisineLabelItalian.setFont(cuisinelFont);
					cuisineLabelItalian.setForeground(Color.WHITE);
					cuisineLabelItalian.setBounds(xItalian + 13, yItalian + 13, 58, 18);
					cuisineLabelItalian.setHorizontalAlignment(SwingConstants.CENTER);
					cuisineLabelItalian.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentItalian.add(cuisineLabelItalian);

					JLabel greenLabelItalian = new JLabel(new ImageIcon("greenLabel.png"));
					greenLabelItalian.setBounds(xItalian + 13, yItalian + 13, 58, 18);
					contentItalian.add(greenLabelItalian);

					JLabel curveImageItalian = new JLabel(new ImageIcon("curveImage.png"));
					curveImageItalian.setBounds(xItalian, yItalian, 276, 281);
					contentItalian.add(curveImageItalian);

					JLabel imageItalian = new JLabel(new ImageIcon(imageData));
					imageItalian.setBounds(xItalian + 7, yItalian + 7, 262, 171);
					contentItalian.add(imageItalian);

					JLabel printedBGItalian = new JLabel(new ImageIcon("printedBG.png"));
					printedBGItalian.setBounds(xItalian, yItalian, 276, 281);
					contentItalian.add(printedBGItalian);

					// Add ActionListener to the button
					buttonItalian.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("Clicked button at row index: " + rowIndex);
							index = rowIndex;

							resetContent();
							view.doClick();
							addRecipeBG.setVisible(false);
							viewRecipeBG.setVisible(true);
							backToRecipe.setVisible(true);

							viewEditRecipe.viewRecipe();
						}
					});

					// Logic for Dashboard
					if (dashboardIsOpen) {
						buttonItalian.setEnabled(false);
					} else {
						buttonItalian.setEnabled(true);
					}

					countItalian++;
					readCountItalian++;
					if (readCountItalian == 4) {
						readCountItalian = 0;
						xItalian = 0;
						yItalian += 281;
					} else {
						xItalian += 276;
					}
				}

				if (cuisineData.equals("Chinese")) {
					JButton buttonChinese = new JButton();
					buttonChinese.setBounds(xChinese, yChinese, 276, 281);
					buttonChinese.setOpaque(false);
					buttonChinese.setBorderPainted(false);
					buttonChinese.setContentAreaFilled(false);
					buttonChinese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					contentChinese.add(buttonChinese);

					if (favData.equals("Yes")) {
						JLabel favorite = new JLabel(new ImageIcon("star.png"));
						favorite.setBounds(xChinese + 238, yChinese + 186, 22, 21);
						contentItalian.add(favorite);
					} else {
						JLabel favorite = new JLabel();
						favorite.setBounds(xChinese + 238, yChinese + 186, 22, 21);
						contentChinese.add(favorite);
					}

					JLabel timeLabelChinese = new JLabel(timeData);
					timeLabelChinese.setFont(time);
					timeLabelChinese.setForeground(new Color(100, 100, 100));
					timeLabelChinese.setBounds(xChinese + 38, yChinese + 245, 100, 12);
					timeLabelChinese.setHorizontalAlignment(SwingConstants.LEFT);
					timeLabelChinese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentChinese.add(timeLabelChinese);

					JLabel recipeLabelChinese = new JLabel(recipeNameData);
					recipeLabelChinese.setFont(recipeFont);
					recipeLabelChinese.setForeground(new Color(38, 38, 38));
					recipeLabelChinese.setBounds(xChinese + 18, yChinese + 209, 235, 33);
					recipeLabelChinese.setHorizontalAlignment(SwingConstants.LEFT);
					recipeLabelChinese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentChinese.add(recipeLabelChinese);

					JLabel mealTypeLabelChinese = new JLabel(mealTypeData);
					mealTypeLabelChinese.setFont(mealTypeFont);
					mealTypeLabelChinese.setForeground(new Color(100, 100, 100));
					mealTypeLabelChinese.setBounds(xChinese + 18, yChinese + 195, 70, 15);
					mealTypeLabelChinese.setHorizontalAlignment(SwingConstants.LEFT);
					mealTypeLabelChinese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentChinese.add(mealTypeLabelChinese);

					JLabel cuisineLabelChinese = new JLabel(cuisineData);
					cuisineLabelChinese.setFont(cuisinelFont);
					cuisineLabelChinese.setForeground(Color.WHITE);
					cuisineLabelChinese.setBounds(xChinese + 13, yChinese + 13, 58, 18);
					cuisineLabelChinese.setHorizontalAlignment(SwingConstants.CENTER);
					cuisineLabelChinese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentChinese.add(cuisineLabelChinese);

					JLabel greenLabelChinese = new JLabel(new ImageIcon("greenLabel.png"));
					greenLabelChinese.setBounds(xChinese + 13, yChinese + 13, 58, 18);
					contentChinese.add(greenLabelChinese);

					JLabel curveImageChinese = new JLabel(new ImageIcon("curveImage.png"));
					curveImageChinese.setBounds(xChinese, yChinese, 276, 281);
					contentChinese.add(curveImageChinese);

					JLabel imageChinese = new JLabel(new ImageIcon(imageData));
					imageChinese.setBounds(xChinese + 7, yChinese + 7, 262, 171);
					contentChinese.add(imageChinese);

					JLabel printedBGChinese = new JLabel(new ImageIcon("printedBG.png"));
					printedBGChinese.setBounds(xChinese, yChinese, 276, 281);
					contentChinese.add(printedBGChinese);

					// Add ActionListener to the button
					buttonChinese.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("Clicked button at row index: " + rowIndex);
							index = rowIndex;

							resetContent();
							view.doClick();
							addRecipeBG.setVisible(false);
							viewRecipeBG.setVisible(true);
							backToRecipe.setVisible(true);

							viewEditRecipe.viewRecipe();
						}
					});

					// Logic for Dashboard
					if (dashboardIsOpen) {
						buttonChinese.setEnabled(false);
					} else {
						buttonChinese.setEnabled(true);
					}

					countChinese++;
					readCountChinese++;
					if (readCountChinese == 4) {
						readCountChinese = 0;
						xChinese = 0;
						yChinese += 281;
					} else {
						xChinese += 276;
					}
				}

				if (cuisineData.equals("Japanese")) {
					JButton buttonJapanese = new JButton();
					buttonJapanese.setBounds(xJapanese, yJapanese, 276, 281);
					buttonJapanese.setOpaque(false);
					buttonJapanese.setBorderPainted(false);
					buttonJapanese.setContentAreaFilled(false);
					buttonJapanese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					contentJapanese.add(buttonJapanese);

					if (favData.equals("Yes")) {
						JLabel favorite = new JLabel(new ImageIcon("star.png"));
						favorite.setBounds(xJapanese + 238, yJapanese + 186, 22, 21);
						contentJapanese.add(favorite);
					} else {
						JLabel favorite = new JLabel();
						favorite.setBounds(xJapanese + 238, yJapanese + 186, 22, 21);
						contentJapanese.add(favorite);
					}

					JLabel timeLabelJapanese = new JLabel(timeData);
					timeLabelJapanese.setFont(time);
					timeLabelJapanese.setForeground(new Color(100, 100, 100));
					timeLabelJapanese.setBounds(xJapanese + 38, yJapanese + 245, 100, 12);
					timeLabelJapanese.setHorizontalAlignment(SwingConstants.LEFT);
					timeLabelJapanese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentJapanese.add(timeLabelJapanese);

					JLabel recipeLabelJapanese = new JLabel(recipeNameData);
					recipeLabelJapanese.setFont(recipeFont);
					recipeLabelJapanese.setForeground(new Color(38, 38, 38));
					recipeLabelJapanese.setBounds(xJapanese + 18, yJapanese + 209, 235, 33);
					recipeLabelJapanese.setHorizontalAlignment(SwingConstants.LEFT);
					recipeLabelJapanese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentJapanese.add(recipeLabelJapanese);

					JLabel mealTypeLabelJapanese = new JLabel(mealTypeData);
					mealTypeLabelJapanese.setFont(mealTypeFont);
					mealTypeLabelJapanese.setForeground(new Color(100, 100, 100));
					mealTypeLabelJapanese.setBounds(xJapanese + 18, yJapanese + 195, 70, 15);
					mealTypeLabelJapanese.setHorizontalAlignment(SwingConstants.LEFT);
					mealTypeLabelJapanese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentJapanese.add(mealTypeLabelJapanese);

					JLabel cuisineLabelJapanese = new JLabel(cuisineData);
					cuisineLabelJapanese.setFont(cuisinelFont);
					cuisineLabelJapanese.setForeground(Color.WHITE);
					cuisineLabelJapanese.setBounds(xJapanese + 13, yJapanese + 13, 58, 18);
					cuisineLabelJapanese.setHorizontalAlignment(SwingConstants.CENTER);
					cuisineLabelJapanese.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					contentJapanese.add(cuisineLabelJapanese);

					JLabel greenLabelJapanese = new JLabel(new ImageIcon("greenLabel.png"));
					greenLabelJapanese.setBounds(xJapanese + 13, yJapanese + 13, 58, 18);
					contentJapanese.add(greenLabelJapanese);

					JLabel curveImageJapanese = new JLabel(new ImageIcon("curveImage.png"));
					curveImageJapanese.setBounds(xJapanese, yJapanese, 276, 281);
					contentJapanese.add(curveImageJapanese);

					JLabel imageJapanese = new JLabel(new ImageIcon(imageData));
					imageJapanese.setBounds(xJapanese + 7, yJapanese + 7, 262, 171);
					contentJapanese.add(imageJapanese);

					JLabel printedBGJapanese = new JLabel(new ImageIcon("printedBG.png"));
					printedBGJapanese.setBounds(xJapanese, yJapanese, 276, 281);
					contentJapanese.add(printedBGJapanese);

					// Add ActionListener to the button
					buttonJapanese.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("Clicked button at row index: " + rowIndex);
							index = rowIndex;

							resetContent();
							view.doClick();
							addRecipeBG.setVisible(false);
							viewRecipeBG.setVisible(true);
							backToRecipe.setVisible(true);

							viewEditRecipe.viewRecipe();
						}
					});

					// Logic for Dashboard
					if (dashboardIsOpen) {
						buttonJapanese.setEnabled(false);
					} else {
						buttonJapanese.setEnabled(true);
					}

					countJapanese++;
					readCountJapanese++;
					if (readCountJapanese == 4) {
						readCountJapanese = 0;
						xJapanese = 0;
						yJapanese += 281;
					} else {
						xJapanese += 276;
					}
				}

				// Logic for Dashboard
				if (dashboardIsOpen) {
					button.setEnabled(false);
				} else {
					button.setEnabled(true);
				}

				countAll++;
				readCountAll++;
				if (readCountAll == 4) {
					readCountAll = 0;
					xAll = 0;
					yAll += 281;
				} else {
					xAll += 276;
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading data from CSV file: " + e.getMessage(),
					"Data Read Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	static void logout() {

		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(createAccount.buttonFont);
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setFocusPainted(false);
		logoutButton.setBorderPainted(true);

		JButton noButton = new JButton("No");
		noButton.setFont(createAccount.buttonFont);
		noButton.setBackground(Color.WHITE);
		noButton.setFocusPainted(false);
		noButton.setBorderPainted(true);

		logout.addActionListener(e -> {

			Object[] options = { logoutButton, noButton };
			UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));
			JOptionPane pane = new JOptionPane("Are you sure you want to Logout?", JOptionPane.QUESTION_MESSAGE,
					JOptionPane.OK_OPTION, null, options);
			JDialog dialog = pane.createDialog("Logout confirmation");

			logoutButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
					mainScreen.mainFrame.setVisible(true);
					dashboardFrame.setVisible(false);

					// Reset All properties here....
					greenBarBG.setBounds(0, 78, 223, 37);
					resetChoiceIcons();
					resetScrollPane();
					resetBg();
					resetVisible();
					dashboardBG.setVisible(true);
					all.setIcon(allIcon);
					scrollPaneAll.setVisible(true);
					mealPlanFeature.mainPlanPanel.setVisible(false);
					viewEditRecipe.viewRecipePanel.setVisible(false);
					scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
					backToRecipe.doClick();
				}
			});
			noButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});
			dialog.setVisible(true);
		});

	}

	static void createDashboard() {

		dashboardFrame.setSize(1366, 768); // Best Size for GUI system
		dashboardFrame.setUndecorated(true);
		dashboardFrame.setVisible(true);

		dashboardJPanel = new JPanel() {
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

		dashboardFrame.setContentPane(dashboardJPanel);
		dashboardFrame.getContentPane().setLayout(null);
		dashboardFrame.setBackground(new Color(0, 0, 0, 0));
		dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboardFrame.setLocationRelativeTo(null);

		// Backgrounds
		dashboardBG.setBounds(0, 0, 1366, 768);
		recipeBG.setBounds(0, 0, 1366, 768);
		mealPlanBG.setBounds(0, 0, 1366, 768);

		addRecipeBG.setBounds(0, 0, 1366, 768);
		viewRecipeBG.setBounds(0, 0, 1366, 768);
		editRecipeBG.setBounds(0, 0, 1366, 768);

		recipeBG.setVisible(false);
		mealPlanBG.setVisible(false);
		addRecipeBG.setVisible(false);
		viewRecipeBG.setVisible(false);

		JLabel buttonsBG = new JLabel(new ImageIcon("dashboardSide.png"));
		buttonsBG.setBounds(0, 0, 223, 768);

		greenBarBG.setBounds(0, 78, 223, 37);
//		greenBarBG.setBounds(0, 119, 223, 37);
//		greenBarBG.setBounds(0, 158, 223, 37);

		JPanel mainButtonsPanel = new JPanel();
		mainButtonsPanel.setLayout(null);
		mainButtonsPanel.setBackground(new Color(0, 0, 0, 0));
		mainButtonsPanel.setBounds(0, 63, 222, 686);

		JLabel greatings = new JLabel("Welcome,");
		greatings.setFont(new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 23));
		greatings.setForeground(Color.WHITE);

		name.setFont(new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 23));
		name.setForeground(Color.WHITE);

		greatings.setBounds(10, 220, 200, 25);
		name.setBounds(10, 245, 200, 30);

		// Side Buttons
		homeButton.setBounds(7, 78, 206, 37);
		homeButton.setBorderPainted(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setOpaque(false);

		recipeButton.setBounds(7, 119, 206, 37);
		recipeButton.setBorderPainted(false);
		recipeButton.setContentAreaFilled(false);
		recipeButton.setOpaque(false);

		mealButton.setBounds(7, 158, 206, 37);
		mealButton.setBorderPainted(false);
		mealButton.setContentAreaFilled(false);
		mealButton.setOpaque(false);

		logout.setBounds(7, 716, 206, 37);
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setOpaque(false);

		// Add recipe button
		addRecipeButton.setBounds(587, 60, 200, 58);
		addRecipeButton.setBorderPainted(false);
		addRecipeButton.setContentAreaFilled(false);
		addRecipeButton.setOpaque(false);
		addRecipeButton.setVisible(false);

		backToRecipe.setBounds(245, 185, 30, 30);
		backToRecipe.setBorderPainted(false);
		backToRecipe.setContentAreaFilled(false);
		backToRecipe.setOpaque(false);
		backToRecipe.setVisible(false);

		saveAddRecipe.setBounds(245, 220, 30, 37);
		saveAddRecipe.setBorderPainted(false);
		saveAddRecipe.setContentAreaFilled(false);
		saveAddRecipe.setOpaque(false);
		saveAddRecipe.setVisible(false);

		// Edit | Save | Delete
		editButton.setBounds(245, 220, 30, 42);
		editButton.setBorderPainted(false);
		editButton.setContentAreaFilled(false);
		editButton.setOpaque(false);
		editButton.setVisible(false);

		saveRecipe.setBounds(245, 265, 30, 39);
		saveRecipe.setBorderPainted(false);
		saveRecipe.setContentAreaFilled(false);
		saveRecipe.setOpaque(false);
		saveRecipe.setVisible(false);

		deleteButton.setBounds(245, 310, 30, 44);
		deleteButton.setBorderPainted(false);
		deleteButton.setContentAreaFilled(false);
		deleteButton.setOpaque(false);
		deleteButton.setVisible(false);

		// Choices Button
		all.setBounds(549, 238, 92, 32);
		all.setIcon(allIcon);
		all.setBorderPainted(false);
		all.setContentAreaFilled(false);
		all.setOpaque(false);

		filipino.setBounds(641, 238, 92, 32);
		filipino.setBorderPainted(false);
		filipino.setContentAreaFilled(false);
		filipino.setOpaque(false);

		italian.setBounds(733, 238, 92, 32);
		italian.setBorderPainted(false);
		italian.setContentAreaFilled(false);
		italian.setOpaque(false);

		chinese.setBounds(823, 238, 92, 32);
		chinese.setBorderPainted(false);
		chinese.setContentAreaFilled(false);
		chinese.setOpaque(false);

		japanese.setBounds(912, 238, 92, 32);
		japanese.setBorderPainted(false);
		japanese.setContentAreaFilled(false);
		japanese.setOpaque(false);

		// Add Cursor
		homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		recipeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mealButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addRecipeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saveAddRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saveRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		all.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		filipino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		italian.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chinese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		japanese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Layered Panel
		layeredPaneDashboard.setSize(dashboardJPanel.getSize());
		dashboardJPanel.add(layeredPaneDashboard);

		// Add & Customized Scroll Pane
		scrollPaneAll.setBounds(231, 288, 1123, 470);
		scrollPaneAll.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneAll.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneAll.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneAll.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneAll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneAll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneAll.setWheelScrollingEnabled(true);
		scrollPaneAll.getVerticalScrollBar().setUnitIncrement(8);

		scrollPaneFilipino.setBounds(231, 288, 1123, 470);
		scrollPaneFilipino.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneFilipino.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneFilipino.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneFilipino.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneFilipino.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneFilipino.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFilipino.setWheelScrollingEnabled(true);
		scrollPaneFilipino.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneFilipino.setVisible(false);

		scrollPaneItalian.setBounds(231, 288, 1123, 470);
		scrollPaneItalian.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneItalian.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneItalian.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneItalian.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneItalian.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneItalian.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneItalian.setWheelScrollingEnabled(true);
		scrollPaneItalian.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneItalian.setVisible(false);

		scrollPaneChinese.setBounds(231, 288, 1123, 470);
		scrollPaneChinese.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneChinese.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneChinese.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneChinese.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneChinese.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneChinese.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneChinese.setWheelScrollingEnabled(true);
		scrollPaneChinese.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneChinese.setVisible(false);

		scrollPaneJapanese.setBounds(231, 288, 1123, 470);
		scrollPaneJapanese.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneJapanese.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneJapanese.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneJapanese.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneJapanese.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneJapanese.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJapanese.setWheelScrollingEnabled(true);
		scrollPaneJapanese.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneJapanese.setVisible(false);

		// Set the font and background color for tooltips
		UIManager.put("ToolTip.font", tooltipFont);
		UIManager.put("ToolTip.background", tooltipBackground);

		// For meantime code | design only
		JLabel bgAll = new JLabel(new ImageIcon("allEx.png"));
		JLabel bgFilipino = new JLabel(new ImageIcon("filipinoEx.png"));
		JLabel bgItalian = new JLabel(new ImageIcon("italianEx.png"));
		JLabel bgChinese = new JLabel(new ImageIcon("chineseEx.png"));
		JLabel bgJapanese = new JLabel(new ImageIcon("japaneseEx.png"));

		// Adding the design
		bgAll.setBounds(0, 0, 1105, 566);
		contentAll.setBackground(new Color(238, 240, 244));
		contentAll.setLayout(null);
		contentAll.setPreferredSize(new Dimension(1105, 849));
//		contentAll.add(bgAll);
		scrollPaneAll.setViewportView(contentAll);

		bgFilipino.setBounds(0, 0, 1105, 286);
		contentFilipino.setBackground(new Color(238, 240, 244));
		contentFilipino.setLayout(null);
		contentFilipino.setPreferredSize(new Dimension(1105, 566));
//		contentFilipino.add(bgFilipino);
		scrollPaneFilipino.setViewportView(contentFilipino);

		bgItalian.setBounds(0, 0, 1105, 286);
		contentItalian.setBackground(new Color(238, 240, 244));
		contentItalian.setLayout(null);
		contentItalian.setPreferredSize(new Dimension(1105, 566));
//		contentItalian.add(bgItalian);
		scrollPaneItalian.setViewportView(contentItalian);

		bgChinese.setBounds(0, 0, 1105, 286);
		contentChinese.setBackground(new Color(238, 240, 244));
		contentChinese.setLayout(null);
		contentChinese.setPreferredSize(new Dimension(1105, 566));
//		contentChinese.add(bgChinese);
		scrollPaneChinese.setViewportView(contentChinese);

		bgJapanese.setBounds(0, 0, 1105, 286);
		contentJapanese.setBackground(new Color(238, 240, 244));
		contentJapanese.setLayout(null);
		contentJapanese.setPreferredSize(new Dimension(1105, 566));
//		contentJapanese.add(bgJapanese);
		scrollPaneJapanese.setViewportView(contentJapanese);

		// Dashboard BG & Side panel buttons
		layeredPaneDashboard.add(dashboardBG, new Integer(0));
		layeredPaneDashboard.add(recipeBG, new Integer(0));
		layeredPaneDashboard.add(mealPlanBG, new Integer(0));
		layeredPaneDashboard.add(addRecipeBG, new Integer(0));
		layeredPaneDashboard.add(viewRecipeBG, new Integer(0));
		layeredPaneDashboard.add(editRecipeBG, new Integer(0));
		layeredPaneDashboard.add(mainButtonsPanel, new Integer(0));
		layeredPaneDashboard.add(greenBarBG, new Integer(1));
		layeredPaneDashboard.add(buttonsBG, new Integer(2));
		layeredPaneDashboard.add(greatings, new Integer(2));
		layeredPaneDashboard.add(name, new Integer(2));
		layeredPaneDashboard.add(homeButton, new Integer(3));
		layeredPaneDashboard.add(addRecipeButton, new Integer(3));
		layeredPaneDashboard.add(backToRecipe, new Integer(4));
		layeredPaneDashboard.add(saveAddRecipe, new Integer(4));
		layeredPaneDashboard.add(editButton, new Integer(4));
		layeredPaneDashboard.add(saveRecipe, new Integer(4));
		layeredPaneDashboard.add(deleteButton, new Integer(4));
		layeredPaneDashboard.add(recipeButton, new Integer(3));
		layeredPaneDashboard.add(mealButton, new Integer(3));
		layeredPaneDashboard.add(logout, new Integer(3));

		// Choices Buttons
		layeredPaneDashboard.add(all, new Integer(3));
		layeredPaneDashboard.add(filipino, new Integer(3));
		layeredPaneDashboard.add(italian, new Integer(3));
		layeredPaneDashboard.add(chinese, new Integer(3));
		layeredPaneDashboard.add(japanese, new Integer(3));

		// Scroll Panes
		layeredPaneDashboard.add(scrollPaneAll, new Integer(3));
		layeredPaneDashboard.add(scrollPaneFilipino, new Integer(3));
		layeredPaneDashboard.add(scrollPaneItalian, new Integer(3));
		layeredPaneDashboard.add(scrollPaneChinese, new Integer(3));
		layeredPaneDashboard.add(scrollPaneJapanese, new Integer(3));

		runDashboard();
	}

	public static void main(String[] args) {
		createDashboard();
	}
}

class CustomScrollBarUI extends BasicScrollBarUI {
	private final int radius = 9;

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.setPaint(new GradientPaint(0, thumbBounds.y, new Color(230, 230, 230), thumbBounds.width, thumbBounds.y,
//				new Color(190, 190, 190)));
		g2.setPaint(new Color(17, 130, 59));
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
		g.setColor(new Color(238, 240, 244));
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
