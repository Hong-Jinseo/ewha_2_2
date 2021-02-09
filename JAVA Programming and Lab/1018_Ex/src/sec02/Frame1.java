package sec02;

import java.awt.*;
import javax.swing.*;

public class Frame1 extends JFrame{

	//생성자
	Frame1(){
		setTitle("Border Layout Test");
		setSize(400, 200);
		
		//컴포넌트 생성
		JButton b1 = new JButton("버튼1");
		JButton b2 = new JButton("버튼2");
		JButton b3 = new JButton("버튼3");
		JButton b4 = new JButton("버튼4");
		JButton b5 = new JButton("버튼5");
		
		add(b1,"North");	//이런 방식도 가능
		add(b2,BorderLayout.SOUTH);
		add(b3,BorderLayout.EAST);
		 add(b4,BorderLayout.WEST);
		add(b5,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Frame1();

	}

}
