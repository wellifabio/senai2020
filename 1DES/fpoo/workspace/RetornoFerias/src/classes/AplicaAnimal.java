package classes;

public class AplicaAnimal {
	
	static Animais toto = new Animais();
	static Animais mimi = new Animais();
	static Animais tico = new Animais();
	static Animais urubu = new Animais();

	public static void main(String[] args) {
		
		toto.nome = "Toto";
		toto.especie = "Cachorro";
		toto.cor = "banca";
		toto.peso = 2;
		
		mimi.nome = "Mini";
		mimi.especie = "gata";
		mimi.cor = "banca";
		mimi.peso = (float)1.3;
		
		tico.nome = "Tico";
		tico.especie = "gato";
		tico.cor = "preta";
		tico.peso = (float)1.8;
		
		urubu.nome = "Zeca";
		urubu.especie = "urubú";
		urubu.cor = "preta";
		urubu.peso = 3;
		
		System.out.println(toto.retornaFraseComParametro("m"));
		System.out.println(mimi.retornaFraseComParametro("f"));
		System.out.println(tico.retornaFraseComParametro("m"));
		System.out.println(urubu.retornaFraseComParametro("m"));
		
		urubu.escreveFrase(" Kilos");
	
	}

}

/* Exercício: Utilizar o mesmo exemplo, criando a classe, atributos e métodos.
Pessoas (nome, idade, peso, altura) 
Instanciar a classe em outra chamada AplicaPessoa com o método main
*/