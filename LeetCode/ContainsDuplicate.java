package com.leo.interview;

import java.util.HashSet;

/*
 * Given an array of integers, find if the array contains any duplicates.
 * Function will return true if any value appears at least twice in the array, and return false
 * if every element is distinct
 */

public class ContainsDuplicate {
	public static void main(String[] args){
		ContainsDuplicate a = new ContainsDuplicate();
		System.out.println(a.hasDupe(new int[]{1, 2, 3, 4, 5}));
		System.out.println(a.hasDupe(new int[]{1, 2, 5, 4, 5}));
	}
	
	public boolean hasDupe(int[] arr){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(set.contains(arr[i])){
				return true;
			} else {
				set.add(arr[i]);
			}		
		}		
		return false;
	}
}
