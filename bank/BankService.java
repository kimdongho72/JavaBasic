package bank;
import java.util.ArrayList;
public class BankService {
	      private ArrayList<Account> accountList = new ArrayList<>();

	   public boolean addAccount(String accNo, String owner, int balance) {
	      if (findAccount(accNo) == null) {
	         accountList.add(new Account(accNo, owner, balance));
	         return true;
	      }
	      return false;
	   }

	   public ArrayList<Account> getAccounts() {
	      return accountList;
	   }

	   public boolean deposit(String accNo, int amount) {
	      Account acc = findAccount(accNo);
	      if (acc != null) {
	         acc.deposit(amount);
	         return true;
	      }
	      return false;
	   }

	   public boolean withdraw(String accNo, int amount) {
	      Account acc = findAccount(accNo);
	      if (acc != null) {
	         return acc.withdraw(amount);
	      }
	      return false;
	   }

	   private Account findAccount(String accNo) {
	      for (Account acc : accountList) {
	         if (acc.getAccNo().equals(accNo)) {
	            return acc;
	         }
	      }
	      return null;
	   }
	}