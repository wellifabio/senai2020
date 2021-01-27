package lacos;

import java.util.Scanner;

public class MenuCase {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 4) {
			System.out.println("Digite uma das quatro opções:");
			System.out.println("1-Bom dia\n2-Boa tarde\n3-Boa noite\n4-Sair");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Olá, bom dia!");
				break;
			case 2:
				System.out.println("Olá, boa tarde!");
				break;
			case 3:
				System.out.println("Olá, boa noite!");
				break;
			case 4:
				System.out.println("Até logo!");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
}
