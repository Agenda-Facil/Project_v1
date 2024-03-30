package Codigo_Fonte;

import java.util.ArrayList;
import java.util.Iterator;

// Classe que representa a agenda de eventos de um usuário
public class Agenda {
    
    Usuario user;   // Usuário associado à agenda
    ArrayList<Evento> eventos = new ArrayList<>();   // Lista de eventos na agenda

    // Construtor da classe Agenda
    public Agenda(Usuario user){
        this.user = user;
    }

    // Método para adicionar um evento à agenda
    public void adicionarEvento(Evento evento){
        this.eventos.add(evento);
    }

    // Método para remover um evento da agenda pelo título
    public void removerEvento(String titulo) {
        boolean removido = false;
        Iterator<Evento> iterator = eventos.iterator();
        while (iterator.hasNext()) {
            Evento evento = iterator.next();
            if (evento.getTitulo().equals(titulo)) {
                iterator.remove();
                removido = true;
            }
        }
        if (!removido) {
            throw new IllegalArgumentException("Evento não encontrado.");
        }
    }

    // Método para mostrar os detalhes de um evento específico pelo título
    public void mostraEvento(String titulo) {
        boolean encontrado = false;
        for (Evento evento : eventos) {
            if (evento.getTitulo().equals(titulo)) {
                System.out.println(evento.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("Evento não encontrado.");
        }
    }

    // Método para editar um evento existente na agenda
    public void editarEvento(String titulo, int aux, Object novoValor) {
        boolean encontrado = false;
        for (Evento evento : eventos) {
            if (evento.getTitulo().equals(titulo)) {
                encontrado = true;
                switch (aux) {
                    // Caso para editar o título do evento
                    case 0:
                        if (novoValor instanceof String) {
                            evento.setTitulo((String) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo título.");
                        }
                        break;
                    // Caso para editar a hora de início do evento
                    case 1:
                        if (novoValor instanceof Integer) {
                            evento.alteraHorarioInicio((int) novoValor, 0); // 0 indica que o novo valor é para a hora de início
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para nova hora de início.");
                        }
                        break;
                    // Caso para editar o minuto de início do evento
                    case 2:
                        if (novoValor instanceof Integer) {
                            evento.alteraHorarioInicio((int) novoValor, 1); // 1 indica que o novo valor é para o minuto de início
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo minuto de início.");
                        }
                        break;
                    // Caso para editar a hora de fim do evento
                    case 3:
                        if (novoValor instanceof Integer) {
                            evento.alteraHorarioFim((int) novoValor, 0); // 0 indica que o novo valor é para a hora de fim
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para nova hora de fim.");
                        }
                        break;
                    // Caso para editar o minuto de fim do evento
                    case 4:
                        if (novoValor instanceof Integer) {
                            evento.alteraHorarioFim((int) novoValor, 1); // 1 indica que o novo valor é para o minuto de fim
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo minuto de fim.");
                        }
                        break;
                    // Caso para editar o dia de início do evento
                    case 5:
                        if (novoValor instanceof Integer) {
                            evento.alteraDiaDataInicio((int) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo dia de início.");
                        }
                        break;
                    // Caso para editar o dia de fim do evento
                    case 6:
                        if (novoValor instanceof Integer) {
                            evento.alteraDiaDataFim((int) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo dia de fim.");
                        }
                        break;
                    // Caso para editar o mês de início do evento
                    case 7:
                        if (novoValor instanceof Integer) {
                            evento.alteraMesDataInicio((int) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo mês de início.");
                        }
                        break;
                    // Caso para editar o mês de fim do evento
                    case 8:
                        if (novoValor instanceof Integer) {
                            evento.alteraMesDataFim((int) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo mês de fim.");
                        }
                        break;
                    // Caso para editar o ano de início do evento
                    case 9:
                        if (novoValor instanceof Integer) {
                            evento.alteraAnoDataInicio((int) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo ano de início.");
                        }
                        break;
                    // Caso para editar o ano de fim do evento
                    case 10:
                        if (novoValor instanceof Integer) {
                            evento.alteraAnoDataFim((int) novoValor);
                        } else {
                            throw new IllegalArgumentException("Tipo inválido para novo ano de fim.");
                        }
                        break;
                    // Lança exceção se o valor de 'aux' for inválido
                    default:
                        throw new IllegalArgumentException("Valor de 'aux' inválido.");
                }
            }
        }
        // Lança exceção se o evento não for encontrado
        if (!encontrado) {
            throw new IllegalArgumentException("Evento não encontrado.");
        }
    }
}
