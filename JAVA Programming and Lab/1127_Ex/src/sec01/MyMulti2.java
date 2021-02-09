package sec01;

class UpperThread extends Thread{
	public void run() {
		for(char i='A'; i<='Z'; i++) { 
			System.out.println(i);
			
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

class LowerThread extends Thread{
	public void run() {
		for(char i='a'; i<='z'; i++) { 
			System.out.println(i);
			
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}

public class MyMulti2{
	
	public static void main(String[] args) {
		
		UpperThread ut = new UpperThread();
		LowerThread lt = new LowerThread();
		
		ut.start();
		lt.start();
	}
}
