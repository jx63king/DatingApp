package org.decision.model;



public class User {

	// Generate Getters and Setters...
	private int idUser; 
	private String password, 
	userFName,userLName, age, 
	gender, orientation,zip,relationshipType, notes,
	attractiveness, hobby, personality; //rankFirst, rankSecond, rankThird;


	public int getUserId() {
		return idUser;
	}

	public void setUserId(int idUser) {
		this.idUser = idUser;
	}

	public String getUserPassword() {
		return password;
	}

	public void setUserPassword(String password) {
		this.password = password;
	}
	
	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}
	
	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}
	
	public String getUserAge() {
		return age;
	}

	public void setUserAge(String age) {
		this.age = age;
	}
	
	
	public String getUserGender() {
		return gender; 
	}
	
	public void setUserGender(String gender) {
		this.gender = gender; 
	}
	
	public String getUserOrientation() {
		return orientation; 
	}
	
	public void setUserOrientation(String orientation) {
		this.orientation = orientation; 
	}
	
	public String getUserZip() {
		return zip; 
	}
	
	public void setUserZip(String zip) {
		this.zip = zip; 
	}
	
	public String getUserRelationship() {
		return relationshipType; 
	}
	
	public void setUserRelationship(String relationshipType) {
		this.relationshipType = relationshipType; 
	}
	
	public String getUserNotes() {
		return notes; 
	}
	
	public void setUserNotes(String notes) {
		this.notes = notes; 
	}

//new 
	public String getUserAttractiveness() {
		return attractiveness; 
	}
	
	public void setUserAttractiveness(String attractiveness) {
		this.attractiveness = attractiveness ; 
	}
	
	public String getUserHobby() {
		return hobby; 
	}
	
	public void setUserHobby(String hobby) {
		this.hobby = hobby; 
	}
	
	public String getUserPersonality() {
		return personality; 
	}
	
	public void setUserPersonality(String personality) {
		this.personality = personality; 
	}
	
	/*user.setRankFirst(rankFirst); 
	user.setRankSecond(rankSecond); 
	user.setRankThird(rankThird); 
	*/
	/*
	public String getRankFirst() {
		return rankFirst; 
	}
	
	public void setRankFirst(String rankFirst) {
		this.rankFirst = rankFirst; 
	}
	
	public String getRankSecond() {
		return rankSecond; 
	}
	
	public void setRankSecond(String rankSecond) {
		this.rankSecond = rankSecond; 
	}
	
	public String getRankThird() {
		return rankThird; 
	}
	
	public void setRankThird(String rankThird) {
		this.rankThird = rankThird; 
	}
	*/
	
	
	

}

