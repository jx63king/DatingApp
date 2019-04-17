package org.decision.dao;

import java.util.List;

//import java.util.List;

import org.decision.model.User;
//import org.springframework.ui.ModelMap;
import org.decision.model.UserSearh;


public interface UserDao {

	public int registerUser(User user);
	//public String userMatching(User user);


	public String loginUser(User user);


	//public String matchingUser(UserSearch user);


	public String matchingUser(UserSearh user);


	public List<User> userList();
	//public List<User> userList(Integer[] userId);
	//public List<User> userList(Integer userId);



}
