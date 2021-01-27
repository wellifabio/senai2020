package lista2reenye;
/* A empresa XKW concedeu um bonus de 20% do valor do 
 * Salário a todos os funcionários com o tempo de trabaho 
 * igual ou superior a 5 anos e 10% aos demais.
 */
import java.util.Scanner;

public class Ex3 {
	
	public static final float PORCENTO_20 = (float) 20 / 100;
	public static final float PORCENTO_10 = (float) 10 / 100;
	public static void main(String[] args) {
		Scanner info = new Scanner(System.in);
		System.out.println("Digite o nome, salário e tempo de empresa em anos:");
		String nome = info.next();
		float salario = info.nextFloat();
		int tempo = info.nextInt();
		float aumento = 0;
		if(tempo >= 5) {
			aumento = salario * PORCENTO_20;
		} else {
			aumento = salario * PORCENTO_10;
		}
		salario = salario + aumento;
		System.out.printf("O novo salário do %s será de R$ %.2f",nome,salario);
	}
}
