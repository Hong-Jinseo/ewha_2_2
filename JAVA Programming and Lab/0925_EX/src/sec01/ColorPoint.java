package sec01;

public class ColorPoint extends Point{
	String color;
	
	void setColor(String color) {
		this.color=color;
	}
	
	void showColorPoint() {
		System.out.println(color);
		showPoint();	//부모 클래스를 상속받았기에 이렇게 쓸 수 있음
	}
}
