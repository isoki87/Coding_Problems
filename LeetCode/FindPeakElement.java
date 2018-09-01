package com.leo.interview;

/*
 * A peak element is an element that is greater than its neighbors
 * Given an input array where num[i] != num[i+1], find a peak element and return its index
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine
 * 
 * You may imagine that num[-1] = num[n] = integer.min_value. 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return index number 2
 */

public class FindPeakElement {
	public static void main(String[] args){
		FindPeakElement a = new FindPeakElement();
		int[] arr1 = new int[]{1, 2, 3, 1};
		System.out.println("Expect 2: " + a.findPeak(arr1));
		int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println("Expect -1: " + a.findPeak(arr2));
		int[] arr3 = new int[]{2, 6, 3, 1, 3, 7};
		System.out.println("Expect 1: " + a.findPeak(arr3));		
	}
	
	public int findPeak(int[] arr){
		int peak = -1;
		for(int i = 0; i < arr.length; i++){
			if(i == 0 || i == arr.length - 1){
				continue;
			}
			if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
				peak = i;
				break;
			}
		}
		return peak;
	}	
}
