package sec01;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.sound.sampled.*;

public class PianoWithSound extends JFrame {
	
	Font f = new Font("맑은 고딕", Font.BOLD, 30);
	Font f2 = new Font("맑은 고딕", Font.PLAIN, 30);
	Color color = new Color(255, 252, 186);
	
	JLabel lb1 = new JLabel("MUSIC : ");
	JLabel lb2 = new JLabel();
	JTextField fileName = new JTextField(".txt", 19);
	JTextField fileName_load = new JTextField(".txt", 19);
	
	
	//오디오 파일 재생 함수
	public void Play(String fileName){
        try{
        	//오디오 입력 스트림 : 입력 장치로부터 자바 프로그램으로 오디오 데이터 전달
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }catch (Exception ex) {}
    }
	
   	
	PianoWithSound() {
		setTitle("My Piano with sound");
		setSize(700, 700);
		//창 전체를 위(건반)/아래(실행 결과) 두 개로 구분하도록 한 grid layout
		setLayout(new GridLayout(2, 1));
				
		
		/* 피아노 흰 건반 JButton*/
		//첫번째 흰건반 버튼(도)
		JButton jbtn1 = new JButton();
		jbtn1.setBackground(Color.white);				//흰색으로 배경색 변경(흰건반)
		jbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/도.wav");					//Play()메소드 이용해 오디오 재생
				lb2.setText(lb2.getText() + "도 ");		//실행 결과 라벨에 '누른 건반 명' 추가로 출력
			}
		});
		
		//두번째 흰건반 버튼(레)
		JButton jbtn2 = new JButton();
		jbtn2.setBackground(Color.white);
		jbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/레.wav");
				lb2.setText(lb2.getText() + "레 ");				
			}
		});
		
		//세번째 흰건반 버튼(미)
		JButton jbtn3 = new JButton();
		jbtn3.setBackground(Color.white);
		jbtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/미.wav");
				lb2.setText(lb2.getText() + "미 ");				
			}
		});
		
		//네번째 흰건반 버튼(파)
		JButton jbtn4 = new JButton();
		jbtn4.setBackground(Color.white);
		jbtn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/파.wav");
				lb2.setText(lb2.getText() + "파 ");				
			}
		});
		
		//다섯번째 흰건반 버튼(솔)
		JButton jbtn5 = new JButton();
		jbtn5.setBackground(Color.white);
		jbtn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/솔.wav");
				lb2.setText(lb2.getText() + "솔 ");				
			}
		});
		
		//여섯번째 흰건반 버튼(라)
		JButton jbtn6 = new JButton();
		jbtn6.setBackground(Color.white);
		jbtn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/라.wav");
				lb2.setText(lb2.getText() + "라 ");				
			}
		});
		
		//일곱번째 흰건반 버튼(시)
		JButton jbtn7 = new JButton();
		jbtn7.setBackground(Color.white);
		jbtn7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/시.wav");
				lb2.setText(lb2.getText() + "시 ");				
			}
		});
		
		
		JPanel piano_keys = new JPanel();			//흰 건반 7개를 한번에 놓을 JPanel 				
		piano_keys.setSize(700, 350);
		piano_keys.setLayout(new GridLayout(1, 7));	//grid 형식으로 바꿈 (건반의 크기 동일하게 하기 위함)
		
		piano_keys.add(jbtn1);		//add(흰 건반 1~7)
		piano_keys.add(jbtn2);
		piano_keys.add(jbtn3);
		piano_keys.add(jbtn4);
		piano_keys.add(jbtn5);
		piano_keys.add(jbtn6);
		piano_keys.add(jbtn7);
		
		
		
		/* 피아노 검은 건반 Jbutton */
		//첫번째 검은건반 버튼(도#)
		JButton jb1 = new JButton();
		jb1.setBackground(Color.black);					//검은색으로 배경색 변경(검은 건반)
		jb1.setBounds(70, 0, 60, 190);					//절대적인 좌표를 통해 위치 지정
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/도#.wav");					//Play()메소드 이용해 오디오 재생
				lb2.setText(lb2.getText() + "도# ");		//실행 결과 라벨에 '누른 건반 명' 추가로 출력
			}
		});
		
		//두번째 검은건반 버튼(레#)
		JButton jb2 = new JButton();
		jb2.setBackground(Color.black);
		jb2.setBounds(170, 0, 60, 190);
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/레#.wav");
				lb2.setText(lb2.getText() + "레# ");				
			}
		});
		
		//세번째 검은건반 버튼(파#)
		JButton jb3 = new JButton();						
		jb3.setBackground(Color.black);
		jb3.setBounds(370, 0, 60, 190);
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/파#.wav");
				lb2.setText(lb2.getText() + "파# ");	 	
			}
		});
		
		//네번째 검은건반 버튼(솔#)
		JButton jb4 = new JButton();
		jb4.setBackground(Color.black);
		jb4.setBounds(470, 0, 60, 190);
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/솔#.wav");
				lb2.setText(lb2.getText() + "솔# ");	 	
			}
		});
		
		//다섯번째 검은건반 버튼(라#)
		JButton jb5 = new JButton();
		jb5.setBackground(Color.black);
		jb5.setBounds(570, 0, 60, 190);
		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("sound/라#.wav");
				lb2.setText(lb2.getText() + "라# ");	 	
			}
		});
		
		
		
		/* 피아노 건반 놓을 JLayeredPane */
		
		//흰 건반 위에 검은 검반 겹쳐 놓기 위해 JLayeredPane 사용
		JLayeredPane key_layered = new JLayeredPane();
		
		//흰 건반이 다 포함된 piano_keys JPanel add
		key_layered.add(piano_keys, new Integer(0));	//흰 건반의 높이는 0
		
		//각각의 검은 건반 버튼 add
		key_layered.add(jb1, new Integer(10));			//검은 건반의 높이는 10
		key_layered.add(jb2, new Integer(10));
		key_layered.add(jb3, new Integer(10));
		key_layered.add(jb4, new Integer(10));
		key_layered.add(jb5, new Integer(10));
		
		
		
		/* 실행 결과 출력, 추가 기능  */
		
		//저장하기
		JButton save_btn = new JButton("저장하기");
		save_btn.setFont(f);
		save_btn.setBackground(color);
		save_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){	
				String fcontent = lb2.getText();		//건반을 눌러 입력된 음
				String fname = fileName.getText();		//파일명
				
				if (fname.equals(".txt")) {
					//파일명을 입력하지 않았다면 오류 발생
					JOptionPane.showMessageDialog(null, "저장할 파일명을 입력해주세요", "오류 발생", JOptionPane.ERROR_MESSAGE);
				}
				else if (fcontent.equals("")){
					//건반을 눌러 음악을 입력하지 않았다면 오류 발생
					JOptionPane.showMessageDialog(null, "저장할 음악을 입력해주세요", "오류 발생", JOptionPane.ERROR_MESSAGE);
				}				
				else {
					try {
						//파일 출력 스트림 생성(파일 열기) - 파일 제목 입력. false:덮어쓰기
						FileWriter fw = new FileWriter(fname, false);
						fw.write(fcontent);		//fcontent에 저장된 내용 파일에 저장
						fw.close();	
						
						lb2.setText("");
						fileName.setText(".txt");
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}				
			}
		});

		
		//연주하기
		JButton load_btn = new JButton("연주하기");
		load_btn.setFont(f);
		load_btn.setBackground(color);
		load_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fname = fileName_load.getText();			//불러올 파일명 받기
				if (fname.equals(".txt")) {
					//파일명을 입력하지 않았다면 오류 발생
					JOptionPane.showMessageDialog(null, "불러올 파일명을 입력해주세요", "오류 발생", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						//파일 입력 스트림 생성
						FileReader fr = new FileReader(fname);
						int ch;
						while((ch=fr.read()) != -1) {				//파일에서 문자 하나를 읽어 -1이 아니면
							Play("sound/" + (char)ch +".wav");		//해당 문자와 연결되는 오디오 파일 재생
							lb2.setText(lb2.getText() + (char)ch);	//해당 문자를 lb2.에 이어서 출력
							Thread.sleep(200);						//오디오 파일이 동시에 재생되지 않도록 시간 지연
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
		
		
		//삭제하기
		JButton del_btn = new JButton("RESET");
		del_btn.setFont(f);
		del_btn.setBackground(color);
		del_btn.setPreferredSize(new Dimension(325, 50));	//버튼 크기 조절	
		del_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lb2.setText("");				//출력 결과 초기화
				fileName.setText(".txt");		//저장하기 파일명 reset
				fileName_load.setText(".txt");	//불러오기 파일명 reset
			}
		});
		
		
		//기다리기
		JButton wait_btn = new JButton("쉼표");
		wait_btn.setFont(f);
		wait_btn.setBackground(color);
		wait_btn.setPreferredSize(new Dimension(325, 50));	
		wait_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//버튼이 눌리면 공백문자 출력
				//오디오 파일이 재생될 때, 중간에 소리가 안 나오는 구간을 넣기 위함
				lb2.setText(lb2.getText() + "   ");	
			}
		});
		
		
		
		/* 컴포넌트 배치 */
		
		//'실행 결과 출력, 추가 기능' 담기 위한 전체 JPanel 
		JPanel setting_jp = new JPanel();
		setting_jp.setLayout(new GridLayout(5, 1));		//grid 형식으로 배치
		
		lb1.setFont(f);
		lb2.setFont(f);
		fileName.setFont(f2);
		fileName_load.setFont(f2);
		
		//button, label, text field 등을 기능에 맞게 별개의 JPanel에 add 
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));	//왼쪽으로 정렬
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
		
		
		//button, label, text field가 포함된 JPanel을 setting JPanel에 add
		setting_jp.add(jp1);
		setting_jp.add(jp2);
		setting_jp.add(jp3);
		setting_jp.add(jp4);
		setting_jp.add(jp5);
		
		//건반이 저장된 key_layered JLayeredPane과 설정창이 포함된 setting_jp JPanel을
		//JFrame에 add 
		add(key_layered);
		add(setting_jp);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new PianoWithSound();
		}
}