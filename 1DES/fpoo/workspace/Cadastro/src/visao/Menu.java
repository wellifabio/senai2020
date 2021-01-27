package visao;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pessoa;

public class Menu {

	static Scanner read = new Scanner(System.in);
	static int menu = 0;

	static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	static Pessoa pessoa;

	public static void main(String[] args) {
		while (menu != 3) {
			System.out.println("1. Cadastrar\n2. Ler (Listar)\n3. Sair\n\n\n");
			menu = read.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Nome Idade Peso Altura");
				pessoa = new Pessoa();
				pessoa.setNome(read.next());
				pessoa.setIdade(read.nextInt());
				pessoa.setPeso(read.nextFloat());
				pessoa.setAltura(read.nextFloat());
				pessoas.add(pessoa); // Coloca a pessoa na lista de pessoas
				System.out.println("Cadastrado com sucesso.");
				break;
			case 2:
				System.out.println("Nome Idade Peso Altura");
				for (Pessoa p : pessoas) {//FOR EACH - Para cada
					System.out.print(p.getNome() + " ");
					System.out.print(p.getIdade() + " ");
					System.out.print(p.getPeso() + " ");
					System.out.print(p.getAltura()+ " ");
					System.out.printf("%.2f\n",p.getIMC());//Além de calcular ainda formata
				}
				break;
			case 3:
				System.out.println("Valews, falows.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}
