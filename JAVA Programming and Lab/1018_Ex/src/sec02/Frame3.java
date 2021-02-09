package sec02;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame3 extends JFrame {
	
	Frame3(){
		setTitle("Grid Layout Test");
		setSize(300,200);
		
		setLayout(new GridLayout(2,2));
		
		//ÄÄÆ÷³ÍÆ®
		add(new JButton("¾È³ç"));
		add(new JButton("Àß°¡"));
		add(new JButton("¹è°íÆÄ"));
		add(new JButton("Á¹·Á"));

		setVisible(true);
	}

	public static void main(String[] args) {
		new Frame3();
	}
}
