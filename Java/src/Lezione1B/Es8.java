package Lezione1B;

public class Es8 {

	public static void main(String[] args) {
		DoWhile(5,3);

	}

	private static void DoWhile(int i, int j) {
		int contenitore = 0;
		do {
			 contenitore = contenitore + i;
			System.out.println(contenitore);
			j--;
			
		}while(j>0);
		
	}

}
