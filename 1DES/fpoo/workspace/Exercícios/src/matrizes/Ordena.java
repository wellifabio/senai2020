package matrizes;

import java.util.Scanner;

public class Ordena {
	public static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {
		int[] vetor = new int[6];
		//Entrada
		System.out.println("Digite seis números inteiros desordenados:");
		for(int i = 0; i < 6; i++){
			vetor[i] = read.nextInt();
		}
		for(int i = 0; i < vetor.length - 1; i++){
			for(int j = i + 1; j < vetor.length; j++){
				if(vetor[i] > vetor[j]){
					int aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		//Saída
		for(int i = 0; i < 6; i++){
			System.out.println(vetor[i]);
		}
	}

}
