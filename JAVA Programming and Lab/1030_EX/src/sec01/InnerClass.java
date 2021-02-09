package sec01;

import java.awt.*;			//��ġ������
import java.awt.event.*;	//�پ��� ������ �������̽�
import javax.swing.*;		//�پ��� ������Ʈ

public class InnerClass extends JFrame{
	JButton btn1, btn2;	//J��ư�� ���� ���������� ��������� ����� ���� Ŭ�������� ���� ����
	InnerClass(){
		setTitle("�׼��̺�Ʈ ������ ����");
		setLayout(new FlowLayout());
		btn1 = new JButton("Ȯ��");
		btn2 = new JButton("���");
		//JButton btn1 = new ��¼�� �ϸ� ����ũ�������� ���� �Ұ�
		
		//2.������ ��� (����)
		btn1.addActionListener(new MyGUI1());
		btn2.addActionListener(new MyGUI2());
		
		add(btn1);
		add(btn2);
		setSize(300,150);
		setVisible(true);
	}

	//1.���� Ŭ������ �̺�Ʈ ������ �ۼ�
	//setTitle() �޼ҵ� ���� ���� : innerclass�� JFrame ��� �޾Ҵµ� MyGUI�� InnerClass ���ο� �ִ� Ŭ�����̱� ����
	class MyGUI1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setTitle("Ȯ�� ��ư�� ��������");
			btn1.setText("OK");	//�̰� �ϱ� ���ؼ� : btn1�̶�� ��ü������ ������ ���� ��������� ���� 
			
		}
		
	}
	
	class MyGUI2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setTitle("��� ��ư�� ��������");			
		}
		
	}
	
	public static void main(String[] args)  {
		new InnerClass();
	}
}
