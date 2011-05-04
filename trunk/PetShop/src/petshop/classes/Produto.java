package petshop.classes;

/**
 * @author arthur
 *
 */
public class Produto extends ItemVenda {

    private double precoCusto;
    private int qtdeEstoque;
    private String informacoes;

    public Produto(int codigo, String nome, double precoCusto, double precoVenda, int qtdeEstoque, String informacoes) {
        super(codigo, nome, precoVenda);
        this.precoCusto = precoCusto;
        this.qtdeEstoque = qtdeEstoque;
        this.informacoes = informacoes;
    }

    public Produto() {
        super(0, "", 0);
        this.informacoes = "";
    }

    public Produto(int cod) {
        super(cod, "", 0);
        this.informacoes = "";
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }


}
