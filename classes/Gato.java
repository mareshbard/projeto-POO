package classes;

public class Gato extends Animal{
    public Gato(int id, String nome){
        super(id, nome);
    }
    
    @Override
    public void mostrarDados(){
        System.out.println(this.id);
        System.out.println(this.nome);
    }
}