package com.andreearacovita.ebankingrestapi.utils;

import java.util.Random;

public class Generator {
	private static Random random = new Random();
	
	private static String bankAccountNumberPrefix = "CH0100001";
	
	private static int randomDigit() {
		return random.nextInt(10);
	}
	
	private static String generate(String prefix, int count) {
		StringBuilder generatedBankAccount = new StringBuilder(prefix);
		
		for (int i = 0; i < count; i++) {
			generatedBankAccount.append(Generator.randomDigit());
		}
		
		return generatedBankAccount.toString();
	}
	
	public static String generateBankAccount() {
		return generate(bankAccountNumberPrefix, 12);
	}
	
	public static String generateCardNumber() {
		
		return generate("", 16);
	}
	
	public static String generateCVV() {
		return generate("", 3);
	}
	
	public static String generatePIN() {
		return generate("", 4);
	}
}
