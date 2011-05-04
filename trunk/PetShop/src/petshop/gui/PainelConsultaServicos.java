package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.LetraMaiuscula;
import petshop.classes.Servico;

public class PainelConsultaServicos extends PainelConsulta {

    public PainelConsultaServicos() {
        super();

        this.setCadastro(new JanelaServico(TipoJanela.CADASTRO));

        int[] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);

        modelo = new String[]{"Código", "Nome", "Preço"};
        tamanhosColunas = new double[]{15, 55, 30};

        setModelo(modelo, tamanhosColunas);
    }

    protected void alterar(int cod){
        JanelaServico janela = new JanelaServico(TipoJanela.ALTERACAO);

        preencher(janela, cod);

        janela.getCampoCodigo().setEnabled(false);
        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void informacoes(int cod) {
        JanelaServico janela = new JanelaServico(TipoJanela.INFORMACAO);

        preencher(janela, cod);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void pesquisar() {
        Servico[] servicos = getServicos();
        Object[][] dados = new Object[servicos.length][4];

        for(int i = 0; i < servicos.length; i++){
            dados[i][0] = servicos[i].getCodigo();
            dados[i][1] = servicos[i].getNome();
            dados[i][2] = servicos[i].getPrecoVenda();
        }

        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();

        model.setDataVector(dados, modelo);
        redimensionarColunas();

        if(servicos.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }

    private void preencher(JanelaServico janela, int cod) {
        Servico s = BancoDeDados.consultar(new Servico(cod))[0];

        if(s.getCodigo() != 0) {
            janela.getCampoCodigo().setDocument(new LetraMaiuscula(10));
            janela.getCampoCodigo().setText(s.getCodigo() + "");
        }
        janela.getCampoNome().setText(s.getNome());
        janela.getCampoDuracao().setText(String.valueOf(s.getDuracao()));
        janela.getCampoPreco().setText(String.valueOf(s.getPrecoVenda()));
        if(!s.getInfo().equals("")) {
            janela.getAreaInformacoes().setText(s.getInfo());
        }
    }

    @Override
    void excluir(int cod) {
        int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este serviço?",
                "Excluir", JOptionPane.YES_NO_OPTION);

        if(resp == JOptionPane.YES_OPTION){
            Servico s = new Servico(cod);
            BancoDeDados.remover(s);
        }
    }

    private Servico[] getServicos(){
        Servico s = new Servico();
        double min; double max;

        if(!campoMin.getText().equals(getEtiqueta(campoMin))) min = Double.valueOf(campoMin.getText());
        else min = 0;
        if(!campoMax.getText().equals(getEtiqueta(campoMax))) max = Double.valueOf(campoMax.getText());
        else max = 0;

        if(comboPesquisa.getSelectedIndex() < 2){
            if(!campoPesquisa.getText().equals("")){
                if(comboPesquisa.getSelectedIndex() == 0){
                    s.setCodigo(Integer.valueOf(campoPesquisa.getText()));
                } else if(comboPesquisa.getSelectedIndex() == 1){
                    s.setNome(campoPesquisa.getText());
                }
            }
            return BancoDeDados.consultar(s);
        }

        if(min <= max || max == 0){
            s.setPrecoVenda(min);
            return BancoDeDados.consultar(s, max);
        } else {
            JOptionPane.showMessageDialog(this, "O máximo não pode ser menor que o mínimo!");
            return new Servico[0];
        }
    }
}
