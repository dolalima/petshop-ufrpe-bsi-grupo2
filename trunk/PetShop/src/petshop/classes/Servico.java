package petshop.classes;

import java.util.Date;

/**
 * @author arthur
 *
 */
public class Servico extends ItemVenda {

	private Date duracao;
        private String info;
	

	/**
	 * @param codigo
	 * @param nome
	 * @param precoVenda
	 * @param data
	 */
	public Servico(long codigo, String nome, double precoVenda, Date data) {
		super(codigo, nome, precoVenda);
		this.duracao = data;
	}

    Servico() {

    }
	
	/**
	 * @return
	 */
	public Date getDuracao() {
		return duracao;
	}
	
	/**
	 * @param data
	 */
	public void setDuracao(Date data) {
		this.duracao = data;
	}
        
        public void setInfo(String info){
            this.info = info;
        }
        public String getInfo() {

            return info;
        }
}
