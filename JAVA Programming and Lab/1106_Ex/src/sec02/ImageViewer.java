package sec02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageViewer extends JFrame {
	//생성자와 내부 클래스에서 공통적으로 접근하는 컴포넌트는 멤버 변수로 선언하는게 효율적인 코드
	JButton btnprev, btnnext;
	ImageIcon [] image;
	JLabel imageLabel;
	int cnt;			//몇 번째 사진인지 확인하기 위함
	
	ImageViewer() {
		setTitle("랜선으로 떠나는 여행");
		Font f = new Font("", Font.BOLD, 30);
		
		JPanel panel = new JPanel();	//버튼을 넣는 공간
		btnprev = new JButton("<<");
		btnnext = new JButton(">>");
		btnprev.setFont(f);
		btnnext.setFont(f);
		image = new ImageIcon[4];
		
		panel.setBackground(Color.orange);
		
		//이미지 로딩 (문제를 효율적으로 해결하기 위한 반복문)
		for(int i=0; i<image.length; i++) {
			String path = "image/img"+i+".png";
			image[i] = new ImageIcon(path);
		}
		
		//처음 이미지
		cnt = 0;		//반드시 필요한 코드는 아님. 멤버 변수로 선언된 값은 자동으로 0으로 초기화 되기 때문
		imageLabel = new JLabel(image[cnt]);
		
		//리스너 등록 (내부 클래스)
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
		
		//리스너 연결
		btnprev.addActionListener(new Preview());
		btnnext.addActionListener(new Next());

		//컴포넌트 부착
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
