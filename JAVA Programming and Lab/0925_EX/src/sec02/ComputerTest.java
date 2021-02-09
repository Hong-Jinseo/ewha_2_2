package sec02;

public class ComputerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 10;
		Calculator cal = new Calculator();
		System.out.println("원의 면적 : "+cal.areaCircle(r));
		
		Computer com = new Computer();
		System.out.println("원의 면적 : "+com.areaCircle(r));
	}

}
