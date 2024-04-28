package guessingGame;

import java.util.Random;

public class Game {
	int number;
	int guessNumber;
	int counter;
	
	public void generateNumberToBeGuessed() {
		Random randomNumber = new Random();
		this.number = randomNumber.nextInt(100) + 1;
		this.counter = 0;
	}
	
	public void makeGuess(int userGuess) {
		this.guessNumber = userGuess;
		this.counter++;
	}
	
	public boolean isCorrectGuess() {
		return (this.number == this.guessNumber);
	}
	
	public void displayWelcomeMessage() {
		System.out.println("I'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it.");
	}
	
	public void displayPleaseGuessMessage() {
		System.out.print("\nEnter a number between 1 and 100: ");
	}
	
	public void displayCorrectGuessMesaage() {
		System.out.println("You got it in " + counter + " tries.");
		
		if (this.counter <= 3) {
			System.out.println("Great work! You are a mathematical wizard.");
		} else if (this.counter <= 7 ) {
			System.out.println("Not too bad! You've got some potential.");
		} else {
			System.out.println("What took you so long.");
		}
	}
	
	public void displayGuessAgainMessage() {
		int guessDiff = this.guessNumber - this.number;
		
		if (guessDiff > 10) {
			System.out.println("Way too high! Guess again.");
		} else if (guessDiff > 0) {
			System.out.println("Too high! Guess again.");
		} else if (guessDiff < -10) {
			System.out.println("Way too low! Guess again.");
		} else {
			System.out.println("Too low! Guess again.");
		}
	}
}