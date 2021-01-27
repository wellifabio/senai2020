package views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controllers.ProcessaTudo;
import models.Compra;

public class TelaCompra {

	private Scanner read = new Scanner(System.in);
	private int indice;

	public Compra cadastro() {
		System.out.println("Digite o id do produto:");
		indice = ProcessaTudo.getIndiceProduto(read.nextInt());
		if (indice < ProcessaTudo.getProdutos().size()) {
			Compra compra = new Compra();
			compra.setId(ProcessaTudo.getCompras().size() + 1);
			compra.setData(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			compra.setHora(new SimpleDateFormat("hh:mm").format(new Date()));
			ProcessaTudo.getProdutos().get(indice).setComprado();
			compra.setProduto(ProcessaTudo.getProdutos().get(indice));
			return compra;
		} else {
			System.out.println("Id não encontrado");
			return null;
		}
	}

	public void consulta() {
		System.out.println("Id\tData\tHora\tProduto\tPreco");
		indice = 0;
		for (Compra c : ProcessaTudo.getCompras()) {
			System.out.print(c.getId() + "\t");
			System.out.print(c.getData() + "\t");
			System.out.print(c.getHora() + "\t");
			System.out.print(c.getProduto().getNome() + "\t");
			System.out.print(c.getProduto().getPreco() + "\n");
			indice++;
		}
	}
}
