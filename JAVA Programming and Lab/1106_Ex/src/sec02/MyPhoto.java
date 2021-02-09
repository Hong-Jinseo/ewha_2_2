package sec02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPhoto extends JFrame {
	JLabel lbl, imglbl;			//���� �ؽ�Ʈ, �̹����� ���̺�
	JButton btn;
	
	public MyPhoto() {
		setTitle("My photo");
		Font f = new Font("", Font.BOLD, 30);
		Color c = new Color(255, 187, 0);
		
		lbl = new JLabel("���� ��ǳ", SwingConstants.CENTER);
		lbl.setFont(f);
		lbl.setForeground(c);
		
		ImageIcon img1 = new ImageIcon("image/p1.png");		//�� ������Ʈ ���Ͽ� ���� ���� ��(1106_Ex ���� ���� �����ϱ�)
		ImageIcon img2 = new ImageIcon("image/p2.png");		//�̹��� �ҷ����� ����
		imglbl = new JLabel(img1);			//"p1.png"�ϸ� �׳� �� �ؽ�Ʈ�� ��µ�. ��ü �ʿ�
		
		btn = new JButton("����");
		btn.setFont(f);
		
		//������ ��� (�͸� Ŭ����)
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//���̺�(imglbl)�� �̹����� ����. setIcon()
				imglbl.setIcon(img2);
			}
		});
		
		add(lbl, "North");		//border layout���� ��ġ �����ֱ�
		add(imglbl, "Center");
		add(btn, "South");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyPhoto();
	}
}
