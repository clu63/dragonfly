package org.DragonflyAutomation;

import com.google.gson.Gson;

public class GsonArrayRoot {
	public static void main(String[] args) {
		Logger.getInstance().add("GsonArrayRoot");
		Integer i;
		String userJson = "[{'name': 'Alex','id': 1}, {'name': 'Brian','id':2}, {'name': 'Charles','id': 3}]";
		String userJson2 = "[{'name': 'Alexa','id': 4}, {'name': 'Briana','id':5}, {'name': 'Charlesa','id': 6}]";
		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		String userJsonCombine = mergeJson(userJson, userJson2);
		User[] userArray = gson.fromJson(userJsonCombine, User[].class);
		System.out.println(gson.toJson(userArray));
		for (User user : userArray) {
			user.setId(user.getId() + 1);
			user.setEmail("test@test.com");
			//user.setName("test");
			user.setLongNum(2147483647);
			user.setIsBoolean(false);
			System.out.println(user);
		}
		System.out.println(gson.toJson(userArray));
		System.out.println("");
		System.out.println(gson.toJson(userArray[3]));
		findTheName("Alexa", userArray);
	}

	private static String mergeJson(String userJson, String userJson2) {
		Logger.getInstance().add("Merge the json string.");
		return userJson.replace("]", "") + "," + userJson2.replace("[", "");
	}

	private static void findTheName(String name, User[] userArray) {
		int start = 0;
		int size = userArray.length;
		int each = 0;
		for (each = start; each < size; each++) {
			if (userArray[each].getName() == name) {
				System.out.println(new Gson().newBuilder().setPrettyPrinting().serializeNulls().create().toJson(userArray[each]));
			}
		}
	}

	class User {
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