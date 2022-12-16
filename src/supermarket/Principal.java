package supermarket;

import java.util.Scanner;

public class Principal {
	
	public static Scanner leia = new Scanner(System.in);
	public static Outros outros = new Outros();
	public static Venda venda = new Venda();
	public static Pagamento pagamento = new Pagamento();
	public static Produto produto1 = new Produto("Arroz",6.50,5);
	public static Produto produto2 = new Produto("Feijão",7.50,5);
	public static Produto produto3 = new Produto("Macarrão",5.60,5);
	public static Produto produto4 = new Produto("Leite",4.20,5);
	public static Produto produto5 = new Produto("Batata",5.30,5);
	public static String aux, versao="1.0.6";
	public static int selecao=0, quantItens=0;
	
	public static void main(String[] args) {
		System.out.print("---> Executando código de supermercado... (Por: Filipe Mateus (15/12/22))");
		outros.aguarde(3000);
		menuInicial();
	}
	public static void menuInicial() {
		outros.limpe();
		System.out.print("=========|MENU PRINCIPAL (v"+versao+")|=========="+
                		 "\n 1 -> Adicionar itens a venda"+
                		 "\n 2 -> Visualizar venda"+
                		 "\n 3 -> Selecionar método de pagamento"+
                		 "\n 4 -> Concluír venda"+
                		 "\n============================================"+
				 		 "\nDigite o número referente a opção desejada: ");
		selecao = leia.nextInt();

		switch(selecao) {
		case 1:
			outros.limpe();
			adicionarItensVendaMenu();
			break;
		case 2:
			outros.limpe();
			visualizarVendaMenu();
			break;
		case 3:
			outros.limpe();
			selecionarMetodoPagamentoMenu();
			break;
		case 4:
			outros.limpe();
			concluirVendaMenu();
			break;
		default:
			System.out.print("Ocorreu um erro: O número inserido não corresponde a nenhuma opção!"+
                    		 "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
			break;
		}
	}
	public static void adicionarItensVendaMenu() {
		System.out.print("==================|ADICIONAR ITEM A VENDA|==================="+
				         "\n| ID |  PRODUTO  | PREÇO | QUANT. EM ESTOQUE |  DISPONÍVEL  |"+
	                     "\n| 1     "+produto1.getNome()+"      R$"+produto1.getPreco()+"          "+produto1.getQuantidadeEstoque()+"                "+produto1.verificarEstoque(produto1)+
	                     "\n| 2     "+produto2.getNome()+"     R$"+produto2.getPreco()+"          "+produto2.getQuantidadeEstoque()+"                "+produto2.verificarEstoque(produto2)+
	                     "\n| 3     "+produto3.getNome()+"   R$"+produto3.getPreco()+"          "+produto3.getQuantidadeEstoque()+"                "+produto3.verificarEstoque(produto3)+
	                     "\n| 4     "+produto4.getNome()+"      R$"+produto4.getPreco()+"          "+produto4.getQuantidadeEstoque()+"                "+produto4.verificarEstoque(produto4)+
	                     "\n| 5     "+produto5.getNome()+"     R$"+produto5.getPreco()+"          "+produto5.getQuantidadeEstoque()+"                "+produto5.verificarEstoque(produto5)+
		                 "\nDigite o número correspondente ao item desejado: ");
		selecao = leia.nextInt();
		if(selecao==1&&produto1.getQuantidadeEstoque()>0) {
			venda.adicionarItemVenda(produto1);
			produto1.setQuantidadeEstoque(produto1.getQuantidadeEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto1.getPreco());
			quantItens++;
			menuInicial();
		}else if(selecao==2&&produto2.getQuantidadeEstoque()>0){
			venda.adicionarItemVenda(produto2);
			produto2.setQuantidadeEstoque(produto2.getQuantidadeEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto2.getPreco());
			quantItens++;
			menuInicial();
		}else if(selecao==3&&produto3.getQuantidadeEstoque()>0) {
			venda.adicionarItemVenda(produto3);
			produto3.setQuantidadeEstoque(produto3.getQuantidadeEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto3.getPreco());
			quantItens++;
			menuInicial();
		}else if(selecao==4&&produto4.getQuantidadeEstoque()>0) {
			venda.adicionarItemVenda(produto4);
			produto4.setQuantidadeEstoque(produto4.getQuantidadeEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto4.getPreco());
			quantItens++;
			menuInicial();
		}else if(selecao==5&&produto5.getQuantidadeEstoque()>0) {
			venda.adicionarItemVenda(produto5);
			produto5.setQuantidadeEstoque(produto5.getQuantidadeEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto5.getPreco());
			quantItens++;
			menuInicial();
		}else {
			System.out.print("Ocorreu um erro: Produto não encontrado ou indisponível!"+
		                     "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	public static void visualizarVendaMenu() {
		if(quantItens!=0) {
			System.out.print("=====|VISUALIZANDO ITENS DA VENDA|=====\n");
			venda.visualizarVenda();
			System.out.print("Quantidade de itens: "+quantItens+
						     "\nValor total: R$"+venda.getVlrTotal()+"\n");
			outros.aguarde(3000);
			System.out.print("(!) Insira [R] para retornar ao menu inicial: ");
			aux = leia.next();
			menuInicial();
		}else {
			System.out.print("Ocorreu um erro: Sua lista de venda está vazia!"+
		                     "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	public static void selecionarMetodoPagamentoMenu() {
		if(quantItens!=0&&pagamento.getTipoPagamento()==0) {
			System.out.print("=====|SELECIONAR MÉTODO DE PAGAMENTO|====="+
		                     "\nMétodos de pagamento disponíveis:"+
					         "\n1 -> Dinheiro | 2 -> Cheque | 3 -> Cartão"+
		                     "\nDigite o número correspondente ao método desejado: ");
			selecao = leia.nextInt();
			pagamento.selecionarTipoPagamento(selecao);
			System.out.print("\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}else {
			System.out.print("Ocorreu um erro: Sua lista de venda está vazia ou você já selecionou um método de pagamento!"+
                             "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	public static void concluirVendaMenu() {
		if(quantItens!=0&&pagamento.getTipoPagamento()!=0) {
			System.out.print("=====|CONCLUÍR VENDA|====="+
		                     "\nDetalhes:"+
					         "\nItens da venda: "+quantItens);
			venda.concluirVenda(pagamento.getTipoPagamento());
			System.out.print("\n\nAVISO: A execução do código terminou!");
		}else {
			System.out.print("Ocorreu um erro: Sua lista de venda está vazia ou você ainda não selecionou um método de pagamento!"+
                    		 "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
}
