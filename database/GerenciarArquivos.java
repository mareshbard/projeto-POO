package database;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class GerenciarArquivos{
@SuppressWarnings("unchecked")
public static <T> T[] append(T[] oldArr, T novo, Class<T> tipo){
    if(oldArr == null){
        T[] newArr = (T[]) Array.newInstance(tipo, 1);
        newArr[0] = novo;
        return newArr;
    }
    T[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novo;
    return newArr;
}


public static <T> void salvar(String arquivo,  T dados){
  try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(dados);
            System.out.println("Dados salvos!");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

@SuppressWarnings("unchecked")
public static <T> T carregar(String arquivo, Class<T> tipo){

    File file = new File(arquivo);
    if(!file.exists()){
        return criarVazio(tipo);
    }

    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
        return (T) ois.readObject();
    } catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
        return null;
    }
}
@SuppressWarnings("unchecked")
private static <T> T criarVazio(Class<T> tipo){
    if(tipo.isArray()){
        return (T) Array.newInstance(tipo.getComponentType(), 0);
    }
    return null;
}

}
