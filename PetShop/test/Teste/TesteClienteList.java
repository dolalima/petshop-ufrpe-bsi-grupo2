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
    private static Cliente[] clienteList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoDeDados.conectar();
        Cliente cliente = new Cliente();
        cliente.setNome("lima");
        clienteList = BancoDeDados.consultar(cliente);

        System.out.printf("Resultado da Pesquisa: %d \n",clienteList.length);


        for (int i=0;i<clienteList.length;i++){
            System.out.println(clienteList[i].getNome());
        }
        

        // TODO code application logic here
    }

}
