package com.leo.interview;

import java.util.Arrays;

/*
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to comptue the reseracher's h-index. A scientist has index h if
 * h of his/her N papers have at least h citations each, and the other N-h papers have 
 * no more than h citations each.
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5
 * papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, his h-index is 3.
 */

//[0] is 0
//[0, 1, 3, 5, 6] is 3
//[0, 0, 0] is 0
//[1, 1, 2, 3, 3] is 2
//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] is 5

public class H_Index {
	public static void main(String[] args){
		H_Index a = new H_Index();
		int[] arr1 = new int[]{0};
		System.out.println("Expect 0: " + a.findHIndex(arr1));
		int[] arr2 = new int[]{0, 1, 3, 5, 6};
		System.out.println("Expect 3: " + a.findHIndex(arr2));
		int[] arr3 = new int[]{0, 0, 0};
		System.out.println("Expect 0: " + a.findHIndex(arr3));
		int[] arr4 = new int[]{1, 1, 2, 3, 3};
		System.out.println("Expect 2: " + a.findHIndex(arr4));
		int[] arr5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Expect 5: " + a.findHIndex(arr5));
	}
	
	public int findHIndex(int[] citations){
		int hIndex = 0;
		if(citations == null || citations.length == 0){
			return hIndex;
		}
		Arrays.sort(citations);
		//Checked how many papers we have looked at
		//Check the paper under to see if it has less citations
		for(int i = 0; i < citations.length; i++){
			int atLeast = Math.min(citations[i], citations.length - i);
			hIndex = Math.max(hIndex, atLeast);
		}
		return hIndex;
	}
}
