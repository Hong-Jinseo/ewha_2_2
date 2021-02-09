package sec02;
import java.util.*;

public class BirthdayHashMap {
	
	static Scanner sc = new Scanner(System.in);
	
	//��ü ���
	public static void printData(HashMap<String, String> dic) {
		for(String k: dic.keySet()) {
			String v = dic.get(k);
			System.out.println(k+" : "+v);	
		}
	}
	
	
	//�˻�
	public static void search(HashMap<String, String> dic) {
		while(true) {
			System.out.print("�̸� �Է�(����� quit) : ");
			String key = sc.next();
			if(key.equals("quit"))
				break;
			String value = dic.get(key);
			if(value==null)
				System.out.println("���� �̸��Դϴ�.");
			else
				System.out.println("���� : "+value);
		}
	}
	
	
	//�߰�
	public static void addData(HashMap<String, String> dic) {
		String key, value;
		while(true) {
			System.out.print("�߰��� �̸� �Է�(����� quit) : ");
			key = sc.next();
			if(key.equals("quit")) break;
			else if(dic.containsKey(key)) {
				System.out.println("�̹� �����ϴ� �̸��Դϴ�.");
				continue;
			}
			System.out.print("�߰��� ���� �Է� : ");
			value = sc.next();
			dic.put(key, value);
		}
	}
	
	
	//����
	public static void deleteData(HashMap<String, String> dic) {
		String key;
		while(true) {
			System.out.print("������ �̸� �Է� (����� quit) : ");
			key = sc.next();
			if(key.equals("quit")) 
				break;
			else if(!dic.containsKey(key))
				System.out.println("�������� �ʴ� �̸��Դϴ�.");
			else
				dic.remove(key);
		}
	}
	
	
	//main �޼ҵ�
	public static void main(String[] args) {

		HashMap<String, String> dic = new HashMap<>();
		int menu;
		dic.put("����", "0626");
		dic.put("�ƺ�", "0828");
		dic.put("����", "0228");
		dic.put("����", "0909");
		
		
		while(true) {
			System.out.println("== MENU ==");
			System.out.println("1.��ü ���  2.�˻�  3.�߰�  4.����  5.����");
			System.out.print("���Ͻô� ����� �����ϼ���(��ȣ�� �Է�) : ");
			menu = sc.nextInt();
			
			if(menu==5) break;
			
			switch(menu) {
				case 1:
					printData(dic);
					break;
				case 2:
					search(dic);
					break;
				case 3:
					addData(dic);
					break;
				case 4:
					deleteData(dic);
					break;		
				default:
					System.out.println("����� �ٽ� �����ϼ���.");
					break;
			}
			System.out.println("");
		}	
		System.out.println("�����մϴ�.");
	}
	

	
}