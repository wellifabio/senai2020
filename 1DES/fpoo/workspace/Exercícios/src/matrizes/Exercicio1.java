/*Crie um programa que crie uma matriz de quadrada
 * de 5 posições, preencha esta matriz com valores
 * aleatórios de 0 a 100 e exiba-a no console.
 * */
package matrizes;

import java.util.Random;

public class Exercicio1 {

	public static Random rand = new Random();

	public static void main(String[] args) {
		// Declara a matriz
		int[][] matriz = new int[5][5];

		// Preencher com números randomicos
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = rand.nextInt(100);
			}
		}
		// Mostrar a matriz
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("[" + matriz[i][j] + "]");
			}
			System.out.println();
		}
	}
}
