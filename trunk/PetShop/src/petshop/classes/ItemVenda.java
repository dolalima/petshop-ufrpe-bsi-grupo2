package petshop.classes;

/**
 * @author arthur
 *
 */
public class ItemVenda {

    private int codigo;
    private String nome;
    private double precoVenda;

    /**
     * @param codigo
     * @param nome
     * @param precoVenda
     */
    public ItemVenda(int codigo, String nome, double precoVenda) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.precoVenda = precoVenda;
    }

    public ItemVenda() {
    }

    /**
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return
     */
    public double getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda
     */
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
