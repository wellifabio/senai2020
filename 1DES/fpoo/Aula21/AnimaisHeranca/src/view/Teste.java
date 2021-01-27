package view;

import model.Cachorro;
import model.Gato;

public class Teste {

	static Cachorro dog = new Cachorro();
	static Gato cat = new Gato(); 
	
	public static void main(String[] args) {
		
		cat.setNome("Mimi");
		cat.perderVida();
		cat.perderVida(5);
		
		dog.setNome("Totó");
		dog.assustarMotoqueiros();
		dog.assustarMotoqueiros();
		dog.assustarMotoqueiros();
		
		System.out.println("O gato "+cat.getNome()+" tem apenas "+cat.getVidas()+" vidas");
		System.out.println("O cachorro "+dog.getNome()+" assustou "+dog.getMotos()+" motoqueiros");
		if(cat.isVivo()) {
			System.out.println("O gato está vivo");
		}else {
			System.out.println("O gato está morto");
		}
	}

}
