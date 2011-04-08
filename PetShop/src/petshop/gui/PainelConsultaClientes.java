package petshop.gui;

public class PainelConsultaClientes extends PainelConsulta {

    public PainelConsultaClientes(){
        super();

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Código", "Nome", "CPF", "RG" }));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {  },
            new String [] {
                "Código", "Nome", "CPF", "RG"
            }
        ));

        botaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoNovo(evt);
            }
        });
    }


    private void botaoNovo(java.awt.event.MouseEvent evt) {
        JanelaCadastroCliente cadastro = new JanelaCadastroCliente();

        cadastro.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        cadastro.setModal(true);
        cadastro.setVisible(true);
    }
}
