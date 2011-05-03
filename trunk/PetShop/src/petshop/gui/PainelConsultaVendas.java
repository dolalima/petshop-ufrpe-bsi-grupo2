package petshop.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petshop.classes.Animal;
import petshop.classes.BancoDeDados;
import petshop.classes.Cliente;
import petshop.classes.Venda;

public class PainelConsultaVendas extends PainelConsulta {


    public PainelConsultaVendas(){
        super();

        this.remove(this.botaoAlterar);
        this.remove(this.botaoExcluir);
        this.setCadastro(new JanelaVenda(TipoJanela.CADASTRO));

        int [] itensPreco = new int[1];
        itensPreco[0] = 3;
        this.setItensPreco(itensPreco);
        
        modelo = new String[] {"Código", "Cliente", "CPF", "Total"};
        tamanhosColunas = new double[] {15, 45, 23, 17};

        setModelo(modelo, tamanhosColunas);
    }

    protected void informacoes(int cod) {
        JanelaVenda janela = new JanelaVenda(TipoJanela.INFORMACAO);

        preencher(janela, cod);

        janela.setModalityType(java.awt.Dialog.DEFAULT_MODALITY_TYPE);
        janela.setModal(true);
        janela.setVisible(true);
    }

    protected void pesquisar() {
        Venda v = new Venda();

        if(!campoPesquisa.getText().equals("")){
            if(comboPesquisa.getSelectedIndex() == 0){
                v.setCodigo(Integer.valueOf(campoPesquisa.getText()));
            } else if(comboPesquisa.getSelectedIndex() == 1){
                Cliente c = new Cliente();
                c.setNome(campoPesquisa.getText());
                v.setCliente(c);
            } else if(comboPesquisa.getSelectedIndex() == 2){

            }
        }

        Venda[] vendas = BancoDeDados.consultar(v);

        Object[][] dados = new Object[vendas.length][4];

        for(int i = 0; i < vendas.length; i++){
            dados[i][0] = vendas[i].getCodigo();
            dados[i][1] = vendas[i].getCliente().getNome();
            dados[i][2] = vendas[i].getCliente().getCpf().getCpf();
            dados[i][3] = vendas[i].total();
        }

        DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();

        model.setDataVector(dados, modelo);
        redimensionarColunas();

        if(vendas.length == 0){
            JOptionPane.showMessageDialog(this, "A busca não retornou nenhum resultado!");
        }
    }

    void alterar(int integer) {
        throw new UnsupportedOperationException("Venda não pode ser alterada");
    }

    private void preencher(JanelaVenda janela, int cod) {

        Venda[] venda = BancoDeDados.consultar(new Venda(cod));
        Venda v = venda[0];

        janela.getLabelCliente().setText(v.getCliente().getNome());
        janela.setTotal(v.total());
        Animal[] a = BancoDeDados.getAnimais(v.getCliente());
        for(int i = 0; i < a.length; i++){
            janela.getComboAnimais().addItem(a[i].getNome());
        }

        janela.getVenda().setCarrinhoProdutos(v.getCarrinhoProdutos());
        janela.getVenda().setCarrinhoServicos(v.getCarrinhoServicos());

        DefaultTableModel modeloServicos = (DefaultTableModel) janela.getTabelaServicos().getModel();
        DefaultTableModel modeloProdutos = (DefaultTableModel) janela.getTabelaProdutos().getModel();

        for(int i = 0; i < janela.getVenda().getCarrinhoProdutos().getProdutos().size(); i++){
            Object[] dados = new Object[4];
            dados[0] = janela.getVenda().getCarrinhoProdutos().getProdutos().get(i).getCodigo();
            dados[1] = janela.getVenda().getCarrinhoProdutos().getProdutos().get(i).getNome();
            dados[2] = janela.getVenda().getCarrinhoProdutos().getQtde().get(i);
            dados[3] = janela.getVenda().getCarrinhoProdutos().getProdutos().get(i).getPrecoVenda();
            modeloProdutos.addRow(dados);
        }
        for(int i = 0; i < janela.getVenda().getCarrinhoServicos().getServicos().size(); i++){
            Object[] dados = new Object[4];
            dados[0] = janela.getVenda().getCarrinhoServicos().getServicos().get(i).getCodigo();
            dados[1] = janela.getVenda().getCarrinhoServicos().getServicos().get(i).getNome();
            dados[2] = janela.getVenda().getCarrinhoServicos().getAnimal().get(i).getNome();
            dados[3] = janela.getVenda().getCarrinhoServicos().getServicos().get(i).getPrecoVenda();
            modeloServicos.addRow(dados);
        }
    }

    @Override
    void excluir(int integer) {
        throw new UnsupportedOperationException("Venda não pode ser excluida");
    }
}
