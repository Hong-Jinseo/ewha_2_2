package sec01;
import java.util.*;


public class StaticMemTest2 {

	double pi=3.14;	//�ν��Ͻ� ���
	public static void main(String[] args) {
		//System.out.println(pi); ���� �޼ҵ忡�� �ν��Ͻ� ���� ���� �Ұ�
		StaticMemTest2 s1 = new StaticMemTest2();
		System.out.println(s1.pi);
		
		//�ƴϸ� 'static double pi'�� ��ġ�� println(pi) ����
	}
}
