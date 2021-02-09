package sec01;

abstract class Student {
	
	protected int type;		//�л� ����
	protected String name;	//�л� �̸�
	protected int score;	//����
	protected String grade;	//����
	
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
		String result = "�Ҽ�\t�̸�\t����\t����\n";
		if (type==1) result += "�кλ�";
		else result += "���п���";
		result += "\t"+getName();
		result += "\t"+getScore();
		result += "\t"+getGrade();
		
		return result;
	}
	

}
