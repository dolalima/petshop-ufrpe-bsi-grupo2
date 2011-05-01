package petshop.gui;

import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.Produto;

public class PainelConsultaProdutos extends PainelConsulta {

    String[] modelo;
    double[] tamanhosColunas;

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

        this.botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterar(11001);
                //alterar((Integer) tabela.getValueAt(0, tabela.getSelectedRow()));
            } });

        this.botaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisar();
            } });
    }

    public void alterar(int cod) {
        JanelaProduto janela = new JanelaProduto(TipoJanela.ALTERACAO);

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

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    private void pesquisar() {
        Produto p = new Produto();

        if(comboPesquisa.getSelectedIndex() == 0){
            p.setCodigo(Integer.valueOf(campoPesquisa.getText()));
        } else if(comboPesquisa.getSelectedIndex() == 1){
            p.setNome(campoPesquisa.getText());
        } else if(comboPesquisa.getSelectedIndex() == 2){
            p.setPrecoCusto(Integer.valueOf(campoPesquisa.getText()));
        } else if(comboPesquisa.getSelectedIndex() == 3){
            p.setPrecoVenda(Integer.valueOf(campoPesquisa.getText()));
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
    }
}
