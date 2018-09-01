package com.leo.interview;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane
 * Each rectangle is defined by its bottom left corner and top right corner coord
 */

public class RectangleArea {
	public static void main(String[] args){
		
	}
	
	
	//Find the areas of the two rectangles first
	//If the rectangles overlap, then subtract overlap area
	public int totalArea(Rectangle a, Rectangle b){
		int areaA = (a.topRight.x - a.bottomLeft.x) * (a.topRight.y - a.bottomLeft.y);
		int areaB = (b.topRight.x - b.bottomLeft.x) * (b.topRight.y - b.bottomLeft.y);
		
		int totalArea = areaA + areaB;
		totalArea -= overlapArea(a, b, totalArea);
		return totalArea;
	}
	
	
	//The two sides can lie directly over each other
	//If that's the case, there are 3 scenarios:
	//1. One rectangle is completely inside another
	//2. Rectangles overlap partially
	//3. Rectangles do not overlap at all but are neighbors
	
	
	/*   *       *        
	 * 
	 * 
	 *   *       *
	 * 
	 */
	
	private int overlapArea(Rectangle a, Rectangle b, int totalArea){
		if(a.bottomLeft.x > b.bottomRight.x || b.bottomLeft.x > a.bottomRight.x){
			return 0;
		}
		if(a.bottomLeft.y > b.topLeft.y || b.bottomLeft.y > a.topLeft.y){
			return 0;
		}
		
		int overlapTopRight = Math.min(a.topRight.x, b.topRight.x);
		int overlapTopLeft = Math.min(a.topLeft.x, b.topLeft.x);
		int overlapBottomRight = Math.min(a.bottomRight.x, b.bottomRight.x);
		int overlapBottomLeft = Math.min(a.bottomLeft.x, b.topLeft.x);
		
		int overlapArea = (overlapTopRight - overlapTopLeft) * (overlapTopRight - overlapBottomRight);		
		return totalArea - overlapArea;
	}
}

class Rectangle{
	Coordinate bottomLeft;
	Coordinate topRight;
	Coordinate bottomRight;
	Coordinate topLeft;
	
	Rectangle(Coordinate bottomLeft, Coordinate topRight){
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
		this.topLeft = new Coordinate(bottomLeft.x, topRight.y);
		this.bottomRight = new Coordinate(topRight.x, bottomLeft.y);
	}	
}

class Coordinate{
	int x;
	int y;
	
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}
