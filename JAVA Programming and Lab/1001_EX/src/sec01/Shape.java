package sec01;

abstract public class Shape {
	//�������
	protected String name;
	
	//�Ϲݸ޼ҵ�
	String getName() {
		return name;
	}
	
	//������
	
	//�߻�޼ҵ�
	abstract double getArea();
	abstract double getPerimeter();
	abstract void showInfo();
}
