package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IntroduceMySelf extends JFrame{
	JButton btn1, btn2;	
	JLabel label;
	
	IntroduceMySelf(){
		setTitle("나의 소개");
		setLayout(new FlowLayout());
		btn1 = new JButton("나의 이름");
		btn2 = new JButton("나의 꿈");
		label = new JLabel("");
		
		//2. 익명 클래스 리스너 종료
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText("나의 이름은 홍진서입니다.");
				label.setFont(new Font("함초롬바탕",Font.BOLD,25));
				label.setForeground(Color.ORANGE);
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText("나의 꿈은 부자입니다.");
				label.setFont(new Font("함초롬바탕",Font.BOLD,25));
				label.setForeground(Color.RED);
			}
		});
		
		add(btn1);
		add(btn2);
		add(label);
		setSize(400, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IntroduceMySelf();
	}
}
