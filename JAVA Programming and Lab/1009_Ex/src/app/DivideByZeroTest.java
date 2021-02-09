package app;
import java.util.*;	//scanner class

public class DivideByZeroTest {

	public static void main(String[] args) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.print("������ : ");
		x = sc.nextInt();
		System.out.print("���� : ");
		y = sc.nextInt();
		
		try {
			int result = x/y;
			System.out.println("��� : "+result);
		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�");
		}
		finally {
			sc.close();
		}
	}
}
