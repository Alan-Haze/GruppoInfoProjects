package Lezione5B.GiocoDelDado;

import java.util.Scanner;

public class GiocoDelDado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int denaro =0;
		String nome = "";
		System.out.println("inserire un numero");
		denaro = scanner.nextInt();
		System.out.println("inserire un nome");
		nome = scanner.next();
		System.out.println("Giocherai con " + denaro);
		System.out.println("Il tuo nome è " + nome);
		scanner.close();
		
		
		Giocatore giocatore = new Giocatore(nome,denaro);
		Dado dado = new Dado();
		System.out.println("Scrivi Invia per tirare dado ");
		nome = scanner.next();
		dado.TiraDado();
	}

}
