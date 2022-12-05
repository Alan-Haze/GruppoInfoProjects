package Lezione2A;

public class Es2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lista= {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(PresenteAssente(lista,11));
		System.out.println(PresenteAssente(lista,2));
	}

	private static String PresenteAssente(int[] array, int i) {
		// TODO Auto-generated method stub
		for(int j=0;j<array.length;j++) {
			if (i==array[j]) return "Presente" ;
			 
		}
		return "Assente";
	}

}
