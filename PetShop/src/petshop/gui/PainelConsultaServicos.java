package petshop.gui;

public class PainelConsultaServicos extends PainelConsulta {

    public PainelConsultaServicos(){
        super();

        this.setCadastro(new JanelaServico(TipoJanela.CADASTRO));

        int [] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "Preço"});
    }
}
