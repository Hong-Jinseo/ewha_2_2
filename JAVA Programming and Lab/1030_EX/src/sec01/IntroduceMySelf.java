package sec01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IntroduceMySelf extends JFrame{
	JButton btn1, btn2;	
	JLabel label;
	
	IntroduceMySelf(){
		setTitle("���� �Ұ�");
		setLayout(new FlowLayout());
		btn1 = new JButton("���� �̸�");
		btn2 = new JButton("���� ��");
		label = new JLabel("");
		
		//2. �͸� Ŭ���� ������ ����
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText("���� �̸��� ȫ�����Դϴ�.");
				label.setFont(new Font("���ʷҹ���",Font.BOLD,25));
				label.setForeground(Color.ORANGE);
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText("���� ���� �����Դϴ�.");
				label.setFont(new Font("���ʷҹ���",Font.BOLD,25));
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
