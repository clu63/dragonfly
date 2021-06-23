package org.DragonflyAutomation;

import java.io.FileReader;
import java.util.List;
import javax.swing.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class DialogJtableDemo {
	public static void main(String[] args) throws Exception {
		String jsonFile = "[" + "{ \"firstName\": \"Stack\", \"lastName\": \"Overflow\" }," + "{ \"firstName\": \"Pee\", \"lastName\": \"Skillet\" }" + "]";
		//			String filePath = "C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_data\\td_test.json";
		//			FileReader jsonFile = new FileReader(filePath);
		//			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//			TestData testData = gson.fromJson(jsonFile, TestData.class);
		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//TestData testData = gson.fromJson(jsonFile, TestData.class);
		//List<User> users = gson.fromJson(jsonFile, User.class);
		
		
		TypeToken<List<User>> token = new TypeToken<List<User>>() {};
		List<User> users = gson.fromJson(jsonFile, token.getType());
		
		
		
		//User[] users = gson.fromJson(jsonFile, User[].class);
		System.out.println(gson.toJson(users));
		//		ObjectMapper mapper = new ObjectMapper();
		//		List<User> users = mapper.readValue(jsonUsers, TypeFactory.defaultInstance().constructCollectionType(List.class, User.class));
		DialogJtableDemo dialogJtableDemo = new DialogJtableDemo();
		UserTableModel model = dialogJtableDemo.new UserTableModel(users);
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JOptionPane.showMessageDialog(null, new JScrollPane(table));
	}

	public class User {
		private String firstName;
		private String lastName;

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}

	public class UserTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private List<User> userData = new ArrayList<User>();
		private String[] columnNames = { "First Name", "Last Name" };

		public UserTableModel() {
		}

		public UserTableModel(List<User> userData) {
			this.userData = userData;
		}

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return userData.size();
		}

		@Override
		public Object getValueAt(int row, int column) {
			Object userAttribute = null;
			User userObject = userData.get(row);
			switch (column) {
			case 0:
				userAttribute = userObject.getFirstName();
				break;
			case 1:
				userAttribute = userObject.getLastName();
				break;
			default:
				break;
			}
			return userAttribute;
		}

		public void addUser(User user) {
			userData.add(user);
			fireTableDataChanged();
		}
	}
}
