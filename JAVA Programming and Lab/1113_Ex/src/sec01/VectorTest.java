package sec01;
import java.util.Vector;	//* �ص� ��

public class VectorTest {

	public static void main(String[] args) {
		
		//�������� �ٷ�� ���׸� ���� ����
		//Ÿ�� ��üȭ���ִ� ����
		Vector<Integer> v = new Vector<>();	//�ڿ� Integer ���� ����
		
		//��� ���� (��üȭ������ Ÿ������ �����ؾ� ��)
		//�ڵ��ڽ� v.add(new Integer(100));
		//�����Ϸ��� ���� �ڵ����� value->object��
		v.add(100);
		v.add(90);
		System.out.println(v);
		//��� �߰�����(�ε��� 1 �κп� 70 add)
		v.add(1,70);
		
		int sum=0;
		for (int i=0; i<v.size(); i++)
			//�ڵ� ��ڽ�(�⺻ �ڷ��� sum�� objectŸ�� ��ȯ�Ǿ� ��)
			sum += v.get(i);
		System.out.println("���� �� ���� : "+sum);
	}
}
