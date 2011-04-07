package petshop.classes;

public class CarrinhoServicos extends CarrinhoDeCompras {
	
	private Animal animal;

	public CarrinhoServicos(ItemVenda item, Animal animal) {
		super(item);
		this.animal = animal;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
