package classes;

public class Animal {
    protected int id;
    protected String nome;
    protected String dono;
    protected String especie;

    public Animal(int id, String nome, String dono) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.especie = "Desconhecida";
    }

    public Animal(int id, String nome, String dono, String especie) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.especie = especie;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDono() { return dono; }
    public void setDono(String dono) { this.dono = dono; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    // Método mostrar()
    public void mostrar() {
        System.out.println("--- PET ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Dono: " + dono);
        System.out.println("Espécie: " + especie);
    }

    
}
