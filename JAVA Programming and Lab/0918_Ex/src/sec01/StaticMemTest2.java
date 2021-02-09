package sec01;
import java.util.*;


public class StaticMemTest2 {

	double pi=3.14;	//인스턴스 멤버
	public static void main(String[] args) {
		//System.out.println(pi); 정적 메소드에서 인스턴스 변수 접근 불가
		StaticMemTest2 s1 = new StaticMemTest2();
		System.out.println(s1.pi);
		
		//아니면 'static double pi'로 고치고 println(pi) 쓰기
	}
}
