package com.leo.interview;

/*
 * Given two binary strings, return their sum (also as a binary string)
 * a = "11", b = "1", return "100"
 */

//Can do insert(0, char) and just sb.toString()
//Or do append(char) and do sb.reverse().toString()

public class AddBinary {
	public static void main(String[] args){
		AddBinary s = new AddBinary();
		System.out.println(s.addBinary("11", "1"));
		System.out.println(s.addBinary("1111011", "11"));
	}
	
	public String addBinary(String a, String b){
		StringBuilder sb = new StringBuilder();		
		boolean shiftOne = false;
		String shorter = (a.length() <= b.length()) ? a : b;
		String longer = (a.length() <= b.length()) ? b : a;
		int sPointer = shorter.length() - 1;
		int lPointer = longer.length() - 1;
		while(sPointer >= 0){
			if(shorter.charAt(sPointer) == '1' && longer.charAt(lPointer) == '1'){
				if(shiftOne){
					sb.append('1');
				} else {
					sb.append('0');
					shiftOne = true;
				}
			} else if(shorter.charAt(sPointer) == '0' && longer.charAt(lPointer) == '0'){
				if(shiftOne){
					sb.append('1');
					shiftOne = false;
				} else {
					sb.append('0');
				}
			} else {
				if(shiftOne){
					sb.append('0');
				} else {
					sb.append('1');
				}
			}
			sPointer--;
			lPointer--;
		}
		while(lPointer >= 0){
			if(longer.charAt(lPointer) == '1'){
				if(shiftOne){
					sb.insert(0, '0');
				} else {
					sb.append('1');
				}
			} else {
				if(shiftOne){
					sb.append('1');
					shiftOne = false;
				} else {
					sb.append('0');
				}
			}
			lPointer--;
		}
		if(shiftOne){
			sb.append('1');
		}
		return sb.reverse().toString();
	}
}
