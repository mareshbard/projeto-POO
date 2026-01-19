package atendimento;
import produtos.*;
public class Estoquista extends Funcionario {
    private static final long serialVersionUID = 1L;
    public Estoquista(String nome, String funcao) {
        super(nome, funcao);
    }
    public Produto adicionarProduto() {
        System.out.println("ID: ");
        int id = Integer.parseInt(System.console().readLine());
        System.out.print("Nome do Produto: ");
        String nome = System.console().readLine();
        System.out.print("Descrição do Produto: ");
        String descricao = System.console().readLine();
        System.out.println("Preço: ");
        double preco = Double.parseDouble(System.console().readLine());
        System.out.println("Quantidade em Estoque: ");
        int quantidade = Integer.parseInt(System.console().readLine());
        Produto novoProduto = new Produto(nome, descricao, preco, quantidade, id);
        System.out.println("Produto adicionado com sucesso!");
        
        return novoProduto;
    }   
        public void removerEstoque(int qtd, Produto p){
        p.setQuantidade(p.getQuantidade() - qtd);
    }
}
