package com.leo.interview;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers, find two numbers such that they add up to a specific sum
 * num = {2, 7, 11, 15} sum = 9
 * return [0, 1]
 * num = {2, 11, 23, 55, 80, 92}
 * 
 */

public class TwoSum {
	public static void main(String[] args){
		
	}
	
	public List<int[]> findTwoSum(int[] arr, int sum){
		ArrayList<int[]> results = new ArrayList<>();
		int l = 0, r = arr.length - 1;
		while(l < r){
			if(arr[l] + arr[r] == sum){
				results.add(new int[]{l, r});
				l++;
				r--;
			} else if (arr[l] + arr[r] < sum){
				l++;
			} else {
				r--;
			}
		}		
		return results;
	}
	
}
