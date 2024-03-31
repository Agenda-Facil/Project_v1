package Codigo_Fonte;

import java.util.ArrayList;

public class Agenda {
    
    Usuario user;
    ArrayList<Evento> eventos = new ArrayList<>();

    public Agenda(Usuario user){
        this.user = user;
    }

    public void adicionarEvento(Evento evento){
        this.eventos.add(evento);
    }

    public void removerEvento(String titulo){
        for (Evento evento : eventos) {
            if(evento.equals(titulo)) eventos.remove(evento);
            else throw new IllegalArgumentException("Não foi possivel remover o Evento.");
        }
    }

    public void mostraEvento(String titulo){
        for (Evento evento : eventos) {
            if (evento.equals(titulo)) {
                System.out.println(evento.toString());
            }
            else throw new IllegalArgumentException("Evento não encontrado. Verifique o Titulo e tente outra vez.");
        }
    }

    //editar evento
    public void editarEventoTitulo(String titulo, String novoTitulo){
        for (Evento evento : eventos) {
            if(evento.equals(titulo)) evento.setTitulo(novoTitulo);
        }
    }
    public void editarEventoHora(String titulo, int hora, int minuto, int aux){
        if (aux == 0) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraHoraInicio(hora, minuto);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento.");
            }
        } else if (aux == 1) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraHoraFim(hora, minuto);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento.");
            }
        } else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
    }
    public void editarEventoDia(String titulo, int dia, int aux){
        if (aux == 0) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraDiaDataInicio(dia);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
            }
        } else if (aux == 1) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraDiaDataFim(dia);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
            }
        } else throw new IllegalArgumentException("Não foi possivel alterar esse Evento.");
    }
    public void editarEventoMes(String titulo, int mes, int aux){
        if (aux == 0) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraMesDataInicio(mes);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
            }
        } else if (aux == 1) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraMesDataFim(mes);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
            }
        } else throw new IllegalArgumentException("Não foi possivel alterar esse Evento.");
    }
    public void editarEventoAno(String titulo, int ano, int aux){
        if (aux == 0) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraAnoDataInicio(ano);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
            }
        } else if (aux == 1) {
            for (Evento evento : eventos) {
                if (evento.equals(titulo)) {
                    evento.alteraAnoDataFim(ano);
                }
                else throw new IllegalArgumentException("Não foi possivel alterar esse Evento."); 
            }
        } else throw new IllegalArgumentException("Não foi possivel alterar esse Evento.");
    }




}