package controllers;

import java.util.ArrayList;

import models.Compra;
import models.Produto;

public class ProcessaTudo {

	private static ArrayList<Compra> compras = new ArrayList<>();
	private static ArrayList<Produto> produtos = new ArrayList<>();
	
	//GETs && SETs
	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public static void setProdutos(ArrayList<Produto> produtos) {
		ProcessaTudo.produtos = produtos;
	}
	
	public static ArrayList<Compra> getCompras() {
		return compras;
	}
	public static void setCompras(ArrayList<Compra> compras) {
		ProcessaTudo.compras = compras;
	}
	
	public static int getIndiceProduto(int id) {
		int indice = 0;
		for(Produto p: ProcessaTudo.getProdutos()) {
			if(id == p.getId()) {
				break;
			}
			indice++;
		}
		return indice;
	}
	
	public static int getIndiceCompras(int id) {
		int indice = 0;
		for(Compra c: ProcessaTudo.getCompras()) {
			if(id == c.getId()) {
				break;
			}
			indice++;
		}
		return indice;
	}
}
