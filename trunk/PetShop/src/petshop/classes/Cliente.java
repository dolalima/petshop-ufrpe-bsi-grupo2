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
    private int rg;
    private CPF cpf;
    private int[] telefone;
    private int[] celular;
    private Animal[] animais;
    private String email;
    private String informacoes;
    
    	
	/**
	 * @param codigo
	 * @param nome
	 * @param sexo
	 * @param endereco
	 * @param email
	 * @param informacoes
	 * @param rg
	 * @param cpf
	 * @param telefone
	 * @param celular
	 * @param animais
	 */
	public Cliente(int codigo, String nome, String sexo, Endereco endereco,
			String email, String informacoes, int rg, CPF cpf, int[] telefone,
			int[] celular, Animal[] animais) {
		
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
		this.email = email;
		this.informacoes = informacoes;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.animais = animais;
	}
	
	
	/**
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return
	 */
	public String getInformacoes() {
		return informacoes;
	}
	/**
	 * @param informacoes
	 */
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	/**
	 * @return
	 */
	public int getRg() {
		return rg;
	}
	/**
	 * @param rg
	 */
	public void setRg(int rg) {
		this.rg = rg;
	}
	/**
	 * @return
	 */
	public CPF getCpf() {
		return cpf;
	}
	/**
	 * @param cpf
	 */
	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return
	 */
	public int[] getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone
	 */
	public void setTelefone(int[] telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return
	 */
	public int[] getCelular() {
		return celular;
	}
	/**
	 * @param celular
	 */
	public void setCelular(int[] celular) {
		this.celular = celular;
	}


	/**
	 * @return
	 */
	public Animal[] getAnimais() {
		return animais;
	}

	/**
	 * @param animais
	 */
	public void setAnimais(Animal[] animais) {
		this.animais = animais;
	}

    
    
}
