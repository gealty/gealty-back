package es.gealty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDAO {

	private static final String serverName = "localhost";
	private static final String portNumber = "3306";
	private static final String userName = "root";
	private static final String database = "gealty";

	
	public BaseDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);

		return  DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + database + "?" +
                "user=" + userName + "&password=");
	}
}
