package sec02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPhoto extends JFrame {
	JLabel lbl, imglbl;			//각각 텍스트, 이미지용 레이블
	JButton btn;
	
	public MyPhoto() {
		setTitle("My photo");
		Font f = new Font("", Font.BOLD, 30);
		Color c = new Color(255, 187, 0);
		
		lbl = new JLabel("가을 단풍", SwingConstants.CENTER);
		lbl.setFont(f);
		lbl.setForeground(c);
		
		ImageIcon img1 = new ImageIcon("image/p1.png");		//꼭 프로젝트 파일에 사진 넣을 것(1106_Ex 폴더 내에 저장하기)
		ImageIcon img2 = new ImageIcon("image/p2.png");		//이미지 불러오는 과정
		imglbl = new JLabel(img1);			//"p1.png"하면 그냥 저 텍스트가 출력됨. 객체 필요
		
		btn = new JButton("변경");
		btn.setFont(f);
		
		//리스너 등록 (익명 클래스)
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//레이블(imglbl)의 이미지를 변경. setIcon()
				imglbl.setIcon(img2);
			}
		});
		
		add(lbl, "North");		//border layout에서 위치 정해주기
		add(imglbl, "Center");
		add(btn, "South");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyPhoto();
	}
}
