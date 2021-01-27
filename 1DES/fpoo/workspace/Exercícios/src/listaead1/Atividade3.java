package listaead1;

/* Desenvolva um programa que leia o nome de 5 times de futebol, o número de vitórias e o
número de empates de cada time. O programa deverá calcular e apresentar na tela, o nome dos
times e o total de pontos de cada um em ordem de classificação decrescente. Lembrando que a
vitória vale 3 pontos e o empate vale um ponto.
Cutintia 3 2
Palmeiras 4 1
Santos 2 3
Flamengo 5 0
Gremio 1 4
 */

import java.util.Scanner;

public class Atividade3 {

	public static final int TOTAL = 5;
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nome = new String[TOTAL];
		int[] pontos = new int[TOTAL];
		int vitoria;

		// Entrada
		System.out.println("Digite o nome e o salário de 5 pessoas");
		for (int i = 0; i < TOTAL; i++) {
			nome[i] = leia.next();
			vitoria = leia.nextInt() * 3;
			pontos[i] = vitoria + leia.nextInt(); 
		}

		//Processamento - Algoritmo de ordenação decrescente
		for(int i = 0; i < TOTAL - 1; i++) {
			for(int j = i + 1; j < TOTAL; j++) {
				if(pontos[i] < pontos[j]) {
					int auxPontos = pontos[i];
					pontos[i] = pontos[j];
					pontos[j] =  auxPontos;
					
					String auxNome = nome[i];
					nome[i] = nome[j];
					nome[j] = auxNome;
				}
			}
		}
		
		// Saída
		System.out.println("Time, pontos:");
		for (int i = 0; i < TOTAL; i++) {
			System.out.print(nome[i]+", ");
			System.out.println(pontos[i]);
		}
	}
}
