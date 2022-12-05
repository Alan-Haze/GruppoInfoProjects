package Lezione5B.GiocoDelDado;

public class Giocatore {
	String nome;
	int denaro;
   public Giocatore(String nome,int denaro) {
	  this.nome = nome;
	  this.denaro = denaro;
  }
   public int GiveMoneyBack() {
	   return denaro;
   }
   public void Won() {
	   denaro++;
   }
   public void Lost() {
	   denaro--;
   }

}
