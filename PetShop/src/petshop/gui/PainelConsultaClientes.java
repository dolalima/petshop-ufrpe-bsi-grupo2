package petshop.gui;

public class PainelConsultaClientes extends PainelConsulta {

    public PainelConsultaClientes(){
        super();

        this.setCadastro(new JanelaCadastroCliente());

        int [] itensPreco = new int[0];
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "CPF", "RG"});
    }
}
