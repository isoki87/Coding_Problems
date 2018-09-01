package com.leo.interview;

/*
 * Given a sorted integer array without duplicates
 * Return the summary of its ranges for consecutive numbers
 * 
 * [0, 1, 2, 4, 5, 7]
 * return ["0 -> 2", "4->5", "7"]
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
	public static void main(String[] args){
		SummaryRanges a = new SummaryRanges();
		int[] arr1 = new int[]{0, 1, 2, 4, 5, 7};
		String[] ans1 = a.summarizeRange(arr1);
		System.out.println(Arrays.toString(ans1));
	}
	
	public String[] summarizeRange(int[] arr){
		List<String> list = new ArrayList<>();
		boolean startNew = true;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length - 1; i++){
			if(startNew){
				sb.append(String.valueOf(arr[i]));
				sb.append(" -> ");
				startNew = false;
			}
			if(arr[i + 1] - arr[i] > 1){
				sb.append(String.valueOf(arr[i]));
				list.add(sb.toString());
				sb.setLength(0);
				startNew = true;
			}			
		}
		if(!startNew){
			sb.append(String.valueOf(arr[arr.length - 1]));
			list.add(sb.toString());
		} else {
			list.add(String.valueOf(arr[arr.length - 1]));
		}
		String[] results = new String[list.size()];
		int i = 0;
		for(String s : list){
			results[i++] = s;
		}
		return results;
	}	
}
