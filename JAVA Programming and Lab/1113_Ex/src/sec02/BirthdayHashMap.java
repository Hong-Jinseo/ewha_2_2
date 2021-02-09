package sec02;
import java.util.*;

public class BirthdayHashMap {
	
	static Scanner sc = new Scanner(System.in);
	
	//전체 출력
	public static void printData(HashMap<String, String> dic) {
		for(String k: dic.keySet()) {
			String v = dic.get(k);
			System.out.println(k+" : "+v);	
		}
	}
	
	
	//검색
	public static void search(HashMap<String, String> dic) {
		while(true) {
			System.out.print("이름 입력(종료는 quit) : ");
			String key = sc.next();
			if(key.equals("quit"))
				break;
			String value = dic.get(key);
			if(value==null)
				System.out.println("없는 이름입니다.");
			else
				System.out.println("생일 : "+value);
		}
	}
	
	
	//추가
	public static void addData(HashMap<String, String> dic) {
		String key, value;
		while(true) {
			System.out.print("추가할 이름 입력(종료는 quit) : ");
			key = sc.next();
			if(key.equals("quit")) break;
			else if(dic.containsKey(key)) {
				System.out.println("이미 존재하는 이름입니다.");
				continue;
			}
			System.out.print("추가할 생일 입력 : ");
			value = sc.next();
			dic.put(key, value);
		}
	}
	
	
	//삭제
	public static void deleteData(HashMap<String, String> dic) {
		String key;
		while(true) {
			System.out.print("삭제할 이름 입력 (종료는 quit) : ");
			key = sc.next();
			if(key.equals("quit")) 
				break;
			else if(!dic.containsKey(key))
				System.out.println("존재하지 않는 이름입니다.");
			else
				dic.remove(key);
		}
	}
	
	
	//main 메소드
	public static void main(String[] args) {

		HashMap<String, String> dic = new HashMap<>();
		int menu;
		dic.put("진서", "0626");
		dic.put("아빠", "0828");
		dic.put("엄마", "0228");
		dic.put("오빠", "0909");
		
		
		while(true) {
			System.out.println("== MENU ==");
			System.out.println("1.전체 출력  2.검색  3.추가  4.삭제  5.종료");
			System.out.print("원하시는 기능을 선택하세요(번호만 입력) : ");
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
					System.out.println("기능을 다시 선택하세요.");
					break;
			}
			System.out.println("");
		}	
		System.out.println("종료합니다.");
	}
	

	
}