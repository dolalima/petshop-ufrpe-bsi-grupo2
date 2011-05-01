package petshop.classes;

import java.util.ArrayList;

/**
 * @author arthur
 *
 */
public class CarrinhoProdutos {

    private ArrayList<Produto> produtos;
    private ArrayList<Integer> qtde;

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Integer> getQtde() {
        return qtde;
    }

    public void setQtde(ArrayList<Integer> qtde) {
        this.qtde = qtde;
    }

    public void add(Produto p, int qtde){
        this.produtos.add(p);
        this.qtde.add(qtde);
    }
}
