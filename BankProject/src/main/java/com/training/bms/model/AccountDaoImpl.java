package com.training.bms.model;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.bms.utility.DBConnection;

import model.Account;
public class AccountDaoImpl {

	Connection connection = DBConnection.getConnection();

	public Account createAcct(Account acct) {
		String query = "INSERT INTO accounts  VALUES (default,?, ? , ?,?)";

		try {
			PreparedStatement s2 = connection.prepareStatement(query);
			s2.setString(1, acct.getFirstname());
			s2.setString(2, acct.getLastname());
			s2.setString(3, acct.getPassword());
			s2.executeUpdate();
			s2.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return acct;
	}
	public void depositTo(int id, double amt) {

		String query = "UPDATE accounts SET balence = balence + ? WHERE id = ?";

		try {
			PreparedStatement s = connection.prepareStatement(query);
			s.setDouble(1, amt);
			s.setInt(2, id);
			s.executeUpdate();
			s.close();

		}catch(SQLException e) {
			System.out.println("ERROR: Account number not found.");
		}
		System.out.println(" DEPOSIT SUCCESSFUL!");
	}

	public void withdrawFrom(int id, double amt) {

		String query = "UPDATE account_table SET balence = balence - ? WHERE id = ?";

		try {
			PreparedStatement s = connection.prepareStatement(query);
			s.setDouble(1, amt);
			s.setInt(2, id);
			s.executeUpdate();
			s.close();

		}catch(SQLException e) {
			System.out.println(" ERROR: Account number not found.");
		}
		System.out.println(" WITHDRAW SUCCESSFUL!");
	}

	public void transferMoney(int idFrom, int idTo, double amt) {

		String query = "UPDATE accounts SET balence = balence - ? WHERE id = ?";
		String query2 = "UPDATE accounts SET balence = balence + ? WHERE id = ?";

		try {
			PreparedStatement s = connection.prepareStatement(query);
			s.setDouble(1, amt);
			s.setInt(2, idFrom);
			s.executeUpdate();
			s.close();

			PreparedStatement s2 = connection.prepareStatement(query2);
			s2.setDouble(1, amt);
			s2.setInt(2, idTo);
			s2.executeUpdate();
			s2.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}

		System.out.println(" TRANSFER SUCCESSFUL!");
	}

	public void deleteAccount(int id, String firstname) {

		String query = "DELETE FROM accounts WHERE accounts = ? AND users = ?";
		String query2 = "DELETE FROM accounts WHERE id = ?";

		try {
			PreparedStatement s = connection.prepareStatement(query);
			s.setInt(1, id);
			s.setInt(2, id);
			s.executeUpdate();

			PreparedStatement s2 = connection.prepareStatement(query2);
			s2.setInt(1, id);
			s2.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteAccount(int id, int userId) {
		// TODO Auto-generated method stub
		
	}
} 
