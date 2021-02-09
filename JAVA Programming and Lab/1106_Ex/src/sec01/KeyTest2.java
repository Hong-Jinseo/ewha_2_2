package sec01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class KeyTest2 extends JFrame {
	Container c;
	JLabel lbl;
	
	KeyTest2(){
		setTitle("키 이벤트 예제");
		
		lbl = new JLabel("<Enter>키도 배경색이 변경됩니다."); 
		Font f = new Font("", Font.BOLD, 20);	//이렇게 폰트 객체 f로 따로 빼면 이곳저곳에 활용 가능
		lbl.setFont(f);							//폰트 객체 필요
		
		//this.setBackground(Color.orange); 			//이렇게 하면 안됨
		//getContentPane().setBackground(Color.orange);	//이건 가능함
		c = getContentPane();
		c.setBackground(Color.orange);
		
		//리스너 등록
		c.addKeyListener(new MyKey());
		add(lbl);
		setSize(400, 400);
		setVisible(true);
		c.requestFocus();
	}
	
	//KeyAdapter 클래스로 리스너 정의
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
