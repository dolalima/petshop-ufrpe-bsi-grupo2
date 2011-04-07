package petshop.classes;

import java.util.Date;

public class Servico extends ItemVenda {
	
	private Date data;
	

	public Servico(int codigo, String nome, double precoVenda, Date data) {
		super(codigo, nome, precoVenda);
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
