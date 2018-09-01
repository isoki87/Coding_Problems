package com.leo.interview;

/*
 * Given an array and a target sum
 * Find three integers from the array such their sum is closest to the target
 * Output the sum
 */

public class ThreeSumClosest {
	public static void main(String[] args){
		
	}
	
	public int findThreeSum(int[] arr, int target){
		int result = Integer.MIN_VALUE;
		int l, r;
		for(int i = 0; i < arr.length - 2; i++){
			l = i + 1;
			r = arr.length - 1;
			while(l < r){
				int sum = arr[i] + arr[l] + arr[r];
				if(sum == target){
					return result;
				} else if(sum > target){
					if(Math.abs(sum - target) < Math.abs(result - target)){
						result = sum;
					}
					r--;
				} else if(sum < target){
					if(Math.abs(sum - target) < Math.abs(result - target)){
						result = sum;
					}
					l++;
				}
			}
		}
		return result;
	}
}
