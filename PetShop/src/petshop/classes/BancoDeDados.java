package petshop.classes;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    /**varivel de comando sql pre configurados**/
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

    /**
     * Metodo que gera um cliente a partir de uma linha da consulta do banco de dados.
     *
     * @param ResultSet
     **/
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
            String cep = (String) resultset.getObject(15);
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
            cliente.setInformacoes((String) resultset.getObject(16));
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();

            Cliente cliente = new Cliente();
            return cliente;
        }
    }

    /**
     * Metodo que gera um produto a partir de uma linha da consulta do banco de dados.
     *
     * @param ResultSet
     **/
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

    /**
     * Metodo que gera um serviço a partir de uma linha da consulta do banco de dados.
     *
     * @param ResultSet
     **/
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

    /**
     * Metodo que gera um animal a partir de uma linha da consulta do banco de dados.
     *
     * @param ResultSet
     **/
    private static Animal gerarAnimalFromResultset(ResultSet resultset) {
        try {
            Animal animal = new Animal();
            animal.setCodigo((Integer) resultset.getObject(1));
            animal.setNome((String) resultset.getObject(2));
            animal.setSexo(((String) resultset.getObject(3)).charAt(0));

            String[] date = String.valueOf(resultset.getObject(4)).split("/");

            GregorianCalendar data = new GregorianCalendar();
            data.set(Integer.valueOf(date[2]), Integer.valueOf(date[1]), Integer.valueOf(date[0]));

            animal.setDataNasc(data);
            animal.setEspecie((String) resultset.getObject(5));
            animal.setRaca((String) resultset.getObject(6));
            animal.setInfo((String) resultset.getObject(7));
            animal.setCodigoDono((Integer) resultset.getObject(8));

            return animal;

        } catch (SQLException e) {
            e.printStackTrace();
            Animal animal = new Animal();
            return animal;

        }
    }

    /**
     * Metodo publico que cadastra um cliente no banco de dados.
     *
     * @param cliente
     **/
    public static boolean cadastrar(Cliente cliente) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
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
     * Metodo publico que cadastra um produto no banco de dados.
     *
     * @param produto
     */
    public static boolean cadastrar(Produto produto) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
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
        PreparedStatement preparedStatement;
        ResultSet resultset;
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

    /**
     * Metodo publico para cadastra um animal no banco de dados.
     *
     * @param Animal
     * @return Boolean
     **/
    public static boolean cadastrar(Animal animal) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO animal "
                    + "(nome,sexo,nascimento,especie,raca,info,dono) "
                    + "VALUES (?,?,?,?,?,?,?)");

            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2, String.valueOf(animal.getSexo()));

            int dia = animal.getDataNasc().get(Calendar.DATE);
            String d;
            if (dia < 10) {
                d = "0" + dia;
            } else {
                d = dia + "";
            }
            int mes = animal.getDataNasc().get(Calendar.MONTH);
            String m;
            if (mes < 10) {
                m = "0" + mes;
            } else {
                m = mes + "";
            }
            int a = animal.getDataNasc().get(Calendar.YEAR);

            preparedStatement.setString(3, d + "/" + m + "/" + a);
            preparedStatement.setString(4, animal.getEspecie());
            preparedStatement.setString(5, animal.getRaca());
            preparedStatement.setString(6, animal.getInfo());
            preparedStatement.setInt(7, animal.getCodigoDono());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo publico que retorna a lista de aniamis do cliente
     *
     * @param Cliente
     * @return Animal[]
     **/
    public static Animal[] getAnimais(Cliente cliente) {
        int contador = 0;
        int nRegistro = 0;
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM animal "
                    + "WHERE dono=? AND ativo=1");
            preparedStatement.setLong(1, cliente.getCodigo());

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

    private static Animal getAnimal(int cod) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM animal"
                    + " WHERE codigo=?");
            preparedStatement.setInt(1, cod);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return gerarAnimalFromResultset(resultset);
            } else {
                Animal animal = new Animal();
                return animal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Animal animal = new Animal();
            return animal;
        }

    }

    /**
     * Metodo para cadastra uma venda no banco de dados
     *
     * @param Venda
     * @return boolean
     **/
    public static boolean cadastrar(Venda venda) {
        int pagamento = 0;
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO vendas "
                    + "(cliente,valor,pagamento,data,parcelado) VALUES (?,?,?,?,?)");
            preparedStatement.setLong(1, venda.getCliente().getCodigo());
            preparedStatement.setDouble(2, venda.total());
            if (venda.getTipoPagamento().equals(TipoPagamento.CARTAO)) {
                pagamento = 1;
            } else if (venda.getTipoPagamento().equals(TipoPagamento.CHEQUE)) {
                pagamento = 2;
            }
            preparedStatement.setInt(3, pagamento);
            int dia = venda.getData().get(Calendar.DATE);
            String d;
            if (dia < 10) {
                d = "0" + dia;
            } else {
                d = dia + "";
            }
            int mes = venda.getData().get(Calendar.MONTH);
            String m;
            if (mes < 10) {
                m = "0" + mes;
            } else {
                m = mes + "";
            }
            int a = venda.getData().get(Calendar.YEAR);

            preparedStatement.setString(4, d + "/" + m + "/" + a);
            preparedStatement.setBoolean(5, venda.isParcelado());
            preparedStatement.executeUpdate();

            venda.setCodigo(getLastVenda());

            if (!registraSaidaProdutos(venda)) {
                drop(venda);
                return false;
            }
            if (!registraSaidaServicos(venda)) {
                drop(venda);
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo privado para registra o produtos da venda no banco de dados.
     *
     * @param Venda
     * @return Boolean
     **/
    private static boolean registraSaidaProdutos(Venda venda) {
        PreparedStatement preparedStatement;
        ArrayList<Produto> produtoList = venda.getCarrinhoProdutos().getProdutos();
        ArrayList<Integer> qtdeList = venda.getCarrinhoProdutos().getQtde();
        for (int i = 0; i < produtoList.size(); i++) {
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO saidaprodutos "
                        + "(venda,produto,qt,valor) VALUES (?,?,?,?)");
                preparedStatement.setLong(1, venda.getCodigo());
                preparedStatement.setLong(2, produtoList.get(i).getCodigo());
                preparedStatement.setInt(3, qtdeList.get(i));
                preparedStatement.setDouble(4, produtoList.get(i).getPrecoVenda());
                preparedStatement.executeUpdate();



            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo privado para registra os serviços dad venda no banco de dados.
     *
     * @param Venda
     * @return Boolean
     */
    private static boolean registraSaidaServicos(Venda venda) {
        PreparedStatement preparedStatement;
        ArrayList<Servico> servicoList = venda.getCarrinhoServicos().getServicos();
        ArrayList<Animal> animalList = venda.getCarrinhoServicos().getAnimal();
        for (int i = 0; i < servicoList.size(); i++) {
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO saidaservicos "
                        + "(venda,servico,animal,valor) VALUES (?,?,?,?)");
                preparedStatement.setLong(1, venda.getCodigo());
                preparedStatement.setLong(2, servicoList.get(i).getCodigo());
                preparedStatement.setInt(3, animalList.get(i).getCodigo());
                preparedStatement.setDouble(4, servicoList.get(i).getPrecoVenda());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo privado que pega o codigo na ultima venda.
     *
     * @return Integer
     **/
    private static int getLastVenda() {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int cod = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT MAX(id_venda) from vendas");
            resultset = preparedStatement.executeQuery();
            resultset.next();
            cod = (Integer) resultset.getObject(1);
            return cod;
        } catch (SQLException e) {
            cod = 0;
            return cod;
        }
    }

    private static CarrinhoProdutos getCarrinhoProdutos(Venda venda) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement(""
                    + "SELECT * FROM saidaprodutos WHERE venda=?");
            preparedStatement.setInt(1, venda.getCodigo());
            resultset = preparedStatement.executeQuery();

            CarrinhoProdutos carrinho = new CarrinhoProdutos();
            while (resultset.next()) {
                Produto produto = getProduto((Integer) resultset.getObject(3));
                produto.setPrecoVenda((Double) resultset.getObject(5));
                carrinho.add(produto, (Integer) resultset.getObject(4));
            }
            return carrinho;

        } catch (SQLException e) {
            e.printStackTrace();
            CarrinhoProdutos carrinho = new CarrinhoProdutos();
            return carrinho;
        }

    }

    private static CarrinhoServicos getCarrinhoServicos(Venda venda) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement(""
                    + "SELECT * FROM saidaservicos WHERE venda=?");
            preparedStatement.setInt(1, venda.getCodigo());
            resultset = preparedStatement.executeQuery();
            CarrinhoServicos carrinho = new CarrinhoServicos();

            while (resultset.next()) {
                Servico servico = getServico((Integer) resultset.getObject(3));
                servico.setPrecoVenda((Double) resultset.getObject(5));
                carrinho.add(servico, getAnimal((Integer) resultset.getObject(4)));
            }
            return carrinho;

        } catch (SQLException e) {
            e.printStackTrace();
            CarrinhoServicos carrinho = new CarrinhoServicos();
            return carrinho;
        }

    }

    /**
     * Medoto publico para consultar os clientes do banco de dados.
     *
     * @param Cliente
     * @return Cliente[]
     **/
    public static Cliente[] consultar(Cliente cliente) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int contador = 0;
        int nRegistros = 0;
        try {
            if (cliente.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                        + "WHERE codigo LIKE ? AND ativo=1");
                preparedStatement.setString(1, "%" + cliente.getCodigo() + "%");
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
                resultset = preparedStatement.executeQuery();

            }

            while (resultset.next()) {
                nRegistros = nRegistros + 1;
            }
            Cliente[] clienteList = new Cliente[nRegistros];

            resultset.beforeFirst();
            while (resultset.next()) {
                //Contador de cliente
                contador++;
                Cliente c = gerarClienteFromResultset(resultset);
                c.setAnimais(getAnimais(c));
                clienteList[contador - 1] = c;

            }
            return clienteList;

        } catch (SQLException e) {
            e.printStackTrace();
            Cliente[] clienteList = new Cliente[0];
            return clienteList;
        }
    }

    /**
     * Metodo para pega o codigo de uma cliente
     *
     * @param Cliente
     * @return Integer
     **/
    public static int getClienteCod(Cliente cliente) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT codigo FROM cliente "
                    + "WHERE cpf=?");
            preparedStatement.setString(1, cliente.getCpf().getCpf());
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                int codigo = (Integer) resultset.getObject(1);
                return codigo;
            } else {
                return 0;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cliente não encontrado.");
            return 0;
        }
    }

    public static Cliente getCliente(int cod) {
        PreparedStatement preparesStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM cliente "
                    + "WHERE codigo=?");
            preparedStatement.setInt(1, cod);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return gerarClienteFromResultset(resultset);
            } else {
                Cliente cliente = new Cliente();
                return cliente;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Cliente cliente = new Cliente();
            return cliente;
        }
    }

    private static Produto getProduto(int cod) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                    + "WHERE codigo= ?");
            preparedStatement.setInt(1, cod);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return gerarProdutoFromResultset(resultset);
            } else {
                Produto produto = new Produto();
                return produto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Produto produto = new Produto();
            return produto;
        }
    }

    private static Servico getServico(int cod) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                    + "WHERE codigo=?");
            preparedStatement.setInt(1, cod);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return gerarServicoFromResultset(resultset);
            } else {
                Servico servico = new Servico();
                return servico;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Servico servico = new Servico();
            return servico;
        }

    }

    /**
     * Verifica se já existe o CPF cadastrado no banco de dados
     *
     * @param Cliente
     * @return Boolean
     **/
    public static boolean checkCPF(Cliente cliente) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
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
     * Metedo para verifica e o codigo do produto já esta cadastrado
     **/
    public static boolean checkCodProduto(int cod) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT codigo FROM produtos "
                    + "WHERE codigo = ?");
            preparedStatement.setInt(1, cod);

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

    public static boolean checkCodServico(int cod) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                    + "WHERE codigo=?");
            preparedStatement.setInt(1, cod);

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
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int contador = 0;
        int nRegistro = 0;
        try {
            if (produto.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                        + "WHERE codigo=? AND ativo=1");
                preparedStatement.setInt(1, produto.getCodigo());
                resultset = preparedStatement.executeQuery();
            } else if (!produto.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM "
                        + "produtos WHERE nome LIKE ? and ativo=1");
                preparedStatement.setString(1, "%" + produto.getNome() + "%");
                resultset = preparedStatement.executeQuery();
            } else {
                preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                        + "WHERE ativo=1");
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

    public static Produto[] consultar(Produto produto, double max) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int contador = 0;
        int nRegistro = 0;
        try {
            if (produto.getPrecoCusto() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                        + "WHERE codigo>=? AND codigo<=? AND ativo=1");
                preparedStatement.setDouble(1, produto.getPrecoCusto());
                preparedStatement.setDouble(2, max);
                resultset = preparedStatement.executeQuery();
            } else if (produto.getPrecoVenda() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                        + "WHERE codigo>=? AND codigo<=? AND ativo=1");
                preparedStatement.setDouble(1, produto.getPrecoVenda());
                preparedStatement.setDouble(2, max);
                resultset = preparedStatement.executeQuery();
            } else{
                preparedStatement = connection.prepareStatement("SELECT * FROM produtos "
                        + "WHERE AND ativo=1");
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
     * Medoto que realiza uma consulta de servicos no banco de dados.
     *
     * @param Servico
     * @return Servico[]
     **/
    public static Servico[] consultar(Servico servico) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int contador = 0;
        int nRegistro = 0;
        try {
            if (servico.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                        + "WHERE codigo= ? AND ativo=1");
                preparedStatement.setInt(1, servico.getCodigo());
                resultset = preparedStatement.executeQuery();
            } else if (!servico.getNome().equals("")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                        + "WHERE nome LIKE ? AND ativo=1");
                preparedStatement.setString(1, "%" + servico.getNome() + "%");
                resultset = preparedStatement.executeQuery();
            } else {
                preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                        + "WHERE ativo=1");
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

    public static Servico[] consulta(Servico servico, double max) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int contador = 0;
        int nRegistro = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM servicos "
                    + "WHERE preco>= ? AND  preco<=? AND ativo=1");
            preparedStatement.setDouble(1, servico.getPrecoVenda());
            preparedStatement.setDouble(2, max);
            resultset = preparedStatement.executeQuery();

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

    /**
     * Medoto que realiza uma consulta de animals no banco de dados.
     *
     * @param Animal
     * @return Animal[]
     **/
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
            preparedStatement = connection.prepareStatement("UPDATE cliente SET "
                    + "nome=?,sexo=?,cpf=?,rg=?,rua=?,ncasa=?,bairro=?,cidade=?"
                    + ",complemento=?,uf=?,email=?,telefone=?,celular=?,cep=?,info=? "
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
            preparedStatement.setLong(16, cliente.getCodigo());
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
     * @param boolean
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

    /**
     * Metodo para altera dados de um animal no banco de dados.
     *
     * @param Animal
     * @param boolean
     **/
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
            preparedStatement.setInt(7, animal.getCodigoDono());

            preparedStatement.setInt(8, animal.getCodigo());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }

    /**
     * Metodo para desativa um cliente do banco de dados.
     *
     * @param Cliente
     * @return boolean
     **/
    public static boolean remover(Cliente cliente) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE cliente SET "
                    + "ativo=0 WHERE codigo=?");
            preparedStatement.setLong(1, cliente.getCodigo());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo para desativa um produto do banco de dados.
     *
     * @param Produto
     * @return booblean
     **/
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

    /**
     * Metodo para desativa um servico do banco de dados
     *
     * @param Servico
     * @return boolean
     **/
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

    /**
     * Metodo para desativa um animal do banco de dados.
     *
     * @param Animal
     * @return booblean
     **/
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

    /**
     * Metodo para remover resgistro de venda do banco de dados caso ocorra uma erro.
     *
     * @param venda
     * @return boolean
     **/
    public static boolean drop(Venda venda) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM saidaservicos "
                    + "WHERE venda=?");
            preparedStatement.setLong(1, venda.getCodigo());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("DELETE FROM saidaprodutos "
                    + "WHERE venda=?");
            preparedStatement.setLong(1, venda.getCodigo());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("DELETE FROM vendas "
                    + "WHERE codigo=?");
            preparedStatement.setLong(1, venda.getCodigo());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Venda[] consultar(Venda venda) {
        PreparedStatement preparedStatement;
        ResultSet resultset;
        int contador = 0;
        int nRegistro = 0;
        try {
            if (venda.getCodigo() != 0) {
                preparedStatement = connection.prepareStatement(""
                        + "SELECT id_venda,codigo,nome,cpf,pagamento,valor "
                        + "FROM vendas INNER JOIN cliente ON vendas.cliente=cliente.codigo "
                        + "INNER JOIN pagamento ON vendas.pagamento=pagamento.id_pagamento "
                        + "WHERE id_venda=?");
                preparedStatement.setInt(1, venda.getCodigo());
                resultset = preparedStatement.executeQuery();
            } else if (!venda.getCliente().getNome().equals("")) {
                preparedStatement = connection.prepareStatement(""
                        + "SELECT id_venda,codigo,nome,cpf,pagamento,valor "
                        + "FROM vendas INNER JOIN cliente ON vendas.cliente=cliente.codigo "
                        + "INNER JOIN pagamento ON vendas.pagamento=pagamento.id_pagamento "
                        + "WHERE nome like ?");
                preparedStatement.setString(1, "%" + venda.getCliente().getNome() + "%");
                resultset = preparedStatement.executeQuery();
            } else if (!venda.getCliente().getCpf().getCpf().equals("")) {
                preparedStatement = connection.prepareStatement(""
                        + "SELECT id_venda,codigo,nome,cpf,pagamento,valor "
                        + "FROM vendas INNER JOIN cliente ON vendas.cliente=cliente.codigo "
                        + "INNER JOIN pagamento ON vendas.pagamento=pagamento.id_pagamento "
                        + "WHERE cpf like ?");
                preparedStatement.setString(1, venda.getCliente().getCpf().getCpf() + "%");
                resultset = preparedStatement.executeQuery();
            } else {
                preparedStatement = connection.prepareStatement(""
                        + "SELECT id_venda,codigo,nome,cpf,pagamento,valor "
                        + "FROM vendas INNER JOIN cliente ON vendas.cliente=cliente.codigo "
                        + "INNER JOIN pagamento ON vendas.pagamento=pagamento.id_pagamento");
                resultset = preparedStatement.executeQuery();
            }

            while (resultset.next()) {
                nRegistro++;
            }
            resultset.beforeFirst();
            Venda[] vendaList = new Venda[nRegistro];

            while (resultset.next()) {
                Venda v = new Venda();
                v.setCodigo((Integer) resultset.getObject(1));
                v.setCliente(getCliente((Integer) resultset.getObject(2)));
                v.setCarrinhoProdutos(getCarrinhoProdutos(v));
                v.setCarrinhoServicos(getCarrinhoServicos(v));
                vendaList[contador] = v;
                contador++;
            }

            return vendaList;

        } catch (SQLException e) {
            e.printStackTrace();
            Venda[] vendaList = new Venda[0];
            return vendaList;
        }
    }
}
