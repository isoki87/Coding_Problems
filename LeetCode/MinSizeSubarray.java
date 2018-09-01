package com.leo.interview;

/*
 * Given an array of n positive integers and a positive integer s, find the minmal length of a subarray
 * which the sum >= s. if there isn't one, return 0 instead
 * 
 * [2, 3, 1, 2, 4, 3] and s = 7 would return 2 since [4, 3] is the minimal subarray
 */

//Find all subarrays that will add up to s
//Group them based on size, put them in set (key size)
//for 1 - n, find the lowest number that exists in the size set

public class MinSizeSubarray {
	public static void main(String[] args){
		MinSizeSubarray a = new MinSizeSubarray();
		int[] arr = new int[]{2, 3, 1, 2, 4, 3};
		System.out.println("Expect 2: " + a.findMinSizeSub(arr, 7));
	}
	
	public int findMinSizeSub(int[] arr, int tar){
		if(arr == null || arr.length == 1){
			return 0;
		}
		int result = Integer.MAX_VALUE;
		int sum = 0;
		int j = 0;
		boolean found = false;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] >= tar){
				return 1;
			}
			sum += arr[i];
			while(sum >= tar){
				found = true;
				result = Math.min(result, i - j + 1);
				sum -= arr[j];
				j++;
			}
		}
		if(found){
			return result;
		}
		return 0;
	}
	
}
