package model;

import java.util.ArrayList;
import java.util.List;

public class Contatos {
	
	private List<Contato> lista = new ArrayList<Contato>();
	
	public void addContato(Contato c) {
		this.lista.add(c);
	}
	
	public List<Contato> getContatos(){
		return this.lista;
	}
}
