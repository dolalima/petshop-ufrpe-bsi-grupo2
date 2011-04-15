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
            System.out.print("Conectado");
            BancoDeDados.conectStatus = true;


        } catch (SQLException e){
            System.out.println("Não foi possivel conectar ao banco de dados");
        }
    }

    /**Metodo publico que cadastra um cliente no banco de dados.
     *
     * @param cliente
     */
    public static void cadastrar(Cliente cliente){
        try{
            //
            preparedStatement = connection.prepareStatement("INSERT INTO cliente(nome,"
                    +"sexo,cpf,rg,rua,ncasa,bairro,cidade,complemento,uf,telefone,"
                    + "celular,cep,info) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setString(3, cliente.getCpf().getCpf());
            preparedStatement.setInt(4, cliente.getRg());
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
                       
            int cod = preparedStatement.executeUpdate();

            System.out.println("ID de cliente "+Integer.toString(cod));

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro no cadastro de Cliente");
        }
    }


    /**
     * Metodo publico que cadastra um pruduto no banco de dados.
     *
     * @param produto
     */
    public static void cadastrar(Produto produto){
        String cmd = "INSERT INTO produto () VALUES ()";
        BancoDeDados.ExecuteSQLCmd(cmd);
    }


    /**
     * Metodo publico que cadastra um servico no banco de dados.
     *
     * @param servico
     **/
    public static void cadastrar(Servico servico){
        String cmd = "INSERT INTO servico () VALUES ()";
        BancoDeDados.ExecuteSQLCmd(cmd);
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
