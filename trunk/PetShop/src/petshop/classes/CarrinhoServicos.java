package petshop.classes;

/**
 * @author arthur
 *
 */
public class CarrinhoServicos {
	
	private Animal animal;

	/**
	 * @param animal
	 */
	public CarrinhoServicos(Animal animal) {
		this.animal = animal;
	}

	/**
	 * @return
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
