package petshop.classes;

public class Produto extends ItemVenda {
	
	private double precoCusto;

	public Produto(int codigo, String nome, double precoVenda, double precoCusto) {
		super(codigo, nome, precoVenda);
		this.precoCusto = precoCusto;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	
}
