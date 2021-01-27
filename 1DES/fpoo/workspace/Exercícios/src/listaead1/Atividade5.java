package listaead1;

import java.util.ArrayList;

/* A Sra. Bete, dona da cantina do SENAI precisa de um programa para anotar os “fiados”.
Atualmente ela utiliza uma ficha com o nome do aluno e anota a data e o valor gasto. Ao final do mês
ela soma os valores desta ficha e o aluno realiza o pagamento. Desenvolva um programa que
cadastre em uma lista os campos: (nome, dia, mês e valor) e gere uma tabela para cada aluno
contendo (nome, dia, mês e valor) e o total da conta. Para isso crie um menu com as opções, 1.
Cadastrar compra, 2. Listar compra por aluno e 3. Sair.
*/

import java.util.Scanner;

public class Atividade5 {

	//Solução simples sem índice
	public static Scanner leia = new Scanner(System.in);
	public static ArrayList<String> nome = new ArrayList<String>();
	public static ArrayList<String> dia = new ArrayList<String>();
	public static ArrayList<String> mes = new ArrayList<String>();
	public static ArrayList<String> valor = new ArrayList<String>();

	public static void main(String[] args) {
		int menu = 0;
		while (menu != 3) {
			System.out.println("1. Cadastrar compra");
			System.out.println("2. Listar compra por aluno");
			System.out.println("3. Sair");
			menu = leia.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite o nome do aluno:");
				nome.add(leia.next());
				System.out.println("Digite o dia:");
				dia.add(leia.next());
				System.out.println("Digite o mes:");
				mes.add(leia.next());
				System.out.println("Digite o valor:");
				valor.add(leia.next());
				break;
			case 2:
				float total = 0;
				System.out.println("Nome, dia, mes, valor");
				for(int i = 0; i < nome.size(); i++) {
					System.out.print(nome.get(i)+", ");
					System.out.print(dia.get(i)+", ");
					System.out.print(mes.get(i)+", ");
					System.out.println(valor.get(i));
					total += Float.parseFloat(valor.get(i));
				}
				System.out.printf("O total a receber é R$ %.2f\n",total);
				break;
			case 3:
				System.out.println("Tchaw!");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}