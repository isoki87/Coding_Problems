package com.leo.interview;

import java.util.Arrays;

/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, n, find the one that's missing
 * from the array, for example, given [0, 1, 3] return 2.
 */

public class MissingNumber {
	public static void main(String[] args){
		MissingNumber a = new MissingNumber();
		int[] arr1 = new int[]{0, 1, 3};
		System.out.println("Expect 2: " + a.findMissing(arr1));
		System.out.println("Expect 2: " + a.findMissing2(arr1));
		int[] arr2 = new int[]{0, 1, 2, 3, 4, 5};
		System.out.println("Expect -1: " + a.findMissing(arr2));
		System.out.println("Expect 2: " + a.findMissing2(arr1));
		int[] arr3 = new int[]{1, 2, 3, 4, 5};
		System.out.println("Expect 0: " + a.findMissing(arr3));
		System.out.println("Expect 2: " + a.findMissing2(arr1));
		int[] arr4 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9, 10};
		System.out.println("Expect 7: " + a.findMissing(arr4));
		System.out.println("Expect 2: " + a.findMissing2(arr1));
		int[] arr5 = new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Expect 1: " + a.findMissing(arr5));
		System.out.println("Expect 2: " + a.findMissing2(arr1));
	}
	
	public int findMissing(int[] arr){
		int num = -1;
		if(arr[0] != 0){
			return 0;
		}
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] + 1 != arr[i + 1]){
				num = arr[i] + 1;
				break;
			}		
		}		
		return num;
	}
	
	//0, 1, 2, 3, 4, 5, 6, 7, 8, 9 (indices)
	//0, 1, 2, 3 ,4, 5, 6, 8, 9, 10
	//0, 2, 3, 4, 5, 6, 7, 8, 9, 10
	
	public int findMissing2(int[] arr){
		Arrays.sort(arr);
		int l = 0;
		int r = arr.length;
		int mid = (l + r) / 2;
		
		while(l < r){
			mid = (l + r) / 2;
			if(arr[mid] > mid){
				//look left
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r;		
	}
}
