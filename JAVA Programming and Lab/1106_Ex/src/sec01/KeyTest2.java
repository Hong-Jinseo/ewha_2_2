package sec01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class KeyTest2 extends JFrame {
	Container c;
	JLabel lbl;
	
	KeyTest2(){
		setTitle("Ű �̺�Ʈ ����");
		
		lbl = new JLabel("<Enter>Ű�� ������ ����˴ϴ�."); 
		Font f = new Font("", Font.BOLD, 20);	//�̷��� ��Ʈ ��ü f�� ���� ���� �̰������� Ȱ�� ����
		lbl.setFont(f);							//��Ʈ ��ü �ʿ�
		
		//this.setBackground(Color.orange); 			//�̷��� �ϸ� �ȵ�
		//getContentPane().setBackground(Color.orange);	//�̰� ������
		c = getContentPane();
		c.setBackground(Color.orange);
		
		//������ ���
		c.addKeyListener(new MyKey());
		add(lbl);
		setSize(400, 400);
		setVisible(true);
		c.requestFocus();
	}
	
	//KeyAdapter Ŭ������ ������ ����
	class MyKey extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
		
			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				String color;
				c.setBackground(new Color(r,g,b));
				color="("+r+", "+g+", "+b+")";
				lbl.setText(color);
			}
			
			if (e.getKeyChar()=='q')
				System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new KeyTest2();
	}
}
