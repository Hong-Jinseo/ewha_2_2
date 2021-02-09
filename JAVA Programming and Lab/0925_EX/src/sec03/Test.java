package sec03;

public class Test {

	public static void main(String[] args) {
		
		int year = 3;	//입사 3년차라고 가정
		
		Staff p1 = new Staff("홍진서", 250);
		System.out.println(p1.name+"의 입사 "+year+"년차 월급은 "+p1.payIncrease(year)+"만원 입니다.");
		
		Manager p2 = new Manager("아빠", 400, 50);
		System.out.println(p2.name+"의 입사 "+year+"년차 월급은 "+p2.payIncrease(year)+"만원 입니다.");
		
		Leader p3 = new Leader("엄마", 600, 70, 30);
		System.out.println(p3.name+"의 입사 "+year+"년차 월급은 "+p3.payIncrease(year)+"만원 입니다.");

	}

}
