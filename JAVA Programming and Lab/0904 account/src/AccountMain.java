import java.util.Scanner;

public class AccountMain {
	public static void main(String[] args) {
		
		Account a = new Account();
		Scanner sc = new Scanner(System.in);
		
		int menu, money;
		
		System.out.printf("%s님의 새로운 계좌가 만들어졌습니다. \n", a.name);
		System.out.println("입금 :1, 출금 :2, 종료 :3");
		System.out.println("=====================");
				
		while(true) {
			System.out.printf("select menu : ");
			menu = sc.nextInt();
			
			if (menu==1) {
				System.out.printf("입금할 금액 : ");
				money = sc.nextInt();
				a.deposit(money);
				System.out.printf("%d원이 입금되었습니다. \n\n", money);
			}
			
			else if (menu==2) {
				System.out.print("출금할 금액 : \n");
				money = sc.nextInt();
				if (a.returnBalance()<=money)
					System.out.print("잔액 부족\n\n");
				else {
					a.withdraw(money);
					System.out.printf("%d원이 출금되었습니다. \n\n", money);
				}
			}
			
			else if (menu==3) 
				break;
		}
		
		System.out.printf("%s님의 최종 잔액은 %d원 입니다.\n", a.name, a.returnBalance());
		
		sc.close();
	}
}