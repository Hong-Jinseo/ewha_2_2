package sec02;

import java.awt.*;	//FlowLayout
import javax.swing.*;

public class Frame2 extends JFrame {
	
	Frame2(){
		setTitle("Flow Layout Test");
		setSize(500,200);
		
		//��ġ������ ���� (default : border)
		//FlowLayout f1 = new FlowLayout(); + setLayout(f1); �� ����
		setLayout(new FlowLayout());
		
		//������Ʈ
		JButton b1 = new JButton("��ư1");
		add(b1);
		add(new JButton("��ư2")); //�̰͵� ����
		add(new JButton("��ư3"));
		add(new JButton("��ư4"));
		add(new JButton("��ư5"));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Frame2();
	}

}
