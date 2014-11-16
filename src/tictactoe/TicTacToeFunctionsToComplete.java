package tictactoe;
import java.util.Scanner;


/**
 * This class presents the classical Tic Tac Toe game using functions. Some functionalities must be complete. 
 * 
 * See FIXME comments to implement the missing functionality.
 * 
 * Teacher:
 * @author chema
 * Students:
 * @author Rodrigo Mompo Redoli 
 * @author Jorge Ramirez Cobo 
 * 
 *The code is published in a public repository. 
 *https://github.com/Rodriwp/GameOfLife
 *
 */
public class TicTacToeFunctionsToComplete {
	private static final int SIZE = 3;
	private static final char EMPTY_CELL = '_';

	public static char [][] createEmptyBoard(int size){
		char [][] board = new char[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				board[i][j]=EMPTY_CELL;
			}
		}
		return board;
	}
	public static void showBoard(char [][]board){
		System.out.println("Tic-Tac-Toe Board");
		System.out.println("-----------------");
		int numberOfRows = board.length;
		int numberOfCols = board[0].length;
		for(int i=0;i<numberOfRows;i++){
			for(int j=0;j<numberOfCols;j++){
				System.out.print("\t"+board[i][j]);
			}
			System.out.println();
		}
	}
	public static boolean isValidRangeOfCells(int row, int col, int numberOfRows, int numberOfCols){
		return (row>=0 && row<numberOfRows && col>=0 && col<numberOfCols);
	}

	public static boolean isEmptyCell(char [][]board,int row, int col){
		return board[row][col]==(EMPTY_CELL);
	}
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		char playerX = 'X';
		char playerO = 'O';
		char currentPlayer = playerX;
		char [][] board = createEmptyBoard(SIZE);
		boolean winner = Boolean.FALSE;
		int numberOfRows = board.length;
		int numberOfCols = board[0].length;
		int freePositions = numberOfRows*numberOfCols;
		boolean emptyPosition = Boolean.FALSE;
		int row = 0;
		int col = 0;

		do{
			//Show the board
			showBoard(board);
			System.out.println("It is the turn of player: "+currentPlayer);
			emptyPosition = Boolean.FALSE;
			do{
				if(freePositions>0 && !winner){
					System.out.println("Intro a position (row,col) between (0,3):");
					row = sc.nextInt();
					col = sc.nextInt();
					if(!isValidRangeOfCells(row,col, numberOfRows, numberOfCols)){
						System.out.println("The position is out of range.");
					}else{
						if(!isEmptyCell(board, row, col)){
							System.out.println("The position has been already introduced.");
						}else{
							emptyPosition = Boolean.TRUE;
						}
					}
				}
			}while(!isValidRangeOfCells(row,col, numberOfRows, numberOfCols) || !emptyPosition);

			board[row][col]=currentPlayer;
			freePositions--;

			//FIXME: Which is the condition to be the winner?
			winner = false; 
			
			if(!winner){
				if(currentPlayer==(playerX)){
					currentPlayer = playerO;
				}else{
					currentPlayer = playerX;
				}
			}
		}while(!winner && freePositions>0);
		showBoard(board);
		if(winner){
			System.out.println("The winner is player: "+currentPlayer);
		}else{
			System.out.println("Draw!");
		}

	}
	private static boolean isWinnerSecondaryDiagonal(char currentPlayer,char[][] board) {
		//FIXME: Complete
		return false;
	}
	private static boolean isWinnerMainDiagonal(char currentPlayer,char[][] board) {
		//FIXME: Complete
		return false;
	}
	private static boolean isWinnerInCols(char currentPlayer,	char[][] board) {
		if(board!=null){
			int numberOfRows = board.length;
			int numberOfCols = board[0].length;
			boolean winner = Boolean.FALSE;
			//Check if currentPlayer is a winner in rows
			int matches = 0;
			winner = Boolean.FALSE;
			for(int i=0;i<numberOfCols && !winner;i++){
				matches = 0;
				for(int j=0;j<numberOfRows && !winner;j++){
					if(board[i][j]== (currentPlayer)){
						matches++;
					}
					winner = (matches == SIZE);
				}

			}
			return winner;
		}
		//FIXME: Complete
		return false;
	}
	private static boolean isWinnerInRows(char currentPlayer,	char[][] board) {
		if(board!=null){
			int numberOfRows = board.length;
			int numberOfCols = board[0].length;
			boolean winner = Boolean.FALSE;
			//Check if currentPlayer is a winner in rows
			int matches = 0;
			winner = Boolean.FALSE;
			for(int i=0;i<numberOfRows && !winner;i++){
				matches = 0;
				for(int j=0;j<numberOfCols && !winner;j++){
					if(board[i][j]== (currentPlayer)){
						matches++;
					}
					winner = (matches == SIZE);
				}

			}
			return winner;
		}
	
		return false;
	}

}
