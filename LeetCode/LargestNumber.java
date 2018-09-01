package com.leo.interview;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a list of non-negative integers, arrange them so they form the largest number
 * [3, 30, 34, 5, 9] will have the output 9534330
 * Have the output return as a string
 */

public class LargestNumber {
	public static void main(String[] args){
		int[] a1 = new int[]{3, 30, 34, 5, 9};
		LargestNumber a = new LargestNumber();
		System.out.println("Expect 9534330: " + a.sortStrings(a1));
	}
	
	public String sortStrings(int[] nums){
		String[] arr = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			arr[i] = String.valueOf(nums[i]);
		}
		//now i have my array of strings
		//sort them by concat
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);		
			}
		});
		
		System.out.println(Arrays.toString(arr));
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			sb.append(arr[i]);
		}		
		return sb.toString();
	}	
}
