/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

import petshop.classes.BancoDeDados;
import petshop.classes.Cliente;

/**
 *
 * @author dola
 */
public class TesteClienteList {
    private static Cliente[] c;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoDeDados.conectar();
        
        c = BancoDeDados.consultar(new Cliente());
        System.out.printf("Resultado da Pesquisa: %d \n",c.length);


        for (int i=0;i<c.length;i++){
            System.out.println(c[i].getNome());
        }
        

        // TODO code application logic here
    }

}
