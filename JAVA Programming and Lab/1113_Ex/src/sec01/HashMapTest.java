package sec01;
import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, String> dic = new HashMap<>();
		String key;
		dic.put("apple", "���");
		dic.put("grape", "����");
		dic.put("orange", "������");
		dic.put("mango", "����");
		Scanner sc = new Scanner(System.in);
		
		//��ü���
		//k�� ������� �� ����
		//keySet() : Ű�� ����. �ؽøʿ� ����� ��� Ű ��ȯ
		for(String k: dic.keySet()) {
			String v = dic.get(k);
			System.out.println(k+" : "+v);
		}
		
		//�˻� ���
		while(true) {
			System.out.print("�ܾ��Է� : ");
			key = sc.next();
			if(key.equals("quit"))
				break;
			String value = dic.get(key);
			if(value==null)
				System.out.println("���� �ܾ��Դϴ�.");
			else
				System.out.println("�� : "+value);
		}
		sc.close();
		
	}
}