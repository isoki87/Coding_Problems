package com.leo.interview;

/*
 * There are N children standing in a line, each child is assigned a rating value.
 * You are giving candies to these children subjected to the following:
 * 1. Each child must have at least one candy
 * 2. Children with a higher rating get more candies than neighbors.
 * 
 * What is the minimum candies you must give?
 */

//10 kids with ratings 1, 5 with ratings 2, 7 with ratings 3
//3 with ratings 4, 5 with ratings 5.

public class Candy {
	public static void main(String[] args){
		
	}
	
	public int distribute(int[] kids){
		if(kids == null || kids.length == 0){
			return 0;
		}
		int[] candies = new int[kids.length];
		candies[0] = 1;
		
		//starting from the left
		for(int i = 1; i < kids.length; i++){
			if(kids[i] > kids[i - 1]){
				candies[i] = candies[i - 1] + 1;
			} else {
				//if number is not ascending, assign 1
				candies[i] = 1;
			}
		}
		
		int result = candies[kids.length - 1];
		
		//now start from right
		for(int i = kids.length - 2; i >= 0; i--){
			int curr = 1;
			if(kids[i] > kids[i + 1]){
				curr = candies[i + 1] + 1;
			}
			result += Math.max(curr,  candies[i]);
			candies[i] = curr;
		}
		return result;		
	}	
}
