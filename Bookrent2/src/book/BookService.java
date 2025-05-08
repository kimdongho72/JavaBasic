package book;

import java.util.ArrayList;

public class BookService {
	private int nextBookNo = 401;

	private ArrayList<Book> bookList = new ArrayList<>();

	public BookService() {
		loadBookList();
	}

	//도서 삭제 추가.
	public void removeBook(int bookNo) {
		// 2학년 선배님이 도와줌.. get(i)를 처음 써봤읍니다.
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookNo() == bookNo) {
				bookList.remove(i);  
				System.out.println("[알림] 도서가 삭제되었습니다.");
			}
		}
	}
	
	// 도서 등록 추가.
	public void registBook(Book book) {
		book.setBookNo(nextBookNo);  
		bookList.add(book);
		nextBookNo += 100; // 자동으로 100씩 증가
		
	}
	
	// 도서 정보 수정 추가.
	public void updateBook(int bookNo, int price) {
		for(Book book : bookList) {
			if(book.getBookNo() == bookNo) {
				book.setPrice(price);
				System.out.println("[알림] 가격이 수정되었습니다.");
				return;
			}
		}
		
		System.out.println("[오류] 해당하는 책을 찾을 수 없습니다.");
	}

	private void loadBookList() {
		bookList.add(new Book(101, "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", 20000, true));
		bookList.add(new Book(201, "나의 첫 알고리즘 + 자료구조", "코리 알트호프", "한빛미디어", 21000, true));
		bookList.add(new Book(301, "Do It! HTML+CSS+자바스크립트", "고경희", "이지스퍼블리싱", 32000, true));
	}

	public ArrayList<Book> listInstockBooks() {
		return listBooks(true);
	}

	public ArrayList<Book> listRentBooks() {
		return listBooks(false);
	}
	
	//모든 도서 목록 보여주기 추가
	public ArrayList<Book> allBookList() {
		return	bookList;
	}

	private ArrayList<Book> listBooks(boolean isInstock) {
		ArrayList<Book> books = new ArrayList<>();

		for (Book book : bookList) {
			if (book.isInstock() == isInstock)
				books.add(book);
		}

		return books;
	}

	public boolean rentBook(int bookNo) {
		return changeRentStatus(bookNo, false);
	}
	
	public boolean returnBook(int bookNo) {
		return changeRentStatus(bookNo, true);
	}

	private boolean changeRentStatus(int bookNo, boolean isInstock) {
		for (Book book : bookList) {
			if (book.getBookNo() == bookNo && book.isInstock() != isInstock) {
				book.setInstock(isInstock);
				return true;
			}
		}
		return false;
	}

}