package petshop.gui;

import petshop.classes.BancoDeDados;
import petshop.classes.Servico;

public class PainelConsultaServicos extends PainelConsulta {

    public PainelConsultaServicos(){
        super();

        this.setCadastro(new JanelaServico(TipoJanela.CADASTRO));

        int [] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "Preço"});

        this.botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterar(1);
                //alterar((Integer) tabela.getValueAt(0, tabela.getSelectedRow()));
            }
        });
    }

    public void alterar(int cod){
        JanelaServico janela = new JanelaServico(TipoJanela.ALTERACAO);

        Servico[] produto = BancoDeDados.consultar(new Servico(cod));
        Servico p = produto[0];

        if(p.getCodigo() != 0)
            janela.getCampoCodigo().setText(String.valueOf(p.getCodigo()));
        janela.getCampoNome().setText(p.getNome());
        janela.getCampoDuracao().setText(String.valueOf(p.getDuracao()));
        janela.getCampoPreco().setText(String.valueOf(p.getPrecoVenda()));
        if(!p.getInfo().equals(""))
            janela.getAreaInformacoes().setText(p.getInfo());

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }
}
