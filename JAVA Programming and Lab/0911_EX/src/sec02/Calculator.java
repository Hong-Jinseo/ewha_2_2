package sec02;

public class Calculator {
	//�޼ҵ� ����
	int add(int n1, int n2){
		return n1+n2;
	}
	
	int sub(int n1, int n2) {
		return n1-n2;
	}
	
	int mul(int n1, int n2) {
		return n1*n2;
	}
	
	float div(int n1, int n2) {
		return (float)n1/n2;
	}
	
	void show(int n1, int n2) {
		System.out.println(n1+" + "+n2+" = "+add(n1,n2));
		System.out.println(n1+" - "+n2+" = "+sub(n1,n2));
		System.out.println(n1+" x "+n2+" = "+mul(n1,n2));
		if (n2==0)
			System.out.println("0���δ� ���� �� �����ϴ�.");
		else
			System.out.println(n1+" / "+n2+" = "+div(n1,n2));
	}

}
