package database;
import classes.*;
import java.io.*;
import java.util.*;

import atendimento.Veterinario;
import atendimento.Veterinario;

public class GerenciarArquivos{
    public static void salvarDados(Animal[] animais){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animais.dat"))){
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
        return new Animal[0];
    }
}

public static Animal[ ] append(Animal[] oldArr, Animal novoAnimal){
    Animal[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novoAnimal;
    return newArr;
}
public static Veterinario[ ] appendFunc(Veterinario[] oldArr, Veterinario novoFunc){
    Veterinario[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novoFunc;
    return newArr;
}

public static void salvarVeterinarios(Veterinario[] Veterinarios){
  try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("veterinarios.dat"))){
            oos.writeObject(Veterinarios);
            System.out.println("Dados salvos!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

public static Veterinario[] carregarVeterinarios(){
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("veterinarios.dat"))){
        return (Veterinario[]) ois.readObject();
    } catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
        return new Veterinario[0];
    }
}
}