package petshop.classes;

public abstract class ItemVenda {
	
	private int codigo;
	private String nome;
	private double precoVenda;
	
	
	public ItemVenda(int codigo, String nome, double precoVenda) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoVenda = precoVenda;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	
}
