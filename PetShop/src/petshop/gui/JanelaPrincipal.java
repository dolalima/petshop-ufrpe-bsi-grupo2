/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaPrincipal.java
 *
 * Created on Apr 7, 2011, 1:45:47 PM
 */

package petshop.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import petshop.classes.BancoDeDados;

/**
 *
 * @author arthur
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private PainelConsultaClientes painelClientes;
    private PainelConsultaProdutos painelProdutos;
    private PainelConsultaServicos painelServicos;
    private PainelConsultaVendas painelVendas;

    /** Creates new form JanelaPrincipal */
    public JanelaPrincipal() {
        initComponents();
        this.setTitle("Menu Principal");
        
        painelClientes = new PainelConsultaClientes();
        painelProdutos = new PainelConsultaProdutos();
        painelServicos = new PainelConsultaServicos();
        painelVendas = new PainelConsultaVendas();
        
        painelSplit.setRightComponent(painelClientes);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(700,450);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelSplit = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        botaoClientes = new javax.swing.JButton();
        botaoProdutos = new javax.swing.JButton();
        botaoServicos = new javax.swing.JButton();
        botaoVendas = new javax.swing.JButton();
        MenuPricipal = new javax.swing.JMenuBar();
        MenuSistema = new javax.swing.JMenu();
        MenuItemLogout = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 450));

        painelSplit.setDividerLocation(170);
        painelSplit.setDividerSize(0);
        painelSplit.setMinimumSize(new java.awt.Dimension(170, 400));
        painelSplit.setPreferredSize(new java.awt.Dimension(700, 350));

        jPanel1.setMinimumSize(new java.awt.Dimension(170, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(170, 400));

        botaoClientes.setText("Clientes");
        botaoClientes.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoClientesMouseClicked(evt);
            }
        });
        jPanel1.add(botaoClientes);

        botaoProdutos.setText("Produtos");
        botaoProdutos.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoProdutosMouseClicked(evt);
            }
        });
        jPanel1.add(botaoProdutos);

        botaoServicos.setText("Serviços");
        botaoServicos.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoServicosMouseClicked(evt);
            }
        });
        jPanel1.add(botaoServicos);

        botaoVendas.setText("Vendas");
        botaoVendas.setPreferredSize(new java.awt.Dimension(150, 40));
        botaoVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoVendasMouseClicked(evt);
            }
        });
        jPanel1.add(botaoVendas);

        painelSplit.setLeftComponent(jPanel1);

        getContentPane().add(painelSplit, java.awt.BorderLayout.CENTER);

        MenuSistema.setText("Sistema");

        MenuItemLogout.setText("Logout");
        MenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicarMenuLogout(evt);
            }
        });
        MenuSistema.add(MenuItemLogout);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuSistema.add(jMenuItem1);

        MenuPricipal.add(MenuSistema);

        setJMenuBar(MenuPricipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoClientesMouseClicked
        if(!painelSplit.getRightComponent().equals(painelClientes)){
            painelSplit.setRightComponent(painelClientes);
        }
}//GEN-LAST:event_botaoClientesMouseClicked

    private void botaoProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoProdutosMouseClicked
        if(!painelSplit.getRightComponent().equals(painelProdutos)){
            painelSplit.setRightComponent(painelProdutos);
        }
}//GEN-LAST:event_botaoProdutosMouseClicked

    private void botaoServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoServicosMouseClicked
        if(!painelSplit.getRightComponent().equals(painelServicos)){
            painelSplit.setRightComponent(painelServicos);
        }
    }//GEN-LAST:event_botaoServicosMouseClicked

    private void botaoVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoVendasMouseClicked
        if(!painelSplit.getRightComponent().equals(painelVendas)){
            painelSplit.setRightComponent(painelVendas);
        }
    }//GEN-LAST:event_botaoVendasMouseClicked

    private void clicarMenuLogout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicarMenuLogout
        int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja fazer logout?", "Logout", JOptionPane.YES_NO_OPTION);

        if(resp == JOptionPane.YES_OPTION){
            JanelaLogin janela = new JanelaLogin();

            //JanelaPrincipal janela = new JanelaPrincipal();

            // Get the size of the screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            // Determine the new location of the window
            int w = janela.getSize().width;
            int h = janela.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;

            // Move the window
            janela.setLocation(x, y);
            janela.setVisible(true);

        }
    }//GEN-LAST:event_clicarMenuLogout

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair do programa?", "Sair", JOptionPane.YES_NO_OPTION);

        if(resp == JOptionPane.YES_OPTION){
            try {
                BancoDeDados.connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemLogout;
    private javax.swing.JMenuBar MenuPricipal;
    private javax.swing.JMenu MenuSistema;
    private javax.swing.JButton botaoClientes;
    private javax.swing.JButton botaoProdutos;
    private javax.swing.JButton botaoServicos;
    private javax.swing.JButton botaoVendas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane painelSplit;
    // End of variables declaration//GEN-END:variables

    public void cadastrarCliente(){

    }
}
