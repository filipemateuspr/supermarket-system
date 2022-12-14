package supermarket;

import java.util.ArrayList;

public class Venda {
	private ArrayList<String> ListaVenda = new ArrayList<String>();
	private double vlrTotal;
	Pagamento pagamento = new Pagamento();
	
	//Métodos construtores (vazio e completo)
	public Venda() {}
	public Venda(ArrayList<String> listaVenda, double vlrTotal) {
		ListaVenda = listaVenda;
		this.vlrTotal = vlrTotal;
	}	
	
	//Getters e Setters
	public ArrayList<String> getListaVenda() {
		return ListaVenda;
	}
	public void setListaVenda(ArrayList<String> listaVenda) {
		ListaVenda = listaVenda;
	}
	public double getVlrTotal() {
		return vlrTotal;
	}
	public void setVlrTotal(double vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	
	//Métodos de "Venda"
	public void adicionarItemVenda(String prod) {
		System.err.print("[Debug|MétodoChamado:adicionarItemVenda]\n");
		ListaVenda.add(prod);
	}
	public void visualizarVenda() {
		System.err.print("\n[Debug|MétodoChamado:adicionarItemVenda]\n");
		System.out.print("Itens à venda: "+ListaVenda);
	}
	public void concluirVenda(int tpag) {
		System.err.print("\n[Debug|MétodoChamado:concluirVenda]");
		System.out.print("\nValor total: "+vlrTotal);
		pagamento.realizarPagamento(tpag);
	}
}