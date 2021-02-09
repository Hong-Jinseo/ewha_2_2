package sec01;

public class GraduateStudent extends Student {

	public GraduateStudent(String name) {
		super(name);
		type = 2;
	}
	
	public void computeGrade() {
		if (score>=80)
			grade = "통과";
		else
			grade = "과락";			
	}
}
