package com.leo.interview;

/*
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of the largest rectangle
 * in the histogram.
 * 
 * 2 1 5 6 2 3
 * the largest rectangle will have an area of 10 units
 * height of 5 (5 and 6) and width of 2
 * 
 */

//Use a stack for O(n) time

public class LargestHistogramRectangle {
	public static void main(String[] args){
		LargestHistogramRectangle a = new LargestHistogramRectangle();
		int[] hist = new int[]{2, 1, 5, 6, 2, 3};
		System.out.println("Expect 10: " + a.largestArea(hist));
	}
	
	public int largestArea(int[] arr){
		if(arr == null || arr.length == 0){
			return 0;
		}
		int largestTotalArea = 0;
		int largestLocalArea = 0;
		int smallestLocalHeight = 0;
		int width = 0;
		for(int i = 0; i < arr.length - 1; i++){
			largestLocalArea = 0;
			smallestLocalHeight = arr[i];
			for(int j = i + 1; j < arr.length; j++){
				width = j - i + 1;
				smallestLocalHeight = Math.min(smallestLocalHeight, arr[j]);
				largestLocalArea = Math.max(largestLocalArea, width * smallestLocalHeight);
				largestTotalArea = Math.max(largestLocalArea, largestTotalArea);
			}		
		}
		return largestTotalArea;
	}
}
