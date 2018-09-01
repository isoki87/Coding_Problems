package com.leo.interview;

/*
 * Given two strings s and t, determine if they are both one edit apart
 */

public class OneEditDistance {
	public static void main(String[] args){
		OneEditDistance a = new OneEditDistance();
		String s1 = "cake";
		String t1 = "ake";
		System.out.println("Expect true: " + a.oneEditOff(s1, t1));
		String s2 = "cake";
		String t2 = "caker";
		System.out.println("Expect true: " + a.oneEditOff(s2, t2));
		String s3 = "interviewing";
		String t3 = "intrrviewing";
		System.out.println("Expect true: " + a.oneEditOff(s3, t3));
		String s4 = "interviews";
		String t4 = "intervieo";
		System.out.println("Expect false: " + a.oneEditOff(s4, t4));
		String s5 = "conglomeration";
		String t5 = "conglmeration";
		System.out.println("Expect true: " + a.oneEditOff(s5, t5));		
	}
	
	public boolean oneEditOff(String s, String t){
		if(s == null || t == null){
			return false;
		}
		if(s.length() - t.length() > 1 || s.length() - t.length() < -1){
			return false;
		}

		boolean flagOne = false;
		if(s.length() == t.length()){
			int i = 0;
			while(i < s.length()){
				if(flagOne && s.charAt(i) != t.charAt(i)){
					return false;
				}
				if(s.charAt(i) != t.charAt(i)){
					flagOne = true;
				}				
				i++;
			}			
		} else {
			String longer = (s.length() > t.length()) ? s : t;
			String shorter = (s.length() > t.length()) ? t : s;
			int i = 0;
			int j = 0;
			while(i < shorter.length() && j < longer.length()){
				if(flagOne && shorter.charAt(i) != longer.charAt(j)){
					return false;
				}
				if(shorter.charAt(i) != longer.charAt(j)){
					j++;
					flagOne = true;
					continue;
				}
				i++;
				j++;
			}			
		}
		return true;
	}
}
