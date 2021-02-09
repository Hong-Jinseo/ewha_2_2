package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseClass2 extends JFrame {
	
	JLabel lbl;

	//생성자
	MouseClass2(){
		setTitle("Mouse 이벤트 예제");
		lbl = new JLabel("Cheer up");
		lbl.setForeground(Color.red);	//전경색(배경색의 반대) : 글자색, 도형의 테두리 등 포함
		add(lbl);
		setLayout(new FlowLayout());
		
		//2. 리스너 등록
		this.addMouseListener(new MyMouse());	//따로 컨퍼넌트 만드는 게 아니라 그냥 창 자체에 출력!
		setSize(400, 400);
		setVisible(true);
	}
	
	//1.내부 클래스로 어댑터클래스 상속받아 사용
	class MyMouse extends MouseAdapter{		//인터페이스가 아닌 클래스
		
		@Override
		public void mousePressed(MouseEvent e) {
			//마우스 버튼을 누르면 모든 정보가 매개변수 e로 넘어옴
			int x=e.getX();
			int y=e.getY();
			lbl.setLocation(x, y);
			System.out.println("("+x+", "+y+")");
			//System.out.println(e);		//e 출력하면 e에 어떤 정보 담고 있는지 알 수 있음
		}
	 }
		
	public static void main(String[] args) {
		new MouseClass2();
	}
}
