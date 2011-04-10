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
    private static final String DATABASE_URL="jdbc:mysql://localhost/petshop";
    /**Variavel de conexao com o banco de dados**/
    private Connection connection = null;
    /**Varivel de execução de comandos SQL no banco de dados**/
    private Statement statement = null;
    /**Variavel que recebe o resultado das pesquisas do banco de dados**/
    private ResultSet resultset = null;
    /**Variavel de recebe os metadados das pesquisas no banco de dados. **/
    private ResultSetMetaData resultsetmetadata = null;

    private boolean conectStatus = false;

    /**Metodo para conectar o sistema ao banco de dados.**/
    public void conectar(){
        try{
            this.connection = DriverManager.getConnection(DATABASE_URL,
                    "root",
                    "lima1807");
            this.statement = this.connection.createStatement();
            System.out.print("Conectado");
            this.conectStatus = true;


        } catch (SQLException e){
            System.out.println("Não foi possivel conectar ao banco de dados");
        }
    }

    public boolean Login(String user,String senha){
        try{
            String cmd = "SELECT user,senha FROM usuarios WHERE user='"+user+"'";
            System.out.println(cmd);
            ResultSet dados = this.statement.executeQuery(cmd);

            dados.next();
            String u = (String) dados.getObject(1);
            String s = (String) dados.getObject(2);
            if (user.equals(u))
                if (senha.equals(s)){
                    System.out.println("Usuario conectado com exito.");
                    return true;
                }
                else {
                System.out.println("Senha Invalida");
                return false;
                }
            else {
                System.out.println("Usuario ou senha Invalida");
                return false;

            }

        } catch (SQLException e){
            System.out.print(e);
            System.out.println("Erro do Sistema");
            return false;
        }
    }

    
    
    
    /**Metodo publico que cadastra um cliente no banco de dados.
     *
     * @param cliente
     */
    public void cadastrar(Cliente cliente){
        String cmd = "INSERT INTO cliente (nome,cpf,rg,rua,bairro,cidade,cep)"+
                "VALUES ("+cliente.getNome()+","+cliente.getCpf()+
                ","+cliente.getRg()+","+cliente.getEndereco().getRua()+","+cliente.getEndereco().getBairro()+
                ","+cliente.getEndereco().getCidade()+","+cliente.getEndereco().getCep()+")";
        this.ExecuteSQLCmd(cmd);
    }
    
    
    /**
     * Metodo publico que cadastra um pruduto no banco de dados.
     *
     * @param produto
     */
    public void cadastrar(Produto produto){
        String cmd = "INSERT INTO produto () VALUES ()";
        this.ExecuteSQLCmd(cmd);
    }
    
    
    /**
     * Metodo publico que cadastra um servico no banco de dados.
     *
     * @param servico
     **/
    public void cadastrar(Servico servico){
        String cmd = "INSERT INTO servico () VALUES ()";
        this.ExecuteSQLCmd(cmd);
    }
    
    
    /**Metodo privado que executa comandos SQL a partir de outros metodos
     * no banco de dados e retorna o resultado para a variavel resultset.
     **/
    private void ExecuteSQLCmd(String cmd){
        try{
        int result = this.statement.executeUpdate(cmd);
            System.out.print(result);
        } catch(SQLException erro){
            System.out.print("Não foi possivel executa consulta.");
        }
    }
}
