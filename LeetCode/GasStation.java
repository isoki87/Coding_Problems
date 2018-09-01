package com.leo.interview;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i];
 * You have a car with an unlimited gas tank, and it costs cost[i] of gas to travel from station i to 
 * station i+1, you begin the journey with an empty tank at one of the gas stations
 * 
 * Return the starting gas station index if you can travel around the circuit once, otherwise return -1
 * 
 */

public class GasStation {
	public static void main(String[] args){
		int[] gas = new int[]{1, 2, 3, 4, 5};
		int[] cost = new int[]{1, 3, 2, 4, 5};
		GasStation a = new GasStation(gas, cost);
		System.out.println("Expect -1: " + a.startAt(1));
		System.out.println("Expect 2: " + a.startAt(2));
		System.out.println("Expect -1: " + a.startAt(4));
	}
	
	private int[] gas;
	private int[] cost;

	GasStation(int[] gas, int[] cost){
		this.gas = gas;
		this.cost = cost;
	}
	
	//1 2 3 4 5
	
	
	public int startAt(int num){
		if(num < 0 || num >= gas.length){
			return -1;
		}		
		int loop = gas.length;

		int tank = 0;
		while(loop > 0){
			if(num >= gas.length){
				num = 0;
			}			
			tank += gas[num];
			if(tank < cost[num]){
				return -1;
			}
			tank -= cost[num];
			num++;
			loop--;
		}				
		return num;
	}	
	
}
