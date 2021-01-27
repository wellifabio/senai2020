package visao;

import java.util.Scanner;
import modelo.Pessoa;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	static Pessoa pessoa = new Pessoa();
	
	public static void main(String[] args) {
		
		System.out.println("Digite o nome");
		pessoa.setNome(leia.next());
		System.out.println("Digite a idade");
		pessoa.setIdade(leia.nextInt());
		
		System.out.println("A "+pessoa.getNome()+" tem "+pessoa.getIdade()+" anos");
	}

}
