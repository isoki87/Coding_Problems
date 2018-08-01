package com.leo.interview;

import java.util.ArrayList;
import java.util.List;

public class ExpressionMatcher {
	
	public boolean isMatch(String s, String p){
		List<Rule> rules = initializeRules(p);
		int i = 0, sP = 0;
		while(sP < s.length() && i < rules.size()){
			sP = rules.get(i).movePointer(sP, s);
			if(sP == -1){
				return false;
			}
			i++;
		}
		if(sP < s.length()){
			return false;
		}
		return true;
	}
	
	interface Rule {
		public int movePointer(int sP, String s);
		public void starProceeding();
		public void starNotProceeding();
	}
	
	class PeriodRule implements Rule {
		private boolean starred;
		private char letterAfterPattern;
		
		public int movePointer(int sP, String s) {
			if(starred){
				if(letterAfterPattern == '\u0000'){
					return s.length();
				}
				return characterAfterPoint(sP, s);
			}
			return sP + 1;
		}
	
		public void starProceeding() {
			this.starred = true;			
		}

		public void starNotProceeding() {
			this.starred = false;			
		}
		
		public void setLetterAfterPattern(char character){
			this.letterAfterPattern = character;
		}
		
		private int characterAfterPoint(int sP, String s){
			while(sP < s.length()){
				if(s.charAt(sP) == this.letterAfterPattern){
					return sP;
				}
				sP++;
			}
			return sP;
		}
	}
	
	class LetterRule implements Rule {
		private boolean starred;
		private char letter;
		
		LetterRule(char character){
			this.letter = character;
		}		
		
		public int movePointer(int sP, String s){	
			if(starred){
				if(s.charAt(sP) == this.letter){
					return characterAfterPoint(sP, s);
				} else {
					return sP;
				}
			} else {
				if(s.charAt(sP) == this.letter){
					return sP + 1;
				}
			}
			return -1;
		}

		public void starProceeding() {
			this.starred = true;			
		}

		public void starNotProceeding() {
			this.starred = false;			
		}
		
		private int characterAfterPoint(int sP, String s){
			while(sP < s.length()){
				if(s.charAt(sP) != this.letter){
					return sP;
				}
				sP++;
			}
			return sP;
		}
	}
	
	private List<Rule> initializeRules(String p){
		List<Rule> rules = new ArrayList<>();
		for(int i = 0; i < p.length(); i++){
			if(p.charAt(i) == '.'){
				PeriodRule rule = new PeriodRule();
				checkStarProceeding(rule, p, i);
				checkLetterAfterPattern(rule, p, i);
				rules.add(rule);
			} else if(p.charAt(i) != '.' && p.charAt(i) != '*'){
				LetterRule rule = new LetterRule(p.charAt(i));
				checkStarProceeding(rule, p, i);
				rules.add(rule);
			}
		}
		return rules;
	}
	
	private void checkLetterAfterPattern(PeriodRule rule, String p, int index){
		while(index < p.length()){
			if(p.charAt(index) != '*' && p.charAt(index) != '.'){
				rule.setLetterAfterPattern(p.charAt(index));
			}
			index++;
		}
	}
	
	private void checkStarProceeding(Rule rule, String p, int index){
		if(index + 1 < p.length() && p.charAt(index + 1) == '*'){
			rule.starProceeding();
		} else {
			rule.starNotProceeding();
		}
	}
}
