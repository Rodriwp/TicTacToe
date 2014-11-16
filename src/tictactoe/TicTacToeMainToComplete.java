package tictactoe;
import java.util.Scanner;

/**
 * This class presents the classical Tic Tac Toe game. Some functionalities must be complete. 
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
 *https://github.com/Rodriwp/TicTacToe
 *
 */
public class TicTacToeMainToComplete {
	private static final int SIZE = 3;
	private static final char EMPTY_CELL = '_';

	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		char playerX = 'X';
		char playerO = 'O';
		char currentPlayer = playerX;
		char [][] board = new char[SIZE][SIZE];
		boolean winner = Boolean.FALSE;
		int numberOfRows = board.length;
		int numberOfCols = board[0].length;
		int freePositions = numberOfRows*numberOfCols;
		boolean emptyPosition = Boolean.FALSE;
		int row = 0;
		int col = 0;
		//1-init the board

		for(int i=0;i<numberOfRows;i++){
			for(int j=0;j<numberOfCols;j++){
				board[i][j]=EMPTY_CELL;
			}
		}
		do{
			//Show the board

			System.out.println("Tic-Tac-Toe Board");
			System.out.println("-----------------");
			for(int i=0;i<numberOfRows;i++){
				for(int j=0;j<numberOfCols;j++){
					System.out.print("\t"+board[i][j]);
				}
				System.out.println();
			}
			System.out.println("It is the turn of player: "+currentPlayer);
			emptyPosition = Boolean.FALSE;
			do{
				if(freePositions>0 && !winner){
					System.out.println("Intro a position (row,col) between (0,2):"); //Originally the print was (0,3) which was not suitable to the range
					row = sc.nextInt();
					col = sc.nextInt();
					if(row<0 || row>numberOfRows-1 || col<0 || col>numberOfCols-1){
						System.out.println("The position is out of range.");
					}else{
						if(board[row][col] != EMPTY_CELL){
							System.out.println("The position has been already introduced.");
						}else{
							emptyPosition = Boolean.TRUE;
						}
					}
				}
			}while(row<0 || row>numberOfRows-1 || col<0 || col>numberOfCols-1 || !emptyPosition);

			board[row][col]=currentPlayer;
			

			//Improve to only check if there is no winner.
			//Check if currentPlayer is a winner in rows
			int matches = 0;
			winner = Boolean.FALSE;
			for(int i=0;i<numberOfRows && !winner;i++){
				matches = 0;
				for(int j=0;j<numberOfCols && !winner;j++){
					if(board[i][j] == (currentPlayer)){
						matches++;
					}
					winner = (matches == SIZE);
				}
			}
			//Check if currentPlayer is a winner in cols
			//FIXME: COMPLETE!
			winner = Boolean.FALSE;
			for(int i=0;i<numberOfCols && !winner;i++){
				matches = 0;
				for(int j=0;j<numberOfRows&& !winner;j++){
					if(board[j][i] == (currentPlayer)){
						matches++;
					}
					winner = (matches == SIZE);
				}

			}
			
			
			//Check main diagonal
			//FIXME: COMPLETE!
			if (board[0][0]==currentPlayer&&board[1][1]==currentPlayer&&board[2][2]==currentPlayer&& !winner){
				winner = true;
			}
			
			
			//Check secondary diagonal
			//FIXME: COMPLETE!
			if (board[0][2]==currentPlayer&&board[1][1]==currentPlayer&&board[2][0]==currentPlayer&& !winner){
				winner = true;
			}
					
			
			freePositions--; //Moved this function this position so the code checks also if there is a win in last turn
			
			//Change currentPlayer
			if(!winner){
				if(currentPlayer == (playerX)){
					currentPlayer = playerO;
				}else{
					currentPlayer = playerX;
				}
			}
		}while(!winner && freePositions>0);
		
		if(winner){
			System.out.println("The winner is player: "+currentPlayer);
		}else{
			System.out.println("Draw!");
		}

	}

}

