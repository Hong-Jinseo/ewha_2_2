package sec01;

import java.util.ArrayList;

public class RealTest {

	public static void main(String[] args) {
		ArrayList<testing> list = new ArrayList<testing>();
		list.add(new testing("æ»≥Á", "goodbye"));
		list.add(new testing("¿ﬂ∞°", "hello"));
		list.add(new testing("≥ª¿œ∫¡", "CU"));
		
		for (testing t:list)
			System.out.println(t.singer + " " + t.song);
	}
}

