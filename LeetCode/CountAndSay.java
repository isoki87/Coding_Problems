package com.leo.interview;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows
 * 1, 11, 21, 1211, 111221
 * 
 * 1 is read off as "one 1" or 11
 * 11 is read off as "two 1s" or 21
 * 21 is read off as "one 2, then one 1", or 1211
 * 
 * 111221
 * 312211
 * 
 * Given an integer n, generate the nth sequence
 */

public class CountAndSay {
	public static void main(String[] args){
		CountAndSay a = new CountAndSay();
		System.out.println("Expect 1: " + a.play(1));
		System.out.println("Expect 11: " + a.play(2));
		System.out.println("Expect 21: " + a.play(3));
		System.out.println("Expect 1211: " + a.play(4));
	  System.out.println("Expect 111221: " + a.play(5));
		System.out.println("Expect 312211: " + a.play(6));
		System.out.println("Expect 13112221: " + a.play(7));
		System.out.println("Expect 1113213211: " + a.play(8));
	}
	
	public String play(int n){
		if(n <= 0){
			return null;
		}
		return playInternal("1", n - 1);
	}
	
	private String playInternal(String seq, int n){
		if(n == 0){
			return seq;
		}
		StringBuilder sb = new StringBuilder();

		int count = 1;
		for(int i = 0; i < seq.length() - 1; i++){
			if(seq.charAt(i) == seq.charAt(i + 1)){
				count++;
			} else {
				sb.append(Integer.toString(count));
				sb.append(seq.charAt(i));
				count = 1;
			}			
		}
		if(seq.length() == 1){
			sb.append('1');
			sb.append(seq);
		} else if(seq.length() > 1){
			sb.append(Integer.toString(count));
			sb.append(seq.charAt(seq.length() - 1));
		}
		return playInternal(sb.toString(), n - 1);
	}
	
}
