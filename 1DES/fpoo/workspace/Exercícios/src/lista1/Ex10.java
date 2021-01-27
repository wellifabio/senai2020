package lista1;

import java.util.Scanner;

/*Pedra mineira é um tipo de piso muito utilizado para revestir
 * o chão em volta de piscinas, dez quilos de pedra mineira
 * custam R$ 130,00 e revestem uma área de 3,7 m2. Desenvolva
 * um programa que leia a área total (m2) a ser revestida, 
 * calcule e apresente na tela o total de quilos de pedra
 * mineira que serão necessários para o revestimento e o 
 * seu custo total (R$). O programa deverá apresentar os valores
 *  monetários formatados com duas casas decimais*/
public class Ex10 {

	public static int CUSTO_KILO_PEDRA = 13;
	public static float AREA_KILO = (float) 0.37;
	
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		System.out.println("Digite a área a ser revestida (m2):");
		float area = leia.nextFloat();
		
		float totalKilos = (float) area / AREA_KILO;
		float totalDinheiro = (float) totalKilos * CUSTO_KILO_PEDRA;
		
		System.out.printf("O total de kilos é de %.2f\n",totalKilos);
		System.out.printf("O custo total será de R$ %.2f",totalDinheiro);
	}

}
