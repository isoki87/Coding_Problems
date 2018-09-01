package com.leo.interview;

/*
 * Given an array of strings, return all groups of strings that are anagrams
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GroupAnagrams {
	public static void main(String[] args){
		GroupAnagrams a = new GroupAnagrams();
		String[] strings = new String[]{"pans", "bonker", "kerbon", "cake", "ronbek", "kenrob", "cat", "snake"};
		List<List<String>> answer = a.findAnagrams(strings);
		System.out.println(answer.toString());
	}
	
	//Assume there is only one possible anagram
	public List<List<String>> findAnagrams(String[] strings){
		List<List<String>> results = new ArrayList<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		
		for(int i = 0; i < strings.length; i++){
			char[] ch = new char[26];
			for(int j = 0; j < strings[i].length(); j++){
				ch[strings[i].charAt(j) - 'a']++;				
			}
			String ns = new String(ch);
			if(map.containsKey(ns)){
				map.get(ns).add(strings[i]);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(strings[i]);
				map.put(ns, list);				
			}						
		}
		results.addAll(map.values());
		return results;				
	}
}
