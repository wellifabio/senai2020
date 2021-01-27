package lista2;

import java.util.Scanner;

public class Exemplo1 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite a sua idade:");
		int idade = leia.nextInt();

		if(idade >= 18){
			System.out.println("Vocé é 'DE-MAIOR'");
		}else{
			System.out.println("Vocé é 'DE-MENOR'");
		}
	}

}
