package com.leo.interview;

//If a character is ?, it matches any single character, CANNOT be empty
//If a character is *, it matches any sequence of characters, can be empty

//"acdcb" vs "a*c?b" false
//"adceb" vs "*a*b" true
//"cb" vs "?a" false
//"aa" vs "*" true
//"aa" vs "a" false
//"acdccb" vs "a*cb" true;

public class WildcardMatching {

	public static void main(String[] args){
		WildcardMatching a = new WildcardMatching();
		System.out.println("Expect true: " + a.isMatch("acdccb", "a*cb"));
		System.out.println("Expect false: " + a.isMatch("acdcb", "a*c?b"));
		System.out.println("Expect true: " + a.isMatch("adceb", "*a*b"));
		System.out.println("Expect false: " + a.isMatch("cb", "?a"));
		System.out.println("Expect true: " + a.isMatch("acdccb", "*"));
		System.out.println("Expect false: " + a.isMatch("aa", "a"));
		System.out.println("Expect false: " + a.isMatch("a", "*aab"));
		System.out.println("Expect true: " + a.isMatch("aaaaabbbbbccccc", "a*"));
	}
	
	public boolean isMatch(String p, String q){
		int i = 0, j = 0;
		int star = -1, pIndex = -1;
		
		while(i < p.length()){
			if(j < q.length() && (q.charAt(j) == '?' || q.charAt(j) == p.charAt(i))){
				++i;
				++j;
			} else if (j < q.length() && q.charAt(j) == '*'){
				star = j;
				pIndex = i;
				j++;
			} else if (star != -1){
				j = star + 1;
				i = pIndex + 1;
				pIndex++;
			} else {
				return false;
			}
		}
		while(j < q.length() && q.charAt(j) == '*'){
			++j;
		}			
		return j == q.length();
	}
}
