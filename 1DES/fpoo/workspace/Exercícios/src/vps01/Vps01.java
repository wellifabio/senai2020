package vps01;

import java.util.Scanner;

public class Vps01 {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		int menuPrincipal = 0;
		while (menuPrincipal != 5) {
			System.out.println("\n\n\n1 - Situação Problema: Taxa de Juros");
			System.out.println("2 - Situação Problema: Calcular Área");
			System.out.println("3 - Situação Problema: Controle de Cestas");
			System.out.println("4 - Situação Problema: Pizzaria Fidelidade");
			System.out.println("5 - Sair\n\n");
			menuPrincipal = leia.nextInt();
			switch (menuPrincipal) {
			case 1:
				System.out.println("Digite o valor do boleto de o número de dias em atrazo:");
				float valor = leia.nextFloat();
				int dias = leia.nextInt();
				float juros = valor * (dias * (float) 1.3) / 100;
				float montante = valor + juros;
				System.out.printf(
						"Aplicando taxa de 1.3 porcento ao dia.\nO total de juros é R$ %.2f\nE o montante final é R$ %.2f\n",
						juros, montante);
				break;
			case 2:
				System.out.println("Digite o valor (a) da lateral do cubo:");
				float a = leia.nextFloat();
				float ac = 6 * (a * a);
				float vc = a * a * a;
				System.out.printf("A área deste cubo é Ac=6 x a^2 = %.2f\n", ac);
				System.out.printf("O volume deste cubo é Ac=a^3 = %.2f\n", vc);
				break;
			case 3:
				String[] funcionario = { "Alice", "Miguel", "Sophia", "Arthur", "Helena", "Bernardo", "Valentina",
						"Heitor", "Laura", "Davi" };
				boolean[] cesta = { false, false, false, false, false, false, false, false, false, false };
				String nomeFun;
				int menuCesta = 0;
				while (menuCesta != 4) {
					System.out.println("\n\n1.Registrar Coleta\n2.Lista das Retiradas\n3.Lista dos Pendentes\n4.Sair");
					menuCesta = leia.nextInt();
					if (menuCesta == 1) {
						System.out.println("Digite o nome do Funcionário");
						nomeFun = leia.next();
						for (int i = 0; i < funcionario.length; i++) {
							if (nomeFun.equals(funcionario[i])) {
								cesta[i] = true;
							}
						}
					} else if (menuCesta == 2) {
						for (int i = 0; i < funcionario.length; i++) {
							if (cesta[i]) {
								System.out.println(funcionario[i]);
							}
						}
					} else if (menuCesta == 3) {
						for (int i = 0; i < funcionario.length; i++) {
							if (!cesta[i]) {
								System.out.println(funcionario[i]);
							}
						}
					} else if (menuCesta == 4) {
						System.out.println("Bye, bye!");
					} else {
						System.out.println("Opção Inválida.");
					}
				}
				break;
			case 4:
				String[] clientes = new String[20];
				int[] pedidos = new int[20];
				System.out.println("Digite quantos Clientes deseja cadastrar, no máximo 20");
				int n = leia.nextInt();
				System.out.println("Digite a tabela o nome e a quantidade de pedidos destes " + n + " clientes");
				for (int i = 0; i < n; i++) {
					clientes[i] = leia.next();
					pedidos[i] = leia.nextInt();
				}
				for (int i = 0; i < n; i++) {
					int cupons = 0;
					if(pedidos[i]<10){
						cupons = 0;
					}else if(pedidos[i]<20){
						cupons = 1;
					}else if(pedidos[i]<30){
						cupons = 2;
					}else if(pedidos[i]<40){
						cupons = 3;
					}else if(pedidos[i]<50){
						cupons = 4;
					}else{
						cupons = 5;
					}
					System.out.println("O cliente "+clientes[i]+", possui "+cupons+" cupons, num total de "+(cupons*20)+"% de desconto no próximo pedido.");
				}
				break;
			case 5:
				System.out.println("Valeus, falows");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}
