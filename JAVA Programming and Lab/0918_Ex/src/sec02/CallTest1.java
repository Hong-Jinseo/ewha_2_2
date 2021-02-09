package sec02;

public class CallTest1 {

	public static void main(String[] args) {
		int x=10;
		System.out.println("x="+x);
		add(x);
		System.out.println("x="+x);
	}
	static void add(int x) {
		x++;
	}
}
