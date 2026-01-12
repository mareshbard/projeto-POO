package produtos;
import java.io.Serializable;
public class Produto implements Serializable {
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private int id;


    public Produto(String nome, String descricao, double preco, int quantidade, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setQuantidade(int qtd){
        this.quantidade = qtd;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setID(int id){
        this.id = id;
    }
    public int getID() {
        return id;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void mostrarDetalhes() {
        System.out.println("ID: " + getID());
        System.out.println("Nome: " + getNome());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Preço: " + getPreco());
        System.out.println("Quantidade em Estoque: " + getQuantidade());
    }
}
