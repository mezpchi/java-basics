package model;

public class Account {
	private int id;
	private double balance;
	private String firstname;
	private String lastname;
	private String password;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int acctID, double balance, String firstname, String lastname, String password) {
		super();
		this.id = acctID;
		this.balance = balance;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAcctID() {
		return id;
	}

	public void setAcctID(int acctID) {
		this.id = acctID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "Account [acctID=" + id + "balance=" + "balance]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;

		return false;
	}

	public Account(String firstname, String lastname, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;

	}

	public Account(int acctID, double balance) {
		super();
		this.id = acctID;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
