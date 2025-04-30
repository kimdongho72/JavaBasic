package hw250430.challenge3;

abstract class Countable {
	protected String name;
	protected int num;
	Countable(String name, int num) {
		this.name = name;
		this.num = num;
	}
	abstract public void count();
}