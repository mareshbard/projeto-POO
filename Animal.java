public class Animal{
    private int id;
    private String nome;
    private String especie;

    public Animal(int id, String nome, String especie) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEspecie(String especie) { this.especie = especie; }

    public void mostrar() {
        System.out.println("\n--- PET ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
    }
}