package com.leo.interview;

/*
 * Given an array of words and a length L, format the text such that each
 * line has exactly L characters and is fully (left and right) justified.
 * Pack your words in a greedy approach, that is, pack as many words as you can 
 * in each line, pad extra spaces ' ' when necessary so that each line has 
 * exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces that the slots on the right.
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Example ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16
 * 
 * Return:
 * [
 * "This is an",
 * "example of text",
 * "justification. "
 * ]
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TextJustification {
	public static void main(String[] args){
		TextJustification a = new TextJustification();
		String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(Arrays.toString(a.justifyWords(words, 16).toArray()));
	}
	
	public List<String> justifyWords(String[] words, int len){
		List<String> results = new ArrayList<>();
		StringBuilder line = new StringBuilder();
		int i = 0;
		int lineLen = 0;
		while(i < words.length){
			if(lineLen == 0 && lineLen + words[i].length() < len){
				line.append(words[i]);
				lineLen += words[i].length();
				i++;
			} else if(lineLen + words[i].length() + 1 < len){
				line.append(" ");
				line.append(words[i]);
				lineLen += words[i].length() + 1;
				i++;
			} else {
				results.add(line.toString());
				line.setLength(0);
				lineLen = 0;
			}
		}
		results.add(line.toString());
		return results;		
	}	
}
