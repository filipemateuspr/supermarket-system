package supermarket;

import java.util.Scanner;

public class Temp {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Venda venda = new Venda();
		Produto produto = new Produto(null, 0, 0);
		Produto produto2 = new Produto(null, 0, 0);
		Pagamento pagamento = new Pagamento();
		int selected;
		System.out.print("DebugLog: ");
		//Adição de produtos (teste)
		produto.setNome("Arroz");
		produto.setPreco(6.50);
		produto.setQuantidadeEstoque(1);
		produto2.setNome("Macarrão");
		produto2.setPreco(7.60);
		produto2.setQuantidadeEstoque(5);
		
		
		
		venda.adicionarItemVenda(produto.getNome());
		venda.adicionarItemVenda(produto2.getNome());
	
		System.err.print("\nResultados de \"venda.adicionarItemVenda(produto.getNome());\"\n   -> para exibição \"venda.getListavenda()\"");
		System.out.println("\nExibição de valores: "+venda.getListaVenda());
		
		produto.verificarEstoque(produto.getQuantidadeEstoque());
		
		System.err.print("\nResultados de \"produto.verificarEstoque(produto.getQuantidadeEstoque())\"\n   -> para exibição \"produto.verificarEstoque(produto.getQuantidadeEstoque())\"");
		System.out.print("\nExibição dos valores: "+ produto.verificarEstoque(produto.getQuantidadeEstoque()));
		
		System.out.print("\n\n[selecionarTipoPagamento] Como irá pagar por isso? ");
		selected = leia.nextInt();
		pagamento.selecionarTipoPagamento(selected);
		
		
		
		System.out.print("\nTestes finalizados!!!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		System.out.print("Running supermarket code...\n");
		System.out.print("Opções Disponíveis:"+
		                 "\nAdicionarItemVenda (1): "+
				         "\nVisualizarVenda (2): "+
		                 "\nConcluírVenda (3): ");
		selected = leia.nextInt();
		
		switch(selected) {
		case 1:
			System.out.print("\nO que irá ");
		case 2:
			
		case 3:
		}*/
	}
	public static void aguarde(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
}