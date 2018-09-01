package com.leo.treeInterview;

/*
 * Do a preorder traversal
 * 
 *         8
 *     1       3
 *   4  2     1  4
 *  6    3
 *  
 *  814623314
 *  
 */

public class PreorderTraversal {
	public static void main(String[] args){
		Node root = new Node(8);
		root.left = new Node(1);
		root.right = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(4);
		root.left.left = new Node(4);
		root.left.right = new Node(2);
		root.left.left.left = new Node(6);
		root.left.right.right = new Node(3);
		PreorderTraversal a = new PreorderTraversal();
		
		System.out.println("Expect 814623314: ");
		a.preorder(root);
	}
	
	public void preorder(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.val);
		preorder(root.left);
		preorder(root.right);
	}
}
