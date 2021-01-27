package principal;

import java.util.Scanner;

public class MenuPrincipal {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		/* Definição do escopo do problema
		*  Filtro através de um laço enquanto para permitir somente numeros
		*  entre 1 e 100*/
		int n = 0;
		while (n < 1 || n >= 100) {
			System.out.println("Quantos funcionário você quer administrar de 1 a 100?");
			n = input.nextInt();
		}

		// Vairáveis que serão administradas (Vetores)
		String[] nome = new String[n];
		float[] salario = new float[n];
		float[] porcentagem = new float[n];
		float[] novoSalario = new float[n];
		boolean[] descontoAumento = new boolean[n];
		int ponteiro = 0;

		// Menu
		int menu = 0;
		while (menu != 4) {
			System.out.println("1.Cadastro\n2.Calcular Reajuste\n3.Listar Todos\n4.Sair");
			menu = input.nextInt();
			switch(menu){
			case 1:
				System.out.println("Digite Nome, Salário, %, (true) aumento ou (false) desconto:");
				nome[ponteiro] = input.next();
				salario[ponteiro] = input.nextFloat();
				porcentagem[ponteiro] = input.nextFloat();
				descontoAumento[ponteiro] = input.nextBoolean();
				ponteiro++;
				System.out.println("Cadastrado com sucesso.");
				break;
			case 2:
				for(int i = 0; i < ponteiro; i++){
					if(descontoAumento[i]){
						novoSalario[i] = salario[i] + salario[i] * porcentagem[i] / 100;
					} else {
						novoSalario[i] = salario[i] - salario[i] * porcentagem[i] / 100;
					}
				}
				System.out.println("Reajuste calculado para todos os funcionários cadastrados.");
				break;
			case 3:
				System.out.println("Nome, Salário, %, Reajuste, Novo Salário");
				for(int i = 0; i < ponteiro; i++){
					System.out.println(nome[i]+", "+salario[i]+", "+porcentagem[i]+", "+descontoAumento[i]+", "+novoSalario[i]);
				}
				break;
			case 4:
				System.out.println("Adeus!");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
	}
}
