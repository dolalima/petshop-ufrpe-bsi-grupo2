/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Teste;

import java.text.DecimalFormat;
import petshop.classes.BancoDeDados;
import petshop.classes.Produto;

/**
 *
 * @author dola
 */
public class TesteProdutoList {
    private static Produto[] p;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BancoDeDados.conectar();
        DecimalFormat preco = new DecimalFormat("0.00");

        p=BancoDeDados.consultarProduto("RACAO", "nome");
        System.out.print("Produtos: \n");
        for (int i=0;i<p.length;i++){
            System.out.printf("Nome: %s\tValor: %s \n", p[i].getNome(),preco.format(p[i].getPrecoVenda()));
        }
    }

}
