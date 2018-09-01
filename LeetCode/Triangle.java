package com.leo.interview;

import java.util.ArrayList;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below
 * 
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * 
 * 
 *      1
 *   100 3 
 *    1 1 5 
 *   1 1 1 1
 *      
 * The minimum path sum from top to bottom is 11(2 + 3 + 5 + 1 = 11)
 * 
 * Can you try to do this in O(n) extra space, where n is the total number of rows in triangle?
 */

public class Triangle {
	public static void main(String[] args){
		int[][] tri = new int[4][];
		tri[0] = new int[]{2};
		tri[1] = new int[]{3, 4};
		tri[2] = new int[]{6, 5, 7};
		tri[3] = new int[]{4, 1, 8, 3};
		Triangle a = new Triangle();
		System.out.println("Expect 11: " + a.findMinSumPath(tri));
		int[][] tri2 = new int[4][];
		tri2[0] = new int[]{1};
		tri2[1] = new int[]{100, 3};
		tri2[2] = new int[]{1, 1, 5};
		tri2[3] = new int[]{1, 1, 1, 1};
		System.out.println("Expect 6: " + a.findMinSumPath(tri2));
	}
	
	public int findMinSumPath(int[][] triangle){
		//int[row][column]
		
		int lastRow = triangle.length - 1;
		ArrayList<Integer> sums = new ArrayList<>();
		for(int i = 0; i < triangle[lastRow].length; i++){
			findSumInternal(triangle, lastRow, i, 0, sums);
		}
		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < sums.size(); i++){
			minSum = Math.min(minSum, sums.get(i));
		}
		return minSum;
	}
	
	private void findSumInternal(int[][] triangle, int startRow, int startCol, int carriedSum, ArrayList<Integer> sums){
		if(startRow == 0){
			sums.add(carriedSum + triangle[0][0]);
			return;
		}
		if(startCol == 0){
			findSumInternal(triangle, startRow - 1, 0, carriedSum + triangle[startRow][0], sums);
		} else if(startCol == triangle[startRow].length - 1){
			findSumInternal(triangle, startRow - 1, startCol - 1, carriedSum + triangle[startRow][startCol], sums);
		} else {
			findSumInternal(triangle, startRow - 1, startCol, carriedSum + triangle[startRow][startCol], sums);
			findSumInternal(triangle, startRow - 1, startCol - 1, carriedSum + triangle[startRow][startCol], sums);
		}
	}
}
