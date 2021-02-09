package sec02;

public class Computer extends Calculator{
	@Override 
	//오버라이드 되었음을 알리는 표시. 
	//int r로 설정하면 시그니처 다르다고 알려줌
	double areaCircle(double r) {
		//super.areaCircle(r);
		double area = Math.PI*r*r;
		return area;
	}

}
