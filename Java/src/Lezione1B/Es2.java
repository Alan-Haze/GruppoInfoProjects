package Lezione1B;

public class Es2 {

	
	public static void main(String[] args) {
		
		HighestNumber(1,2,1);
		HighestNumber(1,2,5);

	}

	private static void HighestNumber(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(i>j & j>k) System.out.println(i);
		if(i>k & k>j) System.out.println(i);
		if(k>j& j > i)System.out.println(k) ;
		if(j>i & i >k)System.out.println(j) ;
		if(j>k & k>i)System.out.println(j);
		if(k>i & i > j)System.out.println(k) ;
		if(k==i || i== j) System.out.println(i+j+k) ;
	}

}
