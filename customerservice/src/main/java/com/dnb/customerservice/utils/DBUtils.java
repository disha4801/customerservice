package com.dnb.customerservice.utils;

//import java.io.IOException;
//import java.io.InputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
//import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

	public DBUtils() {
	}

	@Autowired
	DataSource dataSource;
//private Environment environment;

	// declare the properties
//	private static Properties properties;
//
//	private static Properties getProperties() {
//		// read the file
//		InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
//
//		try {
//			if (inputStream != null) {
//				// if file not null create obj of properties
//				properties = new Properties();
//				properties.load(inputStream);
//				return properties;
//			} else {
//				// if null return null to root
//				return null;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return properties;
//	}

	public Optional<Connection> getConnection() {
		// Properties properties = getProperties();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =dataSource.getConnection();
			return Optional.of(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
