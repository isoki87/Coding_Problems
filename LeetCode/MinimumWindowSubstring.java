package com.leo.interview;

/*
 * Given a string s and string t, find the minimum window in s which will contain all the characters in t in O(n) time
 * 
 * if S = "adobecodebanc", t = "abc", minimum window is "banc" - 4
 */

import java.util.HashMap;

public class MinimumWindowSubstring {
	public static void main(String[] args){
		MinimumWindowSubstring a = new MinimumWindowSubstring();
		String s1 = "adobecodebanc";
		String t = "abc";
		//System.out.println("Expect banc: " + a.findMinimumWindow(s1, t));		
		System.out.println("Expect banc: " + a.minWindow(s1, t));
		
		//THIS CASE BREAKS IT
		//UNDERSTAND THE NEW WAY
		String s2 = "aboooooociababc";
		System.out.println("Expect abc: " + a.minWindow(s2, t));
		//System.out.println("Expect abc: " + a.findMinimumWindow(s2, t));
		
	}
	
	//"aboooooociababc" t = "abc" - 3
	
	public String minWindow(String s, String t) {
    if(t.length()>s.length()) 
        return "";
    String result = "";
 
    //character counter for t
    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
    for(int i=0; i<t.length(); i++){
        char c = t.charAt(i);    
        if(target.containsKey(c)){
            target.put(c,target.get(c)+1);
        }else{
            target.put(c,1);  
        }
    }
 
    // character counter for s
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int left = 0;
    int minLen = s.length()+1;
 
    int count = 0; // the total of mapped characters
 
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
 
        if(target.containsKey(c)){
            if(map.containsKey(c)){
                if(map.get(c)<target.get(c)){
                    count++;
                }
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
                count++;
            }
        }
 
        if(count == t.length()){
            char sc = s.charAt(left);
            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                    map.put(sc, map.get(sc) - 1);
                left++;
                sc = s.charAt(left);
            }
 
            if (i - left + 1 < minLen) {
                result = s.substring(left, i + 1);
                minLen = i - left + 1;
            }
        }
    }
 
    return result;
}
	
	/*public String findMinimumWindow(String s, String t){
		HashMap<Character, Integer> tMap = new HashMap<>();
		initializeMap(tMap, t);
		boolean noScan = true;
		int start = 0;
		int window = s.length();
		HashMap<Integer, Integer> windowMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			if(tMap.containsKey(s.charAt(i)) && noScan){
				noScan = false;
				start = i;
			}
			if(tMap.containsKey(s.charAt(i))){
				int temp = tMap.get(s.charAt(i));
				if(temp == 1){
					tMap.remove(s.charAt(i));
				} else {
					tMap.put(s.charAt(i), temp - 1);
				}
			}
			if(tMap.isEmpty()){
				window = Math.min(window, i - start + 1);
				windowMap.put(window, start);
				noScan = true;
				initializeMap(tMap, t);
			}
		}	
		String result = s.substring(windowMap.get(window), window + windowMap.get(window));
		return result;
	}
	
	private void initializeMap(HashMap<Character, Integer> map, String t){
		for(int i = 0; i < t.length(); i++){
			if(map.containsKey(t.charAt(i))){
				int temp = map.get(t.charAt(i));
				map.put(t.charAt(i), temp + 1);
			} else {
				map.put(t.charAt(i), 1);
			}
		}
	}*/
}
