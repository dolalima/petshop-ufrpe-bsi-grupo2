package petshop.classes;

import java.util.ArrayList;

/**
 * @author arthur
 *
 */
public class CarrinhoServicos {

    private ArrayList<Servico> servicos;
    private Animal animal;

    /**
     * @param animal
     */
    public CarrinhoServicos(Animal animal) {
        this.animal = animal;
    }

    CarrinhoServicos() {
        this.animal = new Animal();
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
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
