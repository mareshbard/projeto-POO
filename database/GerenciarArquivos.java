package database;
import classes.*;
import java.io.*;
import java.util.*;

public class GerenciarArquivos{
    public static void salvarDados(Animal[] animais){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.dat"))){
            oos.writeObject(animais);
            System.out.println("Dados salvos!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }


public static Animal[] carregarAnimais(){
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animais.dat"))){
        return (Animal[]) ois.readObject();
    } catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
        return null;
    }
}

public static Animal[ ] append(Animal[] oldArr, Animal novoAnimal){
    Animal[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novoAnimal;
    return newArr;
}
}