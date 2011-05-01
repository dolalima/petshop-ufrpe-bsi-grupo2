package petshop.classes;

import java.util.Calendar;
import java.util.Date;

/**
 * @author arthur
 *
 */
public class Servico extends ItemVenda {

    private int duracao;
    private String info;

    public Servico(long codigo, String nome, double precoVenda, int duracao, String info) {
        super(codigo, nome, precoVenda);
        this.duracao = duracao;
        this.info = info;
    }
    
    public Servico(int cod) {
        super(cod, "", 0);

    }

    public Servico() {
        super(0, "", 0);
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}