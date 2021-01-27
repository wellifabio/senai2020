package classes;

public class Animais {
	
	//Atributos
	String nome;
	String especie;
	String cor;
	float peso;
	
	//Métodos
	public String retornaFrase() {
		return "O "+nome+" é um(a) "+especie+" da cor "+cor+" e pesa "+peso+" quilos.";
	}
	
	public String retornaFraseComParametro(String sexo) {
		if(sexo.equals("m")) {
			return "O "+nome+" é um "+especie+" da cor "+cor+" e pesa "+peso+" quilos";
		}else {
			return "A "+nome+" é uma "+especie+" da cor "+cor+" e pesa "+peso+" quilos";
		}	
	}
	
	public void escreveFrase(String inmetro) {
		System.out.println("O "+nome+" é um(a) "+especie+" da cor "+cor+" e pesa "+peso+inmetro);
	}
}
