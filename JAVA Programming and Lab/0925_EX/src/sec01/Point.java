package sec01;

public class Point {
	private int x, y;
	
	void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	void showPoint() {
		System.out.println("("+x+","+y+")");
	}
}
