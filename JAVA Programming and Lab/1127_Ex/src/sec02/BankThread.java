package sec02;

class Account{
	int balance = 10000;
	public void withdraw(int money) {
		if (balance >= money) {
			//try {
			//	Thread.sleep(1000);
			//}catch(Exception e) {}
			
			balance -= money;
		}
	}
}

class Bank extends Thread{
	
	static Account obj = new Account();
	public Bank (String name) { super(name); }
	
	public void run() {
		while(true) {
			synchronized(obj) {
				int money = (int)(Math.random()*3+1)*1000;
				if(obj.balance >= money) {
					System.out.println(getName() + " : 원본의 balance:"+obj.balance);
					System.out.println(getName() + " : 찾는 금액:"+money);
					obj.withdraw(money);
					System.out.println(getName() + " : 수정된 balance:"+obj.balance);
					System.out.println();
				}
				else {
					System.out.println("잔액 부족");
					break;
				}
			}
		}
	}
}

public class BankThread {
	public static void main(String[] args) {
		Bank t1 = new Bank("ATM");
		Bank t2 = new Bank("은행");
		
		t2.start();
		t1.start();
	}
}