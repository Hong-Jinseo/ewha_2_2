package sec03;

public class Manager extends Staff{
	double bonus;
	
	Manager(String name, double pay, double bonus){
		super(name, pay);
		this.bonus = bonus;
	}
	
	@Override
	double payIncrease(int year) {
		double newPay=this.pay;
		for (int i=0; i<year; i++) {
			newPay *= 1.2;
		}
		return (Math.round(newPay*100)/100.0)+bonus;
	}
	

}
