package petshop.classes;

/**
 *
 * @author arthur
 */
public class CPF {
	
	private String cpf;

	
        /**
         *
         * @param cpf
         */
        public CPF(String cpf) {
		super();
		this.cpf = cpf;
	}

        /**
         *
         * @param cpf
         */
        public void setCpf(String cpf) {
		this.cpf = cpf;
	}

        /**
         *
         * @return cpf
         */
        public String getCpf() {
		return cpf;
	}
	
        /**
         *
         * @return
         */
        public boolean isValido(){
		
		return true;
	}
	
}
