package sec02;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame3 extends JFrame {
	
	Frame3(){
		setTitle("Grid Layout Test");
		setSize(300,200);
		
		setLayout(new GridLayout(2,2));
		
		//������Ʈ
		add(new JButton("�ȳ�"));
		add(new JButton("�߰�"));
		add(new JButton("�����"));
		add(new JButton("����"));

		setVisible(true);
	}

	public static void main(String[] args) {
		new Frame3();
	}
}
