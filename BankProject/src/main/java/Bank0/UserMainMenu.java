package Bank0;

import java.io.IOException;

import com.bms.utility.AccountServices;
import com.bms.utility.InputUtil;
import com.bms.utility.UserServices;

public class UserMainMenu extends Menu {

	public int inputValue;
	private static UserServices userService = new UserServices();
	private static AccountServices acctService = new AccountServices();


	public static void showMenu() {
		System.out.println(" Welcome " + UserServices.getUserFirstName());
		System.out.println("1. Open Account");
		System.out.println("2. DEPOSIT MONEY ");
		System.out.println("3. WITHDRAW MONEY  ");
		System.out.println("4. TRANSFER MONEY ");			
		System.out.println("5. CLOSE ACCOUNT" );
		System.out.println("6. LOGOUT");
	}

	
	public Menu process() {
		switch(this.inputValue) {
			case 1: acctService.openAccount();break;
			case 2: acctService.deposit(); break;
			case 3: acctService.withdraw(); break;
			case 4: acctService.transfer(); break;			
			case 5: acctService.deleteAcct(); break;
			case 6: return null;
		}
		return this;
	}

	
	public void getUserInput() {
		inputValue = InputUtil.getIntChoice(8);
	}

	public static UserServices getUserService() {
		return userService;
	}

	public static void setUserService(UserServices userService) {
		UserMainMenu.userService = userService;
	}

	
	}
