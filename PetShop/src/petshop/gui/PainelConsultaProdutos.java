package petshop.gui;

import javax.swing.JTextField;
import petshop.classes.BancoDeDados;
import petshop.classes.Produto;

public class PainelConsultaProdutos extends PainelConsulta {
    

    public PainelConsultaProdutos(){
        super();

        this.setCadastro(new JanelaProduto(TipoJanela.CADASTRO));

        int [] itensPreco = new int[2];
        itensPreco[0] = 2;
        itensPreco[1] = 3;
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "Preço de Compra", "Preço de Venda"});

        this.botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterar(11001);
                //alterar((Integer) tabela.getValueAt(0, tabela.getSelectedRow()));
            }
        });
    }


    public void alterar(int cod){
        JanelaProduto janela = new JanelaProduto(TipoJanela.ALTERACAO);

        Produto[] produto = BancoDeDados.consultar(new Produto(cod));
        Produto p = produto[0];

        if(p.getCodigo() != 0)
            janela.getCampoCodigo().setText(String.valueOf(p.getCodigo()));
        janela.getCampoNome().setText(p.getNome());
        janela.getCampoQtde().setText(String.valueOf(p.getQtdeEstoque()));
        janela.getCampoPrecoCusto().setText(String.valueOf(p.getPrecoCusto()));
        janela.getCampoPrecoVenda().setText(String.valueOf(p.getPrecoVenda()));
        if(!p.getInformacoes().equals(""))
            janela.getAreaInformacoes().setText(p.getInformacoes());

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }
}
