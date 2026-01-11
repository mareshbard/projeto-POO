package classes;

public class Coelho extends Animal {
    public String raca;

    public Coelho(int id, String nome, String dono, String raca) {
        super(id, nome, dono);
        this.raca = raca;
        this.especie = "Coelho - " + raca;
    }

    @Override
    public void mostrar() {
        System.out.println("--- PET ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Dono: " + dono);
        System.out.println("Espécie: " + especie);
    }
}

