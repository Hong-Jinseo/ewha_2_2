package sec01;

public class MyRunnable implements Runnable{

	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.print(i);
			try {
				//static �޼ҵ�� ��ü ���� ���� Ŭ���� �̸������� ���� ����
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
