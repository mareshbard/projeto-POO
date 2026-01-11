package database;
import java.io.File;
import java.io.IOException;

public class CriarArquivo{
    public static void criarArq(){
    File arquivo = new File("funcionarios.dat");
    try{
        if(arquivo.createNewFile()){
            System.out.println("Arquivo criado");
        } else{
            System.out.println("Arquivo já existe");
        }
    } catch (IOException e){
        System.out.println("Um erro ocorreu: ");
        e.printStackTrace();
    }
}
    public static void criarAnimalData(){
    File arquivo = new File("animais.dat");
    try{
        if(arquivo.createNewFile()){
            System.out.println("Arquivo criado");
        } else{
            System.out.println("Arquivo já existe");
        }
    } catch (IOException e){
        System.out.println("Um erro ocorreu: ");
        e.printStackTrace();
    }
}
}