package petshop.classes;

import java.util.Date;

public class Vendas {
	
	public enum Pagamento {DINHEIRO, CHEQUE, CARTAO};
	
	private Pagamento tipoPagamento;
	private boolean parcelado;
	private Date data;
	private Cliente cliente;
	private CarrinhoDeCompras[] carrinho;
	
		
	public Vendas(Pagamento tipoPagamento, boolean parcelado, Date data,
			Cliente cliente, CarrinhoDeCompras[] carrinho) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.parcelado = parcelado;
		this.data = data;
		this.cliente = cliente;
		this.carrinho = carrinho;
	}
	
	
	public Pagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(Pagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public boolean isParcelado() {
		return parcelado;
	}
	public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public CarrinhoDeCompras[] getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(CarrinhoDeCompras[] carrinho) {
		this.carrinho = carrinho;
	}
	
	
	public double total(){
		
		return 0;
	}
	
	public boolean cadastrarVenda(){
		
		return true;
	}
	
}
