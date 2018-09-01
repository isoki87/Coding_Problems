package com.leo.interview;

/*
 * Write a function to find the longest common prefix string amongst an array of strings
 */

public class LongestCommonPrefix {
	public static void main(String[] args){
		LongestCommonPrefix a = new LongestCommonPrefix();
		String[] arr1 = new String[]{"cat", "cake", "car", "cab"};
		System.out.println("Expect ca: " + a.roundRobinPrefix(arr1));
	}
	
	//cat, cake, car, cab
	//Use a queue of iterators
	
	//can actually ignore the stringbuilder, just keep track of the index number
	public String roundRobinPrefix(String[] arr){
		StringBuilder sb = new StringBuilder();
		int shortestStr = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++){
			shortestStr = Math.min(shortestStr, arr[i].length());
		}
		boolean broken = false;
		for(int i = 0; i < shortestStr; i++){
			char c = arr[0].charAt(i);
			for(int j = 1; j < arr.length; j++){
				if(c != arr[j].charAt(i)){
					broken = true;
					break;
				}
			}
			if(broken){
				break;
			}
			sb.append(arr[0].charAt(i));
		}		
		return sb.toString();
	}
}
