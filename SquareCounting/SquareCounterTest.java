package com.leo.squarecounter;

import java.util.ArrayList;

/**
 * Created by Lelily on 10/31/2017.
 */
public class SquareCounterTest{
	public static void main(String[] args){
		System.out.println("7 random points, 3 in the same line, 1 square: " + sevenRandom());
		System.out.println("9 Points equidistant, 6 sqaures: " + nineStraightPts());	
	}
	
	private static int sevenRandom() {
		SquareCounter sc = new SquareCounter();
		ArrayList<Double[]> points = new ArrayList<>();
		Double[] a = new Double[2];
		a[0] = 1.0d;
		a[1] = 6.0d;
		Double[] b = new Double[2];
		b[0] = 1.0d;
		b[1] = -2.0d;
		Double[] c = new Double[2];
		c[0] = 5.0d;
		c[1] = 10.0d;
		Double[] d = new Double[2];
		d[0] = 5.0d;
		d[1] = 0.0d;
		Double[] e = new Double[2];
		e[0] = 5.0d;
		e[1] = -5.0d;
		Double[] f = new Double[2];
		f[0] = 13.0d;
		f[1] = 6.0d;
		Double[] g = new Double[2];
		g[0] = 13.0d;
		g[1] = -2.0d;
		points.add(a);
		points.add(b);
		points.add(c);
		points.add(d);
		points.add(e);
		points.add(f);
		points.add(g);
		return sc.countSquares(points);
	}
	
	private static int nineStraightPts() {
		SquareCounter sc = new SquareCounter();
		ArrayList<Double[]> points = new ArrayList<>();
		Double[] a = new Double[2];
		a[0] = -1.0d;
		a[1] = 1.0d;
		Double[] b = new Double[2];
		b[0] = 0.0d;
		b[1] = 1.0d;
		Double[] c = new Double[2];
		c[0] = 1.0d;
		c[1] = 1.0d;
		Double[] d = new Double[2];
		d[0] = -1.0d;
		d[1] = 0.0d;
		Double[] e = new Double[2];
		e[0] = 0.0d;
		e[1] = 0.0d;
		Double[] f = new Double[2];
		f[0] = 1.0d;
		f[1] = 0.0d;
		Double[] g = new Double[2];
		g[0] = -1.0d;
		g[1] = -1.0d;
		Double[] h = new Double[2];
		h[0] = 0.0d;
		h[1] = -1.0d;
		Double[] i = new Double[2];
		i[0] = 1.0d;
		i[1] = -1.0d;
		points.add(a);
		points.add(b);
		points.add(c);
		points.add(d);
		points.add(e);
		points.add(f);
		points.add(g);
		points.add(h);
		points.add(i);
		return sc.countSquares(points);
	}
}
