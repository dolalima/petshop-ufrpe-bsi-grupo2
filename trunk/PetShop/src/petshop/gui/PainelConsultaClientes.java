package petshop.gui;

import petshop.classes.BancoDeDados;
import petshop.classes.Cliente;

public class PainelConsultaClientes extends PainelConsulta {

    public PainelConsultaClientes(){
        super();

        this.setCadastro(new JanelaCliente(TipoJanela.CADASTRO));

        int [] itensPreco = new int[0];
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "CPF", "RG"});

        this.botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterar(3);
                //alterar((Integer) tabela.getValueAt(0, tabela.getSelectedRow()));
            }
        });
    }

    public void alterar(int cod){
        JanelaCliente janela = new JanelaCliente(TipoJanela.ALTERACAO);

        Cliente[] cliente = BancoDeDados.consultar(new Cliente(cod));
        Cliente c = cliente[0];

        janela.getCampoNome().setText(c.getNome());
        if(c.getSexo() == 'M') janela.getComboSexo().setSelectedIndex(1);
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

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }
}
