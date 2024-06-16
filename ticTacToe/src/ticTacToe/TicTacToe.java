package ticTacToe;
import java.util.Scanner;
public class TicTacToe {
	String[][] board = new String[][] {
		new String[] {" ", " ", " "},
		new String[] {" ", " ", " "},
		new String[] {" ", " ", " "}
	};
	byte rowNumber;
	byte columnNumber;
	char markSelected = 'X';
	enum Status {
		X_WINS,
		O_WINS,
		TIE,
		ROOM_LEFT
	}
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe!");
	}
	private String[] grid_comps = new String[] {
		"+---+---+---+",
		"|"
	};
	public void displayGrid() {
		System.out.print("\n");
		for (int x = 0; x < 3; x++) {
			System.out.println(grid_comps[0]);
			for (int y = 0; y < 3; y++) {
				System.out.print(grid_comps[1] + " " + board[x][y] + " ");
			}
			System.out.print(grid_comps[1] + "\n");
		}
		System.out.println(grid_comps[0]);
	}
	public void startGame(Scanner userInput) {
		this.displayGrid();
		boolean keepPlaying = true;
		do {
			switch (takeTurn(userInput)) {
			case X_WINS:
				System.out.println("X has won!");
				keepPlaying = false;
				break;
			case O_WINS:
				System.out.println("O has won!");
				keepPlaying = false;
				break;
			case TIE:
				System.out.println("The game has ended in a tie!");
				keepPlaying = false;
				break;
			case ROOM_LEFT:
			}
		} while (keepPlaying);
	}
	Status takeTurn(Scanner userInput) {
		System.out.println("\n" + this.markSelected + "'s turn");
		boolean emptySpace = false;
		do {
			System.out.print("Pick a row (1, 2, 3): ");
			this.rowNumber = (byte) (userInput.nextByte() - 1);
			System.out.print("Pick a column (1, 2, 3): ");
			this.columnNumber = (byte) (userInput.nextByte() - 1);
			String selectedSpace = this.board[this.rowNumber][this.columnNumber];
			if (selectedSpace == " ") {
				emptySpace = true;
			} else {
				System.out.println("That space is already occupied. Please pick another one!");
			}
		} while (!emptySpace);
		this.board[this.rowNumber][this.columnNumber] = String.valueOf(this.markSelected);
		switch (this.markSelected) {
		case 'X':
			this.markSelected = 'O';
			break;
		case 'O':
			this.markSelected = 'X';
			break;
		}
		this.displayGrid();
		return this.checkForWinner();
	}
	Status checkForWinner() {
		String a, b, c;
		for (int i = 0; i < 3; i++) {
			a = this.board[i][0];
			b = this.board[i][1];
			c = this.board[i][2];
			if ((a != " ") && a.equals(b) && a.equals(c)) {
				if (a.equals("X")) {
					return Status.X_WINS;
				} else {
					return Status.O_WINS;
				}
			}
		}
		a = this.board[0][0];
		b = this.board[1][1];
		c = this.board[2][2];
		if ((a != " ") && a.equals(b) && a.equals(c)) {
			if (a.equals("X")) {
				return Status.X_WINS;
			} else {
				return Status.O_WINS;
			}
		}
		a = this.board[0][0];
		b = this.board[1][1];
		c = this.board[2][2];
		if ((a != " ") && a.equals(b) && a.equals(c)) {
			if (a.equals("X")) {
				return Status.X_WINS;
			} else {
				return Status.O_WINS;
			}
		}
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (this.board[x][y] == " ") {
					return Status.ROOM_LEFT;
				}
			}
		}
		return Status.TIE;
	}
}