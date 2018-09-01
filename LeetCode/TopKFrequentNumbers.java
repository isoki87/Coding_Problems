package com.leo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Given a non-empty array of integers, return the k most frequent elements
 */

public class TopKFrequentNumbers {
	public static void main(String[] args){
		TopKFrequentNumbers a = new TopKFrequentNumbers();
		int[] arr1 = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6};
		List<Integer> list1 = a.kMostFrequent(arr1, 2);
		System.out.println("Expect 5: " + list1.get(0));		
	}
	
	public List<Integer> kMostFrequent(int[] arr, int k){
		Arrays.sort(arr);
		List<Integer>[] occ = new List[arr.length];
		int currNum = 1;
		
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] != arr[i + 1]){
				if(occ[currNum] == null){
					occ[currNum] = new ArrayList<Integer>();
				}
				occ[currNum].add(arr[i]);
				currNum = 1;	
			} else {
				currNum++;
			}			
		}
		if(arr[arr.length - 2] != arr[arr.length -1]){
			if(occ[currNum] == null){
				occ[currNum] = new ArrayList<Integer>();
			}
			occ[currNum].add(arr[arr.length - 2]);
			if(occ[1] == null){
				occ[1] = new ArrayList<Integer>();
			}
			occ[1].add(arr[arr.length - 1]);
		} else {
			if(occ[currNum] == null){
				occ[currNum] = new ArrayList<Integer>();
			}
			occ[currNum].add(arr[arr.length - 1]);
		}
		
		
		for(int i = occ.length - 1; i >= 0; i--){			
			if(occ[i] == null){
				continue;
			}
			if(k == 1){
				return occ[i];
			}
			k--;
		}		
		
		return null;
	}
}
