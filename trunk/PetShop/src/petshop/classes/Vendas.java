package petshop.classes;

import java.util.Date;

/**
 *
 * @author arthur
 */
public class Vendas {
	
    /**
     * 
     */
    public enum Pagamento {

        /**
         * 
         */
        DINHEIRO,
        /**
         *
         */
        CHEQUE,
        /**
         * 
         */
        CARTAO
    };

        
	private Pagamento tipoPagamento;
	private boolean parcelado;
	private Date data;
	private Cliente cliente;
	private CarrinhoDeCompras[] carrinho;
	
		
        /**
         *
         * @param tipoPagamento
         * @param parcelado
         * @param data
         * @param cliente
         * @param carrinho
         */
        public Vendas(Pagamento tipoPagamento, boolean parcelado, Date data,
			Cliente cliente, CarrinhoDeCompras[] carrinho) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.parcelado = parcelado;
		this.data = data;
		this.cliente = cliente;
		this.carrinho = carrinho;
	}
	
	
        /**
         *
         * @return
         */
        public Pagamento getTipoPagamento() {
		return tipoPagamento;
	}
        /**
         *
         * @param tipoPagamento
         */
        public void setTipoPagamento(Pagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
        /**
         * retornar se a venda esta com parcelamento ou nao.
         * 
         * 
         * 
         * 
         *
         */
        public boolean isParcelado() {
		return parcelado;
	}
        /**
         *
         * 
         */
        public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}
	
        /**
         *metodo 
         * @return retorna
         */
        public Date getData() {
		return data;
	}
        /**
         *
         * @param data
         */
        public void setData(Date data) {
		this.data = data;
	}
	
        /**
         *
         * @return
         */
        public Cliente getCliente() {
		return cliente;
	}
        /**
         *
         * @param cliente
         */
        public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
        /**
         *
         * @return
         */
        public CarrinhoDeCompras[] getCarrinho() {
		return carrinho;
	}
        /**
         *
         * @param carrinho
         */
        public void setCarrinho(CarrinhoDeCompras[] carrinho) {
		this.carrinho = carrinho;
	}
	

        /**
         *
         * @return
         */
        public double total(){
		
		return 0;
	}
	
        /**
         *
         * @return
         */
        public boolean cadastrarVenda(){
		
		return true;
	}
	
}
