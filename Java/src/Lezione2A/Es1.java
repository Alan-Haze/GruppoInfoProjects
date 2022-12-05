package Lezione2A;


public class Es1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Inverti(new int[]{1,2,3,4,5});dichiarazione e valorizzazione sono fatte simultaneamente all'interno della chiamata del metodo
		
		int[] inverti = {1,2,3,4,5}; 
		Inverti(inverti); 
	}

	private static void Inverti(int[]array) {
		// TODO Auto-generated method stub
		for(int i = array.length-1 ; i>=0;i--) {
			 System.err.println(array[i]);
			 
}
	}}
