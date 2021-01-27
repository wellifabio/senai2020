package pessoas;

public class Principal {

	static Pessoa joao = new Pessoa();
	static Pessoa ana = new Pessoa();
	static Pessoa maria = new Pessoa();
	static Pessoa carla = new Pessoa();
	
	public static void main(String[] args) {
		
		joao.nome = "João";
		joao.idade = 35;
		joao.altura = (float)1.75;
		joao.peso = (float)75.5;
		
		ana.nome = "Ana";
		ana.idade = 18;
		ana.altura = (float)1.65;
		ana.peso = (float)44;
		
		maria.nome = "Maria";
		maria.idade = 44;
		maria.altura = (float)1.50;
		maria.peso = (float)85;
		
		carla.nome = "Carla";
		carla.idade = 22;
		carla.altura = (float)1.68;
		carla.peso = (float)52;
		
		System.out.println(joao.retornaDados("m"));
		System.out.println(ana.retornaDados("f"));
		System.out.println(maria.retornaDados("f"));
		System.out.println(carla.retornaDados("f"));
		
		System.out.println("O "+joao.nome+"tem "+joao.idade+" anos.");
		System.out.printf("O %s mede %.1fm de altura.\n",joao.nome,joao.altura);

	}

}
