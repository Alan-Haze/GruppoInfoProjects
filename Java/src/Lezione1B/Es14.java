package Lezione1B;

import java.io.EOFException;

public class Es14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InteroN(31);
		
	}

	private static void InteroN(int i) {
		// TODO Auto-generated method stub
	
			int res = 0;
			for(int j=0;j<i;i++) res += j; 
			if(i>1 && i<10) {System.out.println("NxN");}
			if(i>=11 && i<=20) {System.out.println(res);}
			else System.out.println("erroe");
		
		
		

}}
