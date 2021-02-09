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
	String [] desc = {"대한민국 부산", "독일 드레스덴", "미국 뉴욕", "홍콩"};
	
	MyImageViewer() {
		setTitle("내가 가고 싶은 여행지");
		Font f = new Font("맑은 고딕", Font.BOLD, 30);
		
		JPanel panel = new JPanel();	//버튼을 넣는 공간
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
					JOptionPane.showMessageDialog(null, "처음 사진입니다", "오류 발생", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "마지막 사진입니다", "오류 발생", JOptionPane.ERROR_MESSAGE);
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
