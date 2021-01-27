package lacos;

import java.util.Scanner;

public class Exemplo2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int i = 1;
		while(i < 2 || i > 120){
			System.out.println("Digite a sua idade");
			//i = leia.nextInt();
		}
		
		System.out.println("Sua idade é "+i);
	}

}
