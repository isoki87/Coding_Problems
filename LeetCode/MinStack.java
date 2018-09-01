package com.leo.interview;

/*
 * Design a stack that supports push, pop, top and retreiving the minimum element in constant time
 * top is peek
 */

public class MinStack {
	private Node top;
	
	public MinStack(){
		this.top = null;
	}
	
	public void push(int num){
		int min; 
		if(top == null){
			 min = num;
		 } else {
			 min = Math.min(top.min, num);
		 }
		 Node n = new Node(num, min);
		 n.next = top;
		 top = n;
	}
	
	public int pop(){
		int val = top.value;
		top = top.next;
		return val;
	}
	
	public int top(){
		return top.value;
	}
	
	public int currentMin(){
		return top.min;
	}
	
	public static void main(String[] args){
		//5, 4, 3, 2, 1, 5
		MinStack stack = new MinStack();
		stack.push(5);
		System.out.println("Min is 5: " + stack.currentMin());
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println("Min is 1: " + stack.currentMin());
		System.out.println("top() is 1: " + stack.top());
		stack.push(5);
		System.out.println("Min is 1: " + stack.currentMin());
		System.out.println("top() is 5: " + stack.top());
	}
}

class Node {
	int value;
	int min; 
	Node next;
	
	Node(int value, int min){
		this.value = value;
		this.min = min;
	}
}