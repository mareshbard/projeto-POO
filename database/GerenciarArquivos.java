package database;
import classes.*;
import java.io.*;
import java.util.*;

import atendimento.Funcionario;

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
        return null;
    }
}

public static Animal[ ] append(Animal[] oldArr, Animal novoAnimal){
    Animal[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novoAnimal;
    return newArr;
}
public static Funcionario[ ] appendFunc(Funcionario[] oldArr, Funcionario novoFunc){
    Funcionario[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novoFunc;
    return newArr;
}

public static void salvarFuncionarios(Funcionario[] funcionarios){
  try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("funcionarios.dat"))){
            oos.writeObject(funcionarios);
            System.out.println("Dados salvos!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

public static Funcionario[] carregarFuncionarios(){
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("funcionarios.dat"))){
        return (Funcionario[]) ois.readObject();
    } catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
        return null;
    }
}
}