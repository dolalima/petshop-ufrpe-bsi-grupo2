package petshop.interfaces;

public class JanelaLogin extends javax.swing.JFrame {

    public JanelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        campoLogin = new javax.swing.JTextField();
        campoSenha = new javax.swing.JTextField();
        botaoEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Pet Shop");
        setMinimumSize(new java.awt.Dimension(250, 380));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        campoLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoLogin.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        getContentPane().add(campoLogin, gridBagConstraints);

        campoSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoSenha.setText("Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        getContentPane().add(campoSenha, gridBagConstraints);

        botaoEntrar.setText("Entrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(botaoEntrar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoSenha;
    // End of variables declaration//GEN-END:variables

}
