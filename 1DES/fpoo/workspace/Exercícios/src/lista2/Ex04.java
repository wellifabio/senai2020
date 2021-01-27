package lista2;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// Entrada
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite os valores dos três lados do triângulo:");
		int a = leia.nextInt();
		int b = leia.nextInt();
		int c = leia.nextInt();

		// Processamento
		String triangulo = "Não sei";
		
		if (a == b && b == c) {
			triangulo = "EQUILÁTERO";
		} else if (a != b && b != c && a != c) {
			triangulo = "ESCALENO";
		} else {
			triangulo = "ISOCELES";
		}
		
		// Saída
		System.out.println("O triânguo é: " + triangulo);
	}
}
