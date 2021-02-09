package sec01;

public class Mythread1 extends Thread{

	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.print(i);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Mythread1 t = new Mythread1();
		t.start();
	}
}
