package sec02;

public class CallTest3 {
	public static void main(String[] args) {
		int arr[] = {10, 20};
		System.out.println(arr[0]+","+arr[1]);
		swap(arr);
		System.out.println(arr[0]+","+arr[1]);		
	}
	
	static void swap(int arr[]) {
		int tmp = arr[0];
		arr[0] = arr[1];
		arr[1] = tmp;
	}
}
