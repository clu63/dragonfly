package org.DragonflyAutomation;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class DragonflyLaunch {
//	public static void main(String[] args) {
//		try {
//			DragonflyLaunch objDragonflyLaunch = new DragonflyLaunch();
//			DragonflyLaunchDialog dialog = objDragonflyLaunch.new DragonflyLaunchDialog();
//			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public class DragonflyLaunchDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		JRadioButton rdbtnLocal = new JRadioButton("local");
		JRadioButton rdbtnPublic = new JRadioButton("public");
		JRadioButton rdbtnInternal = new JRadioButton("internal");
		JComboBox<String> comboApplication = new JComboBox<String>();
		JComboBox<String> comboTest = new JComboBox<String>();
		JButton btnRun = new JButton("Run");
		JButton btnCancel = new JButton("Cancel");
		FilenameFilter objFilter;
		String dirPath = "";
		String[] arrDropEmpty = new String[0];

		public DragonflyLaunchDialog() {
			//JFrame f = new JFrame();
			//f.setSize(new Dimension(750, 500));
			//JPanel p = new JPanel();
			//p.setLayout(new FlowLayout());
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setSize(750, 500);
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			int xPos = (dim.width / 2) - (this.getWidth() / 2);
			int yPos = (dim.height / 2) - (this.getHeight() / 2);
			this.setLocation(xPos, yPos);
			setAlwaysOnTop(true);
			setTitle("Dragonfly Local Test Runner");
			getContentPane().setLayout(null);
			JLabel lblSelectTheTestArea = new JLabel("Select the test area");
			lblSelectTheTestArea.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTestArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheTestArea.setBounds(12, 15, 398, 35);
			getContentPane().add(lblSelectTheTestArea);
			rdbtnLocal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnLocal.setBounds(12, 45, 127, 25);
			getContentPane().add(rdbtnLocal);
			rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnPublic.setBounds(12, 70, 127, 25);
			getContentPane().add(rdbtnPublic);
			rdbtnInternal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			rdbtnInternal.setBounds(12, 95, 127, 25);
			getContentPane().add(rdbtnInternal);
			//Group the radio buttons.
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnLocal);
			group.add(rdbtnPublic);
			group.add(rdbtnInternal);
			//Register a listener for the radio buttons.
			rdbtnLocal.addActionListener(this);
			rdbtnPublic.addActionListener(this);
			rdbtnInternal.addActionListener(this);
			JLabel lblSelectTheApplication = new JLabel("Select the application");
			lblSelectTheApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheApplication.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheApplication.setBounds(12, 141, 398, 35);
			getContentPane().add(lblSelectTheApplication);
			comboApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
			comboApplication.setToolTipText("Tip the tool");
			comboApplication.setBounds(12, 175, 410, 40);
			comboApplication.setEnabled(false);
			getContentPane().add(comboApplication);
			comboApplication.addActionListener(this);
			JLabel lblSelectTheTest = new JLabel("Select the test");
			lblSelectTheTest.setHorizontalAlignment(SwingConstants.LEFT);
			lblSelectTheTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSelectTheTest.setBounds(12, 252, 398, 35);
			getContentPane().add(lblSelectTheTest);
			comboTest.setToolTipText("Tip the tool");
			comboTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
			comboTest.setBounds(12, 283, 708, 40);
			comboTest.setEnabled(false);
			getContentPane().add(comboTest);
			comboTest.addActionListener(this);
			btnRun.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnRun.setBounds(12, 373, 310, 55);
			btnRun.setEnabled(false);
			getContentPane().add(btnRun);
			btnRun.addActionListener(this);
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancel.setBounds(410, 373, 310, 55);
			getContentPane().add(btnCancel);
			btnCancel.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rdbtnLocal) {
				dirPath = "C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Data/local/test_configuration";
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
				comboApplication.setEnabled(true);
				comboApplication.setModel(new DefaultComboBoxModel<String>(this.getApplications()));
				comboTest.setModel(new DefaultComboBoxModel<String>(arrDropEmpty));
				comboTest.setEnabled(false);
			}
			if (e.getSource() == rdbtnPublic) {
				dirPath = "C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Data/public/test_configuration";
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
				comboApplication.setEnabled(true);
				comboApplication.setModel(new DefaultComboBoxModel<String>(this.getApplications()));
				comboTest.setModel(new DefaultComboBoxModel<String>(arrDropEmpty));
				comboTest.setEnabled(false);
			}
			if (e.getSource() == rdbtnInternal) {
				dirPath = "C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Data/internal/test_configuration";
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
				comboApplication.setEnabled(true);
				comboApplication.setModel(new DefaultComboBoxModel<String>(this.getApplications()));
				comboTest.setModel(new DefaultComboBoxModel<String>(arrDropEmpty));
				comboTest.setEnabled(false);
			}
			if (e.getSource() == comboApplication) {
				System.out.println(comboApplication.getSelectedItem());
				objFilter = new FilenameFilter() {
					@Override
					public boolean accept(File file, String name) {
						if (name.startsWith((String) comboApplication.getSelectedItem())) {
							return true;
						} else {
							return false;
						}
					}
				};
				comboTest.setModel(new DefaultComboBoxModel<String>(this.getTests()));
				comboTest.setEnabled(true);
				;
			}
			if (e.getSource() == comboTest) {
				System.out.println("comboTest");
				btnRun.setEnabled(true);
			}
			if (e.getSource() == btnRun) {
				System.out.println(comboTest.getSelectedItem());
				dispose();
				return;
			}
			if (e.getSource() == btnCancel) {
				dispose();
				return;
			}
		}

		public String[] getApplications() {
			String[] arrDrop = null;
			HashSet<String> hs = new HashSet<String>();
			File dir = new File(dirPath);
			File[] files = dir.listFiles(objFilter);
			if (files.length == 0) {
				System.out.println("The directory is empty");
			} else {
				for (File aFile : files) {
					System.out.println(aFile.getName());
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
			}
			System.out.println(hs);
			return arrDrop;
		}

		public String[] getTests() {
			int intCount = 0;
			File dir = new File(dirPath);
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
			return arrDrop;
		}
	}
}
//		
//		
//		
//		
//		
//		
//public class DragonflyLaunch extends JDialog implements ActionListener {
//	public static void main(String[] args) {
//		try {
//			DragonflyLaunch dialog = new DragonflyLaunch();
//			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public DragonflyLaunch() {
//		FilenameFilter objFilter = new FilenameFilter() {
//			public boolean accept(File file, String name) {
//				if (name.endsWith(".json")) {
//					//if (name.startsWith("lilo")) {
//					// filters files whose extension is .mp3
//					return true;
//				} else {
//					return false;
//				}
//			}
//		};
//		HashSet<String> hs = new HashSet<String>();
//		String[] arrDrop = null;
//		String dirPath = "C:/Users/perrj115/Documents/GitHub/dragonfly/Dragonfly/Data/internal/test_configuration";
//		File dir = new File(dirPath);
//		File[] files = dir.listFiles(objFilter);
//		if (files.length == 0) {
//			System.out.println("The directory is empty");
//		} else {
//			for (File aFile : files) {
//				System.out.println(aFile.getName());
//				String strKeyword = "";
//				int intRightArrowPosition = aFile.getName().indexOf("_");
//				if (intRightArrowPosition > -1) {
//					strKeyword = aFile.getName().substring(0, intRightArrowPosition);
//				}
//				if (hs.contains(strKeyword) == false) {
//					hs.add(strKeyword);
//				}
//			}
//			arrDrop = hs.toArray(new String[0]);
//			Arrays.sort(arrDrop);
//		}
//		System.out.println(hs);
//		this.setSize(750, 500);
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		Dimension dim = tk.getScreenSize();
//		int xPos = (dim.width / 2) - (this.getWidth() / 2);
//		int yPos = (dim.height / 2) - (this.getHeight() / 2);
//		this.setLocation(xPos, yPos);
//		setAlwaysOnTop(true);
//		setTitle("Dragonfly Local Test Runner");
//		getContentPane().setLayout(null);
//		JLabel lblSelectTheApplication = new JLabel("Select the application");
//		lblSelectTheApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblSelectTheApplication.setHorizontalAlignment(SwingConstants.LEFT);
//		lblSelectTheApplication.setBounds(12, 127, 398, 35);
//		getContentPane().add(lblSelectTheApplication);
//		JComboBox comboApplication = new JComboBox();
//		comboApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		comboApplication.setModel(new DefaultComboBoxModel(arrDrop));
//		comboApplication.setToolTipText("Tip the tool");
//		comboApplication.setBounds(12, 161, 410, 40);
//		getContentPane().add(comboApplication);
//		JButton btnRun = new JButton("OK");
//		btnRun.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnRun.setBounds(12, 373, 310, 55);
//		getContentPane().add(btnRun);
//		JButton btnCancel = new JButton("Cancel");
//		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnCancel.setBounds(410, 373, 310, 55);
//		getContentPane().add(btnCancel);
//		JRadioButton rdbtnLocal = new JRadioButton("local");
//		rdbtnLocal.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		rdbtnLocal.setBounds(8, 61, 127, 25);
//		getContentPane().add(rdbtnLocal);
//		JRadioButton rdbtnPublic = new JRadioButton("public");
//		rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		rdbtnPublic.setBounds(270, 61, 127, 25);
//		getContentPane().add(rdbtnPublic);
//		JRadioButton rdbtnInternal = new JRadioButton("internal");
//		rdbtnInternal.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		rdbtnInternal.setBounds(502, 61, 127, 25);
//		getContentPane().add(rdbtnInternal);
//		//Group the radio buttons.
//		ButtonGroup group = new ButtonGroup();
//		group.add(rdbtnLocal);
//		group.add(rdbtnPublic);
//		group.add(rdbtnInternal);
//		//Register a listener for the radio buttons.
//		rdbtnLocal.addActionListener(this);
//		rdbtnPublic.addActionListener(this);
//		rdbtnInternal.addActionListener(this);
//		JLabel lblSelectTheTest = new JLabel("Select the test");
//		lblSelectTheTest.setHorizontalAlignment(SwingConstants.LEFT);
//		lblSelectTheTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblSelectTheTest.setBounds(12, 252, 398, 35);
//		getContentPane().add(lblSelectTheTest);
//		JComboBox comboTest = new JComboBox();
//		comboTest.setToolTipText("Tip the tool");
//		comboTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		comboTest.setBounds(12, 283, 708, 40);
//		getContentPane().add(comboTest);
//		JLabel lblSelectTheTestArea = new JLabel("Select the test area");
//		lblSelectTheTestArea.setHorizontalAlignment(SwingConstants.LEFT);
//		lblSelectTheTestArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblSelectTheTestArea.setBounds(12, 17, 398, 35);
//		getContentPane().add(lblSelectTheTestArea);
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == rdbtnLocal) {
//			System.out.println("Listen " + e.toString());
//			System.out.println("Listen " + e.getSource());
//		}
//	}
//}
