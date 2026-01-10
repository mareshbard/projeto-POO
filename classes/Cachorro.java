package classes;

public class Cachorro extends Animal{
    public String raca;
    public Cachorro(int id, String nome, String dono, String raca){
        super(id, nome, dono);
        this.raca = raca;
    }
    
 @Override
    public void mostrarDados(){
        System.out.println("Dono: " + this.nome);
        System.out.println("Nome do cachorro: " + this.nome);
        System.out.println("ID: " + this.id);
        System.out.println("Raça: " + this.raca);
    }
}