package sec02;

public class Computer extends Calculator{
	@Override 
	//�������̵� �Ǿ����� �˸��� ǥ��. 
	//int r�� �����ϸ� �ñ״�ó �ٸ��ٰ� �˷���
	double areaCircle(double r) {
		//super.areaCircle(r);
		double area = Math.PI*r*r;
		return area;
	}

}
