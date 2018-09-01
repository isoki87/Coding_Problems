package com.leo.interview;

/*
 * Given a string, find the longest substring that contains only TWO unique characters.
 * For example, "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character
 * is "bcbbbbcccb"
 */

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringKUnique {
	public static void main(String[] args){
		LongestSubstringKUnique a = new LongestSubstringKUnique();
		String s1 = "abcbbbbcccbdddadacb"; 
		System.out.println("Expect bcbbbbcccb: " + a.longestSubstringWith(s1));
		String s2 = "acbbbbcaioel";
		System.out.println("Expect cbbbbc: " + a.longestSubstringWith(s2));
		String s3 = "aaaaaaabbbbbbb";
		System.out.println("Expect aaaaaaabbbbbbb: " + a.longestSubstringWith(s3));
	}
	
	
	//For each index in string, look at the subsequent characters till the end or till break condition
	//Break condition is when a third character shows up
	//When it shows up, remember the length of this substring WITH the start index in a map
	//Use the length to compare, at the end, find the longest length, and substring it with the start index
	public String longestSubstringWith(String s){
		if(s == null || s.length() == 0){
			return null;
		}

		//key: length of substring;
		//value: start index
		HashMap<Integer, Integer> lenMap = new HashMap<>();
		HashSet<Character> set = new HashSet<>();
		
		//Start the scan
		int len = 0;
		int longest = -1;
		int uni = 1;
		for(int i = 0; i < s.length() - 1; i++){
			uni = 1;
			set.add(s.charAt(i));
			len++;
			for(int j = i + 1; j < s.length(); j++){
				if(uni == 2 && !set.contains(s.charAt(j))){
					break;
				}
				if(set.contains(s.charAt(j))){
					len++;
				} else {
					set.add(s.charAt(j));
					uni++;
					len++;
				}
			}
			longest = Math.max(len, longest);
			lenMap.put(len, i);
			set.clear();
			len = 0;
		}
		// 0 1 2 3 4 5 6 7 
		if(longest == 1){
			return null;
		}
		String results = s.substring(lenMap.get(longest), longest + lenMap.get(longest));			
		return results;
	}
}
