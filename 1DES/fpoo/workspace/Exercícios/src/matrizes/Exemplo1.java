package matrizes;

import java.util.Random;

public class Exemplo1 {
	public static void main(String[] args){
		Random rand = new Random();
		int[] vetor = new int[9];
		int[][] matriz = new int[3][3];
		int[] vetorPreenchido = {25,34,28,20,45,20,19,18,48};
		int[][] matrizPreenchida = {{10,10,10},{15,12,18},{45,48,23}};
		
		for(int i = 0; i < 9; i++){
			System.out.println(vetorPreenchido[i]);
		}
		System.out.println();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(matrizPreenchida[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		//Valores Aleatórios
		for(int i = 0; i < 9; i++){
			vetor[i] = rand.nextInt(100);
			System.out.println(vetor[i]);
		}
		System.out.println();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				matriz[i][j] = rand.nextInt(100);
				System.out.print("["+matriz[i][j]+"]");
			}
			System.out.println();
		}
	}
}
