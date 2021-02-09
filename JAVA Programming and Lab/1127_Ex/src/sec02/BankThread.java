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
					System.out.println(getName() + " : ������ balance:"+obj.balance);
					System.out.println(getName() + " : ã�� �ݾ�:"+money);
					obj.withdraw(money);
					System.out.println(getName() + " : ������ balance:"+obj.balance);
					System.out.println();
				}
				else {
					System.out.println("�ܾ� ����");
					break;
				}
			}
		}
	}
}

public class BankThread {
	public static void main(String[] args) {
		Bank t1 = new Bank("ATM");
		Bank t2 = new Bank("����");
		
		t2.start();
		t1.start();
	}
}