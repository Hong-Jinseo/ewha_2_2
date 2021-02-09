package sec01;
import java.util.*;

class Circle{
	static double pi=3.14; //정적 변수
	static double area(double r) {
		double area = pi*r*r;
		return area;
	}
	
	//원 둘레 구하는 정적 메소드
	static double space(double r) {
		return 2*pi*r;
	}
	
}

public class StaticMemTest {

	public static void main(String[] args) {
		System.out.print("반지름 입력 : ");
		Scanner sc = new Scanner(System.in);
		
		double r = sc.nextDouble();
		System.out.println(Circle.area(r));
		System.out.println(Circle.space(r));
		sc.close();
	}

}
