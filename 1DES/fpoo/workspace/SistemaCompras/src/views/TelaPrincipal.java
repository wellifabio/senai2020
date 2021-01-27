package views;

import java.util.Scanner;

import controllers.ProcessaTudo;
import models.Compra;

public class TelaPrincipal {

	static Scanner read = new Scanner(System.in);
	static TelaProduto tp = new TelaProduto();
	static TelaCompra tc = new TelaCompra();
	static Compra compra = null;
	static int menu = 0, subMenu = 0;

	public static void main(String[] args) {
		while (menu != 3) {
			System.out.println("\n1.Cadastro Produtos\n2.Cadastro de Compras\n3.Sair\n");
			menu = read.nextInt();
			switch (menu) {
			case 1:
				System.out.println("\n1.Cadastro\n2.Consulta\n3.Alteração\n4.Exclusão\n");
				subMenu = read.nextInt();
				switch (subMenu) {
				case 1:
					ProcessaTudo.getProdutos().add(tp.cadastro());
					break;
				case 2:
					tp.consulta();
					break;
				case 3:
					if (tp.alteracao()) {
						System.out.println("Alterado com sucesso");
					}
					break;
				case 4:
					if (tp.exclusao()) {
						System.out.println("Removido com sucesso");
					}
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
				break;
			case 2:
				System.out.println("\n1.Registrar compra\n2.Listar Compras\n");
				subMenu = read.nextInt();
				switch (subMenu) {
				case 1:
					tp.consulta();
					compra = tc.cadastro();
					if (compra != null) {
						ProcessaTudo.getCompras().add(compra);
						System.out.println("Compra registrada com sucesso");
					}
					break;
				case 2:
					tc.consulta();
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
				break;
			case 3:
				System.out.println("Adeus.");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}
