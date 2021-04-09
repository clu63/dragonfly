package org.DragonflyAutomation;

import java.util.Arrays;
import org.DragonflyAutomation.GsonArrayRoot.User;
import com.google.gson.Gson;

public class GsonArrayMember {
	public static void main(String[] args) {
		String departmentJson = "{'id' : 1, " + "'name': 'HR'," + "'users' : [" + "{'name': 'Alex','id': 1}, " + "{'name': 'Brian','id':2}, " + "{'name': 'Charles','id': 3}]}";
		//String departmentJson = "{'id' : 1, 'name': 'HR' }";
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		Department department = gson.fromJson(departmentJson, Department.class);
		//department = gson.fromJson(departmentJson, Department.class);
		System.out.println(gson.toJson(department));
		System.out.println(department);
	}

	public class Department {
		private long id;
		private String name;
		private User[] users;

		// Getters and Setters
		@Override
		public String toString() {
			return "Department [id=" + id + ", name=" + name + ", users=" + Arrays.toString(users) + "]";
		}
	}
}
