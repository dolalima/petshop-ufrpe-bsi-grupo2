/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import petshop.interfaces.JanelaPrincipal;

/**
 *
 * @author Dola
 */
public class Main {

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

        JanelaPrincipal menu = new JanelaPrincipal();
        menu.setVisible(true);




    }

}
