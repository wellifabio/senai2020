package lista2reenye;

import java.util.Scanner;

/*Faça um algoritmo para calcular a média final da disciplina
 * de programação e mostrar esta média fina e uma mensagem
 * informando se o aluno foi ou não aprovado (media >=6)*/
public class Ex1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite as duas notas da disciplina:");
		int nota1 = leia.nextInt();
		int nota2 = leia.nextInt();
		
		float media = (float) (nota1 + nota2) / 2;
		
		System.out.printf("A média é %.1f\n", media);
		
		if (media >= 6) {
			System.out.println("Você está Aprovado");
		} else {
			System.out.println("Você está Reprovado");
		}
	}
}
