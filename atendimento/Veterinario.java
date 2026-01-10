package atendimento;

public class Veterinario extends Funcionario{
    public int qtd_consultas = 1;
    public int id;
    public Consulta[] consultas = new Consulta[10];
    public Veterinario(String nome, String funcao){
        super(nome, funcao);

    }
    public Veterinario(String nome, String funcao, Consulta consultaInicial){
        super(nome, funcao);
        this.consultas[0] = consultaInicial;
    }
        public void mostrarAgenda(){
            System.out.println("AGENDA: ");
            for(int i=0; i<10; i++){
                if(consultas[i] == null) break;
                System.out.println("Consulta: " + this.consultas[i].horario +" | "+ this.consultas[i].descricao +" com "+ this.nome);
            }
            
        }
    
}