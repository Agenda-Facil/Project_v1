package Codigo_Fonte;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Sistema
 */
public class Sistema {

    private Map<String, Usuario> usuarios;
    private Scanner sc;

    public Sistema() {
        usuarios = new HashMap<>();
        sc = new Scanner(System.in);

        Usuario user1 = new Usuario("Mateus Evangelista", "mateus.evagelista@poo.com", "123mateus");
        Usuario user2 = new Usuario("Leandro Elias", "leandro.elias@poo.com", "123elias");
        usuarios.put(user1.getEmail(), user1);
        usuarios.put(user2.getEmail(), user2);

    }

    public void criarConta() {

        System.out.println("\nCrie sua conta no nosso serviço:");
        System.out.print("Nome completo: ");
        String nome = sc.nextLine();
        String email;
        do {
            System.out.print("Endereço de e-mail: ");
            email = sc.nextLine();
            if (usuarios.containsKey(email)) {
                System.out.println("Este email já está em uso. Por favor, escolha outro.");
            }
        } while (usuarios.containsKey(email));
    
        System.out.print("Crie uma senha: ");
        String senha = sc.nextLine();
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.put(email, novoUsuario);
        System.out.println("Sua conta foi criada com sucesso!\n");
    
    }
    

    public void cadastrarEvento(Usuario user){

        System.out.println("\nCadastro de Evento:\n");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Local: ");
        String local = sc.nextLine();
        System.out.print("Dia de Início: ");
        int diaInicio = sc.nextInt();
        System.out.print("Mês de Início: ");
        int mesInicio = sc.nextInt();
        System.out.print("Ano de Início: ");
        int anoInicio = sc.nextInt();
        System.out.print("Hora de Início: ");
        int horaInicio = sc.nextInt();
        System.out.print("Minuto de Início: ");
        int minutoInicio = sc.nextInt();
        System.out.print("Dia de Fim: ");
        int diaFim = sc.nextInt();
        System.out.print("Mês de Fim: ");
        int mesFim = sc.nextInt();
        System.out.print("Ano de Fim: ");
        int anoFim = sc.nextInt();
        System.out.print("Hora de Fim: ");
        int horaFim = sc.nextInt();
        System.out.print("Minuto de Fim: ");
        int minutoFim = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner

        user.criarEvento(nome, local, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim, horaInicio, minutoInicio, horaFim, minutoFim);
    
        System.out.println("Evento cadastrado com sucesso!");

    }

    public void mostrarUsuarios(Usuario user) {
        System.out.println("\nLista de Usuarios:");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for (Map.Entry<String, Usuario> userDaLista : usuarios.entrySet()) {
                Usuario userEncontrado = userDaLista.getValue();
                if (!user.equals(user)) {
                    System.out.println(userEncontrado.toString());
                }
            }
        }
    }
    
    public void mostrarEventos(Usuario user){
        
        Agenda agenda = user.getAgenda();
        System.out.println("\n" + user.getNome() + " aqui estão todos os seus eventos: \n");
        agenda.mostraTodosEventos();

    }

    public void editarEventoSistema(Usuario user) {

        Agenda a = user.getAgenda();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEdição de Evento: \n");
        
        // Mostra todos os eventos disponíveis
        System.out.println("Eventos disponíveis para edição:");
        int count = 1;
        for (Evento evento : a.eventos) {
            System.out.println(count + ". " + evento.getTitulo());
            count++;
        }
        
        // Recebe o número do evento a ser editado
        System.out.println("Digite o número do evento que você quer editar:");
        int numeroEvento = scanner.nextInt();
        
        // Verifica se o número do evento é válido
        if (numeroEvento < 1 || numeroEvento > a.eventos.size()) {
            System.out.println("Número de evento inválido.");
            return;
        }
        
        // Mostra as opções de edição
        System.out.println("O que você deseja editar neste evento?");
        System.out.println("0. Título");
        System.out.println("1. Hora de Início");
        System.out.println("2. Minuto de Início");
        System.out.println("3. Hora de Fim");
        System.out.println("4. Minuto de Fim");
        System.out.println("5. Dia de Início");
        System.out.println("6. Dia de Fim");
        System.out.println("7. Mês de Início");
        System.out.println("8. Mês de Fim");
        System.out.println("9. Ano de Início");
        System.out.println("10. Ano de Fim");
        int opcao = scanner.nextInt();
        
        // Verifica se a opção é válida
        if (opcao < 0 || opcao > 10) {
            System.out.println("Opção inválida.");
            return;
        }
        
        // Recebe o novo valor
        System.out.println("Digite o novo valor:");
        Object novoValor = scanner.next();
        
        // Chama o método de edição de evento
        try {
            a.editarEvento(a.eventos.get(numeroEvento - 1).getTitulo(), opcao, novoValor);
            System.out.println("Evento editado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    
}