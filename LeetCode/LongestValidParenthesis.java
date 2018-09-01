package com.leo.interview;

import java.util.LinkedList;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

public class LongestValidParenthesis {
	public static void main(String[] args){
		LongestValidParenthesis a = new LongestValidParenthesis();
		String s1 = "()(()((((()))";
		System.out.println("Expect 6: " + a.longestParenthesis(s1));
		String s2 = "(()())";
		System.out.println("Expect 6: " + a.longestParenthesis(s2));
		String s3 = "()(()((((())))))";
		System.out.println("Expect 16: " + a.longestParenthesis(s3));
		String s4 = ")(()";
		System.out.println("Expect 2: " + a.longestParenthesis(s4));
		String s5 = "()()";
		System.out.println("Expect 4: " + a.longestParenthesis(s5));
	}
	
	
	public int longestParenthesis(String s){
		int max = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		stack.add(-1);
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				stack.add(i);
			} else {
				stack.removeLast();
				if(stack.isEmpty()){
					stack.add(i);
				} else {
					max = Math.max(max,  i - stack.peekLast());
				}
			}
		}
		return max;
	}
}
