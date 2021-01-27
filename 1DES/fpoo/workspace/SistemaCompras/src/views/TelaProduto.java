package views;

import java.util.Scanner;

import controllers.ProcessaTudo;
import models.Produto;

public class TelaProduto {

	private Scanner read = new Scanner(System.in);
	private int indice;
	
	public Produto cadastro(){
		System.out.println("Digite os dados abaixo:");
		System.out.println("Id Nome Descrição Preço Quantidade");
		Produto produto = new Produto();
		produto.setId(read.nextInt());
		produto.setNome(read.next());
		produto.setDescricao(read.next());
		produto.setPreco(read.nextDouble());
		produto.setQuantidade(read.nextInt());
		return produto;
	}
	
	public void consulta() {
		System.out.println("Id\tNome\tDescrição\tPreço\tQuantidade");
		for(Produto p: ProcessaTudo.getProdutos()) {
			System.out.print(p.getId()+"\t");
			System.out.print(p.getNome()+"\t");
			System.out.print(p.getDescricao()+"\t");
			System.out.print(p.getPreco()+"\t");
			System.out.print(p.getQuantidade()+"\n");
		}
	}
	
	public boolean alteracao() {
		consulta();
		System.out.println("Digite o id do produto a ser alterado:");
		indice = ProcessaTudo.getIndiceProduto(read.nextInt());
		if(indice < ProcessaTudo.getProdutos().size()) {
			Produto produto = cadastro();
			ProcessaTudo.getProdutos().remove(indice);
			ProcessaTudo.getProdutos().add(indice,produto);
			return true;
		} else {
			System.out.println("Id não encontrado");
			return false;
		}
	}
	
	public boolean exclusao() {
		consulta();
		System.out.println("Digite o id do produto a ser excluído:");
		indice = ProcessaTudo.getIndiceProduto(read.nextInt());
		if(indice < ProcessaTudo.getProdutos().size()) {
			ProcessaTudo.getProdutos().remove(indice);
			return true;
		} else {
			System.out.println("Id não encontrado");
			return false;
		}
	}
}
