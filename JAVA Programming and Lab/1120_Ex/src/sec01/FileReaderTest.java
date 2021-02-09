package sec01;

//입출력 스트림 패키지 import
import java.io.*;

public class FileReaderTest {

	//예외처리 throws
	public static void main(String[] args) throws IOException {

		//파일명 써주기
		File f = new File("test.txt");
		FileReader in = new FileReader(f);
		int ch;
		
		while((ch=in.read()) != -1)		//-1: 파일이 끝났을 때 반환값
			System.out.print((char)ch);
		in.close();

	}

}
