package sec02;
import java.util.ArrayList;

public class SongTest2 {

	public static void main(String[] args) {
		
		ArrayList<Song> list = new ArrayList<Song>();
		
		list.add(new Song("ȫ����", "�������"));
		list.add(new Song("�����ƺ�", "���� ��ž�Ϸ�"));
		list.add(new Song("������", "�����л� ����ؿ�"));
		
		for(Song ss:list)
			System.out.println("("+ss.singer+","+ss.title+")");
	}
}
