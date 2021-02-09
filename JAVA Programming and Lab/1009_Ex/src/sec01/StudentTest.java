package sec01;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name;
		int score, type;
		
		System.out.print("학생유형 입력(학부생=1, 대학원생=2) : ");
		type = sc.nextInt();
		System.out.print("이름 입력 : ");
		name = sc.next();
		System.out.print("점수 입력 : ");
		score = sc.nextInt();
		
		UndergraduateStudent us = new UndergraduateStudent(name);
		GraduateStudent gs = new GraduateStudent(name);
		
		if (type==1) {
			us.setType(type);
			us.setScore(score);
			us.computeGrade();
			System.out.println(us.showInfo());
		}
		else {
			gs.setType(type);
			gs.setScore(score);
			gs.computeGrade();
			System.out.println(gs.showInfo());
		}
		
		sc.close();
	}
}
