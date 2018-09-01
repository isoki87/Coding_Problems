package com.leo.interview;

/*
 * Given an absolute path for a file (unix-style), simplify it
 *
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/../", => "/"
 * path = "/home//foo/", => "/home/foo"
 * 
 */

import java.util.LinkedList;

public class SimplifyPath {
	public static void main(String[] args){
		SimplifyPath a = new SimplifyPath();
		String s1 = "/home/";
		System.out.println("Expect /home: " + a.simplify(s1));
		String s2 = "/a/./b/../../c/";
		System.out.println("Expect /c: " + a.simplify(s2));
		String s3 = "/../";
		System.out.println("Expect /: " + a.simplify(s3));
		String s4 = "/home//foo/";
		System.out.println("Expect /home/foo: " + a.simplify(s4));
		String s5 = "/home/../a/b/c/.././e/";
		System.out.println("Expect /a/b/e: " + a.simplify(s5));
	}
	
	public String simplify(String s){
		//Put the files in a stack
		String[] paths = s.split("/");
		LinkedList<String> stack = new LinkedList<>();
		for(int i = 0; i < paths.length; i++){
			if(paths[i].equals("..")){
				if(!stack.isEmpty()){
					stack.removeLast();
				} else {
					continue;
				}
			} else if(paths[i].equals(".") || paths[i].equals("")){
				continue;
			} else {
				stack.add(paths[i]);
			}		
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()){
			return "/";
		}
		for(String str : stack){
			sb.append('/');
			sb.append(str);
		}
		return sb.toString();
	}
}
