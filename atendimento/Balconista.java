package atendimento;

public class Balconista extends Funcionario{
    public Balconista(String nome, String funcao){
        super(nome, funcao);
    }
    @Override
        public void apresentacao(){
        System.out.println("Nome do balconista: "+ this.nome + "Função: "+ this.funcao);
    }
}