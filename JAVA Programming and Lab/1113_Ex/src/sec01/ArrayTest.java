package sec01;
import java.util.*;

public class ArrayTest {

	public static void main(String[] args) {
		
		//���ڿ��� ���� ������ array list �÷��� ����
		ArrayList<String> list = new ArrayList<String>();
		String str;
		
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			System.out.print("���� �̸�>>");
			String s = scan.next();
			list.add(s);
		}
		
		//����Ʈ�� �ִ� ��� �̸� ���
		for(int i=0; i<list.size(); i++) {
			String name = list.get(i);
			System.out.println(name);
		}
		
		
		while(true) {
			System.out.print("ã�� �̸�(���� quit)>>");
			str = scan.next();
			int index = list.indexOf(str);
			
			// ==:�ּҰ� ��, equals():�� ��ü ��
			//String�� Ŭ������ ���� �� �ο��ϴ��� ���� �ּҰ� �ٸ� �� ����
			if (str.equals("quit")) {
				System.out.println("����");
				break;
			}
			else if(index==-1)
				System.out.println("�˻� ����");
			else
				System.out.println(index+"�� ��ġ��");
		}
	}
}
