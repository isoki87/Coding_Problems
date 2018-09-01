package com.leo.interview;

import java.util.HashMap;
import java.util.LinkedList;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid. The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParenthesis {
	public static void main(String[] args){
		String s1 = "()()(){}{}[][]";
		ValidParenthesis a = new ValidParenthesis();
		System.out.println("Expect true: " + a.isValid(s1));
		String s2 = "(({{[()]}}))";
		System.out.println("Expect true: " + a.isValid(s2));
		String s3 = "({)}";
		System.out.println("Expect false: " + a.isValid(s3));
		String s4 = "(";
		System.out.println("Expect false: " + a.isValid(s4));
		String s5 = "()(";
		System.out.println("Expect false: " + a.isValid(s5));
	}
	
	public boolean isValid(String s){
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		LinkedList<Character> stack = new LinkedList<>();
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				stack.add(s.charAt(i));
			} else if(!stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')){
				char temp = stack.removeLast();
				if(map.containsKey(temp) && map.get(temp) == s.charAt(i)){
					continue;
				}
				return false;
			}
		}		
		return stack.isEmpty();
	}
}
