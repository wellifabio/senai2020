package lacos;

import java.util.Scanner;

public class MenuIf {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 4) {
			System.out.println("Digite uma das quatro opções:");
			System.out.println("1-Bom dia\n2-Boa tarde\n3-Boa noite\n4-Sair");
			opcao = ler.nextInt();
			if (opcao == 1) {
				System.out.println("Olá, bom dia!");
			} else if (opcao == 2) {
				System.out.println("Olá, boa tarde!");
			} else if (opcao == 3) {
				System.out.println("Olá, boa noite!");
			} else if (opcao == 4) {
				System.out.println("Até logo!");
			} else {
				System.out.println("Opção inválida!");
			}
		}
	}
}
