package org.DragonflyAutomation;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

class DialogLocal extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ButtonGroup grpBrowser = new ButtonGroup();
	private ButtonGroup grpEnvironment = new ButtonGroup();
	private ButtonGroup grpTestArea = new ButtonGroup();
	private FilenameFilter objFilter;
	private Font fntDialog = new Font("Tahoma", Font.PLAIN, 20);
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnRun = new JButton("Run");
	private JComboBox<String> cboApplication = new JComboBox<String>();
	private JComboBox<String> cboTest = new JComboBox<String>();
	private JLabel lblSelectTheApplication = new JLabel("Select the application");
	private JLabel lblSelectTheBrowser = new JLabel("Select the browser");
	private JLabel lblSelectTheEnvironment = new JLabel("Select the environment");
	private JLabel lblSelectTheTest = new JLabel("Select the test");
	private JLabel lblSelectTheTestArea = new JLabel("Select the test area");
	private JRadioButton rdoChrome = new JRadioButton("chrome");
	private JRadioButton rdoEnv1 = new JRadioButton("environment 1");
	private JRadioButton rdoEnv2 = new JRadioButton("environment 2");
	private JRadioButton rdoEnv3 = new JRadioButton("environment 3");
	private JRadioButton rdoEnv4 = new JRadioButton("environment 4");
	private JRadioButton rdoEnv5 = new JRadioButton("environment 5");
	private JRadioButton rdoEnv6 = new JRadioButton("environment 6");
	private JRadioButton rdoEnvTestValue = new JRadioButton("test value", true);
	private JRadioButton rdoFirefox = new JRadioButton("firefox");
	private JRadioButton rdoIE = new JRadioButton("internet explorer");
	private JRadioButton rdoInternal = new JRadioButton("internal");
	private JRadioButton rdoLocal = new JRadioButton("local");
	private JRadioButton rdoPublic = new JRadioButton("public");
	private JRadioButton rdoTestValue = new JRadioButton("value in test", true);
	private String mstrPath = "", mstrNameTest = "", mstrTestArea = "";
	private String[] arrDropEmpty = new String[0];
	private int intColumn1 = 12, intColumn2 = 245, intColumn3 = 465,
			intColumnWidth1 = 200, intColumnWidth2 = 200, intColumnWidth3 = 220;

	DialogLocal() {
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setSize(750, 500);
			Toolkit tk = Toolkit.getDefaultToolkit();
			java.awt.Dimension dim = tk.getScreenSize();
			int xPos = (dim.width / 2) - (this.getWidth() / 2);
			int yPos = (dim.height / 2) - (this.getHeight() / 2);
			this.setLocation(xPos, yPos);
			setAlwaysOnTop(true);
			setTitle("Dragonfly Local Test Runner");
			getContentPane().setLayout(null);
			//SelectTheTestArea Group radio buttons.
			lblSelectTheTestArea.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTestArea.setFont(fntDialog);
			lblSelectTheTestArea.setBounds(intColumn1, 15, intColumnWidth1, 35);
			getContentPane().add(lblSelectTheTestArea);
			rdoLocal.setFont(fntDialog);
			rdoLocal.setBounds(intColumn1, 45, intColumnWidth1, 25);
			rdoLocal.addActionListener(this);
			getContentPane().add(rdoLocal);
			rdoPublic.setFont(fntDialog);
			rdoPublic.setBounds(intColumn1, 70, intColumnWidth1, 25);
			rdoPublic.addActionListener(this);
			getContentPane().add(rdoPublic);
			rdoInternal.setFont(fntDialog);
			rdoInternal.setBounds(intColumn1, 95, intColumnWidth1, 25);
			rdoInternal.addActionListener(this);
			getContentPane().add(rdoInternal);
			grpTestArea.add(rdoLocal);
			grpTestArea.add(rdoPublic);
			grpTestArea.add(rdoInternal);
			//SelectTheBrowser Group radio buttons.
			lblSelectTheBrowser.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheBrowser.setFont(fntDialog);
			lblSelectTheBrowser.setBounds(intColumn2, 15, intColumnWidth2, 35);
			getContentPane().add(lblSelectTheBrowser);
			rdoTestValue.setFont(fntDialog);
			rdoTestValue.setBounds(intColumn2, 45, intColumnWidth2, 25);
			rdoTestValue.addActionListener(this);
			getContentPane().add(rdoTestValue);
			rdoIE.setFont(fntDialog);
			rdoIE.setBounds(intColumn2, 70, intColumnWidth2, 25);
			rdoIE.addActionListener(this);
			getContentPane().add(rdoIE);
			rdoChrome.setFont(fntDialog);
			rdoChrome.setBounds(intColumn2, 95, intColumnWidth2, 25);
			rdoChrome.addActionListener(this);
			getContentPane().add(rdoChrome);
			rdoFirefox.setFont(fntDialog);
			rdoFirefox.setBounds(intColumn2, 120, intColumnWidth2, 25);
			getContentPane().add(rdoFirefox);
			rdoFirefox.addActionListener(this);
			grpBrowser.add(rdoTestValue);
			grpBrowser.add(rdoIE);
			grpBrowser.add(rdoChrome);
			grpBrowser.add(rdoFirefox);
			//SelectTheEnvironment Group radio buttons.
			lblSelectTheEnvironment.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheEnvironment.setFont(fntDialog);
			lblSelectTheEnvironment.setBounds(intColumn3, 15, intColumnWidth3, 35);
			getContentPane().add(lblSelectTheEnvironment);
			rdoEnvTestValue.setFont(fntDialog);
			rdoEnvTestValue.setBounds(intColumn3, 45, intColumnWidth3, 25);
			rdoEnvTestValue.addActionListener(this);
			getContentPane().add(rdoEnvTestValue);
			rdoEnv1.setFont(fntDialog);
			rdoEnv1.setBounds(intColumn3, 70, intColumnWidth3, 25);
			rdoEnv1.addActionListener(this);
			getContentPane().add(rdoEnv1);
			rdoEnv2.setFont(fntDialog);
			rdoEnv2.setBounds(intColumn3, 95, intColumnWidth3, 25);
			rdoEnv2.addActionListener(this);
			getContentPane().add(rdoEnv2);
			rdoEnv3.setFont(fntDialog);
			rdoEnv3.setBounds(intColumn3, 120, intColumnWidth3, 25);
			rdoEnv3.addActionListener(this);
			getContentPane().add(rdoEnv3);
			rdoEnv4.setFont(fntDialog);
			rdoEnv4.setBounds(intColumn3, 145, intColumnWidth3, 25);
			rdoEnv4.addActionListener(this);
			getContentPane().add(rdoEnv4);
			rdoEnv5.setFont(fntDialog);
			rdoEnv5.setBounds(intColumn3, 170, intColumnWidth3, 25);
			rdoEnv5.addActionListener(this);
			getContentPane().add(rdoEnv5);
			rdoEnv6.setFont(fntDialog);
			rdoEnv6.setBounds(intColumn3, 195, intColumnWidth3, 25);
			rdoEnv6.addActionListener(this);
			getContentPane().add(rdoEnv6);
			grpEnvironment.add(rdoEnvTestValue);
			grpEnvironment.add(rdoEnv1);
			grpEnvironment.add(rdoEnv2);
			grpEnvironment.add(rdoEnv3);
			grpEnvironment.add(rdoEnv4);
			grpEnvironment.add(rdoEnv5);
			grpEnvironment.add(rdoEnv6);
			//lblSelectTheApplication
			lblSelectTheApplication.setFont(fntDialog);
			lblSelectTheApplication.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheApplication.setBounds(12, 141, 398, 35);
			getContentPane().add(lblSelectTheApplication);
			cboApplication.setFont(fntDialog);
			cboApplication.setToolTipText("Tip the tool");
			cboApplication.setBounds(12, 175, 410, 40);
			cboApplication.setEnabled(false);
			cboApplication.addActionListener(this);
			getContentPane().add(cboApplication);
			//lblSelectTheTest
			lblSelectTheTest.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTest.setFont(fntDialog);
			lblSelectTheTest.setBounds(12, 252, 398, 35);
			getContentPane().add(lblSelectTheTest);
			cboTest.setToolTipText("Tip the tool");
			cboTest.setFont(fntDialog);
			cboTest.setBounds(12, 283, 708, 40);
			cboTest.setEnabled(false);
			cboTest.addActionListener(this);
			getContentPane().add(cboTest);
			btnRun.setFont(fntDialog);
			btnRun.setBounds(12, 373, 310, 55);
			btnRun.setEnabled(false);
			btnRun.addActionListener(this);
			getContentPane().add(btnRun);
			btnCancel.setFont(fntDialog);
			btnCancel.setBounds(410, 373, 310, 55);
			btnCancel.addActionListener(this);
			getContentPane().add(btnCancel);
			gstrBrowserSelection = "value in test";
			//mstrTestEnvironment = "test value";
			gstrEnvironment = "test value";
			this.setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent objActionEvent) {
		ButtonGroup grpSelectedGroup = null;
		JRadioButton objJRadioButton = null;
		String strRadioButtonText = "";
		Object objObject = objActionEvent.getSource();
		if (objObject instanceof JRadioButton) {
			objJRadioButton = (JRadioButton) objObject;
			grpSelectedGroup = ((DefaultButtonModel) objJRadioButton.getModel()).getGroup();
			strRadioButtonText = objJRadioButton.getText();
			if (grpSelectedGroup.equals(grpTestArea)) {
				this.mstrTestArea = strRadioButtonText;
				Paths.getInstance().testArea = strRadioButtonText;
				Paths.getInstance().setDirectory(strRadioButtonText);
				Logger.getInstance().add("data_EnvironmentURL: Paths.getInstance().pathTestData = " + Paths.getInstance().pathTestData);
				mstrPath = (Paths.getInstance().pathSystemUserDir + "/" + Paths.getInstance().pathTestConfiguration).replaceAll("\\\\", "/");
				Logger.getInstance().add("DialogLaunch:actionPerformed mstrPath = " + mstrPath);
				this.getApplications();
			} else if (grpSelectedGroup.equals(grpBrowser)) {
				gstrBrowserSelection = strRadioButtonText;
			} else if (grpSelectedGroup.equals(grpEnvironment)) {
				Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + gstrEnvironment);
				gstrEnvironment = strRadioButtonText;
				Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + gstrEnvironment);
			}
		}
		if (objActionEvent.getSource() == cboApplication) {
			this.getTests();
		}
		if (objActionEvent.getSource() == cboTest) {
			btnRun.setEnabled(true);
		}
		if (objActionEvent.getSource() == btnRun) {
			Paths.getInstance().nameTest = (String) cboTest.getSelectedItem();
			if (!gstrEnvironment.equals("test value")) {
				Logger.getInstance().add("DialogLaunch:actionPerformed Paths.getInstance().pathTestData = " + Paths.getInstance().pathTestData);
				String strFilePathTestData = Paths.getInstance().pathTestData + "Environments.json";
				Logger.getInstance().add("DialogLaunch:actionPerformed strFilePathTestData = " + strFilePathTestData);
				try {
					JSON objJsonObjectFile = new JSON();
					objJsonObjectFile.replaceAllFromFile(strFilePathTestData);
					Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + gstrEnvironment);
					gstrEnvironment = objJsonObjectFile.getString(gstrEnvironment);
					Logger.getInstance().add("DialogLaunch:actionPerformed gstrEnvironment = " + gstrEnvironment);
				} catch (Exception e) {
					Logger.getInstance().add("DialogLaunch:actionPerformed Exception = " + e.toString());
				}
			}
			dispose();
			return;
		}
		if (objActionEvent.getSource() == btnCancel) {
			dispose();
			return;
		}
	}

	private void getApplications() {
		String[] arrDrop = null;
		HashSet<String> hs = new HashSet<String>();
		File dir = new File(mstrPath);
		objFilter = new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				if (name.endsWith(".json")) {
					return true;
				} else {
					return false;
				}
			}
		};
		File[] files = dir.listFiles(objFilter);
		cboApplication.setEnabled(true);
		if (files.length == 0) {
			System.out.println("The directory is empty");
			cboApplication.setModel(new DefaultComboBoxModel<String>(arrDrop));
		} else {
			for (File aFile : files) {
				String strKeyword = "";
				int intRightArrowPosition = aFile.getName().indexOf("_");
				if (intRightArrowPosition > -1) {
					strKeyword = aFile.getName().substring(0, intRightArrowPosition);
				}
				if (hs.contains(strKeyword) == false) {
					hs.add(strKeyword);
				}
			}
			arrDrop = hs.toArray(new String[0]);
			Arrays.sort(arrDrop);
			cboApplication.removeActionListener(this);
			cboApplication.setModel(new DefaultComboBoxModel<String>(arrDrop));
			cboApplication.setSelectedItem(null);
			cboApplication.addActionListener(this);
		}
		cboTest.setModel(new DefaultComboBoxModel<String>(arrDropEmpty));
		cboTest.setEnabled(false);
	}

	private void getTests() {
		int intCount = 0;
		File dir = new File(mstrPath);
		objFilter = new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				if (name.startsWith((String) cboApplication.getSelectedItem())) {
					return true;
				} else {
					return false;
				}
			}
		};
		File[] files = dir.listFiles(objFilter);
		String[] arrDrop = new String[files.length];
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
			for (File aFile : files) {
				arrDrop[intCount] = aFile.getName();
				intCount++;
			}
			Arrays.sort(arrDrop);
		}
		cboTest.setModel(new DefaultComboBoxModel<String>(arrDrop));
		cboTest.setSelectedItem(null);
		cboTest.setEnabled(true);
	}
}
