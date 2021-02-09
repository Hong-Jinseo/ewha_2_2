package sec01;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class PianoWithSound extends JFrame {
	
	Font f = new Font("���� ���", Font.BOLD, 30);
	Font f2 = new Font("���� ���", Font.PLAIN, 30);
	Color color = new Color(255, 252, 186);
	
	JLabel lb1 = new JLabel("MUSIC : ");
	JLabel lb2 = new JLabel();
	JTextField fileName = new JTextField(".txt", 19);
	JTextField fileName_load = new JTextField(".txt", 19);
	
	
	//����� ���� ��� �Լ�
	public void Play(String fileName){
        try{
        	//����� �Է� ��Ʈ�� : �Է� ��ġ�κ��� �ڹ� ���α׷����� ����� ������ ����
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch (Exception ex) {}
    }
	
   	
	PianoWithSound() {
		setTitle("My Piano with sound");
		setSize(700, 700);
		//â ��ü�� ��(�ǹ�)/�Ʒ�(���� ���) �� ���� �����ϵ��� �� grid layout
		setLayout(new GridLayout(2, 1));
				
		
		/* �ǾƳ� �� �ǹ� JButton*/
		//ù��° ��ǹ� ��ư(��)
		JButton jbtn1 = new JButton();
		jbtn1.setBackground(Color.white);				//������� ���� ����(��ǹ�)
		jbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");					//Play()�޼ҵ� �̿��� ����� ���
				lb2.setText(lb2.getText() + "�� ");		//���� ��� �󺧿� '���� �ǹ� ��' �߰��� ���
			}
		});
		
		//�ι�° ��ǹ� ��ư(��)
		JButton jbtn2 = new JButton();
		jbtn2.setBackground(Color.white);
		jbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");
				lb2.setText(lb2.getText() + "�� ");				
			}
		});
		
		//����° ��ǹ� ��ư(��)
		JButton jbtn3 = new JButton();
		jbtn3.setBackground(Color.white);
		jbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");
				lb2.setText(lb2.getText() + "�� ");				
			}
		});
		
		//�׹�° ��ǹ� ��ư(��)
		JButton jbtn4 = new JButton();
		jbtn4.setBackground(Color.white);
		jbtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");
				lb2.setText(lb2.getText() + "�� ");				
			}
		});
		
		//�ټ���° ��ǹ� ��ư(��)
		JButton jbtn5 = new JButton();
		jbtn5.setBackground(Color.white);
		jbtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");
				lb2.setText(lb2.getText() + "�� ");				
			}
		});
		
		//������° ��ǹ� ��ư(��)
		JButton jbtn6 = new JButton();
		jbtn6.setBackground(Color.white);
		jbtn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");
				lb2.setText(lb2.getText() + "�� ");				
			}
		});
		
		//�ϰ���° ��ǹ� ��ư(��)
		JButton jbtn7 = new JButton();
		jbtn7.setBackground(Color.white);
		jbtn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��.wav");
				lb2.setText(lb2.getText() + "�� ");				
			}
		});
		
		
		JPanel piano_keys = new JPanel();			//�� �ǹ� 7���� �ѹ��� ���� JPanel 				
		piano_keys.setSize(700, 350);
		piano_keys.setLayout(new GridLayout(1, 7));	//grid �������� �ٲ� (�ǹ��� ũ�� �����ϰ� �ϱ� ����)
		
		piano_keys.add(jbtn1);		//add(�� �ǹ� 1~7)
		piano_keys.add(jbtn2);
		piano_keys.add(jbtn3);
		piano_keys.add(jbtn4);
		piano_keys.add(jbtn5);
		piano_keys.add(jbtn6);
		piano_keys.add(jbtn7);
		
		
		
		/* �ǾƳ� ���� �ǹ� Jbutton */
		//ù��° �����ǹ� ��ư(��#)
		JButton jb1 = new JButton();
		jb1.setBackground(Color.black);					//���������� ���� ����(���� �ǹ�)
		jb1.setBounds(70, 0, 60, 190);					//�������� ��ǥ�� ���� ��ġ ����
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��#.wav");					//Play()�޼ҵ� �̿��� ����� ���
				lb2.setText(lb2.getText() + "��# ");		//���� ��� �󺧿� '���� �ǹ� ��' �߰��� ���
			}
		});
		
		//�ι�° �����ǹ� ��ư(��#)
		JButton jb2 = new JButton();
		jb2.setBackground(Color.black);
		jb2.setBounds(170, 0, 60, 190);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��#.wav");
				lb2.setText(lb2.getText() + "��# ");				
			}
		});
		
		//����° �����ǹ� ��ư(��#)
		JButton jb3 = new JButton();						
		jb3.setBackground(Color.black);
		jb3.setBounds(370, 0, 60, 190);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��#.wav");
				lb2.setText(lb2.getText() + "��# ");	 	
			}
		});
		
		//�׹�° �����ǹ� ��ư(��#)
		JButton jb4 = new JButton();
		jb4.setBackground(Color.black);
		jb4.setBounds(470, 0, 60, 190);
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��#.wav");
				lb2.setText(lb2.getText() + "��# ");	 	
			}
		});
		
		//�ټ���° �����ǹ� ��ư(��#)
		JButton jb5 = new JButton();
		jb5.setBackground(Color.black);
		jb5.setBounds(570, 0, 60, 190);
		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/��#.wav");
				lb2.setText(lb2.getText() + "��# ");	 	
			}
		});
		
		
		
		/* �ǾƳ� �ǹ� ���� JLayeredPane */
		
		//�� �ǹ� ���� ���� �˹� ���� ���� ���� JLayeredPane ���
		JLayeredPane key_layered = new JLayeredPane();
		
		//�� �ǹ��� �� ���Ե� piano_keys JPanel add
		key_layered.add(piano_keys, new Integer(0));	//�� �ǹ��� ���̴� 0
		
		//������ ���� �ǹ� ��ư add
		key_layered.add(jb1, new Integer(10));			//���� �ǹ��� ���̴� 10
		key_layered.add(jb2, new Integer(10));
		key_layered.add(jb3, new Integer(10));
		key_layered.add(jb4, new Integer(10));
		key_layered.add(jb5, new Integer(10));
		
		
		
		/* ���� ��� ���, �߰� ���  */
		
		//�����ϱ�
		JButton save_btn = new JButton("�����ϱ�");
		save_btn.setFont(f);
		save_btn.setBackground(color);
		save_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){	
				String fcontent = lb2.getText();		//�ǹ��� ���� �Էµ� ��
				String fname = fileName.getText();		//���ϸ�
				
				if (fname.equals(".txt")) {
					//���ϸ��� �Է����� �ʾҴٸ� ���� �߻�
					JOptionPane.showMessageDialog(null, "������ ���ϸ��� �Է����ּ���", "���� �߻�", JOptionPane.ERROR_MESSAGE);
				}
				else if (fcontent.equals("")){
					//�ǹ��� ���� ������ �Է����� �ʾҴٸ� ���� �߻�
					JOptionPane.showMessageDialog(null, "������ ������ �Է����ּ���", "���� �߻�", JOptionPane.ERROR_MESSAGE);
				}				
				else {
					try {
						//���� ��� ��Ʈ�� ����(���� ����) - ���� ���� �Է�. false:�����
						FileWriter fw = new FileWriter(fname, false);
						fw.write(fcontent);		//fcontent�� ����� ���� ���Ͽ� ����
						fw.close();	
						
						lb2.setText("");
						fileName.setText(".txt");
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}				
			}
		});

		
		//�����ϱ�
		JButton load_btn = new JButton("�����ϱ�");
		load_btn.setFont(f);
		load_btn.setBackground(color);
		load_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fname = fileName_load.getText();			//�ҷ��� ���ϸ� �ޱ�
				if (fname.equals(".txt")) {
					//���ϸ��� �Է����� �ʾҴٸ� ���� �߻�
					JOptionPane.showMessageDialog(null, "�ҷ��� ���ϸ��� �Է����ּ���", "���� �߻�", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						//���� �Է� ��Ʈ�� ����
						FileReader fr = new FileReader(fname);
						int ch;
						while((ch=fr.read()) != -1) {				//���Ͽ��� ���� �ϳ��� �о� -1�� �ƴϸ�
							Play("sound/" + (char)ch +".wav");		//�ش� ���ڿ� ����Ǵ� ����� ���� ���
							lb2.setText(lb2.getText() + (char)ch);	//�ش� ���ڸ� lb2.�� �̾ ���
							Thread.sleep(200);						//����� ������ ���ÿ� ������� �ʵ��� �ð� ����
						}
						fr.close();			
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		
		
		//�����ϱ�
		JButton del_btn = new JButton("RESET");
		del_btn.setFont(f);
		del_btn.setBackground(color);
		del_btn.setPreferredSize(new Dimension(325, 50));	//��ư ũ�� ����	
		del_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lb2.setText("");				//��� ��� �ʱ�ȭ
				fileName.setText(".txt");		//�����ϱ� ���ϸ� reset
				fileName_load.setText(".txt");	//�ҷ����� ���ϸ� reset
			}
		});
		
		
		//��ٸ���
		JButton wait_btn = new JButton("��ǥ");
		wait_btn.setFont(f);
		wait_btn.setBackground(color);
		wait_btn.setPreferredSize(new Dimension(325, 50));	
		wait_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ư�� ������ ���鹮�� ���
				//����� ������ ����� ��, �߰��� �Ҹ��� �� ������ ������ �ֱ� ����
				lb2.setText(lb2.getText() + "   ");	
			}
		});
		
		
		
		/* ������Ʈ ��ġ */
		
		//'���� ��� ���, �߰� ���' ��� ���� ��ü JPanel 
		JPanel setting_jp = new JPanel();
		setting_jp.setLayout(new GridLayout(5, 1));		//grid �������� ��ġ
		
		lb1.setFont(f);
		lb2.setFont(f);
		fileName.setFont(f2);
		fileName_load.setFont(f2);
		
		//button, label, text field ���� ��ɿ� �°� ������ JPanel�� add 
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));	//�������� ����
		jp1.add(lb1);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.add(lb2);
		
		JPanel jp3 = new JPanel();
		jp3.add(save_btn);
		jp3.add(fileName);
		
		JPanel jp4 = new JPanel();
		jp4.add(load_btn);
		jp4.add(fileName_load);
		
		JPanel jp5 = new JPanel();
		jp5.add(wait_btn);
		jp5.add(del_btn);
		
		
		//button, label, text field�� ���Ե� JPanel�� setting JPanel�� add
		setting_jp.add(jp1);
		setting_jp.add(jp2);
		setting_jp.add(jp3);
		setting_jp.add(jp4);
		setting_jp.add(jp5);
		
		//�ǹ��� ����� key_layered JLayeredPane�� ����â�� ���Ե� setting_jp JPanel��
		//JFrame�� add 
		add(key_layered);
		add(setting_jp);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new PianoWithSound();
		}
}