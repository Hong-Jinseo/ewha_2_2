package sec02;

class SharedPrinter{
	synchronized void print(String text) {
        for(int i=0; i<text.length(); i++)
        	System.out.print(text.charAt(i));
        System.out.println();
	} 
}

public class WorkerThread extends Thread{

	SharedPrinter p;
	String[] text;
	
	WorkerThread(SharedPrinter p, String[] text){
		this.p = p;
		this.text = text;
	}
	
	public void run() {
		for(int i=0; i<text.length; i++)
			p.print(text[i]);
	}	
	
	public static void main(String[] args) {
		//���� ������ ����
		SharedPrinter p = new SharedPrinter();
		
		String[] engText = {
				"God helps those who help themselves.",
				"He who hesitate is lost.",
				"Knowledge is power.",
				"Small drops make a shower",
				};
		
		String[] korText = {
				"(�ϴ��� ������ ���� �ڸ� ���´�.)",
				"(�����̴� �ڴ� ��� ���� �Ҵ´�.)",
				"(�ƴ� ���� ���̴�.)",
				"(���� ������� �ҳ��� �̷��.)",
				};
		
		WorkerThread t1 = new WorkerThread(p, engText);
		WorkerThread t2 = new WorkerThread(p, korText);
		
		t1.start();
		t2.start();
	}

}
