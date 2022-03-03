package com.training.bms.utility;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			FileReader rdr = new FileReader("src/main/resources/mydb.properties");
			Properties properties = new Properties();
				properties.load(rdr);
				String driver = properties.getProperty("driver");
				String url = properties.getProperty("url");
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
