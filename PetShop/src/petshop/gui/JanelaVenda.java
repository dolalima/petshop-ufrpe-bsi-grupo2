package petshop.gui;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import petshop.classes.Animal;
import petshop.classes.BancoDeDados;
import petshop.classes.Cliente;
import petshop.classes.Produto;
import petshop.classes.Servico;
import petshop.classes.TipoPagamento;
import petshop.classes.Venda;

/**
 *
 * @author arthur
 */
public class JanelaVenda extends Janela {

    private JanelaAdicionaProduto adicionaProduto;
    private JanelaAdicionaServico adicionaServico;
    private JanelaAdicionaCliente adicionaCliente;
    private TipoJanela tipo;
    private DecimalFormat formatoDecimal;
    private double total;
    private Venda venda;
    private Cliente cliente;
    private JTable tabelaProdutos;
    private JTable tabelaServicos;
    private double[] porcentagemTamanhoColunas;

    /** Creates new form JanelaVenda */
    public JanelaVenda(TipoJanela tipo, Venda v) {
        this.tipo = tipo;
        initComponents();

        if(v == null){
            venda = new Venda();
        } else {
            venda = v;
        }

        adicionaServico = new JanelaAdicionaServico(this);
        adicionaProduto = new JanelaAdicionaProduto(this);
        adicionaCliente = new JanelaAdicionaCliente(this);

        this.setLocationRelativeTo(this.getContentPane());

        total = 0.0;
        formatoDecimal = new DecimalFormat("0.00");

        scrollItens.setPreferredSize(new java.awt.Dimension(480, 200));

        tabelaProdutos = new JTable();
        tabelaServicos = new JTable();

        tabelaProdutos.setMaximumSize(new java.awt.Dimension(300, 100));
        tabelaServicos.setMaximumSize(new java.awt.Dimension(300, 100));
        scrollItens.setViewportView(tabelaProdutos);

        ListSelectionModel modeloSelecaoProdutos = tabelaProdutos.getSelectionModel();
        ListSelectionModel modeloSelecaoServicos = tabelaServicos.getSelectionModel();
        modeloSelecaoProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modeloSelecaoServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setModelo(tabelaProdutos,
                new String[]{"Código", "Nome", "Qtde", "Preço"},
                new double[]{15, 50, 15, 20});

        setModelo(tabelaServicos,
                new String[]{"Código", "Nome", "Animal", "Preço"},
                new double[]{15, 40, 25, 19.5});

        modeloSelecaoProdutos.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                verificarBotaoRemover(tabelaProdutos);
            }
        });
        modeloSelecaoServicos.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                verificarBotaoRemover(tabelaServicos);
            }
        });

        if(this.tipo == TipoJanela.INFORMACAO){
            desabilitarCampos();
            preencher();
        } else {
            reiniciar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        botaoPesquisarCliente = new javax.swing.JButton();
        labelCliente = new javax.swing.JLabel();
        comboTipoCarrinho = new javax.swing.JComboBox();
        campoCodigo = new javax.swing.JTextField();
        botaoPesquisaItem = new javax.swing.JButton();
        botaoAdd = new javax.swing.JButton();
        scrollItens = new javax.swing.JScrollPane();
        botaoRemover = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoPagar = new javax.swing.JButton();
        comboAnimais = new javax.swing.JComboBox();
        campoQtde = new javax.swing.JTextField();
        labelCodigo = new javax.swing.JLabel();
        labelQtde = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Venda");
        setMinimumSize(new java.awt.Dimension(570, 370));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        botaoPesquisarCliente.setText("Pesquisar");
        botaoPesquisarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPesquisarClienteMouseClicked(evt);
            }
        });
        botaoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(botaoPesquisarCliente, gridBagConstraints);

        labelCliente.setText("CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(labelCliente, gridBagConstraints);

        comboTipoCarrinho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PRODUTO", "SERVIÇO" }));
        comboTipoCarrinho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoCarrinhoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(comboTipoCarrinho, gridBagConstraints);

        campoCodigo.setMinimumSize(new java.awt.Dimension(90, 24));
        campoCodigo.setPreferredSize(new java.awt.Dimension(90, 24));
        campoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mudarCampo(evt);
            }
        });
        campoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                digitarCampo(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(campoCodigo, gridBagConstraints);

        botaoPesquisaItem.setText("P");
        botaoPesquisaItem.setPreferredSize(new java.awt.Dimension(26, 26));
        botaoPesquisaItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPesquisaItemMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        getContentPane().add(botaoPesquisaItem, gridBagConstraints);

        botaoAdd.setText("Adicionar");
        botaoAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicarBotaoAdicionar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(botaoAdd, gridBagConstraints);

        scrollItens.setMinimumSize(new java.awt.Dimension(500, 200));
        scrollItens.setPreferredSize(new java.awt.Dimension(500, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(scrollItens, gridBagConstraints);

        botaoRemover.setText("Remover");
        botaoRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicarRemover(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(botaoRemover, gridBagConstraints);

        labelTotal.setFont(new java.awt.Font("Ubuntu", 0, 18));
        labelTotal.setForeground(new java.awt.Color(225, 1, 1));
        labelTotal.setText("Total 00.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(labelTotal, gridBagConstraints);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(botaoCancelar, gridBagConstraints);

        botaoPagar.setText("Pagar");
        botaoPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(botaoPagar, gridBagConstraints);

        comboAnimais.setMinimumSize(new java.awt.Dimension(110, 24));
        comboAnimais.setPreferredSize(new java.awt.Dimension(110, 24));
        comboAnimais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mudarComboAnimal(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        getContentPane().add(comboAnimais, gridBagConstraints);

        campoQtde.setMinimumSize(new java.awt.Dimension(50, 24));
        campoQtde.setPreferredSize(new java.awt.Dimension(50, 24));
        campoQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mudarCampo(evt);
            }
        });
        campoQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                digitarCampo(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(campoQtde, gridBagConstraints);

        labelCodigo.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(labelCodigo, gridBagConstraints);

        labelQtde.setText("Qtde");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(labelQtde, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPesquisarClienteActionPerformed

    private void comboTipoCarrinhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoCarrinhoItemStateChanged
        if(comboTipoCarrinho.getSelectedIndex() == 0){
            comboAnimais.setVisible(false);
            campoQtde.setVisible(true);
            scrollItens.setViewportView(tabelaProdutos);
            labelQtde.setText("Qtde");
            verificarBotaoRemover(tabelaProdutos);
        } else {
            comboAnimais.setVisible(true);
            campoQtde.setVisible(false);
            scrollItens.setViewportView(tabelaServicos);
            labelQtde.setText("Animais");
            verificarBotaoRemover(tabelaServicos);
        }

        campoCodigo.setText("");
        digitarCampo(null);
    }//GEN-LAST:event_comboTipoCarrinhoItemStateChanged

    private void botaoPesquisaItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaItemMouseClicked
        if(botaoPesquisaItem.isEnabled()){
            JanelaAdiciona adiciona;

            if(comboTipoCarrinho.getSelectedIndex() == 0) {
                adiciona = adicionaProduto;
            } else {
                adiciona = adicionaServico;
            }


            adiciona.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
            adiciona.setModal(true);
            adiciona.setVisible(true);
        }
    }//GEN-LAST:event_botaoPesquisaItemMouseClicked

    private void botaoPesquisarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisarClienteMouseClicked
        if(botaoPesquisarCliente.isEnabled()){
            adicionaCliente.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
            adicionaCliente.setModal(true);
            adicionaCliente.setVisible(true);
        }
    }//GEN-LAST:event_botaoPesquisarClienteMouseClicked

    private void pagar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagar
        if(botaoPagar.isEnabled() && !existemDependencias()){
            JanelaPagamento cadastro = new JanelaPagamento(this);

            cadastro.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
            cadastro.setModal(true);
            cadastro.setVisible(true);
        }
    }//GEN-LAST:event_pagar

    private void cancelar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar
        cancelar();
    }//GEN-LAST:event_cancelar

    private void mudarCampo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mudarCampo
        if(!campoQtde.getText().equals("")
                || !campoCodigo.getText().equals("")){
            botaoAdd.setVisible(true);
        } else {
            botaoAdd.setVisible(false);
        }
    }//GEN-LAST:event_mudarCampo

    private void digitarCampo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_digitarCampo
        if(this.comboTipoCarrinho.getSelectedItem().equals("PRODUTO")){
            if((campoQtde.getText().equals("")
                    || campoQtde.getText().equals(""))
                    || ((campoCodigo.getText().equals("")
                    || campoCodigo.getText().equals("")))){
                botaoAdd.setVisible(false);
            } else {
                botaoAdd.setVisible(true);
            }
        } else {
            if((comboAnimais.getSelectedIndex() == 0)
                    || ((campoCodigo.getText().equals("")
                    || campoCodigo.getText().equals("")))){
                botaoAdd.setVisible(false);
            } else {
                botaoAdd.setVisible(true);
            }
        }
    }//GEN-LAST:event_digitarCampo

    private void clicarBotaoAdicionar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicarBotaoAdicionar
        if(botaoAdd.isVisible()){
            if(this.comboTipoCarrinho.getSelectedItem().equals("PRODUTO")){
                Produto produto;
                try {
                    produto = BancoDeDados.consultar(new Produto(Integer.valueOf(campoCodigo.getText())))[0];
                } catch(ArrayIndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(this, "Este produto não existe!");
                    return;
                }

                int qtde = Integer.valueOf(campoQtde.getText());

                if(produto.getQtdeEstoque() < qtde){
                    JOptionPane.showMessageDialog(this, "A quantidade é maior que o estoque deste produto!");
                    return;
                }

                Object[] dados = new Object[4];
                dados[0] = produto.getCodigo();
                dados[1] = produto.getNome();
                dados[2] = qtde;
                dados[3] = formatoDecimal.format(produto.getPrecoVenda());

                setTotal((produto.getPrecoVenda() * qtde) + total);

                DefaultTableModel model = (DefaultTableModel) this.tabelaProdutos.getModel();

                boolean existeProduto = false;
                for(int i = 0; i < model.getRowCount(); i++){
                    int codigo = (Integer) model.getValueAt(i, 0);
                    if(codigo == produto.getCodigo()){
                        int q = (Integer) model.getValueAt(i, 2);
                        if(produto.getQtdeEstoque() < q + qtde){
                            JOptionPane.showMessageDialog(this, "A quantidade é maior que o estoque deste produto!");
                            return;
                        }
                        model.setValueAt(q + qtde, i, 2);
                        venda.getCarrinhoProdutos().getQtde().set(i, venda.getCarrinhoProdutos().getQtde().get(i) + qtde);
                        existeProduto = true;
                    }
                }

                if(!existeProduto){
                    model.addRow(dados);
                    redimensionarColunas(tabelaProdutos);
                    venda.getCarrinhoProdutos().add(produto, qtde);
                }

            } else {
                Servico servico;
                try {
                    servico = BancoDeDados.consultar(new Servico(Integer.valueOf(campoCodigo.getText())))[0];
                } catch(ArrayIndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(this, "Este serviço não existe!");
                    return;
                }

                Object[] dados = new Object[4];
                dados[0] = servico.getCodigo();
                dados[1] = servico.getNome();
                dados[2] = cliente.getAnimais()[comboAnimais.getSelectedIndex() - 1].getNome();
                dados[3] = formatoDecimal.format(servico.getPrecoVenda());

                setTotal(servico.getPrecoVenda() + total);

                DefaultTableModel model = (DefaultTableModel) this.tabelaServicos.getModel();


                boolean existeServico = false;
                for(int i = 0; i < model.getRowCount(); i++){
                    int codigo = (Integer) model.getValueAt(i, 0);
                    if(codigo == servico.getCodigo()){
                        String animal = (String) model.getValueAt(i, 2);
                        if(animal.equals(comboAnimais.getSelectedItem())){
                            JOptionPane.showMessageDialog(this, "Este servico já foi adicionado!");
                            existeServico = true;
                        }
                    }
                }

                if(!existeServico){
                    model.addRow(dados);
                    redimensionarColunas(tabelaServicos);
                }

                venda.getCarrinhoServicos().add(servico, cliente.getAnimais()[comboAnimais.getSelectedIndex() - 1]);
            }
            botaoAdd.setEnabled(false);
            campoCodigo.setText("");
            campoQtde.setText("");
            comboAnimais.setSelectedIndex(0);
        }
    }//GEN-LAST:event_clicarBotaoAdicionar

    private void mudarComboAnimal(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mudarComboAnimal
        if(comboAnimais.getSelectedIndex() > 0){
            if(campoCodigo.getText().equals("")) {
                botaoAdd.setVisible(false);
            } else {
                botaoAdd.setVisible(true);
            }
        } else {
            botaoAdd.setVisible(false);
        }
    }//GEN-LAST:event_mudarComboAnimal

    private void clicarRemover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicarRemover
        if(botaoRemover.isVisible()){
            JTable tabela;
            if(comboTipoCarrinho.getSelectedItem().equals("PRODUTO")) {
                tabela = tabelaProdutos;
            } else {
                tabela = tabelaServicos;
            }

            DefaultTableModel model = (DefaultTableModel) tabela.getModel();

            String preco = (String) tabela.getValueAt(tabela.getSelectedRow(), 3);
            String qtde = (String) tabela.getValueAt(tabela.getSelectedRow(), 2);
            setTotal(total - (Double.valueOf(preco) * Integer.valueOf(qtde)));

            int codigo = (Integer) tabela.getValueAt(tabela.getSelectedRow(), 0);

            if(tabela.equals(tabelaProdutos)) {
                venda.getCarrinhoProdutos().remove(codigo);
            } else {
                venda.getCarrinhoServicos().remove(codigo);
            }

            model.removeRow(tabela.getSelectedRow());
        }
    }//GEN-LAST:event_clicarRemover

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JanelaVenda(TipoJanela.CADASTRO, null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdd;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoPagar;
    private javax.swing.JButton botaoPesquisaItem;
    private javax.swing.JButton botaoPesquisarCliente;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoQtde;
    private javax.swing.JComboBox comboAnimais;
    private javax.swing.JComboBox comboTipoCarrinho;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelQtde;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JScrollPane scrollItens;
    // End of variables declaration//GEN-END:variables

    /**
     * Configura o label de total na janela. 
     * @param valor O valor do total de compras
     */
    public void setTotal(double valor) {
        total = valor;
        labelTotal.setText("Total R$ " + formatoDecimal.format(valor));
    }

    protected final void reiniciar() {

        labelCliente.setText("CLIENTE");
        comboTipoCarrinho.setSelectedIndex(0);
        campoCodigo.setText("");
        campoQtde.setText("");
        labelQtde.setText("Qtde");
        comboAnimais.setVisible(false);
        comboAnimais.setModel(new javax.swing.DefaultComboBoxModel(
                new String[]{"ANIMAL"}));

        //remove todos os elementos das tabelas de serviços e produtos.
        ((DefaultTableModel) tabelaProdutos.getModel()).getDataVector().removeAllElements();
        ((DefaultTableModel) tabelaServicos.getModel()).getDataVector().removeAllElements();

        setTotal(0.0);
        botaoAdd.setVisible(false);
        botaoRemover.setVisible(false);

        desabilitarCampos();

        tabelaProdutos.updateUI();
        tabelaServicos.updateUI();
    }

    protected final void desabilitarCampos() {
        if(tipo == TipoJanela.INFORMACAO){
            botaoPagar.setVisible(false);
            botaoCancelar.setVisible(false);
            botaoPesquisarCliente.setEnabled(false);
        } else {
            botaoPagar.setEnabled(false);
            comboTipoCarrinho.setEnabled(false);
            comboAnimais.setEnabled(false);
        }

        botaoRemover.setVisible(false);
        botaoAdd.setVisible(false);
        tabelaProdutos.setEnabled(false);
        tabelaServicos.setEnabled(false);
        campoCodigo.setEnabled(false);         
        campoQtde.setEnabled(false);
        botaoPesquisaItem.setEnabled(false);
    }

    private void setModelo(JTable tabela, String[] modelo, double[] porcentagemTamanhoColunas) {

        //Override o metodo isCellEditable para nao deixar editar as celulas da tabela.
        tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, modelo) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.porcentagemTamanhoColunas = porcentagemTamanhoColunas;

        redimensionarColunas(tabela);
    }

    private void redimensionarColunas(JTable tabela) {
        double t = scrollItens.getWidth();

        for(int i = 0; i < porcentagemTamanhoColunas.length; i++){
            tabela.getColumnModel().getColumn(i).setPreferredWidth((int) ((porcentagemTamanhoColunas[i] * t) / 100));
        }
    }

    public void setCliente(Cliente c) {
        //se ja foi adicionado cliente anteriormente...
        if(cliente != null){
            reiniciar();
        }
        botaoPesquisaItem.setEnabled(true);
        campoCodigo.setEnabled(true);
        comboTipoCarrinho.setEnabled(true);
        comboAnimais.setEnabled(true);
        campoQtde.setEnabled(true);
        botaoPagar.setEnabled(true);

        labelCliente.setText(c.getNome());
        for(int i = 0; i < c.getAnimais().length; i++){
            comboAnimais.addItem(c.getAnimais()[i].getNome());
        }
        this.cliente = c;
    }

    public void adicionar(Produto p, int qtde) {
        venda.getCarrinhoProdutos().add(p, qtde);
        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        modelo.addRow(new Object[]{p.getCodigo(), p.getNome(), qtde,
                    formatoDecimal.format(p.getPrecoVenda())});
    }

    public void adicionar(Servico s, Animal a) {
        venda.getCarrinhoServicos().add(s, a);
        DefaultTableModel modelo = (DefaultTableModel) tabelaServicos.getModel();
        modelo.addRow(new Object[]{s.getCodigo(), s.getNome(), a.getNome(),
                    formatoDecimal.format(s.getPrecoVenda())});

    }

    public void verificarBotaoRemover(JTable tabela) {
        if(tabela.getSelectedRow() != -1) {
            botaoRemover.setVisible(true);
        } else {
            botaoRemover.setVisible(false);
        }
    }

    protected Venda gerarVenda(TipoPagamento tipo, boolean isParcelado) {

        venda.setTipoPagamento(tipo);
        venda.setCliente(cliente);
        String[] data = getDateTime().split("/");
        GregorianCalendar hoje = new GregorianCalendar(Integer.valueOf(data[2]),
                Integer.valueOf(data[1]), Integer.valueOf(data[0]));
        venda.setData(hoje);
        venda.setParcelado(isParcelado);

        return venda;
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    protected final void preencher() {
        labelCliente.setText(venda.getCliente().getNome());
        setTotal(venda.total());

        Animal[] a = BancoDeDados.getAnimais(venda.getCliente());
        for(int i = 0; i < a.length; i++){
            comboAnimais.addItem(a[i].getNome());
        }

        DefaultTableModel modeloServicos = (DefaultTableModel) tabelaServicos.getModel();
        DefaultTableModel modeloProdutos = (DefaultTableModel) tabelaProdutos.getModel();

        for(int i = 0; i < venda.getCarrinhoProdutos().getProdutos().size(); i++){
            Object[] dados = new Object[4];
            dados[0] = venda.getCarrinhoProdutos().getProdutos().get(i).getCodigo();
            dados[1] = venda.getCarrinhoProdutos().getProdutos().get(i).getNome();
            dados[2] = venda.getCarrinhoProdutos().getQtde().get(i);
            dados[3] = venda.getCarrinhoProdutos().getProdutos().get(i).getPrecoVenda();
            modeloProdutos.addRow(dados);
        }
        for(int i = 0; i < venda.getCarrinhoServicos().getServicos().size(); i++){
            Object[] dados = new Object[4];
            dados[0] = venda.getCarrinhoServicos().getServicos().get(i).getCodigo();
            dados[1] = venda.getCarrinhoServicos().getServicos().get(i).getNome();
            dados[2] = venda.getCarrinhoServicos().getAnimal().get(i).getNome();
            dados[3] = venda.getCarrinhoServicos().getServicos().get(i).getPrecoVenda();
            modeloServicos.addRow(dados);
        }
    }

    protected boolean existemDependencias() {
        boolean existemDependencias = false;

        if(total == 0){
            JOptionPane.showMessageDialog(this, "A venda está vazia");
            existemDependencias = true;
        }

        return existemDependencias;
    }

    protected void cadastrar() {
    }

    protected void alterar() {
    }

    public void setCodigo(int codigo) {
        campoCodigo.setText(String.valueOf(codigo));
        if(comboAnimais.getSelectedIndex() > 0){
            botaoAdd.setVisible(true);
        }

        reiniciar();
    }
}
