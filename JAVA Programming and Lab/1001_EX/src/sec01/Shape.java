package sec01;

abstract public class Shape {
	//멤버변수
	protected String name;
	
	//일반메소드
	String getName() {
		return name;
	}
	
	//생성자
	
	//추상메소드
	abstract double getArea();
	abstract double getPerimeter();
	abstract void showInfo();
}
