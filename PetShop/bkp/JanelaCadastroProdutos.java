package petshop.interfaces;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class JanelaCadastroProdutos extends javax.swing.JDialog {

    public JanelaCadastroProdutos() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        campoNome = new javax.swing.JTextField();
        campoQtde = new javax.swing.JTextField();
        campoPrecoCusto = new javax.swing.JTextField();
        scrollInformacoes = new javax.swing.JScrollPane();
        areaInformacoes = new javax.swing.JTextArea();
        botaoCadastrar = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        campoPrecoVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Produto");
        setMinimumSize(new java.awt.Dimension(450, 280));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(320, 200));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        campoNome.setText("Nome");
        campoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoNome, gridBagConstraints);

        campoQtde.setText("Qtde");
        campoQtde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoQtde, gridBagConstraints);

        campoPrecoCusto.setText("Preço de Custo");
        campoPrecoCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoPrecoCusto, gridBagConstraints);

        areaInformacoes.setColumns(20);
        areaInformacoes.setRows(5);
        areaInformacoes.setText("Informações Adicionais");
        areaInformacoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        scrollInformacoes.setViewportView(areaInformacoes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(scrollInformacoes, gridBagConstraints);

        botaoCadastrar.setText("Cadastrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(botaoCadastrar, gridBagConstraints);

        botaoLimpar.setText("Limpar");
        botaoLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparCampos(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(botaoLimpar, gridBagConstraints);

        campoPrecoVenda.setText("Preço de Venda");
        campoPrecoVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoPrecoVenda, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Quando o campo perde o foco e esta vazio, a etiqueta volta
    private void campoRetornaEtiqueta(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRetornaEtiqueta
        JTextComponent campo = (JTextComponent) evt.getComponent();

        if(campo.getText().equals("")){
            campo.setText(getEtiqueta(campo));
        }
    }//GEN-LAST:event_campoRetornaEtiqueta

    //Quando um campo é clicado a etiqueta some, case esteja ativa
    private void campoPerdeEtiqueta(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPerdeEtiqueta
        JTextComponent campo = (JTextComponent) evt.getComponent();

        if(campo.getText().equals(getEtiqueta(campo))){
            campo.setText("");
        }
    }//GEN-LAST:event_campoPerdeEtiqueta

    //Evento do botaoLimpar
    private void limparCampos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limparCampos
        int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja limpar todos os campos?", "Sair", JOptionPane.YES_NO_OPTION);

        if(resp == JOptionPane.YES_OPTION)
            limparCampos();
    }//GEN-LAST:event_limparCampos


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInformacoes;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPrecoCusto;
    private javax.swing.JTextField campoPrecoVenda;
    private javax.swing.JTextField campoQtde;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollInformacoes;
    // End of variables declaration//GEN-END:variables


    //Retorna a etiqueta certa pra cada campo
    private String getEtiqueta(JTextComponent campo){

        if(campo.equals(campoNome)) return "Nome";
        else if(campo.equals(campoPrecoCusto)) return "Preço de Custo";
        else if(campo.equals(campoPrecoVenda)) return "Preço de Venda";
        else if(campo.equals(campoQtde)) return "Qtde";
        else if(campo.equals(areaInformacoes)) return "Informações Adicionais";

        return "";
    }

    //Volta todos os campos pras etiquetas padrões.
    private void limparCampos(){

        campoNome.setText("Nome");
        campoPrecoCusto.setText("Preço de Custo");
        campoPrecoVenda.setText("Preço de Venda");
        campoQtde.setText("Qtde");
        areaInformacoes.setText("Informações Adicionais");
    }
}
