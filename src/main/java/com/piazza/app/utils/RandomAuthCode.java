package com.piazza.app.utils;

public class RandomAuthCode {

	private StringBuffer authCode = new StringBuffer();

	public RandomAuthCode(int length) {
		getRandomAuthCode(length);
	}

	private void getRandomAuthCode(int length) {
		try {
			long time;
			short val;

			for (int i = 0; i < length; i++) {
				time = System.currentTimeMillis();
				val = (short) Math.abs((time * Math.random()) % 10);
				authCode.append(val);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String toString() {
		return authCode.toString();
	}

	public static void main(String[] args) {
		RandomAuthCode authCode;

		for (int i = 0; i < 100; i++) {
			authCode = new RandomAuthCode(6);
			System.out.println(authCode.toString());
		}
	}
}
