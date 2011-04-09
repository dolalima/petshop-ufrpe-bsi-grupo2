package petshop.gui;

public class PainelConsultaVendas extends PainelConsulta {

    public PainelConsultaVendas(){
        super();

        this.setCadastro(new JanelaVenda());

        int [] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);
        
        setModelo(new String[] {"Código", "Cliente", "Total" });
    }
}
