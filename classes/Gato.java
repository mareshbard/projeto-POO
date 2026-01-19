package classes;

public class Gato extends Animal{
    public String raca;
    public Gato(int id, String nome, String dono, String raca){
    super(id, nome, dono, "Gato");
        this.raca = raca;
    }
    public void setRaca(String raca) { this.raca = raca; }
    public String getRaca() { return this.raca; }
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está miando!");
    }

    @Override
    public void mostrar() {
        System.out.println("ID: " + getId() + " | Nome: " + getNome() + " | Raça: " + getRaca() +" | Dono: "+ getDono());

        }
        }
