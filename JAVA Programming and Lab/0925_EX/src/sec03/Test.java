package sec03;

public class Test {

	public static void main(String[] args) {
		
		int year = 3;	//�Ի� 3������� ����
		
		Staff p1 = new Staff("ȫ����", 250);
		System.out.println(p1.name+"�� �Ի� "+year+"���� ������ "+p1.payIncrease(year)+"���� �Դϴ�.");
		
		Manager p2 = new Manager("�ƺ�", 400, 50);
		System.out.println(p2.name+"�� �Ի� "+year+"���� ������ "+p2.payIncrease(year)+"���� �Դϴ�.");
		
		Leader p3 = new Leader("����", 600, 70, 30);
		System.out.println(p3.name+"�� �Ի� "+year+"���� ������ "+p3.payIncrease(year)+"���� �Դϴ�.");

	}

}
