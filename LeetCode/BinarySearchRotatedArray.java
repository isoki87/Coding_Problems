package com.leo.interview;

/*
 * Given a sorted array that is rotated at a pivot unknown to you
 * Find a target value, return -1 if not found, you can assume there are no duplicates
 */

//1 2 3 4 5
//2 3 4 5 1
//3 4 5 1 2
//4 5 1 2 3
//5 1 2 3 4

//tar is right, right is not rotated
//tar is right, right is rotated
//tar is left, left is not rotated
//tar is left, left is rotated

public class BinarySearchRotatedArray {
	public static void main(String[] args){
		int[] a1 = new int[]{1, 2, 3, 4, 5};
		int[] a2 = new int[]{2, 3, 4, 5, 1};
		int[] a3 = new int[]{3, 4, 5, 1, 2};
		int[] a4 = new int[]{4, 5, 1, 2, 3};
		int[] a5 = new int[]{5, 1, 2, 3, 4};
		BinarySearchRotatedArray a = new BinarySearchRotatedArray();
		System.out.println("Expect 0: " + a.rotatedBinarySearch(a1, 1));
		System.out.println("Expect 4: " + a.rotatedBinarySearch(a2, 1));
		System.out.println("Expect 3: " + a.rotatedBinarySearch(a3, 1));
		System.out.println("Expect 2: " + a.rotatedBinarySearch(a4, 1));
		System.out.println("Expect 1: " + a.rotatedBinarySearch(a5, 1));
		System.out.println("Expect -1: " + a.rotatedBinarySearch(a1, 6));
		System.out.println("Expect -1: " + a.rotatedBinarySearch(a2, 6));
		System.out.println("Expect -1: " + a.rotatedBinarySearch(a3, 6));
		System.out.println("Expect -1: " + a.rotatedBinarySearch(a4, 6));
		System.out.println("Expect -1: " + a.rotatedBinarySearch(a5, 6));
		
	}
	
	public int rotatedBinarySearch(int[] arr, int tar){
		if(arr.length == 0 || arr == null){
			return -1;
		}
		return rBSInternal(arr, 0, arr.length - 1, tar);	
	}
	
	private int rBSInternal(int[] arr, int beg, int end, int tar){
		int mid = (beg + end) / 2;
		if(beg > end){
			return -1;
		}
		if(arr[mid] == tar){
			return mid;
		}
		if(arr[beg] <= arr[mid]){
			if(arr[beg] <= tar && arr[mid] > tar){
				return rBSInternal(arr, beg, mid - 1, tar);
			} else {
				return rBSInternal(arr, mid + 1, end, tar);
			}
		} else {
			if(arr[mid] < tar &&  tar <= arr[end]){
				return rBSInternal(arr, mid + 1, end, tar);
			} else {
				return rBSInternal(arr, beg, mid - 1, tar);
			}
		}
			
	}
}
