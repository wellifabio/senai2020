package lista2;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//Entrada
		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite o seu salário: ");
		float salario = leitura.nextFloat();
		System.out.println("Quantos filhos você tem?: ");
		int filhos = leitura.nextInt();
		//Processamento
		if(salario < 2000){
			salario += filhos * 45;
		}
		//Saída
		System.out.printf("Seu salário final será de R$%.2f",salario);
	}

}
