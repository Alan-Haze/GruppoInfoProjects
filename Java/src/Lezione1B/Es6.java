package Lezione1B;

public class Es6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Operations(1,2));
		System.out.println(Operations(2,2));
		System.out.println(Operations(1,1));
	}

	private static int Operations(int i, int j) {
		// TODO Auto-generated method stub
		if (i%2 == 0 || j%2== 0) return i+j;
		if (i%2 == 0 && j%2== 0) return i*j;
		if (i%2 != 0 && j%2!= 0) return i/j;
		return -1;
		
	}

}
