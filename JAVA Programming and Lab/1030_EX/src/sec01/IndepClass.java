package sec01;

//시험에 나와요!
import java.awt.*;			//배치관리자
import java.awt.event.*;	//다양한 리스너 인터페이스
import javax.swing.*;		//다양한 컴포넌트

//1. 독립된 클래스로 이벤트 리스너 작성
class MyGUI1 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn.getText().contentEquals("확인"))
			btn.setText("OK");
		else
			btn.setText("확인");
	}
}
//위 클래스를 사용하려면 위 클래스의 객체가 필요함


public class IndepClass extends JFrame{
	//생성자
	IndepClass(){
		setTitle("액션이벤트 리스너 예제");
		setLayout(new FlowLayout());
		JButton btn = new JButton("확인");
		
		//2. 리스너 등록
		btn.addActionListener(new MyGUI1());	//MyGUI에 대한 객체를 만들어서 연결시켜 줌
		add(btn);
		setSize(300, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new IndepClass();
	}
}
