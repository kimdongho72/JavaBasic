package bank;
import java.util.Scanner;
public class BankApplication {
	   public static void main(String[] args) {
		      Scanner sc = new Scanner(System.in);
		      BankService service = new BankService();
		      boolean run = true;

		      while (run) {
		         System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		         System.out.print("선택> ");
		         String input = sc.nextLine();

		         switch (input) {
		         case "1":
		            System.out.print("계좌번호: ");
		            String accNo = sc.nextLine();
		            System.out.print("계좌주: ");
		            String owner = sc.nextLine();
		            System.out.print("초기입금액: ");
		            int balance = Integer.parseInt(sc.nextLine());

		            if (service.addAccount(accNo, owner, balance)) {
		               System.out.println("결과: 계좌가 생성되었습니다.");
		            } else {
		               System.out.println("이미 존재하는 계좌입니다.");
		            }
		            break;

		         case "2":
		            for (Account acc : service.getAccounts()) {
		               System.out.println(acc.toString());
		            }
		            break;

		         case "3":
		            System.out.print("계좌번호: ");
		            accNo = sc.nextLine();
		            System.out.print("예금액: ");
		            int deposit = Integer.parseInt(sc.nextLine());

		            if (service.deposit(accNo, deposit)) {
		               System.out.println("결과: 예금이 완료되었습니다.");
		            } else {
		               System.out.println("계좌를 찾을 수 없습니다.");
		            }
		            break;

		         case "4":
		            System.out.print("계좌번호: ");
		            accNo = sc.nextLine();
		            System.out.print("출금액: ");
		            int withdraw = Integer.parseInt(sc.nextLine());

		            if (service.withdraw(accNo, withdraw)) {
		               System.out.println("결과: 출금이 완료되었습니다.");
		            } else {
		               System.out.println("잔액 부족 또는 계좌를 찾을 수 없습니다.");
		            }
		            break;

		         case "5":
		            System.out.println("프로그램 종료");
		            run = false;
		            break;

		         default:
		            System.out.println("잘못된 입력입니다.");
		         }
		      }

		      sc.close();
		   }


}
