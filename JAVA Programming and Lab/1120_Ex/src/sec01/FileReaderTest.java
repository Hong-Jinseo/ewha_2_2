package sec01;

//����� ��Ʈ�� ��Ű�� import
import java.io.*;

public class FileReaderTest {

	//����ó�� throws
	public static void main(String[] args) throws IOException {

		//���ϸ� ���ֱ�
		File f = new File("test.txt");
		FileReader in = new FileReader(f);
		int ch;
		
		while((ch=in.read()) != -1)		//-1: ������ ������ �� ��ȯ��
			System.out.print((char)ch);
		in.close();

	}

}
