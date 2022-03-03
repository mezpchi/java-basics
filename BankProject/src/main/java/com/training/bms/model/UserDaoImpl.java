package com.training.bms.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import com.training.bms.model.User;
import com.training.bms.utility.DBConnection;
public class UserDaoImpl implements UserDao {
	 static Connection connection = DBConnection.getConnection();

	public User insertUser(User user) {
			connect();

			String query = "INSERT INTO user_table (first_name, last_name, password) " +
					"VALUES (?, ?, ?) RETURNING id";

			try {
				PreparedStatement s = connection.prepareStatement(query);

				s.setString(1, user.getFirstName());
				s.setString(2, user.getLastName());
				s.setString(3, user.getPassword());
				ResultSet resultSet = s.executeQuery();

				if (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}

			return user;
	}
	private void connect() {
		// TODO Auto-generated method stub
		
	}

	public User getUserAccounts(User user) {
		connect();

		String query = "SELECT * FROM accounts WHERE id = ANY ( SELECT id FROM users_accounts " + 
				"WHERE users_id = ANY ( SELECT id FROM user_table WHERE first_name = 'Norman'))";

		try {
			PreparedStatement s = connection.prepareStatement(query);

			s.setInt(1, user.getId());
			s.setString(2, user.getFirstName());
			ResultSet resultSet = s.executeQuery();

			while (resultSet.next()) {
				
				double d = resultSet.getDouble("balence");
				System.out.println(d);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return user;
	}


	public User checkUser(User user, String pwLogin) {
		connect();

		try {
			PreparedStatement s = connection.prepareStatement("SELECT id, first_name, last_name, pw_hash FROM user_table WHERE id = ?");
			s.setString(1,pwLogin);
			ResultSet resultSet = s.executeQuery();
			

			while(resultSet.next()) {
				// retrieve for the current row from the result set
				int id = resultSet.getInt(1);
				String first_name = resultSet.getString(2);
				String last_name = resultSet.getString(3);
				String password = resultSet.getString(4);
				

				// If entered password equals hashed password -> set values for the user
				if(checkpw(pwLogin, password)){
					user.setId(id);
					user.setFirstName(first_name);
					user.setLastName(last_name);			
					user.setPassword(pwLogin);
				}else {
					System.out.println(" ERROR:  Incorrect password!");
					System.exit(0);
				}
			}

			resultSet.close();
			s.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	private boolean checkpw(String pwLogin, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	@Override
	public int deleteUserById(int id) throws IOException {
int rowsDeleted = 0;
		
		String sql = "DELETE FROM Users WHERE UserId = ?";
		
		Connection connection = null;
		PreparedStatement s = null;
		
		try {
			connection = DBConnection.getConnection();
			s = connection.prepareStatement(sql);
			s.setInt(1, id);
			
			rowsDeleted = s.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			try {if (s != null) s.close();} catch(SQLException e) {}
		}
		
		return rowsDeleted;
	}
	public static Object getUsers(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	}


