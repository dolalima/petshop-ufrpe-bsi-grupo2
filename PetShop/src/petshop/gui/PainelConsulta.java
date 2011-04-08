/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop.gui;

import javax.swing.JButton;

/**
 *
 * @author arthur
 */
public class PainelConsulta extends Painel{

    JButton botaoNovo;
    JButton botaoAlterar;
    JButton botaoInformacoes;

    public PainelConsulta(){

        java.awt.GridBagConstraints gridBagConstraints;

        botaoNovo = new JButton();
        botaoAlterar = new JButton();
        botaoInformacoes = new JButton();

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
    }
}
