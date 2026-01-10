package database;
import java.io.File;
import java.io.IOException;

public class CriarArquivo{
    File arquivo = new File("pets.txt");
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