package org.DragonflyAutomation;

import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

public class DragonflyLaunch extends JFrame {
	private static final long serialVersionUID = 1L;

	public DragonflyLaunch() {
		//headers for the table
		//"strAction", "strLogicalName", "strTagName", "strAttributeNames", "strAttributeValues", "strInputValue", "strAssert", "blnOptional", "blnExitOnFail", "intMillisecondsToWait", "strFunction", "strOutputLinkName", "strLoopOrIf", "blnPleaseWait", "blnHighlight", "blnScreenshot", "strAssistiveProperties", "strOutputValue";
		
		String[] columns = new String[] { "Id", "Name", "Hourly Rate", "Part Time" };
		//actual data for the table in a 2d array
		Object[][] data = new Object[][] { { 1, "John", 40.0, false }, { 2, "Rambo", 70.0, false }, { 3, "Zorro", 60.0, true }, };
		//create table with data
		JTable table = new JTable(data, columns);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//actual data for the table in a 2d array
		//Object[][] data = new Object[][] { { 1, "John", 40.0, false }, { 2, "Rambo", 70.0, false }, { 3, "Zorro", 60.0, true }, };
		//create table with data
		//	JTable table = new JTable(data, columns);
		TableColumn sportColumn = table.getColumnModel().getColumn(2);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Snowboarding");
		comboBox.addItem("Rowing");
		comboBox.addItem("Chasing toddlers");
		comboBox.addItem("Speed reading");
		comboBox.addItem("Teaching high school");
		comboBox.addItem("None");
		sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
		//add the table to the frame
		this.add(new JScrollPane(table));
		this.setTitle("Table Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DragonflyLaunch();
			}
		});
	}
}