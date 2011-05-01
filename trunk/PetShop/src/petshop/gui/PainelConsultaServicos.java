package petshop.gui;

import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.Servico;

public class PainelConsultaServicos extends PainelConsulta {

    String[] modelo;
    double[] tamanhosColunas;

    public PainelConsultaServicos(){
        super();

        this.setCadastro(new JanelaServico(TipoJanela.CADASTRO));

        int [] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);

        modelo = new String[] {"Código", "Nome", "Preço"};
        tamanhosColunas = new double[] {15, 55, 30};

        setModelo(modelo, tamanhosColunas);

        this.botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterar(1);
                //alterar((Integer) tabela.getValueAt(0, tabela.getSelectedRow()));
            } });

        this.botaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisar();
            } });
    }

    public void alterar(int cod){
        JanelaServico janela = new JanelaServico(TipoJanela.ALTERACAO);

        Servico[] servico = BancoDeDados.consultar(new Servico(cod));
        Servico s = servico[0];

        if(s.getCodigo() != 0)
            janela.getCampoCodigo().setText(String.valueOf(s.getCodigo()));
        janela.getCampoNome().setText(s.getNome());
        janela.getCampoDuracao().setText(String.valueOf(s.getDuracao()));
        janela.getCampoPreco().setText(String.valueOf(s.getPrecoVenda()));
        if(!s.getInfo().equals(""))
            janela.getAreaInformacoes().setText(s.getInfo());

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    private void pesquisar() {
        Servico s = new Servico();

        if(comboPesquisa.getSelectedIndex() == 0){
            s.setCodigo(Integer.valueOf(campoPesquisa.getText()));
        } else if(comboPesquisa.getSelectedIndex() == 1){
            s.setNome(campoPesquisa.getText());
        } else if(comboPesquisa.getSelectedIndex() == 2){
            s.setPrecoVenda(Integer.valueOf(campoPesquisa.getText()));
        }

        Servico[] servicos = BancoDeDados.consultar(s);
        Object[][] dados = new Object[servicos.length][4];

        for(int i = 0; i < servicos.length; i++){
            dados[i][0] = servicos[i].getCodigo();
            dados[i][1] = servicos[i].getNome();
            dados[i][2] = servicos[i].getPrecoVenda();
        }

        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();

        model.setDataVector(dados, modelo);
        redimensionarColunas();
    }
}
