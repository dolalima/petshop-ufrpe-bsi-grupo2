package petshop.classes;

import java.util.Date;

public class Animal {
	
	private int codigo;
	private String nome;
	private String especie;
	private String raca;
	private String info;
	private String sexo;
	private Date dataNasc;
	
	
	public Animal(int codigo, String nome, String especie, String raca,
			String info, String sexo, Date dataNasc) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.info = info;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
