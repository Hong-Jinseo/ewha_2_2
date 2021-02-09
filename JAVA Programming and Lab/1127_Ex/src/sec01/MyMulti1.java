package sec01;

public class MyMulti1 implements Runnable{
	
	public void run() {
		String tname = Thread.currentThread().getName();
		System.out.println(tname+" 시작");
		for(int i=1; i<=5; i++) 
			System.out.println(tname+"-"+i);
			try {
				//static 메소드라 객체 생성 없이 클래스 이름만으로 접근 가능
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(tname+"종료");
	}

	public static void main(String[] args) {
		MyMulti1 app = new MyMulti1();
		for(int i=1; i<=3; i++) {
			Thread t = new Thread(app);
			t.start();
		}
		System.out.println("main 종료");
	}
}
