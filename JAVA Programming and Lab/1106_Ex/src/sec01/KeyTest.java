package sec01;

import javax.swing.*;
import java.awt.event.*;

public class KeyTest extends JFrame {
	KeyTest(){
		setTitle("Ű �̺�Ʈ ó��");
		
		//2.������ ���
		addKeyListener(new MyKey());
		setSize(300, 200);
		setVisible(true);
	}
	
	//1.������ Ŭ���� ���� (���� Ŭ����)
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
