package Codigo_Fonte;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sistema
 */
public class Sistema {
    private List<Usuario> usuarios;
    private List<Evento> eventos;
    private Scanner sc;
    public Sistema() {
        usuarios = new ArrayList<>();
        eventos = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public void cadastrarUsuario(){
        System.out.println("\nCadastro de Usuario:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.add(novoUsuario);
        System.out.println("Usuario cadastrado com sucesso!\n");
    }
    public void cadastrarEvento(){
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
    
        Evento evento = new Evento(nome, local, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim, horaInicio, minutoInicio, horaFim, minutoFim);
        eventos.add(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }
    public void mostrarUsuarios(){
        System.out.println("\nLista de Usuarios:");
        if (usuarios.isEmpty()){

            System.out.println("Nenhum usuario cadastrado!");

        }
        else{
            for (Usuario user : usuarios) {
                System.out.println(user.toString());
            }
        }
    }
    public void mostrarEventos(){
        System.out.println("\nLista de Eventos:");
        if (eventos.isEmpty()){

            System.out.println("Nenhum evento cadastrado!");

        }
        else{
            for (Evento even : eventos) {
                System.out.println(even.toString());
            }
        }
    }
    public void editarEventoSistema(){ // função difícil
        
    }
    public void mostrarEventosDoUsuario(){
        
    }
}
