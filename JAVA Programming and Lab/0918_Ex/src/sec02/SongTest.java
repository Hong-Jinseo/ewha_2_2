package sec02;
import java.util.*;

public class SongTest {
	public static void main(String[] args) {
		
		String singer, title;
		Scanner sc = new Scanner(System.in);
		
		Song[] list = new Song[3];
		
		for (int i=0; i<list.length; i++) {
			System.out.print("������ : ");
			singer = sc.nextLine();
			System.out.print("Ÿ��Ʋ�� : ");
			title = sc.nextLine();
			list[i] = new Song(singer, title);
		}
		
		//for (int i=0; i<list.length; i++)
		//	System.out.println("("+list[i].singer+","+list[i].title+")");
		
		//for each��!!!!!!!!!!
		for(Song ss:list)
			System.out.println("("+ss.singer+","+ss.title+")");
		
		sc.close();
	}
}
