public class Gato extends Animal {
    public Gato(int id, String nome) {
        super(id, nome, "Gato");
    }

    public void miar() {
        System.out.println(getNome() + " está miando!");
    }

    @Override
    public void mostrar() {
        System.out.println("ID: " + getId() + " | Nome: " + getNome() + " | Espécie: " + getEspecie() + " (Gato)");
    }
}
