package stackCalculator;
import java.util.Scanner;
import stackCalculator.StackCalculator.COMMANDS;
public class StackCalculatorApp {
	public static COMMANDS assignInput(String input) {
		if (input.contains("push")) {
			return COMMANDS.PUSH;
		} else if (input.equals("add")) {
			return COMMANDS.ADD;
		} else if (input.equals("sub")) {
			return COMMANDS.SUB;
		} else if (input.equals("mult")) {
			return COMMANDS.MULT;
		} else if (input.equals("div")) {
			return COMMANDS.DIV;
		} else if (input.equals("list")) {
			return COMMANDS.LIST;
		} else if (input.equals("clear")) {
			return COMMANDS.CLEAR;
		} else if (input.equals("quit")) {
			return COMMANDS.QUIT;
		}
		System.out.println("Error: Unrecognized command.");
		return COMMANDS.LIST; // Fail-safe
	}
	public static void main(String[] args) {
		StackCalculator calc = new StackCalculator();
		calc.displayWelcomeMessage();
		calc.displayCommands();
		try (Scanner userInput = new Scanner(System.in)) {
			outer: do {
				String userString = userInput.nextLine();
				calc.command = assignInput(userString);
				double x, y;
				switch (calc.command) {
				case PUSH:
					double value = Integer.valueOf(userString.substring(5));
					calc.push(value);
					break;
				case ADD:
					x = calc.pop();
					y = calc.pop();
					calc.push(x + y);
					break;
				case SUB:
					x = calc.pop();
					y = calc.pop();
					calc.push(x - y);
					break;
				case MULT:
					x = calc.pop();
					y = calc.pop();
					calc.push(x * y);
					break;
				case DIV:
					x = calc.pop();
					y = calc.pop();
					calc.push(y / x);
					break;
				case CLEAR:
					calc.clearStack();
					break;
				case LIST:
					break;
				case QUIT:
					break outer;
				}
				calc.listStack();
			} while (true);
			System.out.println("Thanks for using the Stack Calculator.");	
		}
	}
}