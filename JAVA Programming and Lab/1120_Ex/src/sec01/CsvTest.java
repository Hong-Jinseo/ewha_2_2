package sec01;
import java.io.*;
import java.util.*;

public class CsvTest {
	public static void main(String[] args) throws IOException{
		
		FileReader fr = new FileReader("sample.csv");
		String line = null;
		String cvsSplit = ",";
		BufferedReader br = new BufferedReader(fr);
		
		//readLine : �� �� ������ ������ �о��. BufferedReader class�� �����ϴ� �޼ҵ�
		while((line=br.readLine()) != null) {
			String arr[] = line.split(cvsSplit); //�ٷ� ", " �־ ��
			//for(String s:arr) System.out.print(s+cvsSplit+" ");
			//System.out.println();	//�ٹٲ�
			
			//�� ���� ��� �Ʒ� �ڵ� ��� ����
			//����Ʈ ��ü ���
			System.out.println(Arrays.asList(arr));
		}
		br.close();
	}
}
