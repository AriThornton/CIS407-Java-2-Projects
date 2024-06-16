package animalCounter;
public class Sheep extends Animal implements Countable {
	Sheep() {
		this.count = 0;
	}
	public void decrementCount() {
		if (this.count > 0) {
			this.count -=1;
		}
	}
	
	public void incrementCount() {
		this.count += 2;
	}

}