package TicTacToe;

import java.util.Scanner;

public class Game {
	private Board board;
	private Pieces playerX;
	private Pieces playerO;
	private Pieces currentPlayer;

	public Game() {
		board = new Board();
		playerX = new Pieces('X');
		playerO = new Pieces('O');
		currentPlayer = playerX;
	}

	public void startGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe!");

		while (!board.checkWin()) {
			board.printBoard();
			System.out.println("It's " + currentPlayer.getPlayer() + "'s turn.");

			// Ask for user a row and column
			System.out.print("Enter row (1-3): ");
			int row = scanner.nextInt() - 1;
			System.out.print("Enter column (1-3): ");
			int col = scanner.nextInt() - 1;

			// Make the move for the current player
			if (!currentPlayer.play(board, row, col)) {
				System.out.println("Invalid move! Try again.");
				continue;
			}

			// Switch to the next player
			if (currentPlayer == playerX) {
				currentPlayer = playerO;
			} else {
				currentPlayer = playerX;
			}

			// print final board and winner or tie message

			if (board.checkDraw()) {
				System.out.println("It's a Draw!");
				board.resetBoard();
			} else if (board.checkWin()) {
				board.printBoard();
				if (currentPlayer == playerX) {
					System.out.println("Player O wins!");
				} else {
					System.out.println("Player X wins!");
				}
			}
		}
	}
}
