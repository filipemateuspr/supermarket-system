package supermarket.core;

import java.util.ArrayList;

public class Produto {
	
	private volatile ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	private volatile boolean predefCarregado = false, haProdutos = false, exibiuProdutos = false;
	private volatile String nomeProduto;
	private volatile double precoProduto;
	private volatile int idProduto, quantEstoque;
	
	//Construtores
	public Produto() {}
	public Produto(int idProduto, String nomeProduto, double precoProduto, int quantEstoque) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.quantEstoque = quantEstoque;
	}

	//Getters e setters
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public boolean isPredefCarregado() {
		return predefCarregado;
	}
	public void setPredefCarregado(boolean predefCarregado) {
		this.predefCarregado = predefCarregado;
	}
	public boolean haProdutos() {
		return haProdutos;
	}
	public void setHaProdutos(boolean haProdutos) {
		this.haProdutos = haProdutos;
	}
	public boolean exibiuProdutos() {
		return exibiuProdutos;
	}
	public void setExibiuProdutos(boolean exibiuProdutos) {
		this.exibiuProdutos = exibiuProdutos;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantEstoque() {
		return quantEstoque;
	}
	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}
	
	//Funções da classes
	public void adicionarProduto(Produto prod) {
		listaProdutos.add(prod);
	}
	
	public boolean verificarEstoque(Produto prod) {
		if(prod.getQuantEstoque()!=0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String retornarNomeProduto(int idProduto) {
		String nomeProduto="";
		for (Produto produto : listaProdutos) {
			if(produto.getIdProduto()==idProduto) {
				nomeProduto=produto.getNomeProduto();
			}
		}
		return nomeProduto;
	}
	
	public double retornarPrecoProduto(int idProduto) {
		double precoProduto=0;
		for (Produto produto : listaProdutos) {
			if(produto.getIdProduto()==idProduto) {
				precoProduto=produto.getPrecoProduto();
			}
		}
		return precoProduto;
	}
	
	public int retornarQuantEstoque(int idProduto) {
		int quantEstoque=0;
		for (Produto produto : listaProdutos) {
			if(produto.getIdProduto()==idProduto) {
				quantEstoque=produto.getQuantEstoque();
			}
		}
		return quantEstoque;
	}
	
	public void atualizarEstoque(int idProduto, String nomeProduto, double precoProduto, int quantEstoque) {
		listaProdutos.set(idProduto-1, new Produto(idProduto, nomeProduto, precoProduto, quantEstoque-1));
	}
}
