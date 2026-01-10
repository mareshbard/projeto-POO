package atendimento;

import java.util.*;
import java.io.*;

public class Consulta implements Serializable{
    String horario;
    String descricao;
    int idAnimal;
    public Consulta(String horario, String descricao, int id){
        this.horario = horario;
        this.descricao = descricao;
        this.idAnimal = id;
    }
    public static Consulta[ ] append(Consulta[] oldArr, Consulta novaConsulta){
    Consulta[] newArr = Arrays.copyOf(oldArr, oldArr.length+1);
    newArr[newArr.length - 1] = novaConsulta;
    return newArr;
}
}