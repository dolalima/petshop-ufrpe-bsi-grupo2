package petshop.gui;

public class PainelConsultaServicos extends PainelConsulta {

    public PainelConsultaServicos(){
        super();

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Código", "Nome", "Animal", "Preço" }));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {  },
            new String [] {
                "Código", "Nome", "Animal", "Preço"
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
        JanelaCadastroServico cadastro = new JanelaCadastroServico();

        cadastro.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        cadastro.setModal(true);
        cadastro.setVisible(true);
    }
}
