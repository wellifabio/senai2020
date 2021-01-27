package model;

public class Gato extends Animal {
	
	private int vidas = 7;

	//GETs && SETs
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	//Método a mais além dos GETs and SETs
	public void perderVida() {
		if(this.vidas > 0) {
			this.vidas--;
		} else {
			this.vivo = false;
		}
	}
	
	public void perderVidas(int nVidas) {
		this.vidas -= nVidas;
		if(this.vidas > 0) {
			this.vivo = true;
		} else {
			this.vivo = false;
		}
	}
}
