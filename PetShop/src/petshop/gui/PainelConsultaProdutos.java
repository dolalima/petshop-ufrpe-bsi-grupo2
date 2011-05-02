package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.Produto;

public class PainelConsultaProdutos extends PainelConsulta {


    public PainelConsultaProdutos() {
        super();

        this.setCadastro(new JanelaProduto(TipoJanela.CADASTRO));

        int[] itensPreco = new int[2];
        itensPreco[0] = 2;
        itensPreco[1] = 3;
        this.setItensPreco(itensPreco);

        modelo = new String[]{"Código", "Nome", "Preço de Compra", "Preço de Venda"};
        tamanhosColunas = new double[]{15, 45, 20, 20};

        setModelo(modelo, tamanhosColunas);
    }

    protected void alterar(int cod){
        JanelaProduto janela = new JanelaProduto(TipoJanela.ALTERACAO);

        preencher(janela, cod);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void informacoes(int cod) {
        JanelaProduto janela = new JanelaProduto(TipoJanela.INFORMACAO);

        preencher(janela, cod);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void pesquisar() {
        Produto p = new Produto();

        if(!campoPesquisa.getText().equals("")){
            if(comboPesquisa.getSelectedIndex() == 0){
                p.setCodigo(Integer.valueOf(campoPesquisa.getText()));
            } else if(comboPesquisa.getSelectedIndex() == 1){
                p.setNome(campoPesquisa.getText());
            } else if(comboPesquisa.getSelectedIndex() == 2){
                p.setPrecoCusto(Integer.valueOf(campoPesquisa.getText()));
            } else if(comboPesquisa.getSelectedIndex() == 3){
                p.setPrecoVenda(Integer.valueOf(campoPesquisa.getText()));
            }
        }

        Produto[] produtos = BancoDeDados.consultar(p);
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

        if(produtos.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }

    private void preencher(JanelaProduto janela, int cod) {
        Produto[] produto = BancoDeDados.consultar(new Produto(cod));
        Produto p = produto[0];

        if(p.getCodigo() != 0) {
            janela.getCampoCodigo().setText(String.valueOf(p.getCodigo()));
        }
        janela.getCampoNome().setText(p.getNome());
        janela.getCampoQtde().setText(String.valueOf(p.getQtdeEstoque()));
        janela.getCampoPrecoCusto().setText(String.valueOf(p.getPrecoCusto()));
        janela.getCampoPrecoVenda().setText(String.valueOf(p.getPrecoVenda()));
        if(!p.getInformacoes().equals("")) {
            janela.getAreaInformacoes().setText(p.getInformacoes());
        }
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
}
