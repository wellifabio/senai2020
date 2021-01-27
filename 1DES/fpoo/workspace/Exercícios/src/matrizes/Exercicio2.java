/*Crie um programa que crie uma matriz de quadrada
 * de 5 posições, preencha esta matriz com valores
 * aleatórios de 0 a 100 e exiba-a no console.
 * */
package matrizes;

import java.util.Random;

public class Exercicio2 {

	public static Random rand = new Random();

	public static void main(String[] args) {
		// Declara a matriz
		int[][] matriz = new int[5][5];

		// Preencher com números randomicos
		int i = 0;
		int j = 0;
		for (int x = 0; x < 25; x++) {
			matriz[i][j] = rand.nextInt(100);
			if (j < 4) {
				j++;
			} else {
				j = 0;
				i++;
			}
		}
		// Mostrar a matriz
		i = 0;
		j = 0;
		for (int x = 0; x < 25; x++) {
			System.out.print("[" + matriz[i][j] + "]");
			if (j < 4) {
				j++;
			} else {
				j = 0;
				i++;
				System.out.println();
			}
		}
	}
}
