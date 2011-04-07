package petshop.classes;

public class CarrinhoProdutos extends CarrinhoDeCompras {
	
	private int qtde;
	
	public CarrinhoProdutos(ItemVenda item, int qtde) {
		super(item);
		this.qtde = qtde;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

}
