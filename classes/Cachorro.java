public class Cachorro extends Animal {
    public Cachorro(int id, String nome) {
        super(id, nome, "Cachorro");
    }

    public void latir() {
        System.out.println(getNome() + " está latindo!");
    }

    @Override
    public void mostrar() {
        System.out.println("ID: " + getId() + " | Nome: " + getNome() + " | Espécie: " + getEspecie() + " (Cachorro)");
    }
}
