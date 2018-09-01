package com.leo.interview;

/*
 * Compare two version numbers v1 and v2.
 * If v1>v2 return 1, if v1 < v2 return -1, otherwise return 0.
 * Assume that the version strings are non-empty and contain only digits
 * and the . character. The .character does not represent a decimal point and is
 * used to separate number sequences.
 */

//0.1 < 1.1 < 1.2 < 13.37

public class CompareVersions {
	public static void main(String[] args){
		CompareVersions a = new CompareVersions();
		System.out.println("Expect -1: " + a.compare("0.1", "1.1"));
		System.out.println("Expect 0: " + a.compare("1.00", "1"));
		System.out.println("Expect 1: " + a.compare("13.37", "1.1.1"));
		System.out.println("Expect 1: " + a.compare("1.2", "1.19"));
		System.out.println("Expect 1: " + a.compare("1.0.0.0.1", "1.0"));
	}
	
	//For a dot to be recognized, you need to have a double backslash
	//.split("\\.")
	public int compare(String v1, String v2){
		String[] arr1 = v1.split("\\.");
		String[] arr2 = v2.split("\\.");
		
		//possible that 1.0 is compared to 1, leave that check at the end
		//Also remember that 0 and 00 should be equal
		String[] shorter = (arr1.length < arr2.length) ? arr1 : arr2;
		String[] longer = (arr1.length < arr2.length) ? arr2 : arr1;
		boolean broken = false;
		String[] smaller = new String[0];
		//In string.comparTo, 0 is less than 02
		for(int i = 0; i < shorter.length; i++){
			if(allZeros(longer[i]) && allZeros(shorter[i])){
				continue;
			} else {
				if(shorter[i].compareTo(longer[i]) == -1){
					smaller = shorter;
					broken = true;
					break;
				} else if(shorter[i].compareTo(longer[i]) == 1){
					smaller = longer;
					broken = true;
					break;
				}
				//Point result to the longer/shorter array
				//at the end, check where result is pointing to
				//arr1 or arr2
			}
		}
		if(longer.length - shorter.length == 1){
			if(!broken && allZeros(longer[longer.length - 1])){
				return 0;
			} else {
				smaller = longer;
			}
		} else {
			smaller = shorter;
		}
		if(smaller.length > 0){
			if(smaller == arr1){
				return -1;
			} else {
				return 1;
			}
		}		
		return 0;
	}
	
	private boolean allZeros(String s){
		if(s.length() == 0){
			return true;
		}
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != '0'){
				return false;
			}
		}
		return true;
	}
	
}
