public class Gato extends Animal{
    String raca;
    public Gato(int id, String nome){
        super(id, nome);
    }
    
    @Override
    public void mostrarDados(){
        System.out.println(this.id);
        System.out.println(this.nome);
    }
}