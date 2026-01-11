package classes;
public class Gato extends Animal {
    public String raca;

    public Gato(int id, String nome, String dono, String raca) {
        super(id, nome, dono);
        this.raca = raca;
        this.especie = "Gato - " + raca;
    }

    

    @Override
    public void mostrar() {  // precisa ter o mesmo nome usado no MenuPet
        System.out.println("--- PET ---");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Dono: " + this.dono);
        System.out.println("Espécie: " + this.especie);
 
    }
    }