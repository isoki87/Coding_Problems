package com.leo.interview;

import java.util.Arrays;

/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
*/

public class RotateArray {
	public static void main(String[] args){
		RotateArray rA = new RotateArray();
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("Before rotation: " + Arrays.toString(arr));
		rA.rotate(arr, 0);
		System.out.println("Rotate by 0: " + Arrays.toString(arr));
		rA.rotate(arr, 5);
		System.out.println("Rotate by 5: " + Arrays.toString(arr));
		rA.rotate(arr, 2);
		System.out.println("Rorate by 2: " + Arrays.toString(arr));
	}
	
	//1 2 3 4 5, 0
	//1 2 3 4 5
	
	//1 2 3 4 5, 5
	//1 2 3 4 5
	
	//1 2 3 4 5, 2
	//4 5 1 2 3
	
	public void rotate(int[] arr, int steps){
		for(int i = 0; i < steps; i++){
			bubbleLast(arr);
		}
	}
	
	private void bubbleLast(int[] arr){
		int last = arr[arr.length - 1];
		for(int i = arr.length - 1; i > 0; i--){
			arr[i] = arr[i - 1];
		}
		arr[0] = last;
	}

}
