package sec01;

import java.awt.*;			//��ġ������
import java.awt.event.*;	//�پ��� ������ �������̽�
import javax.swing.*;		//�پ��� ������Ʈ

public class AnonyClass extends JFrame{
	JButton btn1, btn2;		//������Ʈ
	AnonyClass(){
		setTitle("�׼��̺�Ʈ ������ ����");
		setLayout(new FlowLayout());
		btn1 = new JButton("Ȯ��");
		btn2 = new JButton("���");
		
		//2. �͸� Ŭ���� ������ ����
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Ȯ�� ��ư�� ��������");
				btn1.setBackground(Color.red);
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("��� ��ư�� ��������");
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
