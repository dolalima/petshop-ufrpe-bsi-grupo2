package petshop.classes;

import java.util.ArrayList;

/**
 * @author arthur
 *
 */
public class CarrinhoServicos {

    private ArrayList<Servico> servicos;
    private ArrayList<Animal> animais;

    /**
     * @param animais
     */
    public CarrinhoServicos() {
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
    public ArrayList<Animal> getAnimal() {
        return animais;
    }

    /**
     * @param animais
     */
    public void setAnimal(ArrayList<Animal> animal) {
        this.animais = animal;
    }

    public void add(Servico s, Animal a){
        servicos.add(s);
        animais.add(a);
    }
    
    public void remove(Servico s, Animal a){
        for(int i = 0; i < servicos.size(); i++){
            if(servicos.get(i).getCodigo() == s.getCodigo()){
                if(animais.get(i).getCodigo() == a.getCodigo()){
                    servicos.remove(i);
                    animais.remove(i);
                }
            }
        }
        
    }
}
