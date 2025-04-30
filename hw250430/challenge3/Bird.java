package hw250430.challenge3;

public class Bird extends Countable {
	public Bird(String name, int num) {
		super(name, num);
	}
	void fly() {
		System.out.println("2마리 " + name + "가 날아간다.");
	}
	// count()와 fly() 메서드를 위한 코드

	@Override
	public void count() {
		System.out.println(name + "가 2마리 있다.");
	}
}