package sec01;

import javax.swing.*;

public class HelloFrame extends JFrame {

	//������
	HelloFrame(){
		setTitle("ù ��° ������ ���α׷�");
		setSize(400, 200);
		//��ư ������Ʈ ���� : JButton 
		JButton btn1 = new JButton("Ȯ��");
		add(btn1);		
		setVisible(true);
	}

	public static void main(String[] args) {
		//��ü ����
		HelloFrame f = new HelloFrame();
	}
}
