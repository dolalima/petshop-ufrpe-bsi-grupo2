package petshop.gui;

import java.awt.GridBagConstraints;

public class PainelConsultaVendas extends PainelConsulta {

    public PainelConsultaVendas(){
        super();

        this.remove(this.botaoAlterar);
        this.remove(this.botaoExcluir);
        /*GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
        add(botaoExcluir, gridBagConstraints);*/
        this.setCadastro(new JanelaVenda());

        int [] itensPreco = new int[1];
        itensPreco[0] = 2;
        this.setItensPreco(itensPreco);
        
        setModelo(new String[] {"Código", "Cliente", "Total" });
    }
}
