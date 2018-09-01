package com.leo.treeInterview;

/*
 * Given a binary tree, return the level order traversal of its nodes from left to right, level by level
 * 
 *       3
 *     9   20
 *        
 *        15  7    would give {3, 9, 20, #, #, 15, 7}
 *        
 *         8
 *     1       3
 *   4  2     1  4
 *  6    3                 would give {8, 1, 3, 4, 2, 1, 4, 6, #, #, 3, #, #, #, #}
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class InLevelTraversal {
	public static void main(String[] args){
		InLevelTraversal a = new InLevelTraversal();
		
		Node root1 = new Node(8);
		root1.left = new Node(1);
		root1.right = new Node(3);
		root1.right.left = new Node(1);
		root1.right.right = new Node(4);
		root1.left.left = new Node(4);
		root1.left.right = new Node(2);
		root1.left.left.left = new Node(6);
		root1.left.right.right = new Node(3);
		String[][] ans1 = a.levelTraversal(root1);
		for(int i = 0; i < ans1.length; i++){
			System.out.println(Arrays.toString(ans1[i]));
		}
		
		Node root2 = new Node(3);
		root2.left = new Node(9);
		root2.right = new Node(20);
		root2.right.left = new Node(15);
		root2.right.right = new Node(7);
		String[][] ans2 = a.levelTraversal(root2);
		for(int i = 0; i < ans2.length; i++){
			System.out.println(Arrays.toString(ans2[i]));
		}
	}
	
	public String[][] levelTraversal(Node root){
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		LinkedList<Node> curr = new LinkedList<>();
		LinkedList<Node> next = new LinkedList<>();
		curr.add(root);
		ArrayList<String> l = new ArrayList<>();
		while(!curr.isEmpty()){
			Node n = curr.removeFirst();
			if(n != null){
				next.add(n.left);
				next.add(n.right);
				l.add(Integer.toString(n.val));
			}
			if(curr.isEmpty()){
				list.add(l);
				l = new ArrayList<>();
				curr = next;
				next = new LinkedList<>();
			}		
		}
		list.remove(list.size() - 1);
		String[][] results = process(list);
		return results;
	}	
	
	private String[][] process(ArrayList<ArrayList<String>> list){
		String[][] results = new String[list.size()][];
		for(int i = 0; i < list.size(); i++){
			results[i] = list.get(i).toArray(new String[list.get(i).size()]);
		}			
		return results;
	}
}
