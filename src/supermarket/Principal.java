package supermarket;

import java.util.Scanner;

public class Principal {
	
	public static Scanner leia = new Scanner(System.in);
	public static Outros outros = new Outros();
	public static Venda venda = new Venda();
	public static Pagamento pagamento = new Pagamento();
	public static Produto produto = new Produto(0, null, 0, 0);
	public static Produto produto1 = new Produto(1,"Arroz",6.50,5);
	public static Produto produto2 = new Produto(2,"Feijão",7.50,5);
	public static Produto produto3 = new Produto(3,"Macarrão",5.60,5);
	public static Produto produto4 = new Produto(4,"Leite",4.20,5);
	public static Produto produto5 = new Produto(5,"Batata",5.30,5);
	public static String versao="1.2.1";
	public static int idProduto=0, quantItens=0;
	public static boolean haProdutos=false;
	
	public static void main(String[] args) {
		System.out.print("---> Executando código de supermercado... (Por: Filipe Mateus (18/12/22))");
		outros.aguarde(3000);
		menuInicial();
	}
	public static void menuInicial() {
		int entrada;
		outros.limpe();
		System.out.print("\n===============|MENU INICIAL (v"+versao+")|==============="+
		                 "\n Opções disponíveis:"+
                		 "\n 1 -> Adicionar itens a venda"+
                		 "\n 2 -> Visualizar venda"+
                		 "\n 3 -> Selecionar método de pagamento"+
                		 "\n 4 -> Concluír venda"+
                		 "\n 5 -> Gerenciar produtos disponíveis"+
                		 "\n====================================================="+
				 		 "\n-> Digite o número referente a opção desejada: ");
		entrada=leia.nextInt();

		switch(entrada) {
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
		case 5:
			outros.limpe();
			gerenteProdutosMenu();
			break;
		default:
			System.out.print("Ocorreu um erro: O número inserido não corresponde a nenhuma opção!"+
                    		 "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
			break;
		}
	}
	public static void gerenteProdutosMenu() {
		int entrada;
		System.out.print("\n==========|GERENTE DE PRODUTOS (v"+versao+")|============="+
                	     "\n Opções disponíveis:"+
                	     "\n 1 -> Adicionar novo produto"+
                	     "\n 2 -> Visualizar lista de produtos"+
                	     "\n 3 -> Volta ao menu inicial"+
                	     "\n====================================================="+
						 "\n-> Digite o número referente a opção desejada: ");
		entrada=leia.nextInt();
		
		switch(entrada) {
		case 1:
			outros.limpe();
			adicionarNovoProduto();
			break;
		case 2:
			outros.limpe();
			visualizarProdutos();
			break;
		case 3:
			outros.limpe();
			menuInicial();
			break;
		default:
			System.out.print("Ocorreu um erro: O número inserido não corresponde a nenhuma opção!"+
           		             "\n\n(!) Retornando ao menu de gerenciamento em 3 segundos...");
			outros.aguarde(3000);
			gerenteProdutosMenu();
			break;
		}
	}
	public static void adicionarItensVendaMenu() {
		int entrada;
		System.out.print("==================|ADICIONAR ITEM A VENDA|==================="+
				         "\n| ID |  PRODUTO  | PREÇO | QUANT. EM ESTOQUE |  DISPONÍVEL  |"+
	                     "\n| 1     "+produto1.getNomeProduto()+"      R$"+produto1.getPrecoProduto()+"          "+produto1.getQuantEstoque()+"                "+produto1.verificarEstoque(produto1)+
	                     "\n| 2     "+produto2.getNomeProduto()+"     R$"+produto2.getPrecoProduto()+"          "+produto2.getQuantEstoque()+"                "+produto2.verificarEstoque(produto2)+
	                     "\n| 3     "+produto3.getNomeProduto()+"   R$"+produto3.getPrecoProduto()+"          "+produto3.getQuantEstoque()+"                "+produto3.verificarEstoque(produto3)+
	                     "\n| 4     "+produto4.getNomeProduto()+"      R$"+produto4.getPrecoProduto()+"          "+produto4.getQuantEstoque()+"                "+produto4.verificarEstoque(produto4)+
	                     "\n| 5     "+produto5.getNomeProduto()+"     R$"+produto5.getPrecoProduto()+"          "+produto5.getQuantEstoque()+"                "+produto5.verificarEstoque(produto5)+
		                 "\nDigite o número correspondente ao item desejado: ");
		entrada=leia.nextInt();
		if(entrada==1&&produto1.getQuantEstoque()>0) {
			venda.adicionarItemVenda(produto1);
			produto1.setQuantEstoque(produto1.getQuantEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto1.getPrecoProduto());
			quantItens++;
			menuInicial();
		}else if(entrada==2&&produto2.getQuantEstoque()>0){
			venda.adicionarItemVenda(produto2);
			produto2.setQuantEstoque(produto2.getQuantEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto2.getPrecoProduto());
			quantItens++;
			menuInicial();
		}else if(entrada==3&&produto3.getQuantEstoque()>0) {
			venda.adicionarItemVenda(produto3);
			produto3.setQuantEstoque(produto3.getQuantEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto3.getPrecoProduto());
			quantItens++;
			menuInicial();
		}else if(entrada==4&&produto4.getQuantEstoque()>0) {
			venda.adicionarItemVenda(produto4);
			produto4.setQuantEstoque(produto4.getQuantEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto4.getPrecoProduto());
			quantItens++;
			menuInicial();
		}else if(entrada==5&&produto5.getQuantEstoque()>0) {
			venda.adicionarItemVenda(produto5);
			produto5.setQuantEstoque(produto5.getQuantEstoque()-1);
			venda.setVlrTotal(venda.getVlrTotal()+produto5.getPrecoProduto());
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
		String tecla="R";
		if(quantItens!=0) {
			System.out.print("=====|VISUALIZANDO ITENS DA VENDA|=====\n");
			venda.visualizarVenda();
			System.out.print("Quantidade de itens: "+quantItens+
						     "\nValor total: R$"+venda.getVlrTotal()+"\n");
			outros.aguarde(3000);
			System.out.print("(!) Digite ["+tecla+"] para retornar ao menu inicial: ");
			tecla = leia.next();
			menuInicial();
		}else {
			System.out.print("Ocorreu um erro: Sua lista de venda está vazia!"+
		                     "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	public static void selecionarMetodoPagamentoMenu() {
		int entrada;
		if(quantItens!=0&&pagamento.getTipoPagamento()==0) {
			System.out.print("=====|SELECIONAR MÉTODO DE PAGAMENTO|====="+
		                     "\nMétodos de pagamento disponíveis:"+
					         "\n1 -> Dinheiro | 2 -> Cheque | 3 -> Cartão"+
		                     "\nDigite o número correspondente ao método desejado: ");
			entrada=leia.nextInt();
			pagamento.selecionarTipoPagamento(entrada);
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
	public static void adicionarNovoProduto() {
		String entrada;
		System.out.print("\n===============|ADICIONAR PRODUTOS|==================\n");
		if(haProdutos==true) {
			produto.visualizarProdutos();
			System.out.print("\nVocê deseja adicionar um novo item à lista de produtos? [Sim/Não]: ");
			entrada=leia.next();
		}else {
			System.out.print("          A lista de produtos está vazia!");
			System.out.print("\nVocê deseja adicionar itens à lista de produtos? [Sim/Não]: ");
			entrada=leia.next();
		}
		if("Sim".equals(entrada)||"SIM".equals(entrada)||"S".equals(entrada)||"s".equals(entrada)) {
			
			//Instanciação local de "Produto" e também criação local de variáveis de auxílio.
			Produto novoProduto = new Produto();
			int quantEstoque;
			String nomeProduto;
			double precoProduto;
			
			//Solicitação das informações de um novo produto ao usuário. 
			System.out.print("Por favor, informe o nome do novo produto: ");
			@SuppressWarnings("resource")
			Scanner leia = new Scanner(System.in); //Correção para o erro do Scanner ao ler novas entradas.
			nomeProduto=leia.nextLine();
			System.out.print("Por favor, informe o preço de venda deste produto: R$");
			precoProduto=leia.nextDouble();
			System.out.print("Por favor, informe a quantidade inicial disponível em estoque: ");
			quantEstoque=leia.nextInt();
			
			//Incremento do "idProduto", adições de valores e criação de um novo produto.
			idProduto++;
			novoProduto.setIdProduto(idProduto);
			novoProduto.setNomeProduto(nomeProduto);
			novoProduto.setPrecoProduto(precoProduto);
			novoProduto.setQuantEstoque(quantEstoque);
			produto.adicionarProduto(novoProduto);
			haProdutos=true;
			
			//Exibição dos detalhes do novo produto que foi adicionado ao sistema.
			System.out.print("Novo produto adicionado ao sistema!"+
			                 "\n========|DETALHES|========="+
			                 "\nNúmero de identificação: "+idProduto+ 
			                 "\nNome do produto: "+nomeProduto+
			                 "\nPreço do produto: R$"+precoProduto+
			                 "\nQuantidade em estoque: "+quantEstoque);
			System.out.print("\n\n(!) Retornando ao menu de gerenciamento de produtos em 3 segundos...");
			outros.aguarde(3000);
			gerenteProdutosMenu();
		}else {
			System.out.print("\n\n(!) Retornando ao menu de gerenciamento de produtos em 3 segundos...");
			outros.aguarde(3000);
			gerenteProdutosMenu();
		}
	}
	public static void visualizarProdutos() {
		System.out.print("\n===============|VISUALIZAR PRODUTOS|=================\n");
		if(haProdutos==true) {
			produto.visualizarProdutos();
		}else {
			System.out.print("          A lista de produtos está vazia!"+
							 "\nAdicione produtos ao sistema para visualiza-los aqui.");
		}
		System.out.print("\n\n(!) Retornando ao menu de gerenciamento de produtos em 3 segundos...");
		outros.aguarde(3000);
		gerenteProdutosMenu();
	}
}
