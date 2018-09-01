package com.leo.interview;

public class TreeTraversal {
	public static void main(String[] args){
		System.out.println(493827156>>2);
		System.out.println(2>>1);
	}
	
	class Node {
		Node leftChild;
		Node rightChild;
		int data;
	}
	
	public Node findValue(Node n, int val){
		if(n.data == val || n == null){
			return n;
		}
		return null;
	}

}
 