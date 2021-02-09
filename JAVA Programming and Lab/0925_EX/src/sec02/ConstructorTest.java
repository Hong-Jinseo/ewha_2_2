package sec02;

class AA{
	AA(){
		System.out.println("持失切 AA");
	}
	AA(int x){
		System.out.println("持失切 AA "+x);
	}
}

class BB extends AA{
	BB(){
		//super(10);
		System.out.println("持失切 BB");
	}
	BB(int x){
		super(x);
		System.out.println("持失切 BB "+x);
	}
}

public class ConstructorTest {
	public static void main(String[] args) {
		BB b = new BB(26);
	}
}
