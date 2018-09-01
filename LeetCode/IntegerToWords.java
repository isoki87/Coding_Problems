package com.leo.interview;

/*
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less within integer's boundaries
 * 
 * 123 -> "One hundred twenty three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 */
import java.util.Stack;
import java.util.HashMap;

public class IntegerToWords {
	public static void main(String[] args){
		IntegerToWords a = new IntegerToWords();
		System.out.println("Six Hundred Forty: " + a.convert(640));
		System.out.println("Twenty One Million Six Thousand Eighty Three: " + a.convert(21006083));
		System.out.println("Five Hundred Ninety Six Million Seven Hundred Seven: " + a.convert(596000707));
	}
	
	public String convert(int num){
		if(num == 0){
			return "Zero";
		}
		//1000888
		StringBuilder sb = new StringBuilder();
		Stack<String> commaStack = new Stack<>();
		Stack<String> numberStack = new Stack<>();
		int cdn = 0;
		while(num / 1000 > 0){
			commaStack.push(commaCdn(cdn));
			cdn++;
			int numbers = num % 1000;
			numberStack.push(stringify(numbers));
			num /= 1000;	
		}
		commaStack.push(commaCdn(cdn));
		numberStack.push(stringify(num));
		
		boolean noNumOnTier = false;		
		while(!numberStack.isEmpty()){
			if(numberStack.peek().equals("")){
				noNumOnTier = true;
			}
			if(noNumOnTier){
				numberStack.pop();
				commaStack.pop();
				noNumOnTier = false;
			} else {
				sb.append(numberStack.pop());		
				sb.append(commaStack.pop());
			}
		}
		String result = sb.toString();
		return result.trim();
	}
	
	//Stringify always have 3 digits
	private String stringify(int num){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(100, "Hundred");
		map.put(10, "Ten");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
		StringBuilder sb = new StringBuilder();
		
		int hundreds = num / 100;
		int tens = num % 100;
		tens /= 10;
		tens *= 10;
		int ones = num % 10;
		
		sb.append(map.get(hundreds));
		if(hundreds != 0){
			sb.append(" ");
			sb.append(map.get(100));
			sb.append(" ");
		}
		
		if(tens != 0){
			sb.append(map.get(tens));
			sb.append(" ");
		}
		
		sb.append(map.get(ones));		
		if(ones != 0){
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	private String commaCdn(int num){
		switch(num){
		case 0 : return "";
		case 1 : return "Thousand ";
		case 2 : return "Million ";
		default : return "";
		}
	}
}
