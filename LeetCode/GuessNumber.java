package com.leo.interview;

/*
 * We're playing a guessing game, the game is as follows:
 * I pick a number from 1 to n, you have to guess which number i picked
 * Everytime you guess wrong, i'll tell you whether the number is higher or lower
 * 
 * You have a predefined API guess(int num) which returns -1, 1, or 0;
 * 
 * -1: num is lower
 * 1: num is higher
 * 0: you win!
 * 
 * n = 10, i pick 6; output is 6.
 * 
 */

public class GuessNumber {
	private int number;

	public static void main(String[] args){
		GuessNumber a = new GuessNumber(6);
		System.out.println("Expect 6: " + a.findNumber(52));
	}
	
	public int findNumber(int max){
		return findNumberInternal(1, max);
	}
	
	private int findNumberInternal(int start, int end){
		if(start >= end){
			return start;
		}
		int mid = (start + end) / 2;
		if(guess(mid) == 0){
			return mid;
		} else if (guess(mid) == 1){
			return findNumberInternal(mid + 1, end);
		} else {
			return findNumberInternal(start, mid - 1);
		}		
	}
	
	GuessNumber(int num){
		this.number = num;
	}	
	
	public int guess(int guess){
		if(guess == number){
			return 0;
		} else if(guess < number){
			return 1;
		} else {
			return -1;
		}
	}
}
