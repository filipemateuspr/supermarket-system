package supermarket;

public class Pagamento {
	private int tipoPagamento;

	//Métodos construtor (vazio e completo)
	public Pagamento() {}
	public Pagamento(int tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	//Getters e Setters
	public int getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(int tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	//Métodos da classe
	public void selecionarTipoPagamento(int tpag) {
		if(tpag == 1) {
			System.out.print("(!) Pagamento em Dinheiro selecionado.\n");
			tipoPagamento=1;
		}else if(tpag == 2) {
			System.out.print("(!) Pagamento com Cheque selecionado.\n");
			tipoPagamento=2;
		}else if(tpag == 3) {
			System.out.print("(!) Pagamento com Cartão selecionado.\n");
			tipoPagamento=3;
		}else {
			System.out.print("Ocorreu um erro: Este número não corresponde a nenhum tipo de pagamento!\n");
		}
	}
	public void realizarPagamento(int tipoPagamento) {
		String metodoPagamento;
		switch(tipoPagamento) {
		case 1:
			metodoPagamento="Dinheiro";
		break;
		case 2:
			metodoPagamento="Cheque";
		break;
		case 3:
			metodoPagamento="Cartão";
		break;
		default:
			metodoPagamento="Não definido";
		break;
		}
		System.out.print("\nO pagamento foi realizado usando "+metodoPagamento+".");
	}
}
