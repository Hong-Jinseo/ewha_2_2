package sec01;

import javax.swing.*;
import java.awt.event.*;

public class KeyTest extends JFrame {
	KeyTest(){
		setTitle("키 이벤트 처리");
		
		//2.리스너 등록
		addKeyListener(new MyKey());
		setSize(300, 200);
		setVisible(true);
	}
	
	//1.리스너 클래스 구현 (내부 클래스)
	class MyKey implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyChar());	
			System.out.println(e.getKeyCode());	
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}
	
	
	public static void main(String[] args) {
		new KeyTest();
	}
}
