package petshop.classes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class BancoDeDados {
    
    /**Endereço do Banco de Dados**/
    private static final String DATABASE_URL="jdbc:mysql://localhost/petshop";
    /**Variavel de conexao com o banco de dados**/
    private Connection connection = null;
    /**Varivel de execução de comandos SQL no banco de dados**/
    private Statement statement = null;
    /**Variavel que recebe o resultado das pesquisas do banco de dados**/
    private ResultSet resultset = null;
    /**Variavel de recebe os metadados das pesquisas no banco de dados. **/
    private ResultSetMetaData resultsetmetadata = null;

    /**Metodo para conectar do sistema ao banco de dados.**/
    public void Conect(){
        try{
            this.connection = DriverManager.getConnection(DATABASE_URL,
                    "root",
                    "lima1807");
            this.statement = this.connection.createStatement();
            System.out.print("Conectado");


        } catch (SQLException e){
            System.out.println("Não foi possivel conectar ao banco de dados");
        }
    }

    private void ExecuteSQLCmd(String cmd){
        try{
        this.resultset = this.statement.executeQuery(cmd);
        } catch(SQLException erro){
            System.out.print("Não foi possivel executa consulta: ");
        }
    }
}
