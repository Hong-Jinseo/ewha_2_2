package sec01;
import javax.swing.*;	//컴포넌트 설계를 포함하는 클래스

public class FirstWindow {
	public static void main(String[] args) {
		
		//JFrame 클래스 이용 => 객체 생성
		JFrame f = new JFrame();
		f.setTitle("첫 윈도우 프로그램");
		f.setSize(500, 200);
		f.setVisible(true);
	}
}
