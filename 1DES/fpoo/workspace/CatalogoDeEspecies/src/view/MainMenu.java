package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Cachorro;
import model.Gato;

public class MainMenu {

	// Cama
	static Scanner scan = new Scanner(System.in);
	static int menu = 0, subMenu, i, posicao;

	static Gato gato;
	static Cachorro cachorro;
	static ArrayList<Gato> gatos = new ArrayList<>();
	static ArrayList<Cachorro> cachorros = new ArrayList<>();

	public static boolean cadastro() {
		subMenu = 0;
		System.out.println("Digite a opção: 1.Gato 2.Cachorro:");
		subMenu = scan.nextInt();
		if (subMenu == 1) {
			System.out.println("Digite os campos abaixo para o Gato:");
			System.out.println("Nome Cor Peso");
			gato = new Gato();
			gato.setNome(scan.next());
			gato.setCor(scan.next());
			gato.setPeso(scan.nextFloat());
			System.out.println("Digite o número de vídas que este gato já perdeu,");
			System.out.println("lembrando que é no máximo 7 vidas:");
			gato.perderVidas(scan.nextInt());
			gatos.add(gato);
			return true;
		} else if (subMenu == 2) {
			System.out.println("Digite os campos abaixo para Cachorro:");
			System.out.println("Nome Cor Peso");
			cachorro = new Cachorro();
			cachorro.setNome(scan.next());
			cachorro.setCor(scan.next());
			cachorro.setPeso(scan.nextFloat());
			System.out.println("Digite quantos motoqueiros este cachorro já assustou:");
			int numeroDeMotoqueiros = scan.nextInt();
			for (int i = 0; i < numeroDeMotoqueiros; i++) {
				cachorro.assustarMotoqueiros();
			}
			cachorros.add(cachorro);
			return true;
		} else {
			return false;
		}
	}

	public static void consulta(int opcao) {
		i = 0;
		if (opcao == 1) {
			System.out.println("Num\tNome\tCor\tPeso\tVivo\tVidas");
			for(Gato g: gatos) {
				System.out.print(i+"\t");
				i++;
				System.out.print(g.getNome()+"\t");
				System.out.print(g.getCor()+"\t");
				System.out.print(g.getPeso()+"\t");
				System.out.print(g.isVivo()+"\t");
				System.out.print(g.getVidas()+"\n");
			}
		} else if (opcao == 2) {
			System.out.println("Num\tNome\tCor\tPeso\tVivo\tMotos");
			for(Cachorro c: cachorros) {
				System.out.print(i+"\t");
				i++;
				System.out.print(c.getNome()+"\t");
				System.out.print(c.getCor()+"\t");
				System.out.print(c.getPeso()+"\t");
				System.out.print(c.isVivo()+"\t");
				System.out.print(c.getMotos()+"\n");
			}
		}
	}

	public static boolean alteracao(int opcao) {
		if(opcao == 1) {
			consulta(opcao);
			System.out.println("Digite a posição do gato a ser alterado na lista:");
			posicao = scan.nextInt();
			System.out.println("Digite os campos abaixo para o Gato:");
			System.out.println("Nome Cor Peso");
			gato = new Gato();
			gato.setNome(scan.next());
			gato.setCor(scan.next());
			gato.setPeso(scan.nextFloat());
			System.out.println("Digite o número de vídas que este gato já perdeu,");
			System.out.println("lembrando que é no máximo 7 vidas:");
			gato.perderVidas(scan.nextInt());
			gatos.remove(posicao);
			gatos.add(posicao,gato);
			return true;
		} else if(opcao==2) {
			consulta(opcao);
			System.out.println("Digite a posição do cachorro a ser alterado na lista:");
			posicao = scan.nextInt();
			System.out.println("Digite os campos abaixo para Cachorro:");
			System.out.println("Nome Cor Peso");
			cachorro =new Cachorro();
			cachorro.setNome(scan.next());
			cachorro.setCor(scan.next());
			cachorro.setPeso(scan.nextFloat());
			System.out.println("Digite quantos motoqueiros este cachorro já assustou:");
			int numeroDeMotoqueiros = scan.nextInt();
			for (int i = 0; i < numeroDeMotoqueiros; i++) {
				cachorro.assustarMotoqueiros();
			}
			cachorros.remove(posicao);
			cachorros.add(posicao,cachorro);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean exclusao(int opcao) {
		consulta(opcao);
		if (opcao == 1) {
			System.out.println("Digite a posição do gato a ser excluído na lista:");
			gatos.remove(scan.nextInt());
			return true;
		}else if(opcao == 2) {
			System.out.println("Digite a posição do cachorro a ser excluído na lista:");
			cachorros.remove(scan.nextInt());
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		while (menu != 5) {
			// CRUD
			System.out.println("\n\n1.Cadastro\n2.Consulta\n3.Alteração\n4.Exclusão\n5.Fim\n\n");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				if (cadastro()) {
					System.out.println("Animal cadastrado com sucesso.");
				} else {
					System.out.println("Opção Inválida");
				}
				break;
			case 2:
				System.out.println("Digite a opção: 1.Gato 2.Cachorro:");
				consulta(scan.nextInt());
				break;
			case 3:
				System.out.println("Digite a opção: 1.Gato 2.Cachorro:");
				if(alteracao(scan.nextInt())) {
					System.out.println("Animal alterado com sucesso.");
				}else {
					System.out.println("Erro ao alterar animal");
				}
				break;
			case 4:
				System.out.println("Digite a opção: 1.Gato 2.Cachorro:");
				if(exclusao(scan.nextInt())) {
					System.out.println("Animal excluído com sucesso.");
				}else {
					System.out.println("Erro ao excluir animal");
				}
				break;
			case 5:
				System.out.println("Tchaw.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}
