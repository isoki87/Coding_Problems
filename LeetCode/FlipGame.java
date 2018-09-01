package com.leo.interview;

/*
 * You are playing the following flip game with your friend:
 * Given a string that contains only the characters "+" and "-"
 * You and your friend take turns to flip two consecutive "++" into "--"
 * The game ends when a person can no longer make a move and therefore the other person wins
 * 
 * Write a function to compute all possible states of the string after one valid move
 */

import java.util.List;
import java.util.ArrayList;

public class FlipGame {
	public static void main(String[] args){
		FlipGame a = new FlipGame();
		String game = "++--++---++--++-+-++--";
		List<String> list = a.possibleMoves(game);
		System.out.println("Expect 5: " + list.size());
	}
	
	public List<String> possibleMoves(String s){
		List<String> list = new ArrayList<>();
		
		char[] cArr = s.toCharArray();
		for(int i = 0; i < cArr.length - 1; i++){
			if(cArr[i] == cArr[i + 1] && cArr[i] == '+'){
				cArr[i] = '-';
				cArr[i + 1] = '-';
				list.add(new String(cArr));
				cArr[i] = '+';
				cArr[i + 1] = '+';
			}
		}
		return list;
	}
}
