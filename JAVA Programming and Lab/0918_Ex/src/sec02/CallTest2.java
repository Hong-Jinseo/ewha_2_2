package sec02;

class Circle{
	int r;
	Circle(int r){
		this.r = r;
	}
}

public class CallTest2 {

	public static void main(String[] args) {
		Circle c = new Circle(10);
		System.out.println("radius = "+c.r);
		size(c);
		System.out.println("radius = "+c.r);
	}
	
	static void size(Circle c) {//�ּҰ� ����
		c.r++;
	}

}
