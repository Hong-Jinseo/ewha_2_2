package app;

public class ArrayExceptionTest {

	public static void main(String[] args) {
		int[] arr = new int[5];	//�迭 ���� ��� �����ϱ�
		
		try {
			for (int i=0; i<=arr.length; i++)
				arr[i] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ������ �ʰ���");
		}
	}

}
