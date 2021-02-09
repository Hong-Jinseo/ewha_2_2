package sec01;

public class Circle extends Shape{
	
	final double PI = 3.14;
	private double radius;

	//»ý¼ºÀÚ
	Circle(String name, double radius){
		this.name = name;
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return PI*radius*radius;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*PI*radius;
	}

	@Override
	void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("name : "+getName());
		System.out.println("Area : "+getArea());
		System.out.println("Perimeter : "+getPerimeter());
	}
	
	

}
