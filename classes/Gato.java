package classes;

public class Gato extends Animal{
    public String raca;
    public Gato(int id, String nome, String dono, String raca){
        super(id, nome, dono);
        this.raca = raca;
    }
    
    @Override
    public void mostrarDados(){
        
        System.out.println("Dono: " + this.dono);
        System.out.println("Nome do gato: " + this.nome);
        System.out.println("ID: " + this.id);
        System.out.println("Raça: " + this.raca);
    }
}