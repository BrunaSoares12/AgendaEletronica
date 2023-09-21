package agenda_eletronica;
import java.util.Scanner;

/**
 *
 * @author bruni
 */
public class Agenda_Eletronica {
    
    public static void main(String[] args) {
     Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("MENU:");
            System.out.println("1- Adicionar contato");
            System.out.println("2- Remover contato");
            System.out.println("3- Buscar contato por nome");
            System.out.println("4- Buscar contato por email");
            System.out.println("5- Buscar contato por telefone");
            System.out.println("6- Consultar tamanho da Agenda");
            System.out.println("7- Finalizar");

            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do contato: ");
                        String nome = scanner.nextLine();

                        System.out.print("Digite o email do contato: ");
                        String email = scanner.nextLine();

                        System.out.print("Digite o telefone do contato: ");
                        long telefone = scanner.nextLong();
                        scanner.nextLine();

                        Contato novoContato = new Contato(nome, email, telefone);
                        agenda.adicionarContato(novoContato);

                        System.out.println("Contato adicionado");
                        break;
                    case 2:
                        System.out.print("Digite o nome do contato: ");
                        String nomeRemover = scanner.nextLine();
                        boolean removido = agenda.removerContato(nomeRemover);
                        if (removido) {
                            System.out.println("Contato removido ");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Digite o nome do contato a ser buscado: ");
                        String buscarContatoPorNome = scanner.nextLine();
                        Contato contatoNome = agenda.buscarContatoPorNome(buscarContatoPorNome);
                        if (contatoNome != null) {
                            System.out.println("Contato encontrado: " + contatoNome.getNome());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("Digite o email do contato: ");
                        String emailBuscar = scanner.nextLine();
                        Contato contatoEmail = agenda.buscarContatoPorEmail(emailBuscar);
                        if (contatoEmail != null) {
                            System.out.println("Contato encontrado: " + contatoEmail.getEmail());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 5:
                        System.out.print("Digite o telefone: ");
                        long buscarContatoporTelefone = scanner.nextLong();
                        scanner.nextLine();
                        Contato contatoTelefone = agenda.buscarContatoPorTelefone(buscarContatoporTelefone);
                        if (contatoTelefone != null) {
                            System.out.println("Contato encontrado: " + contatoTelefone.getTelefone());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;
                    case 6:
                        int tamanhoAgenda = agenda.getTamanho();
                        System.out.println("Tamanho da Agenda: " + tamanhoAgenda + " contatos.");
                        break;
                    case 7:
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Insira um número válido.");
                opcao = 0;
            }

        } while (opcao != 7);

        scanner.close();
    }
}