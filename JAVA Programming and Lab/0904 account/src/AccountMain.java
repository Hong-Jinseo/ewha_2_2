import java.util.Scanner;

public class AccountMain {
	public static void main(String[] args) {
		
		Account a = new Account();
		Scanner sc = new Scanner(System.in);
		
		int menu, money;
		
		System.out.printf("%s���� ���ο� ���°� ����������ϴ�. \n", a.name);
		System.out.println("�Ա� :1, ��� :2, ���� :3");
		System.out.println("=====================");
				
		while(true) {
			System.out.printf("select menu : ");
			menu = sc.nextInt();
			
			if (menu==1) {
				System.out.printf("�Ա��� �ݾ� : ");
				money = sc.nextInt();
				a.deposit(money);
				System.out.printf("%d���� �ԱݵǾ����ϴ�. \n\n", money);
			}
			
			else if (menu==2) {
				System.out.print("����� �ݾ� : \n");
				money = sc.nextInt();
				if (a.returnBalance()<=money)
					System.out.print("�ܾ� ����\n\n");
				else {
					a.withdraw(money);
					System.out.printf("%d���� ��ݵǾ����ϴ�. \n\n", money);
				}
			}
			
			else if (menu==3) 
				break;
		}
		
		System.out.printf("%s���� ���� �ܾ��� %d�� �Դϴ�.\n", a.name, a.returnBalance());
		
		sc.close();
	}
}