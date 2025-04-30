package hw250430.challenge1;

public class Tree implements Countable {
	// Bird 클래스와 유사하다.
	String name;

	public Tree(String name) {
		// name을 초기화하는 코드
		this.name = name;
	}

	void fly() {

	}

	@Override
	public void count() {
		System.out.println(name + "가 5그루 있다.");
	}
}
