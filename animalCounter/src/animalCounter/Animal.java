package animalCounter;
public abstract class Animal {
	int count;
	public void resetCount() {
		this.count = 0;
	}
	public int getCount() {
		return this.count;
	}
}