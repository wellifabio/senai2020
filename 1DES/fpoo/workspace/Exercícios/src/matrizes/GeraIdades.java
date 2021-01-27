package matrizes;

import java.util.Random;

public class GeraIdades {

	public static Random gerador = new Random();
	
	public static void main(String[] args) {
	
		int[] idades = new int[10];
		for(int i = 0; i < 10; i++){
			idades[i] = gerador.nextInt(100);
		}

		for(int i = 0; i < 10; i++){
			System.out.println(idades[i]);
		}
	}

}
