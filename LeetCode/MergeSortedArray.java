package com.leo.interview;

import java.util.Arrays;

/*
 * Given two sorted integer arrays A and B, merge B into A as one array
 * You can assume that A has enough space to hold all elements from B
 * The number of elements in A is m and B is n
 */

public class MergeSortedArray {
	public static void main(String[] args){
		int[] a = new int[8];
		a[0] = 1;
		a[1] = 5;
		a[2] = 80;
		int[] b = new int[]{2, 3, 58, 70, 90};
		MergeSortedArray t = new MergeSortedArray();
		t.merge(a, b, 3, 5);
		System.out.println(Arrays.toString(a));
	}
	
	//1, 2, 3, 4
	//5, 6, 7, 8
	
	//1, 5, 80
	//2, 3, 58, 70, 90
	
	public void merge(int[] a, int[] b, int m, int n){
		int aIndex = m - 1;
		int bIndex = n - 1;
		int totalIndex = m + n - 1;
		while(totalIndex >= 0){
			if(aIndex < 0 || (bIndex >= 0 && b[bIndex] > a[aIndex])){
				a[totalIndex--] = b[bIndex--];
			} else {
				a[totalIndex--] = a[aIndex--];
			}

			System.out.println(aIndex);
		}		
	}
}
