package vetores;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*int[] notas = new int[20];
		
		notas[0] = 5;
		notas[1] = 7;
		notas[2] = 3;
		
		System.out.println(notas[0]);
		System.out.println(notas[1]);
		System.out.println(notas[2]);
		
		String[] nomes = {"Fulano", "Beltrano"};
		
		System.out.println(nomes[0] + " " + nomes[1]);*/
		
		float[] notas = new float[5];
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i <= 4; i++) {
			System.out.println("Informe a nota : ");
			notas[i] = input.nextFloat();
		}
		
		for(int i = 0; i <= 4; i++) {
			System.out.println("Nota " + (i+1) + " : " + notas[i]);
		}

	}

}
