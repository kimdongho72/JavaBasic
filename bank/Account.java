package bank;

public class Account {
	   private String accNo;
	   private String owner;
	   private int balance;

	   public Account(String accNo, String owner, int balance) {
	      this.accNo = accNo;
	      this.owner = owner;
	      this.balance = balance;
	   }

	   public String getAccNo() {
	      return accNo;
	   }

	   public String getOwner() {
	      return owner;
	   }

	   public int getBalance() {
	      return balance;
	   }

	   public void deposit(int amount) {
	      balance += amount;
	   }

	   public boolean withdraw(int amount) {
	      if (balance >= amount) {
	         balance -= amount;
	         return true;
	      }
	      return false;
	   }

	   public String toString() {
	      return accNo + "\t" + owner + "\t" + balance;
	   }
	}


