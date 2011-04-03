package petshop.interfaces;

import javax.swing.JFrame;


public class JanelaPrincipal extends javax.swing.JFrame {

    public JanelaPrincipal() {
        initComponents();
        this.setTitle("Menu Principal");
        
        PainelConsulta painelAnimais = new PainelConsulta();
        painelSplit.setRightComponent(painelAnimais);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(700,450);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSplit = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        MenuPricipal = new javax.swing.JMenuBar();
        MenuSistema = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        MenuItemLogout = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuCliente = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 450));

        painelSplit.setDividerLocation(170);
        painelSplit.setDividerSize(0);
        painelSplit.setMinimumSize(new java.awt.Dimension(170, 400));
        painelSplit.setPreferredSize(new java.awt.Dimension(700, 350));

        jPanel1.setMinimumSize(new java.awt.Dimension(170, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(170, 400));

        jButton1.setText("Clientes");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(jButton1);

        jButton2.setText("Produtos");
        jButton2.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(jButton2);

        jButton3.setText("Serviços");
        jButton3.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(jButton3);

        jButton4.setText("Vendas");
        jButton4.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(jButton4);

        painelSplit.setLeftComponent(jPanel1);

        getContentPane().add(painelSplit, java.awt.BorderLayout.CENTER);

        MenuSistema.setText("Sistema");

        jMenuItem6.setText("Vendas de Produtos");
        MenuSistema.add(jMenuItem6);

        jMenuItem7.setText("Vendas de Serviços");
        MenuSistema.add(jMenuItem7);

        MenuItemLogout.setText("Logout");
        MenuSistema.add(MenuItemLogout);

        jMenuItem1.setText("Sair");
        MenuSistema.add(jMenuItem1);

        MenuPricipal.add(MenuSistema);

        MenuCliente.setText("Cliente");

        jMenuItem3.setText("Consultar");
        MenuCliente.add(jMenuItem3);

        jMenuItem2.setText("Cadastrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuCliente.add(jMenuItem2);

        jMenuItem4.setText("Modificar");
        MenuCliente.add(jMenuItem4);

        jMenuItem5.setText("Exluir");
        MenuCliente.add(jMenuItem5);

        MenuPricipal.add(MenuCliente);

        jMenu1.setText("Produto");
        MenuPricipal.add(jMenu1);

        setJMenuBar(MenuPricipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCliente;
    private javax.swing.JMenuItem MenuItemLogout;
    private javax.swing.JMenuBar MenuPricipal;
    private javax.swing.JMenu MenuSistema;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane painelSplit;
    // End of variables declaration//GEN-END:variables

}
