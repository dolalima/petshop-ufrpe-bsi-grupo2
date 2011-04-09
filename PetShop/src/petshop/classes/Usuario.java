package petshop.classes;

/**
 * @author arthur
 *
 */
public class Usuario {
	
	private String login;
	private String senha;
	
	/**
	 * @param login
	 * @param senha
	 */
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}


	/**
	 * @return
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * @return
	 */
	public boolean logar(){
		
		return true;
	}
	
}
