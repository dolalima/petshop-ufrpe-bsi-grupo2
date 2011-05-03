package petshop.classes;

import java.util.ArrayList;

/**
 * @author arthur
 *
 */
public class CarrinhoProdutos {

    private ArrayList<Produto> produtos;
    private ArrayList<Integer> qtde;

    public CarrinhoProdutos() {
        produtos = new ArrayList();
        qtde = new ArrayList();
    }

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

    public void remove(int codigoProduto){
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getCodigo() == codigoProduto){
                produtos.remove(i);
                qtde.remove(i);
            }
        }
    }
}
