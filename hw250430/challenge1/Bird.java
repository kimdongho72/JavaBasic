package hw250430.challenge1;

public class Bird implements Countable {
	String name;

	public Bird(String name) {
		
		this.name = name;
	}

	void fly() {

	}
	

	@Override
	public void count() {
		System.out.println(name + "가 2마리 있다.");
	}
}