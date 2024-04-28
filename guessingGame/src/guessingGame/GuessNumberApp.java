package guessingGame;

import java.util.Scanner;

public class GuessNumberApp {

	public static void main(String[] args) {
		Game guessingGame = new Game();
		
		guessingGame.displayWelcomeMessage();
			
		try (Scanner input = new Scanner(System.in)) {
			String userContinue;
				
			do {
				guessingGame.generateNumberToBeGuessed();
				guessingGame.displayPleaseGuessMessage();
				guessingGame.makeGuess(Integer.parseInt(input.nextLine()));
					
				while (!(guessingGame.isCorrectGuess())) {
					guessingGame.displayGuessAgainMessage();
					guessingGame.displayPleaseGuessMessage();
					guessingGame.makeGuess(Integer.parseInt(input.nextLine()));
				}
					
				guessingGame.displayCorrectGuessMesaage();
					
				System.out.print("\nTry again? (y/n): ");
				userContinue = input.nextLine();
				while (userContinue.equalsIgnoreCase("n")) {
					System.out.println("\nBye - Come back soon!");
					break;	
				}
				
			}
			
			while (userContinue.equalsIgnoreCase("y"));
		}
	}
}