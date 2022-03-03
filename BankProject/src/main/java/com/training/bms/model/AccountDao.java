package com.training.bms.model;
import java.util.List;

import model.Account;

public interface AccountDao{

	public interface AccountDAO {
		public List<Account> getAccounts();
		public Account getAccountById(int id);
		public Account getAccountByCustomerId(int id);
		public int createAccount(Account account);
		public int updateAccount(Account account);
		public int deleteAccountById(int id);
		public void deposit(int accountId, double amount);
		public void withdraw(int accountId, double amount);
		public void getFirstname(String firstname);
	}
}
