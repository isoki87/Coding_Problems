package com.leo.interview;

/*
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that
 * the concatenation of the two words, words[i] + words[j] is a palindrome
 * 
 * ["bat", "tab", "cat"]
 * returns [[0, 1], [1, 0]]
 * Palindromes are "battab" and "tabbat"
 * 
 * ["whale", "what", "cat", "atatac", "cake"]
 *
 * 
 * returns [[0, 1]]
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePairs {
	public static void main(String[] args){
		PalindromePairs a = new PalindromePairs();
		String[] list1 = new String[]{"bat", "tab", "cat"};
		List<int[]> ans1 = a.findPalinPairs(list1);
		System.out.println("Expect [0, 1]: " + Arrays.toString(ans1.get(0)));
		System.out.println("Expect [1, 0]: " + Arrays.toString(ans1.get(1)));
		String[] list2 = new String[]{"whale", "what", "cat", "atatac", "cake"};
		List<int[]> ans2 = a.findPalinPairs(list2);
		System.out.println("Expect [2, 3]: " + Arrays.toString(ans2.get(0)));
	}
	
	public List<int[]> findPalinPairs(String[] list){
		if(list == null || list.length == 0){
			return null;
		}
		List<int[]> results = new ArrayList<int[]>(); 
		for(int i = 0; i < list.length - 1; i++){
			for(int j = i + 1; j < list.length; j++){
				if(arePalindromes(list[i], list[j])){
					int[] temp = new int[]{i, j};
					int[] temp2 = new int[]{j, i};
					results.add(temp);
					results.add(temp2);
				}
			}
		}
		return results;		
	}
	
	private boolean arePalindromes(String s, String t){
		String newString = s + t;
		int i = 0;
		int j = newString.length() - 1;
		
		while(i <= j){
			if(newString.charAt(i) != newString.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;		
	}
}
