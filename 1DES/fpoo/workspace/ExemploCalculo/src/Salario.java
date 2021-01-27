import java.util.Scanner;

public class Salario {

	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Definição das variáveis
		String nome;
		float salario;
		float porcentagem;
		float novoSalario;
		
		System.out.println("Digite o nome, salário e porcentagem de aumento:");
		//Entrada
		nome = leia.next();
		salario = leia.nextFloat();
		porcentagem = leia.nextFloat();
		
		//Processamento
		novoSalario = salario + salario * porcentagem / 100;
		
		//Saída
		System.out.printf("O novo salario de %s será R$ %.2f",nome,novoSalario);
	}
}
