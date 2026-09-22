package com.praj.lambda;
import java.util.Random;

import java.util.function.Supplier;
public class OtpGenerator {

	public static void main(String[] args) {
		
		char[] vowels = {'A', 'E', 'I', 'O', 'U'};
		Random random = new Random();
		
		Supplier<Character> randomVowelSupplier = () -> vowels[random.nextInt(vowels.length)];
		Supplier<Integer> randomValue = ()->(int) (Math.random() * 9) + 1;
		
		
		char vowel = randomVowelSupplier.get();
		System.out.print("OTP Generated is: "+vowel);
		
		for(int itemp = 0; itemp<5; itemp++) {
			int randomNumber = randomValue.get();
			System.out.print(randomNumber);
		}
		
		
	

	}

}
