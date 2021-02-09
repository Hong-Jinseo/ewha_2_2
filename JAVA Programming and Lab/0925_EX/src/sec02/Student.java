package sec02;

public class Student extends People {
	int stuNo;
	
	Student(String name, String ssn, int stuNO){
		super(name, ssn);
		this.stuNo = stuNO;
	}
}
