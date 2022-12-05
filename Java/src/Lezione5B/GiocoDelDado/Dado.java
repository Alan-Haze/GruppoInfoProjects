package Lezione5B.GiocoDelDado;

public class Dado {
	public void TiraDado() {
		int max = 6;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        
        System.out.println(rand);
	}
}
