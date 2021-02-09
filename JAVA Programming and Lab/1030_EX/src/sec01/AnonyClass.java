package sec01;

import java.awt.*;			//배치관리자
import java.awt.event.*;	//다양한 리스너 인터페이스
import javax.swing.*;		//다양한 컴포넌트

public class AnonyClass extends JFrame{
	JButton btn1, btn2;		//컴포넌트
	AnonyClass(){
		setTitle("액션이벤트 리스너 예제");
		setLayout(new FlowLayout());
		btn1 = new JButton("확인");
		btn2 = new JButton("취소");
		
		//2. 익명 클래스 리스너 종료
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("확인 버튼을 눌렀군요");
				btn1.setBackground(Color.red);
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("취소 버튼을 눌렀군요");
			}
		});
		
		add(btn1);
		add(btn2);
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AnonyClass();
	}
}
