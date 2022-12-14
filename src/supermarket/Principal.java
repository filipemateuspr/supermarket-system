package supermarket;

import java.util.Scanner;

public class Principal {
	
	public static Scanner leia = new Scanner(System.in);
	public static Venda venda = new Venda();
	public static Pagamento pagamento = new Pagamento();
	public static Produto produto1 = new Produto("Arroz",6.50,10);
	public static Produto produto2 = new Produto("Feijão",7.50,10);
	public static Produto produto3 = new Produto("Macarrão",5.60,10);
	public static Produto produto4 = new Produto("Leite",4.20,10);
	public static Produto produto5 = new Produto("Batata",5.30,10);
	public static int selecao=0, quantItens=0;
	
	public static void main(String[] args) {
		System.out.print("\n---> Executando código de supermercado... (Por: Filipe Mateus)");	
		System.out.print("\n==============|MENU PRINCIPAL|=============="+
		                 "\n 1 -> Adicionar itens a venda"+
				         "\n 2 -> Visualizar venda"+
		                 "\n 3 -> Selecionar método de pagamento"+
				         "\n 4 -> Concluír venda"+
		                 "\n============================================"+
						 "\nDigite o número referente a opção desejada: ");
		selecao = leia.nextInt();
		
		switch(selecao) {
		case 1:
			selecao=0;
			System.out.print("\n==================|ADICIONAR ITENS A VENDA|=================="+
					         "\n|  PRODUTO  | PREÇO | QUANTIDADE DISPONÍVEL |  DISPONÍVEL  |"+
		                     "\n 1 "+produto1.getNome()+"      R$"+produto1.getPreco()+"             "+produto1.getQuantidadeEstoque()+"                "+produto1.verificarEstoque(produto1.getQuantidadeEstoque())+
		                     "\n 2 "+produto2.getNome()+"     R$"+produto2.getPreco()+"             "+produto2.getQuantidadeEstoque()+"                "+produto2.verificarEstoque(produto2.getQuantidadeEstoque())+
		                     "\n 3 "+produto3.getNome()+"   R$"+produto3.getPreco()+"             "+produto3.getQuantidadeEstoque()+"                "+produto3.verificarEstoque(produto3.getQuantidadeEstoque())+
		                     "\n 4 "+produto4.getNome()+"      R$"+produto4.getPreco()+"             "+produto4.getQuantidadeEstoque()+"                "+produto4.verificarEstoque(produto4.getQuantidadeEstoque())+
		                     "\n 5 "+produto5.getNome()+"     R$"+produto5.getPreco()+"             "+produto5.getQuantidadeEstoque()+"                "+produto5.verificarEstoque(produto5.getQuantidadeEstoque())+
			                 "\nDigite o número correspondente ao item desejado: ");
			selecao = leia.nextInt();
			if(selecao==1&&produto1.getQuantidadeEstoque()>0) {
				venda.adicionarItemVenda(produto1.getNome());
				produto1.setQuantidadeEstoque(produto1.getQuantidadeEstoque()-1);
				venda.setVlrTotal(venda.getVlrTotal()+produto1.getPreco());
				quantItens++;
				main(args);
			}else if(selecao==2&&produto2.getQuantidadeEstoque()>0){
				venda.adicionarItemVenda(produto2.getNome());
				produto2.setQuantidadeEstoque(produto2.getQuantidadeEstoque()-1);
				venda.setVlrTotal(venda.getVlrTotal()+produto2.getPreco());
				quantItens++;
				main(args);
			}else if(selecao==3&&produto3.getQuantidadeEstoque()>0) {
				venda.adicionarItemVenda(produto3.getNome());
				produto3.setQuantidadeEstoque(produto3.getQuantidadeEstoque()-1);
				venda.setVlrTotal(venda.getVlrTotal()+produto3.getPreco());
				quantItens++;
				main(args);
			}else if(selecao==4&&produto4.getQuantidadeEstoque()>0) {
				venda.adicionarItemVenda(produto4.getNome());
				produto4.setQuantidadeEstoque(produto4.getQuantidadeEstoque()-1);
				venda.setVlrTotal(venda.getVlrTotal()+produto4.getPreco());
				quantItens++;
				main(args);
			}else if(selecao==5&&produto5.getQuantidadeEstoque()>0) {
				venda.adicionarItemVenda(produto5.getNome());
				produto5.setQuantidadeEstoque(produto5.getQuantidadeEstoque()-1);
				venda.setVlrTotal(venda.getVlrTotal()+produto5.getPreco());
				quantItens++;
				main(args);
			}else {
				System.err.print("Produto não encontrado ou indisponível!\n");
				aguarde(2000);
				main(args);
			}
			break;
		case 2:
			if(quantItens!=0) {
				System.out.print("\n=====|VISUALIZANDO ITENS DA VENDA|=====");
				venda.visualizarVenda();
				System.out.print("\nQuantidade de itens: "+quantItens+
						         "\nValor total: R$"+venda.getVlrTotal()+"\n");
				aguarde(2500);
				main(args);
			}else {
				System.err.print("Sua lista de venda está vazia!\n");
				main(args);
			}
			break;
		case 3:
			selecao=0;
			if(quantItens!=0&&pagamento.getTipoPagamento()==0) {
				System.out.print("\n=====|SELECIONAR MÉTODO DE PAGAMENTO|====="+
			                     "\nMétodos de pagamento disponíveis:"+
						         "\n1 -> Dinheiro | 2 -> Cheque | 3 -> Cartão"+
			                     "\nDigite o número correspondente ao método desejado: ");
				selecao = leia.nextInt();
				pagamento.selecionarTipoPagamento(selecao);
				aguarde(2500);
				main(args);
			}else {
				System.err.print("Sua lista de venda está vazia ou você já selecionou um método de pagamento!\n");
				main(args);
			}
			break;
		case 4:
			if(quantItens!=0&&pagamento.getTipoPagamento()!=0) {
				System.out.print("\n=====|CONCLUÍR VENDA|====="+
			                     "\nDetalhes:\nItens da venda: "+quantItens);
				venda.concluirVenda(pagamento.getTipoPagamento());
				System.out.print("\n\nAVISO: A execução do código terminou!");
			}else {
				System.err.print("Sua lista de venda está vazia ou você ainda não selecionou um método de pagamento!\n");
				main(args);
			}
			break;
		default:
			System.err.print("\nOpção inválida! Execução terminada.");
			break;
		}
	}
	
	//Método especial
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
