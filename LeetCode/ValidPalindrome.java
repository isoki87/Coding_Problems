package com.leo.interview;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters
 * "Red rum, sir, is murder" is true
 * "Programcreek is awesome" is false
 * Is the string empty? Empty string is a palindrome.
 */

public class ValidPalindrome {
	public static void main(String[] args){
		ValidPalindrome a = new ValidPalindrome();
		String s1 = "     ";
		System.out.println("Expect true: " + a.isPalindrome(s1));
		String s2 = "Red rum, sir, is murder";
		s2 = s2.toLowerCase();
		System.out.println("Expect true: " + a.isPalindrome(s2));
		String s3 = "Programcreek is awesome";
		s3 = s3.toLowerCase();
		System.out.println("Expect false: " + a.isPalindrome(s3));
	}
	
	public boolean isPalindrome(String s){
		if(s == null || s.trim().length() == 0){
			return true;
		}
		s = s.trim();
		int l = 0;
		int r = s.length() - 1;
		while(l <= r){
			if(s.charAt(l) == s.charAt(r)){
				l++;
				r--;
			} else if(!isAlpha(s.charAt(l)) && !isNum(s.charAt(l))) {
				l++;
			} else if(!isAlpha(s.charAt(r)) && !isNum(s.charAt(r))){
				r--;
			} else {
				if(s.charAt(l) != s.charAt(r)){
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isAlpha(char c){
		if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
			return true;
		}
		return false;
	}
	
	private boolean isNum(char c){
		if(c >= '0' && c <= '9'){
			return true;
		}
		return false;
	}
}
