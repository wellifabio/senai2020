package vetores;

/*Programa que armazena em tempo de execução
 * o nome e a idade de até 100 pessoas e
 * informa a média,
 * o nome do indivíduo com maior idade
 * e o nome do indivíduo com menor idade*/
import java.util.Scanner;

public class Exemplo5 {

	public static final int TAMANHO = 100;
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		String[] nome = new String[TAMANHO];
		int[] idade = new int[TAMANHO];
		int indice = 0;
		int menu = 0;
		while (menu != 6) {
			System.out.println("1.Cadastrar\n2.Listar\n3.Media\n4.Mais velho\n5.Mais novo\n6.Sair");
			menu = input.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite o nome e a idade da " + (indice + 1) + "ª pessoa:");
				nome[indice] = input.next();
				idade[indice] = input.nextInt();
				indice++;
				break;
			case 2:
				for (int i = 0; i < indice; i++) {
					System.out.println(nome[i] + ", " + idade[i]);
				}
				break;
			case 3:
				// Técnica de acumulação para calcular a média
				float media = 0;
				for (int i = 0; i < indice; i++) {
					media += idade[i];
				}
				media /= indice;
				System.out.printf("A média de idade desta população é %.1f\n", media);
				break;
			case 4:
				// Técnica de comparação maior
				int maior = 0;
				int indiceMaior = 0;
				for (int i = 0; i < indice; i++) {
					if (idade[i] > maior) {
						maior = idade[i];
						indiceMaior = i;
					}
				}
				System.out.println("O nome da pessoa mais velha é " + nome[indiceMaior] + ", sua idade é " + maior);
				break;
			case 5:
				// Técnica de comparação menor
				int menor = 200;
				int indiceMenor = 0;
				for (int i = 0; i < indice; i++) {
					if (idade[i] < menor) {
						menor = idade[i];
						indiceMenor = i;
					}
				}
				System.out.println("O nome da pessoa mais nova é " + nome[indiceMenor] + ", sua idade é " + menor);
				break;
			case 6:
				System.out.println("Até logo!");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}
