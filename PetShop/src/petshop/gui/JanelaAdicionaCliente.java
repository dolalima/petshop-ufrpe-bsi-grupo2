/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaAdicionaCliente.java
 *
 * Created on Apr 8, 2011, 6:50:48 PM
 */

package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.CPF;
import petshop.classes.Cliente;

/**
 *
 * @author arthur
 */
public class JanelaAdicionaCliente extends JanelaAdiciona {

    JanelaVenda pai;

    /** Creates new form JanelaAdicionaCliente */
    public JanelaAdicionaCliente(JanelaVenda janelaVenda) {
        pai = janelaVenda;

        initComponents();

        setTitle("Adicionar Cliente");
        
        String[] modelo = new String[] {"Código", "Nome", "CPF", "RG"};
        double[] tamanhosColunas = new double[] {12, 50, 22, 16};
        
        painel.setModelo(modelo, tamanhosColunas);

        this.painel.botaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisar();
            }
        });
            
        this.botaoOK.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(botaoOK.isEnabled()){
                    Number valor = (Number) painel.tabela.getValueAt(painel.tabela.getSelectedRow(), 0);
                    ok(valor.intValue());
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaAdicionaCliente(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void pesquisar(){
        Cliente c = new Cliente();

        if(!painel.campoPesquisa.getText().equals("")){
            if(painel.comboPesquisa.getSelectedIndex() == 0){
                c.setCodigo(Integer.valueOf(painel.campoPesquisa.getText()));
            } else if(painel.comboPesquisa.getSelectedIndex() == 1){
                c.setNome(painel.campoPesquisa.getText());
            } else if(painel.comboPesquisa.getSelectedIndex() == 2){
                c.setCpf(new CPF(painel.campoPesquisa.getText()));
            } else if(painel.comboPesquisa.getSelectedIndex() == 3){
                c.setRg(Integer.valueOf(painel.campoPesquisa.getText()));
            }
        }

        Cliente[] clientes = BancoDeDados.consultar(c);
        Object[][] dados = new Object[clientes.length][4];

        for(int i = 0; i < clientes.length; i++){
            dados[i][0] = clientes[i].getCodigo();
            dados[i][1] = clientes[i].getNome();
            dados[i][2] = clientes[i].getCpf().toString();
            dados[i][3] = clientes[i].getRg();
        }

        DefaultTableModel model = (DefaultTableModel) this.painel.tabela.getModel();

        model.setDataVector(dados, painel.modelo);

        painel.redimensionarColunas();

        if(clientes.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }
    

    private void ok(int cod) {
        pai.setCliente(BancoDeDados.consultar(new Cliente(cod))[0]);
        reiniciar();

        this.dispose();
    }
}
