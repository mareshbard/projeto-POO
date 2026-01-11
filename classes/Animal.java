package classes;
import java.io.Serializable;

public class Animal implements Serializable{
    private static final long serialVersionUID = 2L;
    public int id;
    public String dono;
    public String nome;
    public String especie;
    public void mostrarDados(){
        System.out.println("oi");
    }
    public Animal(int id, String nome, String dono, String especie) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.especie = especie;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDono() { return dono; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDono(String dono) { this.dono = dono; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public void mostrar() {
        System.out.println("\n--- PET ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Dono: " + dono);
    }
    public void emitirSom(){
        System.out.println("ZZZZZ");
    }
}
