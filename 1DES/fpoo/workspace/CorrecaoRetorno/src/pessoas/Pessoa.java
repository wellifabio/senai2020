package pessoas;

public class Pessoa {
	
	String nome;
	int idade;
	float altura;
	float peso;
	
	public String retornaDados(String sexo){
		if(sexo.equals("m")) {
			return "O "+nome+" tem "+idade+" anos, mede "+altura+" e pesa "+peso+" quilos.";
		}else {
			return "A "+nome+" tem "+idade+" anos, mede "+altura+" e pesa "+peso+" quilos.";
		}
	}
}
