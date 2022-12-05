package Lezione6;

import java.util.ArrayList;

public class Banca {
	static ArrayList<BancaAccount> utente;
	static BancaAccount account;
	private static double saldo;

	public Banca() {
		utente = new ArrayList<BancaAccount>();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BancaAccount> str = new ArrayList<BancaAccount>();
		addAccount(110.0,"Alan"); 
//		deposita(0001,110.0);
//		preleva(0001,110.0);
//		getSaldo(0001);
//		trasferisci(0001,0002,110.0);
		
	}

	private static void trasferisci(int i, int j, double d) {
		// TODO Auto-generated method stub
		
	}


	private static double getSaldo(int i) {
		// TODO Auto-generated method stub
		return saldo;
	}


	public static void addAccount(double importo, String nome) {
		int numcc = (int)(Math.random() * 100);
		utente.add(new BancaAccount(importo, nome, numcc));
	}
	
	public static void deposita(int numcc, double sommadep) {
		saldo = account.getSaldo();
		saldo += sommadep;
	}
	
	public static void preleva(int numcc, double sommapr) {
		saldo = account.getSaldo();
		saldo -= sommapr;
	}

}
