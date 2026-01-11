import java.util.ArrayList;
import java.util.Scanner;
import classes.*;
import atendimento.*;
import database.GerenciarArquivos;



public class MenuPet {



    		//criando listas para salvar os objetos
		Veterinario[] listaVeterinarios = GerenciarArquivos.carregarVeterinarios();
		Animal[] lista = GerenciarArquivos.carregarAnimais();
	
    public Scanner in = new Scanner(System.in);
    public ArrayList<Animal> animais = new ArrayList<>();
    private int idAuto = 1;

    public void iniciar() {



        int qtdAnimais;
		int qtdFuncionarios;




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
        lista[0].mostrarDados();



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
			lista[i].mostrarDados();
		}
		GerenciarArquivos.salvarDados(lista);
		//para criar vet tem que ter uma CONSULTA

		Veterinario v1 = new Veterinario("Amanda A", "Vacinação", c1);
		v1.mostrarAgenda();
		GerenciarArquivos.salvarVeterinarios(listaVeterinarios);

	
        int opcao;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Criar cadastro do meu pet");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = in.nextInt();
            in.nextLine();

            if(opcao == 1) {
                Animal novo = criarAnimal();
                if(novo != null) {
                    animais.add(novo);
                    System.out.println("\nCadastro criado com sucesso!");
                    novo.mostrar(); // Mostra no formato "--- PET ---"
                    menuAposCadastro(novo);
                }
            }

        } while(opcao != 0);
    }

    // Método criarAnimal atualizado com subclasses 
    private Animal criarAnimal() {

        System.out.println("\n--- ESPÉCIE ---");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.println("3 - Coelho");
        System.out.println("4 - Outro");
        System.out.print("Opção: ");

        int op = in.nextInt();
        in.nextLine();
                System.out.print("Nome do animal: ");
                String nomeAnimal = in.nextLine();
                System.out.print("Dono: ");
                String donoAnimal = in.nextLine();
                System.out.print("Raça/Cor do animal: ");
                String racaAnimal = in.nextLine();

        switch(op) {
            case 1:
                
                return new Cachorro(idAuto++, nomeAnimal, donoAnimal, racaAnimal);
            case 2: 
                Gato g2 = new Gato(idAuto++, nomeAnimal, donoAnimal, racaAnimal);
                lista = GerenciarArquivos.append(lista, g2);
                return g2;
            case 3: 
                
                return new Coelho(idAuto++, nomeAnimal, donoAnimal, racaAnimal);
            case 4:
                System.out.print("Digite a espécie: ");
                String especieAnimal = in.nextLine();
                
                return new Animal(idAuto++, nomeAnimal, donoAnimal, especieAnimal);
            default:
                System.out.println("Opção inválida!");
                return null;
        }
    }

    private void menuAposCadastro(Animal animal) {
        int op;

        do {
            System.out.println("\n--- CADASTRO ---");
            System.out.println("1 - Editar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Ver por ID");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            op = in.nextInt();
            in.nextLine();

            switch(op) {
                case 1: editarAnimal(animal); break;
                case 2: excluirAnimal(animal); return;
                case 3: verPorId(); break;
            }

        } while(op != 0);
    }

    private void editarAnimal(Animal animal) {

        int op;
        do {
            System.out.println("\nO que deseja editar?");
            System.out.println("1 - Nome");
            System.out.println("2 - Espécie");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Novo nome: ");
                    animal.setNome(in.nextLine());
                    System.out.println("\nAnimal atualizado!");
                    animal.mostrar(); // Mostra cadastro atualizado
                    break;

                case 2:
                    System.out.println("\nEscolha nova espécie:");
                    System.out.println("1 - Cachorro");
                    System.out.println("2 - Gato");
                    System.out.println("3 - Coelho");
                    System.out.println("4 - Outro");
                    System.out.print("Opção: ");

                    int esp = in.nextInt();
                    in.nextLine();

                    switch (esp) {
                        case 1: animal.setEspecie("Cachorro"); break;
                        case 2: animal.setEspecie("Gato"); break;
                        case 3: animal.setEspecie("Coelho"); break;
                        case 4:
                            System.out.print("Digite a espécie: ");
                            animal.setEspecie(in.nextLine());
                            break;
                        default:
                            System.out.println("Opção inválida! Espécie não alterada.");
                    }

                    System.out.println("\nAnimal atualizado!");
                    animal.mostrar(); // Mostra cadastro atualizado
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    private void excluirAnimal(Animal animal) {
        animais.remove(animal);
        System.out.println("Animal removido!");
    }

    private void verPorId() {
        System.out.print("Digite o ID do animal: ");
        int id = in.nextInt();
        in.nextLine();

        Animal encontrado = null;
        for (Animal a : animais) {
            if (a.getId() == id) {
                encontrado = a;
                break;
            }
        }

        if (encontrado != null) {
            encontrado.mostrar(); // Sempre mostra no formato "--- PET ---"
        } else {
            System.out.println("Animal não encontrado!");
        }
    }
}
