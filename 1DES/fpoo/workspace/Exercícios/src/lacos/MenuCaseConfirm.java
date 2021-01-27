package lacos;

import java.util.Scanner;

public class MenuCaseConfirm {
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
				System.out.println("Tem certeza? 1-Sim, ?-Não:");
				opcao = ler.nextInt();
				if (opcao == 1) {
					System.out.println("Até logo!");
					opcao = 4;
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
}
