package com.leo.interview;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s
 */

public class ValidAnagram {
	public static void main(String[] args){
		ValidAnagram a = new ValidAnagram();
		String s1 = "cathatfatnat";
		String t1 = "caatthtaftan";
		System.out.println("Expect true: " + a.isAnagram(s1, t1));
		String s2 = "**hello**I*am*hungry?";
		String t2 = "?ung***a*heIo*lmy*lhr";
		System.out.println("Expect true: " + a.isAnagram(s2, t2));
		String s3 = "ThisIsAwesome";
		String t3 = "hswiIeTAso*e";
		System.out.println("Expect false: " + a.isAnagram(s3, t3));
	}
	
	public boolean isAnagram(String s, String t){
		if(s == null || t == null || s.length() != t.length() || s.length() == 0){
			return false;
		}
		String sTrim = s.trim();
		String tTrim = t.trim();
		
		char[] sArr = new char[256];
		char[] tArr = new char[256];
		
		for(int i = 0; i < s.length(); i++){
			sArr[s.charAt(i)]++;			
		}
		for(int i = 0; i < t.length(); i++){
			tArr[t.charAt(i)]++;
		}
		for(int i = 0; i < sArr.length; i++){
			if(sArr[i] != tArr[i]){
				return false;
			}
		}
		return true;
	}
}
