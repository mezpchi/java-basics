package com.bms.utility;

import com.training.bms.model.AccountDaoImpl;

import model.Account;

public class AccountServices {
	public static Account acct = new Account();
	private static AccountDaoImpl acctDao = new AccountDaoImpl();
	private static UserServices userService = new UserServices();

	public static Account getAccount() {
		return acct;
	}

	public static void setAccount(Account acct) {
		AccountServices.acct = acct;
	}

	public int getAcctId() {
		return acct.getAcctID();
	}

	public void setAcctId(int id) {
		id = acct.getAcctID();
	}

	public double getBalance() {
		return acct.getBalance();
	}

	public void setBalance(double balance) {
		balance = acct.getBalance();
	}

	public static void openAccount() {
		acct.setBalance(0.00);
		
		// Create account in DB and add returned id(unique account number) to user accounts array
		acct = acctDao.createAcct(acct);
		UserServices.newUser = false;
	}

	public static void deposit() {
		System.out.print("  Select account to deposit into: "); 
		int acct_id = InputUtil.getIntChoice(100);

		System.out.print(" Enter amount to be deposited: ");
		double amt = InputUtil.getDoubleInput(100_000);

		acctDao.depositTo(acct_id, amt);
	}

	public static void withdraw() {
		System.out.print("  Select account to withdraw from: "); // id for account
		int acct_id = InputUtil.getIntChoice(100);

		System.out.print("  Enter amount to be withdrawn: ");
		double amt = InputUtil.getDoubleInput(100_000);

		acctDao.withdrawFrom(acct_id, amt);
	}

	public static void transfer() {
		System.out.print(" Select account to transfer from: "); // id for account
		int acct_idFrom = InputUtil.getIntChoice(100);

		System.out.print(" Select account to transfer to: "); // id for account
		int acct_idTo = InputUtil.getIntChoice(100);

		System.out.print(" Enter amount to be transferred: ");
		double amt = InputUtil.getDoubleInput(100_000);

		acctDao.transferMoney(acct_idFrom, acct_idTo, amt);
	}

	public static void deleteAcct() {
		System.out.print("   Select account to delete: "); // id for account
		int id = InputUtil.getIntChoice(100);
		acctDao.deleteAccount(id, userService.getUserId());
	}

	}
