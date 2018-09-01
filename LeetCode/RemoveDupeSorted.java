package com.leo.interview;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Given a sorted array, remove dupe in place such that each element appear only once
 * return the new length, don't use extra space
 * [1, 1, 2] should return len = 2, A is now [1,2]
 */

public class RemoveDupeSorted {
	public static void main(String[] args){
		int[] a1 = new int[]{1, 1, 2};
		int[] a2 = new int[]{1, 2, 3, 3, 3, 4, 5};
		int[] a3 = new int[]{1, 2, 3, 4, 5};
		int[] a4 = new int[]{5, 5, 5, 5, 5};
		
		RemoveDupeSorted r = new RemoveDupeSorted();
		System.out.println("Expect 2: " + r.removeDupe(a1));
		System.out.println(Arrays.toString(a1));
		System.out.println("Expect 5: " + r.removeDupe(a2));
		System.out.println(Arrays.toString(a2));
		System.out.println("Expect 5: " + r.removeDupe(a3));
		System.out.println(Arrays.toString(a3));
		System.out.println("Expect 1: " + r.removeDupe(a4));
		System.out.println(Arrays.toString(a4));
	}
	
	public int removeDupe(int[] arr){
		if(arr.length == 0){
			return 1;
		}				
		int scanner = 0;
		int len = 0;
		LinkedList<Integer> dupeQueue = new LinkedList<>();
		HashSet<Integer> uniSet = new HashSet<>();
		while(scanner < arr.length){
			if(!uniSet.contains(arr[scanner])){
				uniSet.add(arr[scanner]);
				if(!dupeQueue.isEmpty()){
					arr[dupeQueue.removeFirst()] = arr[scanner];
				}
				len++;
			} else {
				dupeQueue.add(scanner);
			}
			scanner++;			
		}		
		return len;
	}

}
