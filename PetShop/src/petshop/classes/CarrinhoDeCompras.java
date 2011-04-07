package petshop.classes;

public abstract class CarrinhoDeCompras {
	
	private ItemVenda item;

	
	public CarrinhoDeCompras(ItemVenda item) {
		super();
		this.item = item;
	}

	public ItemVenda getItem() {
		return item;
	}

	public void setItem(ItemVenda item) {
		this.item = item;
	}
	
}
