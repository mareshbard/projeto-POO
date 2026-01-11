public class Coelho extends Animal {
    public Coelho(int id, String nome) {
        super(id, nome, "Coelho");
    }

    public void pular() {
        System.out.println(getNome() + " está pulando!");
    }

    @Override
    public void mostrar() {
        System.out.println("ID: " + getId() + " | Nome: " + getNome() + " | Espécie: " + getEspecie() + " (Coelho)");
    }
}

