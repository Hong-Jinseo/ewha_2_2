package sec01;
import java.util.*;

class Circle{
	static double pi=3.14; //���� ����
	static double area(double r) {
		double area = pi*r*r;
		return area;
	}
	
	//�� �ѷ� ���ϴ� ���� �޼ҵ�
	static double space(double r) {
		return 2*pi*r;
	}
	
}

public class StaticMemTest {

	public static void main(String[] args) {
		System.out.print("������ �Է� : ");
		Scanner sc = new Scanner(System.in);
		
		double r = sc.nextDouble();
		System.out.println(Circle.area(r));
		System.out.println(Circle.space(r));
		sc.close();
	}

}
