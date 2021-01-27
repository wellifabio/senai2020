package matrizes;

import java.util.Scanner;

public class OrdenaNome {

	public static Scanner leia = new Scanner(System.in);
	public static final int COMPRIMENTO = 10; //Constante
	
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
				if(nome[i].charAt(0) > nome[j].charAt(0)){
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
