package classes;

public class Cachorro extends Animal {
    public String raca;

    public Cachorro(int id, String nome, String dono, String raca){
        super(id, nome, dono, "Cachorro");
        this.raca = raca;
    }
    public void setRaca(String raca) { this.raca = raca; }
    public String getRaca() { return this.raca; }
    @Override
        public void emitirSom() {
        System.out.println(getNome() + " está latindo!");
    }

    @Override
    public void mostrar() {
        System.out.println("ID: " + getId() + " | Nome: " + getNome() + " | Raça: " + getRaca() + " (Cachorro)");
    }
}
    


