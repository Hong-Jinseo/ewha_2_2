package sec03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyImageViewer extends JFrame {
	JButton btnprev, btnnext;
	ImageIcon [] imageIcon;
	Image image;
	JLabel imageLabel, descLabel;
	int cnt;
	String [] desc = {"���ѹα� �λ�", "���� �巹����", "�̱� ����", "ȫ��"};
	
	MyImageViewer() {
		setTitle("���� ���� ���� ������");
		Font f = new Font("���� ���", Font.BOLD, 30);
		
		JPanel panel = new JPanel();	//��ư�� �ִ� ����
		btnprev = new JButton("<<");
		btnnext = new JButton(">>");
		btnprev.setFont(f);
		btnnext.setFont(f);
		imageIcon = new ImageIcon[4];
		descLabel = new JLabel(desc[cnt], SwingConstants.CENTER);
		descLabel.setFont(f);
		
		panel.setBackground(Color.orange);
		
		for(int i=0; i<imageIcon.length; i++) {
			String path = "myImage/image"+i+".jpg";
			imageIcon[i] = new ImageIcon(path);
			image = imageIcon[i].getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
			imageIcon[i] = new ImageIcon(image);
			
		}
		
		imageLabel = new JLabel(imageIcon[cnt]);
		
	
		class Preview implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cnt==0)
					JOptionPane.showMessageDialog(null, "ó�� �����Դϴ�", "���� �߻�", JOptionPane.ERROR_MESSAGE);
				else {
					cnt--;
					imageLabel.setIcon(imageIcon[cnt]);
					descLabel.setText(desc[cnt]);
					
				}
			}			
		}
		
		class Next implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cnt==imageIcon.length-1)
					JOptionPane.showMessageDialog(null, "������ �����Դϴ�", "���� �߻�", JOptionPane.ERROR_MESSAGE);
				else {
					cnt++;
					imageLabel.setIcon(imageIcon[cnt]);
					descLabel.setText(desc[cnt]);
				}
			}
		}
		
		btnprev.addActionListener(new Preview());
		btnnext.addActionListener(new Next());

		add(imageLabel, "North");
		add(descLabel, "Center");
		panel.add(btnprev);
		panel.add(btnnext);
		add(panel, "South");
		setSize(600, 770);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyImageViewer();
	}
}
