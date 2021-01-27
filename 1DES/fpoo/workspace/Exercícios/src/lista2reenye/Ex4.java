package lista2reenye;

import java.util.Scanner;

/*Implemente um código para aprovar empréstimo bancário
 * o código deve pedir três informações:
 * Valor do empréstimo
 * Número de parcelas
 * Salário do solicitante
 * Aprovar empréstimo caso o valor da parcela
 * represente no máximo 30% do salário do Solicitante*/
public class Ex4 {

	public static void main(String[] args) {
		Scanner papaleguas = new Scanner(System.in);
		System.out.println("Digite o valor:");
		float valor = papaleguas.nextFloat();
		System.out.println("Digite o número de parcelas:");
		int parcelas = papaleguas.nextInt();
		System.out.println("Digite seu salário:");
		float salario = papaleguas.nextFloat();
		
		float juros = valor * 10 / 100; //Valor do juros
		valor = valor + juros; //Valor com juros
		float valorParcela = (float) valor / parcelas;
		
		if(valorParcela >= (salario * 30 / 100)) {
			System.out.println("Financiamento Reprovado");
			System.out.printf("O valor da parcela seria de R$%.2f\n",valorParcela);
			System.out.printf("Ultrapassando 30 por cento do seu salário R$%.2f\n",salario);
		}else {
			System.out.println("Financiamento Aprovado");
			System.out.printf("O montante será de R$%.2f\n",valor);
			System.out.printf("A parcela será de R$%.2f\n",valorParcela);
		}
	}

}
