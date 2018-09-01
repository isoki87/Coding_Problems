package com.leo.interview;

/*
 * Find the first occurence of needle in a haystack
 * If not found, return -1
 */

public class NeedleInHaystack {
	public static void main(String[] args){
		NeedleInHaystack a = new NeedleInHaystack();
		String haystack = "abcabcdegabcy";
		String needle = "abcy";
		System.out.println("Expect 9: " + a.findNeedle(haystack, needle));
	}
	
	public int findNeedle(String haystack, String needle){
		int index = -1;
		if(needle == null || haystack == null || needle.length() > haystack.length()){
			return index;
		}
		for(int i = 0; i <= haystack.length() - needle.length(); i++){
			int m = i;
			for(int j = 0; j < needle.length(); j++){
				if(needle.charAt(j) == haystack.charAt(m)){
					if(m - i == needle.length() - 1){
						return i;
					}
					m++;
				} else {
					break;
				}
			}
		}
		return index;
	}

}
