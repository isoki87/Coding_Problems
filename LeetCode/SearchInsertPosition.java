package com.leo.interview;

/*
 * Given a sorted array and a target value, return the index if the target is found
 * If not, return the index where it would be if it were inserted in order, assume no duplicates
 */

public class SearchInsertPosition {
	public static void main(String[] args){
		SearchInsertPosition a = new SearchInsertPosition();
		int[] arr = new int[]{1, 2, 5, 6, 7};
		System.out.println("Expect 2: " + a.findInsert(arr, 4));
		System.out.println("Expect 3: " + a.findInsert(arr, 6));
	}
	
	//1, 2, 5, 6, 7; tar = 4
	
	//1, 2, 5, 6, 7; tar = 6
	
	public int findInsert(int[] arr, int tar){
		return insertBinarySearch(arr, tar, 0, arr.length - 1);
	}	
	
	private int insertBinarySearch(int[] arr, int tar, int start, int end){
		//Each time, look at the left and right of point, if the target is between the two
		//then it will take the index of the larger one
		
		int mid = (start + end) / 2;
		if(arr[mid] == tar){
			return mid;
		}
		if(mid != 0 && mid != arr.length - 1){
			if(arr[mid] < tar && arr[mid + 1] > tar){
				return arr[mid + 1];
			} else if(arr[mid] > tar && arr[mid - 1] < tar){
				return arr[mid - 1];
			}
		}
		//Two edge cases, since mid is not tar at this point
		if(mid == 0){
			return 0;
		}
		if(mid == arr.length){
			return arr.length;
		}
		//begin binary search
		if(arr[mid] > tar){
			return insertBinarySearch(arr, tar, start, mid - 1);
		} else {
			return insertBinarySearch(arr, tar, mid + 1, end);
		}
	}
}
