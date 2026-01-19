package atendimento;

public class Veterinario extends Funcionario {
    public int qtd_consultas = 1;
    public int id;
    public Consulta[] consultas;

    public Veterinario(String nome, String funcao) {
        super(nome, funcao);
    }

    public Veterinario(String nome, String funcao, Consulta consultaInicial) {
        super(nome, funcao);
        this.consultas = new Consulta[]{consultaInicial};
    }

    public String getNome() {
        return this.nome; 
    }

    public void mostrarAgenda() {
        System.out.println("AGENDA: ");
        if (this.consultas == null) return;

        for (int i = 0; i < this.consultas.length; i++) {
            if (this.consultas[i] == null) break;
            // Você também pode usar getNome() aqui para manter o padrão
            System.out.println("Consulta: " + this.consultas[i].horario + " | " + this.consultas[i].descricao + " com " + this.getNome());
        }
    }
}
