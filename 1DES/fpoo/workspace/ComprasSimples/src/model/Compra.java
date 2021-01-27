package model;

public class Compra {
	
	private String data;
	private Produto produto;
	private Servico servico;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
}
