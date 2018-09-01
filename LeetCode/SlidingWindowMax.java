package com.leo.interview;

import java.util.Arrays;

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left
 * of the array to the very right. You can only see the k numbers in the window. Each time
 * the window moves right by one position. Return the max sliding window
 * 
 * Input nums = [1, 3, -1, -3, 5, 3, 6, 7], and k = 3
 * Output: [3, 3, 5, 5, 6, 7]
 * 
 * [1 3 -1] -3 5 3 6 7          Max = 3
 * 1 [3 -1 -3] 5 3 6 7          Max = 3
 * 1 3 [-1 -3 5] 3 6 7          Max = 5
 * 1 3 -1 -3 [5 3 6] 7          Max = 6
 * 1 3 -1 -3 5 [3 6 7]          Max = 7
 * 
 * Assume that k is always valid, and that 1<= k <= input array's size and array is non-empty
 * 
 * Bonus: Try to solve this in linear time?
 * 
 */

import java.util.LinkedList;

public class SlidingWindowMax {
	public static void main(String[] args){
		SlidingWindowMax a = new SlidingWindowMax();
		int[] num1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
		System.out.println("Expect [3, 3, 5, 5, 6, 7]: " + Arrays.toString(a.maxSliding(num1, 3)));
		int[] num2 = new int[]{4, 2, 5, 3, 4, 2, 10, 2, 11, 15};
		System.out.println("Expect [5, 5, 5, 4, 10, 10, 11, 15]: " + Arrays.toString(a.maxSliding(num2, 3)));
		
	}

	public int[] maxSliding(int[] num, int k){
		int[] results = new int[num.length - k + 1];
		LinkedList<Integer> indQueue = new LinkedList<>();
		int ind = 0;
		//If you find a new max, dequeue until you have a new max
		//Put the max into your queue.
		for(int i = 0; i < num.length; i++){
			if(!indQueue.isEmpty() && indQueue.peekFirst() == i - k){
				indQueue.removeFirst();
			}
			while(!indQueue.isEmpty() && num[indQueue.peekLast()] < num[i]){
				indQueue.removeLast();
			}			
			indQueue.add(i);
			if(i >= k - 1){
				results[ind++] = num[indQueue.peek()];
			}
		}
		return results;
	}
}
