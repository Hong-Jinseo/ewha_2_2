package app;
//�߻� Ŭ������ ��ü�� ������ �� ����

public class PackageTest {

	public static void main(String[] args) {
		
		int num[] = {1, 2, 6};
		GoodCalc c = new GoodCalc();
		
		System.out.println(c.add(2, 4));
		System.out.println(c.subtract(2, 4));
		System.out.println(c.average(num));
	}

}
