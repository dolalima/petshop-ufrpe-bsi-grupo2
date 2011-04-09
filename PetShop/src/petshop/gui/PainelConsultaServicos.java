package petshop.gui;

public class PainelConsultaServicos extends PainelConsulta {

    public PainelConsultaServicos(){
        super();

        this.setCadastro(new JanelaCadastroServico());

        int [] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "Preço"});
    }
}
