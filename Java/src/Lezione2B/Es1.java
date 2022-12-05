package Lezione2B;

import java.util.Arrays;

public class Es1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numeri = {10,4,8,9,2,1};
		
		System.out.println(Arrays.toString(ordCre(numeri)));
		System.out.println(Arrays.toString(ordDec(numeri)));
		somma(numeri);
		media(numeri);
		valMax(numeri);
		valMin(numeri);
		stampa(numeri);
	}

	private static void stampa(int[] numeri) {
		// TODO Auto-generated method stub
		for(int i=0;i<numeri.length;i++) {
			System.out.println("stampa: "+numeri[i]);
		}
	}

	private static void valMin(int[] numeri) {
		// TODO Auto-generated method stub
		int min = numeri[0];
		for(int i=0;i<numeri.length;i++) {
			if(numeri[i]<min)min = numeri[i];
		}System.out.println("valMin: "+min);
	}

	private static void valMax(int[] numeri) {
		// TODO Auto-generated method stub
		int max = numeri[0];
		for(int i=0;i<numeri.length;i++) {
			if(numeri[i]>max)max = numeri[i];
		}System.out.println("valMax: "+max);
	}

	private static void somma(int[] numeri) {
		// TODO Auto-generated method stub
		int somma = 0;
		for(int i=0;i<numeri.length;i++) {
			somma = somma + numeri[i];
			somma += numeri[i];
		}System.out.println("somma: "+somma);
	} 
	
	private static void media(int[] numeri) {
		// TODO Auto-generated method stub
		int somma = 0;
		int media = 0 ;
		for(int i=0;i<numeri.length;i++) {
			somma = somma + numeri.length;
			media=somma/numeri.length;
		}System.out.println("media: "+media);
	}

	private static int[] ordDec(int[] array) {
		// TODO Auto-generated method stub
		int[] inOrder = new int[array.length];
		int temp;
		// TODO Auto-generated method stub
		for (int j = 0; j < array.length - 1; j++) {
	        for (int i = 0; i < array.length - 1; i++) {
	            if (array[i] < array[i + 1]) {
	                temp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = temp;
	                inOrder = array;
	            }
	        }}
		return inOrder;
	}

	private static int[] ordCre(int[] array) {
		// TODO Auto-generated method stub
		int[] inOrder = new int[array.length];
		int temp;
		// TODO Auto-generated method stub
		for (int j = 0; j < array.length - 1; j++) {
	        for (int i = 0; i < array.length - 1; i++) {
	            if (array[i] > array[i + 1]) {
	                temp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = temp;
	                inOrder = array;
	            }
	        }}
		return inOrder;
	}

	

}
