package com.codegnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	static final String jdbc_url="jdbc:mysql://localhost:3306/jfs_41";
	static final String username = "root";
	static final String password = "Naga@123";
public static Connection getConnection() throws SQLException{
	return DriverManager.getConnection(jdbc_url,username,password);
	
}
}
