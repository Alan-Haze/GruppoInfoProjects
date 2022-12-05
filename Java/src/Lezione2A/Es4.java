package Lezione2A;

public class Es4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,4,5};
		Mono(array);
	}

	private static void Mono(int[] array) {
		// TODO Auto-generated method stub
		int [] newArr = new int[array.length];
		for(int i = 0;i<array.length;i++) {
			newArr[i] = array[i];
		}
	}

}
