package com.leo.interview;

/*
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid
 */
//o o o o e, k = 3, empty = 4, end = 4
//o e o o, k = 1, empty = 1, end = 3
//o o o o o e o, k = 5, empty = 5, end = 6
//o e o o, k = 3, empty = 1, end = 3
//o e, k = 1, empty = 1, end = 1
//e o, k = 2, empty = 0, end = 1

public class KthLargestUnsorted {
	public static void main(String[] args){
		KthLargestUnsorted a = new KthLargestUnsorted();
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("Expect 1: " + a.quickSelect(arr, 5));
		arr = new int[]{10, 4, 8, 3, 2};
		System.out.println("Expect 3: " + a.quickSelect(arr, 4));
		arr = new int[]{60, 1, 3, 7, 10, 8, 200};
		System.out.println("Expect 7: " + a.quickSelect(arr, 5));
		arr = new int[]{3, 2, 10, 8};
		System.out.println("Expect 3: " + a.quickSelect(arr, 3));
		arr = new int[]{10, 1};
		System.out.println("Expect 10: " + a.quickSelect(arr, 1));
		arr = new int[]{1, 10};
		System.out.println("Expect 1: " + a.quickSelect(arr, 2));
		arr = new int[]{10, 1};
		System.out.println("Expect 1: " + a.quickSelect(arr, 2));
	}
	
	public int quickSelect(int[] arr, int k){
		return quickSelectInternal(arr, k, 0, arr.length - 1);
	}

	private int quickSelectInternal(int[] arr, int k, int start, int end){
		int pivot = arr[start];
		int empty = start;
		int l = start + 1;
		int r = end;
		int mid;
		while(l <= r){
			mid = (l + r) / 2;
			if(empty <= mid){
				if(arr[r] <= pivot){
					arr[empty] = arr[r];
					empty = r;
					r--;
				} else {
					r--;
				}
      } else {
				if(arr[l] > pivot){
					arr[empty] = arr[l];
					empty = l;
					l++;
				} else {
					l++;
				}
			}
		}
		arr[empty] = pivot;
		if(k == end - empty + 1){
			return arr[empty];
		} else if (k > end - empty + 1){
			//k is on the left side
			k -= (end - empty + 1);
			return quickSelectInternal(arr, k, start, empty - 1);
		} else {
			return quickSelectInternal(arr, k, empty + 1, end);
		}	
	}
}
