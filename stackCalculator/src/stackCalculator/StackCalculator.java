package stackCalculator;
import java.util.Stack;
import java.util.ArrayList;
public class StackCalculator {
	Stack<Double> calculator = new Stack<Double>();
	public COMMANDS command;
	public enum COMMANDS {
		PUSH,
		ADD,
		SUB,
		MULT,
		DIV,
		CLEAR,
		LIST,
		QUIT
	}
	public void displayWelcomeMessage() {
		System.out.println("Welcome to the Stack Calculator\n");
	}
	public void displayCommands() {
		System.out.println("Commands: push n, add, sub, mult, div, list, clear, or quit.\n");
	}
	public void push(double n) {
		this.calculator.push(n);
	}
	public double pop() {
		try {
			return this.calculator.pop();
		} catch (Exception e) {
			System.out.println("Error: pop operation could not be completed. Are you sure there was an item left in the stack?");
			return 0;
		}
	}
	public int size() {
		return this.calculator.size();
	}
	public ArrayList<Double> getValues() {
		ArrayList<Double> result = new ArrayList<Double>();
		this.calculator.forEach((n) -> result.add(n));
		return result;
	}
	public void listStack() {
		ArrayList<Double> list = this.getValues();
		if (this.calculator.size() > 0) {
			list.forEach((n) -> System.out.println(n));
		} else {
			System.out.println("empty");
		}
		System.out.println();
	}
	public void clearStack() {
		this.calculator.clear();
	}
}