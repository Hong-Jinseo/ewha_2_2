package sec02;
import java.io.*;
import java.util.*;

public class WordSearch {
	public static void main(String[] args) throws IOException {
		Vector<String> v = new Vector<String>();
		FileReader f = new FileReader("word.txt");
		Scanner fs = new Scanner(f);
		while(fs.hasNext())
			v.add(fs.next());
		fs.close();
		
		Scanner s = new Scanner(System.in);
		while(true) {
			boolean found = false;
			System.out.print("�ܾ�>>");
			String search = s.next();
			if(search.equals("q")) {
				System.out.println("�����մϴ�..");
				break;
			}
			
			for(int i=0; i<v.size(); i++) {
				String vs = v.get(i);
				if(vs.length() < search.length())
					continue;
				String a = vs.substring(0, search.length());
				if(search.equals(a)) {
					System.out.println(vs);
					found = true;
				}
			}
			if(!found)
				System.out.println("Ž�� ����");
		}
		s.close();
	}
}
