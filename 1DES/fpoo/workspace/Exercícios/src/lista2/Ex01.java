package lista2;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("Digite o preço de um produto: ");
		Scanner scan  = new Scanner(System.in);
		double preco = scan.nextDouble();
		
		if(preco > 1000){
			//double desconto = preco * 8 / 100;
			//preco = preco - desconto;
			
			//double desconto = preco * 0.08;
			//preco -= desconto;
			
			//preco = preco - preco * 0.08;
			preco -= preco * 0.08;
		}
		
		System.out.printf("O preço final é R$%.2f",preco);
	}
}
