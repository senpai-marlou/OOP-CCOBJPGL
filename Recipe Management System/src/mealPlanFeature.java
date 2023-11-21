import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class mealPlanFeature {

	// Main Panels
	static JPanel mainPlanPanel = new JPanel();
	static JScrollPane mainScroll = new JScrollPane();

	static ImageIcon mealPlanBG = new ImageIcon("mealPlanBG.png");
	static JLabel bg = new JLabel(mealPlanBG);

	// Sub panels
	static JPanel sundayPanel = new JPanel();
	static MP_scrollBar sundayScroll = new MP_scrollBar();
	static JButton sundayBtn = new JButton();

	static JPanel mondayPanel = new JPanel();
	static MP_scrollBar mondayScroll = new MP_scrollBar();
	static JButton mondayBtn = new JButton();

	static JPanel tuesdayPanel = new JPanel();
	static MP_scrollBar tuesdayScroll = new MP_scrollBar();
	static JButton tuesdayBtn = new JButton();

	static JPanel wednesdayPanel = new JPanel();
	static MP_scrollBar wednesdayScroll = new MP_scrollBar();
	static JButton wednesdayBtn = new JButton();

	static JPanel thursdayPanel = new JPanel();
	static MP_scrollBar thursdayScroll = new MP_scrollBar();
	static JButton thursdayBtn = new JButton();

	static JPanel fridayPanel = new JPanel();
	static MP_scrollBar fridayScroll = new MP_scrollBar();
	static JButton fridayBtn = new JButton();

	static JPanel saturdayPanel = new JPanel();
	static MP_scrollBar saturdayScroll = new MP_scrollBar();
	static JButton saturdayBtn = new JButton();

	// Logic
	static int actions = 0;

	// Data ComboBox
	static Set<String> existingSundayBreakfast = new HashSet<>();
	static Set<String> existingSundayLunch = new HashSet<>();
	static Set<String> existingSundaySnacks = new HashSet<>();
	static Set<String> existingSundayDinner = new HashSet<>();

	static Set<String> existingMondayBreakfast = new HashSet<>();
	static Set<String> existingMondayLunch = new HashSet<>();
	static Set<String> existingMondaySnacks = new HashSet<>();
	static Set<String> existingMondayDinner = new HashSet<>();

	static Set<String> existingTuesdayBreakfast = new HashSet<>();
	static Set<String> existingTuesdayLunch = new HashSet<>();
	static Set<String> existingTuesdaySnacks = new HashSet<>();
	static Set<String> existingTuesdayDinner = new HashSet<>();

	static Set<String> existingWednesdayBreakfast = new HashSet<>();
	static Set<String> existingWednesdayLunch = new HashSet<>();
	static Set<String> existingWednesdaySnacks = new HashSet<>();
	static Set<String> existingWednesdayDinner = new HashSet<>();

	static Set<String> existingThursdayBreakfast = new HashSet<>();
	static Set<String> existingThursdayLunch = new HashSet<>();
	static Set<String> existingThursdaySnacks = new HashSet<>();
	static Set<String> existingThursdayDinner = new HashSet<>();

	static Set<String> existingFridayBreakfast = new HashSet<>();
	static Set<String> existingFridayLunch = new HashSet<>();
	static Set<String> existingFridaySnacks = new HashSet<>();
	static Set<String> existingFridayDinner = new HashSet<>();

	static Set<String> existingSaturdayBreakfast = new HashSet<>();
	static Set<String> existingSaturdayLunch = new HashSet<>();
	static Set<String> existingSaturdaySnacks = new HashSet<>();
	static Set<String> existingSaturdayDinner = new HashSet<>();

	// ComboBox
	static MP_comboBox sundayBreakfast = new MP_comboBox();
	static MP_comboBox sundayLunch = new MP_comboBox();
	static MP_comboBox sundaySnacks = new MP_comboBox();
	static MP_comboBox sundayDinner = new MP_comboBox();

	static MP_comboBox mondayBreakfast = new MP_comboBox();
	static MP_comboBox mondayLunch = new MP_comboBox();
	static MP_comboBox mondaySnacks = new MP_comboBox();
	static MP_comboBox mondayDinner = new MP_comboBox();

	static MP_comboBox tuesdayBreakfast = new MP_comboBox();
	static MP_comboBox tuesdayLunch = new MP_comboBox();
	static MP_comboBox tuesdaySnacks = new MP_comboBox();
	static MP_comboBox tuesdayDinner = new MP_comboBox();

	static MP_comboBox wednesdayBreakfast = new MP_comboBox();
	static MP_comboBox wednesdayLunch = new MP_comboBox();
	static MP_comboBox wednesdaySnacks = new MP_comboBox();
	static MP_comboBox wednesdayDinner = new MP_comboBox();

	static MP_comboBox thursdayBreakfast = new MP_comboBox();
	static MP_comboBox thursdayLunch = new MP_comboBox();
	static MP_comboBox thursdaySnacks = new MP_comboBox();
	static MP_comboBox thursdayDinner = new MP_comboBox();

	static MP_comboBox fridayBreakfast = new MP_comboBox();
	static MP_comboBox fridayLunch = new MP_comboBox();
	static MP_comboBox fridaySnacks = new MP_comboBox();
	static MP_comboBox fridayDinner = new MP_comboBox();

	static MP_comboBox saturdayBreakfast = new MP_comboBox();
	static MP_comboBox saturdayLunch = new MP_comboBox();
	static MP_comboBox saturdaySnacks = new MP_comboBox();
	static MP_comboBox saturdayDinner = new MP_comboBox();

	// Tables
	static DefaultTableModel sBreakfastTbl = new DefaultTableModel();
	static MP_table sBreakfastTable = new MP_table(sBreakfastTbl);
	static DefaultTableModel sLunchTbl = new DefaultTableModel();
	static MP_table sLunchTable = new MP_table(sLunchTbl);
	static DefaultTableModel sSnacksTbl = new DefaultTableModel();
	static MP_table sSnacksTable = new MP_table(sSnacksTbl);
	static DefaultTableModel sDinnerTbl = new DefaultTableModel();
	static MP_table sDinnerTable = new MP_table(sDinnerTbl);

	static DefaultTableModel mBreakfastTbl = new DefaultTableModel();
	static MP_table mBreakfastTable = new MP_table(mBreakfastTbl);
	static DefaultTableModel mLunchTbl = new DefaultTableModel();
	static MP_table mLunchTable = new MP_table(mLunchTbl);
	static DefaultTableModel mSnacksTbl = new DefaultTableModel();
	static MP_table mSnacksTable = new MP_table(mSnacksTbl);
	static DefaultTableModel mDinnerTbl = new DefaultTableModel();
	static MP_table mDinnerTable = new MP_table(mDinnerTbl);

	static DefaultTableModel tBreakfastTbl = new DefaultTableModel();
	static MP_table tBreakfastTable = new MP_table(tBreakfastTbl);
	static DefaultTableModel tLunchTbl = new DefaultTableModel();
	static MP_table tLunchTable = new MP_table(tLunchTbl);
	static DefaultTableModel tSnacksTbl = new DefaultTableModel();
	static MP_table tSnacksTable = new MP_table(tSnacksTbl);
	static DefaultTableModel tDinnerTbl = new DefaultTableModel();
	static MP_table tDinnerTable = new MP_table(tDinnerTbl);

	static DefaultTableModel wBreakfastTbl = new DefaultTableModel();
	static MP_table wBreakfastTable = new MP_table(wBreakfastTbl);
	static DefaultTableModel wLunchTbl = new DefaultTableModel();
	static MP_table wLunchTable = new MP_table(wLunchTbl);
	static DefaultTableModel wSnacksTbl = new DefaultTableModel();
	static MP_table wSnacksTable = new MP_table(wSnacksTbl);
	static DefaultTableModel wDinnerTbl = new DefaultTableModel();
	static MP_table wDinnerTable = new MP_table(wDinnerTbl);

	static DefaultTableModel thBreakfastTbl = new DefaultTableModel();
	static MP_table thBreakfastTable = new MP_table(thBreakfastTbl);
	static DefaultTableModel thLunchTbl = new DefaultTableModel();
	static MP_table thLunchTable = new MP_table(thLunchTbl);
	static DefaultTableModel thSnacksTbl = new DefaultTableModel();
	static MP_table thSnacksTable = new MP_table(thSnacksTbl);
	static DefaultTableModel thDinnerTbl = new DefaultTableModel();
	static MP_table thDinnerTable = new MP_table(thDinnerTbl);

	static DefaultTableModel fBreakfastTbl = new DefaultTableModel();
	static MP_table fBreakfastTable = new MP_table(fBreakfastTbl);
	static DefaultTableModel fLunchTbl = new DefaultTableModel();
	static MP_table fLunchTable = new MP_table(fLunchTbl);
	static DefaultTableModel fSnacksTbl = new DefaultTableModel();
	static MP_table fSnacksTable = new MP_table(fSnacksTbl);
	static DefaultTableModel fDinnerTbl = new DefaultTableModel();
	static MP_table fDinnerTable = new MP_table(fDinnerTbl);

	static DefaultTableModel satBreakfastTbl = new DefaultTableModel();
	static MP_table satBreakfastTable = new MP_table(satBreakfastTbl);
	static DefaultTableModel satLunchTbl = new DefaultTableModel();
	static MP_table satLunchTable = new MP_table(satLunchTbl);
	static DefaultTableModel satSnacksTbl = new DefaultTableModel();
	static MP_table satSnacksTable = new MP_table(satSnacksTbl);
	static DefaultTableModel satDinnerTbl = new DefaultTableModel();
	static MP_table satDinnerTable = new MP_table(satDinnerTbl);

	static void printTable() {
		readCSVFile();
		ActionListener comboBoxListener = e -> {

			String selectedMeal = ((JComboBox<?>) e.getSource()).getSelectedItem().toString();

			String fileName = System.getProperty("user.home") + File.separator + "Downloads" + File.separator
					+ "PrintedData.csv";
			String fileName2 = System.getProperty("user.home") + File.separator + "Downloads" + File.separator
					+ "IngredientsData.csv";

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				int rowIndex = 0;
				String line;
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",");
					if (data[1].equals("\"" + selectedMeal + "\"")) {
						try (BufferedReader br2 = new BufferedReader(new FileReader(fileName2))) {
							int currentIndex = 0;
							String line2;
							while ((line2 = br2.readLine()) != null) {
								if (currentIndex == rowIndex) {
									String[] data2 = line2.split(",");
									DefaultTableModel tableModel = getTableModel(e);
									if (tableModel != null) {

										clearTableModel(tableModel);
										for (int i = 1; i <= 43; i += 3) {

											if (data2[i].replace("\"", "") == "") {
												break; // Stop the loop if the meal is null or empty
											}

											String meal = "• " + data2[i].replace("\"", "") + " "
													+ data2[i + 1].replace("\"", "") + " "
													+ data2[i - 1].replace("\"", "");

											tableModel.addRow(new Object[] { meal });
										}
									}
									break;
								}
								currentIndex++;
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					rowIndex++;
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		};

		if (actions == 0) { // Make sure not to multiply the actionListeners
			addActionListeners(comboBoxListener);
			actions++;
		}
	}

	static void mealPlan() {

		// Main Panel properties
		bg.setBounds(0, 0, 1998, 567);

		UIManager.put("ToolTip.font", dashboardScreen.tooltipFont);
		UIManager.put("ToolTip.background", dashboardScreen.tooltipBackground);

		mainPlanPanel.setLayout(null);
		mainPlanPanel.setPreferredSize(new Dimension(1998, 567));
		mainPlanPanel.setOpaque(false);
		mainPlanPanel.setVisible(true);

		// Add & Customized Scroll Pane
		mainScroll.setBounds(222, 177, 1143, 570);
		mainScroll.setBorder(BorderFactory.createEmptyBorder());
		mainScroll.getHorizontalScrollBar().setUI(new CustomScrollBarUI3());
		mainScroll.getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, 13));

		mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		mainScroll.setWheelScrollingEnabled(true);
		mainScroll.getHorizontalScrollBar().setUnitIncrement(8);

		mainScroll.setViewportView(mainPlanPanel);

// Sunday Panel --------------------------------------------------------------------------------------
		sundayPanel.setLayout(null);
		sundayPanel.setPreferredSize(new Dimension(245, 1080));
		sundayPanel.setVisible(true);
		sundayPanel.setBackground(Color.WHITE);

		sundayScroll.setBounds(25, 55, 245, 485);
		sundayScroll.setViewportView(sundayPanel);

		// ComboBox for breakfast
		sundayBreakfast.setBounds(0, 0, 234, 25);
		sundayBreakfast.addItem(" Breakfast");
		sundayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		sundayLunch.setBounds(0, 270, 234, 25);
		sundayLunch.addItem(" Lunch");
		sundayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		sundaySnacks.setBounds(0, 540, 234, 25);
		sundaySnacks.addItem(" Snacks");
		sundaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		sundayDinner.setBounds(0, 810, 234, 25);
		sundayDinner.addItem(" Dinner");
		sundayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		sBreakfastTable.setBounds(5, 25, 234, 240);
		sBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		sLunchTable.setBounds(5, 295, 234, 240);
		sLunchTbl.addColumn("Column 1");

		// Table for Snacks
		sSnacksTable.setBounds(5, 565, 234, 240);
		sSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		sDinnerTable.setBounds(5, 835, 234, 240);
		sDinnerTbl.addColumn("Column 1");

// Monday Panel --------------------------------------------------------------------------------------
		mondayPanel.setLayout(null);
		mondayPanel.setPreferredSize(new Dimension(245, 1080));
		mondayPanel.setVisible(true);
		mondayPanel.setBackground(Color.WHITE);

		mondayScroll.setBounds(309, 55, 245, 485);
		mondayScroll.setViewportView(mondayPanel);

		// ComboBox for breakfast
		mondayBreakfast.setBounds(0, 0, 234, 25);
		mondayBreakfast.addItem(" Breakfast");
		mondayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		mondayLunch.setBounds(0, 270, 234, 25);
		mondayLunch.addItem(" Lunch");
		mondayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		mondaySnacks.setBounds(0, 540, 234, 25);
		mondaySnacks.addItem(" Snacks");
		mondaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		mondayDinner.setBounds(0, 810, 234, 25);
		mondayDinner.addItem(" Dinner");
		mondayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		mBreakfastTable.setBounds(5, 25, 234, 240);
		mBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		mLunchTable.setBounds(5, 295, 234, 240);
		mLunchTbl.addColumn("Column 1");

		// Table for Snacks
		mSnacksTable.setBounds(5, 565, 234, 240);
		mSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		mDinnerTable.setBounds(5, 835, 234, 240);
		mDinnerTbl.addColumn("Column 1");

// Tuesday Panel --------------------------------------------------------------------------------------	

		tuesdayPanel.setLayout(null);
		tuesdayPanel.setPreferredSize(new Dimension(245, 1080));
		tuesdayPanel.setVisible(true);
		tuesdayPanel.setBackground(Color.WHITE);

		tuesdayScroll.setBounds(593, 55, 245, 485);
		tuesdayScroll.setViewportView(tuesdayPanel);

		// ComboBox for breakfast
		tuesdayBreakfast.setBounds(0, 0, 234, 25);
		tuesdayBreakfast.addItem(" Breakfast");
		tuesdayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		tuesdayLunch.setBounds(0, 270, 234, 25);
		tuesdayLunch.addItem(" Lunch");
		tuesdayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		tuesdaySnacks.setBounds(0, 540, 234, 25);
		tuesdaySnacks.addItem(" Snacks");
		tuesdaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		tuesdayDinner.setBounds(0, 810, 234, 25);
		tuesdayDinner.addItem(" Dinner");
		tuesdayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		tBreakfastTable.setBounds(5, 25, 234, 240);
		tBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		tLunchTable.setBounds(5, 295, 234, 240);
		tLunchTbl.addColumn("Column 1");

		// Table for Snacks
		tSnacksTable.setBounds(5, 565, 234, 240);
		tSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		tDinnerTable.setBounds(5, 835, 234, 240);
		tDinnerTbl.addColumn("Column 1");

// Wednesday ------------------------------------------------------------------------------------------

		wednesdayPanel.setLayout(null);
		wednesdayPanel.setPreferredSize(new Dimension(245, 1080));
		wednesdayPanel.setVisible(true);
		wednesdayPanel.setBackground(Color.WHITE);

		wednesdayScroll.setBounds(877, 55, 245, 485);
		wednesdayScroll.setViewportView(wednesdayPanel);

		// ComboBox for breakfast
		wednesdayBreakfast.setBounds(0, 0, 234, 25);
		wednesdayBreakfast.addItem(" Breakfast");
		wednesdayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		wednesdayLunch.setBounds(0, 270, 234, 25);
		wednesdayLunch.addItem(" Lunch");
		wednesdayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		wednesdaySnacks.setBounds(0, 540, 234, 25);
		wednesdaySnacks.addItem(" Snacks");
		wednesdaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		wednesdayDinner.setBounds(0, 810, 234, 25);
		wednesdayDinner.addItem(" Dinner");
		wednesdayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		wBreakfastTable.setBounds(5, 25, 234, 240);
		wBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		wLunchTable.setBounds(5, 295, 234, 240);
		wLunchTbl.addColumn("Column 1");

		// Table for Snacks
		wSnacksTable.setBounds(5, 565, 234, 240);
		wSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		wDinnerTable.setBounds(5, 835, 234, 240);
		wDinnerTbl.addColumn("Column 1");

// Thursday -------------------------------------------------------------------------------------------
		thursdayPanel.setLayout(null);
		thursdayPanel.setPreferredSize(new Dimension(245, 1080));
		thursdayPanel.setVisible(true);
		thursdayPanel.setBackground(Color.WHITE);

		thursdayScroll.setBounds(1161, 55, 245, 485);
		thursdayScroll.setViewportView(thursdayPanel);

		// ComboBox for breakfast
		thursdayBreakfast.setBounds(0, 0, 234, 25);
		thursdayBreakfast.addItem(" Breakfast");
		thursdayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		thursdayLunch.setBounds(0, 270, 234, 25);
		thursdayLunch.addItem(" Lunch");
		thursdayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		thursdaySnacks.setBounds(0, 540, 234, 25);
		thursdaySnacks.addItem(" Snacks");
		thursdaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		thursdayDinner.setBounds(0, 810, 234, 25);
		thursdayDinner.addItem(" Dinner");
		thursdayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		thBreakfastTable.setBounds(5, 25, 234, 240);
		thBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		thLunchTable.setBounds(5, 295, 234, 240);
		thLunchTbl.addColumn("Column 1");

		// Table for Snacks
		thSnacksTable.setBounds(5, 565, 234, 240);
		thSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		thDinnerTable.setBounds(5, 835, 234, 240);
		thDinnerTbl.addColumn("Column 1");

// Friday ---------------------------------------------------------------------------------------------

		fridayPanel.setLayout(null);
		fridayPanel.setPreferredSize(new Dimension(245, 1080));
		fridayPanel.setVisible(true);
		fridayPanel.setBackground(Color.WHITE);

		fridayScroll.setBounds(1445, 55, 245, 485);
		fridayScroll.setViewportView(fridayPanel);

		// ComboBox for breakfast
		fridayBreakfast.setBounds(0, 0, 234, 25);
		fridayBreakfast.addItem(" Breakfast");
		fridayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		fridayLunch.setBounds(0, 270, 234, 25);
		fridayLunch.addItem(" Lunch");
		fridayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		fridaySnacks.setBounds(0, 540, 234, 25);
		fridaySnacks.addItem(" Snacks");
		fridaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		fridayDinner.setBounds(0, 810, 234, 25);
		fridayDinner.addItem(" Dinner");
		fridayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		fBreakfastTable.setBounds(5, 25, 234, 240);
		fBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		fLunchTable.setBounds(5, 295, 234, 240);
		fLunchTbl.addColumn("Column 1");

		// Table for Snacks
		fSnacksTable.setBounds(5, 565, 234, 240);
		fSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		fDinnerTable.setBounds(5, 835, 234, 240);
		fDinnerTbl.addColumn("Column 1");

// Saturday --------------------------------------------------------------------------------------------
		saturdayPanel.setLayout(null);
		saturdayPanel.setPreferredSize(new Dimension(245, 1080));
		saturdayPanel.setVisible(true);
		saturdayPanel.setBackground(Color.WHITE);

		saturdayScroll.setBounds(1730, 55, 245, 485);
		saturdayScroll.setViewportView(saturdayPanel);

		// ComboBox for breakfast
		saturdayBreakfast.setBounds(0, 0, 234, 25);
		saturdayBreakfast.addItem(" Breakfast");
		saturdayBreakfast.setToolTipText("Breakfast 4 am - 11 am");

		// ComboBox for Lunch
		saturdayLunch.setBounds(0, 270, 234, 25);
		saturdayLunch.addItem(" Lunch");
		saturdayLunch.setToolTipText("Lunch 12 pm - 2 pm");

		// ComboBox for Snacks
		saturdaySnacks.setBounds(0, 540, 234, 25);
		saturdaySnacks.addItem(" Snacks");
		saturdaySnacks.setToolTipText("Snacks 3 pm - 5 pm");

		// ComboBox for Dinner
		saturdayDinner.setBounds(0, 810, 234, 25);
		saturdayDinner.addItem(" Dinner");
		saturdayDinner.setToolTipText("Dinner 6 pm - 9 pm");

		// Table for breakfast
		satBreakfastTable.setBounds(5, 25, 234, 240);
		satBreakfastTbl.addColumn("Column 1");

		// Table for Lunch
		satLunchTable.setBounds(5, 295, 234, 240);
		satLunchTbl.addColumn("Column 1");

		// Table for Snacks
		satSnacksTable.setBounds(5, 565, 234, 240);
		satSnacksTbl.addColumn("Column 1");

		// Table for Dinner
		satDinnerTable.setBounds(5, 835, 234, 240);
		satDinnerTbl.addColumn("Column 1");

// End of the week -------------------------------------------------------------------------------------	

		// mainPlanPanel Layers
		mainPlanPanel.add(sundayScroll, new Integer(1));
		mainPlanPanel.add(mondayScroll, new Integer(1));
		mainPlanPanel.add(tuesdayScroll, new Integer(1));
		mainPlanPanel.add(wednesdayScroll, new Integer(1));
		mainPlanPanel.add(thursdayScroll, new Integer(1));
		mainPlanPanel.add(fridayScroll, new Integer(1));
		mainPlanPanel.add(saturdayScroll, new Integer(1));

		// Main Panel BG
		mainPlanPanel.add(bg, new Integer(2));

		// Sunday Panel
		sundayPanel.add(sundayBreakfast); // ComboBox
		sundayPanel.add(sundayLunch);
		sundayPanel.add(sundaySnacks);
		sundayPanel.add(sundayDinner);

		sundayPanel.add(sDinnerTable); // Table
		sundayPanel.add(sBreakfastTable);
		sundayPanel.add(sSnacksTable);
		sundayPanel.add(sLunchTable);

		// Monday Panel
		mondayPanel.add(mondayBreakfast); // ComboBox
		mondayPanel.add(mondayLunch);
		mondayPanel.add(mondaySnacks);
		mondayPanel.add(mondayDinner);

		mondayPanel.add(mDinnerTable); // Table
		mondayPanel.add(mBreakfastTable);
		mondayPanel.add(mSnacksTable);
		mondayPanel.add(mLunchTable);

		// Tuesday Panel
		tuesdayPanel.add(tuesdayBreakfast); // ComboBox
		tuesdayPanel.add(tuesdayLunch);
		tuesdayPanel.add(tuesdaySnacks);
		tuesdayPanel.add(tuesdayDinner);

		tuesdayPanel.add(tDinnerTable); // Table
		tuesdayPanel.add(tBreakfastTable);
		tuesdayPanel.add(tSnacksTable);
		tuesdayPanel.add(tLunchTable);

		// Tuesday Panel
		wednesdayPanel.add(wednesdayBreakfast); // ComboBox
		wednesdayPanel.add(wednesdayLunch);
		wednesdayPanel.add(wednesdaySnacks);
		wednesdayPanel.add(wednesdayDinner);

		wednesdayPanel.add(wDinnerTable); // Table
		wednesdayPanel.add(wBreakfastTable);
		wednesdayPanel.add(wSnacksTable);
		wednesdayPanel.add(wLunchTable);

		// Tuesday Panel
		thursdayPanel.add(thursdayBreakfast); // ComboBox
		thursdayPanel.add(thursdayLunch);
		thursdayPanel.add(thursdaySnacks);
		thursdayPanel.add(thursdayDinner);

		thursdayPanel.add(thDinnerTable); // Table
		thursdayPanel.add(thBreakfastTable);
		thursdayPanel.add(thSnacksTable);
		thursdayPanel.add(thLunchTable);

		// Tuesday Panel
		fridayPanel.add(fridayBreakfast); // ComboBox
		fridayPanel.add(fridayLunch);
		fridayPanel.add(fridaySnacks);
		fridayPanel.add(fridayDinner);

		fridayPanel.add(fDinnerTable); // Table
		fridayPanel.add(fBreakfastTable);
		fridayPanel.add(fSnacksTable);
		fridayPanel.add(fLunchTable);

		// Tuesday Panel
		saturdayPanel.add(saturdayBreakfast); // ComboBox
		saturdayPanel.add(saturdayLunch);
		saturdayPanel.add(saturdaySnacks);
		saturdayPanel.add(saturdayDinner);

		saturdayPanel.add(satDinnerTable); // Table
		saturdayPanel.add(satBreakfastTable);
		saturdayPanel.add(satSnacksTable);
		saturdayPanel.add(satLunchTable);

		// Add to main dashboard layers
		dashboardScreen.layeredPaneDashboard.add(mainScroll, new Integer(3));

	}

	static void readCSVFile() {
		String fileName = (System.getProperty("user.home") + File.separator + "Downloads" + File.separator
				+ "PrintedData.csv");
		String line;
		Set<String> newSundayBreakfast = new HashSet<>();
		Set<String> newSundayLunch = new HashSet<>();
		Set<String> newSundaySnacks = new HashSet<>();
		Set<String> newSundayDinner = new HashSet<>();

		Set<String> newMondayBreakfast = new HashSet<>();
		Set<String> newMondayLunch = new HashSet<>();
		Set<String> newMondaySnacks = new HashSet<>();
		Set<String> newMondayDinner = new HashSet<>();

		Set<String> newTuesdayBreakfast = new HashSet<>();
		Set<String> newTuesdayLunch = new HashSet<>();
		Set<String> newTuesdaySnacks = new HashSet<>();
		Set<String> newTuesdayDinner = new HashSet<>();

		Set<String> newWednesdayBreakfast = new HashSet<>();
		Set<String> newWednesdayLunch = new HashSet<>();
		Set<String> newWednesdaySnacks = new HashSet<>();
		Set<String> newWednesdayDinner = new HashSet<>();

		Set<String> newThursdayBreakfast = new HashSet<>();
		Set<String> newThursdayLunch = new HashSet<>();
		Set<String> newThursdaySnacks = new HashSet<>();
		Set<String> newThursdayDinner = new HashSet<>();

		Set<String> newFridayBreakfast = new HashSet<>();
		Set<String> newFridayLunch = new HashSet<>();
		Set<String> newFridaySnacks = new HashSet<>();
		Set<String> newFridayDinner = new HashSet<>();

		Set<String> newSaturdayBreakfast = new HashSet<>();
		Set<String> newSaturdayLunch = new HashSet<>();
		Set<String> newSaturdaySnacks = new HashSet<>();
		Set<String> newSaturdayDinner = new HashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String recipeName = data[1].replace("\"", "");
				String mealType = data[2].replace("\"", "");

				if (mealType.equalsIgnoreCase("Breakfast")) {
					newSundayBreakfast.add(recipeName);
					newMondayBreakfast.add(recipeName);
					newTuesdayBreakfast.add(recipeName);
					newWednesdayBreakfast.add(recipeName);
					newThursdayBreakfast.add(recipeName);
					newFridayBreakfast.add(recipeName);
					newSaturdayBreakfast.add(recipeName);
				} else if (mealType.equalsIgnoreCase("Lunch")) {
					newSundayLunch.add(recipeName);
					newMondayLunch.add(recipeName);
					newTuesdayLunch.add(recipeName);
					newWednesdayLunch.add(recipeName);
					newThursdayLunch.add(recipeName);
					newFridayLunch.add(recipeName);
					newSaturdayLunch.add(recipeName);
				} else if (mealType.equalsIgnoreCase("Snacks")) {
					newSundaySnacks.add(recipeName);
					newMondaySnacks.add(recipeName);
					newTuesdaySnacks.add(recipeName);
					newWednesdaySnacks.add(recipeName);
					newThursdaySnacks.add(recipeName);
					newFridaySnacks.add(recipeName);
					newSaturdaySnacks.add(recipeName);
				} else if (mealType.equalsIgnoreCase("Dinner")) {
					newSundayDinner.add(recipeName);
					newMondayDinner.add(recipeName);
					newTuesdayDinner.add(recipeName);
					newWednesdayDinner.add(recipeName);
					newThursdayDinner.add(recipeName);
					newFridayDinner.add(recipeName);
					newSaturdayDinner.add(recipeName);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Update the HashSet and ComboBoxes
		updateComboBox(sundayBreakfast, existingSundayBreakfast, newSundayBreakfast);
		updateComboBox(sundayLunch, existingSundayLunch, newSundayLunch);
		updateComboBox(sundaySnacks, existingSundaySnacks, newSundaySnacks);
		updateComboBox(sundayDinner, existingSundayDinner, newSundayDinner);

		updateComboBox(mondayBreakfast, existingMondayBreakfast, newMondayBreakfast);
		updateComboBox(mondayLunch, existingMondayLunch, newMondayLunch);
		updateComboBox(mondaySnacks, existingMondaySnacks, newMondaySnacks);
		updateComboBox(mondayDinner, existingMondayDinner, newMondayDinner);

		updateComboBox(tuesdayBreakfast, existingTuesdayBreakfast, newTuesdayBreakfast);
		updateComboBox(tuesdayLunch, existingTuesdayLunch, newTuesdayLunch);
		updateComboBox(tuesdaySnacks, existingTuesdaySnacks, newTuesdaySnacks);
		updateComboBox(tuesdayDinner, existingTuesdayDinner, newTuesdayDinner);

		updateComboBox(wednesdayBreakfast, existingWednesdayBreakfast, newWednesdayBreakfast);
		updateComboBox(wednesdayLunch, existingWednesdayLunch, newWednesdayLunch);
		updateComboBox(wednesdaySnacks, existingWednesdaySnacks, newWednesdaySnacks);
		updateComboBox(wednesdayDinner, existingWednesdayDinner, newWednesdayDinner);

		updateComboBox(thursdayBreakfast, existingThursdayBreakfast, newThursdayBreakfast);
		updateComboBox(thursdayLunch, existingThursdayLunch, newThursdayLunch);
		updateComboBox(thursdaySnacks, existingThursdaySnacks, newThursdaySnacks);
		updateComboBox(thursdayDinner, existingThursdayDinner, newThursdayDinner);

		updateComboBox(fridayBreakfast, existingFridayBreakfast, newFridayBreakfast);
		updateComboBox(fridayLunch, existingFridayLunch, newFridayLunch);
		updateComboBox(fridaySnacks, existingFridaySnacks, newFridaySnacks);
		updateComboBox(fridayDinner, existingFridayDinner, newFridayDinner);

		updateComboBox(saturdayBreakfast, existingSaturdayBreakfast, newSaturdayBreakfast);
		updateComboBox(saturdayLunch, existingSaturdayLunch, newSaturdayLunch);
		updateComboBox(saturdaySnacks, existingSaturdaySnacks, newSaturdaySnacks);
		updateComboBox(saturdayDinner, existingSaturdayDinner, newSaturdayDinner);
	}

	static void updateComboBox(JComboBox<String> comboBox, Set<String> existingSet, Set<String> newSet) {
		// Find the deleted recipe by comparing the existing set with the new set
		String deletedRecipe = "";
		for (String recipe : existingSet) {
			if (!newSet.contains(recipe)) {
				deletedRecipe = recipe;
				break;
			}
		}

		// Update the HashSet and ComboBox only if a recipe is deleted
		if (!deletedRecipe.isEmpty()) {
			existingSet.remove(deletedRecipe);
			comboBox.removeItem(deletedRecipe);
		}

		// Add new recipes to the HashSet and ComboBox
		for (String recipe : newSet) {
			if (!existingSet.contains(recipe)) {
				existingSet.add(recipe);
				comboBox.addItem(recipe);
			}
		}
	}

	private static DefaultTableModel getTableModel(ActionEvent e) {

		Component source = (Component) e.getSource();

		if (source == sundayBreakfast) {
			return sBreakfastTbl;
		} else if (source == sundayLunch) {
			return sLunchTbl;
		} else if (source == sundaySnacks) {
			return sSnacksTbl;
		} else if (source == sundayDinner) {
			return sDinnerTbl;
		} else if (source == mondayBreakfast) {
			return mBreakfastTbl;
		} else if (source == mondayLunch) {
			return mLunchTbl;
		} else if (source == mondaySnacks) {
			return mSnacksTbl;
		} else if (source == mondayDinner) {
			return mDinnerTbl;
		} else if (source == tuesdayBreakfast) {
			return tBreakfastTbl;
		} else if (source == tuesdayLunch) {
			return tLunchTbl;
		} else if (source == tuesdaySnacks) {
			return tSnacksTbl;
		} else if (source == tuesdayDinner) {
			return tDinnerTbl;
		} else if (source == wednesdayBreakfast) {
			return wBreakfastTbl;
		} else if (source == wednesdayLunch) {
			return wLunchTbl;
		} else if (source == wednesdaySnacks) {
			return wSnacksTbl;
		} else if (source == wednesdayDinner) {
			return wDinnerTbl;
		} else if (source == thursdayBreakfast) {
			return thBreakfastTbl;
		} else if (source == thursdayLunch) {
			return thLunchTbl;
		} else if (source == thursdaySnacks) {
			return thSnacksTbl;
		} else if (source == thursdayDinner) {
			return thDinnerTbl;
		} else if (source == fridayBreakfast) {
			return fBreakfastTbl;
		} else if (source == fridayLunch) {
			return fLunchTbl;
		} else if (source == fridaySnacks) {
			return fSnacksTbl;
		} else if (source == fridayDinner) {
			return fDinnerTbl;
		} else if (source == saturdayBreakfast) {
			return satBreakfastTbl;
		} else if (source == saturdayLunch) {
			return satLunchTbl;
		} else if (source == saturdaySnacks) {
			return satSnacksTbl;
		} else if (source == saturdayDinner) {
			return satDinnerTbl;
		}

		return null;
	}

	private static void addActionListeners(ActionListener comboBoxListener) {

		sundayBreakfast.addActionListener(comboBoxListener);
		sundayLunch.addActionListener(comboBoxListener);
		sundaySnacks.addActionListener(comboBoxListener);
		sundayDinner.addActionListener(comboBoxListener);

		mondayBreakfast.addActionListener(comboBoxListener);
		mondayLunch.addActionListener(comboBoxListener);
		mondaySnacks.addActionListener(comboBoxListener);
		mondayDinner.addActionListener(comboBoxListener);

		tuesdayBreakfast.addActionListener(comboBoxListener);
		tuesdayLunch.addActionListener(comboBoxListener);
		tuesdaySnacks.addActionListener(comboBoxListener);
		tuesdayDinner.addActionListener(comboBoxListener);

		wednesdayBreakfast.addActionListener(comboBoxListener);
		wednesdayLunch.addActionListener(comboBoxListener);
		wednesdaySnacks.addActionListener(comboBoxListener);
		wednesdayDinner.addActionListener(comboBoxListener);

		thursdayBreakfast.addActionListener(comboBoxListener);
		thursdayLunch.addActionListener(comboBoxListener);
		thursdaySnacks.addActionListener(comboBoxListener);
		thursdayDinner.addActionListener(comboBoxListener);

		fridayBreakfast.addActionListener(comboBoxListener);
		fridayLunch.addActionListener(comboBoxListener);
		fridaySnacks.addActionListener(comboBoxListener);
		fridayDinner.addActionListener(comboBoxListener);

		saturdayBreakfast.addActionListener(comboBoxListener);
		saturdayLunch.addActionListener(comboBoxListener);
		saturdaySnacks.addActionListener(comboBoxListener);
		saturdayDinner.addActionListener(comboBoxListener);
	}

	private static void clearTableModel(DefaultTableModel tableModel) {
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
}
