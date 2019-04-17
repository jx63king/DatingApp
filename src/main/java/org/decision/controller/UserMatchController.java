package org.decision.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.IOException;
import java.sql.*;

import org.decision.dao.UserDao;
import org.decision.model.User;
import org.decision.model.UserSearh;
//import org.decision.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserMatchController {

	@Autowired
	private UserDao userDao;

	private Map<String, Double> featureWeight = new HashMap<String, Double>();
	private Set<String> featureKeys;
	private boolean ranking = false;
	private String rankFirstTest;
	private String rankSecondTest;
	private String rankThirdTest;
	private Map<Integer, String[]> users = new HashMap<Integer, String[]>();
	private Map<String, Integer> feedback = new HashMap<String, Integer>();
	private Set<Integer> userKeys;
	private Set<String> feedbackKeys;

	private String user_idTest;
	private String genderTest;
	private String orientationTest;
	private String locationTest;
	private String age_bottomTest;
	private String age_topTest;
	private String personalityTest;
	private String relationshipTypeTest;
	private String hobbyTest;
	private String attractivenessTest;
	private String[] userRequirementTest;

	private boolean locationNoCheck = false;
	private boolean ageNoCheck = false;
	private boolean personalityNoCheck = false;
	private boolean relationshipTypeNoCheck = false;
	private boolean hobbyNoCheck = false;
	private boolean attractivenessNoCheck = false;

	private Map<Integer, Double> personalScore = new HashMap<Integer, Double>();

	// private Object[] trail;
	Integer[] intArray;
	// private Set<Integer> userKeys;

	@RequestMapping(value = "result", method = RequestMethod.POST)
	// idUser, password,
	// userFName,userLName, ageL, ageH,
	// genderPreferred, orientation,zip,relationshipType, notes,
	// attractiveness, hobby, personality, rankFirst, rankSecond, rankThird;

	public ModelAndView userReg(@RequestParam("idUser") String idUser,
			// @RequestParam("password") String password,
			// @RequestParam("userFName") String userFName,
			// @RequestParam("userLName") String userLName,
			@RequestParam("userAgeL") String ageL, @RequestParam("userAgeH") String ageH,
			@RequestParam("userGender") String gender, @RequestParam("userOrientation") String orientation,
			@RequestParam("userZip") String zip, @RequestParam("userRelationship") String relationship,
			// @RequestParam("userNotes") String notes,
			@RequestParam("userAttractiveness") String attractiveness, @RequestParam("userHobby") String hobby,
			@RequestParam("userPersonality") String personality, @RequestParam("rankFirst") String rankFirst,
			@RequestParam("rankSecond") String rankSecond, @RequestParam("rankThird") String rankThird
	/*
	 * @RequestParam("orientationPreference") String orientationPreference,
	 * 
	 * @RequestParam("attractivenessPreference") String
	 * attractivenessPreference,
	 * 
	 * @RequestParam("orientationPreference") String orientationPreference,
	 */

	) throws Exception {

		ModelAndView mv = new ModelAndView();

		UserSearh user = new UserSearh();
		user.setUserId(idUser);
		// user.setUserPassword(password);

		// user.setUserFName(userFName);
		// user.setUserLName(userLName);
		user.setUserAgeL(ageL);
		user.setUserAgeH(ageH);

		user.setUserGender(gender);
		user.setUserOrientation(orientation);
		user.setUserZip(zip);
		user.setUserRelationship(relationship);
		// user.setUserNotes(notes);

		user.setUserAttractiveness(attractiveness);
		user.setUserHobby(hobby);
		user.setUserPersonality(personality);

		user.setRankFirst(rankFirst);
		user.setRankSecond(rankSecond);
		user.setRankThird(rankThird);

		// int counter = userDao.matchingUser(user);
		// userDao.matchingUser(user);

		if (!ranking) {
			featureWeight.put("gender", 5.0);
			featureWeight.put("orientation", 10.0);
			featureWeight.put("age", 0.16);
			featureWeight.put("location", 0.16);
			featureWeight.put("relationshipType", 0.2);
			featureWeight.put("hobby", 0.16);
			featureWeight.put("attractiveness", 0.16);
			featureWeight.put("personality", 0.16);
		}
		featureKeys = featureWeight.keySet();

		MySQLAccess dao = new MySQLAccess();
		dao.connectToDB();
		// readUsers = id:{location, personality,
		// relationshipType, hobby, attractiveness, gender, orientation, age}
		users = dao.readUsers();
		feedback = dao.readFeedback();
		userKeys = users.keySet(); // user_id set
		feedbackKeys = feedback.keySet(); // user_id set

		String genderTest = user.getUserGender();
		System.out.println("GenderTest; " + genderTest);
		user_idTest = user.getUserId();
		genderTest = user.getUserGender();
		orientationTest = user.getUserOrientation();
		locationTest = user.getUserZip();
		age_bottomTest = user.getUserAgeL();
		age_topTest = user.getUserAgeH();
		personalityTest = user.getUserPersonality();
		relationshipTypeTest = user.getUserRelationship();
		hobbyTest = user.getUserHobby();
		attractivenessTest = user.getUserAttractiveness();
		ranking = Boolean.parseBoolean("true");
		rankFirstTest = user.getRankFirst();
		rankSecondTest = user.getRankSecond();
		rankThirdTest = user.getRankThird();
		// this is for the check marks that we need to add
		String no = "No";
		if (locationTest == Integer.toString(0))
			locationNoCheck = Boolean.parseBoolean("true");

		if (age_bottomTest == null && age_topTest == null)
			ageNoCheck = Boolean.parseBoolean("true");

		if (personalityTest == no)
			personalityNoCheck = Boolean.parseBoolean("true");

		if (relationshipTypeTest == no)
			relationshipTypeNoCheck = Boolean.parseBoolean("true");

		if (hobbyTest == no)
			hobbyNoCheck = Boolean.parseBoolean("true");

		if (attractivenessTest == no)
			attractivenessNoCheck = Boolean.parseBoolean("true");

		System.out.println(user_idTest);
		System.out.println(genderTest);
		System.out.println(locationTest);
		System.out.println(age_bottomTest);
		System.out.println(age_topTest);
		System.out.println(personalityTest);
		System.out.println(relationshipTypeTest);
		System.out.println(hobbyTest);
		System.out.println(attractivenessTest);
		System.out.println(rankFirstTest);
		System.out.println(rankSecondTest);
		System.out.println(rankThirdTest);

		userRequirementTest = new String[] { locationTest, personalityTest, relationshipTypeTest, hobbyTest,
				attractivenessTest, genderTest, orientationTest, age_bottomTest, age_topTest };

		if (ranking) {
			featureWeight.put(rankFirstTest, 0.6);
			featureWeight.put(rankSecondTest, 0.2);
			featureWeight.put(rankThirdTest, 0.11);

			for (String feature : featureKeys) {
				if (!feature.equals(rankFirstTest) && (!feature.equals(rankSecondTest))
						&& (!feature.equals(rankThirdTest))
						&& (!feature.equals("gender") && (!feature.equals("orientation")))) {
					featureWeight.put(feature, 0.03);
				}
			}
		}

		// compare user requirement with database users one attribute per
		// attribute

		for (Integer userInt : userKeys) {
			double score = 0.0;
			// score = score*weight
			// location
			if (locationNoCheck) {
				score += featureWeight.get("location");
			} else
				score += getZipSimilarity(users.get(userInt)[0], userRequirementTest[0])
						* featureWeight.get("location");
			// personality
			// Dice Similarity
			if (personalityNoCheck) {
				score += featureWeight.get("personality");
			} else
				score += DiceCoefficient(users.get(userInt)[1], userRequirementTest[1])
						* featureWeight.get("personality");
			// Cosine Similarity
			// score += getSimilarDegree(users.get(user)[1], userRequirement[1])
			// *
			// featureWeight.get("personality");
			// relationshipType
			if (relationshipTypeNoCheck) {
				score += featureWeight.get("relationshipType");
			} else {
				if (users.get(userInt)[2].equalsIgnoreCase(userRequirementTest[2])) {
					score += featureWeight.get("relationshipType");
				}
			}
			// hobby
			// Dice Similarity
			if (hobbyNoCheck) {
				score += featureWeight.get("hobby");
			}
			score += DiceCoefficient(users.get(userInt)[3], userRequirementTest[3]) * featureWeight.get("hobby");
			// Cosine Similarity
			// score += getSimilarDegree(users.get(user)[3], userRequirement[3])
			// *
			// featureWeight.get("personality");
			// attractiveness
			if (attractivenessNoCheck) {
				score += featureWeight.get("hobby");
			} else {
				if (Integer.parseInt(users.get(userInt)[4]) >= Integer.parseInt(userRequirementTest[4])) {
					score += featureWeight.get("attractiveness");
				}
			}
			// gender
			if (!users.get(userInt)[5].equalsIgnoreCase(userRequirementTest[5])) {
				score -= featureWeight.get("gender");
			}

			// orientation
			if (!users.get(userInt)[6].equalsIgnoreCase(userRequirementTest[6])) {
				score -= featureWeight.get("orientation");
			}

			// age
			if (ageNoCheck) {
				score += featureWeight.get("age");
			} else {
				if (Integer.parseInt(users.get(userInt)[7]) >= Integer.parseInt(userRequirementTest[7])
						&& Integer.parseInt(users.get(userInt)[7]) <= Integer.parseInt(userRequirementTest[8])) {
					score += featureWeight.get("age");
				}
			}
			personalScore.put(userInt, score);
		}
		for (int id : personalScore.keySet()) {
			String key = user_idTest + "," + Integer.toString(id);
			if ((feedback.containsKey(key))) {
				if (feedback.get(key) < 3) {
					personalScore.put(id, personalScore.get(id) - 5);
				}
			}
		}

		HashMap<Integer, Double> sortedScore = sortByValue(personalScore);
		System.out.println(sortedScore);
		Object[] trail = sortedScore.keySet().toArray();

		// Integer[] intArray = sortedScore.keySet().toArray(new
		// Integer[sortedScore.size()]);
		intArray = sortedScore.keySet().toArray(new Integer[sortedScore.size()]);

		// trailList.add(Arrays.toInteger(trail));

		for (int i = 0; i < trail.length; i++) {

			System.out.println(trail[i]);
		}

		for (int j = 0; j < intArray.length; j++) {
			System.out.println("intArray[" + j + "]" + intArray[j]);
		}
		
		MySQLAccess dao_2 = new MySQLAccess();
		dao_2.connectToDB();
		dao_2.cleanResult();
		for (int i = 0; i < intArray.length; ++i) {
			dao_2.insertRecords(intArray[i]);
		}

		// smv.setViewName("result");

		return mv;

	}

	// @Autowired
	// private UserDao userDao;

	@RequestMapping(value = "/results")
	public ModelAndView listUser(ModelAndView model) throws Exception {
		
		 /* MySQLAccess dao_2 = new MySQLAccess(); dao_2.connectToDB();
		  dao_2.cleanResult();
		  
		  for (int i =0;i<intArray.length;++i) {
		  dao_2.insertRecords(intArray[i]); }*/
		 

		List<User> listUsr = userDao.userList();
		// List<User> listUsr = userDao.userList(intArray[j]);
		// List<User> listUsr = userDao.userList();

		if (listUsr != null) {
			model.addObject("listUsr", listUsr);
			model.addObject("msg", "Welcome," + " Successfully.");
			model.setViewName("results");

		} else {
			model.addObject("msg", "Invalid.");
		}

		return model;
	}

	public HashMap<Integer, Double> sortByValue(Map<Integer, Double> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<Integer, Double>> list = new LinkedList<Map.Entry<Integer, Double>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>();
		for (Map.Entry<Integer, Double> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public double getZipSimilarity(String zip1, String zip2) {
		int distance = Math.abs(Integer.parseInt(zip1) - Integer.parseInt(zip2));
		if (distance <= 100)
			return 1;
		else if (distance > 100 && distance <= 1000)
			return 0.8;
		else if (distance > 1000 && distance <= 10000)
			return 0.4;
		else
			return 0;
	}

	public double DiceCoefficient(String str1, String str2) {
		if (str1.isEmpty() && str2.isEmpty()) {
			return 1;
		}

		Set<String> s1 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		Set<String> s2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

		String strArray1[] = str1.split(" ");
		for (int i = 0; i < strArray1.length; ++i) {
			s1.add(strArray1[i]);
		}

		String strArray2[] = str2.split(" ");
		for (int i = 0; i < strArray2.length; ++i) {
			s2.add(strArray2[i]);
		}

		// 求交集
		Set<String> intersection = new HashSet<String>();
		intersection.addAll(s1);
		intersection.retainAll(s2);

		// 求并集
		Set<String> union = new HashSet<String>();
		union.addAll(s1);
		union.addAll(s2);

		return (double) (2 * intersection.size()) / (s1.size() + s2.size());
	}

	public static double getSimilarDegree(String str1, String str2) {
		// 创建向量空间模型，使用map实现，主键为词项，值为长度为2的数组，存放着对应词项在字符串中的出现次数
		Map<String, int[]> vectorSpace = new TreeMap<String, int[]>(String.CASE_INSENSITIVE_ORDER);
		int[] itemCountArray = null;// 为了避免频繁产生局部变量，所以将itemCountArray声明在此

		// 以空格为分隔符，分解字符串
		String strArray[] = str1.split(" ");
		for (int i = 0; i < strArray.length; ++i) {
			if (vectorSpace.containsKey(strArray[i]))
				++(vectorSpace.get(strArray[i])[0]);
			else {
				itemCountArray = new int[2];
				itemCountArray[0] = 1;
				itemCountArray[1] = 0;
				vectorSpace.put(strArray[i], itemCountArray);
			}
		}

		strArray = str2.split(" ");
		for (int i = 0; i < strArray.length; ++i) {
			if (vectorSpace.containsKey(strArray[i]))
				++(vectorSpace.get(strArray[i])[1]);
			else {
				itemCountArray = new int[2];
				itemCountArray[0] = 0;
				itemCountArray[1] = 1;
				vectorSpace.put(strArray[i], itemCountArray);
			}
		}
		// 计算相似度
		double vector1Modulo = 0.00;// 向量1的模
		double vector2Modulo = 0.00;// 向量2的模
		double vectorProduct = 0.00; // 向量积
		Iterator iter = vectorSpace.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			itemCountArray = (int[]) entry.getValue();

			vector1Modulo += itemCountArray[0] * itemCountArray[0];
			vector2Modulo += itemCountArray[1] * itemCountArray[1];

			vectorProduct += itemCountArray[0] * itemCountArray[1];
		}
		vector1Modulo = Math.sqrt(vector1Modulo);
		vector2Modulo = Math.sqrt(vector2Modulo);

		// 返回相似度
		return (vectorProduct / (vector1Modulo * vector2Modulo));
	}

}
