package controllers;

import java.util.ArrayList;

import models.Compra;
import models.dao.CompraDAO;

public class ProcessaCompra {

	public static CompraDAO cd = new CompraDAO();
	private static ArrayList<Compra> compras = cd.open();

	public static ArrayList<Compra> getCompras() {
		return compras;
	}

	public static void setCompras(ArrayList<Compra> compras) {
		ProcessaCompra.compras = compras;
		cd.save(compras);
	}

	// Retorna o número da compra adicionando 1 ao ultimo número da lista
	public static int getAutoNumero() {
		if (ProcessaCompra.compras.isEmpty())
			return 1;
		else
			return ProcessaCompra.compras.get(ProcessaCompra.compras.size() - 1).getNum() + 1;
	}

	public static int getTotalItens() {
		int total = 0;
		for (Compra c : compras) {
			total += c.getQuantidade();
		}
		return total;
	}

	public static int getTotalItens(String data) {
		int total = 0;
		for (Compra c : compras) {
			if (data.contentEquals(c.getData())) {
				total += c.getQuantidade();
			}
		}
		return total;
	}

	public static double getTotalDinheiro() {
		double total = 0;
		for (Compra c : compras) {
			total += c.getSubtotal();
		}
		return total;
	}

	public static double getTotalDinheiro(String data) {
		double total = 0;
		for (Compra c : compras) {
			if (data.contentEquals(c.getData())) {
				total += c.getSubtotal();
			}
		}
		return total;
	}
}
