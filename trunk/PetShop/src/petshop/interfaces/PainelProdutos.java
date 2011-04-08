package petshop.interfaces;

import java.awt.Dimension;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PainelProdutos extends Painel {
    
    private JTextField campoAcimaDe;
    private JTextField campoAbaixoDe;
    private java.awt.GridBagConstraints gridBagConstraints;

    public PainelProdutos(){
        super();
        
        campoAcimaDe = new JTextField("Acima de");
        campoAbaixoDe = new JTextField("Abaixo de");


        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 117;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(campoAcimaDe, gridBagConstraints);
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        gridBagConstraints.gridx = 3;
        add(campoAbaixoDe, gridBagConstraints);


        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Código", "Nome", "Preço de Custo", "Preço de Venda" }));

        comboPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPesquisaEvento(evt);
            }
        });

        comboPesquisa.setMaximumSize(new Dimension(66,24));
        comboPesquisa.setMinimumSize(new Dimension(66,24));

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
        JanelaCadastroProduto cadastro = new JanelaCadastroProduto();

        cadastro.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        cadastro.setModal(true);
        cadastro.setVisible(true);
    }


   private void comboPesquisaEvento(java.awt.event.ItemEvent evt){
       
       if(comboPesquisa.getSelectedIndex() >= 2){
           campoPesquisa.setVisible(false);
           campoAcimaDe.setVisible(true);
           campoAbaixoDe.setVisible(true);
       } else {
           campoPesquisa.setVisible(true);
           campoAcimaDe.setVisible(false);
           campoAbaixoDe.setVisible(false);
       }
   }
}
