package SportsCard.test2;

import SportsCardShop.card.*;
import SportsCardShop.user.*;

import java.util.Scanner;

public class CardUserTestApp {
    public static void main(String[] args) {

        // DAO, Service 준비
        CardDAO cardDAO = new HashMapCardDAO();
        CardService cardService = new DHCardService(cardDAO);
        

        MemberDAO memberDAO = new HashMapMemberDAO();
        MemberService memberService = new DHMemberService(memberDAO);

        Scanner sc = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n[카드 + 유저 테스트]");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 전체 카드 보기");
            System.out.println("4. 카드 검색");
            System.out.println("5. 카드 등록");
            System.out.println("0. 종료");
            System.out.print(">> 메뉴 선택: ");

            String input = sc.nextLine();
            try {
                menu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자를 입력하세요.");
                continue;
            }

            switch (menu) {
                case 1 -> {
                    System.out.print("아이디: ");
                    String id = sc.next();
                    System.out.print("비밀번호: ");
                    String pw = sc.next();
                    System.out.print("이름: ");
                    String name = sc.next();
                    sc.nextLine();
                    boolean result = memberService.register(id, pw, name);
                    System.out.println(result ? "가입 성공" : "중복 아이디입니다");
                }
                case 2 -> {
                    System.out.print("아이디: ");
                    String id = sc.next();
                    System.out.print("비밀번호: ");
                    String pw = sc.next();
                    sc.nextLine();
                    MemberVO member = memberService.login(id, pw);
                    if (member != null)
                        System.out.println(member.getUsername() + "님 환영합니다");
                    else
                        System.out.println("로그인 실패");
                }
                case 3 -> cardService.searchCards("").forEach(System.out::println);
                case 4 -> {
                    System.out.print("검색어: ");
                    String kw = sc.nextLine();
                    cardService.searchCards(kw).forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("카드 ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("팀: ");
                    String team = sc.nextLine();
                    System.out.print("포지션: ");
                    String pos = sc.nextLine();
                    System.out.print("가격: ");
                    int price = Integer.parseInt(sc.nextLine());
                    System.out.print("재고: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    CardVO card = new CardVO(id, name, team, pos, price, stock, false, "일반", 2023, "Topps");
                    cardDAO.insert(card);
                    System.out.println("등록 완료");
                }
                case 0 -> {
                    System.out.println("종료합니다");
                    return;
                }
                default -> System.out.println("[오류] 올바른 메뉴 번호를 입력하세요.");
            }
        } while (true);
    }
}