package sec01;

public class Student {
	//�ʵ弱�� - ���� �̸��� �ҹ���
	//����, �̸�, ����, �а�
	String nation="���ѹα�";
	String name;
	int age;
	String dept;
	
	
	//������ - �����ε� : ������ �̸� ���� but �Ű����� �ٸ�
	Student(String name, int age){
		//this.name=name;
		//this.age=age;
		this(name, age,"�İ�");
	}
	
	Student(String name, int age, String dept){
		this.name=name;
		this.age=age;
		this.dept=dept;
	}
	
	
	//�޼ҵ� (������/������)
	void setName(String name) {
		this.name=name;
	}
	
	void setNation(String nation) {
		this.nation = nation;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	
	void setDept(String dept) {
		this.dept = dept;
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
	
	String getDept() {
		return dept;
	}
	
	void show() { 
		System.out.println("���� : "+nation); //���� ����
		System.out.println("�̸� : "+getName());
		System.out.println("���� : "+getAge());
		System.out.println("���� : "+getDept());
	}
	
}
