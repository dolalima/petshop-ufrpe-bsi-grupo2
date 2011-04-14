/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import petshop.gui.*;
import petshop.classes.*;


/**
 *
 * @author Dola
 */
public class Main {

    JanelaPrincipal menu;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

                // Get the native look and feel class name
        String nativeLF = UIManager.getSystemLookAndFeelClassName();

        // Install the look and feel
        try {
            UIManager.setLookAndFeel(nativeLF);
        } catch (InstantiationException e) {
        } catch (ClassNotFoundException e) {
        } catch (UnsupportedLookAndFeelException e) {
        } catch (IllegalAccessException e) {
        }

        BancoDeDados.conectar();
        //JanelaLogin janela = new JanelaLogin((BancoDeDados) BancoDeDados.connection);
        JanelaPrincipal janela = new JanelaPrincipal();

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

}
