package com.leo.interview;

import java.util.Arrays;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5, the result should be:
 * 
 * [
 *       [1],
 *      [1,1],
 *     [1,2,1],
 *    [1,3,3,1],
 *   [1,4,6,4,1]
 * ]
 * 
 * 
 * 
 */

public class PascalTriangle {
	public static void main(String[] args){
		PascalTriangle a = new PascalTriangle();
		int[][] triangle = a.generate(5);
		System.out.println(Arrays.toString(triangle[0]));
		System.out.println(Arrays.toString(triangle[1]));
		System.out.println(Arrays.toString(triangle[2]));
		System.out.println(Arrays.toString(triangle[3]));
		System.out.println(Arrays.toString(triangle[4]));
	}
	
	public int[][] generate(int numRows){
		if(numRows <= 0){
			return null;
		}
		int[][] triangle = new int[numRows][];
		for(int i = 0; i < numRows; i++){
			triangle[i] = new int[i + 1];
			if(i == 0){
				triangle[i][0] = 1;
			} else {
				triangle[i][0] = 1;
				triangle[i][i] = 1;
				if(i == 1){
					continue;
				}
				for(int j = 1; j < i; j++){
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
			}		
		}	
		return triangle;
	}
}
