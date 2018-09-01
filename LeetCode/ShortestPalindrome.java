package com.leo.interview;

/*
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * "aacecaaa" will return "aaacecaaa"
 * "abcd" will return "dcbabcd"
 * "bdeacccccccaedbe
 */

public class ShortestPalindrome {
	public static void main(String[] args){
		ShortestPalindrome a = new ShortestPalindrome();
		System.out.println("Expect dcbabcd: " + a.shortPalindrome("abcd"));
		System.out.println("Expect aaacecaaa: " + a.shortPalindrome("aacecaaa"));
	}
	
	public String shortPalindrome(String s){
		//Worst case is to mirror the entire string (except for the first char)
		//Best case is not to do anything, OR add one char
		
		int i = 0;
		int j = s.length() - 1;
		
		while(j >= 0){
			if(s.charAt(i) == s.charAt(j)){
				i++;
			}
			j--;
		}
		if(i == s.length()){
			return s;
		}
		String suffix = s.substring(i);
		System.out.println("suffix is " + suffix);
		String prefix = new StringBuilder(suffix).reverse().toString();
		System.out.println("prefix is " + prefix);
		String mid = shortPalindrome(s.substring(0, i));
		System.out.println("mid is " + mid);
		return prefix + mid + suffix;			
	}
}
