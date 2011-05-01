package petshop.gui;

import javax.swing.table.DefaultTableModel;
import petshop.classes.BancoDeDados;
import petshop.classes.Cliente;
import petshop.classes.Venda;

public class PainelConsultaVendas extends PainelConsulta {

    String[] modelo;
    double[] tamanhosColunas;

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
        
        modelo = new String[] {"Código", "Cliente", "Total"};
        tamanhosColunas = new double[] {15, 55, 30};

        setModelo(modelo, tamanhosColunas);

        this.botaoPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisar();
            }
        });
    }

    private void pesquisar() {
        Venda v = new Venda();

        if(comboPesquisa.getSelectedIndex() == 0){
            v.setCodigo(Integer.valueOf(campoPesquisa.getText()));
        } else if(comboPesquisa.getSelectedIndex() == 1){
            Cliente c = new Cliente();
            c.setNome(campoPesquisa.getText());
            v.setCliente(c);
        } else if(comboPesquisa.getSelectedIndex() == 2){
            
        }

        Venda[] vendas = BancoDeDados.consultar(v);
        Object[][] dados = new Object[vendas.length][4];

        for(int i = 0; i < vendas.length; i++){
            dados[i][0] = vendas[i].getCodigo();
            dados[i][1] = vendas[i].getCliente().getNome();
            dados[i][2] = vendas[i].total();
        }

        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();

        model.setDataVector(dados, modelo);
        redimensionarColunas();
    }
}
