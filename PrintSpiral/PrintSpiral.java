package com.leo.interview;

public class SpiralPrinter {
	public void printSpiral(int layers){
		char[][] board = new char[4 * layers][8 * layers + 1];
		//four cases, move left, move up, move right, move down
		int currLen = board.length - 1;
		Coord start = new Coord(0, 0);
		int cdn = 0;
		while(currLen >= 0){
			start = popBoard(board, cdn % 4, start, currLen);
			cdn++;
			currLen--;
		}
		printBoard(board);
	}
	
	private void printBoard(char[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private Coord popBoard(char[][] board, int cdn, Coord start, int len){
		int xstart = start.x;
		int ystart = start.y;
		switch(cdn){
		  //move right
			case 0: while(len >= 0){
							  board[xstart][ystart] = '*';
							  board[xstart][ystart + 1] = ' ';
							  ystart += 2;
							  len--;
							}
							board[xstart][ystart] = '*';
							return new Coord(xstart, ystart);
		  //move down
			case 1: while(len >= 0){
				 				board[xstart][ystart] = '*';
				 				xstart++;
				 				len--;
			        }
							board[xstart][ystart] = '*';
							return new Coord(xstart, ystart);
			//move left
			case 2: while(len >= 0){
								board[xstart][ystart] = '*';
								board[xstart][ystart - 1] = ' ';
								ystart -= 2;
								len--;
							}
							board[xstart][ystart] = '*';
							return new Coord(xstart, ystart);
			//move up
			case 3: while(len >= 0){
								board[xstart][ystart] = '*';
								xstart--;
								len--;
			        }
							board[xstart][ystart] = '*';
			        return new Coord(xstart, ystart);
		}
		return null;
	}
	
	class Coord{
		int x;
		int y;
		
		Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
