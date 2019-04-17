package org.decision.controller;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	final private String host = "jdbc:mysql://localhost:3306/Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final private String user = "root";
	final private String passwd = "JetLee920816";
	final private String user_database = "User";
	final private String feedback_database = "Feedback";

	public void connectToDB() throws Exception {
		try {

			// Setup the connection with the DB
			connect = DriverManager.getConnection(host, user, passwd);
			System.out.println("Database connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, String[]> readUsers() throws Exception {
		try {
			HashMap<Integer, String[]> userInfo = new HashMap<Integer, String[]>();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from " + user_database);
			while (resultSet.next()) {
				int user_id = resultSet.getInt("user_id");
				int age = resultSet.getInt("age");
				int location = resultSet.getInt("zip");
				String gender = resultSet.getString("gender");
				String orientation = resultSet.getString("sexual_orientation");
				String personality = resultSet.getString("personality");
				String relationshipType = resultSet.getString("relationship_type");
				String hobby = resultSet.getString("hobby");
				int attractiveness = resultSet.getInt("attractiveness");

				String[] infoString = new String[] { Integer.toString(location), personality, relationshipType, hobby,
						Integer.toString(attractiveness), gender, orientation, Integer.toString(age) };

				userInfo.put(user_id, infoString);
			}
			return userInfo;
		} catch (Exception e) {
			throw e;
		}
	}

	public HashMap<String, Integer> readFeedback() throws Exception {
		try {
			HashMap<String, Integer> feedbackInfo = new HashMap<String, Integer>();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from " + feedback_database);
			while (resultSet.next()) {
				int user_id = resultSet.getInt("user_id");
				int date_user_id = resultSet.getInt("date_user_id");
				int score = resultSet.getInt("score");

				String infoString = Integer.toString(user_id) + "," + Integer.toString(date_user_id);
				feedbackInfo.put(infoString, score);
			}

			return feedbackInfo;
		} catch (Exception e) {
			throw e;
		}
	}

	public void cleanResult() throws Exception {
		// SQL statement for truncating table before adding new data
		Statement statement = connect.createStatement();
		try {
			statement.executeUpdate("TRUNCATE TABLE search_result");

			System.out.println("Successfully clean original data");

		} catch (SQLException e) {

		}
	}

	public void insertRecords(int id) throws Exception {
		// inserting search results
		Statement statement = connect.createStatement();

		try {
			statement.executeUpdate(
					"insert into search_result(user_id, first_name, last_name, age,gender,sexual_orientation,zip,relationship_type,hobby,attractiveness,personality)\n"
							+ "SELECT User.user_id,User.first_name,User.last_name,User.age,User.gender,User.sexual_orientation,User.zip,User.relationship_type,User.hobby,User.attractiveness,User.personality from User where User.user_id ="
							+ id);

			System.out.println("Successfully insert search records");

		} catch (SQLException e) {

		}
	}

	// free the resultSet and close the connection
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}