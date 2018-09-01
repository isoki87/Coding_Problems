package com.leo.interview;

/*
 * Given n non-negative integers a1, a2, an, hwere each represents a point at coordinate (i, ai).
 *  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 *  Find two lines, which together with x-axis, forms a container, such that the container contains the most water
 */

//This can be done in O(n) as opposed to O(n^2) by having
//two scanners scanning inwards until they match, and keeping track of the maxes
//if height[left] < height[right], left++; else right--;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class ContainerMostWater {
	public static void main(String[] args){
		int[] arr = new int[]{1, 3, 5, 3, 4, 3, 7, 3};
		//Expect 2 and 6
		ContainerMostWater a = new ContainerMostWater();
		List<Integer> list = a.findContainer(arr);
		System.out.println(list.size());
		System.out.println("Expect 2: " + list.get(0));
		System.out.println("Expect 6: " + list.get(1));
	}
	
	public List<Integer> findContainer(int[] arr){
		if(arr == null || arr.length <= 1){
			return null;
		}
		
		int localMostTall = 0;
		int localSecondTall = 0;
		int pillar1 = 0;
		int pillar2 = 0;
		int localMax = 0;
		int max = 0;
		HashMap<Integer, ArrayList<Integer>> maxMap = new HashMap<>();
		
		for(int i = 0; i < arr.length - 1; i++){
			localMostTall = arr[i];
			pillar1 = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] > localMostTall){
					localSecondTall = localMostTall;
					pillar2 = pillar1;
					localMostTall = arr[j];
					pillar1 = j;
				} else if(arr[j] > localSecondTall){
					localSecondTall = arr[j];
					pillar2 = j;
				}
				if((Math.abs(pillar1 - pillar2) * localSecondTall) > max){
					ArrayList<Integer> list = new ArrayList<>();
					list.add(pillar1);
					list.add(pillar2);
					localMax = Math.abs(pillar1 - pillar2) * localSecondTall;
					maxMap.put(localMax, list);
					max = localMax;
				}
			}
		}	
		Collections.sort(maxMap.get(max));
		return maxMap.get(max);
	}
}
