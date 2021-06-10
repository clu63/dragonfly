package org.DragonflyAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.DragonflyAutomation.GsonArrayRoot.User;
import com.google.gson.Gson;

public class GsonArrayMember {
	public static void main(String[] args) {
		String departmentJson = "{'id' : 1, " + "'name': 'HR'," + "'users' : [" + "{'name': 'Alex','id': 1}, " + "{'name': 'Brian','id':2}, " + "{'name': 'Charles','id': 3}]}";
		//String departmentJson = "{'id' : 1, 'name': 'HR' }";
		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		Department department = gson.fromJson(departmentJson, Department.class);
		//department = gson.fromJson(departmentJson, Department.class);
		System.out.println(departmentJson);
		System.out.println(gson.toJson(department));
	}

	public class Department {
		private long id;
		private String name;
		//private User2[] users;
		private List<Department.User2> users = new ArrayList<Department.User2>();

		// Getters and Setters
//		@Override
//		public String toString() {
//			return "Department [id=" + id + ", name=" + name + ", users=" + Arrays.toString(User2) + "]";
//		}

		class User2 {
			private Integer id;
			private String name;
			private String email;
			private Boolean isBoolean;
			private Integer longNum;

			public Boolean getIsBoolean() {
				return isBoolean;
			}

			public Integer getLongNum() {
				return longNum;
			}

			public void setLongNum(Integer longNum) {
				this.longNum = longNum;
			}

			public void setIsBoolean(Boolean isBoolean) {
				this.isBoolean = isBoolean;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			@Override
			public String toString() {
				return "User [id=" + id + ", name = " + name + "]";
			}
		}
	}
}
