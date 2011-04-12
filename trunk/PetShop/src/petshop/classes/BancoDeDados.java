package petshop.classes;

import java.sql.Connection;
import java.sql.Statement;
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
    public static final String DATABASE_URL="jdbc:mysql://localhost/petshop";
    /**Variavel de conexao com o banco de dados**/
    public static Connection connection = null;
    /**Varivel de execução de comandos SQL no banco de dados**/
    public static Statement statement = null;
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
        String cmd = "INSERT INTO cliente (nome,cpf,rg,rua,bairro,cidade,cep)"+
                "VALUES ("+cliente.getNome()+","+cliente.getCpf()+
                ","+cliente.getRg()+","+cliente.getEndereco().getRua()+","+cliente.getEndereco().getBairro()+
                ","+cliente.getEndereco().getCidade()+","+cliente.getEndereco().getCep()+")";
        BancoDeDados.ExecuteSQLCmd(cmd);
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
