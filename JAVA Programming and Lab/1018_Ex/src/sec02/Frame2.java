package sec02;

import java.awt.*;	//FlowLayout
import javax.swing.*;

public class Frame2 extends JFrame {
	
	Frame2(){
		setTitle("Flow Layout Test");
		setSize(500,200);
		
		//배치관리자 변경 (default : border)
		//FlowLayout f1 = new FlowLayout(); + setLayout(f1); 도 가능
		setLayout(new FlowLayout());
		
		//컴포넌트
		JButton b1 = new JButton("버튼1");
		add(b1);
		add(new JButton("버튼2")); //이것도 가능
		add(new JButton("버튼3"));
		add(new JButton("버튼4"));
		add(new JButton("버튼5"));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Frame2();
	}

}
