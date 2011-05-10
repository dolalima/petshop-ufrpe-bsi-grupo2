/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop.gui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author arthur
 */
public abstract class Janela extends JDialog{

    protected abstract void reiniciar();
    protected abstract void preencher();
    protected abstract boolean existemDependencias();
    protected abstract void desabilitarCampos();
    protected abstract void cadastrar();
    protected abstract void alterar();

    protected void cancelar(){
        int resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar?", "Sair", JOptionPane.YES_NO_OPTION);

        if(resp == JOptionPane.YES_OPTION){
            this.dispose();
            reiniciar();
        }
    }

}
