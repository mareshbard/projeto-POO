package atendimento;

import java.util.*;
import java.io.*;

public class Consulta implements Serializable {
    String horario;
    String descricao;
    int idAnimal;

    public Consulta(String horario, String descricao, int id) {
        this.horario = horario;
        this.descricao = descricao;
        this.idAnimal = id;
    }

    public int getIdAnimal() {
        return this.idAnimal;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static Consulta[] appendConsultas(Consulta[] oldArr, Consulta novaConsulta) {
        if (oldArr == null) {
            return new Consulta[]{novaConsulta};
        }
        Consulta[] newArr = Arrays.copyOf(oldArr, oldArr.length + 1);
        newArr[newArr.length - 1] = novaConsulta;
        return newArr;
    }
}