/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop.classes;

/**
 *
 * @author Dola
 */
public class Cliente{
    private int codigo;
    private String nome;
    private String sexo;
    private String endereco;
    private int num;
    private String complemento;
    private String bairro;
    private String uf;
    private String cep;
    private String email;
    private String informacoes;
    private int rg;
    private CPF cpf;
    private int[] telefone;
    private int[] celular;
    private Animal[] animals;
    
    
    
    
	public Cliente(int codigo, String nome, String sexo, String endereco,
			int num, String complemento, String bairro, String uf, String cep,
			String email, String informacoes, int rg, CPF cpf, int[] telefone,
			int[] celular, Animal[] animals) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.num = num;
		this.complemento = complemento;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
		this.email = email;
		this.informacoes = informacoes;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.animals = animals;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public CPF getCpf() {
		return cpf;
	}
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	public int[] getTelefone() {
		return telefone;
	}
	public void setTelefone(int[] telefone) {
		this.telefone = telefone;
	}
	public int[] getCelular() {
		return celular;
	}
	public void setCelular(int[] celular) {
		this.celular = celular;
	}
	public Animal[] getAnimals() {
		return animals;
	}
	public void setAnimals(Animal[] animals) {
		this.animals = animals;
	}
    
    
}
