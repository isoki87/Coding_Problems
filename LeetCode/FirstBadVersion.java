package com.leo.interview;

/*
 * You are a product manager, unfortunately, the latest version of your product fails the QC.
 * Since each version is developeed based on the previous version, all versions AFTER a bad version are also bad
 * 
 * Suppose you have n versions [1, 2, ... n] and you want to find the first bad one, which causes all the following 
 * ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether the version is bad.
 * Implement a function to find the first bad version, you should minimize the number of calls to the API
 */

public class FirstBadVersion {
	public static void main(String[] args){
		FirstBadVersion a = new FirstBadVersion();
		int[] arr1 = new int[]{-1, -1, -1, -1, -1};
		System.out.println("Expect 0: " + a.findFirstBad(arr1));
		int[] arr2 = new int[]{1, -1, -1, -1, -1};
		System.out.println("Expect 1: " + a.findFirstBad(arr2));
		int[] arr3 = new int[]{1, 2, -1, -1, -1};
		System.out.println("Expect 2: " + a.findFirstBad(arr3));
		int[] arr4 = new int[]{1, 2, 3, -1, -1};
		System.out.println("Expect 3: " + a.findFirstBad(arr4));
		int[] arr5 = new int[]{1, 2, 3, 4, -1};
		System.out.println("Expect 4: " + a.findFirstBad(arr5));
	}
	
	public int findFirstBad(int[] versions){
			return findFirstBadInternal(versions, 0, versions.length - 1);
	}
	
	private int findFirstBadInternal(int[] arr, int start, int end){
		if(end <= start){
			return start;
		}
		int mid = (start + end) / 2;	
		if(isBadVersion(arr[mid]) && mid == 0){
			return mid;
		}
		if(isBadVersion(arr[mid]) && !isBadVersion(arr[mid - 1])){
			return mid;
		}
		if(isBadVersion(arr[mid])){
			return findFirstBadInternal(arr, start, mid - 1);
		} else {
			return findFirstBadInternal(arr, mid + 1, end);
		}		
	}
	
	private boolean isBadVersion(int n){
		if(n == -1){
			return true;
		}
		return false;
	}
}
