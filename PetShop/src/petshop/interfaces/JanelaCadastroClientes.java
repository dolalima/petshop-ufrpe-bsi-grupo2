package petshop.interfaces;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class JanelaCadastroClientes extends javax.swing.JDialog {

	
	public JanelaCadastroClientes() {
        initComponents();
    }


    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        campoNome = new javax.swing.JTextField();
        comboSexo = new javax.swing.JComboBox();
        campoTelefone = new javax.swing.JTextField();
        campoCelular = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        campoNumero = new javax.swing.JTextField();
        campoComplemento = new javax.swing.JTextField();
        campoBairro = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        comboUF = new javax.swing.JComboBox();
        campoCEP = new javax.swing.JTextField();
        campoRG = new javax.swing.JTextField();
        campoCPF = new javax.swing.JTextField();
        campoEMail = new javax.swing.JTextField();
        scrollInformacoes = new javax.swing.JScrollPane();
        areaInformacoes = new javax.swing.JTextArea();
        botaoLimpar = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        comboAnimais = new javax.swing.JComboBox();
        botaoAddAnimal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Cliente");
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
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoNome, gridBagConstraints);

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sexo", "Masculino", "Feminino" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(comboSexo, gridBagConstraints);

        campoTelefone.setText("Telefone");
        campoTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoTelefone, gridBagConstraints);

        campoCelular.setText("Celular");
        campoCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoCelular, gridBagConstraints);

        campoEndereco.setText("Endereço");
        campoEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
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
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoEndereco, gridBagConstraints);

        campoNumero.setText("Número");
        campoNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoNumero, gridBagConstraints);

        campoComplemento.setText("Complemento");
        campoComplemento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoComplemento, gridBagConstraints);

        campoBairro.setText("Bairro");
        campoBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoBairro, gridBagConstraints);

        campoCidade.setText("Cidade");
        campoCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoCidade, gridBagConstraints);

        comboUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "GO", "ES", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SP", "SC", "SE", "TO" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(comboUF, gridBagConstraints);

        campoCEP.setText("CEP");
        campoCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoCEP, gridBagConstraints);

        campoRG.setText("RG");
        campoRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoRG, gridBagConstraints);

        campoCPF.setText("CPF");
        campoCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(campoCPF, gridBagConstraints);

        campoEMail.setText("e-Mail");
        campoEMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPerdeEtiqueta(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRetornaEtiqueta(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(campoEMail, gridBagConstraints);

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
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        jPanel1.add(scrollInformacoes, gridBagConstraints);

        botaoLimpar.setText("Limpar");
        botaoLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparCampos(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(botaoLimpar, gridBagConstraints);

        botaoCadastrar.setText("Cadastrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(botaoCadastrar, gridBagConstraints);

        comboAnimais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Animais" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(comboAnimais, gridBagConstraints);

        botaoAddAnimal.setText("Adicionar");
        botaoAddAnimal.setMinimumSize(null);
        botaoAddAnimal.setPreferredSize(null);
        botaoAddAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoAddAnimalMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        jPanel1.add(botaoAddAnimal, gridBagConstraints);

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

    private void botaoAddAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoAddAnimalMouseClicked
        JanelaCadastroAnimais animal = new JanelaCadastroAnimais();
        
        animal.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        animal.setVisible(true);
    }//GEN-LAST:event_botaoAddAnimalMouseClicked
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInformacoes;
    private javax.swing.JButton botaoAddAnimal;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoCEP;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoCelular;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JTextField campoEMail;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoRG;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JComboBox comboAnimais;
    private javax.swing.JComboBox comboSexo;
    private javax.swing.JComboBox comboUF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollInformacoes;
    // End of variables declaration//GEN-END:variables

    //Retorna a etiqueta certa pra cada campo
    private String getEtiqueta(JTextComponent campo){
        
        if(campo.equals(campoNome)) return "Nome";
        else if(campo.equals(campoEndereco)) return "Endereço";
        else if(campo.equals(campoNumero)) return "Número";
        else if(campo.equals(campoComplemento)) return "Complemento";
        else if(campo.equals(campoBairro)) return "Bairro";
        else if(campo.equals(campoCidade)) return "Cidade";
        else if(campo.equals(campoCEP)) return "CEP";
        else if(campo.equals(campoRG)) return "RG";
        else if(campo.equals(campoCPF)) return "CPF";
        else if(campo.equals(campoEMail)) return "e-Mail";
        else if(campo.equals(campoTelefone)) return "Telefone";
        else if(campo.equals(campoCelular)) return "Celular";
        else if(campo.equals(areaInformacoes)) return "Informações Adicionais";
        
        return "";
    }

    //Volta todos os campos pras etiquetas padrões.
    private void limparCampos(){

        campoNome.setText("Nome");
        comboSexo.setSelectedIndex(0);
        campoEndereco.setText("Endereco");
        campoNumero.setText("Numero");
        campoComplemento.setText("Complemento");
        campoBairro.setText("Bairro");
        campoCidade.setText("Cidade");
        comboUF.setSelectedIndex(0);
        campoCEP.setText("CEP");
        campoRG.setText("RG");
        campoCPF.setText("CPF");
        campoEMail.setText("e-Mail");
        campoTelefone.setText("Telefone");
        campoCelular.setText("Celular");
        comboAnimais.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Animais"}));
        areaInformacoes.setText("Informações Adicionais");
    }
}
