package lista1;

import java.util.Scanner;

/*Um caminhão consegue transportar 18 toneladas de laranjas
 * em uma viagem que faz entre a fazen-da e a fábrica de suco de laranja.
 * Um alqueire de terra produz em média 250 toneladas de laranjas.
 * Faça um programa que leia quantos caminhões e quantos alqueires
 * uma fazenda produtora de laranjas possui,
 * calcule e apresente na tela quantas viagens de caminhão
 * serão necessárias para transportar toda a colheita de laranjas*/
public class Ex5 {

	public static int TON_MAX_CAMINHAO = 18;
	public static int TON_MEDIA_MALQUEIRE = 250;

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		System.out.print("Quantos Caminhões o fazendeiro possui?:");
		int caminhoes = leia.nextInt();
		System.out.print("Quantos Alqueires o fazenda possui?:");
		int alqueire = leia.nextInt();

		int viagens = (alqueire * TON_MEDIA_MALQUEIRE) /(caminhoes * TON_MAX_CAMINHAO);
		
		System.out.println("O Fazendeiro precisará de "+viagens+" viagens para transportar a colheita");
	}

}
