package se.krogrannet.jdbc;

import java.sql.*;

public class JdbcHelper {
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/elit_krogra?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public JdbcHelper() throws ClassNotFoundException, SQLException {
		Class.forName( JDBC_DRIVER );
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		return ( DriverManager.getConnection( DB_URL, USERNAME, PASSWORD ) );
	}
}
