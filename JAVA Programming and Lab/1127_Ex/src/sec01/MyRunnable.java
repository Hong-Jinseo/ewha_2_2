package sec01;

public class MyRunnable implements Runnable{

	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.print(i);
			try {
				//static 메소드라 객체 생성 없이 클래스 이름만으로 접근 가능
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
	}
}
