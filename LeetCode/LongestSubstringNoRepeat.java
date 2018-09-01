package com.leo.interview;

/*
 * Given a string, find the length of the longest substring without repeating characters
 * The longest substring witout repeating letters for "abcabcbb" is abc, which is len 3.
 * For "bbbbb" the longest is "b" with the length of 1
 */

import java.util.HashSet;

public class LongestSubstringNoRepeat {
	public static void main(String[] args){
		LongestSubstringNoRepeat a = new LongestSubstringNoRepeat();
		String s1 = "abcabcbb";
		System.out.println("Expect 3: " + a.lengthOfNoRepeat(s1));
		String s2 = "bbbbbbb";
		System.out.println("Expect 1: " + a.lengthOfNoRepeat(s2));
		String s3 = "aaabcbyiukn";
		System.out.println("Expect 7: " + a.lengthOfNoRepeat(s3));
	}
	
	//abcabcbb - 3
	//bbbbb - 1
	//aaabcbyiukn - 7
	
	//Brute force method is to start at each character
	//Go down the length of the string
	public int lengthOfNoRepeat(String s){
		int uniSubstring = Integer.MIN_VALUE;
		s = s.trim();
		if(s == null || s.length() == 0){
			return 0;
		}
		HashSet<Character> set = new HashSet<>();
		int len = 0;
		for(int i = 0; i < s.length() - 1; i++){
			set.add(s.charAt(i));
			len++;
			for(int j = i + 1; j < s.length(); j++){
				if(set.contains(s.charAt(j))){
					break;
				} else {
					set.add(s.charAt(j));
					len++;
				}				
			}
			uniSubstring = Math.max(len, uniSubstring);
			len = 0;
			set.clear();
		}
		return uniSubstring;
	}
}
