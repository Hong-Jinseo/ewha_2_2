package sec02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageViewer extends JFrame {
	//�����ڿ� ���� Ŭ�������� ���������� �����ϴ� ������Ʈ�� ��� ������ �����ϴ°� ȿ������ �ڵ�
	JButton btnprev, btnnext;
	ImageIcon [] image;
	JLabel imageLabel;
	int cnt;			//�� ��° �������� Ȯ���ϱ� ����
	
	ImageViewer() {
		setTitle("�������� ������ ����");
		Font f = new Font("", Font.BOLD, 30);
		
		JPanel panel = new JPanel();	//��ư�� �ִ� ����
		btnprev = new JButton("<<");
		btnnext = new JButton(">>");
		btnprev.setFont(f);
		btnnext.setFont(f);
		image = new ImageIcon[4];
		
		panel.setBackground(Color.orange);
		
		//�̹��� �ε� (������ ȿ�������� �ذ��ϱ� ���� �ݺ���)
		for(int i=0; i<image.length; i++) {
			String path = "image/img"+i+".png";
			image[i] = new ImageIcon(path);
		}
		
		//ó�� �̹���
		cnt = 0;		//�ݵ�� �ʿ��� �ڵ�� �ƴ�. ��� ������ ����� ���� �ڵ����� 0���� �ʱ�ȭ �Ǳ� ����
		imageLabel = new JLabel(image[cnt]);
		
		//������ ��� (���� Ŭ����)
		class Preview implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt--;
				imageLabel.setIcon(image[cnt]);
			}			
		}
		
		class Next implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				imageLabel.setIcon(image[cnt]);
			}
		}
		
		//������ ����
		btnprev.addActionListener(new Preview());
		btnnext.addActionListener(new Next());

		//������Ʈ ����
		add(imageLabel, "Center");
		panel.add(btnprev);
		panel.add(btnnext);
		add(panel, "South");
		setSize(500, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageViewer();
	}
}
