package com.leo.squarecounter;

/*
* Given points on a 2D plane, find all the squares that are formed
* by the points' lines.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 1. Graph out all the unique lines created by the points (normal, horizontal, vertical)
 * 2. Map the unique lines based on their slope, so same sloped lines are in a bucket
 * 3. For each bucket of lines with the same slope, get all the possible combinations of pairings
 * 4. Group the pairings into a further bucket of distance apart and number of pairs in that bucket
 */

public class SquareCounter{
	List<Line> uniqueNormal, uniqueHori, uniqueVert;
	Map<Double, HashMap<Double, Integer>> slopeToDistance;
	Map<Double, Integer> horiPairs;
	Map<Double, Integer> vertPairs;
	
	SquareCounter(){
		this.uniqueNormal = new ArrayList<>();
		this.uniqueHori = new ArrayList<>();
		this.uniqueVert = new ArrayList<>();
		this.slopeToDistance = new HashMap<>();
		this.horiPairs = new HashMap<>();
		this.vertPairs = new HashMap<>();
	}
	
	public int countSquares(List<Double[]> points) {
		int squares = 0;
		populateLineLists(points);
		groupParallelLines();
		squares += countNormal();
		squares += countHoriVert();
		return squares;
	}
	
	private int countHoriVert() {
		int squares = 0;
		for(Map.Entry<Double, Integer> entry : horiPairs.entrySet()) {
			if(vertPairs.containsKey(entry.getKey())) {
				squares += (entry.getValue() <= vertPairs.get(entry.getKey())) ? entry.getValue() : vertPairs.get(entry.getKey());
			}
		}
		return squares;
	}
	
	private int countNormal() {
		int squares = 0;
		HashSet<Double> visited = new HashSet<>();
		for(Map.Entry<Double, HashMap<Double, Integer>> entry : slopeToDistance.entrySet()){
			double recip = -1 / entry.getKey();
			if(visited.contains(recip)){
				continue;
			}
			for(Map.Entry<Double, Integer> e : entry.getValue().entrySet()){
				if(slopeToDistance.containsKey(recip)){
					double distance = e.getKey();
					if(slopeToDistance.get(recip).containsKey(distance)){
						squares += slopeToDistance.get(recip).get(distance);
					}
				}
			}
			visited.add(entry.getKey());
		}
		return squares;
	}
	
	private void groupParallelLines() {
		groupNormalLines();
		groupHoriLines();
		groupVertLines();
	}
	
	private void groupNormalLines() {
		for(int i = 0; i < uniqueNormal.size() - 1; i++) {
			for(int j = i + 1; j < uniqueNormal.size(); j++) {
				if(uniqueNormal.get(i).slope == uniqueNormal.get(j).slope) {
					LinePair pair = new LinePair(uniqueNormal.get(i), uniqueNormal.get(j));
					pair.initPair();
					int count = 1;
					if(slopeToDistance.containsKey(uniqueNormal.get(i).slope)) {
						if(slopeToDistance.get(pair.slope).containsKey(pair.distance)) {
							count = slopeToDistance.get(pair.slope).get(pair.distance);
							slopeToDistance.get(pair.slope).put(pair.distance, count + 1);
						} else {
							slopeToDistance.get(pair.slope).put(pair.distance, count);
						}
					} else {
						HashMap<Double, Integer> map = new HashMap<>();
						map.put(pair.distance, count);
						slopeToDistance.put(pair.slope, map);
					}
				}
			}
		}
	}
	
	private void groupHoriLines() {
		for(int i = 0; i < uniqueHori.size() - 1; i++) {
			for(int j = i + 1; j < uniqueHori.size(); j++) {
				LinePair pair = new LinePair(uniqueHori.get(i), uniqueHori.get(j));
				pair.initPair();
				int count = 1;
				if(horiPairs.containsKey(pair.distance)) {
					count = horiPairs.get(pair.distance);
					horiPairs.put(pair.distance, count + 1);
				} else {
					horiPairs.put(pair.distance, count);
				}
			}
		}
	}
	
	private void groupVertLines() {
		for(int i = 0; i < uniqueVert.size() - 1; i++) {
			for(int j = i + 1; j < uniqueVert.size(); j++) {
				LinePair pair = new LinePair(uniqueVert.get(i), uniqueVert.get(j));
				pair.initPair();
				int count = 1;
				if(vertPairs.containsKey(pair.distance)) {
					count = vertPairs.get(pair.distance);
					vertPairs.put(pair.distance, count + 1);
				} else {
					vertPairs.put(pair.distance, count);
				}	
			}
		}
	}
	
	private void populateLineLists(List<Double[]> points) {
		HashMap<Double, HashSet<Double>> normal = new HashMap<>();
		HashSet<Double> hori = new HashSet<>();
		HashSet<Double> vert = new HashSet<>();
		for(int i = 0; i < points.size() - 1; i++) {
			for(int j = i + 1; j < points.size(); j++) {
				Line line = new Line(points.get(i), points.get(j));
				line.initLine();
				putLineInList(line, normal, hori, vert);
			}
		}
	}
	
	private void putLineInList(Line line, Map<Double, HashSet<Double>> normal, Set<Double> hori, Set<Double> vert) {
		if(line.horizontal) {
			if(hori.contains(line.y_int)) {
				return;
			} else {
				uniqueHori.add(line);
				hori.add(line.y_int);
			}
		} else if (line.vertical) {
			if(hori.contains(line.x_int)) {
				return;
			} else {
				uniqueVert.add(line);
				vert.add(line.x_int);
			}
		} else {
			if(normal.containsKey(line.slope) && normal.get(line.slope).contains(line.y_int)) {
				return;
			} else if(normal.containsKey(line.slope)) {
				normal.get(line.slope).add(line.y_int);
			} else {
				HashSet<Double> set = new HashSet<>();
				set.add(line.y_int);
				normal.put(line.slope, set);
			}
			uniqueNormal.add(line);
		}
	}
	
	class LinePair{
		Line l1, l2;
		boolean horizontal, vertical;
		double distance, slope;
		
		LinePair(Line l1, Line l2){
			this.l1 = l1;
			this.l2 = l2;
			this.horizontal = l1.horizontal;
			this.vertical = l1.vertical;
		}
		
		private void initPair() {
			this.slope = l1.slope;
			this.distance = findDistance(l1, l2);
		}
		
		private double findDistance(Line l1, Line l2) {
			double distance = 0.0d;
			double xDist = (l1.x1 - l2.x2) * (l1.x1 - l2.x2);
			double yDist = (l1.y1 - l2.y2) * (l1.y1 - l2.y2);
			distance = Math.sqrt(xDist + yDist);
			return distance;
		}
	}
	
	class Line{
		double x1, y1, x2, y2;
		double slope, y_int, x_int;
		boolean vertical, horizontal;
		
		Line(Double[] p1, Double[] p2){
			this.x1 = p1[0];
			this.y1 = p1[1];
			this.x2 = p2[0];
			this.y2 = p2[1];
		}
		
		private void initLine() {
			if(x1 == x2) {
				this.vertical = true;
				this.x_int = x1;
			} else if (y1 == y2) {
				this.horizontal = true;
				this.y_int = y1;
			} else {
				this.slope = (y2 - y1) / (x2 - x1);
				this.y_int = y1 - (this.slope * x1);
				this.x_int = (y1 - this.y_int) / this.slope;
			}
		}	
	}
}