package hw250430.challenge3;

public class CountableTest {
	public static void main(String[] args) {
		Countable[] m = { new Bird("뻐꾸기", 5), new Bird("독수리", 2), new Tree("사과나무", 10), new Tree("밤나무", 7) };

		for (Countable e : m) {
			e.count();
		}

		for (int i = 0; i < m.length; i++) {
			// 타입에 따라 fly() 또는 ripen() 메서드를 호출하는 코드
			if (m[i] instanceof Bird) {
				((Bird) m[i]).fly();
			} else {
				((Tree) m[i]).ripen();
			}
		}
	}
}
