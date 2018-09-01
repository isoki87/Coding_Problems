package com.leo.interview;

/*
 * A sorted array is rotated at some pivot unknown to you.
 * Find the minimum element, you can assume no duplicates exists
 */

//1 2 3 4 5 6 7
//2 3 4 5 6 7 1
//3 4 5 6 7 1 2
//4 5 6 7 1 2 3
//5 6 7 1 2 3 4
//6 7 1 2 3 4 5
//7 1 2 3 4 5 6

public class RotatedArrayMin {
	public static void main(String[] args){
		RotatedArrayMin a = new RotatedArrayMin();
		int[] a1 = new int[]{1, 2, 3, 4, 5, 6, 7};
		int[] a2 = new int[]{2, 3, 4, 5, 6, 7, 1};
		int[] a3 = new int[]{3, 4, 5, 6, 7, 1, 2};
		int[] a4 = new int[]{4, 5, 6, 7, 1, 2, 3};
		int[] a5 = new int[]{5, 6, 7, 1, 2, 3, 4};
		int[] a6 = new int[]{6, 7, 1, 2, 3, 4, 5};
		int[] a7 = new int[]{7, 1, 2, 3, 4, 5, 6};
		System.out.println("Expect 1: " + a.findMin(a1));
		System.out.println("Expect 1: " + a.findMin(a2));
		System.out.println("Expect 1: " + a.findMin(a3));
		System.out.println("Expect 1: " + a.findMin(a4));
		System.out.println("Expect 1: " + a.findMin(a5));
		System.out.println("Expect 1: " + a.findMin(a6));
		System.out.println("Expect 1: " + a.findMin(a7));
	}
	
	public int findMin(int[] arr){		
		return findMinInternal(arr, 0, arr.length - 1);
	}	
	
	private int findMinInternal(int[] arr, int start, int end){
		int mid = (start + end) / 2;
		if(arr[start] < arr[end]){
			return arr[start];
		}
		if(end - start == 0){
			return arr[start];
		}
		if(end - start == 1){
			return Math.min(arr[start], arr[end]);
		}
		if(arr[end] < arr[mid]){
			return findMinInternal(arr, mid, end);
		} else {
			return findMinInternal(arr, start, mid);
		}	
	}
}
