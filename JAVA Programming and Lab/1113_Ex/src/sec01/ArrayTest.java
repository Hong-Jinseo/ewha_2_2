package sec01;
import java.util.*;

public class ArrayTest {

	public static void main(String[] args) {
		
		//문자열만 삽입 가능한 array list 컬랙션 생성
		ArrayList<String> list = new ArrayList<String>();
		String str;
		
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			System.out.print("과일 이름>>");
			String s = scan.next();
			list.add(s);
		}
		
		//리스트에 있는 모든 이름 출력
		for(int i=0; i<list.size(); i++) {
			String name = list.get(i);
			System.out.println(name);
		}
		
		
		while(true) {
			System.out.print("찾는 이름(종료 quit)>>");
			str = scan.next();
			int index = list.indexOf(str);
			
			// ==:주소값 비교, equals():값 자체 비교
			//String은 클래스라서 같은 값 부여하더라도 서로 주소값 다를 수 있음
			if (str.equals("quit")) {
				System.out.println("종료");
				break;
			}
			else if(index==-1)
				System.out.println("검색 실패");
			else
				System.out.println(index+"에 위치함");
		}
	}
}
