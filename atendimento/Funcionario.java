package atendimento;

public class Funcionario{
    public String nome;
    public String funcao;
    public void apresentacao(){
        System.out.println("Nome: "+ this.nome + "Função: "+ this.funcao);
    }
}