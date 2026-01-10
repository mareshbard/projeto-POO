package classes;
import java.io.Serializable;

public class Animal implements Serializable{
    private static final long serialVersionUID = 2L;
    public int id;
    public String nome;
    public void mostrarDados(){
        System.out.println("oi");
    }
    public Animal(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
}