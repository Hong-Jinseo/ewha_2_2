package sec01;
import java.io.*;
import java.util.*;

public class FileWriterTest {

	public static void main(String[] args) throws IOException{
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("# ������ ���ϸ� : ");
		String filename = s.next();
		System.out.println("# ������ ������ ���ο� q�� �Է� : ");
		FileWriter out = new FileWriter(filename);
		String str;
		
		//�� �� ������ �����͸� �о�� str ������ ����
		while(!(str=s.nextLine()).equals("q"))
			out.write(str+"\r\n");
		out.close();
		
		System.out.println(filename+" ����Ǿ����ϴ�.");
	} 
}
