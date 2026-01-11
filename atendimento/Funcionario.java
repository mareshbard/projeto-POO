package atendimento;
import java.io.Serializable;
public class Funcionario implements Serializable{
    private static final long serialVersionUID = 1L;
    public String nome;
    public String funcao;
    public Funcionario(String nome, String funcao){
        this.nome = nome;
        this.funcao = funcao;
    }
    public void apresentacao(){
        System.out.println("Nome: "+ this.nome + "Função: "+ this.funcao);
    }
}