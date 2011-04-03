package petshop.interfaces;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;


public class JanelaCadastroAnimais extends javax.swing.JDialog {

    public JanelaCadastroAnimais() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        campoNome = new javax.swing.JTextField();
        campoRaca = new javax.swing.JTextField();
        comboEspecie = new javax.swing.JComboBox();
        botaoLimpar = new javax.swing.JButton();
        campoDataNasc = new javax.swing.JTextField();
        botaoCadastrar = new javax.swing.JButton();
        comboSexo = new javax.swing.JComboBox();
        scrollInformacoes = new javax.swing.JScrollPane();
        areaInformacoes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Animal");
        setMinimumSize(new java.awt.Dimension(450, 280));
        setResizable(false);

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 115;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoNome, gridBagConstraints);

        campoRaca.setText("Raça");
        campoRaca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoRaca, gridBagConstraints);

        comboEspecie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Espécie", "Cão", "Gato", "Ave", "Roedor" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(comboEspecie, gridBagConstraints);

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

        campoDataNasc.setText("Data de Nascimento");
        campoDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
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
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoDataNasc, gridBagConstraints);

        botaoCadastrar.setText("Cadastrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(botaoCadastrar, gridBagConstraints);

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sexo", "Macho", "Fêmea" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(comboSexo, gridBagConstraints);

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
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(scrollInformacoes, gridBagConstraints);

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
                new JanelaCadastroAnimais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInformacoes;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JTextField campoDataNasc;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoRaca;
    private javax.swing.JComboBox comboEspecie;
    private javax.swing.JComboBox comboSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollInformacoes;
    // End of variables declaration//GEN-END:variables


    //Retorna a etiqueta certa pra cada campo
    private String getEtiqueta(JTextComponent campo){

        if(campo.equals(campoNome)) return "Nome";
        else if(campo.equals(campoDataNasc)) return "Data de Nascimento";
        else if(campo.equals(campoRaca)) return "Raça";
        else if(campo.equals(areaInformacoes)) return "Informações Adicionais";

        return "";
    }

    //Volta todos os campos pras etiquetas padrões.
    private void limparCampos(){

        campoNome.setText("Nome");
        comboSexo.setSelectedIndex(0);
        comboEspecie.setSelectedIndex(0);
        campoDataNasc.setText("Data de Nascimento");
        campoRaca.setText("Raça");
        areaInformacoes.setText("Informações Adicionais");
    }
}
