package listaead1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* A Sra. Bete, dona da cantina do SENAI precisa de um programa para anotar os “fiados”.
Atualmente ela utiliza uma ficha com o nome do aluno e anota a data e o valor gasto. Ao final do mês
ela soma os valores desta ficha e o aluno realiza o pagamento. Desenvolva um programa que
cadastre em uma lista os campos: (nome, dia, mês e valor) e gere uma tabela para cada aluno
contendo (nome, dia, mês e valor) e o total da conta. Para isso crie um menu com as opções, 1.
Cadastrar compra, 2. Listar compra por aluno e 3. Sair.
*/

import java.util.Scanner;

public class Atividade5data {

	// Solução completa com índice
	public static Scanner leia = new Scanner(System.in);
	public static ArrayList<String> indice = new ArrayList<String>();
	public static ArrayList<String> nome = new ArrayList<String>();
	public static ArrayList<String> dia = new ArrayList<String>();
	public static ArrayList<String> mes = new ArrayList<String>();
	public static ArrayList<String> valor = new ArrayList<String>();
	// Pegar a data do sistema
	public static Date data = new Date();
	public static SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
	public static SimpleDateFormat sdfMes = new SimpleDateFormat("MM");

	public static void main(String[] args) {
		int menu = 0;
		while (menu != 4) {
			System.out.println("\n\n\n1. Cadastrar compra");
			System.out.println("2. Listar compra por aluno");
			System.out.println("3. Listar todos");
			System.out.println("4. Sair");
			menu = leia.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite o nome do aluno:");
				String nom = leia.next();
				// Percorre o índice para ver se não encontra o nome
				if (!indice.contains(nom)) {
					indice.add(nom);
				}
				// Acrescenta o novo registro
				nome.add(nom);
				dia.add(sdfDia.format(data));
				mes.add(sdfMes.format(data));
				System.out.println("Digite o valor:");
				valor.add(leia.next());
				break;
			case 2:
				float sub = 0;
				System.out.println("Digite o nome do aluno");
				String busca = leia.next();
				if (indice.contains(busca)) {
					System.out.println("Nome, dia, mes, valor:");
					for (int i = 0; i < nome.size(); i++) {
						if (busca.equals(nome.get(i))) {
							System.out.print(nome.get(i) + ", ");
							System.out.print(dia.get(i) + ", ");
							System.out.print(mes.get(i) + ", ");
							System.out.println(valor.get(i));
							sub += Float.parseFloat(valor.get(i));
						}
					}
					System.out.printf("O total da conta é R$ %.2f\n", sub);
				} else {
					System.out.println("Aluno não fez nenhuma compra");
				}
				break;
			case 3:
				// Agrupar utilizando o índice
				float total = 0;
				System.out.println("Nome, dia, mes, valor:");
				for (int i = 0; i < indice.size(); i++) {
					float subTotal = 0;
					for (int j = 0; j < nome.size(); j++) {
						if (indice.get(i).equals(nome.get(j))) {
							System.out.print(nome.get(j) + ", ");
							System.out.print(dia.get(j) + ", ");
							System.out.print(mes.get(j) + ", ");
							System.out.println(valor.get(j));
							subTotal += Float.parseFloat(valor.get(j));
						}
					}
					System.out.printf("O total da conta é R$ %.2f\n", subTotal);
					total += subTotal;
				}
				System.out.printf("O total geral a receber é R$ %.2f\n", total);
				break;
			case 4:
				System.out.println("Tchaw!");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}