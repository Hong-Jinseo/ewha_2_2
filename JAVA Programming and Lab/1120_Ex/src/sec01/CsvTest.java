package sec01;
import java.io.*;
import java.util.*;

public class CsvTest {
	public static void main(String[] args) throws IOException{
		
		FileReader fr = new FileReader("sample.csv");
		String line = null;
		String cvsSplit = ",";
		BufferedReader br = new BufferedReader(fr);
		
		//readLine : 한 줄 라인의 데이터 읽어옴. BufferedReader class가 제공하는 메소드
		while((line=br.readLine()) != null) {
			String arr[] = line.split(cvsSplit); //바로 ", " 넣어도 됨
			//for(String s:arr) System.out.print(s+cvsSplit+" ");
			//System.out.println();	//줄바꿈
			
			//위 두줄 대신 아래 코드 사용 가능
			//리스트 자체 출력
			System.out.println(Arrays.asList(arr));
		}
		br.close();
	}
}
