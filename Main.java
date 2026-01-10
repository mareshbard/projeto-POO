import classes.*;
import atendimento.*;
import database.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Animal[] lista = {new Gato(1, "Dan"), new Gato(2, "Cad")};
		Gato g1 = new Gato(1, "Dan");
		
		System.out.println("Hello World");
		lista = GerenciarArquivos.carregarAnimais();
		lista = GerenciarArquivos.append(lista, new Gato(3, "Leo"));
		lista = GerenciarArquivos.append(lista, new Gato(4, "Dell"));
		lista = GerenciarArquivos.append(lista, new Gato(5, "Steph"));
		System.out.println("Gato: "+ lista[0].id);
		System.out.println("Gato: "+ lista[1].id);
		System.out.println("Gato: "+ lista[2].id);
		System.out.println("Gato: "+ lista[3].id);
		System.out.println("Gato: "+ lista[4].nome);
		GerenciarArquivos.salvarDados(lista);
	}
}
