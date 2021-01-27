package vps01;

import java.util.Scanner;

public class SituacoesProblema {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		int menu = 0;
		while (menu != 5) {
			System.out.println("1 prob\n2 prob\n3 prob\n4 prob\n5 Sair.");
			menu = leia.nextInt();
			switch (menu) {
			case 1:
				float multa = (float) 1.3 / 100;
				System.out.println("Digite o valor do boleto e quantos dias de atraso:");
				// Entrada
				float valor = leia.nextFloat();
				int dias = leia.nextInt();
				// Processamento
				float valorDaMulta = valor * multa * dias;
				// Saída
				System.out.println("O valor da multa é " + valorDaMulta);
				break;
			case 2:
				System.out.println("Digite o valor da ARESTA do cubo:");
				float a = leia.nextFloat();
				float aC = 6 * a * a;
				float vC = a * a * a;
				System.out.printf("A área do cubo é = %.2f\n", aC);
				System.out.printf("O volume do cubo é = %.2f\n", vC);
				break;
			case 3:
				String[] funcionarios = { "Alice", "Miguel", "Sophia", "Arthur", "Helena", "Bernardo", "Valentina",
						"Heitor", "Laura", "Davi" };
				int[] status = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

				int subMenu = 0;
				while (subMenu != 4) {
					System.out.println("1 Registrar");
					System.out.println("2 Retiradas");
					System.out.println("3 Pendentes");
					System.out.println("4 Sair");
					subMenu = leia.nextInt();
					if (subMenu == 1) {
						System.out.println("Digite o nome do funcionário:");
						String nome = leia.next();
						for (int i = 0; i < 10; i++) {
							if (nome.equals(funcionarios[i])) {
								status[i] = 1;
							}
						}
					} else if (subMenu == 2) {
						for (int i = 0; i < 10; i++) {
							if (status[i] == 1) {
								System.out.println(funcionarios[i]);
							}
						}
					} else if (subMenu == 3) {
						for (int i = 0; i < 10; i++) {
							if (status[i] != 1) {
								System.out.println(funcionarios[i]);
							}
						}
					} else if (subMenu == 4) {
						System.out.println("Valews, falows, fuis..");
					} else {
						System.out.println("Opção inválida");
					}
				}
				break;
			case 4:
				String[] clientes = new String[20];
				int[] pedidos = new int[20];
				int[] cupons = new int[20];
				int contador = 0;
				int menuCli = 0;
				while (menuCli != 3) {
					System.out.println("1 Cadastar pedido\n2 Listar todos\n3 Sair");
					menuCli = leia.nextInt();
					switch (menuCli) {
					case 1:
						System.out.println("Digite o nome do Cliente:");
						String nomeCli = leia.next();
						boolean encontrado = false;
						for (int i = 0; i < contador; i++) {
							if (nomeCli.equals(clientes[i])) {
								pedidos[i]++;
								if (pedidos[i] < 10) {
									cupons[i] = 0;
								} else if (pedidos[i] < 20) {
									cupons[i] = 1;
								} else if (pedidos[i] < 30) {
									cupons[i] = 2;
								} else if (pedidos[i] < 40) {
									cupons[i] = 3;
								} else if (pedidos[i] < 50) {
									cupons[i] = 4;
								} else {
									cupons[i] = 5;
								}
								encontrado = true;
							}
						}
						if (!encontrado) {
							clientes[contador] = nomeCli;
							pedidos[contador]++;
							contador++;
						}
						break;
					case 2:
						System.out.println("Nome, Pedidos, Cupons, %:");
						for (int i = 0; i < contador; i++) {
							System.out.println(clientes[i] + ", " + pedidos[i] + ", " + cupons[i]+","+(cupons[i]*20/100));
						}
						break;
					case 3:
						System.out.println("Até logo.");
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				}

				break;
			case 5:
				System.out.println("Bye, bye.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}
