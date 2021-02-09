package sec01;

import java.awt.*;			//배치관리자
import java.awt.event.*;	//다양한 리스너 인터페이스
import javax.swing.*;		//다양한 컴포넌트

public class InnerClass extends JFrame{
	JButton btn1, btn2;	//J버튼에 대한 참조변수를 멤버변수로 만들면 내부 클래스에서 접근 가능
	InnerClass(){
		setTitle("액션이벤트 리스너 예제");
		setLayout(new FlowLayout());
		btn1 = new JButton("확인");
		btn2 = new JButton("취소");
		//JButton btn1 = new 어쩌구 하면 내부크래스에서 접근 불가
		
		//2.리스너 등록 (연결)
		btn1.addActionListener(new MyGUI1());
		btn2.addActionListener(new MyGUI2());
		
		add(btn1);
		add(btn2);
		setSize(300,150);
		setVisible(true);
	}

	//1.내부 클래스로 이벤트 리스너 작성
	//setTitle() 메소드 접근 가능 : innerclass가 JFrame 상속 받았는데 MyGUI는 InnerClass 내부에 있는 클래스이기 때문
	class MyGUI1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setTitle("확인 버튼을 눌렀군요");
			btn1.setText("OK");	//이걸 하기 위해서 : btn1이라는 객체변수를 생성자 위에 멤버변수로 정의 
			
		}
		
	}
	
	class MyGUI2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setTitle("취소 버튼을 눌렀군요");			
		}
		
	}
	
	public static void main(String[] args)  {
		new InnerClass();
	}
}
