package com.bms.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.training.bms.utility.DBConnection;

public class CallingAProcedure {
	static Connection connection;
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the account number to debit the amount :");
		int sender = scanner.nextInt();
		
		System.out.println("Enter the account number to credit the amount :");
		int reciever = scanner.nextInt();
		
		System.out.println("Enter the amount to be transferred :");
		int amount = scanner.nextInt();
		
		Connection connection = DBConnection.getConnection();
		CallableStatement stat = connection.prepareCall("call transfer(?,?,?)");
		stat.setInt(1, sender);
		stat.setInt(2, reciever);
		stat.setInt(3, amount);
		
		stat.execute();
		
		System.out.println("Transfer done/completed");
	}

}