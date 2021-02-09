package sec01;
import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, String> dic = new HashMap<>();
		String key;
		dic.put("apple", "사과");
		dic.put("grape", "포도");
		dic.put("orange", "오렌지");
		dic.put("mango", "망고");
		Scanner sc = new Scanner(System.in);
		
		//전체출력
		//k에 순서대로 값 들어옴
		//keySet() : 키의 집합. 해시맵에 저장된 모든 키 반환
		for(String k: dic.keySet()) {
			String v = dic.get(k);
			System.out.println(k+" : "+v);
		}
		
		//검색 기능
		while(true) {
			System.out.print("단어입력 : ");
			key = sc.next();
			if(key.equals("quit"))
				break;
			String value = dic.get(key);
			if(value==null)
				System.out.println("없는 단어입니다.");
			else
				System.out.println("뜻 : "+value);
		}
		sc.close();
		
	}
}