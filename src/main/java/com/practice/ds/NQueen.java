package com.practice.ds;

public class NQueen {

	public static boolean isSafe(int board[][], int row, int col) {
		int i, j;

		/* Check columns on left side */
		for (i = 0; i < board.length; i++)
			if (board[row][i] == 1)
				return false;

		/* Check rows on left side */
		for (i = 0; i < board.length; i++)
			if (board[i][col] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check upper diagonal on right side */
		for (i = row, j = col; i < board.length && j < board.length; i++, j++)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j < board.length && i >= 0; i--, j++)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	public static boolean placeQueen(int[][] board, int queenSize, int row, int depth) {

		if (depth == board.length && queenSize == 0) {
			return true;
		}

		if (row > board.length) {
			return true;
		}

		for (int col = 0; col < board.length; col++) {

			if (isSafe(board, row, col)) {
				board[row][col] = 1;
				if (placeQueen(board, queenSize - 1, row + 1, depth + 1) == true) {
					return true;
				}
				board[row][col] = 0;

			}

		}

		return false;
	}

	public static void main(String[] args) {

		int board[][] = new int[16][16];

		placeQueen(board, 16, 0, 0);

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				System.out.print(" " + board[row][col]);
			}
			System.out.println();
		}

	}

}
