import java.util.ArrayList;
import java.util.Scanner;

public class MenuPet {

    private Scanner in = new Scanner(System.in);
    private ArrayList<Animal> animais = new ArrayList<>();
    private int idAuto = 1;

    public void iniciar() {
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
        System.out.print("Nome do animal: ");
        String nome = in.nextLine();

        System.out.println("\n--- ESPÉCIE ---");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.println("3 - Coelho");
        System.out.println("4 - Outro");
        System.out.print("Opção: ");

        int op = in.nextInt();
        in.nextLine();

        switch(op) {
            case 1: return new Cachorro(idAuto++, nome);
            case 2: return new Gato(idAuto++, nome);
            case 3: return new Coelho(idAuto++, nome);
            case 4:
                System.out.print("Digite a espécie: ");
                String especie = in.nextLine();
                return new Animal(idAuto++, nome, especie);
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
