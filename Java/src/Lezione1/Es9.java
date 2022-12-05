package Lezione1;

public class Es9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 9;
		int b = 4;
		int quoziente = a / b;
		double quoziente2= a % b;
		double resto =  quoziente - quoziente2;
		if(b == 0) {quoziente = 1;}
		System.out.println(quoziente);
		System.out.println(resto);
	}

}
