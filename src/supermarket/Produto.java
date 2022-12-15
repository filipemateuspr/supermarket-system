package supermarket;

public class Produto {
	private String nome;
	private Double preco;
	private Integer quantidadeEstoque;
	
	//Método construtor completo
	public Produto(String nome, Double preco, Integer quantidadeEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	//Métodos da classe
	public boolean verificarEstoque(int prod) {
		if(prod != 0) {
			return true;
		} else {
			return false;
		}
	}
}
