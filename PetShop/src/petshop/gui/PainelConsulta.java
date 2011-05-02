/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author arthur
 */
public abstract class PainelConsulta extends Painel {

    protected JButton botaoNovo;
    protected JButton botaoAlterar;
    protected JButton botaoExcluir;
    protected JButton botaoInformacoes;
    private JTextField campoAcimaDe;
    private JTextField campoAbaixoDe;
    private JDialog cadastro;
    private int[] itensPreco;

    public PainelConsulta() {

        itensPreco = new int[0];

        botaoNovo = new JButton();
        botaoAlterar = new JButton();
        botaoExcluir = new JButton();
        botaoInformacoes = new JButton();

        botaoNovo.setText("Novo");
        botaoNovo.setFocusCycleRoot(true);
        botaoNovo.setMinimumSize(new java.awt.Dimension(35, 24));
        botaoNovo.setPreferredSize(new java.awt.Dimension(45, 24));
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(botaoNovo, gridBagConstraints);

        botaoAlterar.setText("Alterar");
        botaoAlterar.setMinimumSize(new java.awt.Dimension(35, 24));
        botaoAlterar.setEnabled(false);
        gridBagConstraints.gridx = 1;
        add(botaoAlterar, gridBagConstraints);

        botaoExcluir.setText("Excluir");
        botaoExcluir.setMinimumSize(new java.awt.Dimension(35, 24));
        botaoExcluir.setEnabled(false);
        gridBagConstraints.gridx = 2;
        add(botaoExcluir, gridBagConstraints);

        botaoInformacoes.setText("Informações");
        botaoInformacoes.setMinimumSize(new java.awt.Dimension(35, 24));
        botaoInformacoes.setEnabled(false);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(botaoInformacoes, gridBagConstraints);

        campoAcimaDe = new JTextField();
        campoAbaixoDe = new JTextField();

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(campoAcimaDe, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        add(campoAbaixoDe, gridBagConstraints);


        comboPesquisa.setMaximumSize(new Dimension(66, 24));
        comboPesquisa.setMinimumSize(new Dimension(66, 24));

        comboPesquisa.addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                trocarTipoPesquisa();
            }
        });

        botaoNovo.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventoBotaoNovo(evt);
            }
        });

        this.botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(botaoAlterar.isEnabled()){
                    Number valor = (Number) tabela.getValueAt(tabela.getSelectedRow(), 0);
                    alterar(valor.intValue());
                }
            }
        });

        this.botaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisar();
            }
        });

        this.botaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(botaoExcluir.isEnabled()){
                    Number valor = (Number) tabela.getValueAt(tabela.getSelectedRow(), 0);
                    excluir(valor.intValue());
                }
            }
        });

        this.botaoInformacoes.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(botaoInformacoes.isEnabled()){
                    Number valor = (Number) tabela.getValueAt(tabela.getSelectedRow(), 0);
                    informacoes(valor.intValue());
                }
            }
        });

        ListSelectionModel cellSelectionModel = tabela.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if(tabela.getSelectedRow() != -1){
                    botaoAlterar.setEnabled(true);
                    botaoExcluir.setEnabled(true);
                    botaoInformacoes.setEnabled(true);
                } else {
                    botaoAlterar.setEnabled(false);
                    botaoExcluir.setEnabled(false);
                    botaoInformacoes.setEnabled(false);
                }
            }
        });

        trocarTipoPesquisa(); //serve para setar os campos de preço serem visiveis ou nao.
    }

    private void eventoBotaoNovo(java.awt.event.MouseEvent evt) {

        getCadastro().setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        getCadastro().setModal(true);

        getCadastro().setVisible(true);
    }

    private void trocarTipoPesquisa() {

        boolean trocarParaPreco = false;

        for(int i = 0; i < itensPreco.length; i++){
            if(comboPesquisa.getSelectedIndex() == itensPreco[i]) {
                trocarParaPreco = true;
            }
        }


        if(trocarParaPreco){
            campoPesquisa.setVisible(false);
            campoAcimaDe.setVisible(true);
            campoAbaixoDe.setVisible(true);
        } else {
            campoPesquisa.setVisible(true);
            campoAcimaDe.setVisible(false);
            campoAbaixoDe.setVisible(false);
        }

        this.updateUI();
    }

    abstract void alterar(int integer);

    abstract void pesquisar();

    abstract void informacoes(int integer);

    abstract void excluir(int integer);

    /**
     * Retorna o a janela de cadastro que foi setada.
     * @return cadastro
     */
    public JDialog getCadastro() {
        return cadastro;
    }

    /**
     * Seta uma JanelaCadastro, que vai ser aberta quando for pressionado o botaoNovo
     * @param cadastro
     */
    public void setCadastro(JDialog cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * Retorna a lista dos numeros em que estão os elementos que são preços
     * @return itensPreco
     */
    public int[] getItensPreco() {
        return itensPreco;
    }

    /**
     * Configura a lista dos numeros em que estão os elementos que são preços
     * @param itensPreco
     */
    public void setItensPreco(int[] itensPreco) {
        this.itensPreco = itensPreco;
    }
}
