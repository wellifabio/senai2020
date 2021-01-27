package lista2reenye;

import java.util.Scanner;

/*Faça um algoritmo que receba o ano de nascimento do usuário
 * e verifique se ele tem 18 anos ou mais, se a resposta for 
 * positiva é maior de idade.*/
public class Ex2 {

	public static final int ANO_ATUAL = 2020;

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Digite o ano que você nasceu:");
		int anoNascimento = read.nextInt();
		int idade = ANO_ATUAL - anoNascimento;
		if (idade < 18) {
			System.out.println("Você é (DI-MENOR)");
		} else if (idade < 40) {
			System.out.println("Você é (DI-MAIOR)");
		} else if (idade < 70){
			System.out.println("Você é (VÉIO)");
		} else if(idade < 100){
			System.out.println("Você está (com o Pé na cova)");
		} else {
			System.out.println("O que você está fazendo aqui ainda.");
		}
	}

}
