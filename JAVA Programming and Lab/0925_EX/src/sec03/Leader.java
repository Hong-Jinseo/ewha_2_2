package sec03;

public class Leader extends Manager{
	double stockOption;
		
	Leader(String name, double pay, double bonus, double stockOption){
		super(name, pay, bonus);
		this.stockOption = stockOption;
	}
	
	@Override
	double payIncrease(int year) {
		double newPay=this.pay;
		for (int i=0; i<year; i++) {
			newPay *= 1.1;
		}
		return (Math.round(newPay*100)/100.0)+bonus+stockOption;
	}
	

}
