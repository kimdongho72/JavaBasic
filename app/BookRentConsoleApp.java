package app;

import java.util.ArrayList;
import java.util.Scanner;

import book.Book;
import book.BookService;

public class BookRentConsoleApp {

	BookService bs = new BookService();

	public static void main(String[] args) {
		// BookRentConsoleApp 객체 생성
		BookRentConsoleApp app = new BookRentConsoleApp();

		// 환영인사
		app.displayWelcome();

		// 선택메뉴에 따라 기능 수행
		app.controlMenu();

	}

	private void displayWelcome() {
		System.out.println("************************************");
		System.out.println("*     도서 대여점에 오신 걸 환영합니다.    *");
		System.out.println("************************************");
	}

	private void controlMenu() {
		int menu;

		do {
			menu = getMenu(); // 메뉴 출력하고 메뉴 번호를 입력 받음
			switch (menu) {
			case 1:
				menuBookList();
				break;
			case 2:
				menuBookRent();
				break;
			case 3:
				menuBookRentList();
				break;
			case 4:
				menuBookReturn();
				break;
			case 5:
				menuBookRegist();
				break;
			case 6:
				menuBookUpdate();
				break;	
			case 7:
				menuBookRemove();
				break;	
			case 0:
				menuExit();
				break;
			default:
				System.out.println("없는 메뉴입니다.");
			}
		} while (menu != 0);
	}

	private void menuBookRemove() {
		allBookList();
		Scanner sc = new Scanner(System.in);
		System.out.println(">> 삭제할 도서 번호");
		int bookNo = sc.nextInt();
		
		bs.removeBook(bookNo);
		allBookList();
		
	}
	
	private void menuBookUpdate() {
		
		allBookList();
		Scanner sc = new Scanner(System.in);
		System.out.println(">> 수정할 도서 번호");
		int bookNo = sc.nextInt();
		System.out.println(">> 수정할 가격");
		int price = sc.nextInt();
		
		bs.updateBook(bookNo, price);
	}
	
	private void menuBookRegist() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 제목: ");
		String title = sc.nextLine();
		System.out.print(">> 저자: ");
		String author = sc.nextLine();
		System.out.print(">> 출판사: ");
		String publisher = sc.nextLine();
		System.out.print(">> 가격: ");
		int price = sc.nextInt();

		Book book = new Book(0, title, author, publisher, price, true); // 임시 값 0 할당
		bs.registBook(book);

		System.out.println("[알림] 도서가 등록되었습니다.");
		
	}
	
	private void menuBookRentList() {
		ArrayList<Book> bookList = bs.listRentBooks();
		displayBookList(bookList);
	}

	private void menuBookList() {
		ArrayList<Book> bookList = bs.listInstockBooks();
		displayBookList(bookList);
	}
	
	private void allBookList() {
		ArrayList<Book> bookList = bs.allBookList();
		System.out.println("모든 도서 목록");
		displayBookList(bookList);
	}

	private void displayBookList(ArrayList<Book> bookList) {
		System.out.println("---------------------------------");
		if (bookList.isEmpty()) {
			System.out.println("책이 없습니다.");
		} else {
			for (Book book : bookList) {
				System.out.println(book.toString());
			}
		}

		System.out.println("---------------------------------");
	}

	private void menuExit() {
		System.out.println("*** 도서 대여점 종료 ***");
	}

	private void menuBookRent() {
		displayBookList(bs.listInstockBooks());

		Scanner sc = new Scanner(System.in);
		System.out.print(">> 대여할 도서 번호 : ");
		int bookNo = sc.nextInt();

		if (bs.rentBook(bookNo)) {
			displayBookList(bs.listRentBooks());
		} else {
			System.out.println("[에러] 없는 도서이거나 이미 대여한 도서입니다.");
		}
	}

	private void menuBookReturn() {
		displayBookList(bs.listRentBooks());
		Scanner sc = new Scanner(System.in);
		System.out.print(">> 반납할 도서 번호 : ");
		int bookNo = sc.nextInt();

		if (bs.returnBook(bookNo)) {
			displayBookList(bs.listInstockBooks());
		} else {
			System.out.println("[에러] 없는 도서이거나 이미 반납한 도서입니다.");
		}

	}

	private int getMenu() {
		// 메뉴 출력
		System.out.println("=================================");
		System.out.println("1. 도서 목록 보기");
		System.out.println("2. 도서 대여");
		System.out.println("3. 도서 대여 현황 보기");
		System.out.println("4. 도서 반납");
		System.out.println("5. 도서 등록");
		System.out.println("6. 도서 정보 수정");
		System.out.println("7. 도서 삭제");
		System.out.println("0. 종료");
		System.out.println("=================================");
		System.out.print(">> 메뉴 선택 : ");

		// 메뉴 번호 입력
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		return menu;
	}

}