package petshop.classes;

import java.util.Calendar;

/**
 * @author arthur
 *
 */
public class Animal {

    private int codigo;
    private String nome;
    private char sexo;
    private Calendar dataNasc;
    private String especie;
    private String raca;
    private String info;
    private Cliente dono;


    public Animal(String nome, char sexo, Calendar dataNasc, String especie, String raca, String info) {
        
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.especie = especie;
        this.raca = raca;
        this.info = info;
    }

    public Animal(String nome) {
        this.nome = nome;
    }

    Animal() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }


}
