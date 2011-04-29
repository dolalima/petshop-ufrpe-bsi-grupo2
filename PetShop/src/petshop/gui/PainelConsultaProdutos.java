package petshop.gui;

import javax.swing.JTextField;

public class PainelConsultaProdutos extends PainelConsulta {
    
    private JTextField campoAcimaDe;
    private JTextField campoAbaixoDe;
    private java.awt.GridBagConstraints gridBagConstraints;

    public PainelConsultaProdutos(){
        super();

        this.setCadastro(new JanelaProduto(TipoJanela.CADASTRO));

        int [] itensPreco = new int[2];
        itensPreco[0] = 2;
        itensPreco[1] = 3;
        this.setItensPreco(itensPreco);

        setModelo(new String[] {"Código", "Nome", "Preço de Compra", "Preço de Venda"});
    }
}
