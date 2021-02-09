package sec03;

public class Staff {
	String name;	//�̸�
	double pay;		//�޿�. ���� ����
	
	Staff(String name, double pay){
		this.name = name;
		this.pay = pay;
	}
	
	double payIncrease(int year) {
		double newPay=this.pay;
		for (int i=0; i<year; i++) {
			newPay *= 1.3;
		}
		return (Math.round(newPay*100)/100.0);
	}
}
