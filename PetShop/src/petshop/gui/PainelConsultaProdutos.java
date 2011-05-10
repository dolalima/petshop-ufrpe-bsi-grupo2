package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.Produto;

public class PainelConsultaProdutos extends PainelConsulta {

    Produto[] produtos;

    public PainelConsultaProdutos() {
        super();

        this.setCadastro(new JanelaProduto(TipoJanela.CADASTRO, null));

        int[] itensPreco = new int[2];
        itensPreco[0] = 2;
        itensPreco[1] = 3;
        this.setItensPreco(itensPreco);

        modelo = new String[]{"Código", "Nome", "Preço de Compra", "Preço de Venda"};
        tamanhosColunas = new double[]{15, 45, 20, 20};

        setModelo(modelo, tamanhosColunas);
    }

    protected void alterar(int cod){
        Produto p = BancoDeDados.consultar(new Produto(cod))[0];
        JanelaProduto janela = new JanelaProduto(TipoJanela.ALTERACAO, p);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void informacoes(int cod) {
        Produto p = BancoDeDados.consultar(new Produto(cod))[0];
        JanelaProduto janela = new JanelaProduto(TipoJanela.INFORMACAO, p);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void pesquisar() {
        produtos = getProdutos();
        if(produtos.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
            return;
        }
        
        Object[][] dados = new Object[produtos.length][4];

        for(int i = 0; i < produtos.length; i++){
            dados[i][0] = produtos[i].getCodigo();
            dados[i][1] = produtos[i].getNome();
            dados[i][2] = produtos[i].getPrecoCusto();
            dados[i][3] = produtos[i].getPrecoVenda();
        }

        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();

        model.setDataVector(dados, modelo);
        redimensionarColunas();
    }

    @Override
    void excluir(int cod) {
        int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este produto?",
                "Excluir", JOptionPane.YES_NO_OPTION);

        if(resp == JOptionPane.YES_OPTION){
            Produto p = new Produto(cod);
            BancoDeDados.remover(p);
        }
    }

    private Produto[] getProdutos(){
        Produto p = new Produto();
        double min; double max;

        if(!campoMin.getText().equals(getEtiqueta(campoMin))) min = Double.valueOf(campoMin.getText());
        else min = 0;
        if(!campoMax.getText().equals(getEtiqueta(campoMax))) max = Double.valueOf(campoMax.getText());
        else max = 0;

        if(comboPesquisa.getSelectedIndex() < 2){
            if(!campoPesquisa.getText().equals("")){
                if(comboPesquisa.getSelectedIndex() == 0){
                    p.setCodigo(Integer.valueOf(campoPesquisa.getText()));
                } else if(comboPesquisa.getSelectedIndex() == 1){
                    p.setNome(campoPesquisa.getText());
                }
            }
            return BancoDeDados.consultar(p);
        }

        if(min <= max || max == 0){
            if(comboPesquisa.getSelectedIndex() == 2) p.setPrecoCusto(min);
            else if(comboPesquisa.getSelectedIndex() == 3) p.setPrecoVenda(min);
            return BancoDeDados.consultar(p, max);
        } else {
            JOptionPane.showMessageDialog(this, "O máximo não pode ser menor que o mínimo!");
            return new Produto[0];
        }
    }
}
