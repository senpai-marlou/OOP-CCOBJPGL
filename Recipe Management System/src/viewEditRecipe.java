import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("unused")
public class viewEditRecipe {

	// For View Only
	private static String imageData;
	private static String recipeNameData;
	private static String mealTypeData;
	private static String cuisineData;
	private static String timeData;
	private static String favData;

	// Ingredients Data
	private static String ingredientData1;
	private static String quantityData1;
	private static String unitData1;

	private static String ingredientData2;
	private static String quantityData2;
	private static String unitData2;

	private static String ingredientData3;
	private static String quantityData3;
	private static String unitData3;

	private static String ingredientData4;
	private static String quantityData4;
	private static String unitData4;

	private static String ingredientData5;
	private static String quantityData5;
	private static String unitData5;

	private static String ingredientData6;
	private static String quantityData6;
	private static String unitData6;

	private static String ingredientData7;
	private static String quantityData7;
	private static String unitData7;

	private static String ingredientData8;
	private static String quantityData8;
	private static String unitData8;

	private static String ingredientData9;
	private static String quantityData9;
	private static String unitData9;

	private static String ingredientData10;
	private static String quantityData10;
	private static String unitData10;

	private static String ingredientData11;
	private static String quantityData11;
	private static String unitData11;

	private static String ingredientData12;
	private static String quantityData12;
	private static String unitData12;

	private static String ingredientData13;
	private static String quantityData13;
	private static String unitData13;

	private static String ingredientData14;
	private static String quantityData14;
	private static String unitData14;

	private static String ingredientData15;
	private static String quantityData15;
	private static String unitData15;

	static String imageLocation;
	static boolean clicked = false;

	// General Font
	static Font titleF = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 30);
	static Font generalF = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 16);

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

	// Recipe name
	static JTextField recipeName = new JTextField();

	// Meal type | Cuisine | Cook time
	static R_textFields mealType = new R_textFields();
	static R_textFields cuisine = new R_textFields();
	static R_textFields cookTime = new R_textFields();

	// Content panel in Procedure
	static JTextArea procedureText = new JTextArea();
	static JScrollPane procedureScrollPane = new JScrollPane(procedureText);

	static JLabel yesNo = new JLabel();

	// Procedure Data
	private static String procedureData;

	// Edit recipes
	static JPanel viewRecipePanel = new JPanel();
	static JPanel viewRecipePanel2 = new JPanel();
	static JLabel viewRecipeBG = new JLabel(new ImageIcon("viewRecipeBG.png"));

	static void editRecipe() {

		viewRecipePanel.removeAll();
		viewRecipePanel2.removeAll();

		// Add image button
		JButton addImage = new JButton();
		JLabel addImageLabel = new JLabel();

		// Favorites
		Font labelMark = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 10);
		JLabel mark = new JLabel("Mark as favorite?");

		// Content panel in Ingredients
		JPanel ingredients = new JPanel();
		JScrollPane ingredientsScrollPane = new JScrollPane(ingredients);
		JLabel linesBG = new JLabel(new ImageIcon("linesBG.png"));

		viewRecipePanel.removeAll();
		viewRecipePanel2.removeAll();

		recipeName.setText(recipeNameData);
		mealType.setText(mealTypeData);
		cuisine.setText(cuisineData);
		cookTime.setText(timeData);
		procedureText.setText(procedureData);

		addImageLabel.setIcon(new ImageIcon(imageData));
		addImage.setEnabled(true);

		// Ingredients
		ingredient1.setText(ingredientData1);
		quantity1.setText(quantityData1);
		unit1.setText(unitData1);

		ingredient2.setText(ingredientData2);
		quantity2.setText(quantityData2);
		unit2.setText(unitData2);

		ingredient3.setText(ingredientData3);
		quantity3.setText(quantityData3);
		unit3.setText(unitData3);

		ingredient4.setText(ingredientData4);
		quantity4.setText(quantityData4);
		unit4.setText(unitData4);

		ingredient5.setText(ingredientData5);
		quantity5.setText(quantityData5);
		unit5.setText(unitData5);

		ingredient6.setText(ingredientData6);
		quantity6.setText(quantityData6);
		unit6.setText(unitData6);

		ingredient7.setText(ingredientData7);
		quantity7.setText(quantityData7);
		unit7.setText(unitData7);

		ingredient8.setText(ingredientData8);
		quantity8.setText(quantityData8);
		unit8.setText(unitData8);

		ingredient9.setText(ingredientData9);
		quantity9.setText(quantityData9);
		unit9.setText(unitData9);

		ingredient10.setText(ingredientData10);
		quantity10.setText(quantityData10);
		unit10.setText(unitData10);

		ingredient11.setText(ingredientData11);
		quantity11.setText(quantityData11);
		unit11.setText(unitData11);

		ingredient12.setText(ingredientData12);
		quantity12.setText(quantityData12);
		unit12.setText(unitData12);

		ingredient13.setText(ingredientData13);
		quantity13.setText(quantityData13);
		unit13.setText(unitData13);

		ingredient14.setText(ingredientData14);
		quantity14.setText(quantityData14);
		unit14.setText(unitData14);

		ingredient15.setText(ingredientData15);
		quantity15.setText(quantityData15);
		unit15.setText(unitData15);

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

		if (favData.equals("Yes")) {
			clicked = false;
			yesNo.setText("Yes");
		} else {
			clicked = true;
			yesNo.setText("No");
		}

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

		// Panel properties
		viewRecipePanel.setLayout(null);
		viewRecipePanel.setBounds(236, 177, 1113, 573);
		viewRecipePanel.setOpaque(false);
		viewRecipePanel.setVisible(true);

		// Add image button
		addImage.setBounds(46, 16, 262, 173);
		addImage.setBorderPainted(true);
		addImage.setContentAreaFilled(false);
		addImage.setOpaque(false);
		addImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		addImageLabel.setBounds(46, 16, 262, 173);
		addImageLabel.setOpaque(false);

		// Recipe name
		recipeName.setBounds(320, 23, 263, 40);
		recipeName.setFont(titleF);
		recipeName.setForeground(new Color(38, 38, 38));
		recipeName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		recipeName.setOpaque(false);
//		recipeName.setBorder(null);

		mealType.setBounds(435, 77, 110, 25);
//		mealType.setBorder(null);

		cuisine.setBounds(435, 115, 110, 25);
//		cuisine.setBorder(null);

		cookTime.setBounds(435, 157, 110, 25);
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
		viewRecipeBG.setBounds(0, 0, 1113, 573);

		// Panel Layers
		viewRecipePanel.add(addImage, new Integer(0));
		viewRecipePanel.add(addImageLabel, new Integer(0));
		viewRecipePanel.add(recipeName, new Integer(1));
		viewRecipePanel.add(mealType, new Integer(1));
		viewRecipePanel.add(cuisine, new Integer(1));
		viewRecipePanel.add(cookTime, new Integer(1));
		viewRecipePanel.add(mark, new Integer(1));
		viewRecipePanel.add(yesNo, new Integer(1));
		viewRecipePanel.add(procedureScrollPane, new Integer(1));
		viewRecipePanel.add(ingredientsScrollPane, new Integer(1));

		// Add BG
		viewRecipePanel.add(viewRecipeBG, new Integer(1));

		// Add to main dashboard layers
		dashboardScreen.layeredPaneDashboard.add(viewRecipePanel, new Integer(4));
	}

	static void viewRecipe() {

		readData();
		viewRecipePanel.removeAll();
		viewRecipePanel2.removeAll();

		JLabel viewRecipeBG = new JLabel(new ImageIcon("viewRecipeBG.png"));

		// Recipe name
		JLabel recipeName = new JLabel(recipeNameData);

		// Image
		JLabel addImageLabel = new JLabel(new ImageIcon(imageData));

		// Meal type | Cuisine | Cook time
		VR_labels mealType = new VR_labels();
		VR_labels cuisine = new VR_labels();
		VR_labels cookTime = new VR_labels();

		// Content panel in Procedure
		JTextArea procedureText = new JTextArea(procedureData);
		procedureText.setEditable(false);
		JScrollPane procedureScrollPane = new JScrollPane(procedureText);

		// Favorites
		Font labelMark = new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 10);
		JLabel mark = new JLabel("Mark as favorite?");
		JLabel yesNo = new JLabel(favData);
		boolean clicked = false;

		// Content panel in Ingredients
		JPanel ingredients = new JPanel();
		JScrollPane ingredientsScrollPane = new JScrollPane(ingredients);
		JLabel linesBG = new JLabel(new ImageIcon("linesBG.png"));

		VR_labels ingredient1 = new VR_labels();
		VR_labelsIG quantity1 = new VR_labelsIG();
		VR_labelsIG unit1 = new VR_labelsIG();

		VR_labels ingredient2 = new VR_labels();
		VR_labelsIG quantity2 = new VR_labelsIG();
		VR_labelsIG unit2 = new VR_labelsIG();

		VR_labels ingredient3 = new VR_labels();
		VR_labelsIG quantity3 = new VR_labelsIG();
		VR_labelsIG unit3 = new VR_labelsIG();

		VR_labels ingredient4 = new VR_labels();
		VR_labelsIG quantity4 = new VR_labelsIG();
		VR_labelsIG unit4 = new VR_labelsIG();

		VR_labels ingredient5 = new VR_labels();
		VR_labelsIG quantity5 = new VR_labelsIG();
		VR_labelsIG unit5 = new VR_labelsIG();

		VR_labels ingredient6 = new VR_labels();
		VR_labelsIG quantity6 = new VR_labelsIG();
		VR_labelsIG unit6 = new VR_labelsIG();

		VR_labels ingredient7 = new VR_labels();
		VR_labelsIG quantity7 = new VR_labelsIG();
		VR_labelsIG unit7 = new VR_labelsIG();

		VR_labels ingredient8 = new VR_labels();
		VR_labelsIG quantity8 = new VR_labelsIG();
		VR_labelsIG unit8 = new VR_labelsIG();

		VR_labels ingredient9 = new VR_labels();
		VR_labelsIG quantity9 = new VR_labelsIG();
		VR_labelsIG unit9 = new VR_labelsIG();

		VR_labels ingredient10 = new VR_labels();
		VR_labelsIG quantity10 = new VR_labelsIG();
		VR_labelsIG unit10 = new VR_labelsIG();

		VR_labels ingredient11 = new VR_labels();
		VR_labelsIG quantity11 = new VR_labelsIG();
		VR_labelsIG unit11 = new VR_labelsIG();

		VR_labels ingredient12 = new VR_labels();
		VR_labelsIG quantity12 = new VR_labelsIG();
		VR_labelsIG unit12 = new VR_labelsIG();

		VR_labels ingredient13 = new VR_labels();
		VR_labelsIG quantity13 = new VR_labelsIG();
		VR_labelsIG unit13 = new VR_labelsIG();

		VR_labels ingredient14 = new VR_labels();
		VR_labelsIG quantity14 = new VR_labelsIG();
		VR_labelsIG unit14 = new VR_labelsIG();

		VR_labels ingredient15 = new VR_labels();
		VR_labelsIG quantity15 = new VR_labelsIG();
		VR_labelsIG unit15 = new VR_labelsIG();

		// Insert the data in the Label
		ingredient1.setText(ingredientData1);
		quantity1.setText(quantityData1);
		unit1.setText(unitData1);

		ingredient2.setText(ingredientData2);
		quantity2.setText(quantityData2);
		unit2.setText(unitData2);

		ingredient3.setText(ingredientData3);
		quantity3.setText(quantityData3);
		unit3.setText(unitData3);

		ingredient4.setText(ingredientData4);
		quantity4.setText(quantityData4);
		unit4.setText(unitData4);

		ingredient5.setText(ingredientData5);
		quantity5.setText(quantityData5);
		unit5.setText(unitData5);

		ingredient6.setText(ingredientData6);
		quantity6.setText(quantityData6);
		unit6.setText(unitData6);

		ingredient7.setText(ingredientData7);
		quantity7.setText(quantityData7);
		unit7.setText(unitData7);

		ingredient8.setText(ingredientData8);
		quantity8.setText(quantityData8);
		unit8.setText(unitData8);

		ingredient9.setText(ingredientData9);
		quantity9.setText(quantityData9);
		unit9.setText(unitData9);

		ingredient10.setText(ingredientData10);
		quantity10.setText(quantityData10);
		unit10.setText(unitData10);

		ingredient11.setText(ingredientData11);
		quantity11.setText(quantityData11);
		unit11.setText(unitData11);

		ingredient12.setText(ingredientData12);
		quantity12.setText(quantityData12);
		unit12.setText(unitData12);

		ingredient13.setText(ingredientData13);
		quantity13.setText(quantityData13);
		unit13.setText(unitData13);

		ingredient14.setText(ingredientData14);
		quantity14.setText(quantityData14);
		unit14.setText(unitData14);

		ingredient15.setText(ingredientData15);
		quantity15.setText(quantityData15);
		unit15.setText(unitData15);

		// Panel properties
		viewRecipePanel2.setLayout(null);
		viewRecipePanel2.setBounds(236, 177, 1113, 573);
		viewRecipePanel2.setOpaque(false);
		viewRecipePanel2.setVisible(true);

		addImageLabel.setBounds(46, 16, 263, 172);
		addImageLabel.setOpaque(false);

		// Recipe name
		recipeName.setBounds(320, 23, 263, 40);
		recipeName.setFont(titleF);
		recipeName.setForeground(new Color(38, 38, 38));
		recipeName.setOpaque(false);

		mealType.setBounds(435, 77, 110, 25);
		mealType.setText(mealTypeData);

		cuisine.setBounds(435, 115, 110, 25);
		cuisine.setText(cuisineData);

		cookTime.setBounds(435, 157, 110, 25);
		cookTime.setText(timeData);

		// Mark as favorite
		mark.setBounds(120, 190, 98, 15);
		mark.setFont(labelMark);
		mark.setForeground(new Color(100, 100, 100));

		yesNo.setBounds(214, 190, 25, 15);
		yesNo.setFont(labelMark);
		yesNo.setHorizontalAlignment(SwingConstants.CENTER);
		yesNo.setForeground(new Color(100, 100, 100));
		yesNo.setFocusable(false);
		yesNo.setOpaque(false);

		// Procedure
		procedureText.setFont(generalF);
		procedureText.setForeground(new Color(100, 100, 100));
		procedureText.setOpaque(true);
		procedureText.setBackground(Color.WHITE);
		procedureText.setLineWrap(true);
		procedureText.setWrapStyleWord(true);
//		procedureText.setBorder(BorderFactory.createLineBorder(Color.GRAY));

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

		// Layers
		// -------------------------------------------------------------------------------------------------------

		// Set rendering hints for text anti-aliasing
		recipeName.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		procedureText.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		mark.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		yesNo.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

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
		viewRecipeBG.setBounds(0, 0, 1113, 573);

		// Panel Layers
		viewRecipePanel2.add(addImageLabel, new Integer(0));
		viewRecipePanel2.add(recipeName, new Integer(1));
		viewRecipePanel2.add(mealType, new Integer(1));
		viewRecipePanel2.add(cuisine, new Integer(1));
		viewRecipePanel2.add(cookTime, new Integer(1));
		viewRecipePanel2.add(mark, new Integer(1));
		viewRecipePanel2.add(yesNo, new Integer(1));
		viewRecipePanel2.add(procedureScrollPane, new Integer(1));
		viewRecipePanel2.add(ingredientsScrollPane, new Integer(1));

		// Add BG
		viewRecipePanel2.add(viewRecipeBG, new Integer(1));

		// Add to main dashboard layers
		dashboardScreen.layeredPaneDashboard.add(viewRecipePanel2, new Integer(3));
	}

	static void readData() {

		viewRecipePanel.removeAll();
		viewRecipePanel2.removeAll();
		resetValues();

		// Data
		String filePath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator
				+ "PrintedData.csv";
		String filePath2 = System.getProperty("user.home") + File.separator + "Downloads" + File.separator
				+ "IngredientsData.csv";
		String filePath3 = System.getProperty("user.home") + File.separator + "Downloads" + File.separator
				+ "ProcedureData.csv";

		int rowIndex = dashboardScreen.index; // Assuming the row index is available in the dashboardScreen object
		String line = "";

		try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filePath));
				BufferedReader bufferedReader2 = new BufferedReader(new FileReader(filePath2));
				BufferedReader bufferedReader3 = new BufferedReader(new FileReader(filePath3))) {

			int currentRow = 0;

			while ((line = bufferedReader1.readLine()) != null) {
				if (currentRow == rowIndex) {
					String[] recipeData = line.split(",", -1);

					imageData = recipeData[0].replace("\"", "");
					recipeNameData = recipeData[1].replace("\"", "");
					mealTypeData = recipeData[2].replace("\"", "");
					cuisineData = recipeData[3].replace("\"", "");
					timeData = recipeData[4].replace("\"", "");
					favData = recipeData[5].replace("\"", "");

					break; // Exit the loop after reading the desired row
				}

				currentRow++;
			}

			currentRow = 0;

			while ((line = bufferedReader2.readLine()) != null) {
				if (currentRow == rowIndex) {
					String[] recipeData = line.split(",", -1);

					ingredientData1 = recipeData[0].replace("\"", "");
					quantityData1 = recipeData[1].replace("\"", "");
					unitData1 = recipeData[2].replace("\"", "");

					ingredientData2 = recipeData[3].replace("\"", "");
					quantityData2 = recipeData[4].replace("\"", "");
					unitData2 = recipeData[5].replace("\"", "");

					ingredientData3 = recipeData[6].replace("\"", "");
					quantityData3 = recipeData[7].replace("\"", "");
					unitData3 = recipeData[8].replace("\"", "");

					ingredientData4 = recipeData[9].replace("\"", "");
					quantityData4 = recipeData[10].replace("\"", "");
					unitData4 = recipeData[11].replace("\"", "");

					ingredientData5 = recipeData[12].replace("\"", "");
					quantityData5 = recipeData[13].replace("\"", "");
					unitData5 = recipeData[14].replace("\"", "");

					ingredientData6 = recipeData[15].replace("\"", "");
					quantityData6 = recipeData[16].replace("\"", "");
					unitData6 = recipeData[17].replace("\"", "");

					ingredientData7 = recipeData[18].replace("\"", "");
					quantityData7 = recipeData[19].replace("\"", "");
					unitData7 = recipeData[20].replace("\"", "");

					ingredientData8 = recipeData[21].replace("\"", "");
					quantityData8 = recipeData[22].replace("\"", "");
					unitData8 = recipeData[23].replace("\"", "");

					ingredientData9 = recipeData[24].replace("\"", "");
					quantityData9 = recipeData[25].replace("\"", "");
					unitData9 = recipeData[26].replace("\"", "");

					ingredientData10 = recipeData[27].replace("\"", "");
					quantityData10 = recipeData[28].replace("\"", "");
					unitData10 = recipeData[29].replace("\"", "");

					ingredientData11 = recipeData[30].replace("\"", "");
					quantityData11 = recipeData[31].replace("\"", "");
					unitData11 = recipeData[32].replace("\"", "");

					ingredientData12 = recipeData[33].replace("\"", "");
					quantityData12 = recipeData[34].replace("\"", "");
					unitData12 = recipeData[35].replace("\"", "");

					ingredientData13 = recipeData[36].replace("\"", "");
					quantityData13 = recipeData[37].replace("\"", "");
					unitData13 = recipeData[38].replace("\"", "");

					ingredientData14 = recipeData[39].replace("\"", "");
					quantityData14 = recipeData[40].replace("\"", "");
					unitData14 = recipeData[41].replace("\"", "");

					ingredientData15 = recipeData[42].replace("\"", "");
					quantityData15 = recipeData[43].replace("\"", "");
					unitData15 = recipeData[44].replace("\"", "");

					break; // Exit the loop after reading the desired row
				}

				currentRow++;
			}

			currentRow = 0;

			while ((line = bufferedReader3.readLine()) != null) {
				if (currentRow == rowIndex) {
					String[] recipeData = line.split(",", -1);

					procedureData = recipeData[0].replace("\\n", "\n").replace("<comma>", ",");
					procedureData = procedureData.replaceAll("^\"|\"$", "");

					break; // Exit the loop after reading the desired row
				}

				currentRow++;
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading data from CSV file: " + e.getMessage(),
					"Data Read Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	static void saveData() {
		System.out.println("Save the data");

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

		if (imageLocation == null || imageLocation.equals("")) {
			imageLocation = imageData;
		}

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

		String procedureDataWithoutComma = procedureData.replace(",", "<comma>"); // Replace commas with a
																					// placeholder
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

			// Delete the recipe and replace a new one
			addRecipeFeature.deleteRowData();
			imageLocation = "";

			// Clear all the data
			dashboardScreen.backToRecipe.doClick();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
		}

	}

	static void resetValues() {
		imageData = "";
		recipeNameData = "";
		mealTypeData = "";
		cuisineData = "";
		timeData = "";
		favData = "";

		ingredientData1 = "";
		quantityData1 = "";
		unitData1 = "";

		ingredientData2 = "";
		quantityData2 = "";
		unitData2 = "";

		ingredientData3 = "";
		quantityData3 = "";
		unitData3 = "";

		ingredientData4 = "";
		quantityData4 = "";
		unitData4 = "";

		ingredientData5 = "";
		quantityData5 = "";
		unitData5 = "";

		ingredientData6 = "";
		quantityData6 = "";
		unitData6 = "";

		ingredientData7 = "";
		quantityData7 = "";
		unitData7 = "";

		ingredientData8 = "";
		quantityData8 = "";
		unitData8 = "";

		ingredientData9 = "";
		quantityData9 = "";
		unitData9 = "";

		ingredientData10 = "";
		quantityData10 = "";
		unitData10 = "";

		ingredientData11 = "";
		quantityData11 = "";
		unitData11 = "";

		ingredientData12 = "";
		quantityData12 = "";
		unitData12 = "";

		ingredientData13 = "";
		quantityData13 = "";
		unitData13 = "";

		ingredientData14 = "";
		quantityData14 = "";
		unitData14 = "";

		ingredientData15 = "";
		quantityData15 = "";
		unitData15 = "";
	}
}
