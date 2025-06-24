package SportsCardShop.app;

import SportsCardShop.admin.*;
import SportsCardShop.card.*;
import SportsCardShop.card.file.ObjFileHashMapCardDAO;
import SportsCardShop.order.*;
import SportsCardShop.user.*;
import SportsCardShop.user.file.ObjFileHashMapMemberDAO;
import SportsCardShop.cart.CartDAO;
import SportsCardShop.cart.CartService;
import SportsCardShop.cart.CartServiceImpl;
import SportsCardShop.cart.HashMapCartDAO;

import java.util.List;
import java.util.Scanner;
import SportsCardShop.cart.CartItemVO;

public class MainApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CardDAO cardDAO = new ObjFileHashMapCardDAO();
		MemberDAO memberDAO = new ObjFileHashMapMemberDAO();
		CartDAO cartDAO = new HashMapCartDAO();
		CartService cartService = new CartServiceImpl(cartDAO);

		OrderDAO orderDAO = new ListOrderDAO();

		CardService cardService = new DHCardService(cardDAO);

		MemberService memberService = new DHMemberService(memberDAO);

		OrderService orderService = new DHOrderService(orderDAO);
		AdminService adminService = new DHAdminService(cardService, memberService, orderDAO);

		MemberVO loginUser = null;

		while (true) {
			System.out.println("\n[스포츠 카드 쇼핑몰]");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 종료");
			System.out.print(">> 선택: ");

			String input = sc.nextLine();
			if (input.equals("0"))
				break;

			switch (input) {
			case "1" -> {
				System.out.print("아이디: ");
				String id = sc.nextLine();
				System.out.print("비밀번호: ");
				String pw = sc.nextLine();
				System.out.print("이름: ");
				String name = sc.nextLine();
				boolean result = memberService.register(id, pw, name);
				System.out.println(result ? "가입 성공" : "중복된 아이디입니다.");
			}
			case "2" -> {
				System.out.print("아이디: ");
				String id = sc.nextLine();
				System.out.print("비밀번호: ");
				String pw = sc.nextLine();
				loginUser = memberService.login(id, pw);
				if (loginUser != null) {
					System.out.println(loginUser.getUsername() + "님 환영합니다!");
					if (loginUser.getId().equals("admin"))
						runAdminMenu(sc, adminService, cardService);
					else
						runUserMenu(sc, loginUser, cardService, orderService, memberService, cartService);

					loginUser = null;
				} else {
					System.out.println("로그인 실패");
				}
			}
			default -> {
				System.out.println("올바른 번호를 입력하세요.");
			
			}

			}
		}
	}

	private static void runAdminMenu(Scanner sc, AdminService adminService, CardService cardService) {
		while (true) {
			System.out.println("\n[관리자 메뉴]");
			System.out.println("1. 전체 회원 목록");
			System.out.println("2. 전체 카드 목록");
			System.out.println("3. 전체 주문 목록");
			System.out.println("4. 카드 삭제");
			System.out.println("5. 카드 재고 수정");
			System.out.println("6. 회원 강제 탈퇴");
			System.out.println("7. 카드 등록");
			System.out.println("0. 로그아웃");
			System.out.print(">> 선택: ");

			String input = sc.nextLine();
			switch (input) {
			case "1" -> adminService.getAllMembers().forEach(System.out::println);
			case "2" -> adminService.getAllCards().forEach(System.out::println);
			case "3" -> adminService.getAllOrders().forEach(System.out::println);
			case "4" -> {
				System.out.print("삭제할 카드 ID: ");
				int id = readInt(sc);

				CardVO card = cardService.getCardById(id);
				if (card == null) {
					System.out.println("해당 카드가 존재하지 않습니다.");
					break;
				}

				boolean result = adminService.removeCard(id);
				System.out.println(result ? "삭제 완료" : "삭제 실패");
			}
			case "5" -> {
				System.out.print("카드 ID: ");
				int id = readInt(sc);
				System.out.print("새 재고 수량: ");
				int qty = readInt(sc);
				boolean updated = adminService.updateCardStock(id, qty);
				System.out.println(updated ? "재고 수정 완료" : "해당 카드 없음");
			}
			case "6" -> {
				System.out.print("삭제할 회원 번호: ");
				int memberNo = readInt(sc);
				boolean result = adminService.removeMember(memberNo);
				System.out.println(result ? "회원 삭제 완료" : "해당 회원이 존재하지 않습니다.");
			}
			case "7" -> {
				System.out.println("[카드 등록]");
				System.out.print("카드 이름: ");
				String name = sc.nextLine();
				System.out.print("팀명: ");
				String team = sc.nextLine();
				System.out.print("카테고리 (예: 축구/농구/야구): ");
				String category = sc.nextLine();
				System.out.print("가격: ");
				int price = readInt(sc);
				System.out.print("재고 수량: ");
				int stock = readInt(sc);
				System.out.print("인기 카드인가요? (true/false): ");
				boolean isPopular = Boolean.parseBoolean(sc.nextLine());
				System.out.print("등급 (예: A/B/C): ");
				String grade = sc.nextLine();
				System.out.print("연도 (예: 2023): ");
				int year = readInt(sc);
				System.out.print("브랜드 (예: Topps): ");
				String brand = sc.nextLine();

				int newId = cardService.getAllCards().stream().mapToInt(CardVO::getCardId).max().orElse(0) + 1;

				CardVO card = new CardVO(newId, name, team, category, price, stock, isPopular, grade, year, brand);
				boolean result = cardService.registerCard(card);

				System.out.println(result ? "카드 등록 완료" : "카드 등록 실패");
			}
			case "0" -> {
				return;
			}
			default -> System.out.println("잘못된 선택");
			}
		}
	}

	private static void runUserMenu(Scanner sc, MemberVO user, CardService cardService, OrderService orderService,
			MemberService memberService, CartService cartService) {
		while (true) {
			System.out.println("\n[사용자 메뉴]");
			System.out.println("1. 전체 카드 보기");
			System.out.println("2. 인기 카드 보기");
			System.out.println("3. 키워드 검색");
			System.out.println("4. 상세 필터 검색");
			System.out.println("5. 카드 주문하기");
			System.out.println("6. 내 주문 목록 보기");
			System.out.println("7. 비밀번호 변경");
			System.out.println("8. 회원 탈퇴");
			System.out.println("9. 장바구니 보기");
			System.out.println("10. 장바구니에 카드 추가하기");
			System.out.println("0. 로그아웃");
			System.out.print(">> 입력: ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1" -> cardService.searchCards("").forEach(System.out::println);
			case "2" -> cardService.getPopularCards().forEach(System.out::println);
			case "3" -> {
				System.out.print("검색어: ");
				String kw = sc.nextLine();
				cardService.searchCards(kw).forEach(System.out::println);
			}
			case "4" -> {
				System.out.print("키워드: ");
				String kw = sc.nextLine();
				System.out.print("최소 가격: ");
				int min = readInt(sc);
				System.out.print("최대 가격: ");
				int max = readInt(sc);
				System.out.print("(비어있으면 스킵) 등급: ");
				String grade = sc.nextLine();
				System.out.print("(비어있으면 스킵)연도: ");
				String yearInput = sc.nextLine().trim();
				int year = yearInput.isEmpty() ? 0 : Integer.parseInt(yearInput);

				System.out.print("(비어있으면 스킵)브랜드: ");
				String brand = sc.nextLine();
				System.out.print("(0이면 스킵)재고만 보기(true/false): ");
				boolean inStock = Boolean.parseBoolean(sc.nextLine());
				CardSearchCondition cond = new CardSearchCondition();
				cond.setKeyword(kw);
				cond.setMinPrice(min);
				cond.setMaxPrice(max);
				cond.setGrade(grade);
				cond.setYear(year);
				cond.setBrand(brand);
				cond.setInStockOnly(inStock);

				cardService.filterCards(cond).forEach(System.out::println);

			}
			case "5" -> {
				System.out.print("카드 ID: ");
				int cardId = readInt(sc);
				System.out.print("수량: ");
				int qty = readInt(sc);
				CardVO card = cardService.getCardById(cardId);
				if (card != null) {
					boolean success = orderService.orderCard(user.getMemberNo(), user.getUsername(), card, qty);
					System.out.println(success ? "주문 완료" : "재고 부족");
				} else
					System.out.println("카드를 찾을 수 없습니다");
			}
			case "6" -> orderService.getOrderListByMember(user.getMemberNo()).forEach(System.out::println);
			case "7" -> {
				System.out.print("기존 비밀번호: ");
				String oldPw = sc.nextLine();
				System.out.print("새 비밀번호: ");
				String newPw = sc.nextLine();
				boolean updated = memberService.updatePassword(user.getMemberNo(), oldPw, newPw);
				System.out.println(updated ? "비밀번호 변경 완료" : "기존 비밀번호가 일치하지 않습니다.");
			}

			case "8" -> {
				boolean result = memberService.remove(user.getMemberNo());
				System.out.println(result ? "회원 탈퇴 완료" : "회원 탈퇴 실패");
				if (result) {
					user = null;
					return;
				}
			}
			case "9" -> runCartMenu(sc, user, cartService, orderService);


			case "10" -> {
				System.out.print("장바구니에 담을 카드 ID: ");
				int cid = readInt(sc);
				System.out.print("수량: ");
				int qty = readInt(sc);

				CardVO card = cardService.getCardById(cid);
				if (card == null) {
				    System.out.println("해당 카드가 존재하지 않습니다.");
				} else if (qty <= 0) {
				    System.out.println("수량은 1 이상이어야 합니다.");
				} else if (card.getStock() < qty) {
				    System.out.println("재고 부족: 현재 재고는 " + card.getStock() + "개입니다.");
				} else {
				    CartItemVO item = new CartItemVO(card, qty);
				    cartService.addItemToCart(item);
				    System.out.println("장바구니에 추가되었습니다.");
				}
			}

			case "0" -> {
				return;
			}
			default -> System.out.println("잘못된 선택");
			}
		}
	}

	private static void runCartMenu(Scanner sc, MemberVO user, CartService cartService, OrderService orderService) {
	    while (true) {
	        System.out.println("\n[🛒 장바구니 메뉴]");
	        System.out.println("1. 장바구니 전체 주문");
	        System.out.println("2. 특정 카드 삭제");
	        System.out.println("3. 장바구니 비우기");
	        System.out.println("0. 뒤로가기");
	        System.out.print(">> 선택: ");

	        String input = sc.nextLine();
	        switch (input) {
	            case "1" -> {
	                List<CartItemVO> cartItems = cartService.listCartItems();
	                if (cartItems.isEmpty()) {
	                    System.out.println("장바구니가 비어 있습니다.");
	                    break;
	                }

	                boolean allOrdered = true;

	                for (CartItemVO item : cartItems) {
	                    CardVO card = item.getCard();
	                    int quantity = item.getQuantity();

	                    if (card.getStock() >= quantity) {
	                        boolean success = orderService.orderCard(
	                            user.getMemberNo(), user.getUsername(), card, quantity
	                        );
	                        if (success) {
	                            System.out.println("[" + card.getName() + "] 주문 완료");
	                        } else {
	                            System.out.println("[" + card.getName() + "] 주문 실패");
	                            allOrdered = false;
	                        }
	                    } else {
	                        System.out.println("[" + card.getName() + "] 재고 부족");
	                        allOrdered = false;
	                    }
	                }

	                if (allOrdered) {
	                    cartService.clearCart();
	                    System.out.println("장바구니 비웠습니다.");
	                } else {
	                    System.out.println("일부 주문이 실패했습니다. 재고 확인 후 다시 시도하세요.");
	                }
	            }
	            case "2" -> {
	                System.out.print("삭제할 카드 ID: ");
	                int id = readInt(sc);
	                boolean removed = cartService.removeCartItem(id);
	                System.out.println(removed ? "삭제 완료" : "장바구니에 해당 카드가 없습니다.");
	            }
	            case "3" -> {
	                cartService.clearCart();
	                System.out.println("장바구니가 비워졌습니다.");
	            }
	            case "0" -> { return; }
	            default -> System.out.println("잘못된 선택입니다.");
	        }
	    }
	}

	private static int readInt(Scanner sc) {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
			return readInt(sc);
		}
	}
}