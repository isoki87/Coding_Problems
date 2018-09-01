package com.leo.interview;

/*
 * You are playing the following Bulls and Cows game with your friend: You write down a number 
 * and ask your friend to guess what the number is. Each time your friend makes a guess, you 
 * provide a hint that indicates how many digits in said guess match your secret number exactly 
 * in both digit and position (called "bulls") and how many digits match the secret number but 
 * locate in the wrong position (called "cows"). Your friend will use successive guesses and hints 
 * to eventually derive the secret number.
 * 
 * For example:
 * Secret number: "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, 
 * use A to indicate the bulls and B to indicate the cows. In the above example, 
 * your function should return "1A3B".
 */

import java.util.HashMap;

public class BullsAndCows {
	private String ans;
	private HashMap<Character, Integer> ansMap;
	
	public BullsAndCows(String ans){
		this.ans = ans;
		this.ansMap = new HashMap<>();
	}
	
	public String guess(String s){
		//Have a position check
		//return the strings to be processed
		initializeMap();
		int cowsAndBulls = countCheck(s);
		int bulls = positionCheck(s);
		int cows = cowsAndBulls - bulls;
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(bulls));
		sb.append('A');
		sb.append(Integer.toString(cows));
		sb.append('B');
		return sb.toString();
	}
	
	private void initializeMap(){
		for(int i = 0; i < ans.length(); i++){
			if(ansMap.containsKey(ans.charAt(i))){
				ansMap.put(ans.charAt(i), ansMap.get(ans.charAt(i)) + 1);
			} else {
				ansMap.put(ans.charAt(i), 1);
			}			
		}
	}
	
	private int positionCheck(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ans.charAt(i)){
				count++;
			}
		}
		return count;
	}
	
	private int countCheck(String s){
		int count = 0;		
		for(int i = 0; i < s.length(); i++){
			if(ansMap.containsKey(s.charAt(i))){
				count++;
				if(ansMap.get(s.charAt(i)) == 1){
					ansMap.remove(s.charAt(i));
				} else {
					ansMap.put(s.charAt(i), ansMap.get(s.charAt(i)) - 1);
				}
			}
		}		
		return count;
	}
	
	
	public static void main(String[] args){
		BullsAndCows game = new BullsAndCows("cactus");
		System.out.println("Expect 2A1B: " + game.guess("cat"));
		System.out.println("Expect 6B: " + game.guess("suacct"));
	}
}
