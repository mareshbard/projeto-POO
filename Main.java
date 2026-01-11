import classes.*;
import atendimento.*;
import database.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Main{
	public static void main(String[] args) {

    MenuPet menu = new MenuPet();
    menu.iniciar();

	//criando dados iniciais
		int qtdAnimais;
		int qtdFuncionarios;


		//criando listas para salvar os objetos
		Veterinario[] listaVeterinarios = GerenciarArquivos.carregarVeterinarios();
		Animal[] lista = GerenciarArquivos.carregarAnimais();

		//verificando se já existe os arquivos
	
        if(listaVeterinarios.length == 0){
			Consulta c2 = new Consulta("10h", "Vacinação Antirrábica", 2);
			Veterinario v2 = new Veterinario("Amanda A", "Vacinação", c2);
			listaVeterinarios = GerenciarArquivos.appendFunc(listaVeterinarios, v2);
			qtdFuncionarios = 1;
			GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
        } 
		if(lista.length == 0){
			
			Gato g1 = new Gato(1, "Dan", "Sissi", "Siames");
			g1.mostrarDados();
			lista = GerenciarArquivos.append(lista, g1);
			qtdAnimais = 0;
			GerenciarArquivos.salvarDados(lista);
			
		}
        lista[0].mostrar();



		Consulta c1 = new Consulta("10h", "Vacinação Antirábica", 1);
		Consulta c2 = new Consulta("10h", "Vacinação Antirábica", 2);
		//funções que devem ser usadas nas funcoes de criar animais:
		if(listaVeterinarios.length > 0){
			
			listaVeterinarios[0].consultas = Consulta.appendConsultas(listaVeterinarios[0].consultas, c1);
			listaVeterinarios[0].consultas = Consulta.appendConsultas(listaVeterinarios[0].consultas, c2);
		}
		listaVeterinarios[0].mostrarAgenda();


		
		
		lista = GerenciarArquivos.append(lista, new Gato(4, "Dell", "Lana", "Siames"));
		lista = GerenciarArquivos.append(lista, new Cachorro(5, "Cas", "Andor", "Labrador"));
		for(int i=0; i<lista.length; i++){
			lista[i].mostrar();
		}
		GerenciarArquivos.salvarDados(lista);
		//para criar vet tem que ter uma CONSULTA

		Veterinario v1 = new Veterinario("Amanda A", "Vacinação", c1);
		v1.mostrarAgenda();
		GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
	}
}
