/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop;

/**
 *
 * @author Dola
 */
public class Cliente {
    private String nome;
    private String cpf;
    private String rg;

    public Cliente(){

    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setRg(String rg){
        this.rg = rg;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getRg(){
        return this.rg;
    }


}
