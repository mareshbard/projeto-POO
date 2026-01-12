import java.util.ArrayList;
import java.util.Scanner;
import classes.*;
import atendimento.*;
import database.GerenciarArquivos;

public class MenuPet {

    Veterinario[] listaVeterinarios = GerenciarArquivos.carregarVeterinarios();
    Animal[] lista = GerenciarArquivos.carregarAnimais();
    
    public Scanner in = new Scanner(System.in);
    private int idAuto = lista.length;

    public void iniciar() {
        if(listaVeterinarios == null || listaVeterinarios.length == 0){
            Consulta c_inicial = new Consulta("10h", "Vacinação Antirrábica", 0);
            Veterinario v_inicial = new Veterinario("Dra. Amanda", "Clínica Geral", c_inicial);
            listaVeterinarios = new Veterinario[]{v_inicial};
            GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
        }

        int perfil;
        do {
            System.out.println("\n=== PETCARE 2026 - ACESSO ===");
            System.out.println("1 - Sou Balconista");
            System.out.println("2 - Sou Veterinário");
            System.out.println("0 - Sair");
            System.out.print("Escolha seu perfil: ");
            perfil = in.nextInt();
            in.nextLine();

            switch(perfil) {
                case 1: menuBalconista(); break;
                case 2: menuVeterinario(); break;
                case 0: 
                    System.out.println("Salvando dados e encerrando...");
                    GerenciarArquivos.salvarDados(lista);
                    GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
                    break;
                default: System.out.println("Opção inválida!");
            }
        } while(perfil != 0);
    }

    // perfil do balconista
    private void menuBalconista() {
        int opcao;
        do {
            System.out.println("\n--- MENU BALCONISTA (LOGÍSTICA) ---");
            System.out.println("1 - Criar cadastro de Pet");
            System.out.println("2 - Cadastrar Funcionário (Vet)");
            System.out.println("3 - Agendar Consulta");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = in.nextInt();
            in.nextLine();

            switch(opcao) {
                case 1:
                    Animal novo = criarAnimal();
                    if(novo != null) {
                        lista = GerenciarArquivos.append(lista, novo);
                        System.out.println("Pet cadastrado com sucesso!");
                        GerenciarArquivos.salvarDados(lista);
                    }
                    break;
                case 2: menuCadastroFuncionario(); break;
                case 3: agendarConsulta(); break;
            }
        } while(opcao != 0);
    }

    //perfil do vet
    private void menuVeterinario() {
        if (listaVeterinarios.length == 0) {
            System.out.println("Nenhum veterinário cadastrado!");
            return;
        }

        System.out.println("\n--- SELECIONE SEU USUÁRIO ---");
        for (int i = 0; i < listaVeterinarios.length; i++) {
            System.out.println(i + " - " + listaVeterinarios[i].getNome());
        }
        System.out.print("Escolha: ");
        int index = in.nextInt();
        in.nextLine();

        if (index < 0 || index >= listaVeterinarios.length) {
            System.out.println("Veterinário inválido.");
            return;
        }

        Veterinario vetAtual = listaVeterinarios[index];
        int op;
        do {
            System.out.println("\n--- BEM-VINDO(A) DR(A). " + vetAtual.getNome().toUpperCase() + " ---");
            System.out.println("1 - Ver Agenda (Consultas)");
            System.out.println("2 - Iniciar Atendimento (Próximo da lista)");
            System.out.println("0 - Sair do Perfil");
            System.out.print("Opção: ");
            op = in.nextInt();
            in.nextLine();

            if (op == 1) {
                vetAtual.mostrarAgenda();
            } else if (op == 2) {
                atenderProximo(vetAtual);
            }
        } while (op != 0);
    }

    private void atenderProximo(Veterinario vet) {
        if (vet.consultas == null || vet.consultas.length == 0) {
            System.out.println("Não há consultas agendadas.");
            return;
        }
        
        Consulta atual = vet.consultas[0];
        
        System.out.println("Atendendo consulta de ID Pet: " + atual.getIdAnimal() + "..."); 
        System.out.println("Descrição: " + atual.getDescricao());
        
        Consulta[] novaAgenda = new Consulta[vet.consultas.length - 1];
        for (int i = 1; i < vet.consultas.length; i++) {
            novaAgenda[i - 1] = vet.consultas[i];
        }
        vet.consultas = novaAgenda;

        System.out.println("Atendimento finalizado com sucesso!");
        GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
    }

    
    private Animal criarAnimal() {
        System.out.println("\n--- ESPÉCIE ---");
        System.out.println("1-Cachorro \n 2-Gato \n 3-Coelho \n 4-Outro");
        int op = in.nextInt(); in.nextLine();
        System.out.print("Nome: "); String nome = in.nextLine();
        System.out.print("Dono: "); String dono = in.nextLine();
        System.out.print("Raça/Cor: "); String raca = in.nextLine();

        switch(op) {
            case 1: return new Cachorro(idAuto++, nome, dono, raca);
            case 2: return new Gato(idAuto++, nome, dono, raca);
            case 3: return new Coelho(idAuto++, nome, dono, raca);
            default: return new Animal(idAuto++, nome, dono, "Outro");
        }
    }

    private void menuCadastroFuncionario() {
        System.out.print("Nome do Veterinário: ");
        String nome = in.nextLine();
        System.out.print("Especialidade: ");
        String espec = in.nextLine();
        Veterinario novoVet = new Veterinario(nome, espec, null);
        listaVeterinarios = GerenciarArquivos.appendFunc(listaVeterinarios, novoVet);
        GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
        System.out.println("Veterinário cadastrado!");
    }

    private void agendarConsulta() {
        System.out.print("ID do Pet: ");
        int idPet = in.nextInt(); in.nextLine();
        
        // Busca o pet na lista carregada
        Animal petEncontrado = null;
        for(Animal a : lista) {
            if(a != null && a.getId() == idPet) { petEncontrado = a; break; }
        }

        if(petEncontrado == null) {
            System.out.println("Pet não encontrado!");
            return;
        }

        System.out.print("Data/Hora: "); String data = in.nextLine();
        System.out.print("Descrição: "); String desc = in.nextLine();
        Consulta nova = new Consulta(data, desc, petEncontrado.getId());

        System.out.println("Selecione o Veterinário para a consulta:");
        for (int i = 0; i < listaVeterinarios.length; i++) {
            System.out.println(i + " - " + listaVeterinarios[i].getNome());
        }
        int vIndex = in.nextInt(); in.nextLine();

        listaVeterinarios[vIndex].consultas = Consulta.appendConsultas(listaVeterinarios[vIndex].consultas, nova);
        System.out.println("Agendado com sucesso!");
        GerenciarArquivos.salvarVeterinarios(listaVeterinarios);
    }
}