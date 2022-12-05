package Lezione5B;

import java.util.Scanner;

public class Calcolatrice {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Somma();
		
		//Sottrazione();
		//Moltiplicazione();
		//Divisione (); 
		
		
	}

	private static void Divisione() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a,b,somma =0;
		a = scanner.nextInt();
		b = scanner.nextInt();
		somma=a/b;
		System.out.println("somma " + somma);
		scanner.close();
	}

	private static void Moltiplicazione() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a,b,somma =0;
		a = scanner.nextInt();
		b = scanner.nextInt();
		somma=a*b;
		System.out.println("somma " + somma);
		scanner.close();
	}

	private static void Sottrazione() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a,b,somma =0;
		a = scanner.nextInt();
		b = scanner.nextInt();
		somma=a-b;
		System.out.println("somma " + somma);
		scanner.close();
	}

	private static void Somma() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a,b,somma =0;
		a = scanner.nextInt();
		b = scanner.nextInt();
		somma=a+b;
		System.out.println("somma " + somma);
		scanner.close();
	}

}
