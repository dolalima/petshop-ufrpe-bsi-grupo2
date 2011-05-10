package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.CPF;
import petshop.classes.Cliente;
import petshop.classes.Venda;

public class PainelConsultaVendas extends PainelConsulta {

    Venda[] vendas;

    public PainelConsultaVendas(){
        super();

        this.setCadastro(new JanelaVenda(TipoJanela.CADASTRO, null));
        int [] itensPreco = new int[1];
        itensPreco[0] = 3;
        this.setItensPreco(itensPreco);
        
        modelo = new String[] {"Código", "Cliente", "CPF", "Total"};
        tamanhosColunas = new double[] {15, 45, 23, 17};

        setModelo(modelo, tamanhosColunas);

        this.remove(botaoAlterar);
        this.remove(botaoExcluir);
    }

    protected void informacoes(int cod) {
        Venda v = BancoDeDados.consultar(new Venda(cod))[0];
        JanelaVenda janela = new JanelaVenda(TipoJanela.INFORMACAO, v);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void pesquisar() {
        vendas = getVendas();        

        Object[][] dados = new Object[vendas.length][4];

        for(int i = 0; i < vendas.length; i++){
            dados[i][0] = vendas[i].getCodigo();
            dados[i][1] = vendas[i].getCliente().getNome();
            dados[i][2] = vendas[i].getCliente().getCpf().toString();
            dados[i][3] = vendas[i].total();
        }

        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();

        model.setDataVector(dados, modelo);
        redimensionarColunas();

        if(vendas.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }

    void alterar(int integer) {
    }

    void excluir(int integer) {        
    }

    private Venda[] getVendas(){
        Venda v = new Venda();
        double min; double max;

        if(!campoMin.getText().equals(getEtiqueta(campoMin))) min = Double.valueOf(campoMin.getText());
        else min = 0;
        if(!campoMax.getText().equals(getEtiqueta(campoMax))) max = Double.valueOf(campoMax.getText());
        else max = 0;

        if(comboPesquisa.getSelectedIndex() < 3){
            if(!campoPesquisa.getText().equals("")){
                if(comboPesquisa.getSelectedIndex() == 0){
                    v.setCodigo(Integer.valueOf(campoPesquisa.getText()));
                } else if(comboPesquisa.getSelectedIndex() == 1){
                    Cliente c = new Cliente();
                    c.setNome(campoPesquisa.getText());
                    v.setCliente(c);
                } else if(comboPesquisa.getSelectedIndex() == 1){
                    Cliente c = new Cliente();
                    c.setCpf(new CPF(campoPesquisa.getText()));
                    v.setCliente(c);
                }
            }
            return BancoDeDados.consultar(v);
        }

        if(min <= max || max == 0){
            return BancoDeDados.consultar(min, max);
        } else {
            JOptionPane.showMessageDialog(this, "O máximo não pode ser menor que o mínimo!");
            return new Venda[0];
        }
    }
}
