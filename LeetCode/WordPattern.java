package com.leo.interview;

import java.util.HashMap;
//TRY THE VERSION WHERE SPACE SEPARATES THE WORDS
/*
 * Given a pattern and a string str, find if str follows the same pattern
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * 
 * pattern = "abab", str = "redblueredblue" is true
 * pattern = "aaaa", str = "asdasdasdasd" is true
 * pattern = "aabb", str = "xyzabcxyzabc" is false 
 * pattern = "abcb", str = "xyzabcijkabc" is true
 * pattern = "abcd", str = "hilolcakepop" is true
 * pattern = "abab", str = "hihithihit" is true
 */

public class WordPattern {
	public static void main(String[] args){
		WordPattern a = new WordPattern();
		String s1 = "red blue red blue";		
		String p1 = "abab";
		System.out.println("Expect true: " + a.followsPattern(s1, p1));
		String s2 = "asd asd asd asd";		
		String p2 = "aaaa";
		System.out.println("Expect true: " + a.followsPattern(s2, p2));
		String s3 = "xyz abc xyz abc";		
		String p3 = "aabb";
		System.out.println("Expect false: " + a.followsPattern(s3, p3));
		String s4 = "xyz abc ijk abc";		
		String p4 = "abcb";
		System.out.println("Expect true: " + a.followsPattern(s4, p4));
		String s5 = "hi lol cake pop";		
		String p5 = "abcd";
		System.out.println("Expect true: " + a.followsPattern(s5, p5));
		String s6 = "hi hit hi hit";		
		String p6 = "abab";
		System.out.println("Expect true: " + a.followsPattern(s6, p6));
	}
	
	public boolean followsPattern(String str, String patt){
		String[] strArr = str.split(" ");
		HashMap<String, Character> map = new HashMap<>();
		int pattIndex = 0;
		
		for(int i = 0; i < strArr.length; i++){
			if(map.containsKey(strArr[i])){
				if(map.get(strArr[i]) != patt.charAt(pattIndex)){
					return false;
				}
			} else {
				map.put(strArr[i], patt.charAt(pattIndex));
			}
			pattIndex++;
		}
		return true;
	}
	
	//Break my string down into components first;
	//So first, i need to find if there is a pattern in the string where substring is repeated
	//If it's ab pattern, how do i distinguish a from b.
	
	//Map pattern to components
	//Go through the pattern and put together a new string
	//If end string.equals(s) then return true
	
	
	//THIS IS THE LEETCODE SOLUTION STUDY WHY THIS WORKS
	/*
	public boolean followsPattern(String str, String pattern) {
    if(pattern.length()==0 && str.length()==0)
        return true;
    if(pattern.length()==0)
        return false;
 
    HashMap<Character, String> map = new HashMap<Character, String>();
 
    return helper(pattern, str, 0, 0, map);
	}
	
	public boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map){
    if(i==pattern.length() && j==str.length()){
        return true;
    }
 
    if(i>=pattern.length() || j>=str.length())
        return false;
 
    char c = pattern.charAt(i);
    for(int k=j+1; k<=str.length(); k++){
        String sub = str.substring(j, k);
        if(!map.containsKey(c) && !map.containsValue(sub)){
            map.put(c, sub);
            if(helper(pattern, str, i+1, k, map))
                return true;
            map.remove(c);
        }else if(map.containsKey(c) && map.get(c).equals(sub)){
            if(helper(pattern, str, i+1, k, map))
                return true;
        }
    }
    return false;
	}*/
}
