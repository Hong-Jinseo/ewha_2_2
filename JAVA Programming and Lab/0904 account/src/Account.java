
public class Account {
	public String name="Jinseo";
	public int balance=0;
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	public void deposit(int amount) {
		balance += amount;
	}
	
	public int returnBalance() {
		return balance;
	}
}