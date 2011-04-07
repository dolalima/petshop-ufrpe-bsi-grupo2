package petshop.classes;

public class CPF {
	
	private String cpf;

	
	public CPF(String cpf) {
		super();
		this.cpf = cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
	
	public boolean verificaValidade(){
		
		return true;
	}
	
}
