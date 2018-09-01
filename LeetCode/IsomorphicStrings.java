package com.leo.interview;

import java.util.HashMap;

/*Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.

For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.*/

public class IsomorphicStrings {
	public static void main(String[] args){
		IsomorphicStrings i = new IsomorphicStrings();
		System.out.println(i.isIsomorphic("egg", "add"));
		System.out.println(i.isIsomorphic("foo", "bar"));
		System.out.println(i.isIsomorphic("egg", "ttr"));
	}
	//"egg" and "add" is true
	//"foo" and "bar" is not
	//"egg" and "ttr" is not
	//order matters
	
	public boolean isIsomorphic(String s, String t){
		if(s.length() != t.length() || s.length() == 0){
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				if(map.get(s.charAt(i)) != t.charAt(i)){
					return false;
				}
			} else {
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}
}
