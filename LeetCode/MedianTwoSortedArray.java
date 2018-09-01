package com.leo.interview;
/*There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).
 * 
 */

public class MedianTwoSortedArray {
	public static void main(String[] args){
		MedianTwoSortedArray a = new MedianTwoSortedArray();
		int[] arr1 = {1, 2, 5, 7, 10};
		int[] arr2 = {3, 4, 5, 9, 11};
		System.out.println("5 " + a.findMedian(arr1, arr2));
		arr1 = new int[]{1, 2, 5, 7, 10};
		arr2 = new int[]{3, 5};
		System.out.println("5 " + a.findMedian(arr1, arr2));	
		arr1 = new int[]{1, 2, 3, 4, 5};
		arr2 = new int[]{6, 7, 8, 9, 10};
		System.out.println("5.5 " +a.findMedian(arr1, arr2));	
		arr1 = new int[]{1};
		arr2 = new int[]{3};
		System.out.println("2 " + a.findMedian(arr1, arr2));
		arr1 = new int[]{1, 2};
		arr2 = new int[]{3};
		System.out.println("2 " + a.findMedian(arr1, arr2));

		
	}
	
	public double findMedian(int[] arr1, int[] arr2){
		int totalLen = arr1.length + arr2.length;
		if(totalLen % 2 == 0){
			//is even
			return ((findKthNumber(arr1, arr2, (totalLen / 2), 0, 0) + 
					findKthNumber(arr1, arr2, (totalLen / 2) - 1, 0, 0)) / 2.0);
		}
		//is odd
		return (double)findKthNumber(arr1, arr2, (totalLen / 2), 0, 0);
	}
	

	private int findKthNumber(int[] arr1, int[] arr2, int k, int s1, int s2){
		int m1 = (s1 + arr1.length) / 2;
		int m2 = (s2 + arr2.length) / 2;
		if(k == 0){
			return (Integer.min(arr1[s1], arr2[s2]));
		} else if (s1 >= arr1.length){
			return arr2[s2 + k];
		} else if (s1 == arr1.length - 1 && arr2[m2] > arr1[s1]){
			return arr2[s2 + k - 1];
		}	else if (s2 >= arr2.length){
			return arr1[s1 + k];
		} else if (s2 == arr2.length - 1 && arr1[m1] > arr2[s2]){
			return arr1[s1 + k - 1];
		}
		if(arr1[m1] > arr2[m2]){
			k -= (m2 - s2);
			return findKthNumber(arr1, arr2, k, s1, m2);
		} else {
			k -= (m1 - s1);
			return findKthNumber(arr1, arr2, k, m1, s2);
		}
	}
}
