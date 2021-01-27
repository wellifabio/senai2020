package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Animal;

public class Menu {

	static ArrayList<Animal> animais = new ArrayList<Animal>();
	static Animal animal;
	static Scanner scan = new Scanner(System.in);
	static int menu = 0, indice;

	// CRUD (Create, Read, Update, Delete) (Cadastro, Consulta[1 ou n], Alteração,
	// Exclusão)
	public static void main(String[] args) {
		System.out.println("CRUD de Animais (LISTAS)");
		while (menu != 7) {
			System.out.println("\n\n1.Cadastro (CREATE)\n2.Listar todos(READ)\n3.Ler apenas um(READ)");
			System.out.println("4.Alterar um(UPDATE)\n5. Excluir um(DELETE)\n6.Limpar Lista(DELETE)\n7.Sair\n\n");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite os dados abaixo:");
				System.out.println("Nome Espécie Cor Peso");
				animal = new Animal(); // Limpa o objeto (Criando um novo)
				animal.setNome(scan.next());
				animal.setEspecie(scan.next());
				animal.setCor(scan.next());
				animal.setPeso(scan.nextFloat());
				animais.add(animal); // Adiciona o objeto a lista
				break;
			case 2:
				System.out.println("Nome\tEspécie\tCor\tPeso");
				for (Animal a : animais) {// Para cada animal a que pertença a lista de animais
					System.out.print(a.getNome() + "\t" + a.getEspecie() + "\t");
					System.out.println(a.getCor() + "\t" + a.getPeso());
				}
				break;
			case 3:
				System.out.println("Digite a posição na lista inicando em 0:");
				indice = scan.nextInt();
				if (indice < animais.size()) {
					System.out.println("Nome: " + animais.get(indice).getNome());
					System.out.println("Espécie: " + animais.get(indice).getEspecie());
					System.out.println("Cor: " + animais.get(indice).getCor());
					System.out.println("Peso: " + animais.get(indice).getPeso());
				} else {
					System.out.println("Posição inválida");
				}
				break;
			case 4:
				System.out.println("Digite a posição na lista inicando em 0:");
				indice = scan.nextInt();
				if (indice < animais.size()) {
					System.out.println("Nome: " + animais.get(indice).getNome());
					System.out.println("Espécie: " + animais.get(indice).getEspecie());
					System.out.println("Cor: " + animais.get(indice).getCor());
					System.out.println("Peso: " + animais.get(indice).getPeso());
					
					System.out.println("Digite os dados abaixo:");
					System.out.println("Nome Espécie Cor Peso");
					animal = new Animal(); // Limpa o objeto (Criando um novo)
					animal.setNome(scan.next());
					animal.setEspecie(scan.next());
					animal.setCor(scan.next());
					animal.setPeso(scan.nextFloat());
					animais.remove(indice);
					animais.add(indice, animal);	
				} else {
					System.out.println("Posição inválida");
				}
				
				break;
			case 5:
				System.out.println("Digite a posição na lista inicando em 0:");
				indice = scan.nextInt();
				if (indice < animais.size()) {
					System.out.println("Nome: " + animais.get(indice).getNome());
					System.out.println("Espécie: " + animais.get(indice).getEspecie());
					System.out.println("Cor: " + animais.get(indice).getCor());
					System.out.println("Peso: " + animais.get(indice).getPeso());
					animais.remove(indice);
				} else {
					System.out.println("Posição inválida");
				}
				break;
			case 6:
				animais = new ArrayList<Animal>();
				System.out.println("Lista Limpa.");
				break;
			case 7:
				System.out.println("Bye, bye.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}

}
