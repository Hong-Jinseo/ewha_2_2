package sec02;

import java.awt.*;
import javax.swing.*;

public class Piano extends JFrame {
	
	Piano(){
		setTitle("My Piano");
		setSize(700,200);
		setLayout(new GridLayout(1, 8));
		
		String[] arr = {"��", "��", "��", "��", "��", "��", "��", "��"};
		
		for (int i=0; i<arr.length; i++) 
			add(new JButton(arr[i]));
		setVisible(true);
	}

	public static void main(String[] args) {
		new Piano();
	}
}
