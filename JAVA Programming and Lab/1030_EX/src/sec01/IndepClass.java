package sec01;

//���迡 ���Ϳ�!
import java.awt.*;			//��ġ������
import java.awt.event.*;	//�پ��� ������ �������̽�
import javax.swing.*;		//�پ��� ������Ʈ

//1. ������ Ŭ������ �̺�Ʈ ������ �ۼ�
class MyGUI1 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn.getText().contentEquals("Ȯ��"))
			btn.setText("OK");
		else
			btn.setText("Ȯ��");
	}
}
//�� Ŭ������ ����Ϸ��� �� Ŭ������ ��ü�� �ʿ���


public class IndepClass extends JFrame{
	//������
	IndepClass(){
		setTitle("�׼��̺�Ʈ ������ ����");
		setLayout(new FlowLayout());
		JButton btn = new JButton("Ȯ��");
		
		//2. ������ ���
		btn.addActionListener(new MyGUI1());	//MyGUI�� ���� ��ü�� ���� ������� ��
		add(btn);
		setSize(300, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new IndepClass();
	}
}
