package vetores;
/*Programa que le o nome e a idade de 5 pessoas e informa a média*/
import java.util.Scanner;

public class Exemplo2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] nome = new String[5];
		int[] idade = new int[5];
		
		System.out.println("Digite o nome e a idade de 5 pessoas:");
		for(int i = 0; i < 5; i++){
			nome[i] = input.next();
			idade[i] = input.nextInt();
		}

		for(int i = 0; i < 5; i++){
			System.out.println(nome[i]+", "+idade[i]);
		}
		
		float media = (idade[0]+idade[1]+idade[2]+idade[3]+idade[4])/5;
		System.out.println("A média de idade desta população é "+media);
	}

}
