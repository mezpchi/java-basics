package com.training.bms.model;
import java.util.List;
import com.training.bms.model.AccountDao;
import com.training.bms.model.AccountDaoImpl;
import com.training.bms.model.UserDao;
import com.training.bms.model.UserDaoImpl;

public class User {
 public static final boolean admin = false;
public static final String name = null;
	public int id;
	public String firstName;
	public String lastName;
	public String password;
	public boolean approved;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password =" + password + "]";
	}
	public boolean validateIdentity(String firstName, String password) {
		UserDao cdi = new UserDaoImpl();
		boolean isFirstNameFound = false;
		List<User> allUsers = cdi.getUsers();
		for (User c: allUsers) {
			if(c.getFirstName().equals(firstName) && c.getPassword().equals(password)) {
				return true;
			}
		}
return isFirstNameFound;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	public static boolean isAdmin() {
		return admin;
	}
}

