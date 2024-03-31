package Codigo_Fonte;

// Classe que representa uma data com hora para agendamento de eventos
public class Data {

    // Atributos da classe Data
    private int dia;    // Armazena o dia
    private int mes;    // Armazena o mês
    private int ano;    // Armazena o ano

    private int hora;   // Armazena a hora
    private int minuto; // Armazena os minutos

    // Construtor da classe Data
    public Data(int dia, int mes, int ano, int hora, int minuto){
        // Verifica se a data é válida
        if (validaData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else throw new IllegalArgumentException("A Data inserida está inválida");

        // Verifica se a hora é válida
        if (validaHora(hora, minuto)) {
            this.hora = hora;
            this.minuto = minuto;
        } else throw new IllegalArgumentException("A Hora inserida está inválida");
    }

    // Método toString para representar a data formatada como string
    public String toString() {
        // Formata a data e a hora
        String dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano);
        String horaFormatada = String.format("%02d:%02d", hora, minuto);
        return String.format("Data: %s | Hora: %s", dataFormatada, horaFormatada);
    }

    // Método privado para validar a data
    private boolean validaData(int dia, int mes, int ano){
        // Verifica se o mês está dentro do intervalo
        if(mes < 1 || mes > 12) return false; 
        // Verifica se o dia está dentro do intervalo de dias do mês inserido
        else if(dia < 1 || dia > diasNoMes(dia, mes)) return false; 
        // Verifica se o ano é positivo
        else if(ano <= 0) return false; 
        return true;
    }

    // Método privado para calcular o número de dias em um determinado mês
    private int diasNoMes(int dia, int mes){
        // Verifica se o mês é fevereiro
        if(mes == 2){
            // Verifica se o ano é bissexto para determinar o número de dias em fevereiro
            if(validaBissexto(mes)) return 29; 
            else return 28;
        } 
        // Verifica se o mês tem 30 dias
        else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) return 30; 
        // Se não for fevereiro nem um mês com 30 dias, assume-se que tem 31 dias
        else return 31; 
    }

    // Método privado para validar a hora
    private boolean validaHora(int hora, int minuto){
        // Verifica se a hora e os minutos estão dentro do intervalo válido
        return ((hora >= 0 && hora <= 23) && (minuto >= 0 && minuto <= 59)); 
    }

    // Método privado para validar se o ano é bissexto
    private boolean validaBissexto(int ano) {
        // Verifica se o ano é bissexto de acordo com a regra do calendário gregoriano
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0); 
    }

    // Getters e setters para os atributos da classe
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        // Verifica se o dia inserido é válido
        if(validaData(dia, this.mes, this.ano)){
            this.dia = dia;
        } else throw new IllegalArgumentException("O dia inserido está inválido");
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        // Verifica se o ano inserido é válido
        if(validaData(this.dia, this.mes, ano)){
            this.ano = ano;
        } else throw new IllegalArgumentException("O ano inserido está inválido");
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        // Verifica se o mês inserido é válido
        if (validaData(this.dia, mes, this.ano)) {
            this.mes = mes;
        } else throw new IllegalArgumentException("O mês inserido está inválido");
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        // Verifica se a hora inserida é válida
        if (validaHora(hora, this.minuto)) {
            this.hora = hora;
        } else throw new IllegalArgumentException("A hora inserida está inválida");
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        // Verifica se o minuto inserido é válido
        if (validaHora(this.hora, minuto)) {
            this.minuto = minuto;
        } else throw new IllegalArgumentException("O minuto inserido está inválido");
    }
}
