package petshop.classes;

import java.util.Date;

/**
 * @author arthur
 *
 */
public class Animal {
	
	private int codigo;
	private String nome;
	private String especie;
	private String raca;
	private String info;
	private String sexo;
	private Date dataNasc;
	
	
        /**
         * @param codigo
         * @param nome
         * @param especie
         * @param raca
         * @param info
         * @param sexo
         * @param dataNasc
         */
        public Animal(int codigo, String nome, String especie, String raca,
			String info, String sexo, Date dataNasc) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.info = info;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
	}
	
	
        /**
         * @return
         */
        public int getCodigo() {
		return codigo;
	}

        /**
         * @param codigo
         */
        public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

        /**
         * @return
         */
        public String getNome() {
		return nome;
	}

        /**
         * @param nome
         */
        public void setNome(String nome) {
		this.nome = nome;
	}

        /**
         * @return
         */
        public String getEspecie() {
		return especie;
	}

        /**
         * @param especie
         */
        public void setEspecie(String especie) {
		this.especie = especie;
	}

        /**
         * @return
         */
        public String getRaca() {
		return raca;
	}

        /**
         * @param raca
         */
        public void setRaca(String raca) {
		this.raca = raca;
	}

        /**
         * @return
         */
        public String getInfo() {
		return info;
	}

        /**
         * @param info
         */
        public void setInfo(String info) {
		this.info = info;
	}

        /**
         * @return
         */
        public String getSexo() {
		return sexo;
	}

        /**
         * @param sexo
         */
        public void setSexo(String sexo) {
		this.sexo = sexo;
	}

        /**
         * @return
         */
        public Date getDataNasc() {
		return dataNasc;
	}

        /**
         * @param dataNasc
         */
        public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
