package sec02;
import java.util.Scanner;

public class CalculatorTest {
	public static void main(String[] args) {
		
		int num1, num2;
		
		Calculator cal = new Calculator();
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("숫자 두 개를 순서대로 입력하시오 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		cal.show(num1, num2);
		sc.close();
	}
}
