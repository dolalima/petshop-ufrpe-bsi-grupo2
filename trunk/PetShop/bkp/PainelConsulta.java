package petshop.interfaces;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class PainelConsulta extends javax.swing.JPanel {

    public PainelConsulta() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelPesquisa = new javax.swing.JLabel();
        comboPesquisa = new javax.swing.JComboBox();
        campoPesquisa = new javax.swing.JTextField();
        painelItens = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaoPesquisar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoInformacoes = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(650, 400));
        setLayout(new java.awt.GridBagLayout());

        labelPesquisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPesquisa.setText("Pesquisar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        add(labelPesquisa, gridBagConstraints);

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPesquisa.setMaximumSize(new java.awt.Dimension(66, 24));
        comboPesquisa.setMinimumSize(new Dimension(66,24));
        comboPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPesquisaItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(comboPesquisa, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(campoPesquisa, gridBagConstraints);

        painelItens.setPreferredSize(new java.awt.Dimension(155, 275));

        tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.setPreferredSize(new java.awt.Dimension(300, 400));
        painelItens.setViewportView(tabela);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 569;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        add(painelItens, gridBagConstraints);

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setMinimumSize(new java.awt.Dimension(35, 24));
        botaoPesquisar.setPreferredSize(new java.awt.Dimension(50, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(botaoPesquisar, gridBagConstraints);

        botaoNovo.setText("Novo");
        botaoNovo.setFocusCycleRoot(true);
        botaoNovo.setMinimumSize(new java.awt.Dimension(35, 24));
        botaoNovo.setPreferredSize(new java.awt.Dimension(45, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        add(botaoNovo, gridBagConstraints);

        botaoAlterar.setText("Alterar");
        botaoAlterar.setMinimumSize(new java.awt.Dimension(35, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(botaoAlterar, gridBagConstraints);

        botaoInformacoes.setText("Informações");
        botaoInformacoes.setMinimumSize(new java.awt.Dimension(35, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(botaoInformacoes, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void comboPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPesquisaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPesquisaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton botaoAlterar;
    javax.swing.JButton botaoInformacoes;
    javax.swing.JButton botaoNovo;
    javax.swing.JButton botaoPesquisar;
    javax.swing.JTextField campoPesquisa;
    javax.swing.JComboBox comboPesquisa;
    javax.swing.JLabel labelPesquisa;
    javax.swing.JScrollPane painelItens;
    javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
