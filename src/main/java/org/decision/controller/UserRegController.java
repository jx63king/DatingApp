/*package org.decision.controller;

import org.decision.dao.UserDao;
import org.decision.model.User;
//import org.decision.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	//public ModelAndView userRegistration(@RequestParam("userId") String userId,
		//	@RequestParam("password") String password) {
	
	//idUser, password, userFName,userLName, age, gender, orientation,zip,relationship, notes;
	
	public ModelAndView userReg(
			@RequestParam("idUser") String idUser,
			@RequestParam("password") String password,
			@RequestParam("userFName") String userFName,
			@RequestParam("userLName") String userLName,
			@RequestParam("userAgeL") String ageL,
			@RequestParam("userAgeH") String ageH,
			@RequestParam("userGender") String gender,
			@RequestParam("userOrientation") String orientation,
			@RequestParam("userZip") String zip,
			@RequestParam("userRelationship") String relationship,
			@RequestParam("userNotes") String notes,
			@RequestParam("userAttractiveness") String attractiveness,
			@RequestParam("userHobby") String hobby, 
			@RequestParam("userPersonality") String personality
			) {
	
		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUserId(idUser);
		user.setUserPassword(password);
		
		user.setUserFName(userFName);
		user.setUserLName(userLName);
		user.setUserAge(age); 
		
		user.setUserGender(gender); 
		user.setUserOrientation(orientation); 
		user.setUserZip(zip); 
		user.setUserRelationship(relationship); 
		user.setUserNotes(notes); 
		
		user.setUserAttractiveness(attractiveness);
		user.setUserHobby(hobby);
		user.setUserPersonality(personality);
		
		
		int counter = userDao.registerUser(user);

		if (counter > 0) {
		//if (tmp != null) {
			mv.addObject("msg", "Thanks for your input.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("reg");

		return mv;

	}
	
	

}*/
