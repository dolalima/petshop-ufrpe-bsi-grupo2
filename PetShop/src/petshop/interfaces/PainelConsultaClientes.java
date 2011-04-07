package petshop.interfaces;

@SuppressWarnings("serial")
public class PainelConsultaClientes extends PainelConsulta {

    public PainelConsultaClientes(){
        super();

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Código", "Nome", "CPF", "RG" }));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null}, {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF", "RG"
            }
        ));

        botaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoNovoEvento(evt);
            }
        });
    }


    private void botaoNovoEvento(java.awt.event.MouseEvent evt) {
        JanelaCadastroClientes cadastro = new JanelaCadastroClientes();

        cadastro.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        cadastro.setModal(true);
        cadastro.setVisible(true);
    }
}
