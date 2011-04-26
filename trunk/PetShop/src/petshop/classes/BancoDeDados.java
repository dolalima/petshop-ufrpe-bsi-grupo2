package petshop.classes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * Classe de selação do sistema com banco de dados, as atividades de cadastrar, pesquisar,
 * alterar e excluir cliente, protudos, serviços e animais são todas feitas atravez dessa
 * classe.
 * @author dola
 */
public abstract class BancoDeDados {

    /**Endereço do Banco de Dados**/
    private static final String DATABASE_URL="jdbc:mysql://localhost/petshop";
    /**Variavel de conexao com o banco de dados**/
    public static Connection connection = null;
    /**Varivel de execução de comandos SQL no banco de dados**/
    public static Statement statement = null;
    //**varivel de comando sql pre configurados**//
    public static PreparedStatement preparedStatement = null;
    /**Variavel que recebe o resultado das pesquisas do banco de dados**/
    public static ResultSet resultset = null;
    /**Variavel de recebe os metadados das pesquisas no banco de dados. **/
    public static ResultSetMetaData resultsetmetadata = null;

    public static boolean conectStatus = false;

    /**Metodo para conectar o sistema ao banco de dados.**/
    public static void conectar(){
        try{
            BancoDeDados.connection = DriverManager.getConnection(DATABASE_URL,
                    "root",
                    "lima1807");
            BancoDeDados.statement = BancoDeDados.connection.createStatement();
            System.out.println("Conectado");
            BancoDeDados.conectStatus = true;


        } catch (SQLException e){
            System.out.println("Não foi possivel conectar ao banco de dados");
        }
    }

    /**Metodo publico que cadastra um cliente no banco de dados.
     *
     * @param cliente
     */
    public static boolean cadastrar(Cliente cliente){
        try{
            // Configuração de pre-comando
            preparedStatement = connection.prepareStatement("INSERT INTO cliente(nome,"
                    +"sexo,cpf,rg,rua,ncasa,bairro,cidade,complemento,uf,telefone,"
                    + "celular,cep,info) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Entrada de valores
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setString(3, cliente.getCpf().getCpf());
            preparedStatement.setLong(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getEndereco().getRua());
            preparedStatement.setInt(6, cliente.getEndereco().getNum());
            preparedStatement.setString(7, cliente.getEndereco().getBairro());
            preparedStatement.setString(8,cliente.getEndereco().getCidade());
            preparedStatement.setString(9, cliente.getEndereco().getComplemento());
            preparedStatement.setString(10, cliente.getEndereco().getUf());
            preparedStatement.setString(11, cliente.getTelefone());
            preparedStatement.setString(12, cliente.getCelular());
            preparedStatement.setString(13, cliente.getEndereco().getCep());
            preparedStatement.setString(14, cliente.getInformacoes());
            //Execução de comando
            int cod = preparedStatement.executeUpdate();

            System.out.println("ID de cliente "+Integer.toString(cod));
            return true;

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro no cadastro de Cliente");
            return false;
        }
    }


    /**
     * Metodo publico que cadastra um pruduto no banco de dados.
     *
     * @param produto
     */
    public static boolean cadastrar(Produto produto){

        try{
            // Configuração de pre-comando
            preparedStatement = connection.prepareStatement("INSERT INTO produtos "+
                    "(codigo,nome,qt,preco_custo,preco_venda,info) VALUES (?,?,?,?,?,?)");
            //Entrada de valores
            preparedStatement.setLong(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getQtdeEstoque());
            preparedStatement.setDouble(4, produto.getPrecoCusto());
            preparedStatement.setDouble(5, produto.getPrecoVenda());
            preparedStatement.setString(6, produto.getInformacoes());
            // Executando comando SQL
            preparedStatement.executeUpdate();
            //
            return true;


        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao cadastra produto.");
            return false;
        }

    }

    public static Cliente[] consultar(Cliente c){
        int contador=0;
        int nRegistros=0;
        try{
            if (!c.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE nome LIKE ?");
                preparedStatement.setString(1, "%"+c.getNome()+"%");
                resultset = preparedStatement.executeQuery();
            }

            resultsetmetadata = resultset.getMetaData();
            while (resultset.next()){
                nRegistros=nRegistros+1;
            }
            Cliente[] clienteList= new Cliente[nRegistros];
            resultset.beforeFirst();
            while (resultset.next()){
                //Contador de cliente
                contador=contador+1;
                Cliente cliente = new Cliente();
                cliente.setCodigo((Integer)resultset.getObject(1));
                cliente.setNome((String)resultset.getObject(2));
                cliente.setSexo((String)resultset.getObject(3));
                CPF cpf = new CPF((String)resultset.getObject(4));
                cliente.setCpf(cpf);
                cliente.setRg((Integer)resultset.getObject(5));
                //Enderero do cliente
                String rua = (String)resultset.getObject(6);
                int n = (Integer)resultset.getObject(7);
                String bairro =(String)resultset.getObject(8);
                String cidade =(String)resultset.getObject(9);
                String complemento = (String)resultset.getObject(10);
                String uf = (String)resultset.getObject(11);
                String cep = (String)resultset.getObject(14);
                //
                Endereco endereco = new Endereco();
                endereco.setRua(rua);
                endereco.setNum(n);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                endereco.setComplemento(complemento);
                endereco.setUf(uf);
                endereco.setCep(cep);
                cliente.setEndereco(endereco);
                //
                cliente.setTelefone((String)resultset.getObject(12));
                cliente.setCelular((String)resultset.getObject(13));
                cliente.setInformacoes((String)resultset.getObject(15));


                clienteList[contador-1]=cliente;
            }
            return clienteList;

        } catch (SQLException e) {
            e.printStackTrace();
            Cliente[] clienteList = new Cliente[0];
            return clienteList;
        }
    }

    public static Produto[] consultar(Produto p){
        int contador = 0;
        int nRegistro = 0;
        try{
            if(!p.getNome().equals("")){
                preparedStatement = connection.prepareStatement("SELECT * FROM "+
                        "produtos WHERE nome LIKE ?");
                preparedStatement.setString(1, "%"+p.getNome()+"%");
                resultset = preparedStatement.executeQuery();
            }
            while (resultset.next()){
                nRegistro++;
            }
            Produto[] produtoList = new Produto[nRegistro];
            resultset.beforeFirst();
            while (resultset.next()){
                contador++;
                Produto produto = new Produto();
                produto.setCodigo((Integer)resultset.getObject(1));
                produto.setNome((String)resultset.getObject(2));
                produto.setQtdeEstoque((Integer)resultset.getObject(3));
                produto.setPrecoCusto((Double)resultset.getObject(4));
                produto.setPrecoVenda((Double)resultset.getObject(5));
                produto.setInformacoes((String)resultset.getObject(6));

                produtoList[contador -1]=produto;

            }
            return produtoList;
        }catch(SQLException e){
            e.printStackTrace();
            Produto[] produtoList = new Produto[0];
            return produtoList;
        }
    }

    
    /**
     * Metodo publico que cadastra um servico no banco de dados.
     *
     * @param servico
     **/
    public static boolean cadastrar(Servico servico){
        try{
            // Pre-comando SQL
            preparedStatement = connection.prepareStatement("INSERT INTO produtos "
                    + "(codigo,nome,duracao,preco,info) VALUES (?,?,?,?,?)");
            //Configuração das varieaveis
            preparedStatement.setLong(1, servico.getCodigo());
            preparedStatement.setString(2, servico.getNome());
            preparedStatement.setInt(3, (int) servico.getDuracao().getTime());
            preparedStatement.setDouble(4, servico.getPrecoVenda());
            preparedStatement.setString(5, servico.getInfo());
            //Execução de comando SQL
            preparedStatement.executeUpdate();
            //
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    /**Metodo privado que executa comandos SQL a partir de outros metodos
     * no banco de dados e retorna o resultado para a variavel resultset.
     **/
    private static void ExecuteSQLCmd(String cmd){
        try{
        int result = BancoDeDados.statement.executeUpdate(cmd);
            System.out.print(result);
        } catch(SQLException erro){
            System.out.print("Não foi possivel executa consulta.");
        }
    }
    
}
