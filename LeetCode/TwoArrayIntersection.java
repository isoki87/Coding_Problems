package com.leo.interview;

/*
 * Given two arrays, write a function to compute their intersection
 */

import java.util.Arrays;
import java.util.HashSet;


//Use a map if there are repeated numbers
public class TwoArrayIntersection {
	public static void main(String[] args){
		TwoArrayIntersection a = new TwoArrayIntersection();
		int[] arr1 = new int[]{1, 2, 3, 4, 5};
		int[] arr2 = new int[]{6, 7, 8, 9};
		System.out.println(Arrays.toString(a.findIntersection(arr1, arr2)));
	}
	
	public int[] findIntersection(int[] arr1, int[] arr2){
		HashSet<Integer> set1 = new HashSet<>();
		for(int i = 0; i < arr1.length; i++){
			set1.add(arr1[i]);
		}
		
		HashSet<Integer> set2 = new HashSet<>();
		for(int i = 0; i < arr2.length; i++){
			if(set1.contains(arr2[i])){
				set2.add(arr2[i]);
			}			
		}
		
		int[] results = new int[set2.size()];
		int i = 0;
		for(int num : set2){
			results[i++] = num;
		}
		return results;	
	}
}
