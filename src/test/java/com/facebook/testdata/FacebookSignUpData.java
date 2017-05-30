package com.facebook.testdata;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class FacebookSignUpData {
	private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String fName;
	private String lName;
	private String password;
	private String bMonth;
	private String bDay;
	private String bYear;
	private String gender;
	public static String[] names = { "Julie", "Boris", "Chirack", "Petru", "Anna", "Elizabeth", "Cory", "Eddie" };
	public static String[] lNames = { "Brown", "Smith", "Chirackish", "Petruvich", "Hedjes", "Linton", "Cerveny",
			"Barker", "Hilton", "Moore", "Yellow" };

	public ArrayList<String> getSignUpInfo() {
		ArrayList<String> signUpInfo = new ArrayList<String>();
		signUpInfo.add(createFirstName());
		signUpInfo.add(createLastName());
		signUpInfo.add(createPassword());
		signUpInfo.add(generateDay());
		signUpInfo.add(generateMonth());
		signUpInfo.add(generateYear());
		signUpInfo.add(generateGender());
		return signUpInfo;
	}

	public String generateGender() {
		String male = "male";
		String female = "female";
		int num = 1 + (int) Math.round(Math.random() * (2 - 1));

		if (num == 1) {
			gender = male;
		} else {
			gender = female;
		}
		return gender;
	}

	public String createFirstName() {
		fName = names[randBetween(0, names.length - 1)];
		return fName;
	}

	public String createLastName() {
		lName = lNames[randBetween(0, names.length - 1)];
		return lName;
	}

	public String createPassword() {
		UUID uuid = UUID.randomUUID();
		password = uuid.toString();
		return password;
	}

	public String generateDay() {
		bDay = String.valueOf(randBetween(1, 30));
		return bDay;
	}

	public String generateMonth() {

		bMonth = String.valueOf(randBetween(1, 12));
		return bMonth;
	}

	public String generateYear() {
		bYear = String.valueOf(randBetween(1906, 2000));
		return bYear;
	}

	private static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static String generateRandomStr(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("String length must be a positive integer");
		}

		Random random = new SecureRandom();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}

		return sb.toString();
	}

}
