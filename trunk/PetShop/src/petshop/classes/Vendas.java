package petshop.classes;

import java.util.Date;

/**
 *
 * @author arthur
 */
public class Vendas {
	
        
	private Pagamento tipoPagamento;
	private boolean parcelado;
	private Date data;
	private Cliente cliente;
	private CarrinhoProdutos produtos;
	private CarrinhoServicos servicos;
	
	
	/**
	 * @param tipoPagamento
	 * @param parcelado
	 * @param data
	 * @param cliente
	 * @param produtos
	 * @param servicos
	 */
	public Vendas(Pagamento tipoPagamento, boolean parcelado, Date data,
			Cliente cliente, CarrinhoProdutos produtos,
			CarrinhoServicos servicos) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.parcelado = parcelado;
		this.data = data;
		this.cliente = cliente;
		this.produtos = produtos;
		this.servicos = servicos;
	}
	
	
	/**
	 * @return the tipoPagamento
	 */
	public Pagamento getTipoPagamento() {
		return tipoPagamento;
	}
	/**
	 * @param tipoPagamento the tipoPagamento to set
	 */
	public void setTipoPagamento(Pagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	/**
	 * @return the parcelado
	 */
	public boolean isParcelado() {
		return parcelado;
	}
	/**
	 * @param parcelado the parcelado to set
	 */
	public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the produtos
	 */
	public CarrinhoProdutos getProdutos() {
		return produtos;
	}
	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(CarrinhoProdutos produtos) {
		this.produtos = produtos;
	}
	/**
	 * @return the servicos
	 */
	public CarrinhoServicos getServicos() {
		return servicos;
	}
	/**
	 * @param servicos the servicos to set
	 */
	public void setServicos(CarrinhoServicos servicos) {
		this.servicos = servicos;
	}

	
}
