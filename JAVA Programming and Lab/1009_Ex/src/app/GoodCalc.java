package app;
import lib.Calculator; //다른 패키지에 있어 따로 임포트 해 주어야 함

//부모 클래스의 추상 메소드들을 구현하지 않으면 오류 뜸
public class GoodCalc extends Calculator{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	@Override
	public double average(int[] a) {
		double sum = 0;
		for (int i=0; i<a.length; i++)
			sum += a[i];
		return sum/a.length;
	}
}
