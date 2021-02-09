package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseClass extends JFrame {
	
	JLabel lbl;

	//생성자
	MouseClass(){
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
	
	//1.내부 클래스로 마우스 이벤트 리스너 작성(MouseListener)
	class MyMouse implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			//마우스 버튼을 누르면 모든 정보가 매개변수 e로 넘어옴
			int x=e.getX();
			int y=e.getY();
			lbl.setLocation(x, y);
			System.out.println("("+x+", "+y+")");
			//System.out.println(e);		//e 출력하면 e에 어떤 정보 담고 있는지 알 수 있음
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	 }
		
	public static void main(String[] args) {
		new MouseClass();
	}
}
