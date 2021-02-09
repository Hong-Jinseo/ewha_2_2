package app;

public class ArrayExceptionTest {

	public static void main(String[] args) {
		int[] arr = new int[5];	//배열 선언 방법 공부하기
		
		try {
			for (int i=0; i<=arr.length; i++)
				arr[i] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 초과함");
		}
	}

}
