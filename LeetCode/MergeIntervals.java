package com.leo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals
 * 
 * Given [1, 3], [2, 6], [8, 10], [15, 18]
 * Return [1, 6], [8, 10], [15, 18]
 * 
 */

public class MergeIntervals {
	public static void main(String[] args){
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[]{8, 10});
		list.add(new int[]{1, 3});
		list.add(new int[]{15, 18});
		list.add(new int[]{2, 6});
		for(int i = 0; i < list.size(); i++){
			System.out.println(Arrays.toString(list.get(i)));
		}
		MergeIntervals a = new MergeIntervals();
		list = a.merge(list);
		for(int i = 0; i < list.size(); i++){
			System.out.println(Arrays.toString(list.get(i)));
		}
	}
	
	public ArrayList<int[]> merge(List<int[]> list){
		ArrayList<int[]> result = new ArrayList<>();
		if(list == null || list.size() == 0){
			return result;
		}
		Collections.sort(list, new Comparator<int[]>(){
			public int compare(int[] a, int[]b){
				return (a[0] < b[0]) ? -1 : (a[0] == b[0]) ? 0 : 1;
			}
		});
		//now the list is sorted
		int start = list.get(0)[0], end = list.get(0)[1];
		for(int i = 0; i < list.size(); i++){
			if(end >= list.get(i)[0] && end <= list.get(i)[1]){
				end = list.get(i)[1];
			} else if(list.get(i)[1] < end){
				continue;
			} else {
				//if they don't overlap, add the current start and end as an interval to results
				//set new start and end values
				result.add(new int[]{start, end});
				start = list.get(i)[0];
				end = list.get(i)[1];
			}
		}
		result.add(new int[]{start, end});
		return result;
	}
}
