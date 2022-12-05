package Lezione2B;

import java.util.Arrays;

public class Es2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1,2,3};
		int[] array2 = {4,5,6};
		System.out.println(Arrays.toString(Concatena(array1,array2)));
	
	}

	private static int[] Concatena(int[] array1, int[] array2) {
		// TODO Auto-generated method stub
		int[] arrayTot = new int[array1.length + array2.length];
		int pos = 0;
		for (int element : array1) {
            arrayTot[pos] = element;
            pos++;
        }

        for (int element : array2) {
            arrayTot[pos] = element;
            pos++;
        }return arrayTot;
	}

}
