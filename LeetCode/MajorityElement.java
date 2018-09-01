package com.leo.interview;

/*
 * Given an array of size n, find the majority element
 * Majority element is the element that appears more than n/2 times
 * Assume the array is non-empty and the majority element always exists in array
 */

import java.util.HashMap;

public class MajorityElement {
	public static void main(String[] args){
		int[] arr1 = new int[]{1, 2, 4, 5, 5, 5, 5, 5, 5, 5};
		int[] arr2 = new int[]{1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 5};
		MajorityElement a = new MajorityElement();
		System.out.println("Expect 5: " + a.findMajorityNaive(arr1));
		System.out.println("Expect 5: " + a.findMajorityLinear(arr1));
		System.out.println("Expect 5: " + a.findMajorityLinear(arr2));
	}
	
	public int findMajorityNaive(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i]) + 1);
				if(map.get(arr[i]) > arr.length / 2){
					return arr[i];
				}
			} else {
				map.put(arr[i], 1);
			}
		}		
		return -1;
	}	
	
	public int findMajorityLinear(int[] arr){
		//since there will be always more than half elements as majority
		int result = 0;
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(count == 0){
				result = arr[i];
				count++;
			} else if(result == arr[i]){
				count++;
			} else {
				count--;
			}
		}
		return result;
	}
}
