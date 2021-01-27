package vetores;

/*Programa que lê o nome e a idade de 15 pessoas e
 * informa a média, o nome do indivíduo com maior idade
 * e o nome do indivíduo com menor idade*/
import java.util.Scanner;

public class Exemplo4 {

	public static final int TAMANHO = 15;
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nome = new String[TAMANHO];
		int[] idade = new int[TAMANHO];
		System.out.println("Digite o nome e a idade de " + TAMANHO + " pessoas:");
		for (int i = 0; i < TAMANHO; i++) {
			nome[i] = input.next();
			idade[i] = input.nextInt();
		}
		for (int i = 0; i < TAMANHO; i++) {
			System.out.println(nome[i] + ", " + idade[i]);
		}
		// Técnica de acumulação para calcular a média
		float media = 0;
		for (int i = 0; i < TAMANHO; i++) {
			media += idade[i];
		}
		media /= TAMANHO;
		System.out.printf("A média de idade desta população é %.1f\n", media);
		// Técnica de comparação
		int maior = 0;
		int indiceMaior = 0;
		for (int i = 0; i < TAMANHO; i++) {
			if (idade[i] > maior) {
				maior = idade[i];
				indiceMaior = i;
			}
		}
		System.out.println("O nome do mais velho é "+nome[indiceMaior]+", sua idade é "+maior);
		// Técnica de comparação
		int menor = 200;
		int indiceMenor = 0;
		for (int i = 0; i < TAMANHO; i++) {
			if (idade[i] < menor) {
				menor = idade[i];
				indiceMenor = i;
			}
		}
		System.out.println("O nome do mais novo é "+nome[indiceMenor]+", sua idade é "+menor);
	}
}
