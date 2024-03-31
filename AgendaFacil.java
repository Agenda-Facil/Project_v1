package Codigo_Fonte;
import java.util.Scanner;

public class AgendaFacil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema SistemaAgenda = new Sistema(); // Supõe-se a existência desta classe para gerenciar o sistema.
        int option;
        do {
            System.out.println("\nBem-vindo a AgendaFacil");
            System.out.println("1. Adicionar Usuário no Sistema");
            System.out.println("2. Adicionar Evento no Sistema");
            System.out.println("3. Mostrar Todos os Usuários do Sistema");
            System.out.println("4. Mostrar Todos os Eventos do Sistema");
            System.out.println("5. Editar Evento do Sistema (pelo título)");
            System.out.println("6. Mostrar Eventos do Usuário");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Implementação do método de adicionar usuario no sistema
                    SistemaAgenda.cadastrarUsuario();
                    break;
                case 2:
                    // Implementação do método de adicionar um evento no sistema
                    SistemaAgenda.cadastrarEvento();
                    break;
                case 3:
                    // Implementação do método que mostra todos os usuarios do sistema
                    SistemaAgenda.mostrarUsuarios();
                    break;
                case 4:
                    // Implementação do método que mostra todos os eventos do sistema
                    SistemaAgenda.mostrarEventos();
                    break;
                case 5:
                    // Implementação do método de editar Eventos do sistema (é aqui que podemos adicionar convidados ao evento, e notificá-los disso, bem como fazer votação)
                    SistemaAgenda.editarEventoSistema();
                    break;
                case 6:
                    // Implementação do método que mostra todos os eventos do usuário (confirmados ou não confirmados)
                    SistemaAgenda.mostrarEventosDoUsuario();
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (option != 7);

        sc.close();
    }
}
