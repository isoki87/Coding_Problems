package com.leo.treeInterview;

/*
 * Invert a binary tree
 * 
 *       4
 *     /   \
 *    2     7
 *   / \   / \
 *  1   3 6   9
 * 
 * Output will be 
 *       4
 *     /   \
 *    7     2
 *   / \   / \
 *  9   6 3   1
 * 
 */


public class InvertBinaryTree {
	public static void main(String[] args){
		
	}
	
	public Node invert(Node root){
		if(root != null){
			invertInternal(root);
		}		
		return root;
	}
	
	private void invertInternal(Node root){		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

		if(root.left != null){
			invertInternal(root.left);
		}
		if(root.right != null){
			invertInternal(root.right);
		}
	}
}
