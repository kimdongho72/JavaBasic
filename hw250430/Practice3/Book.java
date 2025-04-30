package hw250430.Practice3;

public class Book implements Comparable<Object> {
	int price;

	Book(int price) {
		this.price = price;
	}

	void BookPrice() {
		System.out.println("Book [price=" + price + "]");
	}

	@Override
	public int compareTo(Object o) { 
		Book book = (Book) o; 

		
		if (this.price <= book.price)
			return -1;
		else
			return 1;
	}
}