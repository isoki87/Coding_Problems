package com.leo.interview;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string
 */

import java.util.Set;
import java.util.HashSet;

public class ReverseVowels {
	public static void main(String[] args){
		ReverseVowels a = new ReverseVowels();
		System.out.println("Expect \"testing\" to \"tisteng\": " + a.reverseVowels("testing"));
		System.out.println("Expect \"lalidum\" to \"lulidam\": " + a.reverseVowels("lalidum"));
		System.out.println("Expect \"kea\" to \"kae\": " + a.reverseVowels("kea"));
	}
	
	public String reverseVowels(String s){
		char[] charArr = s.toCharArray();
		Set<Character> set = initializeSet();
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			if(!set.contains(charArr[i])){
				i++;
				continue;
			}
			if(!set.contains(charArr[j])){
				j--;
				continue;
			}
			char temp = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = temp;	
			i++;
			j--;
		}
		return new String(charArr);
	}
	
	private Set<Character> initializeSet(){
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		return set;		
	}
}
