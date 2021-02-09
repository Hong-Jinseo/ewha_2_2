package sec01;
import java.util.Vector;	//* 해도 됨

public class VectorTest {

	public static void main(String[] args) {
		
		//정수값만 다루는 제네릭 벡터 생성
		//타입 구체화해주는 과정
		Vector<Integer> v = new Vector<>();	//뒤에 Integer 생략 가능
		
		//요소 삽입 (구체화시켜준 타입으로 삽입해야 함)
		//자동박싱 v.add(new Integer(100));
		//컴파일러에 의해 자동으로 value->object로
		v.add(100);
		v.add(90);
		System.out.println(v);
		//요소 중간삽입(인덱스 1 부분에 70 add)
		v.add(1,70);
		
		int sum=0;
		for (int i=0; i<v.size(); i++)
			//자동 언박싱(기본 자료형 sum에 object타입 변환되어 들어감)
			sum += v.get(i);
		System.out.println("벡터 값 총합 : "+sum);
	}
}
