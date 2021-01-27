package model;

public class Cachorro extends Animal {
	
	private int motos = 0;

	public int getMotos() {
		return motos;
	}

	public void setMotos(int motos) {
		this.motos = motos;
	}
	
	public void assustarMotoqueiros() {
		this.motos++;
	}
	
}
