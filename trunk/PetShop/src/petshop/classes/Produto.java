package petshop.classes;

/**
 * @author arthur
 *
 */
public class Produto extends ItemVenda {

	private double precoCusto;
	private int qtdeEstoque;

	/**
	 * @param codigo
	 * @param nome
	 * @param precoVenda
	 * @param precoCusto
	 * @param qtdeEestoque
	 */
	public Produto(int codigo, String nome, double precoVenda, double precoCusto, int qtdeEstoque) {
		super(codigo, nome, precoVenda);
		this.precoCusto = precoCusto;
		this.qtdeEstoque = qtdeEstoque;
	}

	/**
	 * @return
	 */
	public double getPrecoCusto() {
		return precoCusto;
	}

	/**
	 * @param precoCusto
	 */
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	/**
	 * @return
	 */
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}


	/**
	 * @param qtdeEstoque
	 */
	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

}
