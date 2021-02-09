package sec01;
import java.io.*;
import java.util.*;

public class FileWriterTest {

	public static void main(String[] args) throws IOException{
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("# 저장할 파일명 : ");
		String filename = s.next();
		System.out.println("# 저장은 마지막 라인에 q를 입력 : ");
		FileWriter out = new FileWriter(filename);
		String str;
		
		//한 줄 단위의 데이터를 읽어와 str 변수에 저장
		while(!(str=s.nextLine()).equals("q"))
			out.write(str+"\r\n");
		out.close();
		
		System.out.println(filename+" 저장되었습니다.");
	} 
}
