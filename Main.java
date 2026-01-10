import classes.*;
import atendimento.*;
import database.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) {

	//criando dados iniciais
		Gato g1 = new Gato(1, "Dan");
		Consulta c2 = new Consulta("10h", "Vacinação Antirábica", 2);
		Veterinario v2 = new Veterinario("Amanda A", "Vacinação", c2);
		int qtdAnimais;
		int qtdFuncionarios;

		//criando listas para salvar os objetos
		Funcionario[] listaFuncionarios = {v2};
		Animal[] lista = {new Gato(1, "Dono")};

		//verificando se já existe os arquivos
		
		File arquivo = new File("funcionarios.dat");
    try{
        if(arquivo.createNewFile()){
            System.out.println("Arquivo criado");
			GerenciarArquivos.salvarFuncionarios(listaFuncionarios);
			qtdFuncionarios = 0;
        } else{
            System.out.println("Arquivo já existe");
			listaFuncionarios = GerenciarArquivos.carregarFuncionarios();
			qtdFuncionarios = listaFuncionarios.length;
        }
    } catch (IOException e){
        System.out.println("Um erro ocorreu: ");
        e.printStackTrace();
    }

	arquivo = new File("animais.dat");
    try{
        if(arquivo.createNewFile()){
            System.out.println("Arquivo criado");
			GerenciarArquivos.salvarDados(lista);
			qtdAnimais = 1;
        } else{
            System.out.println("Arquivo já existe");
			lista = GerenciarArquivos.carregarAnimais();
			qtdAnimais = lista.length;
        }
    } catch (IOException e){
        System.out.println("Um erro ocorreu: ");
        e.printStackTrace();
    }




		
		//funções que devem ser usadas nas funcoes de criar animais:
		lista = GerenciarArquivos.append(lista, new Gato(4, "Dell"));
		lista = GerenciarArquivos.append(lista, new Gato(5, "Steph"));
		System.out.println("Gato: "+ lista[0].id);
		GerenciarArquivos.salvarDados(lista);
		//para criar vet tem que ter uma CONSULTA
		Consulta c1 = new Consulta("10h", "Vacinação Antirábica", 1);
		Veterinario v1 = new Veterinario("Amanda A", "Vacinação", c1);
		v1.mostrarAgenda();
		GerenciarArquivos.salvarFuncionarios(listaFuncionarios);
	}
}
