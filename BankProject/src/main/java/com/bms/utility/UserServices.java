package com.bms.utility;

import com.training.bms.model.UserDaoImpl;
import com.training.bms.model.User;

public class UserServices {
	public static User user = new User();
	private static UserDaoImpl userDao = new UserDaoImpl();
	public static boolean newUser = false;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		UserServices.user = user;
	}

	public  int getUserId() {
		return user.getId();
	}

	public void setUserId(int id) {
		id = user.getId();
	}

	public static String getUserFirstName() {
		return user.getFirstName();
	}

	public void setUserFirstName(String firstName) {
		firstName = user.getFirstName();
	}

	public String getUserLastName() {
		return user.getLastName();
	}

	public void setUserLastName(String lastName) {
		lastName = user.getLastName();
	}

	public String getUserPass_hash(String pass_hash) {
		return user.getPassword();
	}

	public void setPass_hash(String pass_hash) {
		pass_hash = user.getPassword();
	}

	public static void createUser() {
		System.out.print("         Please enter your first name: ");
		user.setFirstName(InputUtil.getStringInput(30));

		System.out.print("         Please enter your last name: ");
		user.setLastName(InputUtil.getStringInput(30));

		System.out.print("         Please enter your password: ");
		user.setPassword((InputUtil.getStringInput(30)));

		user = userDao.insertUser(user);
		newUser = true;
	}

	public void userLogin() {
		System.out.print("  Please enter your password: ");
		String pw = InputUtil.getStringInput(30);

		user = userDao.checkUser(user, pw);
		System.out.println();
		System.out.println("         Logging into your account . . .");
	}

	public void displayAccts() {  userDao.getUserAccounts(user);  }
}
