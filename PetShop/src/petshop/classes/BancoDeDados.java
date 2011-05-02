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
 **/
public abstract class BancoDeDados {

    /**Endereço do Banco de Dados**/
    private static final String DATABASE_URL = "jdbc:mysql://localhost/petshop";
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
    /**Variavel de status da conecxão**/
    public static boolean conectStatus = false;

    /**Metodo para conectar o sistema ao banco de dados.**/
    public static void conectar() {
        try {
            BancoDeDados.connection = DriverManager.getConnection(DATABASE_URL,
                    "root",
                    "lima1807");
            BancoDeDados.statement = BancoDeDados.connection.createStatement();
            System.out.println("Conectado");
            BancoDeDados.conectStatus = true;


        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar ao banco de dados");
        }
    }

    private static Cliente gerarClienteFromResultset(ResultSet resultset) {

        try {
            Cliente cliente = new Cliente();
            cliente.setCodigo((Integer) resultset.getObject(1));
            cliente.setNome((String) resultset.getObject(2));
            cliente.setSexo((String) resultset.getObject(3));
            CPF cpf = new CPF((String) resultset.getObject(4));
            cliente.setCpf(cpf);
            cliente.setRg((Integer) resultset.getObject(5));
            //Enderero do cliente
            String rua = (String) resultset.getObject(6);
            int n = (Integer) resultset.getObject(7);
            String bairro = (String) resultset.getObject(8);
            String cidade = (String) resultset.getObject(9);
            String complemento = (String) resultset.getObject(10);
            String uf = (String) resultset.getObject(11);
            String cep = (String) resultset.getObject(14);
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
            cliente.setEmail((String) resultset.getObject(12));
            cliente.setTelefone((String) resultset.getObject(13));
            cliente.setCelular((String) resultset.getObject(14));
            cliente.setInformacoes((String) resultset.getObject(15));
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();

            Cliente cliente = new Cliente();
            return cliente;
        }
    }

    private static Produto gerarProdutoFromResultset(ResultSet resultset) {
        try {
            Produto produto = new Produto();
            produto.setCodigo((Integer) resultset.getObject(1));
            produto.setNome((String) resultset.getObject(2));
            produto.setQtdeEstoque((Integer) resultset.getObject(3));
            produto.setPrecoCusto((Double) resultset.getObject(4));
            produto.setPrecoVenda((Double) resultset.getObject(5));
            produto.setInformacoes((String) resultset.getObject(6));
            return produto;
        } catch (SQLException e) {
            e.printStackTrace();
            Produto produto = new Produto();
            return produto;

        }

    }

    private static Servico gerarServicoFromResultset(ResultSet resultset) {
        try {
            Servico servico = new Servico((Integer) resultset.getObject(1));
            servico.setNome((String) resultset.getObject(2));
            servico.setDuracao((Integer) resultset.getObject(3));
            servico.setPrecoVenda((Double) resultset.getObject(4));
            servico.setInfo((String) resultset.getObject(5));
            return servico;
        } catch (SQLException e) {
            e.printStackTrace();
            Servico servico = new Servico(0);
            return servico;


        }
    }

    private static Animal gerarAnimalFromResultset(ResultSet resultset) {
        try {
            Animal animal = new Animal();
            animal.setCodigo((Integer) resultset.getObject(1));
            animal.setNome((String) resultset.getObject(2));
            animal.setDataNasc(null);
            animal.setEspecie((String) resultset.getObject(4));
            animal.setRaca((String) resultset.getObject(5));
            animal.setInfo((String) resultset.getObject(6));
            animal.setDono((Integer) resultset.getObject(7));

            return animal;

        } catch (SQLException e) {
            e.printStackTrace();
            Animal animal = new Animal();
            return animal;

        }
    }

    /**Metodo publico que cadastra um cliente no banco de dados.
     *
     * @param cliente
     */
    public static boolean cadastrar(Cliente cliente) {
        try {
            // Configuração de pre-comando
            preparedStatement = connection.prepareStatement("INSERT INTO cliente(nome,"
                    + "sexo,cpf,rg,rua,ncasa,bairro,cidade,complemento,uf,email,telefone,"
                    + "celular,cep,info) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Entrada de valores
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, String.valueOf(cliente.getSexo()));
            preparedStatement.setString(3, cliente.getCpf().getCpf());
            preparedStatement.setLong(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getEndereco().getRua());
            preparedStatement.setInt(6, cliente.getEndereco().getNum());
            preparedStatement.setString(7, cliente.getEndereco().getBairro());
            preparedStatement.setString(8, cliente.getEndereco().getCidade());
            preparedStatement.setString(9, cliente.getEndereco().getComplemento());
            preparedStatement.setString(10, cliente.getEndereco().getUf());
            preparedStatement.setString(11, cliente.getEmail());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getCelular());
            preparedStatement.setString(14, cliente.getEndereco().getCep());
            preparedStatement.setString(15, cliente.getInformacoes());
            //Execução de comando
            int cod = preparedStatement.executeUpdate();

            System.out.println("ID de cliente " + Integer.toString(cod));
            return true;

        } catch (SQLException e) {
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
    public static boolean cadastrar(Produto produto) {

        try {
            // Configuração de pre-comando
            preparedStatement = connection.prepareStatement("INSERT INTO produtos "
                    + "(codigo,nome,qt,preco_custo,preco_venda,info) VALUES (?,?,?,?,?,?)");
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


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastra produto.");
            return false;
        }

    }

    /**
     * Metodo publico que cadastra um servico no banco de dados.
     *
     * @param servico
     **/
    public static boolean cadastrar(Servico servico) {
        try {
            // Pre-comando SQL
            preparedStatement = connection.prepareStatement("INSERT INTO servicos "
                    + "(codigo,nome,duracao,preco,info) VALUES (?,?,?,?,?)");
            //Configuração das varieaveis
            preparedStatement.setLong(1, servico.getCodigo());
            preparedStatement.setString(2, servico.getNome());
            preparedStatement.setInt(3, servico.getDuracao());
            preparedStatement.setDouble(4, servico.getPrecoVenda());
            preparedStatement.setString(5, servico.getInfo());
            //Execução de comando SQL
            preparedStatement.executeUpdate();
            //
            System.out.println("Servico cadastrado com exito.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastra o serviço.");
            return false;
        }
    }

    public static boolean cadastrar(Animal animal) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO animal "
                    + "(nome,sexo,nascimento,especie,raca,info,dono) "
                    + "VALUES (?,?,?,?,?,?,?)");

            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, String.valueOf(animal.getSexo()));
            preparedStatement.setString(3, String.valueOf(animal.getDataNasc().toString()));
            preparedStatement.setString(4, animal.getEspecie());
            preparedStatement.setString(5, animal.getRaca());
            preparedStatement.setString(6, animal.getInfo());
            preparedStatement.setInt(7, animal.getDono());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Animal[] getAnimais(Cliente cliente) {
        int contador = 0;
        int nRegistro = 0;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM animal "
                    + "WHERE dono=? AND ativo=1");
            preparedStatement.setInt(1, cliente.getCodigo());

            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                nRegistro++;
            }
            resultset.beforeFirst();

            Animal[] animalList = new Animal[nRegistro];

            while (resultset.next()) {
                contador++;
                animalList[contador - 1] = gerarAnimalFromResultset(resultset);
            }
            return animalList;
        } catch (SQLException e) {
            e.printStackTrace();
            Animal[] animalList = new Animal[0];
            return animalList;

        }
    }

    public static boolean cadastrar(Venda venda) {
        int pagamento = 0;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO vendas "
                    + "(cliente,valor,pagamento,data) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, venda.getCliente().getCodigo());
            preparedStatement.setDouble(2, venda.total());
            if (venda.getTipoPagamento().equals(TipoPagamento.CARTAO)) {
                pagamento = 1;
            } else if (venda.getTipoPagamento().equals(TipoPagamento.CHEQUE)) {
                pagamento = 2;
            }

            preparedStatement.setInt(3, pagamento);

            preparedStatement.setString(4, "");
            preparedStatement.executeUpdate();

            venda.setCodigo(getLastVenda());

            if (!registraSaidaProdutos(venda)){
                drop(venda);
                return false;
            }
            if (!registraSaidaServicos(venda)){
                drop(venda);
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean registraSaidaProdutos(Venda venda) {
        Produto[] produtoList = (Produto[]) venda.getCarrinhoProdutos().getProdutos().toArray();
        Integer[] qtdeList = (Integer[]) venda.getCarrinhoProdutos().getQtde().toArray();
        for (int i = 0; i <= produtoList.length; i++) {
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO saidaprodutos "
                        + "(venda,produto,qt,valor) VALUES (?,?,?,?)");
                preparedStatement.setInt(1, venda.getCodigo());
                preparedStatement.setLong(2, produtoList[i].getCodigo());
                preparedStatement.setInt(3, produtoList[i].getQtdeEstoque() - qtdeList[i]);
                preparedStatement.setDouble(4, produtoList[i].getPrecoVenda());


            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static boolean registraSaidaServicos(Venda venda) {
        Servico[] servicoList = (Servico[]) venda.getCarrinhoServicos().getServicos().toArray();
        Animal[] animalList = (Animal[]) venda.getCarrinhoServicos().getServicos().toArray();
        for (int i = 0; i <= servicoList.length; i++) {
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO saidaservicos "
                        + "(venda,servico,animal,valor) VALUES (?,?,?,?)");
                preparedStatement.setInt(1, venda.getCodigo());
                preparedStatement.setLong(2, servicoList[i].getCodigo());
                preparedStatement.setInt(3, animalList[i].getCodigo());
                preparedStatement.setDouble(4, servicoList[i].getPrecoVenda());

            }catch(SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static int getLastVenda() {
        int cod = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT MAX(codigo) from vendas");
            resultset = preparedStatement.executeQuery();
            resultset.next();
            cod = (Integer) resultset.getObject(1);
            return cod;
        } catch (SQLException e) {
            cod = 0;
            return cod;
        }
    }

    public static Cliente[] consultar(Cliente cliente) {
        int contador = 0;
        int nRegistros = 0;
        try {
            if (cliente.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE codigo LIKE ? AND ativo=1");
                preparedStatement.setString(1, String.valueOf(cliente.getCodigo()));
                resultset = preparedStatement.executeQuery();
            } else if (!cliente.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE nome LIKE ? AND ativo=1");
                preparedStatement.setString(1, "%" + cliente.getNome() + "%");
                resultset = preparedStatement.executeQuery();
            } else if (!cliente.getCpf().getCpf().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE cpf LIKE ? AND ativo=1");
                preparedStatement.setString(1, cliente.getCpf().getCpf() + "%");
                resultset = preparedStatement.executeQuery();
            } else if (cliente.getRg() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE rg LIKE ? AND ativo=1");
                preparedStatement.setString(1, String.valueOf(cliente.getRg()) + "%");
                resultset = preparedStatement.executeQuery();
            } else {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE ativo=1");
                preparedStatement.setString(1, String.valueOf(cliente.getRg()) + "%");
                resultset = preparedStatement.executeQuery();

            }

            while (resultset.next()) {
                nRegistros = nRegistros + 1;
            }
            Cliente[] clienteList = new Cliente[nRegistros];
            resultset.beforeFirst();
            while (resultset.next()) {
                //Contador de cliente
                contador = contador + 1;

                clienteList[contador - 1] = gerarClienteFromResultset(resultset);
            }
            return clienteList;

        } catch (SQLException e) {
            e.printStackTrace();
            Cliente[] clienteList = new Cliente[0];
            return clienteList;
        }
    }

    public static int getClienteCod(Cliente cliente) {
        try {
            preparedStatement = connection.prepareStatement("SELECT codigo FROM cliente "
                    + "WHERE cpf=?");
            preparedStatement.setString(1, cliente.getCpf().getCpf());
            resultset = preparedStatement.executeQuery();

            resultset.next();

            int codigo = (Integer) resultset.getObject(1);
            return codigo;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente não encontrado.");
            return 0;
        }
    }

    /**
     * Verifica se já existe o CPF cadastrado no banco de dados
     **/
    public static boolean checkCPF(Cliente cliente) {
        try {
            preparedStatement = connection.prepareStatement("SELECT cpf FROM "
                    + "cliente WHERE cpf=?");
            preparedStatement.setString(1, cliente.getCpf().getCpf());
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que realiza uma consulta de produtos no banco de dados a partir
     * de produto com algumas informações.
     *
     * @param Produto
     * @return Produto[]
     **/
    public static Produto[] consultar(Produto produto) {
        int contador = 0;
        int nRegistro = 0;
        try {
            if (produto.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                        + "WHERE codigo LIKE ? AND ativo=1");
                preparedStatement.setString(1, "%" + produto.getCodigo() + "%");
                resultset = preparedStatement.executeQuery();
            } else if (!produto.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM "
                        + "produtos WHERE nome LIKE ? and ativo=1");
                preparedStatement.setString(1, "%" + produto.getNome() + "%");
                resultset = preparedStatement.executeQuery();
            }
            while (resultset.next()) {
                nRegistro++;
            }
            Produto[] produtoList = new Produto[nRegistro];
            resultset.beforeFirst();
            while (resultset.next()) {
                contador++;
                produtoList[contador - 1] = gerarProdutoFromResultset(resultset);
            }
            return produtoList;
        } catch (SQLException e) {
            e.printStackTrace();
            Produto[] produtoList = new Produto[0];
            return produtoList;
        }
    }

    /**
     * Medoto que realiza uma consulta de servicos no banco de dados a partir
     * de um servico com algumas informações.
     *
     * @param Servico
     * @return Servico[]
     **/
    public static Servico[] consultar(Servico servico) {
        int contador = 0;
        int nRegistro = 0;
        try {
            if (servico.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                        + "WHERE codigo LIKE ? AND ativo=1");
                preparedStatement.setString(1, "%" + servico.getCodigo() + "%");
                resultset = preparedStatement.executeQuery();
            } else if (!servico.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                        + "WHERE nome LIKE ? AND ativo=1");
                preparedStatement.setString(1, "%" + servico.getNome() + "%");
                resultset = preparedStatement.executeQuery();
            }
            while (resultset.next()) {
                nRegistro++;
            }

            Servico[] servicoList = new Servico[nRegistro];
            resultset.beforeFirst();

            while (resultset.next()) {
                contador++;

                servicoList[contador - 1] = gerarServicoFromResultset(resultset);
            }
            return servicoList;

        } catch (SQLException e) {
            e.printStackTrace();
            Servico[] servicoList = new Servico[0];
            return servicoList;
        }
    }

    public static Animal[] consultar(Animal a) {
        int contador = 0;
        int nRegistro = 0;
        try {
            if (!a.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM animal"
                        + " WHERE nome LIKE %" + a.getNome() + "%");
                resultset = preparedStatement.executeQuery();
            }

            while (resultset.next()) {
                nRegistro++;
            }

            resultset.beforeFirst();

            Animal[] animalList = new Animal[nRegistro];

            while (resultset.next()) {
                contador++;
                animalList[contador - 1] = gerarAnimalFromResultset(resultset);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Animal[0];
    }

    /**
     * Metodo alterar dados de clientes no banco de dados
     *
     * @param Cliente
     * @return boolean
     **/
    public static boolean alterar(Cliente cliente) {
        try {
            // Preparação de commando SQL para atualização de registros
            preparedStatement = connection.prepareStatement("UPDATE cliente SET"
                    + "nome=?,sexo=?,cpf=?,rg=?,rua=?,ncasa=?,bairro=?,cidade=?"
                    + ",complemento=?,uf=?,email=?,telefone=?,celular=?,cep=?,info=?) "
                    + "WHERE codigo=?");
            // introdução das variaveis no comando
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, String.valueOf(cliente.getSexo()));
            preparedStatement.setString(3, cliente.getCpf().getCpf());
            preparedStatement.setLong(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getEndereco().getRua());
            preparedStatement.setInt(6, cliente.getEndereco().getNum());
            preparedStatement.setString(7, cliente.getEndereco().getBairro());
            preparedStatement.setString(8, cliente.getEndereco().getCidade());
            preparedStatement.setString(9, cliente.getEndereco().getComplemento());
            preparedStatement.setString(10, cliente.getEndereco().getUf());
            preparedStatement.setString(11, cliente.getEmail());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getCelular());
            preparedStatement.setString(14, cliente.getEndereco().getCep());
            preparedStatement.setString(15, cliente.getInformacoes());
            // Codigo do cliente que ira ser alterado
            preparedStatement.setInt(16, cliente.getCodigo());
            //Executa alteraçõe no banco de dados
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Metodo para altera os dados de produtos no banco de dados.
     *
     * @param Produto
     * @return boolean
     **/
    public static boolean alterar(Produto produto) {
        try {
            // Configuração de pre-comando
            preparedStatement = connection.prepareStatement("UPDATE produtos SET "
                    + "nome=?,qt=?,preco_custo=?,preco_venda=?,info=? "
                    + "WHERE codigo=?");
            //Entrada de valores
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setInt(2, produto.getQtdeEstoque());
            preparedStatement.setDouble(3, produto.getPrecoCusto());
            preparedStatement.setDouble(4, produto.getPrecoVenda());
            preparedStatement.setString(5, produto.getInformacoes());
            // Codico do produto que ira ser alterado
            preparedStatement.setLong(6, produto.getCodigo());
            // Executando comando SQL
            preparedStatement.executeUpdate();
            // Resultado
            System.out.println("Alteração do produto realizada com exito.");
            return true;

            // Tratamento de erro
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao altera produto.");
            return false;
        }

    }

    /**
     * Metodo para altera dados de um serviço no banco de dados.
     *
     * @param Servico
     **/
    public static boolean alterar(Servico servico) {
        try {
            // Pre-comando SQL
            preparedStatement = connection.prepareStatement("UPDATE INTO produtos "
                    + "(nome,duracao,preco,info) VALUES (?,?,?,?) "
                    + "WHERE codigo=?");
            //Configuração das varieaveis
            preparedStatement.setString(1, servico.getNome());
            preparedStatement.setInt(2, servico.getDuracao());
            preparedStatement.setDouble(3, servico.getPrecoVenda());
            preparedStatement.setString(4, servico.getInfo());
            // Codido do servico que ira ser alterado
            preparedStatement.setLong(5, servico.getCodigo());
            //Execução de comando SQL
            preparedStatement.executeUpdate();
            // Resultado
            System.out.println("Servico alterado com exito.");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao altera o serviço.");
            return false;
        }
    }

    public static boolean alterar(Animal animal) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE animal SET "
                    + "nome=?,sexo=?,nascimento=?,especie=?,raca=?,info=?,dono=? "
                    + "WHERE codigo=?");

            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, String.valueOf(animal.getSexo()));
            preparedStatement.setString(3, String.valueOf(animal.getDataNasc().toString()));
            preparedStatement.setString(4, animal.getEspecie());
            preparedStatement.setString(5, animal.getRaca());
            preparedStatement.setString(6, animal.getInfo());
            preparedStatement.setInt(7, animal.getDono());

            preparedStatement.setInt(8, animal.getCodigo());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }

    public static boolean remover(Cliente cliente) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE cliente SET "
                    + "ativo=0 WHERE codigo=?");
            preparedStatement.setInt(1, cliente.getCodigo());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean remover(Produto produto) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE produtos SET "
                    + "ativo=0 WHERE codigo=?");
            preparedStatement.setLong(1, produto.getCodigo());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean remover(Servico servico) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE servicos SET "
                    + "ativo=0 WHERE codigo=?");
            preparedStatement.setLong(1, servico.getCodigo());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean remover(Animal animal) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE animal SET "
                    + "ativo=0 WHRE codigo=?");
            preparedStatement.setInt(1, animal.getCodigo());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    public static boolean drop(Venda venda){
        try{
            preparedStatement = connection.prepareStatement("DELETE FROM saidaservicos "
                    + "WHERE venda=?");
            preparedStatement.setInt(1, venda.getCodigo());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("DELETE FROM saidaprodutos "
                    + "WHERE venda=?");
            preparedStatement.setInt(1, venda.getCodigo());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("DELETE FROM vendas "
                    + "WHERE codigo=?");
            preparedStatement.setInt(1, venda.getCodigo());
            preparedStatement.executeUpdate();

            return true;

        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static Venda[] consultar(Venda v) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
