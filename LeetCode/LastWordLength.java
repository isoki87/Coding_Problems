package com.leo.interview;

/*
 * Given a string s consisting of upper/lower-case alphabets and empty space characters ' ', return the length of the last word in the string
 * If the last word does not exist, return 0;
 */

public class LastWordLength {
	public static void main(String[] args){
		LastWordLength a = new LastWordLength();
		String s1 = "bird is big";
		String s2 = " this is one";
		String s3 = "superduper";
		String s4 = "    ";
		String s5 = "i want a";
		System.out.println("Expect 3: " + a.findLastWordLength(s1));
		System.out.println("Expect 3: " + a.findLastWordLength(s2));
		System.out.println("Expect 10: " + a.findLastWordLength(s3));
		System.out.println("Expect 0: " + a.findLastWordLength(s4));
		System.out.println("Expect 1: " + a.findLastWordLength(s5));
		
	}
	//"bird is big" - 3
	//" this is one  " - 3
	//"superduper" - 10
	//"     " - 0
	//"i want a" - 1
	
	
	public int findLastWordLength(String s){
		String phrase = s.trim();
		int len = 0;
		if(phrase.length() == 0){
			return len;
		}
		for(int i = phrase.length() - 1; i >= 0; i--){
			if(phrase.charAt(i) == ' '){
				return len;
			}
			len++;
		}
		return len;
	}
	
}
