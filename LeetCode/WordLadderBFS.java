package com.leo.interview;

/*Given two words (start and end), and a dictionary, find the length of shortest transformation 
 * sequence from start to end, such that only one letter can be changed at a time and each 
 * intermediate word must exist in the dictionary.
 * 
 */

import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderBFS {
	public static void main(String[] args){
		WordLadderBFS a = new WordLadderBFS();
		HashSet<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println("Expecting 5: " + a.shortestTransfSeq("hit", "cog", set));
		set.clear();
		set.add("scoot");
		set.add("scot");
		System.out.println("Expecting 1: " + a.shortestTransfSeq("shoot", "cat", set));
		set.clear();
		System.out.println("Expecting 2: " + a.shortestTransfSeq("hit", "hot", set));
	}
	
	//start = shoot
	//end = cat
	//set = scoot scot
	//1: shoot -x
	
	//start = hit
	//end = hot
	//2: hit hot
	
	//start = hit
	//end = cog
	//set =  hot, dot, dog, lot, log
	//5: hit hot dot dog cog
	
	public int shortestTransfSeq(String s, String t, HashSet<String> set){
		HashSet<String> visited = new HashSet<>();
		visited.add(s);
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(s, 1));
		while(!queue.isEmpty()){
			WordNode curr = queue.removeFirst();
			if(isValid(curr.word, t)){
				return curr.path + 1;
			}
			for(String str: set){
				if(!visited.contains(str) && isValid(curr.word, str)){
					queue.add(new WordNode(str, curr.path + 1));
					visited.add(str);
				}
			}
		}
		return 1;
	}
	
	private boolean isValid(String x, String y){
		int diff = 0;
		int shortestLength = (x.length() <= y.length()) ? x.length() : y.length();
		for(int i = 0; i < shortestLength; i++){
			if(x.charAt(i) != y.charAt(i)){
				diff++;
				if(diff > 1){
					return false;
				}
			}
		}
		if(diff == 1 && x.length() != y.length()){
			return false;
		}
		return true;
	}
}

class WordNode {
	String word;
	int path;
	
	WordNode(String s, int path){
		this.word = s;
		this.path = path;
	}
}