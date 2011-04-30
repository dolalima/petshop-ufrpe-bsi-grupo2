package petshop.classes;

/**
 * @author arthur
 *
 */
public class Cliente{
    private int codigo;
    private String nome;
    private String sexo;
    private Endereco endereco;
    private long rg;
    private CPF cpf;
    private String email;
    private String telefone;
    private String celular;
    private Animal[] animais;
    private String informacoes;

    public Cliente(String nome, String sexo, Endereco endereco, long rg, CPF cpf, String email, String telefone, String celular, Animal[] animais, String informacoes) {
        
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.animais = animais;
        this.informacoes = informacoes;
    }

    public Cliente() {
        this.nome = "";
        this.sexo = " ";
        this.endereco = new Endereco();
        this.rg = 0;
        this.cpf = new CPF("");
        this.email = "";
        this.telefone = "";
        this.celular = "";
        this.animais = new Animal[0];
        this.informacoes = "";
    }

    public Cliente(int cod) {
        this.codigo = cod;
        this.nome = "";
        this.sexo = " ";
        this.endereco = new Endereco();
        this.rg = 0;
        this.cpf = new CPF("");
        this.email = "";
        this.telefone = "";
        this.celular = "";
        this.animais = new Animal[0];
        this.informacoes = "";
    }



    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the rg
     */
    public long getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(int rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public CPF getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the animais
     */
    public Animal[] getAnimais() {
        return animais;
    }

    /**
     * @param animais the animais to set
     */
    public void setAnimais(Animal[] animais) {
        this.animais = animais;
    }

    /**
     * @return the informacoes
     */
    public String getInformacoes() {
        return informacoes;
    }

    /**
     * @param informacoes the informacoes to set
     */
    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
    
}
