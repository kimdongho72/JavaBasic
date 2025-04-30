package hw250430.challenge3;

class Tree extends Countable {
	// Bird 클래스와 유사하다.

	public Tree(String name, int num) {
		super(name, num);
	}

	public void ripen() {
		System.out.println(name + "에 열매가 잘 익었다.");
	}

	@Override
	public void count() {
		System.out.println(name + "가 5그루 있다.");
	}
}