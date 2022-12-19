package supermarket;

import java.util.Scanner;

public class Principal {
	
	public static boolean haProdutos=false, predefCarregado=false;
	public static int idProduto=0, quantItens=0;
	public static String versao="1.2.5";
	public static Scanner leia = new Scanner(System.in);
	public static Pagamento pagamento = new Pagamento();
	public static Produto produto = new Produto();
	public static Venda venda = new Venda();
	public static Outros outros = new Outros();

	public static void main(String[] args) {
		System.out.print("---> Executando código de supermercado... (Por: Filipe Mateus (19/12/22))");
		outros.aguarde(3000);
		menuInicial();
	}
	
	public static void menuInicial() {
		int entrada;
		outros.limpe();
		System.out.print("\n============|GERENTE DE VENDAS (v"+versao+")|============="+
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
			submenuAdicionarItemVenda();
			break;
		case 2:
			submenuVisualizarVenda();
			break;
		case 3:
			submenuSelecionarMetodoPagamento();
			break;
		case 4:
			submenuConcluirVenda();
			break;
		case 5:
			menuGerenteProdutos();
			break;
		default:
			System.out.print("Ocorreu um erro: O número inserido não corresponde a nenhuma opção!"+
                    		 "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
			break;
		}
	}
	
	public static void menuGerenteProdutos() {
		int entrada;
		outros.limpe();
		System.out.print("\n==========|GERENTE DE PRODUTOS (v"+versao+")|============="+
                	     "\n Opções disponíveis:"+
                	     "\n 1 -> Adicionar novo produto"+
                	     "\n 2 -> Visualizar lista de produtos"+
                	     "\n 3 -> Carregar pré-definição de produtos"+
                	     "\n 4 -> Volta ao menu inicial"+
                	     "\n====================================================="+
						 "\n-> Digite o número referente a opção desejada: ");
		entrada=leia.nextInt();
		switch(entrada) {
		case 1:
			submenuAdicionarNovoProduto();
			break;
		case 2:
			submenuVisualizarProdutos();
			break;
		case 3:
			submenuCarregarPredefProdutos();
			break;
		case 4:;
			menuInicial();
			break;
		default:
			System.out.print("Ocorreu um erro: O número inserido não corresponde a nenhuma opção!"+
           		             "\n\n(!) Retornando ao menu de gerenciamento em 3 segundos...");
			outros.aguarde(3000);
			menuGerenteProdutos();
			break;
		}
	}
	
	public static void submenuAdicionarItemVenda() {
		String tecla="R"; int entrada;
		outros.limpe();
		if(haProdutos==true) {
			System.out.print("\n============|ADICIONAR ITEM A VENDA|=================\n");
			produto.visualizarProdutos();
			System.out.print("\nQual produto você deseja adicionar a sua lista de venda? [Insira o ID]: ");
			entrada=leia.nextInt();
			if(entrada-1<produto.getListaProdutos().size()&&produto.retornarQuantEstoque(entrada)>0) {
				venda.adicionarItemVenda(entrada,produto.retornarNomeProduto(entrada),produto.retornarPrecoProduto(entrada));
				produto.atualizarEstoque(entrada,produto.retornarNomeProduto(entrada),produto.retornarPrecoProduto(entrada),produto.retornarQuantEstoque(entrada));
				venda.setVlrTotal(venda.getVlrTotal()+produto.retornarPrecoProduto(entrada));
				System.out.print("Produto \""+produto.retornarNomeProduto(entrada)+"\" adicionado a sua lista de venda!");
				quantItens++;
				System.out.print("\n(!) Digite ["+tecla+"] para retornar ao menu inicial: ");
				tecla=leia.next();
				menuInicial();
			}else {
				System.out.print("Ocorreu um erro: Produto não encontrado ou indisponível!"+
	                             "\n\n(!) Retornando ao menu inicial em 3 segundos...");
				outros.aguarde(3000);
				menuInicial();
			}
		}else {
			System.out.print("Ocorreu um erro: Não há nenhum produto disponível para compra!"+
                    		 "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	
	public static void submenuVisualizarVenda() {
		String tecla="R";
		outros.limpe();
		if(quantItens!=0) {
			System.out.print("\n===========|VISUALIZAR ITENS DA VENDA|===============\n");
			venda.visualizarVenda();
			System.out.print("Quantidade de itens: "+quantItens+
						     "\nValor total: R$"+venda.getVlrTotal()+"\n");
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
	
	public static void submenuSelecionarMetodoPagamento() {
		int entrada;
		outros.limpe();
		if(quantItens!=0&&pagamento.getTipoPagamento()==0) {
			System.out.print("\n==========|SELECIONAR MÉTODO DE PAGAMENTO|==========="+
		                     "\nMétodos de pagamento disponíveis:"+
					         "\n1 -> Dinheiro | 2 -> Cheque | 3 -> Cartão"+
		                     "\nDigite o número correspondente ao método desejado: ");
			entrada=leia.nextInt();
			pagamento.selecionarTipoPagamento(entrada);
			System.out.print("(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}else {
			System.out.print("Ocorreu um erro: Sua lista de venda está vazia ou você já selecionou um método de pagamento!"+
                             "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	
	public static void submenuConcluirVenda() {
		outros.limpe();
		if(quantItens!=0&&pagamento.getTipoPagamento()!=0) {
			System.out.print("\n=================|CONCLUÍR VENDA|===================="+
		                     "\n|===|DETALHES|===|"+
					         "\nNúmero de itens: "+quantItens);
			venda.concluirVenda(pagamento.getTipoPagamento());
			System.out.print("\n\nAVISO: A execução do código terminou!");
		}else {
			System.out.print("Ocorreu um erro: Sua lista de venda está vazia ou você ainda não selecionou um método de pagamento!"+
                    		 "\n\n(!) Retornando ao menu inicial em 3 segundos...");
			outros.aguarde(3000);
			menuInicial();
		}
	}
	
	public static void submenuAdicionarNovoProduto() {
		String entrada, tecla="R";
		outros.limpe();
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
			outros.aguarde(1500);
			System.out.print("\n(!) Digite ["+tecla+"] para retornar ao menu de gerenciamento de produtos: ");
			tecla=leia.next();
			menuGerenteProdutos();
		}else {
			System.out.print("(!) Digite ["+tecla+"] para retornar ao menu de gerenciamento de produtos: ");
			tecla=leia.next();
			menuGerenteProdutos();
		}
	}
	
	public static void submenuVisualizarProdutos() {
		String tecla="R";
		outros.limpe();
		System.out.print("\n===============|VISUALIZAR PRODUTOS|=================\n");
		if(haProdutos==true) {
			produto.visualizarProdutos();
		}else {
			System.out.print("          A lista de produtos está vazia!"+
							 "\nAdicione produtos ao sistema para visualiza-los aqui.");
		}
		System.out.print("\n(!) Digite ["+tecla+"] para retornar ao menu de gerenciamento de produtos: ");
		tecla=leia.next();
		menuGerenteProdutos();
	}
	
	public static void submenuCarregarPredefProdutos() {
		String tecla="R";
		outros.limpe();
		if(predefCarregado==false) {
			System.out.print("\n==========|PRÉ-DEFINIÇÃO DE PRODUTOS|================\n");
			System.out.print("Carregando pré-definição de produtos, por favor aguarde...");
			outros.aguarde(2500);
			
			//Incremento de "idProduto" e instanciação de objetos de "Produto".
			idProduto++;
			Produto preset01 = new Produto(idProduto,"Arroz",6.50,15);
			idProduto++;
			Produto preset02 = new Produto(idProduto,"Feijão",7.50,15);
			idProduto++;
			Produto preset03 = new Produto(idProduto,"Macarrão",5.60,15);
			idProduto++;
			Produto preset04 = new Produto(idProduto,"Leite",4.20,15);
			idProduto++;
			Produto preset05 = new Produto(idProduto,"Batata",5.30,25);
			idProduto++;
			Produto preset06 = new Produto(idProduto,"Banana",4.99,25);
			idProduto++;
			Produto preset07 = new Produto(idProduto,"Suco de Uva",8.99,15);
			idProduto++;
			Produto preset08 = new Produto(idProduto,"Beterraba",4.96,25);
			idProduto++;
			Produto preset09 = new Produto(idProduto,"Peito de Frango",13.99,5);
			idProduto++;
			Produto preset10 = new Produto(idProduto,"Costela Bovina",27.49,5);
			
			//Adição das pré-definições ao ArrayList.
			produto.adicionarProduto(preset01);
			produto.adicionarProduto(preset02);
			produto.adicionarProduto(preset03);
			produto.adicionarProduto(preset04);
			produto.adicionarProduto(preset05);
			produto.adicionarProduto(preset06);
			produto.adicionarProduto(preset07);
			produto.adicionarProduto(preset08);
			produto.adicionarProduto(preset09);
			produto.adicionarProduto(preset10);
			
			//Alteração das variáveis lógicas para evitar duplicações de pré-definições.
			haProdutos=true;
			predefCarregado=true;
			
			//Retorno ao menu inicial.
			System.out.print("\nPré-definição de produtos carregada!");
			outros.aguarde(1500);
			System.out.print("\n(!) Digite ["+tecla+"] para retornar ao menu de gerenciamento de produtos: ");
			tecla=leia.next();
			menuGerenteProdutos();
		}else {
			System.out.print("Ocorreu um erro: Você já carregou a pré-definição de produtos!"+
                    		 "\n\n(!) Retornando ao menu de gerenciamento de produtos em 3 segundos...");
			outros.aguarde(3000);
			menuGerenteProdutos();
		}
	}
}
