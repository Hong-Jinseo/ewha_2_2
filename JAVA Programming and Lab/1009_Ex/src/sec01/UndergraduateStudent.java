package sec01;

public class UndergraduateStudent extends Student {

	public UndergraduateStudent(String name) {
		super(name);
		type = 1;
	}
	
	public void computeGrade() {
		if (score>=70)
			grade = "���";
		else
			grade = "����";			
	}
}
