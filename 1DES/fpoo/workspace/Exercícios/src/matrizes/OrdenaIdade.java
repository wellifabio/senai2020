package matrizes;

import java.util.Scanner;

public class OrdenaIdade {
	
	public static Scanner leia = new Scanner(System.in);
	public static final int COMPRIMENTO = 10;
	
	public static void main(String[] args){
		String[] nome = new String[COMPRIMENTO];
		int[] idade =  new int[COMPRIMENTO];
		
		//Entrada
		System.out.println("Nome, Idade:");
		for(int i = 0; i < COMPRIMENTO; i++){
			nome[i] = leia.next();
			idade[i] = leia.nextInt();
		}
		
		//Processamento
		for(int i = 0; i < COMPRIMENTO - 1; i++){
			for(int j = i + 1; j < COMPRIMENTO; j++){
				if(idade[i] > idade[j]){
					String auxNome = nome[i];
					nome[i] = nome[j];
					nome[j] = auxNome;
					
					int auxIdade = idade[i];
					idade[i] = idade[j];
					idade[j] = auxIdade;
				}
			}
		}
		
		//Saída
		for(int i = 0; i < COMPRIMENTO; i++){
			System.out.println(nome[i]+" "+idade[i]);
		}
	}
}
