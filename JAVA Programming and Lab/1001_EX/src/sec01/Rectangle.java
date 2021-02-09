package sec01;

public class Rectangle extends Shape{

	private double length;
	private double width;
	
	//»ý¼ºÀÚ
	Rectangle(String name, double length, double width){
		this.name = name;
		this.length = length;
		this.width = width;	
	}
	
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	
	@Override
	double getArea() {
		return length*width;
	}

	@Override
	double getPerimeter() {
		return 2*(length+width);
	}

	@Override
	void showInfo() {
		System.out.println("name : "+getName());
		System.out.println("Area : "+getArea());
		System.out.println("Perimeter : "+getPerimeter());
	}

}
