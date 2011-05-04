/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author arthur
 */
public abstract class PainelConsulta extends Painel {

    protected JButton botaoNovo;
    protected JButton botaoAlterar;
    protected JButton botaoExcluir;
    protected JButton botaoInformacoes;
    protected JTextField campoMin;
    protected JTextField campoMax;
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

        campoMin = new JTextField();
        campoMin.setText(getEtiqueta(campoMin));
        campoMin.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                tirarEtiqueta(evt);
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                colocarEtiqueta(evt);
            }
        });

        campoMax = new JTextField();
        campoMax.setText(getEtiqueta(campoMax));
        campoMax.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                tirarEtiqueta(evt);
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                colocarEtiqueta(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(campoMin, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        add(campoMax, gridBagConstraints);


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
                    int codigo = (Integer) tabela.getValueAt(tabela.getSelectedRow(), 0);
                    alterar(codigo);
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
                    int codigo = (Integer) tabela.getValueAt(tabela.getSelectedRow(), 0);
                    excluir(codigo);
                }
            }
        });

        this.botaoInformacoes.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(botaoInformacoes.isEnabled()){
                    int codigo = (Integer) tabela.getValueAt(tabela.getSelectedRow(), 0);
                    informacoes(codigo);
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

    protected void trocarTipoPesquisa() {
        boolean trocarParaPreco = false;

        for(int i = 0; i < itensPreco.length; i++){
            if(comboPesquisa.getSelectedIndex() == itensPreco[i]) {
                trocarParaPreco = true;
            }
        }
        if(trocarParaPreco){
            campoPesquisa.setVisible(false);
            campoMin.setVisible(true);
            campoMax.setVisible(true);
        } else {
            campoPesquisa.setVisible(true);
            campoMin.setVisible(false);
            campoMax.setVisible(false);
        }

        campoPesquisa.setText("");
        campoMin.setText(getEtiqueta(campoMin));
        campoMax.setText(getEtiqueta(campoMax));

        this.updateUI();
    }

    private void tirarEtiqueta(FocusEvent evt) {
        JTextComponent campo = (JTextComponent) evt.getComponent();

        if(campo.getText().equals(getEtiqueta(campo))){
            campo.setText("");
        }
}

    private void colocarEtiqueta(java.awt.event.FocusEvent evt) {
        JTextComponent campo = (JTextComponent) evt.getComponent();

        if(campo.getText().equals("")){
            campo.setText(getEtiqueta(campo));
        }
    }

    abstract void alterar(int codigo);

    abstract void pesquisar();

    abstract void informacoes(int codigo);

    abstract void excluir(int codigo);

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

    protected String getEtiqueta(JTextComponent campo) {
        if(campo.equals(campoMin)) return "MIN";
        else if(campo.equals(campoMax)) return "MAX";

        return "";
    }
}
