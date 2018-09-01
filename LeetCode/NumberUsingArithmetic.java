package com.leo.interview;

/*
 * Given a list of numbers and a target number, write a program to determine whether the target
 * number can be calculated by applying the four basic operations to the number list.
 * You can assume () is automatically added when necessary
 * 
 * {1, 2, 3, 4} and 21   return true because (1 + 2) * (3 + 4) = 21
 * 
 */



//This solution will NOT account for parenthesis
import java.util.ArrayList;

public class NumberUsingArithmetic {
	public static void main(String[] args){
		NumberUsingArithmetic a = new NumberUsingArithmetic();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);	
		list.add(4);
		//1 + 2 + 3 + 4 = 10
		System.out.println("Expect true: " + a.calculate(list, 10));
		//1 * 2 * 3 - 4 = 2
		System.out.println("Expect true: " + a.calculate(list, 2));
		//1 + 2 / 3 * 4 = 4
		System.out.println("Expect true: " + a.calculate(list, 4));
		System.out.println("Expect false: " + a.calculate(list, 99999));
		System.out.println("Expect false: " + a.calculate(list, 92));
	}
	
	public boolean calculate(ArrayList<Integer> list, int tar){
		if(list == null || list.size() == 0){
			return false;
		}
		int cumulative = 0;
		if(calculateInternal(list, tar, cumulative, 0, list.size(), 0)){
			return true;
		} else if(calculateInternal(list, tar, cumulative, 0, list.size(), 1)){
			return true;
		} else if(calculateInternal(list, tar, cumulative, 0, list.size(), 2)){
			return true;
		} else if(calculateInternal(list, tar, cumulative, 0, list.size(), 3)){
			return true;
		}
		return false;
	}
	
	private boolean calculateInternal(ArrayList<Integer> list, int tar, int cumulative, int currIndex, int end, int cdn){
		if(currIndex == list.size() - 1 && arithmetic(cdn, cumulative, list.get(currIndex)) == tar){
			return true;
		}
		if(currIndex == end){
			return false;
		}
		cumulative = arithmetic(cdn, cumulative, list.get(currIndex));
		if(calculateInternal(list, tar, cumulative, currIndex + 1, end, 0)){
			return true;
		} else if(calculateInternal(list, tar, cumulative, currIndex + 1, end, 1)){
			return true;
		} else if(calculateInternal(list, tar, cumulative, currIndex + 1, end, 2)){
			return true;
		} else if(calculateInternal(list, tar, cumulative, currIndex + 1, end, 3)){
			return true;
		}
		return false;
	}
	
	private int arithmetic(int cdn, int cumulative, int num){
		switch(cdn){
			case 0: 
				return cumulative - num;
			case 1: 
				return cumulative + num;
			case 2: 
				return cumulative * num;
			case 3: 
				return cumulative / num;
			default: return 0;
		}
	}
}
