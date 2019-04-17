package org.decision.dao;

import javax.sql.DataSource;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.decision.model.User;
import org.decision.model.UserSearh;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.decision.model.User;




public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	/*@Override
	public int registerUser1(User user) {
		//public String userMatching(User user) {
		
		String sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			
			int counter = jdbcTemplate.update(sql, 
					//new Object[] { user.getUserId(), user.getPassword() });
					new Object[] {
							user.getUserId(), 
							user.getUserFName(), 
							user.getUserLName(), 
							user.getUserAgeL(),
							user.getUserAgeH(),
							user.getUserGender(),
							user.getUserOrientation(),
							user.getUserZip(),
							user.getUserRelationship(),
							user.getUserPassword(), 
							user.getUserNotes(),
							user.getUserAttractiveness(),
							user.getUserHobby(),
							user.getUserPersonality()
			});
			return counter;

			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}*/



	@Override
	public String loginUser(User user) {
		
		String sql = "SELECT user_id FROM User WHERE user_id=? AND password=? ";
		
		try {

			String userId = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getUserId(), user.getUserPassword() }, String.class);

			return userId;
			
		} catch (Exception e) {
			return null;
		}
		
		
	}

	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String matchingUser(UserSearh user) {
		// TODO Auto-generated method stub
		/*String sql = "SELECT user_id FROM User";
		
		try {

			String userId = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getUserId() }, String.class);

			return userId;
			
		} catch (Exception e) {
			return null;
		}*/
		return null;
	
	
	}
	


	@Override
	//public List<User> userList(Integer userId) {
	public List<User> userList() {
	//public List<User> userList() {
		List<User> list = jdbcTemplate.query(
				"SELECT * FROM search_result ", new RowMapper<User>() {
				//"SELECT * FROM User where user_id = userId(?)", new RowMapper<User>() {
 
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User usr = new User();
				
				usr.setUserId(rs.getInt("user_id"));
				usr.setUserFName(rs.getString("first_name"));
				usr.setUserLName(rs.getString("last_name"));
				usr.setUserAge(rs.getString("age")); 
				usr.setUserGender(rs.getString("gender"));
				usr.setUserOrientation(rs.getString("sexual_orientation"));
				usr.setUserZip(rs.getString("zip"));
				usr.setUserRelationship(rs.getString("relationship_type"));
				//usr.setUserPassword(rs.getString("password"));
				//usr.setUserNotes(rs.getString("notes"));
				usr.setUserAttractiveness(rs.getString("attractiveness"));
				usr.setUserHobby(rs.getString("hobby"));
				usr.setUserPersonality(rs.getString("personality"));
				
				return usr;
			}

		});

		return list;
	}

	




	
	
}
