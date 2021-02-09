package sec01;

public class ColorPointTest {

	public static void main(String[] args) {
		Point p = new Point();
		p.setPoint(3, 4);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.setColor("white");
		cp.setPoint(2, 6);		//상속받음
		cp.showColorPoint();
	}

}
