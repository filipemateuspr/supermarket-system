package supermarket;

import java.util.ArrayList;

public class Venda {
	
	private ArrayList<Produto> listaVenda = new ArrayList<>();
	private double vlrTotal;
	private Pagamento pagamento = new Pagamento();
	
	//Métodos construtores
	public Venda() {}
	public Venda(ArrayList<Produto> listaVenda, double vlrTotal) {
		this.listaVenda = listaVenda;
		this.vlrTotal = vlrTotal;
	}	
	
	//Getters e Setters
	public ArrayList<Produto> getListaVenda() {
		return listaVenda;
	}
	public void setListaVenda(ArrayList<Produto> listaVenda) {
		this.listaVenda = listaVenda;
	}
	public double getVlrTotal() {
		return vlrTotal;
	}
	public void setVlrTotal(double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	
	//Métodos da classe
	public void adicionarItemVenda(int idProduto, String nomeProduto, double precoProduto) {
		Produto prod = new Produto();
		prod.setIdProduto(idProduto);
		prod.setNomeProduto(nomeProduto);
		prod.setPrecoProduto(precoProduto);
		listaVenda.add(prod);
	}
	public void visualizarVenda() {
		int idProduto=0;
		for (Produto produto : listaVenda) {
			System.out.println("[ID:"+(idProduto+1)+"] "+produto.getNomeProduto()+" (R$"+produto.getPrecoProduto()+")");
			idProduto++;
		}
	}
	public void concluirVenda(int tpag) {
		System.out.print("\nValor total: R$"+vlrTotal);
		pagamento.realizarPagamento(tpag);
	}
	
	/*---Métodos não usados (serão removidos)---
	public void adicionarItemVenda(Produto prod) {
		listaVenda.add(prod);
	}
	public void visualizarVenda() {
		int aux = 0;
		for (Produto produto : listaVenda) {
			System.out.println("[ID:"+(aux+1)+"] "+produto.getNomeProduto()+" (R$"+ produto.getPrecoProduto()+")");
			aux++;
		}
	}*/
}
