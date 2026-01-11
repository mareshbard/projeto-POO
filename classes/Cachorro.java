package classes;

public class Cachorro extends Animal {
    public String raca;

    public Cachorro(int id, String nome, String dono, String raca) {
        super(id, nome, dono);
        this.raca = raca;
        this.especie = "Cachorro - " + raca;
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

