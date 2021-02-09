package sec01;

public class Student {
	//필드선언 - 변수 이름은 소문자
	//국적, 이름, 나이, 학과
	String nation="대한민국";
	String name;
	int age;
	String dept;
	
	
	//생성자 - 오버로딩 : 생성자 이름 같음 but 매개변수 다름
	Student(String name, int age){
		//this.name=name;
		//this.age=age;
		this(name, age,"컴공");
	}
	
	Student(String name, int age, String dept){
		this.name=name;
		this.age=age;
		this.dept=dept;
	}
	
	
	//메소드 (접근자/설정자)
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
		System.out.println("국적 : "+nation); //직접 접근
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("전공 : "+getDept());
	}
	
}
