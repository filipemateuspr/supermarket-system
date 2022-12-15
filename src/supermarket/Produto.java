package supermarket;

public class Produto {
	private String nome;
	private double preco;
	private int quantidadeEstoque;
	
	//Método construtor completo
	public Produto(String nome, double preco, int quantidadeEstoque) {
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
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	//Métodos da classe
	public boolean verificarEstoque(Produto prod) {
		if(prod.getQuantidadeEstoque() != 0) {
			return true;
		} else {
			return false;
		}
	}
}
