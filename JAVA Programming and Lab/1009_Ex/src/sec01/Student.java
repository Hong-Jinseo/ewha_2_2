package sec01;

abstract class Student {
	
	protected int type;		//학생 유형
	protected String name;	//학생 이름
	protected int score;	//점수
	protected String grade;	//학점
	
	public Student(String name) {
		this.name = name;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public String getGrade() {
		return grade;
	}
	
	
	abstract public void computeGrade();
	
	public String showInfo() {
		String result = "소속\t이름\t점수\t학점\n";
		if (type==1) result += "학부생";
		else result += "대학원생";
		result += "\t"+getName();
		result += "\t"+getScore();
		result += "\t"+getGrade();
		
		return result;
	}
	

}
