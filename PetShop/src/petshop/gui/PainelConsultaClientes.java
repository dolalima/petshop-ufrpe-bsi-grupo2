package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.CPF;
import petshop.classes.Cliente;

public class PainelConsultaClientes extends PainelConsulta {
    
    
    public PainelConsultaClientes(){
        super();

        this.setCadastro(new JanelaCliente(TipoJanela.CADASTRO));

        int [] itensPreco = new int[0];
        this.setItensPreco(itensPreco);
        
        modelo = new String[]{"Código", "Nome", "CPF", "RG"};
        
        setModelo(modelo, new double[]{15, 50, 20, 15});

        this.remove(this.botaoExcluir);
    }

    protected void alterar(int cod){
        JanelaCliente janela = new JanelaCliente(TipoJanela.ALTERACAO);

        preencher(janela, cod);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void informacoes(int cod) {
        JanelaCliente janela = new JanelaCliente(TipoJanela.INFORMACAO);

        preencher(janela, cod);

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
        
        Cliente[] clientes = BancoDeDados.consultar(c);
        Object[][] dados = new Object[clientes.length][4];
        
        for(int i = 0; i < clientes.length; i++){
            dados[i][0] = clientes[i].getCodigo();
            dados[i][1] = clientes[i].getNome();
            dados[i][2] = clientes[i].getCpf().getCpf();
            dados[i][3] = clientes[i].getRg();
        }
        
        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();
        
        model.setDataVector(dados, modelo);
        redimensionarColunas();

        if(clientes.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }

    private void preencher(JanelaCliente janela, int cod){

        Cliente[] cliente = BancoDeDados.consultar(new Cliente(cod));
        Cliente c = cliente[0];

        janela.getCampoNome().setText(c.getNome());
        if(c.getSexo().equals("M")) janela.getComboSexo().setSelectedIndex(1);
        else janela.getComboSexo().setSelectedIndex(2);
        janela.getCampoRua().setText(c.getEndereco().getRua());
        janela.getCampoNumero().setText(String.valueOf(c.getEndereco().getNum()));
        if(!c.getEndereco().getComplemento().equals(""))
            janela.getCampoComplemento().setText(c.getEndereco().getComplemento());
        janela.getCampoBairro().setText(c.getEndereco().getBairro());
        janela.getCampoCidade().setText(c.getEndereco().getCidade());
        janela.getComboUF().setSelectedItem(c.getEndereco().getUf());
        if(!c.getEndereco().getCep().equals(""))
            janela.getCampoCEP().setText(c.getEndereco().getCep());
        janela.getCampoRG().setText(String.valueOf(c.getRg()));
        janela.getCampoCPF().setText(c.getCpf().getCpf());
        if(!c.getEmail().equals(""))
            janela.getCampoEMail().setText(c.getEmail());
        if(!c.getTelefone().equals(""))
            janela.getCampoTelefone().setText(c.getTelefone());
        if(!c.getCelular().equals(""))
            janela.getCampoCelular().setText(c.getCelular());
        for(int i = 0; i < c.getAnimais().length; i++){
            janela.getComboAnimais().addItem(c.getAnimais()[i].getNome());
        }
        if(!c.getInformacoes().equals(""))
            janela.getAreaInformacoes().setText(c.getInformacoes());
    }

    @Override
    void excluir(int integer) {
        throw new UnsupportedOperationException("Cliente não pode ser excluído");
    }
}
