package com.leo.interview;

/*Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.
For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?*/

public class ReverseWordsString {
	public static void main(String[] args){
		ReverseWordsString t = new ReverseWordsString();
		String s1 = "i like cake";
		System.out.println(s1 + " is now " + t.reverseWords(s1));
		String s2 = "this is a bug";
		System.out.println(s2 + " is now " + t.reverseWords(s2));
		String s3 = "the sky is blue";
		System.out.println(s3 + " is now " + t.reverseWords(s3));
	}
	
	//"i like cake" "cake like i"
	//"this is a bug" "bug a is this"
	public String reverseWords(String s){
		String str = reverse(s, 0, s.length() - 1);
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				sb.append(reverse(str, j, i - 1));
				sb.append(' ');
				j = i + 1;
			}
		}
		sb.append(reverse(str, j, str.length() - 1));
		return sb.toString();
	}
	
	private String reverse(String s, int start, int end){
		StringBuilder sb = new StringBuilder();
		for(int i = end; i >= start; i--){ 
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
