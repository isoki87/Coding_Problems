package com.leo.interview;

/*
 * The String "PAYPALISHIRING" is written in a zig zag pattern
 * on a given number of rows like this
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * and then read line by line: "PAHNAPLSIIGYIR"
 * write a method convert("PAYPALISHIRING", 3) that returns "PAHNAPSIIGYIR"
 * 
 */

public class ZigZagConversion {
	public static void main(String[] args){
		ZigZagConversion a = new ZigZagConversion();
		System.out.println(a.convert("PAYPALISHIRING", 3));
		System.out.println(a.convert("PAYPALISHIRING", 9));
		
	}
	
	public String convert(String s, int rows){
		//2D[y][x]
		char[][] matrix = initializeMatrix(s, rows);
		int row = 0;
		int col = 0;
		for(int i = 0; i < s.length(); i++){
			if(row > matrix.length - 1){
				i--;
				row = 0;
				col++;
				continue;
			} 
			if(col % 2 == 0){	
				matrix[row][col] = s.charAt(i);
				row++;
			} else {
				if(row % 2 == 0){
					matrix[row][col] = ' ';
					row++;
					i--;
				} else {
					matrix[row][col] = s.charAt(i);
					row++;
				}
			}
		}
//		for(int i = 0; i < matrix.length; i++){
//			for(int j = 0; j < matrix[i].length; j++){
//				System.out.print(matrix[i][j]);
//			}
//			System.out.print("\n");
//		}		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				if(isLetter(matrix[i][j])){
					sb.append(matrix[i][j]);
				}
			}
		}
		return sb.toString();
	}
	
	private boolean isLetter(char c){
		if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
			return true;
		}
		return false;
	}
	
	private char[][] initializeMatrix(String s, int rows){
		char[][] m = new char[rows][];
		int len = s.length();
		int columns = 0;
		while(len >= 0){
			if(columns % 2 == 0){
				len -= rows;
				columns++;
			} else {
				len -= (rows / 2);
				columns++;
			}
		}
		for(int i = 0; i < m.length; i++){
			m[i] = new char[columns];
		}
		return m;
	}
	
}
