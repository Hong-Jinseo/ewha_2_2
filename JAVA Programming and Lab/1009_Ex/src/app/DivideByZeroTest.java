package app;
import java.util.*;	//scanner class

public class DivideByZeroTest {

	public static void main(String[] args) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.print("피젯수 : ");
		x = sc.nextInt();
		System.out.print("젯수 : ");
		y = sc.nextInt();
		
		try {
			int result = x/y;
			System.out.println("결과 : "+result);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}
		finally {
			sc.close();
		}
	}
}
