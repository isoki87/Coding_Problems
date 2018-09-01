package com.leo.interview;

import java.util.HashSet;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive sequence should be [1, 2, 3, 4]
 * That length will be 4 (therego the output)
 * 
 * Algorithm should run in O(n) time
 */

public class LongestConsecutiveSequence {
	public static void main(String[] args){
		int[] arr = new int[]{100, 4, 200, 1, 3, 2};
		LongestConsecutiveSequence a = new LongestConsecutiveSequence();
		System.out.println("Expect 4: " + a.findLongestConsecutiveSequence(arr));
	}
	
	public int findLongestConsecutiveSequence(int[] arr){
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++){
			set.add(arr[i]);
		}
		int max = 1;
		for(int num : arr){
			int count = 1;
			int left = num - 1;
			int right = num + 1;
			
			while(set.contains(left)){
				count++;
				set.remove(left);
				left--;
			}
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
	
}
