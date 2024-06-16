package animalCounter;
public class Alligator extends Animal implements Countable {
	Alligator() {
		this.count = 0;
	}
	
	public void incrementCount() {
		this.count += 1;
	}
}