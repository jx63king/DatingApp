package org.decision.model;

public class UserSearh {

	// Generate Getters and Setters...
		private String idUser, ageL, ageH, agePreference,
		genderPreferred, orientation, orientationPreference,relationshipType,
		attractiveness,attractivenessPreference, hobby,hobbyPreference, 
		personality,personalityPreference, rankFirst, rankSecond, rankThird;
		String zip;

		

		public String getUserId() {
			return idUser;
		}

		public void setUserId(String idUser) {
			this.idUser = idUser;
		}

		/*public String getUserPassword() {
			return password;
		}

		public void setUserPassword(String password) {
			this.password = password;
		}*/
		
		
		public String getUserAgeL() {
			return ageL;
		}

		public void setUserAgeL(String ageL) {
			this.ageL = ageL;
		}
		
		public String getUserAgeH() {
			return ageH;
		}
		
		public void setUserAgeH(String ageH) {
			this.ageH = ageH;
		}

		public void setUserAgePreference(String agePreference) {
			this.agePreference = agePreference;
		}
		
		public String getUserAgePreference() {
			return agePreference;
		}

		
		
		public String getUserGender() {
			return genderPreferred; 
		}
		
		public void setUserGender(String genderPreferred) {
			this.genderPreferred = genderPreferred; 
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
		
		//orientationPreference
		public String getOrientationPreference() {
			return orientationPreference; 
		}
		
		public void setOrientationPreference(String orientationPreference) {
			this.orientationPreference = orientationPreference; 
		}
		
		
		//attractivenessPreference
		public String getAttractivenessPreference() {
			return attractivenessPreference; 
		}
		
		public void setAttractivenessPreference(String attractivenessPreference) {
			this.attractivenessPreference = attractivenessPreference; 
		}
		
		//hobbyPreference
		public String getHobbyPreference() {
			return hobbyPreference; 
		}
		
		public void setHobbyPreference(String hobbyPreference) {
			this.hobbyPreference = hobbyPreference; 
		}
		
		//personalityPreference
		public String getPersonalityPreference() {
			return personalityPreference; 
		}
		
		public void setPersonalityPreference(String personalityPreference) {
			this.personalityPreference = personalityPreference; 
		}
		
		
		
		
	
}
