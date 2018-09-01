package com.leo.interview;

/*
 * Given a binary search, how do we serialize it for file transport
 * How do we deserialize it?
 * 
 */


//      8
//     /  \
//   4     9
//  / \   /  \
// 3   1  7   2
//  \ /   /  
//  3 1  4
//   /
//   5


//Inorder: left, curr, right
//preorder: curr, left, right
//postorder: left, right, curr

import java.util.List;
import java.util.LinkedList;

public class SerializeDeserialize {
	LinkedList<String> queue;
	public static void main(String[] args){
		SerializeDeserialize a = new SerializeDeserialize();	
		SNode root = new SNode(8);
		root.left = new SNode(4);
		root.right = new SNode(10);
		root.left.left = new SNode(3);
		root.left.left.right = new SNode(3);
		root.left.right = new SNode(1);
		root.left.right.left = new SNode(1);
		root.left.right.left.left = new SNode(5);
		root.right.left = new SNode(7);
		root.right.left.left = new SNode(4);
		root.right.right = new SNode(2);
		String code = a.serialize(root);
		System.out.println("843-13-1-1115-1-1-1-11074-1-1-12-1-1");
		System.out.println(code);
		
		SNode newRoot = a.deserialize(code);
		System.out.println("Expect 8: " + newRoot.value);
		System.out.println("Expect 4: " + newRoot.left.value);
		System.out.println("Expect 10: " + newRoot.right.value);
		System.out.println("Expect 3: " + newRoot.left.left.value);
		System.out.println("Expect 3: " + newRoot.left.left.right.value);
		System.out.println("Expect 1: " + newRoot.left.right.value);
		System.out.println("Expect 1: " + newRoot.left.right.left.value);
		System.out.println("Expect 5: " + newRoot.left.right.left.left.value);
		System.out.println("Expect 7: " + newRoot.right.left.value);
		System.out.println("Expect 4: " + newRoot.right.left.left.value);
		System.out.println("Expect 2: " + newRoot.right.right.value);
	}
	
	SerializeDeserialize(){
		this.queue = new LinkedList<>();
	}
	
	public String serialize(SNode root){
		StringBuilder sb = new StringBuilder("");
		serializeInternal(root, sb);
		return sb.toString();
	}
	
	private void serializeInternal(SNode root, StringBuilder sb){
		if(root == null){
			sb.append('-');
			sb.append('1');
			queue.add("-1");
			return;
		}
		sb.append(root.value);
		queue.add(String.valueOf(root.value));
		serializeInternal(root.left, sb);
		serializeInternal(root.right, sb);		
	}
	
	public SNode deserialize(String nodeString){
		SNode root = deserializeInternal();
		return root;
	}
	
	private SNode deserializeInternal(){
		if(queue.isEmpty() || queue.get(0).equals("-1")){
			queue.removeFirst();
			return null;
		}
		int num = Integer.valueOf(queue.removeFirst());
		SNode n = new SNode(num);
		n.left = deserializeInternal();
		n.right = deserializeInternal();
		return n;		
	}	
}

class SNode{
	SNode right;
	SNode left;
	int value;
	
	SNode(int value){
		this.value = value;
	}	
}

