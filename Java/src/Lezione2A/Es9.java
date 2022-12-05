package Lezione2A;

public class Es9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,3,4,5};
		SumEvenIndex(array);
	}

	private static void SumEvenIndex(int[] array) {
		// TODO Auto-generated method stub
		int somma = 0;
		for(int i=0;i<array.length;i++) {
			
			if(i%2==0) {somma = somma + array[i];}
			
			
		}System.out.println(somma);
	}

}
