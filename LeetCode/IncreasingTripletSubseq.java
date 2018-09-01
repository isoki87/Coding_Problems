package com.leo.interview;

/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array
 * [1, 2, 3, 4, 5]  returns true
 * [5, 4, 3, 2, 1]  returns false
 * [2, 3, 1, 4] return false
 */

public class IncreasingTripletSubseq {
	public static void main(String[] args){
		IncreasingTripletSubseq a = new IncreasingTripletSubseq();
		int[] arr1 = new int[]{1, 2, 3, 4, 5};
		System.out.println("Expect true: " + a.findTriplet(arr1));
		int[] arr2 = new int[]{5, 4, 3, 2, 1};
		System.out.println("Expect false: " + a.findTriplet(arr2));
		int[] arr3 = new int[]{2, 3, 1, 4};
		System.out.println("Expect false: " + a.findTriplet(arr3));
		int[] arr4 = new int[]{5, 10, 1, 2};
		System.out.println("Expect false: " + a.findTriplet(arr4));
		int[] arr5 = new int[]{22, 10, 2, 3, 4};
		System.out.println("Expect true: " + a.findTriplet(arr5));
		int[] arr6 = new int[]{11, 40, 2, 3, 4, 6};
		System.out.println("Expect true: " + a.findTriplet(arr6));
	}
	
	public boolean findTriplet(int[] arr){
		if(arr == null || arr.length < 3){
			return false;
		}
		for(int i = 0; i < arr.length - 2; i++){
			if(arr[i] + 1 == arr[i + 1] && arr[i] + 2 == arr[i + 2]){
				return true;
			}
		}		
		return false;
	}
}
