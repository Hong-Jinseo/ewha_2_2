package sec02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseClass extends JFrame {
	
	JLabel lbl;

	//������
	MouseClass(){
		setTitle("Mouse �̺�Ʈ ����");
		lbl = new JLabel("Cheer up");
		lbl.setForeground(Color.red);	//�����(������ �ݴ�) : ���ڻ�, ������ �׵θ� �� ����
		add(lbl);
		setLayout(new FlowLayout());
		
		//2. ������ ���
		this.addMouseListener(new MyMouse());	//���� ���۳�Ʈ ����� �� �ƴ϶� �׳� â ��ü�� ���!
		setSize(400, 400);
		setVisible(true);
	}
	
	//1.���� Ŭ������ ���콺 �̺�Ʈ ������ �ۼ�(MouseListener)
	class MyMouse implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			//���콺 ��ư�� ������ ��� ������ �Ű����� e�� �Ѿ��
			int x=e.getX();
			int y=e.getY();
			lbl.setLocation(x, y);
			System.out.println("("+x+", "+y+")");
			//System.out.println(e);		//e ����ϸ� e�� � ���� ��� �ִ��� �� �� ����
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	 }
		
	public static void main(String[] args) {
		new MouseClass();
	}
}
