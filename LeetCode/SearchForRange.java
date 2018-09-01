package com.leo.interview;

import java.util.Arrays;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value
 * Your algorithm MUST have a run time of O(log n). 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, [5, 7, 7, 8, 8, 10] with the target value 8 will return [3, 4]
 */

public class SearchForRange {
	public static void main(String[] args){
		SearchForRange a = new SearchForRange();
		int[] arr1 = new int[]{5, 7, 7, 8, 8, 10};
		System.out.println("Expect [3, 4]: " + Arrays.toString(a.findRange(arr1, 8)));
		int[] arr2 = new int[]{6, 6, 6, 6, 6, 6, 6};
		System.out.println("Expect [0, 6]: " + Arrays.toString(a.findRange(arr2, 6)));
		System.out.println("Expect [-1, -1]: " + Arrays.toString(a.findRange(arr2, 1)));
	}
	
	public int[] findRange(int[] arr, int tar){
		//O(log n) suggest binary search
		//Binary search for the target first, once found, binary search for the range
		//Once the target is found, find the midpoint between target and start or target and end.
		//The border point between the target and the non-target will be the boundary
		int tarIndex = findTarget(arr, tar, 0, arr.length - 1);		
		int[] range = new int[2];
		System.out.println(tarIndex);
		if(tarIndex == -1){
			return new int[]{-1, -1};
		} else {
			range[0] = findLeftBound(arr, tar, 0, tarIndex);
			range[1] = findRightBound(arr, tar, tarIndex, arr.length - 1);
		}	
		return range;		
	}
	
	private int findTarget(int[] arr, int tar, int start, int end){
		int mid = (start + end) / 2;
		if(end < start){
			return -1;
		}
		if(arr[mid] == tar){
			return mid;
		}
		if(arr[mid] > tar){
			return findTarget(arr, tar, start, mid - 1);
		} else {
			return findTarget(arr, tar, mid + 1, end);
		}		
	}
	
	private int findLeftBound(int[] arr, int tar, int start, int end){
		if(start >= end){
			return start;
		}
		int mid = (start + end) / 2;
		//Check if we're on the border
		if(arr[mid] == tar){
			if(arr[mid] != arr[mid - 1]){
				return mid;
			}
			return findLeftBound(arr, tar, start, mid - 1);
		} else {
			return findLeftBound(arr, tar, mid + 1, end);
		}
	}
	
	private int findRightBound(int[] arr, int tar, int start, int end){
		if(start >= end){
			return end;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == tar){
			if(arr[mid] != arr[mid + 1]){
				return mid;
			}
			return findRightBound(arr, tar, mid + 1, end);
		} else {
			return findRightBound(arr, tar, start, mid - 1);
		}
	}

}
