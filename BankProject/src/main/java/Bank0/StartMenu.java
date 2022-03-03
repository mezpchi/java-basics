package Bank0;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bms.utility.AccountServices;
import com.bms.utility.InputUtil;
import com.bms.utility.UserServices;
import com.training.bms.model.AccountDao;
import com.training.bms.model.AccountDaoImpl;
import com.training.bms.model.User;
import com.training.bms.model.UserDao;
import com.training.bms.model.UserDaoImpl;

import model.Account;

public class StartMenu {
	private static final UserDao UserDao = null;
	static Scanner scanner = new Scanner(System.in);
	Account account = new Account();
	int choice = 0;
	static String option = null;
	AccountDaoImpl accountDao = new AccountDaoImpl();
	public String password1;
	public static UserServices userService = new UserServices();
	private static User u = null;

	public void startStartmenu() throws IOException {
		String firstname = null;
		String lastname = null;
		String password = null;
		String name = null;
		loop: while (true) {
			System.out.println("  Welcome please select an option below ");
			System.out.println("  1. OPEN NEW USER ACCOUNT ");
			System.out.println("  2. CREATE NEW ADMIN ACCOUNT");
			System.out.println("  3. LOGIN TO EXISTING ACCOUNT ");
			System.out.println("  4. EXIT BANKING APPLICATION ");
			System.out.println("Please enter your choice : ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				UserServices.createUser();				
break;

			case 2:
				UserServices.setUser(null);
				break;

			case 3:
				userService.userLogin();
				break;

			case 4:
				System.out.println("Thanks for Banking with us today!");
				break loop;
			}
			if (u != null) {
				loggedIn();
			}
		}
		scanner.close();
	}

	private void login() {
		// TODO Auto-generated method stub
		
	}

	public static void loggedIn() {
		if (!u.approved) {
			System.out.println(User.name + "are not approved by admins. Logging out...\n");
			u = null;
			return;
		}
		while (true) {
			System.out.println("1. Open and View Account");

			System.out.println("2. DEPOSIT MONEY ");

			System.out.println("3. WITHDRAW MONEY  ");

			System.out.println("4. TRANSFER MONEY ");
			if (User.isAdmin()) {
				System.out.println("5 to approve users");
			}
			System.out.println("0 to log out of Account");
			System.out.println("Enter choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();
			if (!User.admin && choice > 2) {
				System.out.println("Invalid Option for a user. Try again");
				continue;
			}
			switch (choice) {

			case 0:
				System.out.println(User.name + "logging out...");
				u = null;
				return;
			case 1:
				OpenNewAccount();
				break;
			case 2:
				AccountServices.deposit();
				break;
			case 3:
				AccountServices.withdraw();
				break;
			case 4:
				AccountServices.transfer();
			}
		}
	}

	private void CreateNewAdmin() {
		// TODO Auto-generated method stub
		
	}

	private static void OpenNewAccount() {
		// TODO Auto-generated method stub

	}

	public static void createAccount() {
		System.out.println("Create a user account");
		createUser(false);
		System.out.println("User account created, " + ( u.getFirstName()));
	}

	public static void createAdmin() {
		System.out.println("Create an admin account");
		createUser(true);
		System.out.println("Admin account created, " + User.name);
	}

	public static void createUser(boolean admin) {
		String name = null;
		while (true) {
			System.out.println("Enter your first name: ");
			name = scanner.nextLine();
			
		System.out.println("Enter a password: ");
		String password = scanner.nextLine();

		u = new User(); // logs in
		String inserted = null;
		try {
			inserted = UserDao.updateUser(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (inserted != null) {
	System.out.println("New User Account Has been updated.");
	}
	AccountServices.deposit();
	}
	}
	// @Override
	protected void finalize() throws Throwable {
		super.finalize();

	}

	private static void approveUsers() {
		// TODO Auto-generated method stub
		
	}
}
