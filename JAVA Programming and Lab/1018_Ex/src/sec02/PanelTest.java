package sec02;

import java.awt.*;
import javax.swing.*;

public class PanelTest extends JFrame {
	
	PanelTest(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		
		JButton b1 = new JButton("OK");
		JButton b2 = new JButton("Cancel");
		b1.setBackground(Color.yellow);
		b2.setBackground(Color.yellow);
		
		panel.add(b1);
		panel.add(b2);
		add(panel);			//default: center
		
		setTitle("Panel Test");
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PanelTest();
	}
}
