package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.CPF;
import petshop.classes.Cliente;

public class PainelConsultaClientes extends PainelConsulta {

    Cliente[] clientes;
    
    public PainelConsultaClientes(){
        super();

        this.setCadastro(new JanelaCliente(TipoJanela.CADASTRO, null));

        int [] itensPreco = new int[0];
        this.setItensPreco(itensPreco);
        
        modelo = new String[]{"Código", "Nome", "CPF", "RG"};
        
        setModelo(modelo, new double[]{15, 50, 20, 15});

        this.remove(botaoExcluir);
    }

    protected void alterar(int cod){
        JanelaCliente janela = new JanelaCliente(TipoJanela.ALTERACAO,
                BancoDeDados.consultar(new Cliente(cod))[0]);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void informacoes(int cod) {
        JanelaCliente janela = new JanelaCliente(TipoJanela.INFORMACAO,
                BancoDeDados.consultar(new Cliente(cod))[0]);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }
    
    protected void pesquisar(){
        Cliente c = new Cliente();

        if(!campoPesquisa.getText().equals("")){
            if(comboPesquisa.getSelectedIndex() == 0){
                c.setCodigo(Integer.valueOf(campoPesquisa.getText()));
            } else if(comboPesquisa.getSelectedIndex() == 1){
                c.setNome(campoPesquisa.getText());
            } else if(comboPesquisa.getSelectedIndex() == 2){
                c.setCpf(new CPF(campoPesquisa.getText()));
            } else if(comboPesquisa.getSelectedIndex() == 3){
                c.setRg(Integer.valueOf(campoPesquisa.getText()));
            }
        }
        
        clientes = BancoDeDados.consultar(c);
        Object[][] dados = new Object[clientes.length][4];
        
        for(int i = 0; i < clientes.length; i++){
            dados[i][0] = clientes[i].getCodigo();
            dados[i][1] = clientes[i].getNome();
            dados[i][2] = clientes[i].getCpf().toString();
            dados[i][3] = clientes[i].getRg();
        }
        
        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();
        
        model.setDataVector(dados, modelo);
        redimensionarColunas();

        if(clientes.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }

    void excluir(int cod) {
    }
}
