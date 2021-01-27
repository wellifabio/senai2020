package matrizes;

import java.util.Scanner;

public class Troca {

	public static Scanner leia = new Scanner(System.in);
	public static void main(String[] args) {
		String copo = "Suco de laranja";
		String caneca = "Suco de abacaxi";
		System.out.println("copo = "+copo);
		System.out.println("caneca = "+caneca);
		System.out.println("Digite 1 para trocar ou outro nro.");
		int numero = leia.nextInt();
		if(numero == 1){
			String auxiliar = copo;
			copo = caneca;
			caneca = auxiliar;
		}
		System.out.println("copo = "+copo);
		System.out.println("caneca = "+caneca);
	}

}
