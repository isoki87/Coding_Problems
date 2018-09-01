package com.leo.interview;

/*
 * Implement an atoi
 * Consider the following cases:
 * 1. null or empty string
 * 2. white spaces
 * 3. +/- sign
 * 4. Calculate real value
 * 5. handle min & max (if the result is greater than integer's max)
 */

public class Atoi {
	public static void main(String[] args){
		Atoi a = new Atoi();
		String s = "92939";
		String t = "-28938";
		int p = a.doAtoi(s);
		int q = a.doAtoi(t);
		System.out.println(p);
		System.out.println(q);
	}
	
	public int doAtoi(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		//
		s = s.trim();
		boolean negative = (s.charAt(0) == '-');
		double result = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				result = result * 10 + (s.charAt(i) - '0');
			}
		}
		if(negative){
			result = -result;
		}
		if(result > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		} else if (result < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}		
		return (int)result;
	}

}
