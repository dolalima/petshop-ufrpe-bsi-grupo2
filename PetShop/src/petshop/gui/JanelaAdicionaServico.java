/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaAdicionaServico.java
 *
 * Created on Apr 8, 2011, 7:39:11 PM
 */

package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.Servico;

/**
 *
 * @author arthur
 */
public class JanelaAdicionaServico extends JanelaAdiciona {

    JanelaVenda pai;

    /** Creates new form JanelaAdicionaCliente */
    public JanelaAdicionaServico(JanelaVenda janelaVenda) {
        pai = janelaVenda;

        setTitle("Adicionar Serviço");
        
        String[] modelo = new String[] {"Código", "Nome"};
        double[] tamanhosColunas = new double[] {30, 70};

        painel.setModelo(modelo, tamanhosColunas);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaAdicionaServico(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void pesquisar() {
        Servico s = new Servico();

        if(painel.comboPesquisa.getSelectedIndex() == 0){
            s.setCodigo(Integer.valueOf(painel.campoPesquisa.getText()));
        } else if(painel.comboPesquisa.getSelectedIndex() == 1){
            s.setNome(painel.campoPesquisa.getText());
        }

        Servico[] servicos = BancoDeDados.consultar(s);
        Object[][] dados = new Object[servicos.length][4];

        for(int i = 0; i < servicos.length; i++){
            dados[i][0] = servicos[i].getCodigo();
            dados[i][1] = servicos[i].getNome();
        }

        DefaultTableModel model = (DefaultTableModel) this.painel.tabela.getModel();

        model.setDataVector(dados, painel.modelo);
        painel.redimensionarColunas();

        if(servicos.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }
}
