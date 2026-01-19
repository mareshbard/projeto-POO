package classes;

public class Coelho extends Animal {
    public String raca;
    public Coelho(int id, String nome, String raca, String dono) {
        super(id, nome, dono, "Coelho");
        this.raca = raca;
    }

    public void pular() {
        System.out.println(getNome() + " está pulando!");
    }

    @Override
    public void mostrar() {
        System.out.println("ID: " + getId() + " | Nome: " + getNome() + " | Dono: " + getDono());
    }
}

