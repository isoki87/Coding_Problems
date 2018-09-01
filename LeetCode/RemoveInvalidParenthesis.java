package com.leo.interview;

/*
 * Remove the minimum number of invalid parenthesis in order to make the input
 * string valid. Return all possible results.
 * 
 * The input string may contains letters other than the parenthesis ( and ).
 * 
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 * 
 */

//1. Check if string is valid
//2. Compute min number of l and r to remove, O(n)
//3. Try all possible ways to remove the l and r till they're 0 and valid.
//   For 3, remove r first since they have the potential to break the entire string
//   DFS and add result to the list

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {
	public static void main(String[] args){
		
		
		
	}

}
