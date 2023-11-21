import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class addRecipeFeature {

	static JPanel addRecipePanel = new JPanel();
	static JLabel addRecipeBG = new JLabel(new ImageIcon("addRecipeBG.png"));

	// Add image button
	static JButton addImage = new JButton();
	static JLabel addImageLabel = new JLabel();
	static String imageLocation;

	// General Font
	static Font titleF = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 30);
	static Font generalF = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 16);

	// Recipe name
	static JTextField recipeName = new JTextField();

	// Meal type | Cuisine | Cook time
	static R_textFields mealType = new R_textFields();
	static R_textFields cuisine = new R_textFields();
	static R_textFields cookTime = new R_textFields();

	// Content panel in Procedure
	static JTextArea procedureText = new JTextArea();
	static JScrollPane procedureScrollPane = new JScrollPane(procedureText);

	// Favorites
	static Font labelMark = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 10);
	static JLabel mark = new JLabel("Mark as favorite?");
	static JLabel yesNo = new JLabel("No");
	static boolean clicked = false;

	// Content panel in Ingredients
	static JPanel ingredients = new JPanel();
	static JScrollPane ingredientsScrollPane = new JScrollPane(ingredients);
	static JLabel linesBG = new JLabel(new ImageIcon("linesBG.png"));

	static R_textFields ingredient1 = new R_textFields();
	static R_textFieldsIG quantity1 = new R_textFieldsIG();
	static R_textFieldsIG unit1 = new R_textFieldsIG();

	static R_textFields ingredient2 = new R_textFields();
	static R_textFieldsIG quantity2 = new R_textFieldsIG();
	static R_textFieldsIG unit2 = new R_textFieldsIG();

	static R_textFields ingredient3 = new R_textFields();
	static R_textFieldsIG quantity3 = new R_textFieldsIG();
	static R_textFieldsIG unit3 = new R_textFieldsIG();

	static R_textFields ingredient4 = new R_textFields();
	static R_textFieldsIG quantity4 = new R_textFieldsIG();
	static R_textFieldsIG unit4 = new R_textFieldsIG();

	static R_textFields ingredient5 = new R_textFields();
	static R_textFieldsIG quantity5 = new R_textFieldsIG();
	static R_textFieldsIG unit5 = new R_textFieldsIG();

	static R_textFields ingredient6 = new R_textFields();
	static R_textFieldsIG quantity6 = new R_textFieldsIG();
	static R_textFieldsIG unit6 = new R_textFieldsIG();

	static R_textFields ingredient7 = new R_textFields();
	static R_textFieldsIG quantity7 = new R_textFieldsIG();
	static R_textFieldsIG unit7 = new R_textFieldsIG();

	static R_textFields ingredient8 = new R_textFields();
	static R_textFieldsIG quantity8 = new R_textFieldsIG();
	static R_textFieldsIG unit8 = new R_textFieldsIG();

	static R_textFields ingredient9 = new R_textFields();
	static R_textFieldsIG quantity9 = new R_textFieldsIG();
	static R_textFieldsIG unit9 = new R_textFieldsIG();

	static R_textFields ingredient10 = new R_textFields();
	static R_textFieldsIG quantity10 = new R_textFieldsIG();
	static R_textFieldsIG unit10 = new R_textFieldsIG();

	static R_textFields ingredient11 = new R_textFields();
	static R_textFieldsIG quantity11 = new R_textFieldsIG();
	static R_textFieldsIG unit11 = new R_textFieldsIG();

	static R_textFields ingredient12 = new R_textFields();
	static R_textFieldsIG quantity12 = new R_textFieldsIG();
	static R_textFieldsIG unit12 = new R_textFieldsIG();

	static R_textFields ingredient13 = new R_textFields();
	static R_textFieldsIG quantity13 = new R_textFieldsIG();
	static R_textFieldsIG unit13 = new R_textFieldsIG();

	static R_textFields ingredient14 = new R_textFields();
	static R_textFieldsIG quantity14 = new R_textFieldsIG();
	static R_textFieldsIG unit14 = new R_textFieldsIG();

	static R_textFields ingredient15 = new R_textFields();
	static R_textFieldsIG quantity15 = new R_textFieldsIG();
	static R_textFieldsIG unit15 = new R_textFieldsIG();

	static void runRecipe() {

		// Setting the general JOption Font
		UIManager.put("OptionPane.messageFont", new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 13));

		addImage.addActionListener(e -> {
			System.out.println("Add image");

			JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + File.separator + "Downloads");
			fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif"));
			int result = fileChooser.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				imageLocation = selectedFile.getAbsolutePath();
				ImageIcon imageIcon = new ImageIcon(imageLocation);
				addImageLabel.setIcon(imageIcon);
				addImage.setEnabled(false);
			}
		});

		yesNo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (clicked) {
					yesNo.setText("No");
					clicked = false;
				} else {
					yesNo.setText("Yes");
					clicked = true;
				}
			}
		});
	}

	static void saveData() {
		// Get the values from the form

		// Printed Data
		String recipeData = recipeName.getText();
		String typeData = mealType.getText();
		String cuisineData = cuisine.getText();
		String cookTimeData = cookTime.getText();
		String favorites = yesNo.getText();

		// Ingredients Data
		String ingredientData1 = ingredient1.getText();
		String quantityData1 = quantity1.getText();
		String unitData1 = unit1.getText();

		String ingredientData2 = ingredient2.getText();
		String quantityData2 = quantity2.getText();
		String unitData2 = unit2.getText();

		String ingredientData3 = ingredient3.getText();
		String quantityData3 = quantity3.getText();
		String unitData3 = unit3.getText();

		String ingredientData4 = ingredient4.getText();
		String quantityData4 = quantity4.getText();
		String unitData4 = unit4.getText();

		String ingredientData5 = ingredient5.getText();
		String quantityData5 = quantity5.getText();
		String unitData5 = unit5.getText();

		String ingredientData6 = ingredient6.getText();
		String quantityData6 = quantity6.getText();
		String unitData6 = unit6.getText();

		String ingredientData7 = ingredient7.getText();
		String quantityData7 = quantity7.getText();
		String unitData7 = unit7.getText();

		String ingredientData8 = ingredient8.getText();
		String quantityData8 = quantity8.getText();
		String unitData8 = unit8.getText();

		String ingredientData9 = ingredient9.getText();
		String quantityData9 = quantity9.getText();
		String unitData9 = unit9.getText();

		String ingredientData10 = ingredient10.getText();
		String quantityData10 = quantity10.getText();
		String unitData10 = unit10.getText();

		String ingredientData11 = ingredient11.getText();
		String quantityData11 = quantity11.getText();
		String unitData11 = unit11.getText();

		String ingredientData12 = ingredient12.getText();
		String quantityData12 = quantity12.getText();
		String unitData12 = unit12.getText();

		String ingredientData13 = ingredient13.getText();
		String quantityData13 = quantity13.getText();
		String unitData13 = unit13.getText();

		String ingredientData14 = ingredient14.getText();
		String quantityData14 = quantity14.getText();
		String unitData14 = unit14.getText();

		String ingredientData15 = ingredient15.getText();
		String quantityData15 = quantity15.getText();
		String unitData15 = unit15.getText();

		// Procedure Data
		String procedureData = procedureText.getText().replace("\n", "\\n");

		// Format the data as a comma-separated string
		String data1 = String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", imageLocation, recipeData, typeData,
				cuisineData, cookTimeData, favorites);

		String data2 = String.format(
				"\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
				ingredientData1, quantityData1, unitData1, ingredientData2, quantityData2, unitData2, ingredientData3,
				quantityData3, unitData3, ingredientData4, quantityData4, unitData4, ingredientData5, quantityData5,
				unitData5, ingredientData6, quantityData6, unitData6, ingredientData7, quantityData7, unitData7,
				ingredientData8, quantityData8, unitData8, ingredientData9, quantityData9, unitData9, ingredientData10,
				quantityData10, unitData10, ingredientData11, quantityData11, unitData11, ingredientData12,
				quantityData12, unitData12, ingredientData13, quantityData13, unitData13, ingredientData14,
				quantityData14, unitData14, ingredientData15, quantityData15, unitData15);

		String procedureDataWithoutComma = procedureData.replace(",", "<comma>"); // Replace commas with a placeholder
		String data3 = String.format("\"%s\"", procedureDataWithoutComma);

		// Define the file path in the Downloads folder
		Path printedData = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Downloads");
		String filePath1 = printedData.resolve("PrintedData.csv").toString();

		Path ingredientsData = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Downloads");
		String filePath2 = ingredientsData.resolve("IngredientsData.csv").toString();

		Path proceduresData = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Downloads");
		String filePath3 = proceduresData.resolve("ProcedureData.csv").toString();

		// Write the data to the CSV file
		try {
			FileWriter writer1 = new FileWriter(filePath1, true);
			FileWriter writer2 = new FileWriter(filePath2, true);
			FileWriter writer3 = new FileWriter(filePath3, true);

			writer1.write(data1 + System.lineSeparator());
			writer2.write(data2 + System.lineSeparator());
			writer3.write(data3 + System.lineSeparator());

			writer1.close();
			writer2.close();
			writer3.close();

			JOptionPane.showMessageDialog(null, "Data saved successfully!");

			// Clear all the data
			dashboardScreen.backToRecipe.doClick();
			clearData();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
		}
	}

	static void clearData() {
		recipeName.setText("");
		mealType.setText("");
		cuisine.setText("");
		cookTime.setText("");
		procedureText.setText("");
		yesNo.setText("No");
		clicked = false;
		addImageLabel.setIcon(null);
		addImage.setEnabled(true);

		// Reset Ingredients
		ingredient1.setText("");
		quantity1.setText("");
		unit1.setText("");

		ingredient2.setText("");
		quantity2.setText("");
		unit2.setText("");

		ingredient3.setText("");
		quantity3.setText("");
		unit3.setText("");

		ingredient4.setText("");
		quantity4.setText("");
		unit4.setText("");

		ingredient5.setText("");
		quantity5.setText("");
		unit5.setText("");

		ingredient6.setText("");
		quantity6.setText("");
		unit6.setText("");

		ingredient7.setText("");
		quantity7.setText("");
		unit7.setText("");

		ingredient8.setText("");
		quantity8.setText("");
		unit8.setText("");

		ingredient9.setText("");
		quantity9.setText("");
		unit9.setText("");

		ingredient10.setText("");
		quantity10.setText("");
		unit10.setText("");

		ingredient11.setText("");
		quantity11.setText("");
		unit11.setText("");

		ingredient12.setText("");
		quantity12.setText("");
		unit12.setText("");

		ingredient13.setText("");
		quantity13.setText("");
		unit13.setText("");

		ingredient14.setText("");
		quantity14.setText("");
		unit14.setText("");

		ingredient15.setText("");
		quantity15.setText("");
		unit15.setText("");
	}

	static void deleteRowData() {

		int rowIndexToDelete = dashboardScreen.index; // Index of the row to delete

		try {
			// Construct the path to the CSV file in the system's download directory
			String downloadsDirectory = System.getProperty("user.home") + File.separator + "Downloads";

			String csvFilePath1 = downloadsDirectory + File.separator + "PrintedData.csv";
			String csvFilePath2 = downloadsDirectory + File.separator + "IngredientsData.csv";
			String csvFilePath3 = downloadsDirectory + File.separator + "ProcedureData.csv";

			// Read all lines from the CSV file
			List<String> lines1 = Files.readAllLines(Paths.get(csvFilePath1));
			List<String> lines2 = Files.readAllLines(Paths.get(csvFilePath2));
			List<String> lines3 = Files.readAllLines(Paths.get(csvFilePath3));

			if (rowIndexToDelete >= 0 && rowIndexToDelete < lines1.size()) {

				// Remove the row from the list
				lines1.remove(rowIndexToDelete);
				lines2.remove(rowIndexToDelete);
				lines3.remove(rowIndexToDelete);

				// Write the modified list back to the CSV file
				Files.write(Paths.get(csvFilePath1), lines1);
				Files.write(Paths.get(csvFilePath2), lines2);
				Files.write(Paths.get(csvFilePath3), lines3);

			} else {
				JOptionPane.showMessageDialog(null, "Invalid row index!");
			}
		} catch (IOException ex) {
			ex.printStackTrace(); // Print the stack trace for debugging purposes
			JOptionPane.showMessageDialog(null, "Error deleting data: " + ex.getMessage());
		}
		viewEditRecipe.resetValues();
		dashboardScreen.printAllData();
	}

	@SuppressWarnings("removal")
	public static void addRecipe() {

		// Panel properties
		addRecipePanel.setLayout(null);
		addRecipePanel.setBounds(236, 177, 1113, 573);
		addRecipePanel.setOpaque(false);
		addRecipePanel.setVisible(true);

		// Add image button
		addImage.setBounds(46, 16, 263, 172);
		addImage.setBorderPainted(true);
		addImage.setContentAreaFilled(false);
		addImage.setOpaque(false);
		addImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		addImageLabel.setBounds(46, 16, 263, 172);
		addImageLabel.setOpaque(false);

		// Recipe name
		recipeName.setBounds(320, 23, 263, 40);
		recipeName.setFont(titleF);
		recipeName.setForeground(new Color(38, 38, 38));
		recipeName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		recipeName.setOpaque(false);
//		recipeName.setBorder(null);

		// Set the font and background color for tooltips
		UIManager.put("ToolTip.font", dashboardScreen.tooltipFont);
		UIManager.put("ToolTip.background", dashboardScreen.tooltipBackground);

		mealType.setBounds(435, 77, 110, 25);
		mealType.setToolTipText("Breakfast | Lunch | Dinner | Snacks    ");
//		mealType.setBorder(null);

		cuisine.setBounds(435, 115, 110, 25);
		cuisine.setToolTipText("Filipino | Italian | Chinese | Japanese    ");
//		cuisine.setBorder(null);

		cookTime.setBounds(435, 156, 110, 25);
		cookTime.setToolTipText("Minutes to Hours  ");
//		cookTime.setBorder(null);

		// Mark as favorite
		mark.setBounds(120, 190, 98, 15);
		mark.setFont(labelMark);
		mark.setForeground(new Color(100, 100, 100));

		yesNo.setBounds(214, 190, 25, 15);
		yesNo.setFont(labelMark);
		yesNo.setHorizontalAlignment(SwingConstants.CENTER);
		yesNo.setForeground(new Color(100, 100, 100));
		yesNo.setFocusable(false);
		yesNo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		yesNo.setOpaque(false);

		// Procedure
		procedureText.setFont(generalF);
		procedureText.setForeground(new Color(100, 100, 100));
		procedureText.setOpaque(true);
		procedureText.setBackground(Color.WHITE);
		procedureText.setLineWrap(true);
		procedureText.setWrapStyleWord(true);
		procedureText.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		procedureScrollPane.setBounds(593, 68, 505, 493);

		procedureScrollPane.setBorder(BorderFactory.createEmptyBorder());
		procedureScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI2());
		procedureScrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI2());
		procedureScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		procedureScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		procedureScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		procedureScrollPane.setWheelScrollingEnabled(true);
		procedureScrollPane.getVerticalScrollBar().setUnitIncrement(8);

		// Ingredients
		ingredients.setLayout(null);
		ingredients.setPreferredSize(new Dimension(524, 414));
		ingredients.setBackground(Color.WHITE);

		linesBG.setBounds(0, 0, 500, 414);

		ingredientsScrollPane.setBounds(53, 262, 524, 306);
		ingredientsScrollPane.setBorder(BorderFactory.createEmptyBorder());
		ingredientsScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI2());
		ingredientsScrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI2());
		ingredientsScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		ingredientsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ingredientsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		ingredientsScrollPane.setWheelScrollingEnabled(true);
		ingredientsScrollPane.getVerticalScrollBar().setUnitIncrement(8);

		// Text fields
		ingredient1.setBounds(10, 3, 265, 25);
		quantity1.setBounds(312, 3, 100, 25);
		unit1.setBounds(440, 3, 50, 25);

		ingredient2.setBounds(10, 30, 265, 25);
		quantity2.setBounds(312, 30, 100, 25);
		unit2.setBounds(440, 30, 50, 25);

		ingredient3.setBounds(10, 57, 265, 25);
		quantity3.setBounds(312, 57, 100, 25);
		unit3.setBounds(440, 57, 50, 25);

		ingredient4.setBounds(10, 84, 265, 25);
		quantity4.setBounds(312, 84, 100, 25);
		unit4.setBounds(440, 84, 50, 25);

		ingredient5.setBounds(10, 111, 265, 25);
		quantity5.setBounds(312, 111, 100, 25);
		unit5.setBounds(440, 111, 50, 25);

		ingredient6.setBounds(10, 138, 265, 25);
		quantity6.setBounds(312, 138, 100, 25);
		unit6.setBounds(440, 138, 50, 25);

		ingredient7.setBounds(10, 165, 265, 25);
		quantity7.setBounds(312, 165, 100, 25);
		unit7.setBounds(440, 165, 50, 25);

		ingredient8.setBounds(10, 192, 265, 25);
		quantity8.setBounds(312, 192, 100, 25);
		unit8.setBounds(440, 192, 50, 25);

		ingredient9.setBounds(10, 219, 265, 25);
		quantity9.setBounds(312, 219, 100, 25);
		unit9.setBounds(440, 219, 50, 25);

		ingredient10.setBounds(10, 246, 265, 25);
		quantity10.setBounds(312, 246, 100, 25);
		unit10.setBounds(440, 246, 50, 25);

		ingredient11.setBounds(10, 273, 265, 25);
		quantity11.setBounds(312, 273, 100, 25);
		unit11.setBounds(440, 273, 50, 25);

		ingredient12.setBounds(10, 300, 265, 25);
		quantity12.setBounds(312, 300, 100, 25);
		unit12.setBounds(440, 300, 50, 25);

		ingredient13.setBounds(10, 327, 265, 25);
		quantity13.setBounds(312, 327, 100, 25);
		unit13.setBounds(440, 327, 50, 25);

		ingredient14.setBounds(10, 354, 265, 25);
		quantity14.setBounds(312, 354, 100, 25);
		unit14.setBounds(440, 354, 50, 25);

		ingredient15.setBounds(10, 381, 265, 25);
		quantity15.setBounds(312, 381, 100, 25);
		unit15.setBounds(440, 381, 50, 25);

// Layers -------------------------------------------------------------------------------------------------------

		// Set rendering hints for text anti-aliasing
		recipeName.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		procedureText.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		mark.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		yesNo.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// Extras
		yesNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Ingredients panel layers
		ingredients.add(ingredient1);
		ingredients.add(quantity1);
		ingredients.add(unit1);

		ingredients.add(ingredient2);
		ingredients.add(quantity2);
		ingredients.add(unit2);

		ingredients.add(ingredient3);
		ingredients.add(quantity3);
		ingredients.add(unit3);

		ingredients.add(ingredient4);
		ingredients.add(quantity4);
		ingredients.add(unit4);

		ingredients.add(ingredient5);
		ingredients.add(quantity5);
		ingredients.add(unit5);

		ingredients.add(ingredient6);
		ingredients.add(quantity6);
		ingredients.add(unit6);

		ingredients.add(ingredient7);
		ingredients.add(quantity7);
		ingredients.add(unit7);

		ingredients.add(ingredient8);
		ingredients.add(quantity8);
		ingredients.add(unit8);

		ingredients.add(ingredient9);
		ingredients.add(quantity9);
		ingredients.add(unit9);

		ingredients.add(ingredient10);
		ingredients.add(quantity10);
		ingredients.add(unit10);

		ingredients.add(ingredient11);
		ingredients.add(quantity11);
		ingredients.add(unit11);

		ingredients.add(ingredient12);
		ingredients.add(quantity12);
		ingredients.add(unit12);

		ingredients.add(ingredient13);
		ingredients.add(quantity13);
		ingredients.add(unit13);

		ingredients.add(ingredient14);
		ingredients.add(quantity14);
		ingredients.add(unit14);

		ingredients.add(ingredient15);
		ingredients.add(quantity15);
		ingredients.add(unit15);

		ingredients.add(linesBG);

		// Add recipeBG
		addRecipeBG.setBounds(0, 0, 1113, 573);

		// Panel Layers
		addRecipePanel.add(addImage, new Integer(0));
		addRecipePanel.add(addImageLabel, new Integer(0));
		addRecipePanel.add(recipeName, new Integer(1));
		addRecipePanel.add(mealType, new Integer(1));
		addRecipePanel.add(cuisine, new Integer(1));
		addRecipePanel.add(cookTime, new Integer(1));
		addRecipePanel.add(mark, new Integer(1));
		addRecipePanel.add(yesNo, new Integer(1));
		addRecipePanel.add(procedureScrollPane, new Integer(1));
		addRecipePanel.add(ingredientsScrollPane, new Integer(1));

		// Add BG
		addRecipePanel.add(addRecipeBG, new Integer(1));

		// Add to main dashboard layers
		dashboardScreen.layeredPaneDashboard.add(addRecipePanel, new Integer(3));

		runRecipe();
	}
}

class CustomScrollBarUI2 extends BasicScrollBarUI {
	private final int radius = 9;

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.setPaint(new GradientPaint(0, thumbBounds.y, new Color(230, 230, 230), thumbBounds.width, thumbBounds.y,
//				new Color(190, 190, 190)));
		g2.setPaint(new Color(150, 150, 150));
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
		g.setColor(Color.WHITE);
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
