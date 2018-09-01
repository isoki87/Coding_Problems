package com.leo.interview;

/*
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1
 */


public class ScrambleString {
	public static void main(String[] args){
		ScrambleString a = new ScrambleString();
		String s1 = "cucumber";
		String s2 = "ercubumc";
		System.out.println("Expect true: " + a.isScrambledOf(s1, s2));
		String s3 = "cucumbers";
		String s4 = "ercubumc";
		System.out.println("Expect false: " + a.isScrambledOf(s3, s4));
		String s5 = "cucumber";
		String s6 = "erccbumc";
		System.out.println("Expect false: " + a.isScrambledOf(s5, s6));
	}
	
	public boolean isScrambledOf(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() != s2.length()){
			return false;
		}
		char[] s1Count = new char[256];
		char[] s2Count = new char[256];
		
		for(int i = 0; i < s1.length(); i++){
			s1Count[s1.charAt(i)]++;			
		}
		for(int i = 0; i < s2.length(); i++){
			s2Count[s2.charAt(i)]++;
		}
		for(int i = 0; i < s1Count.length; i++){
			if(s1Count[i] != s2Count[i]){
				return false;
			}
		}
		return true;
	}
}
