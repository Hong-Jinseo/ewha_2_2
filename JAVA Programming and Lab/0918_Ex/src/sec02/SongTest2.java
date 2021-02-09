package sec02;
import java.util.ArrayList;

public class SongTest2 {

	public static void main(String[] args) {
		
		ArrayList<Song> list = new ArrayList<Song>();
		
		list.add(new Song("홍진서", "성적대박"));
		list.add(new Song("엄마아빠", "진서 과탑하렴"));
		list.add(new Song("교수님", "진서학생 대단해요"));
		
		for(Song ss:list)
			System.out.println("("+ss.singer+","+ss.title+")");
	}
}
