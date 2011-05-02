package petshop.classes;

import java.util.GregorianCalendar;

/**
 *
 * @author arthur
 */
public class Venda {

    private int codigo;
    private TipoPagamento tipoPagamento;
    private boolean parcelado;
    private GregorianCalendar data;
    private Cliente cliente;
    private CarrinhoProdutos carrinhoProdutos;
    private CarrinhoServicos carrinhoServicos;

    public Venda(TipoPagamento tipoPagamento, boolean parcelado, GregorianCalendar data,
            Cliente cliente, CarrinhoProdutos produtos, CarrinhoServicos servicos) {
        this.tipoPagamento = tipoPagamento;
        this.parcelado = parcelado;
        this.data = data;
        this.cliente = cliente;
        this.carrinhoProdutos = produtos;
        this.carrinhoServicos = servicos;
    }

    public Venda() {
        this.tipoPagamento = TipoPagamento.DINHEIRO;
        this.data = new GregorianCalendar();
        this.cliente = new Cliente();
        this.carrinhoProdutos = new CarrinhoProdutos();
        this.carrinhoServicos = new CarrinhoServicos();
    }

    public Venda(int cod) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public boolean isParcelado() {
        return parcelado;
    }

    public void setParcelado(boolean parcelado) {
        this.parcelado = parcelado;
    }

    public CarrinhoProdutos getCarrinhoProdutos() {
        return carrinhoProdutos;
    }

    public void setCarrinhoProdutos(CarrinhoProdutos produtos) {
        this.carrinhoProdutos = produtos;
    }

    public CarrinhoServicos getCarrinhoServicos() {
        return carrinhoServicos;
    }

    public void setCarrinhoServicos(CarrinhoServicos servicos) {
        this.carrinhoServicos = servicos;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double total(){
        double total = 0;

        Produto[] produtos = (Produto[]) carrinhoProdutos.getProdutos().toArray();
        Servico[] servicos = (Servico[]) carrinhoServicos.getServicos().toArray();

        for(int i = 0; i < produtos.length; i++){
            total += produtos[i].getPrecoVenda();
        }

        for(int i = 0; i < servicos.length; i++){
            total += servicos[i].getPrecoVenda();
        }

        return total;
    }
}
