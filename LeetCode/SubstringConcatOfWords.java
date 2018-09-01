package com.leo.interview;

/*
 * Given a string s, and a list of words (WORDS) that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concat of each word in WORDS
 * exactly once and without any intervening characters
 * 
 * Given s = "barfoothefoobarman" & WORDS = ["foo", "bar"], return [0, 9]
 */

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class SubstringConcatOfWords {
	public static void main(String[] args){
		SubstringConcatOfWords a = new SubstringConcatOfWords();
		String s1 = "barfoothefoobarman";
		int[] ans = a.findConcatSubstring(s1, new String[]{"foo", "bar"});
		System.out.println(Arrays.toString(ans));				
	}
	
	public int[] findConcatSubstring(String s, String[] list){
		if(s == null || s.length() == 0){
			return null;
		}
		ArrayList<Integer> results = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < list.length; i++){
			set.add(list[i]);
		}
		//this tells me how long each word is in WORD
		int len = list[0].length();
		
		for(int i = 0; i <= s.length() - len; i++){
			initializeSet(set, list);
			if(isSubstring(s, set, i, len)){
				results.add(i);
			}
		}
		int[] result = new int[results.size()];
		for(int i = 0; i < results.size(); i++){
			result[i] = results.get(i);
		}
		return result;
	}
	
	private boolean isSubstring(String s, HashSet<String> set, int start, int len){
		while(!set.isEmpty() && start <= s.length() - len){
			String a = s.substring(start, start + len);
			if(set.contains(a)){
				set.remove(a);
			} else {
				return false;
			}	
			start += (len);
		}	
		return true;
	}
	
	private void initializeSet(HashSet<String> set, String[] list){
		for(int i = 0; i < list.length; i++){
			set.add(list[i]);
		}
	}

}
