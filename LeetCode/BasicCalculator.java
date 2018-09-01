package com.leo.interview;

/*
 * Implement a basic calculator to evaluate a simple expression string
 * The string can contain open ( and closing parenthesis ), the plus + or minus - signs, non-negative integers and empty spaces
 * You can assume the expression is always valid
 * 
 * "2 + 3 + 5 - 7" will be 3
 * "1 + 1" will be 2
 * "(1)" will be 1
 * "(1 - (4 - 5))" will be 2
 * "1 - (4 + (2 - (3 + 5)) + 7) + 10" will be 6
 * "- 1" will be -1
 * "(1 + (4 + 5 + 2) - 3) + (6 - 8)" will be 7
 * "(1 - ((2 - 4) + 8) - 8) + 20" will be 23
 */

import java.util.Stack;

public class BasicCalculator {
	public static void main(String[] args){
		BasicCalculator a = new BasicCalculator();
		String s1 = "2 + 3 + 5 - 7";
		String s2 = "1 + 1";
		String s3 = "(1)";
		String s4 = "(1 - (4 - 5))";
		String s5 = "1 - (4 + (2 - (3 + 5)) + 7) + 10";
		String s6 = "-1";
		String s7 = "(1 + (4 + 5 + 2) - 3) + (6 - 8)";
		String s8 = "(1 - ((2 - 4) + 8) - 8) + 19";
		System.out.println("Expect 3: " + a.calculate(s1));
		System.out.println("Expect 2: " + a.calculate(s2));
		System.out.println("Expect 1: " + a.calculate(s3));
		System.out.println("Expect 2: " + a.calculate(s4));
		System.out.println("Expect 6: " + a.calculate(s5));
		System.out.println("Expect -1: " + a.calculate(s6));
		System.out.println("Expect 7: " + a.calculate(s7));		
		System.out.println("Expect 6: " + a.calculate(s8));	
	}
	
	public int calculate(String s){
		s = s.trim();
		//Need a separate integer stack to handle numbers more than single digits
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < len; i++){
			if(Character.isDigit(s.charAt(i))){
				int sum = s.charAt(i) - '0';
				while(i + 1 < len && Character.isDigit(s.charAt(i + 1))){
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+'){
				sign = 1;
			} else if (s.charAt(i) == '-'){
				sign = -1;
			} else if (s.charAt(i) == '('){
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')'){
				result = result * stack.pop() + stack.pop();
			}
		}
		return result;
	}
}
