package hw250430.challenge2;

public class Bird implements Countable {
	String name;

	public Bird(String name) {
		// name을 초기화하는 코드
		this.name = name;
	}

	public void fly() {
		System.out.println("2마리 " + name + "가 날아간다.");
	}
	// count()와 fly() 메서드를 위한 코드

	@Override
	public void count() {
		System.out.println(name + "가 2마리 있다.");
	}

	@Override
	public void ripen() {
	}
}